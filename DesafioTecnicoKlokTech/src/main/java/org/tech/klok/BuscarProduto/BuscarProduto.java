package org.tech.klok.BuscarProduto;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.tech.klok.Metodos.PageBuscarProduto;
import org.tech.klok.Constantes.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import static org.tech.klok.Metodos.DriverFactory.killDriver;

public class BuscarProduto {
    PageBuscarProduto page = new PageBuscarProduto();

    @Given("um produto")
    public void umProduto() {
        page.acessarTelaInicial("https://www.magazineluiza.com.br/");
    }

    //Buscando um produto
    @When("busca por um {string}")
    public void buscaPorUm(String produto) {
        page.esperarPor(page.getElementos().getPesquisar());
        page.Pesquisar().sendKeys(produto);
        page.Pesquisar().sendKeys(Keys.ENTER);
    }

    //Verificando resultados da busca
    @Then("acha um produto")
    public void achaUmProduto() {
        page.esperarPor(page.getElementos().getResultado());
        for (int i = 0; i < page.Resultado().size(); i++) {
            String notebook = page.Resultado().get(i).getText();
            Assert.assertTrue(notebook.contains("Notebook"));
        }
    }

    //Busca por produto inexistente
    @Then("não acha um produto")
    public void nãoAchaUmProduto() {
        page.esperarPor(page.getElementos().getResultadoLista());
        Assert.assertEquals(Constantes.nao_encontra_produto, page.ResultadoLista().getText());
    }

    //Busca com caracteres inválidos
    @Then("não retorna resultados")
    public void nãoRetornaResultados() {
        page.esperarPor(page.getElementos().getResultadoLista());
        Assert.assertEquals(Constantes.nao_retorna_resultados, page.ResultadoLista().getText());
    }

    //Seleciona um produto da pagina de resultados
    @And("clica no produto escolhido")
    public void clicaNoProdutoEscolhido() {
        page.esperarPor(page.getElementos().getResultado());
        Constantes.verificar = page.Resultado().get(1).getText();
        page.Resultado().get(1).click();
    }

    //Verifica a pagina do produto escolhido
    @Then("o sistema deve exibir a pagina do produto")
    public void oSistemaDeveExibirAPaginaDoProduto() {
        page.esperarPor(page.getElementos().getNote());
        Assert.assertEquals(page.Note().getText(), Constantes.verificar);
    }

    //Busca com filtro
    @And("seleciona uma categoria")
    public void selecionaUmaCategoria() {
        page.esperarPor(page.getElementos().getBusque_por());
        page.BuscarPorCategoria().sendKeys("APPLE");
        page.esperarPor(page.getElementos().getCategoria());
        page.Categoria().click();
        page.esperarPorSelecao(page.getElementos().getCategoria());
    }

    @Then("os produtos da categoria devem ser exibidos")
    public void osProdutosDaCategoriaDevemSerExibidos() {
        page.esperarPor(page.getElementos().getResultado());
        for (int i = 0; i < page.Resultado().size(); i++) {
            String notebook = page.Resultado().get(i).getText();
            Assert.assertTrue(notebook.contains("Apple"));
        }
    }

    @After
    public void finalizarBrowser() {
        killDriver();
    }
}


