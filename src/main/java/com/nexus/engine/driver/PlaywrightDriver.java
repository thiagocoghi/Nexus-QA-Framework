package com.nexus.engine.driver;

import com.microsoft.playwright.*;
import java.util.Objects;

/**
 * Gerenciador de Driver Playwright de alta performance.
 * Utiliza ThreadLocal para garantir segurança em execuções paralelas.
 */
public class PlaywrightDriver {

    private static final ThreadLocal<Playwright> playwrightThread = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThread = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> contextThread = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThread = new ThreadLocal<>();

    /**
     * Inicializa o motor do Playwright e o Browser para a thread atual.
     * @param headless Define se o browser rodará com ou sem interface visual.
     */
    public static void setup(boolean headless) {
        if (Objects.isNull(playwrightThread.get())) {
            Playwright playwright = Playwright.create();
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(headless)
            );

            playwrightThread.set(playwright);
            browserThread.set(browser);
            contextThread.set(browser.newContext());
            pageThread.set(contextThread.get().newPage());
        }
    }

    /**
     * Retorna a instância da Page exclusiva para a thread em execução.
     */
    public static Page getPage() {
        return pageThread.get();
    }

    /**
     * Encerra a sessão e limpa as variáveis de thread para evitar vazamento de memória (Memory Leak).
     */
    public static void quit() {
        if (Objects.nonNull(pageThread.get())) {
            pageThread.get().close();
            contextThread.get().close();
            browserThread.get().close();
            playwrightThread.get().close();

            pageThread.remove();
            contextThread.remove();
            browserThread.remove();
            playwrightThread.remove();
        }
    }
}