## Dicionário de requisições para a API AutoBots

<details>
<summary><strong>Cliente</strong></summary>


### 1. Cadastrar Cliente (POST)

**Método:** `POST`  
**URL:** `http://localhost:8080/clientes`

**Body:**
```json
{
  "nome": "Sarah Montuani Batagioti",
  "nomeSocial": "Sarah Batagioti",
  "dataNascimento": "1990-05-15T00:00:00.000+00:00",
  "endereco": {
    "estado": "SP",
    "cidade": "São José dos Campos",
    "bairro": "Jupira",
    "rua": "Avenida Principal",
    "numero": "150",
    "codigoPostal": "12230000",
    "informacoesAdicionais": "Próximo à praça central"
  },
  "documentos": [
    {
      "tipo": "RG",
      "numero": "123456789"
    }
  ],
  "telefones": [
    {
      "ddd": "12",
      "numero": "987654321"
    }
  ]
}
```

**Resposta esperada:** `201 Created`

### 2. Listar Todos os Clientes (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes`

**Resposta esperada:** `200 OK`

### 3. Buscar Cliente por ID (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1`

**Resposta esperada:** `200 OK`

### 4. Atualizar Cliente (PUT)

**Método:** `PUT`  
**URL:** `http://localhost:8080/clientes/1`

**Body:**
```json
{
  "nome": "Batatinha",
  "nomeSocial": "Batatinha",
  "dataNascimento": "1990-05-15T00:00:00.000+00:00"
}
```

**Resposta esperada:** `200 OK`

### 5. Deletar Cliente (DELETE)

**Método:** `DELETE`  
**URL:** `http://localhost:8080/clientes/1`

**Resposta esperada:** `204 No Content`

</details>

<details>
<summary><strong>Endereço</strong></summary>


### 1. Cadastrar Endereço (POST)

**Pré-requisito:** Cliente com ID 1 deve existir

**Método:** `POST`  
**URL:** `http://localhost:8080/clientes/1/endereco`

**Body:**
```json
{
  "estado": "SP",
  "cidade": "São José dos Campos",
  "bairro": "Paraiso do Sol",
  "rua": "Rua Esperança",
  "numero": "250",
  "codigoPostal": "12240000",
  "informacoesAdicionais": "Apto 501"
}
```

**Resposta esperada:** `201 Created`

### 2. Buscar Endereço do Cliente (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1/endereco`

**Resposta esperada:** `200 OK`

### 3. Atualizar Endereço (PUT)

**Método:** `PUT`  
**URL:** `http://localhost:8080/clientes/1/endereco`


**Body:**
```json
{
  "estado": "RJ",
  "cidade": "Rio",
  "bairro": "De Janeiro",
  "rua": "Pão de Acucar",
  "numero": "444",
  "codigoPostal": "444444444",
  "informacoesAdicionais": "Próximo à praia"
}
```

**Resposta esperada:** `200 OK`

### 4. Deletar Endereço (DELETE)

**Método:** `DELETE`  
**URL:** `http://localhost:8080/clientes/1/endereco`

**Resposta esperada:** `204 No Content`

</details>

<details>
<summary><strong>Documento</strong></summary>


### 1. Cadastrar Documento (POST)

**Pré-requisito:** Cliente com ID 1 deve existir

**Método:** `POST`  
**URL:** `http://localhost:8080/clientes/1/documentos`

**Body:**
```json
{
  "tipo": "RG",
  "numero": "123456789"
}
```

**Resposta esperada:** `201 Created`

### 2. Listar Documentos do Cliente (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1/documentos`

**Resposta esperada:** `200 OK`

### 3. Buscar Documento por ID (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1/documentos/1`

**Resposta esperada:** `200 OK`

### 4. Atualizar Documento (PUT)

**Método:** `PUT`  
**URL:** `http://localhost:8080/clientes/1/documentos/1`



**Body:**
```json
{
  "tipo": "RG",
  "numero": "987654321"
}
```

**Resposta esperada:** `200 OK`

### 5. Deletar Documento (DELETE)

**Método:** `DELETE`  
**URL:** `http://localhost:8080/clientes/1/documentos/1`


**Resposta esperada:** `204 No Content`

</details>

<details>
<summary><strong>Telefone</strong></summary>


### 1. Cadastrar Telefone (POST)

**Pré-requisito:** Cliente com ID 1 deve existir

**Método:** `POST`  
**URL:** `http://localhost:8080/clientes/1/telefones`



**Body:**
```json
{
  "ddd": "12",
  "numero": "987654321"
}
```

**Resposta esperada:** `201 Created`

### 2. Listar Telefones do Cliente (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1/telefones`

**Resposta esperada:** `200 OK`

### 3. Buscar Telefone por ID (GET)

**Método:** `GET`  
**URL:** `http://localhost:8080/clientes/1/telefones/1`

**Resposta esperada:** `200 OK`


### 4. Atualizar Telefone (PUT)

**Método:** `PUT`  
**URL:** `http://localhost:8080/clientes/1/telefones/1`


**Body:**
```json
{
  "ddd": "11",
  "numero": "999999999"
}
```

**Resposta esperada:** `200 OK`

### 5. Deletar Telefone (DELETE)

**Método:** `DELETE`  
**URL:** `http://localhost:8080/clientes/1/telefones/1`

**Resposta esperada:** `204 No Content`

</details>


