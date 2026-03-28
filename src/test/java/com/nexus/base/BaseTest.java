package com.nexus.base;

import com.nexus.engine.driver.PlaywrightDriver;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import java.io.ByteArrayInputStream;
import java.nio.file.Paths;

/**
 * Classe base para todos os testes de UI.
 * Gerencia o setup/teardown e capturas de tela em caso de falha.
 */
public class BaseTest {

    @BeforeEach
    public void setUp() {
        // Inicializa o browser. 'true' para modo headless (ideal para CI/CD)
        // Você pode parametrizar isso via System.getProperty futuramente
        PlaywrightDriver.setup(true);
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        // Lógica de Engenharia de Valor: Screenshot apenas em falha
        // Para simplificar no portfólio, vamos anexar o estado final do teste
        captureScreenshot(testInfo.getDisplayName());

        PlaywrightDriver.quit();
    }

    /**
     * Captura um screenshot e anexa automaticamente ao relatório Allure.
     */
    private void captureScreenshot(String testName) {
        byte[] screenshot = PlaywrightDriver.getPage().screenshot();
        Allure.addAttachment("Screenshot Final - " + testName,
                new ByteArrayInputStream(screenshot));
    }
}