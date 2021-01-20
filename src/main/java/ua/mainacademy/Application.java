package ua.mainacademy;

import org.openqa.selenium.WebDriver;
import ua.mainacademy.service.AmazonItemHandleService;
import ua.mainacademy.service.AmazonSearchService;
import ua.mainacademy.service.WebDriverService;

public class Application {

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverService.getWebDriver("https://www.amazon.com");
        webDriver = AmazonSearchService.getSearchResultPage(webDriver, "iphone 8");

        if (AmazonSearchService.isItemPresent("123", webDriver)) {
            webDriver = AmazonSearchService.getItemPage("123", webDriver);
            webDriver = AmazonItemHandleService.addItemToCart(webDriver);
        } else {
            AmazonSearchService.getSearchNextPage(webDriver);
        }
        webDriver.quit();
    }

}

