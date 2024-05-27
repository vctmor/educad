
1) Identificar Objetos e Classes
2) refinar a lista [de classes] do passo 1
3) identificar responsabilidades óbvias para cada classe
4) identificar os verbos como responsabilidade 
5) A partir do passo 4, realizar a trbuição das novas responsabilidades.
6) Apresentar a lógica para cada responsabilidade; A)fazer a lógica das responsabilidades de ação, descobrir novas responsabilidades; b) identificar colaborações


passo 1 identificar objetos e classes
    procurar por substantivos/nomes
    potenciais ojetos e classes

Passo 2 - refinar a lista [de classes] do passo 1
    identificar substantivos/nomes sinônimos que representam a mesma classe
    desconsiderar, neste passo, substantivos/nomes que representam atributos

    Identificar classes e sub classes
    Descrever o que cada classe faz

Cartões CRC
Classe:
Descrição:
Responsabilidade:
Colaboração:


Passo 3 - identificar responsabilidades óbvias para cada classe

Biblioteca
    Sabe:
        nomeBiblioteca
        catalogoLivros
        listaLeitores
    Faz:
        registraLeitor
            colabora:
                Leitor
            Colaboraçao:
                Construtor
                
        addLivroCatalogo
            Colabora:
                Livro
            Colaboração:
                Construtor
        emprestaLivro
            Colabora:
                Livro e Leitor
            colaboração:
                Marca livro, anexa livro
        devolveLivro
            Colabora:
                Livro
            Colaboração:
                desmarcaLivro, desanexa livro
        exibeLivrosDisponiveis
            Colabora:
                Livro
            Colaboração:
                Livro está disponível?
        exibeLivrosIndisponiveis
            Colaboradora:
                Livro
            Colaboração:
                Livro está disponível?

Livro
    Sabe:
        titulo
        autor
        idLivro
        disponibilidade
        emprestadoPara
    Faz:
        //marca livro como emprestado
        //anexa leitor como algo do empréstimo do livro
        desanexa usuario como alvo do emprestimo do livro
        marca livro como disponivel

Leitor
    Sabe:
        nome
        listaLivrosEmprestados
    Faz:
        anexa livro à lista de livros emprestados
        desanexa livro da lista de livros emprestados

Passo 4 - identificar os verbos como responsabilidade

passo 5 - A partir do passo 4, realizar a trbuição das novas responsabilidades.

    Para cada potencial responsabilidade **veriicar a classe a ser atribuída**:
        se corresponder à responsabilidade óbvia, buscar outra classe
        se não, busque classe para atribuir

passo 6 - Apresentar a lógica para cada responsabilidade; A)fazer a lógica das responsabilidades de ação, descobrir novas responsabilidades; b) identificar colaborações

Exemplo [método] "empresta livro" da classe Biblioteca:

    tem livro a emprestar para dado leitor
    [colabora com] classe Livro:
       anexar leitor como 'emprestador' do livro - **nova resposabilidade**
    [colabora com] classe Leitor    
        anexa livro à lista de livros do usuário - **nova resposabilidade**

Exemplo [método] "devolve livro" da classe Biblioteca:

    [colabora com] classe 
        Desanexa livro da lista de livros emprestados pelo leitor
    [colabora com] classe Livro
        Desanexa leitor como alvo do empréstimo do livro
      

Exemplo [método] "exibe livros disponíveis" da classe Biblioteca:

    para cada livro do catálogo de livros
        se o livro estiver disponível
            então coloca na lista para eibir

Exemplo [método] "registra leitors" da classe Biblioteca:   

    se leitor nnão esta na lista de leitores da biblioteca
        então cria/instnancia um novo objeto Leitor
        adiciona esse objeto na lista de usuários da biblioteca e avisa "novo leitor"
    caso contrario, avisa "Leitor Existente"

Exemplo [método] "adiciona livro" da classe Biblioteca:   

    cria novo número único de catalogo
    cria/Instancia um objeto Livro sob o o numero unico de catalogo
    adiciona objeto ao catalog de livros da biblioteca


Diagrama que ilustra a relação de dependência entre as classes na estrutura do sistema, onde a Biblioteca utiliza Livros e Leitores em suas operações.

```
    +------------+       +---------+
    | Biblioteca | ----> |  Livro  |
    +------------+       +---------+
            ^
            |
       +----+----+
       | Leitor  |
       +---------+
```

Neste diagrama:
- A classe Biblioteca depende da classe Livro, indicando que a Biblioteca utiliza ou tem uma associação com a classe Livro.
- A classe Biblioteca também depende da classe Leitor da mesma maneira.
- Não há uma seta saindo da classe Livro ou Leitor, indicando que elas não dependem de outras classes neste contexto específico.







