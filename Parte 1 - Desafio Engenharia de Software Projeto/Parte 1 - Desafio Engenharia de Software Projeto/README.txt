

ARQUIVOS
- diagrama_sequencia_renovar_emprestimo.txt: código-fonte PlantUML editável.
- diagrama_sequencia_renovar_emprestimo.png: imagem recortada do diagrama que o estudante exportou do PlantUML em PDF, para remover margens brancas e facilitar a leitura.
- README.txt: explicação, decisões de modelagem e checklist.

REVISÃO DO PDF EXPORTADO PELO ESTUDANTE
O PDF enviado contém uma página e mostra que o código foi renderizado pelo PlantUML. O diagrama contém:
- Ator Usuário.
- Tela de Renovação («boundary»).
- Controlador de Renovação («control»).
- Entidades Empréstimo, Livro e Reserva («entity»).
- API de Pagamento tratada como interface de sistema externo.
- Verificação de reserva antes da verificação de atraso.
- Alternativas alt para livro reservado/não reservado e empréstimo atrasado/não atrasado.
- Fragmento opt para a opção de pagamento via Pix.
A imagem PNG deste pacote foi recortada a partir desse PDF para retirar margens da página e preservar o conteúdo do diagrama.

REGRAS DO CASO DE USO CONFORME A ESPECIFICAÇÃO
1. Ator: Usuário.
2. Pré-condição: o usuário possui um livro em empréstimo.
3. O sistema verifica primeiro se existe reserva para o livro; se houver, bloqueia a renovação e informa o usuário.
4. Sem reserva, o sistema verifica se o empréstimo está atrasado.
5. Se estiver atrasado, o usuário é informado de que deve entregar o livro ou pagar a multa; a renovação não ocorre nesse fluxo.
6. Se o usuário optar por pagar a multa via Pix, o sistema calcula o valor devido até aquele momento, solicita à API de pagamento a geração do código e o exibe ao usuário.
7. Se não houver reserva nem atraso, o empréstimo é renovado e o usuário recebe a confirmação.

CLASSIFICAÇÃO BCE PROPOSTA
- Tela de Renovação — Boundary: interface com o usuário.
- Controlador de Renovação — Control: coordena o caso de uso e a ordem das verificações.
- Empréstimo — Entity: representa o empréstimo, verifica atraso, calcula multa e executa a renovação permitida.
- Livro — Entity: representa o livro e permite verificar a existência de reserva ativa.
- Reserva — Entity: representa/consulta a reserva vinculada ao livro.
- API de Pagamento — Boundary: interface com um serviço externo para gerar a cobrança Pix.

DECISÕES IMPORTANTES
- A API de pagamento é externa, por isso foi modelada como Boundary.
- O enunciado pede gerar e exibir o código Pix, mas não especifica confirmação do pagamento nem renovação automática após o pagamento. O diagrama não presume essas ações.
- Os nomes das classes são uma proposta; o grupo pode padronizá-los, preservando responsabilidades e regras de negócio.
- A especificação não determina banco de dados, repositórios ou detalhes de implementação da API; esses elementos não foram inventados.


