package mail.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;

public class YandexImagesPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class=\"websearch-button__text\"]")
    private WebElement websearchBtn;

    @FindBy(xpath = "//button[contains(@aria-label, \"Поиск по картинке\")]")
    private WebElement searchByImageBtn;

    @FindBy(xpath = "//input[@name=\"upfile\"]")
    private WebElement uploadFileBtn;

    @FindBy(xpath = "//div[@class=\"cbir-panel__close-icon\"]")
    private WebElement cloceIcon;

    public YandexImagesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void goToSearch() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(websearchBtn));
        websearchBtn.click();
    }

    public ItSeemsPage uploadImage(String filePath) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(searchByImageBtn));
        searchByImageBtn.click();
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(cloceIcon));
        uploadFileBtn.sendKeys(new File(filePath).getAbsolutePath());

        return new ItSeemsPage(driver);
    }
}
