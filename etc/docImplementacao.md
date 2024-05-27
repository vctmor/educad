# Documento de Implementação: Sistema de Gerenciamento de Alunos (Carômetro)

## Introdução
O Sistema de Gerenciamento de Alunos, denominado Carômetro, é uma aplicação desenvolvida em Java que permite a gestão de informações de alunos de uma instituição educacional. Esta documentação destina-se a fornecer uma visão geral do sistema, detalhes da implementação e instruções sobre como utilizá-lo.

## Funcionalidades
O Carômetro oferece as seguintes funcionalidades:

1. **Adicionar Aluno**: Permite adicionar novos alunos ao sistema, incluindo nome e foto.
2. **Buscar Aluno por RA**: Permite buscar alunos pelo seu RA (Registro Acadêmico).
3. **Editar Aluno**: Permite editar informações de alunos existentes, como nome e foto.
4. **Excluir Aluno**: Permite excluir um aluno do sistema.
5. **Listar Alunos por Nome**: Permite listar alunos com base em uma pesquisa por nome.
6. **Gerar PDF**: Gera uma lista de todos os alunos cadastrados em formato PDF, incluindo nome, RA e foto.

## Tecnologias Utilizadas
- Linguagem de Programação: Java
- Bibliotecas: Swing (para GUI), iText (para geração de PDF)
- Banco de Dados: MySQL
- Ferramentas de Desenvolvimento: Eclipse IDE

## Estrutura do Código
A estrutura do código-fonte é organizada em uma única classe Java, denominada `Carometro.java`. A seguir, descrevemos os principais componentes e métodos dessa classe:

- **Método `main()`**: Inicia a aplicação, criando uma instância da classe `Carometro` e tornando-a visível.

- **Métodos de Acesso ao Banco de Dados**:
  - `status()`: Verifica o status da conexão com o banco de dados.
  - `setarData()`: Define a data atual na interface gráfica.
  - `insertDB()`: Insere os dados de um novo aluno no banco de dados.
  - `buscarRA()`: Busca um aluno pelo RA no banco de dados.
  - `listarNomes()`: Lista os nomes dos alunos com base em uma pesquisa por nome.
  - `buscarNome()`: Busca um aluno pelo nome selecionado na lista.
  - `editar()`: Edita os dados de um aluno no banco de dados.
  - `excluir()`: Exclui um aluno do banco de dados.

- **Manipulação de Imagens**:
  - `carregarFoto()`: Carrega uma foto de um arquivo local e exibe na interface gráfica.

- **Outras Funcionalidades**:
  - `reset()`: Reseta o estado da interface gráfica para o padrão.
  - `gerarPdf()`: Gera um documento PDF com a lista de alunos cadastrados.

## Requisitos do Sistema
- Ambiente de execução Java (JRE)
- Banco de dados MySQL
- JDK para compilação (caso haja necessidade de alterações no código)

## Instruções de Uso
1. Execute a aplicação `Carometro.java`.
2. Utilize as funcionalidades disponíveis na interface gráfica para gerenciar os alunos.
3. Ao adicionar um aluno, é necessário informar o nome e carregar uma foto.
4. Para buscar um aluno pelo RA, digite o RA e clique em "Buscar".
5. Para editar um aluno, primeiro busque-o pelo RA, faça as alterações desejadas e clique em "Editar".
6. Para excluir um aluno, busque-o pelo RA e clique em "Excluir".
7. É possível listar alunos por nome digitando parte do nome na caixa de texto correspondente.
8. Para gerar um documento PDF com a lista de alunos, clique no botão "Gerar PDF".

## Considerações Finais
O Sistema de Gerenciamento de Alunos oferece uma interface intuitiva e funcionalidades essenciais para o gerenciamento eficaz das informações dos alunos. A estrutura modular do código permite fácil manutenção e extensão das funcionalidades conforme necessário.

Este documento fornece uma visão geral do sistema e instruções básicas de uso. Para informações mais detalhadas sobre a implementação, consulte o código-fonte e os comentários nele contidos.

---
Espero que este documento de implementação forneça uma visão clara do funcionamento e da estrutura do sistema de gerenciamento de alunos. Se precisar de mais alguma coisa, estou à disposição para ajudar!