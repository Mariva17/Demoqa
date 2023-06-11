package e2e;

import org.testng.annotations.Test;
import ui.TestBase;
import ui.pages.WebTablesPage;

public class WebTablesTests extends TestBase {

    WebTablesPage webTablesPage;

    @Test
    public void checkTypeToSearchByName() {
        webTablesPage = new WebTablesPage(app.driver);
        webTablesPage.goToWebTables();
        webTablesPage.filterByName("Vega");
        webTablesPage.checkFilterByName("Vega");
    }


}
