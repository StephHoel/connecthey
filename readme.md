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
- Back-end: Spring Boot, Java
- Front-end: ReactJS, Typescript, Tailwindcss
- Banco de Dados do Azure para servidor flexível do PostgreSQL

## Funcionalidades

- [x] Cadastro de Empresa
- [x] Cadastro de Fornecedor
- [ ] Perfil com possibilidade de edição das informações e exclusão de cadastro
- [x] Listagem de Empresas por Nome
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
  <img src=".github/new_suppliers_pf.png" width="100%">
</p>

#### Novo Fornecedor (Pessoa Jurídica)
<p align="center">
  <img src=".github/new_suppliers_pj.png" width="100%">
</p>

## Documentação da API

#### Fornecedor (suppplier)

```http
  GET    /api/supplier                Retornar todos
  GET    /api/supplier/name/${name}   Retornar todos que contém nome informado
  GET    /api/supplier/doc/${doc}     Retornar todos que contém CPNJ ou CPF informado
  GET    /api/supplier/${id}          Retornar um
  POST   /api/supplier                Criar
  PUT    /api/supplier                Atualizar
  DELETE /api/supplier                Deletar
```


#### Empresas (company)

```http
  GET    /api/company                 Retornar todos
  GET    /api/supplier/name/${name}   Retornar todos que contém nome informado
  GET    /api/supplier/doc/${doc}     Retornar todos que contém CPNJ ou CPF informado
  GET    /api/company/${id}           Retornar um
  POST   /api/company                 Criar
  PUT    /api/company                 Atualizar
  DELETE /api/company                 Deletar
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
  updatedAt         string($date-time)
```


#### Schema Empresa

```http
  idCompany           string($uuid)
  cnpjCompany         string
                      pattern: ^([0-9]{2}[.]?[0-9]{3}[.]?[0-9]{3}[/]?[0-9]{4}[-]?[0-9]{2})$|^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})$
  fantasyNameCompany  string
  postalCompany       string
                      pattern: ^[0-9]{2}[.]?[0-9]{3}[-]?[0-9]{3}$
  emailCompany        string
  createdAt           string($date-time)
  updatedAt           string($date-time)
```

## Devs

- [Steph Hoel](https://www.github.com/StephHoel)
