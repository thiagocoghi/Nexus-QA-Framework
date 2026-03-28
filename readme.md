# 🚀 Nexus-QA-Framework

[![Java Version](https://img.shields.io/badge/Java-21%2B-orange)](https://www.oracle.com/java/)
[![Playwright](https://img.shields.io/badge/Framework-Playwright-green)](https://playwright.dev/java/)
[![RestAssured](https://img.shields.io/badge/API-RestAssured-red)](https://rest-assured.io/)
[![CI/CD](https://img.shields.io/badge/Pipeline-GitHub%20Actions-blue)](https://github.com/features/actions)

## 📌 Visão Geral
O **Nexus-QA-Framework** é um ecossistema de engenharia de qualidade de alto nível projetado para plataformas de E-commerce. Ele resolve o principal gargalo da automação moderna: a lentidão e a instabilidade (*flakiness*) de testes puramente de interface.

### O Diferencial: Estratégia Híbrida
Diferente de frameworks convencionais, o Nexus utiliza a **Camada de API (RestAssured)** para realizar o *Data Seeding* (criação de usuários, tokens e carrinhos) em milissegundos, permitindo que a **Camada de UI (Playwright)** foque exclusivamente na validação crítica da jornada do usuário.

---

## 🏗️ Arquitetura e Design Patterns

O projeto implementa princípios rigorosos de Engenharia de Software para garantir escalabilidade:

* **Fluent Page Object Model (POM):** Métodos encadeados que permitem uma escrita de teste próxima da linguagem natural.
* **Singleton Driver Factory:** Gerenciamento centralizado e seguro do ciclo de vida do Browser.
* **ThreadLocal Parallelism:** Arquitetura *Thread-Safe* pronta para execução paralela massiva.
* **Client Pattern (API):** Abstração completa das requisições REST utilizando POJOs (Plain Old Java Objects).

---

## 🛠️ Tech Stack

| Tecnologia          | Função |
|:--------------------| :--- |
| **Java 21**         | Linguagem base utilizando Records e modern Features. |
| **Playwright Java** | Automação de UI com auto-waiting e execução multi-browser. |
| **RestAssured**     | Validação de contratos e orquestração de massa via API. |
| **JUnit 5**         | Motor de execução, assertions e orquestração de suítes. |
| **Axe-core**        | Scan automático de acessibilidade (WCAG) integrado. |
| **Allure Report**   | Relatórios dinâmicos com screenshots em caso de falha. |

---

## 📂 Estrutura do Projeto

```text
nexus-qa-framework/
├── .github/workflows/       # Pipeline CI/CD (GitHub Actions)
├── src/
│   ├── main/java/com/nexus/
│   │   ├── api/             # REST Clients & Models (POJOs)
│   │   ├── ui/              # Page Objects & Components
│   │   └── engine/          # Driver Factory & Utils (Axe, Reports)
│   └── test/java/com/nexus/
│       ├── tests/           # Hybrid E2E, UI and API Test Cases
│       └── base/            # Lifecycle Hooks (BaseTest)
└── pom.xml                  # Dependências e Plugins Maven
```

## ⚙️ Integração Contínua (CI/CD)
O framework está configurado para rodar via GitHub Actions. A cada interação no repositório, o pipeline:

Provisiona um ambiente Linux (Ubuntu).

Instala o JDK 21 e os binários do Playwright.

Executa a suíte de testes em modo Headless.

Gera evidências e publica o Allure Report.


## 🚀 Como Executar Localmente
Clone o repositório:
```
Bash
git clone [https://github.com/seu-usuario/Nexus-QA-Framework.git](https://github.com/seu-usuario/Nexus-QA-Framework.git)
Instale as dependências e Browsers:
```
```
Bash
mvn install
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --with-deps"
Execute os testes:
```
```
Bash
mvn test
Visualize o Relatório:
```
```
Bash
mvn allure:serve
```
### 📊 Impacto de Negócio
Performance: Redução de até 40% no tempo de execução comparado a testes UI puros.

Confiabilidade: Localizadores resilientes eliminam falsos positivos.

Inclusão: Auditoria de acessibilidade automatizada em cada deploy.

Desenvolvido por Thiago Coghi \
QA Analisty | Engenheiro de Controle e Automação