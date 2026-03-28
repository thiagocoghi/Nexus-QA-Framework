package com.nexus.ui.pages;

import com.microsoft.playwright.Page;
import com.nexus.engine.driver.PlaywrightDriver;

/**
 * Page Object da tela de Login com Fluent Interface.
 */
public class LoginPage {

    private final Page page;

    // Seletores (Locators) - Centralizados para fácil manutenção
    private final String userInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";

    public LoginPage() {
        this.page = PlaywrightDriver.getPage();
    }

    /**
     * Navega para a URL base do e-commerce.
     * @return a própria instância da LoginPage para encadeamento.
     */
    public LoginPage navigate() {
        page.navigate("https://www.saucedemo.com");
        return this;
    }

    /**
     * Realiza o preenchimento e clique de login.
     * @return a próxima página do fluxo (InventoryPage).
     */
    public InventoryPage login(String user, String pass) {
        page.fill(userInput, user);
        page.fill(passwordInput, pass);
        page.click(loginButton);
        return new InventoryPage();
    }
}