package randomTest;

import org.junit.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import page.*;
import verify.Verify;

import java.util.concurrent.TimeUnit;

public class ValeurDefautTest {
    static WebDriver driver;
    static Random random;
    static Recherche recherche;
    static PageErreurInvalide pageErreurInvalide;
    static PageErreurSup pageErreurSup;
    static PlayingCard playingCard;
    static Resultat resultat;

    private String URL = "https://www.random.org/playing-cards/";
    private String dossier = "valeur_defaut\\";

    @Test
    public void caseCoche(){
        Verify.verifyCaseCoche(driver, playingCard.getSpades(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.gethearts(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getDiamonds(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getClubs(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getAces(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getTwos(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getThrees(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getFours(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getFives(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getSixes(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getSevens(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getEights(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getNines(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getTens(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getJacks(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getQueens(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getKings(), dossier+"caseCoche");
        Verify.verifyCaseCoche(driver, playingCard.getShowRemaingCard(), dossier+"caseCoche");
    }

    @Test
    public void caseNonCoche(){
        Verify.verifyCasePasCoche(driver, playingCard.getBlackJoker(), dossier+"caseNonCoche");
        Verify.verifyCasePasCoche(driver, playingCard.getRedJoker(), dossier+"caseNonCoche");
        Verify.verifyCasePasCoche(driver, playingCard.getCardsAsText(), dossier+"caseNonCoche");
    }

    @Test
    public void nombreDrawDefaut(){
        playingCard.getDrawCards().click();
        Assert.assertEquals("1", resultat.getLigne1NombrePioche());
    }
    @Test
    public void nombreDeckDefaut(){
        playingCard.getDrawCards().click();
        Assert.assertEquals("52", resultat.getLigne1NombreMax());
    }

    @Test
    public void testReset(){
        playingCard.getClubs().click();
        playingCard.getAces().click();
        playingCard.getFives().click();
        playingCard.getRedJoker().click();
        playingCard.getCardsAsText().click();

        playingCard.getReset().click();

        Verify.verifyCaseCoche(driver, playingCard.getClubs(), dossier+"testReset");
        Verify.verifyCaseCoche(driver, playingCard.getAces(), dossier+"testReset");
        Verify.verifyCaseCoche(driver, playingCard.getFives(), dossier+"testReset");
        Verify.verifyCasePasCoche(driver, playingCard.getRedJoker(), dossier+"testReset");
        Verify.verifyCasePasCoche(driver, playingCard.getCardsAsText(), dossier+"testReset");

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
