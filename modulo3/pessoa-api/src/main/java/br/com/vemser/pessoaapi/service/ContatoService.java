package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaService pessoaService;

    public ContatoService() {
    }

    public Contato create(Contato contato, Integer idPessoa) throws RegraDeNegocioException {
        contato.setIdPessoa(pessoaService.listByIdPessoa(idPessoa).getIdPessoa());
        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer idContato, Contato contatoAtualizar) throws RegraDeNegocioException {
        pessoaService.listByIdPessoa(contatoAtualizar.getIdPessoa());
        return contatoRepository.update(contatoByIdContato(idContato), contatoAtualizar);
    }

    public void delete(Integer idContato) throws RegraDeNegocioException {
        contatoRepository.delete(contatoByIdContato(idContato));
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return list().stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa)).toList();
    }

    public Contato contatoByIdContato(Integer idContato) throws RegraDeNegocioException {

        return list().stream()
                .filter(contato -> contato.getIdContato().equals(idContato))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("O contato informado não existe"));
    }
}
