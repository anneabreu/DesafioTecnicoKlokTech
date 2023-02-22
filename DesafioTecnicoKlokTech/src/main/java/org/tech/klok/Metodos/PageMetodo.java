package org.tech.klok.Metodos;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMetodo {
    public void esperarPor(By by) {
        WebDriverWait wait2 = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public void esperarPorSelecao(By by) {
        WebDriverWait wait2 = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait2.until(ExpectedConditions.elementToBeSelected(by));
    }
    public void esperarPor(String id_campo) {
        esperarPor(By.id(id_campo));
    }
    /********* TextField e TextArea ************/
    public void acessarTelaInicial(String string){
        //System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        DriverFactory.getDriver().get(string);
    }
    public void escrever(By by, String texto){
        DriverFactory.getDriver().findElement(by).clear();
        DriverFactory.getDriver().findElement(by).sendKeys(texto);
    }
    public void escrever(String id_campo, String texto){
        escrever(By.id(id_campo), texto);
    }

    public void getTitulo(){
        DriverFactory.getDriver().getTitle();
    }

    public String obterValorCampo(String id_campo) {
        return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }


}
