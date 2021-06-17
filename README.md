# API-Mutant

A continuación se hace una breve descripción de la arquitectura utilizada y las tecnologias.

# Arquitectura

Se utiliza **heroku** PaaS para el despliegue de la aplicación, para comodidad del desarrollador 🙃

# Tecnologias

- Spring Boot
- Swagger
- Docker
- MongoDB

# EndPoints
```
POST: https://app-mutant-mercadolibre.herokuapp.com/mutants/api/mutant
GET: https://app-mutant-mercadolibre.herokuapp.com/mutants/api/stats
```

# Correr las Imagenes Docker

```
docker-compose up --build
```