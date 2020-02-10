package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageErreurSup {

    private WebDriver driver;
    public PageErreurSup(WebDriver driver){
        this.driver = driver;
    }

    public String getErreurSupText(){
        return driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
    }

    public String getErreurSupDemande(){
        String temp = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
        temp = temp.substring(14);
        int i = temp.indexOf(" ");
        temp = temp.substring(0, i);

        return temp;
    }

    public String getErreurSupMax(){
        String temp = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
        int i = temp.lastIndexOf(" ")+1;
        int j = temp.length();
        temp = temp.substring(i, j);

        return temp;
    }
}
