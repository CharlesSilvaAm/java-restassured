package com.api_java_test.contrato;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.dto.UsuarioDTO;
import io.restassured.http.ContentType;
import org.apache.http.client.CredentialsProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class CreateTest extends BaseTest {
    UsuarioDTO user = new UsuarioDTO();

    @Test
    public void validarContratoCriarUsuario() {

        user.setName("morpheus");
        user.setJob("leader");

        given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(user)
                .when()
                .post("/api/users")
                .then()
                .body(matchesJsonSchemaInClasspath("json_schemas/POST_CREATED.json"));
        }
    }
