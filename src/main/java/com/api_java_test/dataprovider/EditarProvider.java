package com.api_java_test.dataprovider;
import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import org.testng.annotations.DataProvider;

public class EditarProvider {
    @DataProvider(name = "editarUsuarioComSucesso")
    public static Object[][] editarUsuarioComSucesso() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        EditarDTO editar = new EditarDTO("morpheus","zion resident");
        return new Object[][]{
                {editar, login}
        };
    }
    @DataProvider(name = "dadosParaEdicaoComSucessoUsuario")
    public static Object[][] dadosParaEdicaoComSucessoUsuario() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        EditarDTO patch = new EditarDTO("Camões Mendes","zicachain");
        return new Object[][]{
                {patch, login}
        };
    }
}
