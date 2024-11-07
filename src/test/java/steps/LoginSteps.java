package steps;

import core.Driver;
import enums.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import maps.LoginMap;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

import java.io.IOException;
import java.util.Map;

public class LoginSteps {

    LoginPage loginPage;
    String userName;

    @Before
    public void iniciarNavegador(Scenario scenario){
        new Driver(Browser.CHROME);
        Driver.setNameScenario(scenario.getName());
        Driver.creatDirectory();
    }
    @After
    public void fecharNavegador(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            Driver.printScreen("Error - Momento que houve a falha no cenario");
        }
        Driver.getDriver().quit();
    }

    @Quando("os campos de login sejam preechidos da seguinte forma")
    public void osCamposDeLoginSejamPreechidosDaSeguinteForma(Map<String, String> map) throws IOException {
        Driver.getDriver().get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        userName = map.get("login");
        String password = map.get("password");

        loginPage.setInpUserName(userName);
        loginPage.setInpPassword(password);

        Driver.printScreen("Preenchimento dos campos de login");
    }
    @Quando("for realizado o clique no botao sign in")
    public void forRealizadoOCliqueNoBotaoSignIn() {
        loginPage.clicarBtnLogin();

    }
    @Entao("deve ser logado no sistema")
    public void deveSerLogadoNoSistema() throws IOException {
        Assert.assertEquals("Swag Labs", loginPage.getTextUsuarioLogado());
        Driver.printScreen("Tela de usuario logado no sistema");

    }
    @Entao("valido alert de usuario bloqueado")
    public void validoAlertDeUsuarioBloqueado() throws IOException {
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", loginPage.getTextUsuarioBloqueado());
        Driver.printScreen("Tela de login com alert de bloqueio do usuario");
    }
    @Entao("aguardo o timeout programado")
    public void aguardoOTimeoutProgramado() {
        loginPage.getTextUsuarioLogado();
    }
    @Entao("valido alert de dados em branco")
    public void validoAlertDeDadosEmBranco() throws IOException {
        Assert.assertEquals("Epic sadface: Username is required", loginPage.getTextDadosEmBranco());
        Driver.printScreen("Tela de login com alert de usuario dados em branco");
    }
    @Entao("valido alert de password em branco")
    public void validoAlertDePasswordEmBranco() throws IOException {
        Assert.assertEquals("Epic sadface: Password is required", loginPage.getTextDadosEmBranco());
        Driver.printScreen("Tela de login com alert de usuario dados em branco");
    }






}
