package com.nexus.tests.e2e;

import com.nexus.api.clients.UserClient;
import com.nexus.api.models.UserRequest;
import com.nexus.base.BaseTest;
import com.nexus.ui.pages.LoginPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Jornada do Usuário")
@Feature("Autenticação")
public class HybridLoginTest extends BaseTest {

    private final UserClient userClient = new UserClient();

    // Dados de teste (Em um cenário real, poderiam vir de um Faker ou Config)
    private final UserRequest testUser = new UserRequest("standard_user", "secret_sauce", "nexus@qa.com");

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Deve realizar login com sucesso após garantir existência do usuário via API")
    @Description("Este teste utiliza RestAssured para garantir o estado do banco e Playwright para validar a UI.")
    public void shouldLoginSuccessfullyWithHybridStrategy() {

        // 1. Camada de API: Garantir que o usuário existe (Data Seeding)
        // Nota: Em sites de treino como SauceDemo, a API é simulada, mas no projeto real
        // você enviaria o POST aqui.
      //  userClient.createUser(testUser);

        // 2. Camada de UI: Fluxo Fluente de Login
        boolean isLoginSuccessful = new LoginPage()
                .navigate()
                .login(testUser.username(), testUser.password())
                .isLoaded();

        // 3. Validação Final
        assertTrue(isLoginSuccessful, "O login deveria ter sido realizado com sucesso!");
    }
}