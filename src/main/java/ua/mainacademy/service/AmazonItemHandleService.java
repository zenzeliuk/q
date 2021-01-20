package ua.mainacademy.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.mainacademy.util.TimeoutUtil;

import static java.util.Objects.nonNull;

public class AmazonItemHandleService {

    public static WebDriver addItemToCart(WebDriver webDriver) {
        WebElement addItemToCartButton = webDriver.findElement(By.id("add-to-cart-button"));
        if (nonNull(addItemToCartButton)) {
            addItemToCartButton.click();
            TimeoutUtil.waitSeconds(5);
        }
        return webDriver;
    }

}
