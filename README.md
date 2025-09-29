# 🎮 Biblioteca de Jogos

Uma aplicação web para gerenciar sua coleção de jogos pessoais. Permite **cadastrar, listar, editar, excluir e pesquisar jogos**, com classificação por **categoria** e **estúdio/desenvolvedor**.

---

## 🛠 Tecnologias Utilizadas

| Tecnologias | Descrição |
|-------------|-----------|
| **Java 21** | Linguagem principal |
| **Spring Boot** | Framework back-end |
| **Thymeleaf** | Template Engine para o front-end |
| **PostgreSQL** | Banco de dados relacional |
| **Bootstrap 5** | Estilização e layout responsivo |
| **Maven** | Gerenciador de dependências |

---

## 🚀 Como Rodar o Projeto Localmente

### ✅ Pré-requisitos

Antes de começar, você precisa ter instalado:

- **Java 17+**  
- **Maven**  
- **PostgreSQL**  

---

### 📦 Clonar o Projeto

```bash
git clone https://github.com/SEU_USUARIO/bibliotecajogos.git
cd bibliotecajogos
````
### 🗄️ Configurar o Banco de Dados
Crie um banco PostgreSQL local:

````
CREATE DATABASE bibliotecajogos;
````
### ⚙️ Configurar application.properties
No arquivo `src/main/resources/application.properties`, configure:

````
spring.datasource.url=jdbc:postgresql://localhost:5432/bibliotecajogos
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
````


### ▶️ Rodar a Aplicação
Via Maven:

````
./mvnw spring-boot:run
````
Ou gerando o .jar:

````
./mvnw clean package
java -jar target/bibliotecajogos-0.0.1-SNAPSHOT.jar
````
### 🌐 Acessar no Navegador
````
http://localhost:8080/jogos
````

---

### 📸 Funcionalidades
>✔️ Cadastro de jogos
>
>✔️ Listagem com ordenação
>
>✔️ Pesquisa por título, autor e gênero
>
>✔️ Seleção de Categoria e Estúdio
>
>✔️ Edição e exclusão

---

### 📌 Futuras Melhorias (Opcional)
>🔍 Filtro por categoria e estúdio
>
>⭐ Campo de avaliação/nota
>
>📊 Dashboard com estatísticas
