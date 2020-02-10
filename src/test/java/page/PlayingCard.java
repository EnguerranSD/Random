package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PlayingCard {

    private WebDriver driver;

    public PlayingCard(WebDriver driver){this.driver=driver;}

    public String getBody(){
        return driver.findElement(By.tagName("body")).getText();
    }

    public WebElement getDraw(){
        return driver.findElement(By.xpath("/html/body/div/form/p[1]/input"));
    }

    public WebElement getDrawClear(){
        WebElement element = driver.findElement(By.xpath("/html/body/div/form/p[1]/input"));
        element.clear();
        return element;
    }

    public Select getDeckSelect(){
        return new Select(driver.findElement(By.xpath("/html/body/div/form/p[1]/select")));
    }

    public WebElement getDrawCards(){
        return driver.findElement(By.xpath("/html/body/div/form/p[6]/input[1]"));
    }

    public WebElement getReset(){
        return driver.findElement(By.xpath("/html/body/div/form/p[6]/input[2]"));
    }

    public WebElement getSpades(){
        return driver.findElement(By.name("spades"));
    }
    public WebElement gethearts(){
        return driver.findElement(By.name("hearts"));
    }
    public WebElement getDiamonds(){
        return driver.findElement(By.name("diamonds"));
    }
    public WebElement getClubs(){
        return driver.findElement(By.name("clubs"));
    }
    public WebElement getAces() {
        return driver.findElement(By.name("aces"));
    }
    public WebElement getTwos() {
        return driver.findElement(By.name("twos"));
    }
    public WebElement getThrees() {
        return driver.findElement(By.name("threes"));
    }
    public WebElement getFours() {
        return driver.findElement(By.name("fours"));
    }
    public WebElement getFives() {
        return driver.findElement(By.name("fives"));
    }
    public WebElement getSixes() {
        return driver.findElement(By.name("sixes"));
    }
    public WebElement getSevens() {
        return driver.findElement(By.name("sevens"));
    }
    public WebElement getEights() {
        return driver.findElement(By.name("eights"));
    }
    public WebElement getNines() {
        return driver.findElement(By.name("nines"));
    }
    public WebElement getTens() {
        return driver.findElement(By.name("tens"));
    }
    public WebElement getJacks() {
        return driver.findElement(By.name("jacks"));
    }
    public WebElement getQueens() {
        return driver.findElement(By.name("queens"));
    }
    public WebElement getKings() {
        return driver.findElement(By.name("kings"));
    }
    public WebElement getBlackJoker() {
        return driver.findElement(By.name("bjoker"));
    }
    public WebElement getRedJoker() {
        return driver.findElement(By.name("rjoker"));
    }
    public WebElement getShowRemaingCard() {
        return driver.findElement(By.name("remaining"));
    }
    public WebElement getCardsAsText() {
        return driver.findElement(By.xpath("/html/body/div/form/p[4]/input[2]"));
    }
    public void unselectAll(){
        getAces().click();
        getTwos().click();
        getThrees().click();
        getFours().click();
        getFives().click();
        getSixes().click();
        getSevens().click();
        getEights().click();
        getNines().click();
        getTens().click();
        getJacks().click();
        getQueens().click();
        getKings().click();
    }
}
