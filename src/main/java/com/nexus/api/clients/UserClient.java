package com.nexus.api.clients;

import com.nexus.api.models.UserRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * Cliente responsável pelas chamadas de API relacionadas ao Usuário.
 */
public class UserClient {

    private static final String BASE_URL = "https://api.example.com"; // Substituir pela URL real do E-commerce

    /**
     * Cria um novo usuário no sistema via POST.
     * @param user Objeto com os dados do usuário.
     * @return Response do RestAssured para validações no teste.
     */
    public Response createUser(UserRequest user) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(user)
                .log().all() // Loga a requisição no console (útil para debug)
                .post("/users");
    }

    /**
     * Realiza o login via API para obter um Token de Autenticação.
     */
    public String getAuthToken(String username, String password) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"" + username + "\", \"password\": \"" + password + "\" }")
                .post("/login")
                .jsonPath()
                .getString("token");
    }
}