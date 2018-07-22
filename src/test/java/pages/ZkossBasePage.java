package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by rkurian on 5/5/2018.
 */
public class ZkossBasePage {

    private WebDriverWait wait;
    protected WebDriver driver;

    public ZkossBasePage() {

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public ZkossBasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void waitTillElementVisibleByName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
    }

    public void waitTillElementVisibleById(String id) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public void waitTillWebElementVisibile(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendChar(WebElement element, String value) {
        waitTillWebElementVisibile(element);
        element.clear();
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }

    public void click(WebElement element) {
        waitTillWebElementVisibile(element);
        element.click();
        System.out.println("**** clicked button ****");
    }

    public void submit(WebElement element) {
        waitTillWebElementVisibile(element);
        element.submit();
        System.out.println("**** clicked button ****");
    }
}