<h1 align="center">
  Spring Security + Keycloak
</h1>

## Configuração do Keycloak

1 - Executar Keycloak
```
docker compose up -d
```

2 - Criar usuário e client oauth no Keycloak
- Acessar a URL http://localhost:8080
- Criar Realm
- Registrar client oauth
- Criar novo usuário
     
## Como Executar
- Construir o projeto
```
./mvnw clean package
```
- Executar
```
java -jar ./target/spring-security-keycloak-0.0.1-SNAPSHOT.jar
```

## Como Testar
As seguintes rotas podem ser acessadas para testar:
- Acessar a URL http://localhost:9090
- GET /public - Rota aberta
- GET /private - Rota que pede autenticação
- GET /cookie - Rota que pede autenticação com cookie de sessão

Testar com [httpie](https://httpie.io/)
- http -A bearer -a ${JWT_TOKEN} GET /jwt - Rota que pede autenticação com JWT
