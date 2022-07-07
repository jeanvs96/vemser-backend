package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService() {
    }

    public Pessoa create(Pessoa pessoa) throws RegraDeNegocioException {
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list() {
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws RegraDeNegocioException {
        return pessoaRepository.update(listByIdPessoa(id), pessoaAtualizar);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        pessoaRepository.delete(listByIdPessoa(id));
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
