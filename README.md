
# Projeto em Spring Boot para estudo de API REST com Banco de Dados

### Tecnologias Utilizadas
- Hibernate
- Lombok
- PostgreSQL
- Spring Boot
- Spring Data JPA
- Spring Web

### Exemplo para adicionar `role`
`POST` em `/roles/add` com o seguinte `body`:
```
{
  "name": "ADMIN"
}
```

### Exemplo para adicionar `user`
`POST` em `/users/add` com o seguinte `body`:
```
{
  "fullName": "John Darksouls",
  "userName": "johndark",
  "password": "estus"
}
```

### Exemplo para adicionar `user` com `roles`
`POST` em `/users/add` com o seguinte `body`:
```
{
  "fullName": "John Darksouls",
  "userName": "johndark",
  "password": "estus",
  "roles": [
    {
      "roleId": 1
    },
    {
      "roleId": 2
    }
  ]
}
```
