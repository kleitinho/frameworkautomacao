package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class TaskPage extends BasePage {
	
	public void criarTarefa() {
		clicarBotao(By.id("insert-button"));
	}
	
	public void adicionarTarefa() {
		escrever("title", "Tarefa de Automação");
		escrever("dueDate", "13/04/2019");
		escrever(By.xpath("//*[@id=\"add-task\"]/div[4]/div/div"), "testes");
		clicarBotao(By.id("form-submit-button"));
		
	}
	
	//public void editarTarefa()

}
