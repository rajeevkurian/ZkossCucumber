package steps;

import Base.ZkossUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ZkossMainPage;
import pages.ZkossBasePage;
import pages.ZkossInputPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rkurian on 7/2/2018.
 */
public class ZkossSteps {

    private ZkossUtil zkossUtil;
    private ZkossBasePage basePage;
    private WebDriver driver;
    private ZkossInputPage zInput;
    public  ZkossSteps(Container container){
        //do init  stuff here
     this.zkossUtil = container.getBase();
     this.driver = container.getDriver();
     //basePage = new ZkossBasePage(driver);
     zInput = new ZkossInputPage(driver);
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {

        //Assert.assertEquals("Its not displayed", zkossUtil.Driver.findElement(By.id("Initial")).isDisplayed(), true);
    }

    @Given("^I navigate to the zkoss page$")
    public void iNavigateToTheLoginPage() throws Throwable {

        System.out.println("Navigate Login Page");
        //driver.navigate().to("https://www.zkoss.org/zkdemo/input");
        //driver.get("https://www.zkoss.org/zkdemo/input");
        driver.navigate().to("https://www.zkoss.org/zkdemo/input");
    }

    @Given("^I wait for page to load$")
    public void i_wait_for_page_to_load() throws Throwable {
       zInput.waitForDatePickerToLoad();
    }
    @Then("^I click date time button$")
    public void i_click_date_time_button() throws Throwable {
        zInput.clickDateAndTimePicker();
    }

    @Then("^I click date picker$")
    public void i_click_short_date() throws Throwable {
       //zInput.waitForDatePageToLoad();
       zInput.clickDatePicker1();
       //zInput.clickBefore();
      // zInput.clickMyBday();
       //Select all click
       zInput.printAll();
    }




    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        ZkossMainPage page = new ZkossMainPage(this.driver);
        page.ClickLogin();
        ZkossUtil.waitFor(15000);
    }


    @And("^I enter the following for Login$")
    public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
        //Create an ArrayList
        List<User> users =  new ArrayList<User>();
        //Store all the users
        users = table.asList(User.class);

        ZkossMainPage page = new ZkossMainPage(zkossUtil.Driver);

        for (User user: users){
            page.Login(user.username, user.password);
            //page.Login("admin", "adminPassword");
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUsernameAndPassword(String userName, String password) throws Throwable {
        System.out.println("UserName is : " + userName);
        System.out.println("Password is : " + password);
    }

    @Then("^I should see the userform page wrongly$")
    public void iShouldSeeTheUserformPageWrongly() throws Throwable {

        Assert.assertEquals("Its not displayed", zkossUtil.Driver.findElement(By.id("sdfgdsfsd")).isDisplayed(), true);
    }


    public class User {
        public String username;
        public String password;

        public User(String userName, String passWord) {
            username= userName;
            password = passWord;
        }
    }

}
