# Connect Hey
<p align="center">
  <img src="https://img.shields.io/static/v1?label=Spring Boot&message=framework&color=blue&style=for-the-badge&logo=springboot"/>
  <img src="https://img.shields.io/static/v1?label=react&message=framework&color=blue&style=for-the-badge&logo=REACT"/>
  <img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

### Tópicos 

🔹 [Descrição do projeto](#descrição-do-projeto)

🔹 [Funcionalidades](#funcionalidades)

🔹 [Telas](#telas)

🔹 [Documentação da API](#documentação-da-api)

🔹 [Autores](#autores)

Com o Connect Hey você pode conectar sua empresa com os fornecedores que você achar melhor para o seu negócio.

## Descrição do Projeto

Neste projeto você vai encontrar uma API que será consumida por uma aplicação web que conecta empresas à fornecedores.

O que foi utilizado:
- Backend: Java Spring Boot
- Frontend: React
- Banco de Dados do Azure para servidor flexível do PostgreSQL

## Funcionalidades

- [x] Cadastro de Empresa
- [ ] Cadastro de Fornecedor
- [ ] Perfil com possibilidade de edição das informações e exclusão de cadastro
- [ ] Listagem de Empresas por Nome
- [ ] Listagem de Fornecedor por Nome ou CPF/CNPJ

<!--
1. Requisitos
a. CRUD de todas as entidades (Front-end e Back-end)
e. Caso o fornecedor seja pessoa física, também é necessário cadastrar o RG e a data de nascimento
(f). Caso a empresa seja do Paraná, não permitir cadastrar um fornecedor pessoa física menor de idade
h. Validar CEP na API http://cep.la/api, a validação também deve ser feita no Front-end
-->

## Telas

#### Home
<p align="center">
  <img src=".github/home.png" width="100%">
</p>

## Documentação da API

#### Fornecedor (suppplier)

```http
  GET    /api/supplier          Retornar todos
  GET    /api/supplier/${name}  Retornar todos que contém nome informado
  GET    /api/supplier/${doc}   Retornar todos que contém CPNJ ou CPF informado
  GET    /api/supplier/${id}    Retornar um
  POST   /api/supplier          Criar
  PUT    /api/supplier          Atualizar
  DELETE /api/supplier          Deletar
```

#### Empresas (company)

```http
  GET    /api/company           Retornar todos
  GET    /api/supplier/${name}  Retornar todos que contém nome informado
  GET    /api/supplier/${doc}   Retornar todos que contém CPNJ ou CPF informado
  GET    /api/company/${id}     Retornar um
  POST   /api/company           Criar
  PUT    /api/company           Atualizar
  DELETE /api/company           Deletar
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `UUID` | **Obrigatório**. O ID do fornecedor ou companhia que você quer |
| `name`      | `String` | **Obrigatório**. O nome do fornecedor ou companhia que você quer |
| `doc`      | `String` | **Obrigatório**. O CNPJ/CPF do fornecedor ou companhia que você quer |

#### Schema Fornecedor

```http
  idSupplier        string($uuid)
  cnpjCpfSupplier   string
                    pattern: ^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$
  isCnpjSupplier    boolean
  nameSupplier      string
  postalSupplier    string
                    pattern: ^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$
  emailSupplier     string
  rgSupplier        string
                    pattern: ^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{1}$
  birthdaySupplier  string($date)
  createdAt         string($date-time)
  updatedAt	        string($date-time)
```

#### Schema Empresa

```http
  idCompany	          string($uuid)
  cnpjCompany         string
                      pattern: ^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$
  fantasyNameCompany  string
  postalCompany	      string
                      pattern: ^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$
  emailCompany	      string
  createdAt	          string($date-time)
  updatedAt	          string($date-time)
```

## Autores

- [Steph Hoel](https://www.github.com/StephHoel)
