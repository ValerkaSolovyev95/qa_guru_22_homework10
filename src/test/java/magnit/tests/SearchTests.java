package magnit.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

@Tag("Web")
public class SearchTests extends BaseTest {

    @ParameterizedTest(name = "Find product {0}")
    @ValueSource(strings = {"картофель", "морковь", "капуста"})
    void findingProductValueSourceTests(String product) {
        mainPage.findProduct(product)
                .checkCatalogVisible();
    }

    @ParameterizedTest(name = "Find product = {0}, product name = {1}")
    @CsvSource(value = {"картофель, Картофель фасованный", "морковь, Морковь мытая", "капуста, КАПУСТА белокочанная 1кг"})
    void findingProductCsvSourceTests(String product, String expectedProduct) {
        mainPage.findProduct(product)
                .checkResult(expectedProduct);
    }

    @ParameterizedTest(name = "Find product = {0}, product name = {1}")
    @CsvFileSource(resources = "product.csv")
    void findingProductCsvFileSourceTests(String product, String expectedProduct) {
        mainPage.findProduct(product)
                .checkResult(expectedProduct);
    }

    static Stream<Arguments> findingProductsMethodSource() {
        return Stream.of(
                Arguments.of("картофель", List.of("Картофель фасованный", "Картофель красный мытый",
                        "Картофель Беби", "Картофель для варки", "Картофель белорусский", "Картофель",
                        "Картофель Синеглазка", "Картофель для жарки", "Картофель Шарики пастеризованный",
                        "Картофель пастеризованный с соусом Сливочный", "Картофель отварной в вакууме",
                        "Картофель Кримм Чили с беконом пастеризованный с соусом", "Картофель фри со специями (мс)(СП ГМ)",
                        "КАРТОФЕЛЬ ФРИ со специями (СП ГМ)")),
                Arguments.of("морковь", List.of("Морковь мытая", "Морковь отварная кубик", "Морковь",
                        "Морковь мытая для сока", "Консервы мясорастительные МЕДОВЫЙ ДОМ кролик-патиссон-морковь"))
        );
    }

    @ParameterizedTest(name = "Find product = {0}, products name = {1}")
    @MethodSource
    void findingProductsMethodSource(String product, List<String> expectedProducts) {
        mainPage.findProduct(product)
                .checkResult(expectedProducts);
    }
}
