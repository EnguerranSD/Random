package randomTest;

import org.junit.*;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import page.*;
import verify.Verify;

import java.util.concurrent.TimeUnit;

public class MoteurTest {
    static WebDriver driver;
    static Random random;
    static Recherche recherche;
    static PageErreurInvalide pageErreurInvalide;
    static PageErreurSup pageErreurSup;
    static PlayingCard playingCard;
    static Resultat resultat;

    private String URL = "https://www.random.org/playing-cards/";
    private String dossier = "moteur\\";

    @Test
    public void erreurZeroCartes(){
        playingCard.getDrawClear().sendKeys("0");
        playingCard.getDrawCards().click();
        Assert.assertTrue(pageErreurInvalide.getErreurInvalideText().contains("The cards value must be an integer in the"));
    }

    @Test
    public void TropDeCarte(){
        playingCard.getDrawClear().sendKeys("102");
        playingCard.getDrawCards().click();
        Assert.assertTrue(pageErreurSup.getErreurSupText().contains("cards to be drawn but the deck configuration you chose only"));
    }
    @Test
    public void erreurString(){
        playingCard.getDrawClear().sendKeys("azfa");
        playingCard.getDrawCards().click();
        Assert.assertTrue(pageErreurInvalide.getErreurInvalideText().contains("The cards value must be an integer in the"));
    }
    @Test
    public void erreurFloat(){
        playingCard.getDrawClear().sendKeys("0.58");
        playingCard.getDrawCards().click();
        Assert.assertTrue(pageErreurInvalide.getErreurInvalideText().contains("The cards value must be an integer in the"));
    }
    @Test
    public void spades(){
        playingCard.getDrawClear().sendKeys("13");
        playingCard.gethearts().click();
        playingCard.getDiamonds().click();
        playingCard.getClubs().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<=13; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Spades"));
        }

    }
    @Test
    public void hearts(){
        playingCard.getDrawClear().sendKeys("13");
        playingCard.getSpades().click();
        playingCard.getDiamonds().click();
        playingCard.getClubs().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<=13; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Hearts"));
        }

    }
    @Test
    public void diamonds(){
        playingCard.getDrawClear().sendKeys("13");
        playingCard.getSpades().click();
        playingCard.gethearts().click();
        playingCard.getClubs().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<=13; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Diamonds"));
        }

    }
    @Test
    public void clubs(){
        playingCard.getDrawClear().sendKeys("13");
        playingCard.getSpades().click();
        playingCard.getDiamonds().click();
        playingCard.gethearts().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<=13; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Clubs"));
        }

    }
    @Test
    public void aces(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getAces().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Ace"));
        }

    }
    @Test
    public void twos(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getTwos().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Two"));
        }

    }
    @Test
    public void threes(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getThrees().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Three"));
        }

    }
    @Test
    public void fours(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getFours().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Four"));
        }

    }
    @Test
    public void fives(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getFives().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Five"));
        }

    }
    @Test
    public void sixes(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getSixes().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Six"));
        }

    }
    @Test
    public void sevens(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getSevens().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Seven"));
        }

    }
    @Test
    public void eights(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getEights().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Eight"));
        }

    }
    @Test
    public void nines(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getNines().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Nine"));
        }

    }
    @Test
    public void tens(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getTens().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Ten"));
        }

    }
    @Test
    public void jacks(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getJacks().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Jack"));
        }

    }
    @Test
    public void queens(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getQueens().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("Queen"));
        }

    }
    @Test
    public void kings(){
        playingCard.getDrawClear().sendKeys("4");
        playingCard.unselectAll();
        playingCard.getKings().click();
        playingCard.getDrawCards().click();
        for (int i=1; i<5; i++){
            Assert.assertTrue(resultat.getResultat(i).contains("King"));
        }

    }
    @Test
    public void jokers(){
        playingCard.getDrawClear().sendKeys("2");
        playingCard.unselectAll();
        playingCard.getRedJoker().click();
        playingCard.getBlackJoker().click();
        playingCard.getDrawCards().click();
        Assert.assertTrue(resultat.getResultat(1).contains("Joker"));
        Assert.assertTrue(resultat.getResultat(2).contains("Joker"));
    }

    @Before
    public void before(){
        driver.navigate().to(URL);
        playingCard.getCardsAsText().click();
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
