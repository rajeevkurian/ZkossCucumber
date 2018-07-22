package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by rkurian on 7/2/2018.
 */
public class ZkossInputPage extends ZkossBasePage {

    public ZkossInputPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[@itemprop='title']")
    WebElement datePickerTitle;

    @FindBy(xpath = "//li/a[contains(text(),'Date and Time Picker')]")
    WebElement dateTimePickerRef;

    @FindBy(xpath = "//span[text()='Input']")
    WebElement inputText;

    @FindBy(xpath = "//a[@id = 'pR1Qp-btn']")
    WebElement shortDate1;

    @FindBy(xpath = "//tr[@class='z-row'][1]/td[@class='z-row-inner'][2]/div[1]/span[1]/a")
    WebElement datePicker1;

    @FindBy(xpath = "//a[@class='z-calendar-icon z-calendar-left']")
    WebElement clickBefore;

    @FindBy(xpath = "//table[@class='z-calendar-body']/tbody/tr[1]/td[6]")
    WebElement myBirthDay;

    @FindBy(xpath = "//table[@class='z-calendar-body']/tbody")
    List<WebElement> month;

    public void waitForDatePickerToLoad(){

        waitTillWebElementVisibile(datePickerTitle);
    }

    public void clickDateAndTimePicker(){
        waitTillWebElementVisibile(dateTimePickerRef);
        click(dateTimePickerRef);
        waitTillWebElementVisibile(inputText);
    }

    public void waitForDatePageToLoad(){
        waitTillWebElementVisibile(shortDate1);
    }

    public void clickDatePicker1(){
        waitTillWebElementVisibile(datePicker1);
        datePicker1.click();
    }

    public void  clickBefore(){
        waitTillWebElementVisibile(clickBefore);
        clickBefore.click();
    }

    public void clickMyBday(){
        waitTillWebElementVisibile(myBirthDay);
        myBirthDay.click();
    }

    public void printAll() {
        for(WebElement e : month){
            //Iterate tr- each tr is week and each td is week.
            List<WebElement> weeks = e.findElements(By.tagName("tr"));
            for(WebElement d : weeks){
                List<WebElement> days = d.findElements(By.tagName("td"));
                for(WebElement day : days){
                    System.out.println("**** Days ****"+day.getText()+"\n");
                }
            }
        }
    }
}
