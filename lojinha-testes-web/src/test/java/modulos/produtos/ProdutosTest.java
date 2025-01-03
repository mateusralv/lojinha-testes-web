package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import paginas.LoginPage;

@DisplayName("Testes Web do modulos de produto")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        //Abrir navegador
        System.setProperty("webdriver.chrome.driver", "/Users/mras2/Documents/chromedriver-mac-x64/chromedriver");
        navegador = new ChromeDriver();

        //Navegar ate a lojinha
        //navegador.manage().window().maximize();
        navegador.get("http://165.227.93.41/lojinha-web/v2");

    }
    @Test
    @DisplayName("Registrar produto com valor zero")
    public void testRegistrarProdutoValorZero() {
        //Fazer login
        new LoginPage(navegador)
                .informarSenha("admin")
                .informarUsuario("admin")
                        .clickSaveButton();


/*        navegador.findElement(By.cssSelector("label[for='senha']")).click();
        navegador.findElement(By.id("senha")).sendKeys("admin");

        navegador.findElement(By.cssSelector("button[type='submit']")).click();*/

        //Ir para tepagina de adcionar produto
        navegador.findElement(By.className("waves-effect")).click();

        //preencher dados dos formularios
        navegador.findElement(By.id("produtonome")).sendKeys("iphone1234");
        navegador.findElement(By.id("produtovalor")).sendKeys("0.0");
        navegador.findElement(By.id("produtocores")).sendKeys("Preto");

        navegador.findElement(By.id("btn-salvar")).click();

        //Validar mensagem de erro
        String mensagemToast = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToast);

    }

    @AfterEach
    public void tearDown(){
        //fechar navegador
        navegador.quit();
    }

}
