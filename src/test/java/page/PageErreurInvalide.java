package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageErreurInvalide {

    private WebDriver driver;

    public PageErreurInvalide(WebDriver driver){this.driver = driver;}

    public String getErreurInvalideText(){
        return driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
    }

    public String getErreurInvalideMax(){
        String temp = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
        int i = temp.indexOf(",")+1;
        int j = temp.indexOf("]");
        return temp.substring(i, j);
    }


}
