package controller;

import java.util.ArrayList;

import model.Campo;

public class ControladorTela {
	private Campo c = Campo.getInstancia();
	
	public ArrayList<String[]> invocarCampo(){
		return c.getCampo();
	}
	
	public void setDerrota(boolean b) {
		c.setDerrota(b);
	}
	
	public boolean isDerrota() {
		return c.isDerrota();
	}
	
	public int getAcertos() {
		return c.getAcertos();
	}
	
	public void setAcertos(int quantidade) {
		c.setAcertos(quantidade);
	}

	public void NovoJogo() {
		c.Resetar();
		
	}
}
