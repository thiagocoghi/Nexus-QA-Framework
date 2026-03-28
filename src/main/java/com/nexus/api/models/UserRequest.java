package com.nexus.api.models;

/**
 * Record que representa o contrato da API de criação de usuário.
 * Records em Java 21 são imutáveis e já possuem getters, equals e hashCode nativos.
 */
public record UserRequest(String username, String password, String email) {}