import com.thoughtworks.gauge.Step;
import org.openqa.selenium.Keys;


import static org.junit.Assert.assertEquals;

public class StepImplementation {

    @Step("User go to main page")
    public void goToMainPage() {

        common.goToUrl("main_page");
    }

    @Step("User write <searchKey> in the search bar and search")
    public void gotoGetStartedPage(final String searchkey) throws InterruptedException {
        common.findElement("search_box").sendKeys(searchkey);
        common.findElement("search_box").sendKeys(Keys.ENTER);
    }

    @Step("The user clicks on the product and goes to the detail page")
    public void productAddToBasket() {
        String titleText = common.findElement("search_page_result").getText();
        assertEquals("Detaylı Arama", titleText);
        common.findElement("product").click();
        common.getDriverWait();
    }

    @Step("User add the product the cart <unit>")
    public void addToBasket(final String unit) {
        common.getDropDownElement("dropdown_box").selectByValue(unit);
        common.findElement("btn_add_cart").click();
        String succesText = common.findElement("succesful_message_for_addto_product").getText();
        assertEquals("SEPETİNİZE EKLENMİŞTİR", succesText);

    }

    @Step("User should see the added product in the cart")
    public void goToSepetPage() {
        common.goToUrl("cart_url");
        common.getDriverWait();
        String value = common.findElement("cart_unit_value").getAttribute("value");
        assertEquals("5",value);
        common.getDriverWait();
    }
}
