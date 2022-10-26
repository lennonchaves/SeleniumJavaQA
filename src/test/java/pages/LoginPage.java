package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.Commands.*;

public class LoginPage extends RunCucumber {

    // elementos
    private String URL = "http://automationpratice.com.br/";
    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By botaoAcessarCadastro = By.cssSelector(".right_list_fix > li > a > .fa-lock");

    // ações / funções / métodos
    public void acessarAplicao() {
        getDriver(System.getProperty("browser")).get(URL);
    }

    public void acessarTelaLogin() {
        clickElement(botaoAcessarLogin);
        //getDriver().findElement(botaoAcessarLogin).click();
    }

    public void preencheEmail(String email){
         getDriver().findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha){
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public void clicarLogin(){
        clickElement(botaoFazerLogin);
        //getDriver().findElement(botaoFazerLogin).click();
    }

    public void verificaLoginSucesso(){
        checkMessage(By.id("swal2-title"), "Login realizado");
        //String textoLoginSucesso = getDriver().findElement(By.id("swal2-title")).getText();
        //Assert.assertEquals("Os textos não são iguais!", "Login realizado", textoLoginSucesso);
    }

    public void verificaCampoVazio(String message){
        checkMessage(By.className("invalid_input"), message);
    }

    public void acessarTelaCadastro(){
        clickElement(botaoAcessarCadastro);
        //getDriver().findElement(botaoAcessarCadastro).click();
    }

}
