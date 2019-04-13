package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class Inicializacao extends BasePage{
	public void abrirSite() {
		abrirUrl("https://mark7.herokuapp.com/login");
		
	}
	
	public void logar() {
		escrever("login_email", "kleiton.msantana@gmail.com");
		escrever("login_password", "455181");
		clicarBotao(By.xpath("//*[@id=\"lockedtop_0$ctl07$lockedtop_0$btnLoginctl07$lockedtop_0$ctl05$\"]"));
		
	}

}
