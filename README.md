[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/Itb4j27_)
[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-2e0aaae1b6195c2367325f4f02e2d04e9abb55f0b24a779b69b11b9e10269abc.svg)](https://classroom.github.com/online_ide?assignment_repo_id=24138242&assignment_repo_type=AssignmentRepo)
# 🛡️ Laboratório — Batalha de Heróis

## Objetivo

Desenvolver um jogo simples de batalha por turnos utilizando os conceitos fundamentais de Programação Orientada a Objetos em Java.

---

# Cenário

O Reino de Arcádia está sob ataque. Para proteger a cidade, heróis enfrentam monstros em batalhas por turnos.

Cada personagem possui características próprias e pode atacar inimigos ou utilizar poções para recuperar vida durante o combate.

Seu objetivo é desenvolver o sistema responsável por controlar essa batalha.

---

# Requisitos Funcionais

## 1. Classe Personagem

Implemente a classe `Personagem`.

### Atributos

```java
private String nome;
private int vida;
private int ataque;
private int defesa;
private boolean pocaoUtilizada;
```

### Construtor

```java
public Personagem(String nome,
                  int vida,
                  int ataque,
                  int defesa)
```

### Métodos obrigatórios

```java
public void atacar(Personagem inimigo)

public void receberDano(int dano)

public void usarPocao(Pocao pocao)

public boolean estaVivo()

public String getNome()

public int getVida()
```

---

## 2. Classe Pocao

Implemente a classe `Pocao`.

### Atributos

```java
private String nome;
private int cura;
```

### Construtor

```java
public Pocao(String nome, int cura)
```

### Métodos

```java
public String getNome()

public int getCura()
```

---

## 3. Classe Jogo

Implemente uma classe `Jogo` contendo o método:

```java
public static void main(String[] args)
```

Essa classe deverá executar uma batalha completa entre dois personagens.

---

# Regras de Negócio

## Regra 1 — Ataque

O dano causado deve ser calculado por:

```text
dano = ataque - defesa
```

---

## Regra 2 — Dano mínimo

Todo ataque deve causar pelo menos:

```text
1 ponto de dano
```

---

## Regra 3 — Vida

A vida nunca pode ficar negativa.

```text
vida mínima = 0
```

---

## Regra 4 — Derrota

Um personagem é derrotado quando:

```java
vida == 0
```

Nesse caso:

```java
estaVivo() == false
```

---

## Regra 5 — Uso de poção

Cada personagem pode utilizar apenas **uma poção durante toda a batalha**.

Exemplo:

```java
Pocao pequena = new Pocao("Poção Pequena", 10);
```

Após utilizar a poção:

```java
vida += cura
```

Tentativas posteriores de usar poção devem ser ignoradas.

---

# Exemplo de Execução

```text
=== BATALHA INICIADA ===

Artemis ataca Goblin
Goblin possui 14 de vida

Goblin ataca Artemis
Artemis possui 27 de vida

Goblin usa Poção Pequena
Goblin possui 24 de vida

Artemis ataca Goblin
Goblin possui 18 de vida

...

=== FIM DA BATALHA ===

Vencedor: Artemis
```

---

# Restrições

* Não utilizar herança.
* Não utilizar interfaces.
* Não utilizar classes abstratas.
* Não utilizar bibliotecas externas.
* Utilizar apenas conceitos básicos de orientação a objetos.

---

# Critérios de Avaliação

| Item                                |   Pontos |
| ----------------------------------- | -------: |
| Classe Personagem                   |      2,0 |
| Classe Pocao                        |      1,0 |
| Encapsulamento                      |      1,0 |
| Método atacar                       |      2,0 |
| Método receberDano                  |      1,0 |
| Método usarPocao                    |      1,0 |
| Método estaVivo                     |      1,0 |
| Simulação da batalha na classe Jogo |      1,0 |
| **Total**                           | **10,0** |

---

# O que será avaliado automaticamente

Os testes verificarão:

* criação correta dos objetos;
* cálculo de dano;
* dano mínimo;
* redução da vida;
* vida não negativa;
* identificação de personagem derrotado;
* funcionamento da poção;
* limitação de uma poção por personagem;
* execução correta da batalha.
