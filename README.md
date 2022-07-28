# anime
Controle de cadastro para animes

Tecnologias utilizadas: Java 8, Springboot, banco: H2 e Swagger.
Exemplos de requisição:

POST:http://localhost:8080/anime
{
    "nomeAnime": "Naruto",
    "nomeAutor": "",
    "anoPublicacao": "2003-02-02",
    "numeroEpisodios": 30,
    "genero": "Luta",
    "sinopse": "Acão"
}

GET: http://localhost:8080/anime

GET: http://localhost:8080/anime/id

PUT: http://localhost:8080/anime/id

DELETE: http://localhost:8080/anime/id
