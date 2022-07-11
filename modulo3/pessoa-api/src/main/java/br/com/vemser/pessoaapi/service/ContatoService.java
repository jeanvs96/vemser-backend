package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    ObjectMapper objectMapper;

    public ContatoService() {
    }

    public List<ContatoDTO> list() {
        List<ContatoDTO> contatosDTO = new ArrayList<>();
        List<Contato> contatosEntity = contatoRepository.list();
        for (Contato contato: contatosEntity) {
            contatosDTO.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        return contatosDTO;
    }

    public ContatoDTO create(ContatoCreateDTO contatoCreateDTO, Integer idPessoa) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.listByIdPessoa(idPessoa);
        log.info("Adicionando contato à pessoa: " + pessoa.getNome());
        contatoCreateDTO.setIdPessoa(idPessoa);
        Contato contatoEntity = objectMapper.convertValue(contatoCreateDTO, Contato.class);
        contatoEntity = contatoRepository.create(contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        log.info("Contato adicionado");
        return contatoDTO;
    }

    public ContatoDTO update(Integer idContato, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        Pessoa pessoa = pessoaService.listByIdPessoa(contatoAtualizarDTO.getIdPessoa());
        log.info("Atualizando contato de " + pessoa.getNome());
        Contato contatoEntity = objectMapper.convertValue(contatoAtualizarDTO, Contato.class);
        contatoEntity = contatoRepository.update(contatoByIdContato(idContato), contatoEntity);
        ContatoDTO contatoDTO = objectMapper.convertValue(contatoEntity, ContatoDTO.class);
        log.info("Contato atualizado");
        return contatoDTO;
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        log.warn("Deletando contato...");
        contatoRepository.delete(contatoByIdContato(idContato));
        log.info("Contato deletado");
    }

    public List<ContatoDTO> listByIdPessoa(Integer idPessoa) {
        List<ContatoDTO> contatosDTO = new ArrayList<>();
        List<Contato> contatosEntity = contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa)).toList();
        for (Contato contato: contatosEntity) {
            contatosDTO.add(objectMapper.convertValue(contato, ContatoDTO.class));
        }
        return contatosDTO;
    }


    public Contato contatoByIdContato(Integer idContato) throws RegraDeNegocioException {
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("O contato informado não existe"));
    }
}
