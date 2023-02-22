package org.tech.klok.Metodos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.tech.klok.Metodos.DriverFactory.getDriver;

public class PageBuscarProduto extends PageMetodo {
    public WebDriver driver = getDriver();
    private PageXpath elements;
    public PageBuscarProduto(){
        this.elements=new PageXpath();
    }

    public PageXpath getElementos() {
        return elements;
    }

    public WebElement Pesquisar(){
        return driver.findElement(elements.getPesquisar());
    }
    public List<WebElement> Resultado(){return driver.findElements(elements.getResultado());
    }

    public WebElement ResultadoLista(){
        return driver.findElement(elements.getResultadoLista());
    }
    public WebElement Note(){
        return driver.findElement(elements.getNote());
    }
    public WebElement Categoria(){
        return driver.findElement(elements.getCategoria());
    }
    public WebElement BuscarPorCategoria(){
        return driver.findElement(elements.getBusque_por());
    }

}
