package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        endereco.setIdPessoa(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco listByIdEndereco(Integer idEndereco) throws Exception {
        return enderecoRepository.enderecoByIdEndereco(idEndereco);
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa){
        return enderecoRepository.listByIdPessoa(idPessoa);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = enderecoRepository.enderecoByIdEndereco(idEndereco);
        return enderecoRepository.update(enderecoRecuperado, enderecoAtualizar);
    }

    public void delete(Integer id) throws Exception {
        enderecoRepository.delete(id);
    }
}
