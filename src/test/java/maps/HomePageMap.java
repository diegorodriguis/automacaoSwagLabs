package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageMap {
    @FindBy(css = "[class='shopping_cart_link']")
    public WebElement slcToCarrinho;
    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    public WebElement slcBackpackToCarrinho;
}
