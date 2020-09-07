package mail.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YandexMainPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@style, \"kartinki\")]")
    private WebElement imageBtn;

    public YandexMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        driver.get("https://yandex.ru/");
    }

    public YandexImagesPage goToYandexImages() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(imageBtn));
        imageBtn.click();
        return new YandexImagesPage(driver);
    }
}
