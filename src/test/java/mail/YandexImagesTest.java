package mail;

import mail.pageobjects.ItSeemsPage;
import mail.pageobjects.YandexImagesPage;
import mail.pageobjects.YandexMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YandexImagesTest {

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkItSeemsPanel() {
        YandexMainPage mainPage = new YandexMainPage(driver);
        mainPage.openPage();
        YandexImagesPage images = mainPage.goToYandexImages();
        images.goToSearch();
        ItSeemsPage itSeems = images.uploadImage("src/main/resources/img/test-file.jpeg");
        ArrayList<String> tags = itSeems.getAllTags();

        assertTrue(isTagPresent(tags, "автокран"));
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

    private boolean isTagPresent(List<String> allTags, String tagName) {
        Pattern pattern = Pattern.compile(tagName);

        for (String tag : allTags) {
            Matcher matcher = pattern.matcher(tag);

            if (matcher.find()) {
                return true;
            }
        }

        return false;
    }
}
