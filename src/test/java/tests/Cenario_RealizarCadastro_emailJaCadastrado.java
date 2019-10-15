package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.loginPages;

//Realizar cadastro com sucesso!!!

public class Cenario_RealizarCadastro_emailJaCadastrado {

	static loginPages loginPages;
	static WebDriver navegador;

	@BeforeClass
	public static void beforeClass() throws Exception {

		loginPages = new loginPages(navegador);
	}

	@Test
	public void Cenario_RealizarCadastro_teste() throws InterruptedException {
		navegador = loginPages.fazerLogin();

		// Declarar Wait
		WebDriverWait wait = new WebDriverWait(navegador, 30);

		
		// WAIT Página Inicial
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")));

		// Acessar a opção de LOGIN
		navegador.findElement(By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a")).click();

/*		// REALIZAR AÇÕES EM NOVA ABA --- (((caso a página seja aberta em nova guia)))
		for (String winHandle : navegador.getWindowHandles()) {
			navegador.switchTo().window(winHandle);
		}
*/
		
		// ---------------- Tela de Login e Cadastro --------------------
		// WAIT Página Login/cadastro
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='login_form']/div/p[1]/a")));

		
		// Campo Email do quadro Criar Conta
		navegador.findElement(By.id("email_create")).sendKeys("test@gmail.com");
		Thread.sleep(800);

		// Clicar em "Criar Conta"
		navegador.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(800);

		
		//Validar email	
		 WebElement pegarMensagem = navegador.findElement(By.xpath("//*[@id='create_account_error']/ol/li"));
	     String Validar = pegarMensagem.getText();
	     Thread.sleep(3000);


		if (Validar.contains("An account using this email address has already been registered. Please enter a valid password or request a new one."))
			   {
				System.out.println("O Email informado já está cadastrado!");
				Thread.sleep(2000);
				
				//fechar página
				navegador.quit();				
			   }
		
		
		
	}
}