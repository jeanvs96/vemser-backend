package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.entity.TipoContato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    public ContatoService() {}

    public Contato create(Contato contato, Integer idPessoa) throws Exception {
        verificarIdPessoa(idPessoa);
        contato.setIdPessoa(idPessoa);
        return contatoRepository.create(contato);

    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        verificarIdPessoa(contatoAtualizar.getIdPessoa());
        return contatoRepository.update(recuperarContato(id), contatoAtualizar);
    }

    public void delete(Integer idContato) throws Exception {
        recuperarContato(idContato);
        contatoRepository.delete(idContato);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }



    public boolean verificarIdPessoa(Integer idPessoa) throws Exception{
        PessoaService pessoaService = new PessoaService();
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        return true;
    }

    public Contato recuperarContato(Integer idContato) throws Exception {
        try {
            Contato contatoRecuperado = contatoRepository.contatoByIdContato(idContato);
            return contatoRecuperado;
        } catch (Exception e) {
            throw  new Exception("Contato não econtrado");
        }
    }
}
