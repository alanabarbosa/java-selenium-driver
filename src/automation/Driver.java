package automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {
    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");

        EdgeOptions options = new EdgeOptions();
        
        WebDriver driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.kabum.com.br");
        
        WebElement closePoupop = driver.findElement(By.className("ins-web-opt-in-reminder-close-button"));
        closePoupop.click();
        
        WebElement btnCookie =  driver.findElement(By.id("onetrust-accept-btn-handler"));
        btnCookie.click();
        
        WebElement input = driver.findElement(By.id("input-busca"));
        input.sendKeys("Ryzen 7");   
        
        WebElement btnSearch = driver.findElement(By.className("bmNiyT"));
        btnSearch.click();
        
        List<WebElement> products = driver.findElements(By.className("productCard"));
        System.out.println("Quantidade de produtos na página: " + products.size());
        
        for (WebElement product : products) {
            WebElement productTitle = product.findElement(By.className("nameCard"));
            String titleText = productTitle.getText();
            
            if (productTitle.getText().equals("Processador AMD Ryzen 7 5700G, 3.8GHz "
        		+ "(4.6GHz Max Turbo), Cache 20MB, 8 Núcleos, 16 Threads, Vídeo Integrado, "
        		+ "AM4 - 100-100000263BOX")) {
                System.out.println("Produto encontrado: " + titleText);
                product.click();
                break; 
            }            
            
        }
        
        System.out.println("Título da página: " + driver.getTitle());

        driver.quit();
    }
}
