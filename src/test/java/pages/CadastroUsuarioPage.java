package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import runner.RunCucumber;

import static support.Commands.clickElement;

public class CadastroUsuarioPage extends RunCucumber {

    // elementos
    private By campoNome = By.id("user");
    private By campoEmail = By.id("email");
    private By campoSenha = By.id("password");
    private By botaoFazerCadastro= By.id("btnRegister");

    // ações / funções / métodos
    public void preencheNome(String email){
         getDriver().findElement(campoNome).sendKeys(email);
    }
    public void preencheEmail(String email){
         getDriver().findElement(campoEmail).sendKeys(email);
    }

    public void preencherSenha(String senha){
        getDriver().findElement(campoSenha).sendKeys(senha);
    }

    public void cadastrarUsuario(){
        clickElement(botaoFazerCadastro);
    }

    public void verificaCadastroSucesso(){
        String textoLoginSucesso = getDriver().findElement(By.id("swal2-title")).getText();
        Assert.assertEquals("Os textos não são iguais!", "Cadastro realizado!", textoLoginSucesso);
    }
}
