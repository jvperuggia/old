package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class loginPages {

	static WebDriver navegador;

	public loginPages(WebDriver navegador) {
		loginPages.navegador = navegador;
	}

	public WebDriver fazerLogin() {

		// Definindo Navegador
		ChromeOptions options = new ChromeOptions();

		
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		WebDriver navegador = new ChromeDriver(options);
		
//		System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\geckodriver.exe");
//		WebDriver navegador = new FirefoxDriver();
		
//		System.setProperty("webdriver.ie.driver","C:\\Webdriver\\IEDriverServer.exe");
//		WebDriver navegador = new InternetExplorerDriver();

		//Maximizar
		navegador.manage().window().maximize();
		
		//Acessar URL
		navegador.get("http://automationpractice.com/index.php");
		
		
		return navegador;
	}

}
