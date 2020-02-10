package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Recherche {
    private WebDriver driver;

    public Recherche(WebDriver driver){
        this.driver=driver;
    }

    public WebElement getLien(){
        return driver.findElement(By.xpath("/html/body/div[2]/div[5]/div[3]/div/div[1]/div[5]/div[1]/div/h2/a[1]"));
    }
}
