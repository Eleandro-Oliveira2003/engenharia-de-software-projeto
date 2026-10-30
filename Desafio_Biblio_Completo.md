# Desafio Biblio: estado do projeto e plano de conclusão

Este documento registra o que já existe no repositório, o que foi organizado nesta rodada e o trabalho que falta. A implementação Java da Parte 3 é uma base didática; os valores das transportadoras são fixos e servem apenas para demonstrar o padrão Strategy.

## Estrutura consolidada

```text
Desafio_Biblio/
├── Desafio_Biblio_Completo.md       # cópia de acompanhamento; manter sincronizada com a raiz
└── Desafio/
    ├── Parte_01/
    │   ├── Diagrama_01.txt          # PlantUML: sequência para renovar empréstimo
    │   └── Diagrama_01.png          # exportar após revisão
    ├── Parte_02/
    │   ├── Diagrama_02.txt          # PlantUML: estados do exemplar
    │   └── Diagrama_02.png          # exportar após revisão
    └── Parte_03/
        ├── Diagrama_03.txt          # PlantUML: classes do Strategy
        ├── Diagrama_03.png          # exportar após revisão
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
            └── Usuario.java
```

Os diagramas ficam junto da parte a que pertencem, e as classes Java da Parte 3 ficam no mesmo diretório de código sem `package`; assim podem ser compiladas juntas. Os arquivos `Diagrama_*.txt` são fontes PlantUML e os PNGs são entregáveis ainda pendentes.

## Situação por parte

### Parte 1 — sequência de renovação

**Já existe:** `Desafio/Parte_01/Diagrama_01.txt`, com fluxo BCE, consulta de reserva, verificação de atraso, renovação e opção de cobrança Pix.

**Falta:** revisar o fluxo contra o enunciado oficial, confirmar exceções e exportar `Diagrama_01.png`. Não há implementação Java desta parte no projeto.

### Parte 2 — estados do exemplar

**Já existe:** `Desafio/Parte_02/Diagrama_02.txt`, com os estados Disponível, Emprestado, Atrasado, Reservado e Em Inspeção; modela aviso diário de atraso e inspeção a cada 15 empréstimos na devolução.

**Falta:** revisar a regra de prioridade entre reserva e inspeção com base no enunciado oficial e exportar `Diagrama_02.png`. Não há implementação Java desta parte no projeto.

### Parte 3 — Strategy para frete

**Já existe:** interface `FreteStrategy`, quatro implementações de transportadora, entidades auxiliares, `Emprestimo.calcularFrete()` e `MainTeste`. A estratégia recebe endereço, dimensões e peso; os dados do empréstimo são conectados às entidades e a troca de estratégia é demonstrada no exemplo.

**Corrigido nesta organização:** assinaturas desalinhadas entre a interface e o código legado, empréstimo que passava `null` para o cálculo, `Endereco` duplicado/incompatível, `System.str` e aspas inválidas no teste. O getter de cidade retorna `String`; as dimensões são copiadas para evitar alteração externa.

**Falta:** conferir se os cálculos devem usar de fato peso, dimensões e endereço conforme as fórmulas do enunciado. Hoje A/B/C/D retornam valores fixos (R$ 10,00 / R$ 12,00 / R$ 11,00 / R$ 10,50), então não representam cotações reais. Exportar `Diagrama_03.png` após revisão.

## Divisão do trabalho pendente

### Colega 1 — Partes 1 e 2 (diagramas e entregáveis)

- Conferir `Parte_01/Diagrama_01.txt` e `Parte_02/Diagrama_02.txt` linha a linha com o enunciado oficial.
- Corrigir regras/nomes de eventos que não correspondam à especificação e explicar decisões ambíguas em comentários curtos no arquivo.
- Gerar `Diagrama_01.png` e `Diagrama_02.png` a partir dos fontes PlantUML revisados, salvando cada PNG na pasta correspondente.
- Atualizar este documento com o que foi alterado e os critérios ainda não atendidos.

### Colega 2 — Parte 3 (cálculo, diagrama e integração)

- Conferir as fórmulas e parâmetros de frete exigidos pelo enunciado; substituir os valores fixos das quatro classes se as fórmulas estiverem especificadas.
- Ajustar `FreteStrategy`, as quatro estratégias e `Emprestimo` em conjunto, mantendo uma assinatura única e os dados do endereço/exemplar conectados.
- Revisar `Parte_03/Diagrama_03.txt` para refletir os nomes e assinaturas finais do Java e exportar `Diagrama_03.png` na pasta da Parte 3.
- Verificar que o exemplo `MainTeste` demonstre as quatro empresas e documentar os resultados obtidos.

## Critérios para considerar concluído

- [ ] As três fontes PlantUML correspondem ao enunciado e aos arquivos Java aplicáveis.
- [ ] Os três PNGs estão nas pastas indicadas e foram gerados dos fontes finais.
- [ ] As regras e os parâmetros de cada parte foram conferidos com o enunciado oficial.
- [ ] O código da Parte 3 compila em conjunto e `MainTeste` demonstra A, B, C e D.
- [ ] Este documento e a cópia `Desafio_Biblio/Desafio_Biblio_Completo.md` descrevem a mesma situação.

## Como compilar e executar a Parte 3

Na pasta `Desafio/Parte_03/codigo`, com JDK instalado:

```sh
javac *.java
java MainTeste
```

Os valores exibidos atualmente são fixos e ilustrativos. A saída comprova somente que a troca de estratégia está conectada; não valida uma regra comercial de frete. Nesta máquina, `javac` não está instalado ou não está no PATH, portanto a compilação ainda precisa ser confirmada por um dos colegas com JDK.

