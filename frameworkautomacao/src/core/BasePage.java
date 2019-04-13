package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public void abrirUrl(String url) {
		getDriver().get(url);
	}

	/**** Areas de textos ****/
	public void escrever(By locator, String valor) {
		getDriver().findElement(locator).clear();
		getDriver().findElement(locator).sendKeys(valor);

	}

	public void escrever(String id, String texto) {
		escrever(By.id(id), texto);
	}

	public String obterValorInput(String id) {

		return getDriver().findElement(By.id(id)).getAttribute("value");

	}

	public String obterValorTexto(String txt) {

		return getDriver().findElement(By.id(txt)).getText();
	}

	/**** Areas de Cliques ****/

	public void cliqueRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public void cliqueCbox(String id) {
		getDriver().findElement(By.id(id)).click();
	}

	public boolean rboSelecionado(String id) {

		return getDriver().findElement(By.id(id)).isSelected();

	}

	public void cliqueBotao(String ButtonName) {
		getDriver().findElement(By.xpath("//input[@value='" + ButtonName + "']")).click();

	}
	
	public void clicarBotao(By locator) {
		getDriver().findElement(locator);
	}

	/**** Areas de Select ****/

	public void selecionarCombo(String id, String valor) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}

	public void deselecionarCombo(String id, String valor) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByValue(valor);
	}

	public String obterValorCombo(String id) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();

	}

	public List<String> obterValoresCombo(String id) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> elementos = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for (WebElement opcao : elementos) {

			valores.add(opcao.getText());
		}
		return valores;

	}

	public int obterQtdadeOpcoesCombo(String id) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> elementos = combo.getOptions();
		return elementos.size();
	}

	public boolean verificarOpcaoCombo(String id, String valor) {

		WebElement element = getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> elementos = combo.getOptions();
		for (WebElement opcao : elementos) {
			if (opcao.getText().equals(valor)) {
				return true;
			}

		}

		return false;

	}

	/**** Areas de Select ****/

	public String alertaObterTexto() {

		Alert alerta = getDriver().switchTo().alert();
		return alerta.getText();

	}

	public String obterTextoeAceitar() {

		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.accept();
		return valor;
	}

	public String obterTextoeNegar() {

		Alert alerta = getDriver().switchTo().alert();
		String valor = alerta.getText();
		alerta.dismiss();
		return valor;
	}

	public void escreverAlerta(String txt) {

		Alert alerta = getDriver().switchTo().alert();
		alerta.sendKeys(txt);
		alerta.accept();
	}

	/**** Areas de Frames E Janelas ****/

	public void entrarFrame(String id) {
		getDriver().switchTo().frame(id);
	}

	public void sairFrame() {
		getDriver().switchTo().defaultContent();
	}

	public void trocarJanela(String id) {
		getDriver().switchTo().window(id);
	}

	/*** Area tabela ***/

	public void InteragirComTabelas(int indicebusca, int interacao, String valor, String valorbusca, String acao) {

		String xpath = "//tbody/tr[td[" + indicebusca + "]='" + valorbusca + "']/td[" + interacao + "]/input";
		WebElement elementoTabela = getDriver().findElement(By.xpath(xpath));

		switch (acao) {
			case "click":elementoTabela.click();break;
			
			case "escrever":elementoTabela.sendKeys(valor);break;
			
			default:System.out.println("Ação Inválida");
			
			
		}
	}
}

