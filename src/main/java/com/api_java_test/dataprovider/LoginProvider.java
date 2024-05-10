package com.api_java_test.dataprovider;
import com.api_java_test.dto.LoginDTO;
import org.testng.annotations.DataProvider;

public class LoginProvider {
    @DataProvider(name = "loginSucesso")
    public static Object[][] loginSucesso() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginSucessoValidarToken")
    public static Object[][] loginSucessoValidarToken() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginSucessoComAssertToken")
    public static Object[][] loginSucessoComAssertToken() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginSomenteComEmailValido")
    public static Object[][] loginSomenteComEmailValido() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginSomenteComPasswordValido")
    public static Object[][] loginSomenteComPasswordValido() {
        LoginDTO login = new LoginDTO("", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginEmailEPasswordInvalidos")
    public static Object[][] loginEmailEPasswordInvalidos() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.comm", "citysli");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginEmailInvalidoESenhaValida")
    public static Object[][] loginEmailInvalidoESenhaValida() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.comm", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginEmailEPasswordVazios")
    public static Object[][] loginEmailEPasswordVazios() {
        LoginDTO login = new LoginDTO("", "");
        return new Object[][]{
                {login}
        };
    }
}
