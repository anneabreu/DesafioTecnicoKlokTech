package org.tech.klok.Metodos;

import org.openqa.selenium.By;

public class PageXpath {
    private By pesquisar = By.xpath("//*[@id=\"input-search\"]");

    private By resultado = By.xpath("(//*[@data-testid='product-title'])\n");

    private By resultado_lista = By.xpath("//h1[@data-testid='text-list-title']");

    private By note = By.xpath("//*[@id=\"__next\"]/div/main/section[2]/div[2]/h1");

    private By categoria = By.xpath("(//input[@data-testid='checkbox-item'])[1]");
    private By busque_por = By.xpath("//input[@id='search-filter ']");
    public By getBusque_por(){return busque_por;}

    public By getPesquisar(){return pesquisar;}
    public By getResultado(){return resultado;}
    public By getResultadoLista(){return resultado_lista;}
    public By getNote(){return note;}
    public By getCategoria(){return categoria;}

}
