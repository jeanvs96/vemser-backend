package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
import br.com.vemser.pessoaapi.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
@Validated
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<ContatoDTO>> list(){
        return new ResponseEntity<>(contatoService.list(), HttpStatus.OK);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public ResponseEntity<List<ContatoDTO>> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) {
        return new ResponseEntity<>(contatoService.listByIdPessoa(idPessoa), HttpStatus.OK);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contatoCreateDTO, @PathVariable ("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.create(contatoCreateDTO, idPessoa), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable ("idContato") Integer id, @Valid @RequestBody ContatoCreateDTO contatoAtualizarDTO) throws  RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizarDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable ("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}
