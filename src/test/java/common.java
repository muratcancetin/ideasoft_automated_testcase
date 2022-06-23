import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class common {

    public static WebElement findElement(final String locator){
        String cssSelector = System.getenv(locator);
        final WebElement element = Driver.webDriver.findElement(By.cssSelector(cssSelector));
        return element;
    }
    public static Select getDropDownElement(final String locator){
        return new Select(findElement(locator));
    }
    public static void getDriverWait(){
        Driver.webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void goToUrl(final String url){
        String app_url = System.getenv(url);
        Driver.webDriver.get(app_url);
        getDriverWait();
    }
}
