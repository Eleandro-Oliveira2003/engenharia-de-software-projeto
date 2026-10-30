PARTE 2 - DIAGRAMA DE ESTADOS DO LIVRO (SISTEMA BIBLIO)

ARQUIVOS
- Diagrama_02.txt: código PlantUML.
- Diagrama_02.png: exporte em https://plantuml.com/ (cole o código do .txt, clique em Submit e salve a imagem PNG) e coloque nesta pasta.

ESTADOS: Disponível, Emprestado, Atrasado, Reservado, Em Inspeção.
ESTADO INICIAL: [*] -> Disponível (livro cadastrado no acervo).
ESTADO FINAL: não há; a especificação permite nenhum ou vários e as regras não descrevem baixa/descarte do livro.

REGRAS COBERTAS
1. Na prateleira = Disponível.
2. Retirada por sócio = Emprestado.
3. Emprestado + prazo vencido = Atrasado; enquanto atrasado, há auto-transição diária que envia o e-mail de aviso.
4. Devolução com reserva vinculada = Reservado (não fica disponível para os demais).
5. Inspeção a cada 15 empréstimos: na devolução, se qtdEmprestimos é múltiplo de 15, o livro vai para Em Inspeção.
6. Saída da inspeção = Disponível (sem reserva) ou Reservado (com reserva).

DECISÕES DE MODELAGEM
- Toda transição tem evento (retirar, devolver, prazo ultrapassado, novo dia em atraso, inspeção concluída).
- Se a devolução ocorre no 15º empréstimo e há reserva, a inspeção tem prioridade; depois dela o livro vai para Reservado.
- Reservado -> Emprestado: o sócio da reserva retira o livro. A especificação não pede expiração de reserva, então não foi modelada.
