# Encurtador de Url

Api desenvolvida com o proposito de encurtar urls.

## 🛠️Tecnologias
- Spring Boot
- MongoDb
- Docker



## 🚀 Como Rodar 

<b>Para rodar a aplicação:</b> <br>
```
$ git clone https://github.com/nobregas/url-shortener.git
$ ./mvnw clean package
$ docker compose up
$ java -jar target/url-shortener.jar
```

## 📚Funcionalidades
- Encurtar url
````
- http POST http://localhost:8080/shorten
{
    "url": "https://www.google.com/"
}
````
- Redirecionar
````
- http GET http://localhost:8080/ID gerado

http://localhost:8080/663189ddd65bad60891fb30b -> https://www.google.com/
````

