package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Endereco> list() {
        return enderecoRepository.list();
    }

    public Endereco create(Endereco endereco, Integer idPessoa) throws RegraDeNegocioException {
        endereco.setIdPessoa(pessoaService.listByIdPessoa(idPessoa).getIdPessoa());
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer idEndereco, Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return enderecoRepository.update(listByIdEndereco(idEndereco), enderecoAtualizar);
    }

    public void delete(Integer idEndereco) throws RegraDeNegocioException {
        enderecoRepository.delete(listByIdEndereco(idEndereco));
    }

    public List<Endereco> listByIdPessoa(Integer idPessoa) {
        return list().stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa)).toList();
    }

    public Endereco listByIdEndereco(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoRecuperado;

    }
}
