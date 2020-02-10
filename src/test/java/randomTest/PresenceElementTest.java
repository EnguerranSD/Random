package randomTest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import page.*;
import verify.Verify;

import java.util.concurrent.TimeUnit;

public class PresenceElementTest {
    static WebDriver driver;
    static Random random;
    static Recherche recherche;
    static PageErreurInvalide pageErreurInvalide;
    static PageErreurSup pageErreurSup;
    static PlayingCard playingCard;
    static Resultat resultat;

    private String URL = "https://www.random.org/playing-cards/";
    private String dossier = "presence_page_selection\\";

    @Test
    public void presenceStepText(){
        Verify.verifyTextPresent(driver, "Step 1: Number of Cards", dossier+"presenceStepText");
        Verify.verifyTextPresent(driver, "Step 2: Deck Configuration", dossier+"presenceStepText");
        Verify.verifyTextPresent(driver, "Step 3: Display Options", dossier+"presenceStepText");
        Verify.verifyTextPresent(driver, "Step 4: Go!", dossier+"presenceStepText");
    }

    @Test
    public void presenceQuestion(){
        Verify.verifyTextPresent(driver, "Which suits should be included?", dossier+"presenceQuestion");
        Verify.verifyTextPresent(driver, "Which cards should be included?", dossier+"presenceQuestion");
        Verify.verifyTextPresent(driver, "Do you want to include jokers?", dossier+"presenceQuestion");
        Verify.verifyTextPresent(driver, "Your cards will be shown in the order drawn. You can choose from the following extra options:", dossier+"presenceQuestion");
        Verify.verifyTextPresent(driver, "Be patient! It may take a little while to draw your cards...", dossier+"presenceQuestion");
    }

    @Test
    public void presenceBoutons(){
        Verify.verifyElementPresent(driver, By.name("spades"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("hearts"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("diamonds"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("clubs"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("aces"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("twos"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("threes"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("fours"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("fives"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("sixes"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("sevens"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("eights"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("nines"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("tens"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("jacks"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("queens"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("kings"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("bjoker"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("rjoker"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("remaining"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.name("text"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.xpath("/html/body/div/form/p[6]/input[1]"), dossier+"presenceBoutons");
        Verify.verifyElementPresent(driver, By.xpath("/html/body/div/form/p[6]/input[2]"), dossier+"presenceBoutons");
    }

    @Before
    public void before(){
        driver.navigate().to(URL);
    }

    @BeforeClass
    public static void setUp(){

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-notifications");
//        options.addArguments("start-maximized");
//
//        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
//
//        driver = new ChromeDriver(options);
        driver = new HtmlUnitDriver();

        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

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
