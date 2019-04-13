package testes;

import org.junit.Test;

import core.BaseTest;
import pages.TaskPage;

public class Tasks extends BaseTest {
	
	TaskPage tp = new TaskPage();
	
	@Test
	public void criarTask() {
		tp.criarTarefa();
		tp.adicionarTarefa();
		
		
	}
	
	public void editarTask() {
		
	}

}
