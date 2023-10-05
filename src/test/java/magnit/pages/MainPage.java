package magnit.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    SelenideElement searchField = $("[placeholder=\"Искать товары\"]"),
    searchButton = $("form.new-header-search-form.js-search-form.new-header-search-form__open"),
    catalog = $(".catalog-page__sort-grid__search");

    public MainPage findProduct(String text) {
        searchField.setValue(text).pressEnter();
        searchButton.$(ByAll.linkText("Найти")).click();
        return this;
    }

    public MainPage checkResult(String text) {
        catalog.shouldHave(Condition.text(text));
        return this;
    }

    public MainPage checkResult(List<String> texts) {
        $$(".catalog-page__sort-grid__search a").filter(Condition.visible).shouldHave(CollectionCondition.texts(texts));
        return this;
    }

    public MainPage checkCatalogVisible() {
        catalog.should(Condition.visible);
        return this;
    }
}
