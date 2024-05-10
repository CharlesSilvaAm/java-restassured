# Desafio-api

## Pré-requisitos
### Ferramentas/Tecnologias:

- [Java JDK](https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html) - Como tecnologia (linguagem de programação)
- [TestNG](https://testng.org/) - Como _TestRunner_
- [Maven](https://maven.apache.org/) - Como gerenciador de dependências
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) - Como sugestão de IDE

## Arquitetura do projeto
```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├──com.api_java_test
│   │   │   │   ├── baseteste
│   │   │   │       └──BaseTest.class
│   │   │   │   ├── clients
│   │   │   │   │   └── ApiClient.class
│   │   │   │   ├── dataprovider
│   │   │   │   │   ├── EditarProvider.Class
│   │   │   │   │   ├── LoginProvider.class
│   │   │   │   │   ├── UsuarioProvider.class
│   │   │   │   ├── dto
│   │   │   │   │   ├── EditarDTO.class
│   │   │   │   │   ├── LoginDTO.class
│   │   │   │   │   ├── UsuarioDTO.class
│   │   ├── resources
│   ├── test
│   │   ├── java
│   │   │   ├── contrato
│   │   │   │   ├── CreateTest.class
│   │   │   │   ├── ListTest.class
│   │   │   │   ├── UpdatePatchTest.class
│   │   │   │   ├── UpdatePutTest.class
│   │   │   ├── funcional
│   │   │   │   ├── CadastroUsuario.class
│   │   │   │   ├── EditarUsuarioPatch.class
│   │   │   │   ├── EditarUsuarioPut.class
│   │   │   │   ├── ListarUsuarios.class
│   │   │   │   ├── LoginTest.class
│   │   ├── resources
│   │   │   ├── json_schemas
│   │   │   │   ├── GET_LIST_USERS.json
│   │   │   │   ├── PATCH_UPDATE_USER.json
│   │   │   │   ├── POST_CREATED.json
│   │   │   │   ├── PUT_UPDATE_USER.json
├── .gitignore
├── .github-ci.yml
├── pom.xml
├── README.md
```

## Execução do projeto

- Clonar o projeto
```bash
  git clone https://github.com/CharlesSilvaAm/java-restassured.git
```
- Branch
```bash
  develop-test
```
- Executar os testes pelo CLI. O comando deve ser executando na raiz do projeto.
```bash
  mvn test
```
- Ao final do teste será gerado um relatório HTML contendo a execução dos testes no diretório:
```bash
  target/report/test-report.html
```