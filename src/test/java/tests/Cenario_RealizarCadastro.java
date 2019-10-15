package tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

import com.google.common.base.Strings;

import pages.loginPages;

//Realizar cadastro com sucesso!!!

public class Cenario_RealizarCadastro {

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
		
		//email RANDOM
		Double emailRandom = Math.random() *9999;
		String stringEmail = Strings.padStart(String.valueOf(emailRandom.longValue()), 4, '0');
		String email = stringEmail;
		
		navegador.findElement(By.id("email_create")).sendKeys("test_"+email+"@gmail.com");
		Thread.sleep(800);

		// Clicar em "Criar Conta"
		navegador.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(800);

		
		
		// ---------------- Tela Dados Cadastrais --------------------
		// WAIT Página Login/cadastro
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='customer_firstname']")));

		// Radio - Sexo (Masculino)
		navegador.findElement(By.id("id_gender1")).click();
		Thread.sleep(500);

		// campo Primeiro nome
		navegador.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("Joao");
		Thread.sleep(500);

		// Campo Sobrenome
		navegador.findElement(By.id("customer_lastname")).sendKeys("Peruggia");
		Thread.sleep(500);
		
		// Campo Senha
		navegador.findElement(By.id("passwd")).sendKeys("senha123");
		Thread.sleep(500);

		// Data de Nascimento
		//DIA RANDOM
		Double diaRandom = Math.random() *30;
		String stringDia = Strings.padStart(String.valueOf(diaRandom.longValue()), 2, '1');
		String dia = stringDia;
		//selecionar dia
		navegador.findElement(By.id("days")).sendKeys(dia);
		Thread.sleep(500);


		//MÊS RANDOM
		Random aleatorio = new Random();
		int mesRandom = aleatorio.nextInt(12) + 1;
		String mes = null;
		mes = "0" + mesRandom;
		mes = mes.replaceAll("^0+", "");
		//selecionar Mês	
		WebElement mySelectElm = navegador.findElement(By.id("months")); 
		Select mySelect= new Select(mySelectElm);
		Thread.sleep(1000);
		mySelect.selectByValue(mes);
		Thread.sleep(500);

		
		//ANO RANDOM		
		Random anoAleatorio = new Random();
		int anoRandom = anoAleatorio.nextInt(119) + 1901;
		String ano = null;
		ano = "0" + anoRandom;
		ano = ano.replaceAll("^0+", "");
		//selecionar Ano Nascimento
		navegador.findElement(By.id("years")).sendKeys(ano);
		Thread.sleep(500);
				
		// Receber ofertas
		navegador.findElement(By.id("optin")).click();
		Thread.sleep(500);
		
		//Empresa
		navegador.findElement(By.id("company")).sendKeys("GrooveTech");
		Thread.sleep(500);
		
		//Endereço 1 
		navegador.findElement(By.id("address1")).sendKeys("Adventure Way N32, Google");
		Thread.sleep(500);

		//Endereço Parte 2
		navegador.findElement(By.id("address2")).sendKeys("21º andar - Sala 2103");
		Thread.sleep(500);
				
		//Cidade
		navegador.findElement(By.id("city")).sendKeys("Florence");
		Thread.sleep(500);
				
		//Estado
		navegador.findElement(By.xpath("//*[@id='id_state']/option[3]")).click();
		Thread.sleep(500);
						
		//Endereço 1 
		navegador.findElement(By.id("postcode")).sendKeys("85232");
		Thread.sleep(500);
		
		//Celular
		navegador.findElement(By.id("phone_mobile")).sendKeys("+55 21 99876-5432");
		Thread.sleep(500);
				
		//Email Alternativo
		navegador.findElement(By.id("alias")).clear(); //Limpando campo
		navegador.findElement(By.id("alias")).sendKeys("outro_email@mail.com");
		Thread.sleep(500);
				
		//Submeter
		navegador.findElement(By.name("submitAccount")).click();
		
				
		
		// ---------------- Tela Minha Conta --------------------	
		// WAIT Página Minha Conta
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a/i")));

		// VERIFICAR se o cadastro foi realizado com sucesso
		WebElement verficarMsg = navegador.findElement(By.xpath("//*[@id='center_column']/p"));
		String MsgSucesso = verficarMsg.getText();
		Thread.sleep(500);
		
		if (MsgSucesso.equals("Welcome to your account. Here you can manage all of your personal information and orders."))
		   {
			//Cadastro Realizado com Sucesso - Fechar Navegador
			Thread.sleep(2000);
			System.out.println("Cadastro Realizado com Sucesso!!!");
			navegador.quit();						
		   }
		else
			System.out.println("O cadastro não foi realizado");
			navegador.quit();			

	}
}