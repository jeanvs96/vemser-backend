package com.chatkafka.chatkafka.service;

import com.chatkafka.chatkafka.dto.MensagemDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConsumerService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "${kafka.topic.geral}",
            groupId = "jean",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "kafka.client-id-geral")
    public void consumirChatGeral(@Payload String mensagem,
                         @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                         @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        imprimirMensagemChatGeral(mensagemDTO);
    }

    public void imprimirMensagemChatGeral(MensagemDTO mensagemDTO) {
        String data = mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String usuario = mensagemDTO.getUsuario();
        String mensagem = mensagemDTO.getMensagem();

        System.out.println(data + " [" + usuario + "] " + mensagem);
    }

    @KafkaListener(
            topics = "${kafka.topic.privado}",
            groupId = "${kafka.client-id}",
            containerFactory = "listenerContainerFactory",
            clientIdPrefix = "${kafka.client-id}")
    public void consumirChatPrivado(@Payload String mensagem,
                                  @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                  @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {

        MensagemDTO mensagemDTO = objectMapper.readValue(mensagem, MensagemDTO.class);
        imprimirMensagemChatPrivado(mensagemDTO);
    }

    public void imprimirMensagemChatPrivado(MensagemDTO mensagemDTO) {
        String data = mensagemDTO.getDataCriacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        String usuario = mensagemDTO.getUsuario();
        String mensagem = mensagemDTO.getMensagem();

        System.out.println(data + " [" + usuario + "](privado): " + mensagem);
    }
}
