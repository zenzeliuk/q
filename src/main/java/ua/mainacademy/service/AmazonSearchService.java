package ua.mainacademy.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.mainacademy.util.TimeoutUtil;

import java.util.List;

public class AmazonSearchService {

    public static WebDriver getSearchResultPage(WebDriver webDriver, String keyWord) {
        WebElement searchInput = webDriver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys(keyWord);
        TimeoutUtil.waitSeconds(3);
        WebElement searchButton = webDriver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        TimeoutUtil.waitSeconds(3);
        String currentUrl = webDriver.getCurrentUrl();
        webDriver.get(currentUrl);
        return webDriver;
    }

    public static WebDriver getSearchNextPage(WebDriver webDriver) {
        WebElement searchButtonNextPage = webDriver.findElement(By.className("a-last")).findElement(By.tagName("a"));
        searchButtonNextPage.click();
        String currentUrl = webDriver.getCurrentUrl();
        webDriver.get(currentUrl);
        return webDriver;
    }

    public static WebDriver getItemPage(String itemCode, WebDriver webDriver) {
        List<WebElement> items = webDriver.findElements(By.cssSelector(String.format("div[data-asin='%s']", itemCode)));
        String link = items.get(0)
                .findElements(By.tagName("h2")).get(0)
                .findElements(By.tagName("a")).get(0)
                .getAttribute("href");
        webDriver.get(link);
        TimeoutUtil.waitSeconds(3);
        return webDriver;
    }

    public static boolean isItemPresent(String itemCode, WebDriver webDriver) {
        List<WebElement> webElements = webDriver.findElements(By.cssSelector(String.format("div[data-asin='%s']", itemCode)));
        return !webElements.isEmpty();
    }
}
