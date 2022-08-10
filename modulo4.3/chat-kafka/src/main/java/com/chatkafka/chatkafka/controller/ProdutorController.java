package com.chatkafka.chatkafka.controller;

import com.chatkafka.chatkafka.enums.ChatEnum;
import com.chatkafka.chatkafka.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
@Validated
public class ProdutorController {
    private final ProducerService produtorService;

    @PostMapping("/send")
    public void enviarMensagem(String mensagem, @RequestParam List<ChatEnum> listChatEnum) throws JsonProcessingException {
        produtorService.sendMensagem(mensagem, listChatEnum);
    }
}
