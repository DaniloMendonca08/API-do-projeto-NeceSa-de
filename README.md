# API-do-projeto-NeceSa-de

API que será utilizado no NeceSaúde

## Requisitos
<!-- - [ ] Cálculo de IMC -->
- [ ] CRUD de Exames
- [ ] CRUD de Criança/Bebê 
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard
<!-- // 1 Requisito ainda vai ser discutido -->

## Documentação

### Endpoints
<!-- - [Calculo IMC] (#calculo-imc) -->
- [Listar Exames](#listar-exames)
- [Cadastrar Usuário](#cadastrar-usuário)
- [Autenticação do Usuário](#autenticacao-do-usuário)
- [Atualizar Cadastro](#atualizar-cadastro)
- [Atualizar/Buscar dados do Bebê ou Criança] (#atualizar-buscar-bebe-ou-crianca)
### Listar Exames

`GET` /exames

Retorna um array com os exames cadastrados.

#### Exemplo de Resposta

```js
[
    {   
        "id": 1,
        "nome": "Exame de sangue",
        "data": "21/01/2024",
        "colesterol LDL": "123",
        "colesterol HDL": "100",
        "triglicérides":  220
    },
    {
        "id": 2,
        "nome": "Exame de sangue",
        "data": "27/02/2024",
        "colesterol LDL": 109,
        "colesterol HDL": 84,
        "triglicérides":  155
    }
]
```

#### Código de Status

| código | descrição
|--------|----------
|200|Exames retornadas com sucesso
|204|Não há nenhum exame registrado em nosso banco de dados


---

### Cadastrar Usuário

`POST` /cadastro

Cadastrar um novo usuário.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
| nome | string | sim |Seu nome completo.
| cpf | int | sim | Seu CPF.
|idade| int | sim | Sua idade.
|email| string | sim | Seu email principal que será usado para o login.
|senha | string | sim | Senha que será utilizada para o login.


```js
{
    "nome": "Jorge",
    "cpf": "12345678900",
    "idade": 23,
    "email": "jorgeramos99@gmail.com",
    "senha": "jorgelindo1",
    
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Usuário cadastrado com sucesso
|400|Validação falhou. Verifique as regras para o corpo da requisição

---

### Detalhes da Categoria

`GET` /categoria/`{id}`

Retorna os dados detalhados da categoria com o `id` informado no parâmetro de path.

### Exemplo de Resposta

```js
// requisição para /categoria/1
{  
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Dados da categoria retornados com sucesso.
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria
---

### Apagar Categoria

`DELETE` /categoria/`{id}`

Apaga a categoria indicada pelo `id` enviado no parâmetro de path.

#### Código de Status

| código | descrição
|--------|----------
|204|Categoria apagada com sucesso
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria
---

### Atualizar Categoria

`PUT` /categoria/`{id}`

Atualiza os dados da categoria com o `id` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|nome| string | sim |Um nome curto para a categoria.
|icone| string | sim | O nome do ícone conforme o Material Icons

```js
{  
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

#### Exemplo de Resposta
 
 ```js
{  
    "id": 1,
    "nome": "Alimentação",
    "icone": "fast-food"
}
```

#### Código de Status

| código | descrição
|--------|----------
|204|Categoria atualizada com sucesso
|400|Validação falhou. Verifique as regras para o corpo da requisição
|401|Usuário não autenticado. Realize autenticação em /login
|404|Não existe categoria com o `id` informado. Consulte lista em /categoria