package modulos.produtos;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@DisplayName("Testes Web do modulos de produto")
public class ProdutosTest {
    @Test
    @DisplayName("Registrar produto com valor zero")
    public void testRegistrarProdutoValorZero() {
        //Abrir navegador
        System.setProperty("webdriver.chrome.driver", "/Users/mras2/Documents/chromedriver-mac-x64/chromedriver");
        WebDriver navegador = new ChromeDriver();

        //Navegar ate a lojinha
        navegador.manage().window().maximize();
        navegador.get("http://165.227.93.41/lojinha-web/v2");

        //Fazer login
        navegador.findElement(By.cssSelector("label[for='usuario']")).click();
        navegador.findElement(By.id("usuario")).sendKeys("admin");

        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");

        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        //Ir para tepagina de adcionar produto
        navegador.findElement(By.className("waves-effect")).click();

        //preencher dados dos formularios
        navegador.findElement(By.id("produtonome")).sendKeys("iphone1234");
        navegador.findElement(By.id("produtovalor")).sendKeys("125");
        navegador.findElement(By.id("produtocores")).sendKeys("Preto");

        navegador.findElement(By.id("btn-salvar")).click();


        //Validar mensagem de erro

    }
}
