package testdefs;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.ManagePlayersPage;

import java.net.MalformedURLException;
import java.util.List;


public class CreateDeleteUser {
    private ManagePlayersPage page;

    @Before
    public void openGame() throws MalformedURLException {
        page = new ManagePlayersPage();
        page.init();
    }

    @Given("^I'm in the game$")
    public void iMInTheGame() {
        Assert.assertTrue(page != null);
        System.out.println("I'm in the Game");
    }

    @Given("I see play btn")
    public void i_see_play_btn() {
        Assert.assertTrue(page.isPlayBtnDisplay());
        System.out.println("I see play btn");
    }

    @When("^Click on play button$")
    public void click_on_play_button() {
        page.clickPlayBtn();
        System.out.println("I clicked on play btn");
    }

    @When("^Wait (\\d+)s$")
    public void wait_s(Integer seconds) {
        page.waitForSeconds(seconds);
        System.out.println("I waited for " + seconds + "s");
    }

    @Then("^The setup UI display$")
    public void the_setup_UI_display() {
        Assert.assertTrue(page.isAddPlayerBtnDisplay());
        System.out.println("The setup player UI displayed");
    }

    @Then("^Has (\\d+) default user$")
    public void has_default_user(Integer numOfUser) {
        Assert.assertTrue(page.getNumOfUsers() == numOfUser);
    }

    @Given("^I'm in the manage user page$")
    public void iMInTheManageUserPage() {
        page.clickPlayBtn();
        Assert.assertTrue(page.isAddPlayerBtnDisplay());
        System.out.println("I'm in the manage user page");
    }


    @And("^I open user contains \"([^\"]*)\" in name$")
    public void iOpenUserContainsInName(String name) {
        page.clickOnUserContain(name);
        System.out.println("I open user which has name contains: " + name);

    }

    @When("^I click on delete btn$")
    public void iClickOnDeleteBtn() {
        page.clickOnDeleteBtn();
        System.out.println("I clicked on delete button");
    }

    @Then("^User was deleted$")
    public void userWasDeleted() {
        page.clickOnDeleteBtn();

    }

    @Then("^User contains \"([^\"]*)\" in name was deleted$")
    public void userContainsInNameWasDeleted(String name) {
        Assert.assertFalse(page.isHasUserWithNameContain(name));
        System.out.println("User contain " + name + "in Name was deleted");
    }

    @Then("I can add the user")
    public void i_can_add_the_user(List<String> names) {
        page.addUsers(names);
        Assert.assertTrue(page.isUsersDisplayed(names));
    }

}
