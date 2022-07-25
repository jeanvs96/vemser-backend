package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(("/paginacao"))
@RequiredArgsConstructor
public class PaginacaoController {

    private final ContatoRepository contatoRepository;

    private final EnderecoRepository enderecoRepository;

    @GetMapping("/contatos")
    public Page<ContatoEntity> listContatos(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("descricao"));
        return contatoRepository.contatosSortDescricao(pageable);
    }

    @GetMapping("/endereco")
    public Page<EnderecoEntity> listEnderecos(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("cep"));
        return enderecoRepository.enderecoSortCep(pageable);
    }

    @GetMapping("/endereco-por-pais")
    public ResponseEntity<Page<EnderecoEntity>> enderecoByPais(@RequestParam String pais, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("cep"));
        return new ResponseEntity<>(enderecoRepository.enderecoByPaisPageable(pais, pageable), HttpStatus.OK);
    }
}
