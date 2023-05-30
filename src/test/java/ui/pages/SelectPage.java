package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import ui.wait.Wait;

public class SelectPage extends PageBase {

    Wait wait;

    public SelectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "withOptGroup")
    WebElement withOptGroup;

    @FindBy(id = "react-select-2-input")
    WebElement firstInput;

    @FindBy(id = "react-select-4-input")
    WebElement multiSelectDropDown;

    @FindBy(id = "selectOne")
    WebElement secondInput;

    @FindBy(css = "[class=' css-yk16xz-control']")
    WebElement thirdInput;

    public void goToSelectPage() {
        driver.get("https://demoqa.com/select-menu");
        wait = new Wait(driver);
        wait.forVisibility(withOptGroup);
    }

    public void selectInFirstInput(String inputValue) {
        driver.findElement(By.id("withOptGroup")).click();
        wait.forVisibility(firstInput);
        driver.findElement(By.id("react-select-2-input")).sendKeys(inputValue);
        driver.findElement(By.id("react-select-2-input")).sendKeys(Keys.ENTER);

    }

    public void selectOld(String value) {
        WebElement selectElement = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(selectElement);
        select.selectByValue(value);
        select.selectByIndex(0);
        select.selectByVisibleText("Green");
    }

    public void selectMulti() {
        WebElement selectElement = driver.findElement(By.id("cars"));
        Select select = new Select(selectElement);
        select.selectByValue("opel");
        select.selectByValue("audi");

    }

    public void multiSelectDD(String inputValue) {
        driver.findElement(By.cssSelector("[class=' css-2b097c-container']")).click();
        //     wait.forVisibility(thirdInput);
        driver.findElement(By.id("react-select-4-input")).sendKeys(inputValue);
        driver.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);

    }

    public void cleanInput() {
        driver.findElement(By.xpath("(//*[@class='css-19bqh2r'])[5]")).click();
    }

    public void selectSecondInput(String inputValue) {
        driver.findElement(By.id("selectOne")).click();
        wait.forVisibility(secondInput);
        driver.findElement(By.id("react-select-3-input")).sendKeys(inputValue);
        driver.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }
}
