package magnit.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import magnit.pages.MainPage;
import magnit.pages.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;
import static magnit.test_data.TestData.MAGNIT_URL;

public class BaseTest {
     MainPage mainPage = new MainPage();
     SearchPage searchPage = new SearchPage();

    @BeforeAll
    static void setup() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = MAGNIT_URL;
    }

    @AfterEach
    void afterEach() {
        Selenide.closeWebDriver();
    }
}
