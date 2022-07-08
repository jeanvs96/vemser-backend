package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public PessoaService() {
    }

    public PessoaDTO create(PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("Criando pessoa...");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaCreateDTO, Pessoa.class);
        pessoaEntity = pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info(pessoaDTO.getNome() + " adicionado(a) ao banco de dados");
        return pessoaDTO;
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaAtualizarDTO) throws RegraDeNegocioException {
        log.info("Atualizando pessoa...");
        Pessoa pessoaEntity = objectMapper.convertValue(pessoaAtualizarDTO, Pessoa.class);
        pessoaEntity = pessoaRepository.update(listByIdPessoa(id), pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        log.info("Dados de " + pessoaDTO.getNome() + " atualizados no banco de dados");
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        log.warn("Deletando...");
        Pessoa pessoaDeletar = listByIdPessoa(id);
        pessoaRepository.delete(pessoaDeletar);
        log.info(pessoaDeletar.getNome() + "removida do banco de dados");
    }

    public Pessoa listByIdPessoa(Integer idPessoa) throws RegraDeNegocioException {
        return list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<Pessoa> listByName(String nome) {
        return list().stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase())).toList();
    }
}
