package magnit.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import magnit.tests.BaseTest;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    SelenideElement catalog = $(".catalog-page__sort-grid__search");
    
    public SearchPage checkResult(String text) {
        catalog.shouldHave(Condition.text(text));
        return this;
    }

    public SearchPage checkResult(List<String> texts) {
        $$(".catalog-page__sort-grid__search a").filter(Condition.visible).shouldHave(CollectionCondition.texts(texts));
        return this;
    }

    public SearchPage checkCatalogVisible() {
        catalog.should(Condition.visible);
        return this;
    }
}
