package com.kafka.produtor.produtorconsumidor.controller;

import com.kafka.produtor.produtorconsumidor.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProducerService produtorService;

    @PostMapping("/enviar")
    public void enviarMensagem(String mensagem){
        produtorService.enviarMensagemKafka(mensagem);
    }
}
