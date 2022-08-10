package com.chatkafka.chatkafka.enums;

public enum ChatEnum {
    CHAT_GERAL("chat-geral"),
    CHAT_JEAN("chat-jean"),
    CHAT_BRUNO("chat-bruno"),
    CHAT_CESAR("chat-cesar"),
    CHAT_CLEBER("chat-cleber"),
    CHAT_CASTRO("chat-castro"),
    CHAT_DAYVIDSON("chat-dayvidson"),
    CHAT_GABRIEL("chat-gabriel"),
    CHAT_MACHADO("chat-machado"),
    CHAT_PAULO("chat-paulo"),
    CHAT_RAFAEL("chat-rafael"),
    CHAT_RODRIGO("chat-rodrigo"),
    CHAT_WILLIAN("chat-willian");

    private final String chat;

    ChatEnum(String chat) {
        this.chat = chat;
    }

    public String getChat(){return chat;}


}
