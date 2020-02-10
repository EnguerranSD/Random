package verify;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import page.Resultat;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Verify {

    public static void verifyElementPresent(WebDriver driver, By locator, String chemin){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            driver.findElement(locator);
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        }catch (NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                System.out.println("test");
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e2){
                e2.printStackTrace();
            }
            fail("L'élèment n'est pas présent");
        }
    }

    public static void verifyTextPresent(WebDriver driver, String text, String chemin){
        String body = driver.findElement(By.tagName("body")).getText();
        if (!body.contains(text)){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            fail("Le body ne contient pas ce texte");
        }
    }
    public static void verifyTextPresent(WebDriver driver, WebElement element,  String text, String chemin){
        String body = element.getText();
        if (!body.contains(text)){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            fail("Le body ne contient pas ce texte");
        }
    }

    public static void verifyUrl(WebDriver driver, String url, String chemin){
        String temp = driver.getCurrentUrl();
        if (!temp.equals(url)){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("URL atendue : "+url);
            System.out.println("URL acutelle : "+temp);
            fail("L'URL attendue ne correspond à l'URL actuelle");
        }
    }

    public static void verifyCaseCoche(WebDriver driver, WebElement element, String chemin){
        if (!element.isSelected()){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            fail("Le bouton n'est pas coché");
        }
    }
    public static void verifyCasePasCoche(WebDriver driver, WebElement element, String chemin){
        if (element.isSelected()){
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\IdeaProjects\\Random.org\\src\\test\\screen\\"+chemin+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
            fail("Le bouton n'est pas coché");
        }
    }

}
