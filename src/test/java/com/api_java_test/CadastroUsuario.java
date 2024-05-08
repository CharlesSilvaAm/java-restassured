package com.api_java_test;

import com.api_java_test.dto.LoginDTO;
import com.api_java_test.dto.UsuarioDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CadastroUsuario extends BaseTest {

    LoginDTO login = new LoginDTO();
    UsuarioDTO user = new UsuarioDTO();

    @Test
    public void RealizarCadastroDeUsuarioComSucesso() {

        login.setEmail("eve.holt@reqres.in");
        login.setPassword("cityslicka");

        user.setName("morpheus");
        user.setJob("leader");

        String token = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("token");

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(user)
                .when()
                .post("/users")
                .then()
                .statusCode(201);

    }

}
