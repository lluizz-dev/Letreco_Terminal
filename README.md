# 🎯 Letreco (Versão Terminal)

Projeto desenvolvido como desafio: **reproduzir o jogo Termo no Greenfoot**.  
Antes de implementar a versão gráfica, decidi criar primeiro uma **versão totalmente funcional no terminal**, para focar na lógica e estrutura do jogo.

---

## 🕹️ Sobre o jogo

O **Letreco** é um jogo inspirado no famoso **Termo / Wordle**, onde o jogador deve adivinhar uma palavra secreta em um número limitado de tentativas.

O sistema informa:
- ✅ Letras corretas e na posição correta  
- ⚠️ Letras corretas, mas na posição errada  
- ❌ Letras incorretas  

---

## 💻 Versão atual (Terminal)

A versão de console está sendo feita em **Java**, rodando diretamente no terminal.  
Ela utiliza arquivos `.txt` com todas as palavras dentro da pasta `src/main/resources`.

### ✨ Funcionalidades
- [X] Suporte a acentuação e palavras em português;
- [X] Arquitetura modular com classes separadas (`Controle`, `Palavra`, `LetrecoConsole`).
- [ ] Escolha aleatória de palavras;
- [ ] Feedback visual com cores no terminal;

### 🧩 Fase atual
- [X] Verificação da palavra;
- [ ] Lógica do jogo;
- [ ] Implentação no terminal;

---

## 🚧 Próximos passos
- [ ] Migrar a lógica para o **Greenfoot**, criando uma interface gráfica;
- [ ] Adicionar sons e animações;
- [ ] Implementar contagem de pontos e ranking.

---

## ⚙️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/lluizz-dev/Letreco.git
   ```
2. Abra o projeto na sua IDE, **IntelliJ IDEA, VS Code, Net Brains, Eclipse**.
3. Execute a classe principal:
   ```
   LetrecoConsole.java
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
          ├── ...
```

---

## 👨‍💻 Autor
**Luiz Eduardo**  
🎓 Estudante de Análise e Desenvolvimento de Sistemas  
💻 Foco em Programação

🔗 GitHub: [lluizz-dev](https://github.com/lluizz-dev)  
📫 Email: luiz.eduardodss24@gmail.com

---