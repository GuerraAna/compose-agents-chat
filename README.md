# agentchat

Projeto Android (Kotlin) para desenvolvimento e experimentação — aplicativo agora localizado no
módulo `app/`.

## Visão geral

Este repositório contém um projeto Android criado com Gradle (Kotlin DSL). O módulo principal do
aplicativo está em `app/`. O projeto parece configurado para desenvolvimento no Android Studio e usa
Kotlin.

## Estrutura do projeto (principal)

- build.gradle.kts, settings.gradle.kts, gradle.properties — arquivos de configuração do Gradle
- app/ — módulo Android principal
    - build.gradle.kts — configuração do módulo app
    - src/main/AndroidManifest.xml
    - src/main/java/ — código-fonte
    - src/main/res/ — recursos (layouts, drawables, strings, etc.)
    - proguard-rules.pro
- gradle/ — wrapper e configurações do Gradle

(Arquivos e pastas geradas por build estão em `app/build/`.)

## Requisitos

- JDK 11+ (conforme configuração do projeto)
- Android Studio (recomendado) ou linha de comando Gradle
- SDK Android apropriado instalado via Android Studio SDK Manager

## Como abrir o projeto

1. Abra o Android Studio.
2. Selecione "Open" e escolha a pasta do projeto: `C:\Users\anagu\AndroidStudioProjects\agentchat`.
3. Aguarde o Gradle sincronizar e baixar dependências.

## Comandos úteis (Windows)

- Compilar (modo debug):
    - gradlew.bat assembleDebug

- Instalar no dispositivo/emulador conectado:
    - gradlew.bat installDebug

- Executar testes unitários locais:
    - gradlew.bat test

- Executar testes instrumentados em dispositivo/emulador:
    - gradlew.bat connectedAndroidTest

- Limpar build:
    - gradlew.bat clean

Observação: se estiver usando Git Bash/WSL, pode usar `./gradlew` conforme apropriado.

## Execução no Android Studio

- Configure um emulador AVD pelo AVD Manager ou conecte um dispositivo físico com depuração USB
  habilitada.
- Use Run > Run 'app' ou o botão de execução para compilar e instalar.

## Boas práticas e dicas

- Mantenha o SDK e as ferramentas do Android atualizados via SDK Manager.
- Se ocorrerem problemas de sincronização do Gradle, experimente
  `File > Invalidate Caches / Restart` no Android Studio.

## Testes e CI

- Atualmente há suporte a testes unitários e instrumentados via Gradle. Integração contínua (CI) não
  está configurada neste README — configurar GitHub Actions/Bitrise/etc. é recomendado se desejar
  builds automatizados.

## Contribuição

1. Crie um branch para sua feature/bugfix.
2. Abra um pull request com descrição clara das mudanças.

## Contato

- Mantenha os commits com mensagens claras e descritivas.

---

Este README descreve o estado atual do projeto com base na estrutura encontrada no repositório.
Atualize conforme o projeto evoluir (dependências, instruções específicas, licenças, etc.).
