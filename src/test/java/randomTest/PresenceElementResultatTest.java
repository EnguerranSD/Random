package randomTest;

import org.junit.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import page.*;
import verify.Verify;

import java.util.concurrent.TimeUnit;

public class PresenceElementResultatTest {
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
    public void presenceNombreDraw(){
        Assert.assertEquals("1", resultat.getLigne1NombrePioche());
    }
    @Test
    public void presenceNombreMax(){
        Assert.assertEquals("52", resultat.getLigne1NombreMax());
    }
    @Test
    public void presenceUndrawn(){
        Assert.assertEquals("51", resultat.getUndrawnValue());
    }
    @Test
    public void presenceResultat(){
        Assert.assertTrue(resultat.getResultat(1).contains("of"));
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

        driver.navigate().to("https://www.random.org/playing-cards/");
        playingCard.getCardsAsText().click();
        playingCard.getDrawCards().click();
    }

    @AfterClass
    public static void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
