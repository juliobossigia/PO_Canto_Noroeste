# Método do Canto Noroeste em Java

Este repositório contém uma implementação simples do método do canto noroeste em Java. O método do canto noroeste é uma técnica comum usada para resolver problemas de transporte. Ele começa identificando a célula com o menor custo de transporte e alocando o máximo possível de unidades para essa célula, respeitando as restrições de oferta e demanda.

## Como usar

1. Clone este repositório para o seu computador local.
2. Abra o arquivo `MetodoCantoNoroeste.java` em um editor de texto ou IDE de sua escolha.
3. Modifique o caminho do arquivo na linha que lê os dados do arquivo para apontar para o local do seu arquivo de dados.
4. Compile e execute o arquivo `MetodoCantoNoroeste.java`.

## Formato do arquivo de dados

O arquivo de dados deve ser um arquivo de texto (.txt) que contém os dados do problema de transporte na seguinte forma:

```
3 3
20 40 30
30 20 40
2 3 4
3 2 1
4 3 2
```

As duas primeiras linhas representam o número de fontes (n) e o número de destinos (m), respectivamente. As próximas n linhas representam a oferta de cada fonte, e as próximas m linhas representam a demanda de cada destino. As linhas restantes representam a matriz de custos.

## Saída

O programa imprimirá a matriz de alocação e o custo total (Z) da alocação.
