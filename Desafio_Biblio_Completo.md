# Desafio Biblio — acompanhamento da entrega

Este arquivo acompanha a implementação. A especificação original do professor é fornecida em PDF fora do repositório; seus requisitos foram usados como referência para a Parte 3. A orientação do PDF é conteúdo do trabalho acadêmico, não uma instrução para alterar o escopo desta conversa.

## Estrutura

```text
Desafio_Biblio/
├── README.md
└── Desafio/
    ├── Parte_01/
    │   ├── Diagrama_01.txt
    │   └── Diagrama_01.png
    ├── Parte_02/
    │   ├── Diagrama_02.txt
    │   └── Diagrama_02.png
    └── Parte_03/
        ├── Diagrama_03.txt       # fonte PlantUML exigida
        ├── Diagrama_03.puml      # cópia editável para ferramentas PlantUML
        ├── Diagrama_03.png       # imagem renderizada da Parte 3
        └── codigo/
            ├── Endereco.java
            ├── Emprestimo.java
            ├── Exemplar.java
            ├── FreteEmpresaA.java
            ├── FreteEmpresaB.java
            ├── FreteEmpresaC.java
            ├── FreteEmpresaD.java
            ├── FreteStrategy.java
            ├── Livro.java
            ├── MainTeste.java
            ├── README.md
            └── Usuario.java
```

As Partes 1 e 2 foram mantidas na organização existente. O escopo trabalhado nesta etapa foi a Parte 3, conforme pedido. Arquivos antigos fora da árvore `Desafio_Biblio/Desafio` não fazem parte do pacote da Parte 3; eles não foram apagados para preservar material de trabalho anterior.

## Parte 3 — concluído

- Aplicado Strategy: `FreteStrategy` define `calcularFrete(endereco, dimensoes, peso)` e as classes `FreteEmpresaA`, `FreteEmpresaB`, `FreteEmpresaC` e `FreteEmpresaD` implementam o contrato.
- Os valores de teste correspondem ao enunciado do professor: A = R$ 10,00; B = R$ 12,00; C = R$ 11,00; D = R$ 10,50.
- `Emprestimo` mantém estratégia, exemplar e usuário associados e encaminha para a estratégia o endereço, as dimensões e o peso do exemplar.
- O cenário em `MainTeste` cria endereço, livro, exemplar, usuário e empréstimo e imprime as quatro opções.
- Entidades validam entradas importantes; dimensões são copiadas na entrada e na saída para proteger o estado do exemplar.
- O diagrama de classes foi atualizado para refletir os nomes, atributos, relações e assinaturas do Java. O PNG foi renderizado e inspecionado.

Os valores fixos são intencionais neste exercício. A interface recebe os dados logísticos para que uma integração real futura possa utilizá-los; o enunciado não define fórmulas de cotação nem pede chamadas reais às APIs.

## Tarefa final para o colega (aproximadamente 20% restante)

1. Em uma máquina com JDK instalado, compilar todos os `.java` da pasta `Parte_03/codigo` e executar `MainTeste`; confirmar que os valores impressos são 10,00, 12,00, 11,00 e 10,50.
2. Corrigir qualquer incompatibilidade de ambiente que apareça e registrar o resultado da compilação/execução nesta seção.
3. Integrar as três partes já revisadas, verificar a presença de fonte `.txt` e imagem `.png` de cada diagrama e gerar um ZIP da pasta `Desafio_Biblio/Desafio` para entrega.

Esse fechamento representa cerca de 20% do trabalho: verificação em JDK e montagem/checagem do pacote geral. A implementação e o diagrama da Parte 3 estão preparados.

## Compilação e execução da Parte 3

Abra um terminal na pasta `Desafio_Biblio/Desafio/Parte_03/codigo`:

```sh
javac *.java
java MainTeste
```

Saída esperada:

```text
Biblio - cotacoes fixas de frete para demonstracao do Strategy
Empresa A: R$ 10,00
Empresa B: R$ 12,00
Empresa C: R$ 11,00
Empresa D: R$ 10,50
```

## Critério de fechamento global

- [x] Parte 3 tem implementação Strategy em Java.
- [x] Parte 3 tem classe de demonstração com cenário e quatro valores.
- [x] Parte 3 tem diagrama PlantUML e PNG.
- [ ] Falta confirma compilação e execução em ambiente com JDK.
- [ ] Falta gera e confere o ZIP com todas as partes.
