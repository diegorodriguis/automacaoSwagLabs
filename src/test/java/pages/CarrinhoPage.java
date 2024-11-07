package pages;

import core.Driver;
import maps.CarrinhoMap;
import maps.HomePageMap;
import org.openqa.selenium.support.PageFactory;

public class CarrinhoPage {
    CarrinhoMap carrinhoMap;
    public CarrinhoPage() {
        carrinhoMap = new CarrinhoMap();
        PageFactory.initElements(Driver.getDriver(), carrinhoMap);
    }

    public void clickRemoveBackpackTKart(){
        Driver.visibilityOf(carrinhoMap.clickRemoveBackpaackToKart);
        carrinhoMap.clickRemoveBackpaackToKart.click();
    }
    public String getTextProductAddKart(){
        Driver.visibilityOf(carrinhoMap.textProductInKart);
        return carrinhoMap.textProductInKart.getText();
    }
    public void invisibleTextProductAddKart(){
       Driver.invisibilityOf(carrinhoMap.textProductInKart);
    }

}
