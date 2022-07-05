package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.Contato;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContato = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 1, "COMERCIAL", "048995876566", "whatsapp"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 1, "RESIDENCIAL", "04833545655", "casa"));
        listaContato.add(new Contato(COUNTER.incrementAndGet(), 2, "COMERCIAL", "051998654789", "trabalho"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContato.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContato;
    }

    public Contato update(Integer id,
                         Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContato.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContato.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não econtrado"));
        listaContato.remove(contatoRecuperado);
    }

    public List<Contato> listByIdPessoa(Integer idPessoa) {
        return listaContato.stream()
                .filter(contato -> contato.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }
}
