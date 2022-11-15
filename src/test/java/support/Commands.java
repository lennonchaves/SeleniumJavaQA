package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import runner.RunCucumber;

public class Commands extends RunCucumber {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(getDriver(), tempo);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void clickElement(By element){
        System.out.println("####################################");
        try {
            System.out.println("******* Tentando clicar no elemento " + element);
            waitElementBeClickable(element,10000);
            getDriver().findElement(element).click();
        } catch(Exception error){
            System.out.println("****** Erro no click do elemento " + element);
            new Exception(error);
        }
        System.out.println("####################################");
    }

    public static void checkMessage(By element, String expectedMessage){
        System.out.println("####################################");
        String actualMessage = null;
        waitElementBeVisible(element, 10000);
        actualMessage = getDriver().findElement(element).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("******  Mensagem Esperada " + expectedMessage);
        System.out.println("####################################");


    }
}
