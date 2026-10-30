# Parte 3 — Strategy para frete

Esta pasta contém a implementação Java, o fonte PlantUML `.txt` solicitado no enunciado e sua imagem PNG.

## Responsabilidades

- `FreteStrategy`: contrato comum às empresas de entrega; recebe endereço, dimensões e peso.
- `FreteEmpresaA` a `FreteEmpresaD`: estratégias concretas com os valores fixos definidos para o exercício.
- `Emprestimo`: contexto que mantém o usuário, o exemplar e a estratégia selecionada e calcula o frete.
- `MainTeste`: cria o cenário completo e exibe as quatro opções.
- `Diagrama_03.txt`: fonte PlantUML da organização das classes.
- `Diagrama_03.png`: renderização do diagrama para avaliação.

## Executar

Requer JDK. No terminal, dentro desta pasta:

```sh
javac *.java
java MainTeste
```

A implementação simula os valores indicados pelo enunciado. Não chama as APIs reais das transportadoras.
