package ua.mainacademy;

import org.openqa.selenium.WebDriver;
import ua.mainacademy.service.AmazonItemHandleService;
import ua.mainacademy.service.AmazonSearchService;
import ua.mainacademy.service.WebDriverService;
import ua.mainacademy.util.TimeoutUtil;

public class Application {

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverService.getWebDriver("https://www.amazon.com");
        webDriver = AmazonSearchService.getSearchResultPage(webDriver, "iphone 8");

        for (int i = 0; i < 5; i++) {
            if (AmazonSearchService.isItemPresent("B01NAW9E1R", webDriver)) {
                webDriver = AmazonSearchService.getItemPage("B01NAW9E1R", webDriver);
                webDriver = AmazonItemHandleService.addItemToCart(webDriver);
                break;
            } else {
                AmazonSearchService.getSearchNextPage(webDriver);
                TimeoutUtil.waitSeconds(3);
            }
        }
        webDriver.quit();
    }

}

