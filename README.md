# API-do-projeto-NeceSa-de

API que será utilizado no NeceSaúde

## Requisitos
<!-- - [ ] Cálculo de IMC -->
- [ ] CRUD de Exames
- [ ] CRUD Infantil  
- [ ] CRUD de Usuários
- [ ] Autenticação
- [ ] Dashboard
<!-- // 1 Requisito ainda vai ser discutido -->
## Documentação

### Endpoints
<!-- - [Calculo IMC] (#calculo-imc) -->
- [Cadastrar Exame de Sangue](#cadastrar-exame-de-sangue)
- [Listar Exames de Sangue](#listar-exames-de-sangue)
- [Cadastrar Usuário](#cadastrar-usuário)
- [Autenticação do Usuário](#autenticação-do-usuário)
- [Atualizar Cadastro](#atualizar-cadastro)
- [Buscar dados Cadastro](#buscar-dados-cadastro)
- [Cadastro Infantil](#cadastro-infantil)
- [Buscar dados Infantis](#buscar-dados-infantis)
- [Atualizar dados Infantis](#atualizar-dados-infantis)

### Cadastrar Exame de Sangue

`POST` /exames/cadastro

### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|nome| string | sim | Nome do exame.
|data| string | sim | Data em que o exame foi realizado.
|colesterol LDL| int | sim | Dados do colesterol LDL.
|colesterol HDL| int | sim | Dados do colesterol HDL.
|triglicérides| int | sim | Dados do triglicérides.
|glicose| int | sim | Dados da glicose.


```js
[
    {   
        "nome": "Exame de sangue",
        "data": "01/01/2024",
        "colesterol LDL": 110,
        "colesterol HDL": 69,
        "triglicérides":  77,
        "glicose": 310
    }
]
```

#### Código de Status

| código | descrição
|--------|----------
|200|Exame cadastrado com sucesso.

---

### Listar Exames de Sangue

`GET` /exames

Retorna um array com os exames cadastrados.

#### Exemplo de Resposta

```js
[
    {   
        "id": 09253,
        "nome": "Exame de sangue",
        "data": "21/01/2024",
        "colesterol LDL": 123,
        "colesterol HDL": 100,
        "triglicérides":  220,
        "glicose": 210
    },
    {
        "id": 052363,
        "nome": "Exame de sangue",
        "data": "27/02/2024",
        "colesterol LDL": 109,
        "colesterol HDL": 84,
        "triglicérides":  155,
        "glicose": 182
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

`POST` /usuario/cadastro

Cadastrar um novo usuário.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
| nome | string | sim |Seu nome completo.
| cpf | long | sim | Seu CPF.
|idade| int | sim | Sua idade.
|email| string | sim | Seu email principal que será usado para o login.
|senha | string | sim | Senha que será utilizada para o login.


```js
{
    "nome": "Jorge",
    "cpf": 12345678900,
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

### Autenticação do Usuário

`GET` /usuario/autenticar

Verifica se os dados inputados de login pelo usuário coincidem com os armazenados no banco de dados.

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
| cpf | long | não | Seu CPF.
|idade| int | não | Sua idade.
|email| string | não | Seu email principal que será usado para o login.
|senha | string | não | Senha que será utilizada para o login.


```js
{
    "nome": "Jorge",
    "cpf": 12345678900,
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
    "cpf": 12345678900,
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

### Cadastro Infantil

`POST` /infantil/cadastro

Cadastrar um bebê ou criança que o usuário desejar.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|cpfRespo| long | sim | CPF do responsável do bebê ou criança, deve ser o mesmo do que foi utilizado no cadastro.
|nome| string | sim |Nome do bebê ou criança.
|idade| string | sim | Idade de quem será cadastrado.
|peso| string | sim | Peso de quem será cadastrado.
|altura| string | sim | Altura de quem será cadastrado.
|sexo| string | sim | Sexo de quem será cadastrado.

```js
{   
    "cpfRespo": 12345678900,
    "nome": "Mateus",
    "idade": "5 meses",
    "peso": "7.5 kg",
    "altura": "60 cm",
    "sexo": "masculino"
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Cadastro concluido com sucesso
|400|Não foi possível cadastrar. Verifique se já é cadastrado

---

### Buscar dados Infantis

`GET` /infantil/`{cpfRespo}`

Busca os dados de acordo com o `cpfRespo` passado pelo path, para ele poder atualizar algum dado caso queira.

#### Exemplo de Resposta

```js
{   
    "cpfRespo": 12345678900,
    "nome": "Mateus",
    "idade": "5 meses",
    "peso": "7.5 kg",
    "altura": "60 cm",
    "sexo": "masculino"
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Dados encontrados com sucesso.
|404|Não existe cadastro com os dados informados.

---
### Atualizar dados Infantis

`PUT` /infantil/`{cpfRespo}`

Atualiza os dados no `cpfRespo` informado no path, utilizando os novos dados enviados no corpo da requisição.

#### Corpo da Requisição

| campos | tipo | obrigatório | descrição
|--------|------|:-------------:|----------
|cpfRespo| long | não | CPF do responsável do bebê ou criança, deve ser o mesmo do que foi utilizado no cadastro.
|nome| string | não |Nome do bebê ou criança.
|idade| string | não | Idade de quem será cadastrado.
|peso| string | não | Peso de quem será cadastrado.
|altura| string | não | Altura de quem será cadastrado.
|sexo| string | não | Sexo de quem será cadastrado.

```js
{   
    "cpfRespo": 12345678900,
    "nome": "Mateus",
    "idade": "3 anos",
    "peso": "13 kg",
    "altura": "1,30 cm",
    "sexo": "masculino"
}
```

#### Código de Status

| código | descrição
|--------|----------
|200|Cadastro atualizado com sucesso.
|404|Não existe cadastro com o `cpfRespo` informado
---
