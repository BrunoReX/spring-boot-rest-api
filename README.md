
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

### Exemplo para adicionar `user` sem nenhuma `role`
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
### Exemplo para obter os items `role`
`GET` em `/roles` para obter (exemplo):
```
[
  {
    "id": 1,
    "name": "ADMIN"
  },
  {
    "id": 2,
    "name": "USER"
  },
]
```

### Exemplo para obter item `role` com `id`
`GET` em `/roles/1` para obter (exemplo):
```
{
  "id": 1,
  "name": "ADMIN"
}
```


### Exemplo para obter todos os items `user`
`GET` em `/users` para obter (exemplo):
```
[
  {
    "id": 1,
    "fullName": "John Darksouls",
    "userName": "johndark",
    "roles": [
      {
        "id": 1,
        "roleId": 1,
        "roleName": "ADMIN"
      },
      {
        "id": 2,
        "roleId": 2,
        "roleName": "USER"
      }
    ]
  },
  {
    "id": 2,
    "fullName": "Seu Madruga",
    "userName": "madruga",
    "roles": [
      {
        "id": 3,
        "roleId": 2,
        "roleName": "USER"
      }
    ]
  }
]
```

### Exemplo para obter item `user` com `id`
`GET` em `/users/1` para obter (exemplo):
```
{
  "id": 1,
  "fullName": "John Darksouls",
  "userName": "johndark",
  "roles": [
    {
      "id": 1,
      "roleId": 1,
      "roleName": "ADMIN"
    },
    {
      "id": 2,
      "roleId": 2,
      "roleName": "USER"
    }
  ]
}
```

### Exemplo para deletar item `role` com `id`
`DELETE` em `/roles/1/delete`

### Exemplo para deletar item `user` com `id`
`DELETE` em `/user/1/delete`
