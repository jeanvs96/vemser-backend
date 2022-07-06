package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Contato;
import br.com.vemser.pessoaapi.repository.ContatoRepository;

import java.util.List;

public class ContatoService {

    private ContatoRepository contatoRepository;

    public ContatoService() {
        contatoRepository = new ContatoRepository();
    }

    public Contato create(Contato contato) throws Exception {
        verificarIdPessoa(contato.getIdPessoa());
        verificarTipoDeContato(contato.getTipoContato());
        return contatoRepository.create(contato);

    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        verificarIdPessoa(contatoAtualizar.getIdPessoa());
        verificarTipoDeContato(contatoAtualizar.getTipoContato());
        return contatoRepository.update(id, contatoAtualizar);

    }

    public void delete(Integer id) throws Exception {
        contatoRepository.delete(id);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return contatoRepository.listByIdPessoa(idPessoa);
    }

    public boolean verificarTipoDeContato(String tipoDeContato) throws Exception {
        ContatoType[] comercial = ContatoType.values();
        for (ContatoType t : comercial) {
            if (t.toString().equals(tipoDeContato)) {
                return true;
            }
        }
        throw new Exception("Tipo de contato inválido.");
    }

    public boolean verificarIdPessoa(Integer idPessoa) throws Exception{
        PessoaService pessoaService = new PessoaService();
        pessoaService.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(idPessoa))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        return true;
    }
}
