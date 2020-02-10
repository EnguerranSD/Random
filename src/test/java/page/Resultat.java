package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Resultat {

    private WebDriver driver;

    public Resultat( WebDriver driver){
        this.driver = driver;
    }

    public String getLigne1(){
        return driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
    }

    public String getLigne1NombrePioche(){
        String txt = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
        String temp = txt.substring(13);
        int i = temp.indexOf(" ");
        return temp.substring(0, i);
    }

    public String getLigne1NombreMax(){
        String txt = driver.findElement(By.xpath("/html/body/div/p[1]")).getText();
        int i = txt.lastIndexOf(" ")+1;
        int j = txt.length()-1;
        return txt.substring(i, j);
    }

    public String getResultat(){
        String txt = driver.findElement(By.xpath("/html/body/div/p[2]")).getText();
        int i = txt.indexOf("(");
        return txt.substring(0, i);
    }

    public String getResultat(int ligne){
        String txt = "";
        try{
            txt = driver.findElement(By.xpath("/html/body/div/p[2]/span["+ligne+"]")).getText();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
        return txt;

    }

    public String getResultat(String ligne){
        String txt = "";
        try{
            txt = driver.findElement(By.xpath("/html/body/div/p[2]/span["+ligne+"]")).getText();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }
        return txt;

    }

    public String getUndrawnLine(){
        String txt = driver.findElement(By.xpath("/html/body/div/p[2]")).getText();
        int i = txt.indexOf("(");
        int j = txt.length();
        return txt.substring(i, j);
    }
    public String getUndrawnValue(){
        String txt = driver.findElement(By.xpath("/html/body/div/p[2]")).getText();
        int i = txt.indexOf("(")+1;
        String temp = txt.substring(i);
        int j = temp.indexOf(" ");
        return temp.substring(0, j);
    }

    public WebElement getAgainButton(){
        return driver.findElement(By.xpath("/html/body/div/form/input[22]"));
    }

    public WebElement getGoBackButton(){
        return driver.findElement(By.xpath("/html/body/div/form/input[22]"));
    }

}
