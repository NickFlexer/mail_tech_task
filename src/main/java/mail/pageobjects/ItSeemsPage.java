package mail.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ItSeemsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[contains(text(), \"Кажется, на картинке\")]")
    private WebElement itSeemsLabel;

    @FindBy(xpath = "//div[@class=\"Tags Tags_type_simple\"]/a")
    private List<WebElement> tags;

    public ItSeemsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);

        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(itSeemsLabel));
    }

    public ArrayList<String> getAllTags() {
        ArrayList<String> result = new ArrayList<>();

        for (WebElement tag : tags) {
            result.add(tag.getText());
        }

        return result;
    }
}
