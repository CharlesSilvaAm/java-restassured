package com.api_java_test.funcional;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.UsuarioProvider;
import com.api_java_test.dto.LoginDTO;
import com.api_java_test.dto.UsuarioDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CadastroUsuario extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "criarUsuarioComSucesso", dataProviderClass = UsuarioProvider.class)
    public void RealizarCadastroDeUsuarioComSucesso(UsuarioDTO user, LoginDTO login) {
        ValidatableResponse responseLogin = apiClient.postLogin(login)
                .statusCode(200);
        String token = responseLogin.extract().path("token");
        apiClient.postCreateUser(user, token)
                .assertThat()
                .statusCode(201)
                .body("name", is(notNullValue()))
                .body("job", is(notNullValue()));

    }

}
