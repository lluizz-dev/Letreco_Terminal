# 🎯 Letreco (Versão Terminal)

Projeto desenvolvido como desafio: **reproduzir o jogo Termo no Greenfoot**.  
Antes de implementar a versão gráfica, foi criada uma **versão totalmente funcional no terminal**, com foco na lógica e estrutura do jogo.

---

## 🕹️ Sobre o jogo

O **Letreco** é inspirado no famoso **Termo / Wordle**, onde o jogador deve adivinhar uma palavra secreta em um número limitado de tentativas.

Durante o jogo, o sistema informa:
- ✅ **Letra correta e na posição correta**
- ⚠️ **Letra correta, mas na posição errada**
- ❌ **Letra incorreta**

---

## 💻 Versão atual (Terminal)

Esta versão é desenvolvida em **Java** e roda diretamente no terminal.  
Ela utiliza arquivos `.txt` localizados na pasta `src/main/resources` para armazenar as palavras.

### ✨ Funcionalidades implementadas
- [X] Suporte a acentuação e palavras em português
- [X] Arquitetura modular com classes separadas (`Controle`, `Palavra`, `LetrecoConsole`)
- [X] Escolha aleatória de palavras *(em desenvolvimento)*
- [X] Feedback visual colorido no terminal *(em desenvolvimento)*

---

## ⚙️ Como executar o projeto

### 1. Instalar o JDK
Para rodar o jogo, é necessário ter o **Java Development Kit (JDK)** instalado.

#### 🧩 Passo a passo:
1. Acesse o site oficial da Oracle:  
   👉 [https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)
2. Baixe a versão mais recente do **JDK 21 ou superior**.
3. Instale normalmente clicando em *Next* até concluir.

#### 🧠 Verificando a instalação
Abra o **Prompt de Comando (CMD)** e digite:
```bash
java -version
```
Se aparecer algo como:
```
java version "21.0.1" 2025-07-15 LTS
```
significa que o Java foi instalado com sucesso.

---

### 2. Configurar variáveis de ambiente (se necessário)

Caso o comando `java -version` **não funcione**, é preciso configurar as variáveis de ambiente manualmente:

#### 🔧 Passo a passo:
1. Procure no Windows: **Editar variáveis de ambiente do sistema**
2. Clique em **Variáveis de Ambiente**
3. Em **Variáveis do sistema**, clique em **Novo** e adicione:
    - **Nome da variável:** `JAVA_HOME`
    - **Valor da variável:** caminho de instalação do JDK  
      (Exemplo: `C:\Program Files\Java\jdk-25`)
4. Ainda em "Variáveis do sistema", localize a variável `Path` → **Editar**
    - Clique em **Novo** e adicione:
      ```
      %JAVA_HOME%\bin
      ```
5. Clique em **OK** em todas as janelas e feche.
6. Abra um novo terminal e digite novamente:
   ```bash
   java -version
   ```
   Agora deve funcionar corretamente.

---

### 3. Clonar o repositório
Abra o terminal e digite:
```bash
git clone https://github.com/lluizz-dev/Letreco.git
```

---

### 4. Abrir o projeto
Abra a pasta clonada na sua IDE favorita:  
**IntelliJ IDEA**, **VS Code**, **NetBeans** ou **Eclipse**.

Certifique-se de que o **JDK configurado no projeto** seja o mesmo instalado no sistema.

---

### 5. Compilar e executar

#### ✅ Via IDE:
Abra o arquivo `LetrecoConsole.java` e clique em ▶️ **Run**.

#### ✅ Via terminal:
Dentro da pasta raiz do projeto, digite:
```bash
javac -d bin src/main/java/*.java
java -cp bin main.java.LetrecoConsole
```

---

## 📂 Estrutura do projeto
```
src/
 └── main/
     ├── java/
     │    ├── Controle.java
     │    ├── LetrecoConsole.java
     │    └── Palavra.java
     └── resources/
          ├── conjugacoes.txt
          ├── continentes.txt
          ├── frutas.txt
          └── ...
```

---

## 🚧 Próximos passos
- [ ] Migrar lógica para **Greenfoot** (versão gráfica)
- [ ] Adicionar sons e animações
- [ ] Criar ranking de pontuação

---

## 📸 Exemplo de execução *(em breve)*
> Em breve será adicionado um exemplo visual do jogo rodando no terminal.

---

## 👨‍💻 Autor

**Luiz Eduardo**  
🎓 Estudante de Análise e Desenvolvimento de Sistemas  
💻 Focado em programação e desenvolvimento de jogos

🔗 GitHub: [lluizz-dev](https://github.com/lluizz-dev)  
📫 Email: luiz.eduardodss24@gmail.com

---

## 💬 Sugestões

Contribuições são bem-vindas!  
Se quiser sugerir melhorias ou novas funcionalidades, abra uma *issue* no repositório.

---
