package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Random {

    private WebDriver driver;

    public Random(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getRechercheInput(){
        return driver.findElement(By.name("q"));
    }

    public WebElement getRechercheGoButton(){
        return driver.findElement(By.xpath("/html/body/div/div[1]/form/div/input[2]"));
        //return driver.findElement(By.ByCssSelector)
    }

    public WebElement getOngletGame(){
        return driver.findElement(By.xpath("/html/body/div/ul/li[2]/a"));
    }

    public WebElement getOngletCard(){
        return driver.findElement(By.xpath("/html/body/div/ul/li[2]/ul/li[5]/a"));
    }

    public WebElement getButtoncard(){
        return driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/p/a[5]"));
    }
}
