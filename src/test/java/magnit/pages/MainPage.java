package magnit.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    SelenideElement searchField = $("[placeholder=\"Искать товары\"]"),
    searchButton = $("form.new-header-search-form.js-search-form.new-header-search-form__open");

    public MainPage openPage() {
        open("/");
        return this;
    }

    public MainPage findProduct(String text) {
        searchField.setValue(text);
        searchButton.$(ByAll.linkText("Найти")).click();
        return this;
    }
}
