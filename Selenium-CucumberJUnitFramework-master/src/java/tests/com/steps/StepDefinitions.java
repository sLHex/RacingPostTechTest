package com.steps;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import cucumber.api.PendingException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.global.Generic;
import com.utilities.LogAction;
import com.utilities.TestFailedException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import javax.swing.*;

public class StepDefinitions {

    public WebDriver driver = null;

    public Scenario currentScenario = null;
    LogAction log = new LogAction(StepDefinitions.class);
    Generic gfx = new Generic();


    @Before
    public void setUp(Scenario scenario) {

        this.currentScenario = scenario;

        log.writeLog("INFO", "Running scenario : " + "[ Name : " + currentScenario.getName() + " ]" + "[ SourceTagNames : " + currentScenario.getSourceTagNames() + " ]");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Conno\\Desktop\\Repos\\chromedriver.exe");
        driver = new ChromeDriver();

        log.writeLog("INFO", "WebDriver Initialized");

    }

    @After
    public void tearDown() throws IOException {

        driver.close();
        driver.quit();

        log.writeLog("PASS", "WebDriver Closed");
        log.writeLog("INFO", "Scenario " + "[ Name : " + currentScenario.getName() + " ]" + " has run with \n [ STATUS = " + currentScenario.getStatus() + " ]");


    }

    @Given("I am on “https:\\/\\/www.racingpost.com\\/racecards\\/”")
    public void i_am_on_https_www_racingpost_com_racecards() {

        //Loading the website
        driver.get("https://www.racingpost.com/racecards/");

    }

    @When("I click the “Big Race Entries” header")
    public void i_click_the_Big_Race_Entries_header() {

        //Selecting the "Big Race Entries" If it cannot be selected the assertion will fail the test
        try {
            WebElement element = driver.findElement(By.cssSelector("#secondaryNav > li:nth-child(8) > a"));
            //Was going to use a thread.sleep() here but I already know Mark would kill me if I did.
            element.click();
        } catch (Exception e) {
            Assert.fail("Unable to click on Big Race Entries");

        }
    }

    @Then("^The date of the next big race event is in the future$")
    public void the_date_of_the_next_big_race_event_is_in_the_future() throws TestFailedException {

        //Normally I'd use a POM here but given the test is small in nature it felt more efficient to grab the top date via xpath
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/main/div/div[2]/div[1]/div[2]"));
        //Pulling the string from the given element
        String raceDateString = element.getText();
        //Converting it to a date time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yy", Locale.ENGLISH);
        LocalDate raceDate = LocalDate.parse(raceDateString, formatter);
        //Comparing the converted & formatted race date to the current date
        LocalDate currentDate = LocalDate.now();
        //compareTo method returns number of days from raceDate to currentDate
        int result = raceDate.compareTo(currentDate);
        //Making sure the value returned is more than zero I.E a date in the future
        Assert.assertTrue("Checking raceDate set to future", result > 0);

    }

    @Then("I see today's offers")
    public void i_see_today_s_offers() {
        //defining element to be verified
       WebElement element = driver.findElement(By.cssSelector("body > div.ui-canvas.js-contentWrapper.ui-advertising__skinsWrp.ui-advertising__skinsWrp_secNav > aside.ui-sidebar.ui-sidebar_marginless > div > div > div"));
       //Maximising the window as today's offer is not visable on smaller/thinner screens
       driver.manage().window().maximize();
       //verify element is displayed
        Assert.assertTrue("check for today's offer advertising side-bar",element.isDisplayed());
    }

}
