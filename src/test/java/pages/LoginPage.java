package pages;

import core.Driver;
import maps.LoginMap;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    LoginMap loginMap;

    public LoginPage() {
        loginMap = new LoginMap();
        PageFactory.initElements(Driver.getDriver(), loginMap);
    }

    public void setInpUserName(String userName) {
        if (userName != null) {
            loginMap.inpUserName.sendKeys(userName);
        }
    }
    public void setInpPassword(String password){
        if(password != null) {
            loginMap.inpPassword.sendKeys(password);
        }
    }
    public void clicarBtnLogin(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }
    public  String getTextUsuarioLogado(){
        Driver.visibilityOf(loginMap.textLogado);
        return loginMap.textLogado.getText();
    }

    public  String getTextUsuarioBloqueado(){
        Driver.visibilityOf(loginMap.textUsuarioBloqueado);
        return loginMap.textUsuarioBloqueado.getText();
    }
    public  String getTextDadosEmBranco(){
        Driver.visibilityOf(loginMap.textCamposEmBranco);
        return loginMap.textCamposEmBranco.getText();
    }

    public void telaLogada(){
        Driver.visibilityOf(loginMap.btnLogin);
        loginMap.btnLogin.click();
    }

}
