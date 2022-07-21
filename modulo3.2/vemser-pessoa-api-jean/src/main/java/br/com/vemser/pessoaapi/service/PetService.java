package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PetCreateDTO;
import br.com.vemser.pessoaapi.dto.PetDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    private final PessoaService pessoaService;

    private final PessoaRepository pessoaRepository;

    private final ObjectMapper objectMapper;

    public List<PetDTO> list() {
        return petRepository.findAll()
                .stream()
                .map(this::entityToPetDTO).toList();
    }

    public PetDTO create(PetCreateDTO petCreateDTO) throws RegraDeNegocioException {
        PetEntity petEntity = createDtoToEntity(petCreateDTO);
        PessoaEntity pessoaEntityRecuperada = pessoaService.listByIdPessoa(petEntity.getIdPessoa());

            log.info("Criando pet...");
            petEntity.setPessoaEntity(pessoaEntityRecuperada);
            PetDTO petDTO = entityToPetDTO(petRepository.save(petEntity));
            log.info(petDTO.getNome() + " adicionado(a) ao banco de dados");
        return petDTO;
    }

    public PetDTO update(Integer idPet, PetCreateDTO petAtualizarDTO) throws RegraDeNegocioException {
        PetEntity petRecuperado = petRepository.findById(idPet).orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
        PessoaEntity pessoaEntity = petRecuperado.getPessoaEntity();
        pessoaEntity.setPetEntity(null);

        PessoaEntity pessoaRecuperada = pessoaService.listByIdPessoa(petRecuperado.getIdPessoa());

        log.info("Atualizando pet...");
        petRecuperado.setTipoPet(petAtualizarDTO.getTipoPet());
        petRecuperado.setNome(petAtualizarDTO.getNome());
        petRecuperado.setPessoaEntity(pessoaService.listByIdPessoa(petAtualizarDTO.getIdPessoa()));
        petRecuperado.setIdPessoa(petAtualizarDTO.getIdPessoa());
        pessoaRecuperada.setPetEntity(petRecuperado);
        pessoaRepository.save(pessoaRecuperada);


        if (!pessoaRecuperada.getIdPessoa().equals(pessoaEntity.getIdPessoa())) {
            pessoaService.update(pessoaEntity.getIdPessoa(), objectMapper.convertValue(pessoaEntity, PessoaCreateDTO.class));
        }

        PetDTO petDTO = entityToPetDTO(petRepository.save(petRecuperado));

        log.info("Dados de " + petDTO.getNome() + " atualizados no banco de dados");
        return petDTO;
    }

    public void delete(Integer idPet) throws RegraDeNegocioException {
        PetEntity petDeletar = listByIdPet(idPet);
        log.warn("Deletando...");
        petRepository.delete(petDeletar);
        log.info(petDeletar.getNome() + " removido do banco de dados");
    }

    public PetEntity listByIdPet(Integer idPet) throws RegraDeNegocioException {
        return petRepository.findById(idPet)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }

    public PetDTO entityToPetDTO(PetEntity petEntity) {
        return objectMapper.convertValue(petEntity, PetDTO.class);
    }

    public PetEntity createDtoToEntity(PetCreateDTO petCreateDTO) {
        return objectMapper.convertValue(petCreateDTO, PetEntity.class);
    }
}
