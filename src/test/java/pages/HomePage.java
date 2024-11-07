package pages;

import core.Driver;
import maps.HomePageMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class HomePage {

    private WebDriver driver;
    HomePageMap homePageMap;
    public HomePage() {
        homePageMap = new HomePageMap();
        PageFactory.initElements(Driver.getDriver(), homePageMap);
    }

    public void selectToCarrinho(){
       homePageMap.slcToCarrinho.click();
    }
    public void selectItemBakcpak(){
       homePageMap.slcBackpackToCarrinho.isDisplayed();
       homePageMap.slcBackpackToCarrinho.click();
    }

}
