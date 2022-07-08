package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> list() {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        List<Endereco> enderecos = enderecoRepository.list();
        for (Endereco endereco : enderecos) {
            enderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTO;
    }

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.listByIdPessoa(idPessoa);
        log.info("Adicionando endereco à pessoa: " + pessoa.getNome());
        enderecoCreateDTO.setIdPessoa(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        enderecoEntity = enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        log.info("Endereço adicionado");
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.listByIdPessoa(enderecoAtualizarDTO.getIdPessoa());
        log.info("Atualizando endereco de " + pessoa.getNome());
        Endereco enderecoEntity = objectMapper.convertValue(enderecoAtualizarDTO, Endereco.class);
        enderecoEntity = enderecoRepository.update(recuperarByIdEndereco(idEndereco), enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        log.info("Endereço atualizado");
        return enderecoDTO;
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        log.warn("Removendo endereço...");
        enderecoRepository.delete(recuperarByIdEndereco(idEndereco));
        log.info("Endereço removido");
    }

    public List<EnderecoDTO> listByIdPessoa(Integer idPessoa) {
        List<EnderecoDTO> enderecosDTO = new ArrayList<>();
        List<Endereco> enderecos = enderecoRepository.list().stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).toList();
        for (Endereco endereco : enderecos) {
            enderecosDTO.add(objectMapper.convertValue(endereco, EnderecoDTO.class));
        }
        return enderecosDTO;
    }

    public EnderecoDTO dtoByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoEntity = recuperarByIdEndereco(idEndereco);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        return enderecoDTO;
    }

    public Endereco recuperarByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
         return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}
