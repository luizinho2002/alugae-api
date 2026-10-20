# 🏡 Alugaê API

API backend desenvolvida em **Java** com **Spring Boot**, inspirada na plataforma do Airbnb, criada com o objetivo de gerenciar e filtrar imóveis para alugar por temporada de forma inteligente e performática.

---

## 🚀 Tecnologias Utilizadas

* **Java 17** (Linguagem principal)
* **Spring Boot 3.2.5** (Framework para desenvolvimento web e APIs REST)
* **Maven** (Gerenciamento de dependências e build)
* **Stream API & Lambdas** (Processamento funcional de coleções e filtros)
* **Git e GitHub** (Controle de versão e portfólio)

---

## 🏛️ Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas, garantindo separação de responsabilidades, código limpo e facilidade de manutenção:

* **`model/`**: Contém as classes de domínio e regras de negócio essenciais (ex: `Imovel` com encapsulamento e estruturas como `Set` e `Map`).
* **`service/`**: Camada de serviço (`ImovelService`), responsável por centralizar a lógica de negócio e as de fitragrem.
* **`controller/`**: Camada de controle (`AlugaeController`), responsável por expor as rotas HTTP (endpoints) e interagir com o cliente via JSON.

---

## 🔌 Endpoints Disponíveis

A aplicação roda nativamente na porta `8080`. Abaixo estão as rotas principais disponíveis na API

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| **GET** | `/` | Retorna uma mensagem de boas-vindas confirmando que a API está online. |
| **GET** | `/imoveis` | Retorna a lista completa de todos os imóveis cadastrados em formato JSON. |
| **GET** | `/imoveis/filtrar?precoMax=VALOR` | Filtra e retorna apenas os imóveis que possuem o preço por noite menor ou igual ao teto informado (utilizando **Stream API**). |

---

⚙️ Como Executar o Projeto Localmente

Certifique-se de ter o **Java 17** (ou superior) e o **Maven** instalados em sua máquina.

Clone o repositório e execute os comandos abaixo no seu terminal:

```bash
git clone [https://github.com/luizinho2002/alugae-api.git](https://github.com/luizinho2002/alugae-api.git)
cd alugae-api
mvn clean compile
mvn spring-boot:run
```

Depois de rodar, acesse no seu navegador ou cliente HTTP (como o Postman):

- **Home**: http://localhost:8080
- **Listar Imóveis**: http://localhost:8080/imoveis
- **Filtrar por Preço**: http://localhost:8080/imoveis/filtar?precoMax=400

---

## 👨‍💻 Autor

Desenvolvido por **Luiz Fernando** como parte de sua jornada de evolução e especialização em desenvolvimento Back-End Java.