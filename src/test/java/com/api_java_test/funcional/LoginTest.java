package com.api_java_test.funcional;
import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.LoginProvider;
import com.api_java_test.dto.LoginDTO;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class LoginTest extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "loginSucesso", dataProviderClass = LoginProvider.class)
    public void RealizarLoginSucesso(LoginDTO login) {
        apiClient.postLogin(login)
                .statusCode(200);
    }
    @Test(dataProvider = "loginSucessoValidarToken", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSucessoValidarToken(LoginDTO login) {
        apiClient.postLogin(login)
                .statusCode(200)
            .body("token", is(notNullValue()));
    }
    @Test(dataProvider = "loginSucessoComAssertToken", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSucessoComAssertToken(LoginDTO login) {
        ValidatableResponse response =
                apiClient.postLogin(login)
                       .statusCode(200);
        String token = response.extract().path("token");
        System.out.println(token);
    }
    @Test(dataProvider = "loginSomenteComEmailValido", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSomenteComEmail(LoginDTO login) {
        Response response = apiClient.postLogin(login)
                .extract().response();
                 response.then()
                .statusCode(400);
        String mensagemDeErro = response.jsonPath().getString("error");
        String mensagemDeErroEsperada = "Missing password";
        Assert.assertEquals(mensagemDeErro, mensagemDeErroEsperada);
    }
    @Test(dataProvider = "loginSomenteComPasswordValido", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSomenteComPassword(LoginDTO login) {
        Response response = apiClient.postLogin(login)
                .extract().response();
                 response.then()
                .statusCode(400);
        String mensagemDeErro = response.jsonPath().getString("error");
        String mensagemDeErroEsperada = "Missing email or username";
        Assert.assertEquals(mensagemDeErro, mensagemDeErroEsperada);
    }
    @Test(dataProvider = "loginEmailEPasswordInvalidos", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginEmailEPasswordInvalidos(LoginDTO login) {
        Response response = apiClient.postLogin(login)
                .extract().response();
                response.then()
                .statusCode(400);
        String mensagemDeErro = response.jsonPath().getString("error");
        String mensagemDeErroEsperada = "user not found";
        Assert.assertEquals(mensagemDeErro, mensagemDeErroEsperada);
    }
    @Test(dataProvider = "loginEmailInvalidoESenhaValida", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginEmailInvalido(LoginDTO login) {
        Response response = apiClient.postLogin(login)
                .extract().response();
                 response.then()
                .statusCode(400);
        String mensagemDeErro = response.jsonPath().getString("error");
        String mensagemDeErroEsperada = "user not found";
        Assert.assertEquals(mensagemDeErro, mensagemDeErroEsperada);
    }
    @Test(dataProvider = "loginEmailEPasswordVazios", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginEmailEPasswordVazios(LoginDTO login) {
        Response response = apiClient.postLogin(login)
                .extract().response();
                 response.then()
                .statusCode(400);
        String mensagemDeErro = response.jsonPath().getString("error");
        String mensagemDeErroEsperada = "Missing email or username";
        Assert.assertEquals(mensagemDeErro, mensagemDeErroEsperada);
    }
}
