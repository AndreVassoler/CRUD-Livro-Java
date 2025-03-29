# 📚 CRUD de Livros com Spring Boot

## 📝 Descrição
Este projeto é um CRUD simples para gerenciamento de livros, desenvolvido com **Spring Boot**, **Spring Data JPA** e **H2 Database**. A aplicação permite:

- Criar um novo livro
- Listar todos os livros
- Buscar um livro por ID
- Deletar um livro

---

## 🚀 Tecnologias Utilizadas
- **Java 17**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Banco de Dados H2** (pode ser substituído por MySQL)
- **Maven**

---

## 📂 Estrutura do Projeto
```
📂 src/main/java/com/example/CRUD_Livros
 ┣ 📂 Controller
 ┃ ┗ 📜 LivroController.java
 ┣ 📂 DTO
 ┃ ┗ 📜 LivroDTO.java
 ┣ 📂 Enums
 ┃ ┗ 📜 Status.java
 ┣ 📂 Model
 ┃ ┗ 📜 Livro.java
 ┣ 📂 Repository
 ┃ ┗ 📜 LivroRepository.java
 ┣ 📂 Service
 ┃ ┗ 📜 LivroService.java
 ┗ 📜 CrudLivrosApplication.java
```

---

## 🛠️ Como Rodar o Projeto
### **1️⃣ Clonar o Repositório**
```bash
git clone https://github.com/AndreVassoler/CRUD-Livro-Java
cd CRUD_Livros
```

### **2️⃣ Configurar e Rodar a Aplicação**
#### **Usando Maven**
```bash
mvn spring-boot:run
```
#### **Ou Executando pelo VS Code/IntelliJ**
- Abra a classe `CrudLivrosApplication.java`
- Clique no botão **Run** ou pressione `Shift + F10`

---

## 📌 Endpoints da API
A aplicação expõe os seguintes endpoints:

### **1️⃣ Criar um Livro (POST)**
```bash
curl -X POST http://localhost:8080/livros -H "Content-Type: application/json" -d '{
  "titulo": "1984",
  "autor": "George Orwell"
}'
```

### **2️⃣ Listar Todos os Livros (GET)**
```bash
curl -X GET http://localhost:8080/livros
```

### **3️⃣ Buscar um Livro por ID (GET)**
```bash
curl -X GET http://localhost:8080/livros/1
```

### **4️⃣ Deletar um Livro (DELETE)**
```bash
curl -X DELETE http://localhost:8080/livros/1
```

---

## 🛠️ Banco de Dados
Por padrão, o projeto está configurado para rodar com o **H2 Database**. Caso prefira usar **MySQL**, altere o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/livraria
spring.datasource.username=root
spring.datasource.password=suasenha
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

Para acessar o **console do H2**, use:
```
http://localhost:8080/h2-console
```
**JDBC URL:** `jdbc:h2:mem:testdb`  
**Usuário:** `sa`  
**Senha:** (deixe em branco)

---

## ✅ Conclusão
Este projeto serve como uma excelente base para quem deseja aprender Spring Boot e JPA de forma prática e objetiva.

Ele pode ser expandido com funcionalidades como atualização de livros, autenticação de usuários e paginação de resultados.

