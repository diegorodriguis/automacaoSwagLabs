package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginMap {
    @FindBy(id = "user-name")
    public WebElement inpUserName;
    @FindBy(id = "password")
    public WebElement inpPassword;
    @FindBy(id = "login-button")
    public WebElement btnLogin;
    @FindBy(css = "[class='app_logo']")
    public WebElement textLogado;
    @FindBy(css = "[data-test='error']")
    public WebElement textUsuarioBloqueado;
    @FindBy(css = "[class='error-message-container error']")
    public WebElement textCamposEmBranco;

}
