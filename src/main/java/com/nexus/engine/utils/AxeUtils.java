//package com.nexus.engine.utils;
//
//import com.deque.html.axe_core.playwright.AxeBuilder;
//import com.deque.html.axe_core.results.AxeResults;
//import com.nexus.engine.driver.PlaywrightDriver;
//import io.qameta.allure.Allure;
//import java.util.Objects;
//
///**
// * Utilitário para auditoria de acessibilidade (WCAG).
// */
//public class AxeUtils {
//
//    /**
//     * Realiza um scan de acessibilidade na página atual e anexa ao Allure.
//     * @param contextName Nome do contexto/página para o relatório.
//     */
//    public static void checkAccessibility(String contextName) {
//        AxeResults results = new AxeBuilder(PlaywrightDriver.getPage()).analyze();
//
//        if (!results.getViolations().isEmpty()) {
//            StringBuilder report = new StringBuilder();
//            report.append("Violações de Acessibilidade encontradas em: ").append(contextName).append("\n\n");
//
//            results.getViolations().forEach(violation -> {
//                report.append("ID: ").append(violation.getId()).append("\n");
//                report.append("Descrição: ").append(violation.getDescription()).append("\n");
//                report.append("Impacto: ").append(violation.getImpact()).append("\n");
//                report.append("Ajuda: ").append(violation.getHelpUrl()).append("\n");
//                report.append("------------------------------------------\n");
//            });
//
//            // Anexa o relatório detalhado ao Allure
//            Allure.addAttachment("Accessibility Report - " + contextName, report.toString());
//        }
//    }
//}