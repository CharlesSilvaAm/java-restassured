package com.api_java_test;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.EditarProvider;
import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class EditarUsuario extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "editarUsuarioComSucesso", dataProviderClass = EditarProvider.class)
    public void EditarUsuarioCadastrado(EditarDTO editar, LoginDTO login) {
        ValidatableResponse responseLogin = apiClient.postLogin(login)
                .statusCode(200);
        String token = responseLogin.extract().path("token");
        apiClient.putUser(editar, token)
                .statusCode(201);
    }
}
