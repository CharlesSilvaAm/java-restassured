package com.api_java_test.contrato;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.dataprovider.EditarProvider;
import com.api_java_test.dto.EditarDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UpdateUserTest extends BaseTest {

    @Test(dataProvider = "editarUsuario", dataProviderClass = EditarProvider.class)
    public void validarContratoEditarUsuario(EditarDTO editar) {
        given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .body(editar)
                .when()
                .put("users/2")
                .then()
                .body(matchesJsonSchemaInClasspath("json_schemas/PUT_UPDATE_USER.json"));
    }
}

