package randomTest;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.*;
import page.*;
import verify.Verify;

import java.util.concurrent.TimeUnit;

public class AccesPageTest {
    static WebDriver driver;
    static Random random;
    static Recherche recherche;
    static PageErreurInvalide pageErreurInvalide;
    static PageErreurSup pageErreurSup;
    static PlayingCard playingCard;
    static Resultat resultat;

    private String URL = "https://www.random.org/playing-cards/";
    private String dossier = "acces_page\\";

    @Test
    public void accesBouton(){
        random.getButtoncard().click();
        Verify.verifyUrl(driver, URL, dossier+"accesBouton");
    }
    @Test
    public void accesUrlPagePrincipale(){
        driver.navigate().to(URL);
        Verify.verifyUrl(driver, URL, dossier+"accesUrlPagePrincipale");
    }
    @Test
    public void accesUrlPageDice(){
        driver.navigate().to("https://www.random.org/dice/");
        driver.navigate().to(URL);
        Verify.verifyUrl(driver, URL, dossier+"accesUrlPageDice");
    }
    @Ignore
    @Test
    public void accesOngletPagePrincipale(){
        Actions action = new Actions(driver);
        action.moveToElement(random.getOngletGame()).build().perform();
        random.getOngletCard().click();
        Verify.verifyUrl(driver, URL, dossier+"accesOngletPagePrincipale");
    }
    @Ignore
    @Test
    public void accesOngletPageDice(){
        driver.navigate().to("https://www.random.org/dice/");
        Actions action = new Actions(driver);
        action.moveToElement(random.getOngletGame()).build().perform();
        random.getOngletCard().click();
        Verify.verifyUrl(driver, URL, dossier+"aaccesOngletPageDice");
    }


    @Before
    public void before(){
        driver.navigate().to("https://www.random.org/");

    }

    @BeforeClass
    public static void setUp(){

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--disable-notifications");
        //options.addArguments("start-maximized");

        //System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");

        //driver = new ChromeDriver(options);

        driver = new HtmlUnitDriver();

        //driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        random = new Random(driver);
        recherche = new Recherche(driver);
        pageErreurInvalide = new PageErreurInvalide(driver);
        pageErreurSup = new PageErreurSup(driver);
        playingCard = new PlayingCard(driver);
        resultat = new Resultat(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
