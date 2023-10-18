# DSMovie Desafio RestAssured
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/Luann2003/dsmovie-restassured-desafio/blob/main/LICENSE) 

Este projeto consiste na implementação de testes de API para o sistema DSMovie, que lida com informações de filmes e avaliações de filmes. O objetivo é utilizar o framework RestAssured para criar testes automatizados que verifiquem o comportamento correto das APIs.

## Sobre o Projeto DSMovie

O projeto DSMovie é uma plataforma de filmes que permite a visualização de dados públicos de filmes, mas exige autenticação para realizar operações de inserção, atualização e exclusão de filmes. Além disso, os usuários podem registrar avaliações de filmes com uma nota de 0 a 5. O sistema calcula a média das notas de todos os usuários e a armazena junto com a contagem de votos no filme.


## Testes de API

### MovieContollerRA:

1. `findAllShouldReturnOkWhenMovieNoArgumentsGiven`: Deve retornar o status "OK" quando nenhum argumento é fornecido.
2. `findAllShouldReturnPagedMoviesWhenMovieTitleParamIsNotEmpty`: Deve retornar filmes paginados quando um parâmetro de título do filme não estiver vazio.
3. `findByIdShouldReturnMovieWhenIdExists`: Deve retornar o filme quando o ID existe.
4. `findByIdShouldReturnNotFoundWhenIdDoesNotExist`: Deve retornar "Não encontrado" quando o ID não existe.
5. `insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankTitle`: Deve retornar "Entidade não processável" quando um administrador está logado e o título do filme está em branco.
6. `insertShouldReturnForbiddenWhenClientLogged`: Deve retornar "Proibido" quando um cliente está logado.
7. `insertShouldReturnUnauthorizedWhenInvalidToken`: Deve retornar "Não autorizado" quando o token é inválido.

### ScoreContollerRA:

8. `saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist`: Deve retornar "Não encontrado" quando o ID do filme não existe.
9. `saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId`: Deve retornar "Entidade não processável" quando o ID do filme está ausente.
10. `saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero`: Deve retornar "Entidade não processável" quando a pontuação é menor que zero.

## Como Executar os Testes

- Clone este repositório em sua máquina local.
- Certifique-se de que o ambiente de desenvolvimento esteja configurado corretamente.
- Execute os testes automatizados utilizando o framework RestAssured.

# Autor
Luan Victor de Ramos Luciano

https://www.linkedin.com/in/luan-luciano-1603b4197/

