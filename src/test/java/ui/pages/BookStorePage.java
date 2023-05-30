package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ui.wait.Wait;

import java.util.List;

public class BookStorePage extends PageBase {

    Wait wait;

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "rt-tbody")
    WebElement bookStore;

    @FindBy(tagName = "placeholder")
    WebElement inputSearch;

    @FindBy(className = "[class = 'rt-tr-group']")
    List<WebElement> books;

    @FindBy(xpath = "(//*[@class='rt-resizable-header-content'][contains(text(), 'Image')])")
    WebElement sortByImage;

    @FindBy(xpath = "(//*[@class='rt-resizable-header-content'][contains(text(), 'Title')])")
    WebElement sortByTitle;

    @FindBy(xpath = "(//*[@class='rt-resizable-header-content'][contains(text(), 'Author')])")
    WebElement sortByAuthor;

    @FindBy(xpath = "(//*[@class='rt-resizable-header-content'][contains(text(), 'Publisher')])")
    WebElement sortByPublisher;

    @FindBy(className = "element-group")
    List<WebElement> elementGroups;


    public boolean goToBookStore() {
        return bookStore.isDisplayed();
    }

    public void inputSearchText() {
        fillField(inputSearch, "Git");
    }

}
