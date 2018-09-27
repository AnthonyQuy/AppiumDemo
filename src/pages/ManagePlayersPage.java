package pages;


import common.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class ManagePlayersPage extends BasePage {

    private By byBtnPlay = By.id("com.anthonyquy.masoi:id/btn_Start");
    private By byBtnAddPlayer = By.id("com.anthonyquy.masoi:id/btn_AddPlayer");
    private By byUserAvatar = By.id("com.anthonyquy.masoi:id/iv_Avatar");
    private By byBtnDelete = By.id("com.anthonyquy.masoi:id/btn_Delete");
    private By byBtnConfirmAddUser = By.id("com.anthonyquy.masoi:id/btn_Save");
    private By byEditTextPlayerName = By.id("com.anthonyquy.masoi:id/et_PlayerName");

    private By byTextViewContain(String string) {
        return By.xpath("//android.widget.TextView[contains(@text,'" + string + "')]");
    }

    private MobileElement getBtnPlay() {
        return driver.findElement(byBtnPlay);
    }

    private MobileElement getBtnAddPlayer() {
        return driver.findElement(byBtnAddPlayer);
    }

    public boolean isPlayBtnDisplay() {
        return getBtnPlay().isDisplayed();
    }

    public void clickPlayBtn() {
        getBtnPlay().click();
    }

    public boolean isAddPlayerBtnDisplay() {
        return getBtnAddPlayer().isDisplayed();
    }

    public int getNumOfUsers() {
        return driver.findElements(byUserAvatar).size();
    }

    public void clickOnUserContain(String string) {
        MobileElement e = driver.findElement(byTextViewContain(string));
        e.click();
    }

    public void clickOnDeleteBtn() {
        driver.findElement(byBtnDelete).click();
    }

    public boolean isHasUserWithNameContain(String string) {
        try {
            driver.findElement(byTextViewContain(string));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void addUsers(List<String> lstUser) {
        for (String user : lstUser) {
            getElement(byBtnAddPlayer).click();
            getElement(byEditTextPlayerName).sendKeys(user);
            getElement(byBtnConfirmAddUser).click();
        }
    }


    public boolean isUsersDisplayed(List<String> names) {
        for (String name : names) {
            if (!isHasUserWithNameContain(name)) return false;
        }
        return true;
    }
}
