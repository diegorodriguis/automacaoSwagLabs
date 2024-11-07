package steps;

import core.Driver;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;
import pages.CarrinhoPage;
import pages.HomePage;
import pages.LoginPage;

import java.io.IOException;
import java.util.Map;

public class CarrinhoSteps {

    HomePage homePage;
    CarrinhoPage carrinhoPage;

    @Entao("adiciono um item no carrinho")
    public void adicionoUmItemNoCarrinho() {
        homePage = new HomePage();
        homePage.selectItemBakcpak();
    }
    @Entao("acesso ao carrinho pela pagina principal")
    public void acessoAoCarrinhoPelaPaginaPrincipal() {
        homePage.selectToCarrinho();
    }
    @Entao("valido item adicionado com sucesso")
    public void validoItemAdicionadoComSucesso() throws IOException {
        carrinhoPage = new CarrinhoPage();
        Assert.assertEquals("Sauce Labs Backpack", carrinhoPage.getTextProductAddKart());
        Driver.printScreen("Tela de carrinho com produto adicionado");
    }
    @Entao("clico em remover do carrinho")
    public void clicoEmRemoverDoCarrinho() {
        carrinhoPage.clickRemoveBackpackTKart();
    }
    @Entao("valido carrinho vazio")
    public void validoCarrinhoVazio() {
        carrinhoPage.invisibleTextProductAddKart();
    }
}
