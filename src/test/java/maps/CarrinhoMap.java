package maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CarrinhoMap {

    @FindBy(css = "[class='inventory_item_name']")
    public WebElement textProductInKart;
    @FindBy(name = "remove-sauce-labs-backpack")
    public WebElement clickRemoveBackpaackToKart;
}
