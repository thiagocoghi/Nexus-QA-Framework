package com.nexus.ui.pages;

import com.microsoft.playwright.Page;
import com.nexus.engine.driver.PlaywrightDriver;

public class InventoryPage {

    private final Page page;
    private final String titleHeader = ".title";

    public InventoryPage() {
        this.page = PlaywrightDriver.getPage();
    }

    /**
     * Verifica se o título da página está visível (ex: "Products").
     */
    public boolean isLoaded() {
        return page.isVisible(titleHeader);
    }

    public String getTitle() {
        return page.innerText(titleHeader);
    }
}