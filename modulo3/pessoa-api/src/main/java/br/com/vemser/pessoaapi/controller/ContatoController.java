package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import br.com.vemser.pessoaapi.service.ContatoService;
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

    public ContatoController() {}

    @GetMapping
    public List<ContatoDTO> list(){
        return contatoService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<ContatoDTO> listByIdPessoa(@PathVariable ("idPessoa") Integer idPessoa) {
        return contatoService.listByIdPessoa(idPessoa);
    }

    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contatoCreateDTO, @PathVariable ("idPessoa") Integer idPessoa) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.create(contatoCreateDTO, idPessoa), HttpStatus.OK);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable ("idContato") Integer id, @RequestBody ContatoCreateDTO contatoAtualizarDTO) throws  RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizarDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable ("idContato") Integer id) throws RegraDeNegocioException {
        contatoService.delete(id);
    }
}
