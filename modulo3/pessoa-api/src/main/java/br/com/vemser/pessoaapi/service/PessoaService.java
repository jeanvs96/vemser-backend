package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public PessoaService(){}

    public Pessoa create(Pessoa pessoa) throws Exception {
        verificarNomeEDataDeNascimento(pessoa);
        return pessoaRepository.create(pessoa);
    }

    public List<Pessoa> list(){
        return pessoaRepository.list();
    }

    public Pessoa update(Integer id, Pessoa pessoaAtualizar) throws  Exception {
        verificarNomeEDataDeNascimento(pessoaAtualizar);
        return pessoaRepository.update(id, pessoaAtualizar);
    }

    public void delete(Integer id) throws Exception {
        pessoaRepository.delete(id);
    }

    public List<Pessoa> listByName(String nome) {
        return pessoaRepository.listByName(nome);
    }

    public boolean verificarNomeEDataDeNascimento(Pessoa pessoa) throws Exception {
        Boolean nomeVazio = StringUtils.isBlank(pessoa.getNome());
        Boolean dataDeNascimento = StringUtils.isEmpty(pessoa.getDataNascimento().toString());
        Boolean cpfVazio = StringUtils.isEmpty(pessoa.getCpf());
        if (pessoa.getCpf().length() != 11 && (nomeVazio && dataDeNascimento && cpfVazio)){
            return false;
        } else {
            throw new Exception("Nome, cpf ou Data de Nascimento incorretos");
        }
    }
}
