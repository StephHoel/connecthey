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

Neste projeto você vai encontrar uma API e uma aplicação web que devem ser usadas juntas para formr um website completo que conecta empresas à fornecedores.

O que foi utilizado:
- Back-end: Spring Boot, Java
- Front-end: ReactJS, Typescript, Tailwindcss
- Banco de Dados do Azure para servidor flexível do PostgreSQL

## Funcionalidades

- [x] Cadastro de Negócio
- [x] Cadastro de Fornecedor
- [ ] Cadastro de Usuários (quem cadastrará negócios e fornecedores)
- [ ] Perfil com possibilidade de edição das informações e exclusão de cadastro
- [x] Listagem de Negócio por Nome
- [x] Listagem de Fornecedor por Nome
- [ ] Listagem de Fornecedor por CPF/CNPJ

<!--
1. Requisitos
a. CRUD de todas as entidades (Front-end e Back-end)
(f). Caso a empresa seja do Paraná, não permitir cadastrar um fornecedor pessoa física menor de idade
h. Validar CEP na API http://cep.la/api, a validação também deve ser feita no Front-end
-->

## Telas

#### Home
<p align="center">
  <img src=".github/home.png" width="100%">
</p>

#### Procurar Negócios (Dados carregados)
<p align="center">
  <img src=".github/companies_loaded.png" width="100%">
</p>

#### Procurar Negócios (Carregando)
<p align="center">
  <img src=".github/companies_loading.png" width="100%">
</p>

#### Procurar Negócios (Sem dados)
<p align="center">
  <img src=".github/companies_not_records.png" width="100%">
</p>

#### Procurar Fornecedores (Dados carregados)
<p align="center">
  <img src=".github/suppliers_loaded.png" width="100%">
</p>

#### Procurar Fornecedores (Carregando)
<p align="center">
  <img src=".github/suppliers_loading.png" width="100%">
</p>

#### Procurar Fornecedores (Sem dados)
<p align="center">
  <img src=".github/suppliers_not_records.png" width="100%">
</p>

#### Novo Negócio
<p align="center">
  <img src=".github/new_company.png" width="100%">
</p>

#### Novo Fornecedor (Pessoa Física)
<p align="center">
  <img src=".github/new_supplier_pf.png" width="100%">
</p>

#### Novo Fornecedor (Pessoa Jurídica)
<p align="center">
  <img src=".github/new_supplier_pj.png" width="100%">
</p>

## Documentação da API

### Caminhos

| Fornecedor | (suppplier)                  |                                                |
| ---------- | ---------------------------- | ---------------------------------------------- |
| GET        | `/api/supplier`              | Retorna todos                                  |
| GET        | `/api/supplier/name/${name}` | Retorna todos que contém nome informado        |
| GET        | `/api/supplier/doc/${doc}`   | Retorna todos que contém CPNJ ou CPF informado |
| GET        | `/api/supplier/${id}`        | Retorna 1                                      |
| POST       | `/api/supplier`              | Cria                                           |
| PUT        | `/api/supplier`              | Atualiza                                       |
| DELETE     | `/api/supplier`              | Deleta                                         |


| Empresas | (company)                   |                                                |
| -------- | --------------------------- | ---------------------------------------------- |
| GET      | `/api/company`              | Retorna todos                                  |
| GET      | `/api/company/name/${name}` | Retorna todos que contém nome informado        |
| GET      | `/api/company/doc/${doc}`   | Retorna todos que contém CPNJ ou CPF informado |
| GET      | `/api/company/${id}`        | Retorna 1                                      |
| POST     | `/api/company`              | Cria                                           |
| PUT      | `/api/company`              | Atualiza                                       |
| DELETE   | `/api/company`              | Deleta                                         |


| Usuários | (user)          |                          |
| -------- | --------------- | ------------------------ |
| POST     | `/api/user`     | Retorna se existe ou não |
| POST     | `/api/user/new` | Cria                     |
| PUT      | `/api/user`     | Atualiza                 |
| DELETE   | `/api/user`     | Deleta                   |


### Definição

| Parâmetro  | Tipo     | Descrição                                                            |
| ---------- | -------- | -------------------------------------------------------------------- |
| `id`       | `UUID`   | **Obrigatório**. O ID do fornecedor ou companhia que você quer       |
| `name`     | `String` | **Obrigatório**. O nome do fornecedor ou companhia que você quer     |
| `doc`      | `String` | **Obrigatório**. O CNPJ/CPF do fornecedor ou companhia que você quer |
| `usarname` | `String` | **Obrigatório**. O username que você quer verificar                  |
| `password` | `String` | **Obrigatório**. A password que você quer verificar                  |


### Schemas 

| Fornecedor                |                                                              |
| ------------------------- | ------------------------------------------------------------ |
| idSupplier                | string($uuid)                                                |
| cnpjCpfSupplier           | string                                                       |
| cnpjCpfSupplier (pattern) | `^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2}$` |
| cnpjCpfSupplier (pattern) | `^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}$`             |
| isCnpjSupplier            | boolean                                                      |
| nameSupplier              | string                                                       |
| postalSupplier            | string                                                       |
| postalSupplier (pattern)  | `^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$`                         |
| emailSupplier             | string                                                       |
| rgSupplier                | string                                                       |
| rgSupplier (pattern)      | `^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{1}$`             |
| birthdaySupplier          | string($date)                                                |
| createdAt                 | string($date-time)                                           |
| updatedAt                 | string($date-time)                                           |


| Empresa                 |                                                              |
| ----------------------- | ------------------------------------------------------------ |
| idCompany               | string($uuid)                                                |
| cnpjCompany             | string                                                       |
| cnpjCompany (pattern)   | `^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2}$` |
| cnpjCompany (pattern)   | `^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}$`             |
| fantasyNameCompany      | string                                                       |
| postalCompany           | string                                                       |
| postalCompany (pattern) | `^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$`                         |
| emailCompany            | string                                                       |
| createdAt               | string($date-time)                                           |
| updatedAt               | string($date-time)                                           |


| Usuário           |                                                              |
| ----------------- | ------------------------------------------------------------ |
| idUser            | string($uuid)                                                |
| nameUser          | string                                                       |
| usernameUser      | string                                                       |
| passwordUser      | string                                                       |
| docUser           | string                                                       |
| docUser (pattern) | `^[0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2}$` |
| docUser (pattern) | `^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2}$`             |
| isCpfUser         | boolean                                                      |
| emailUser         | string                                                       |
| createdAt         | string($date-time)                                           |
| updatedAt         | string($date-time)                                           |


## Devs

- [Steph Hoel](https://www.github.com/StephHoel)
