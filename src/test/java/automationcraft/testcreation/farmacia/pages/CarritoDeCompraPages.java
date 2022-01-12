package automationcraft.testcreation.farmacia.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarritoDeCompraPages extends SeleniumBase {

    public CarritoDeCompraPages(WebDriver driver) {
        super(driver);
    }

    //Localizadores
    By barraBusqueda = By.xpath("//input[@id=\"search\"]");
    By btnAgregarCarritoBromex = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[4]/div[2]/ol/li[1]/div/div[2]/div[2]/div/div[1]/form/button");
    By btnCantidadCarrito = By.xpath("//a[3]//span[@class='counter qty']");
    By btnVerCarrito = By.xpath("//a[@id=\"top-cart-btn-checkout\"]");
    By btnAumentarCantidad = By.xpath("//input[@id='cart-2598860-qty']");


    //Comportamientos
    public void validacionUrl(String url) throws Exception {
        goToUrl(url);
    }

    public void guardarProducto() throws Exception {
        explicitWait(1500);
        click(btnAgregarCarritoBromex);
    }

    public void validarCargaEnCarrito() throws Exception {
        if(!isDisplayed(btnCantidadCarrito)) {
            throw new Exception("Elemento no Encontrado");
        }
        click(btnCantidadCarrito);
    }

    public void validarDespliegueCarritoCompraWeb() throws InterruptedException {
        explicitWait(1500);
        click(btnVerCarrito);
    }

    public void validarAumentarCantidadProducto(int cantidad) throws Exception {
        if(!isDisplayed(btnAumentarCantidad)) {
            throw new Exception("Elemento no Encontrado");
        }
        type(String.valueOf(cantidad), btnAumentarCantidad);
    }

    public void validarActualizarCompra(String string) {
        By btnActualizarCompra = By.xpath("//button[@name='update_cart_action' and @title='"+string+ "']");
        click(btnActualizarCompra);
    }

}
