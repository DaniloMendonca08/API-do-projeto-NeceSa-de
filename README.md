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
- [Buscar dados Cadastro](#buscar-dados-cadastro)
- [Cadastrar Bebê ou Criança](#cadastro-bebê-ou-criança)
- [Atualizar dados do Bebê ou Criança](#atualizar-dados-bebe-ou-crianca)
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
|400|Não foi possível cadastrar. Verifique se já é cadastrado

---

### Autenticação do usuário

`GET` /usuario

Verifica se os dados inputados de login pelo usuário coincidem com os armazenados no banco de dados.

### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|email| string | sim | Email que foi inserido no momento do cadastro
|senha | string | sim | Senha que foi inserida no momento do cadastro.

```js

{  
    "email": "jorgeramos99@gmail.com",
    "senha": "jorgelindo1"
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Usuário autenticado com sucesso.
|400|Email ou senha estão incorretos. Tente novamente.
|404|Não existe cadastro com os dados informados.
---

### Atualizar Cadastro

`PUT` /usuario/`{email}`

Atualiza os dados do usuário baseado no `email` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
| nome | string | não |Seu nome completo.
| cpf | int | não | Seu CPF.
|idade| int | não | Sua idade.
|email| string | não | Seu email principal que será usado para o login.
|senha | string | não | Senha que será utilizada para o login.


```js
{
    "nome": "Jorge",
    "cpf": "12345678900",
    "idade": 23,
    "email": "jorgeramos@outlook.com",
    "senha": "jorgefeio2",

}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Cadastro atualizado com sucesso.
|404|Não existe cadastro com o `email` informado
---

### Buscar dados Cadastro

`GET` /usuario/`{email}`

Busca os dados do usuário de acordo com o `email` passado pelo path, para ele poder atualizar algum dado caso queira.

#### Exemplo de Resposta
 
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
|200|Dados encontrados com sucesso.
|404|Não existe cadastro com os dados informados.

---

### Cadastrar Bebê ou Criança

`POST` /cadastro-bebe-ou-crianca

Cadastrar um bebê ou criança que o usuário desejar.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|nome| string | sim |Nome do bebê ou criança.
|idade| int | sim | Idade de quem será cadastrado.
|peso| string | sim | Peso de quem será cadastrado.
|altura| string | sim | Altura de quem será cadastrado.
|sexo| string | sim | Sexo de quem será cadastrado.

```js
{
    "nome": "Mateus",
    "idade": "2 anos",
    "peso": "10 kg",
    "altura": "1,23 cm",
    "sexo": "masculino"

}
```