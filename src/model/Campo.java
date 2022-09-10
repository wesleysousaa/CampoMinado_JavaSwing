package model;

import java.util.ArrayList;

public class Campo {

	private int bombas = 10;
	private ArrayList<String[]> campo = new ArrayList();
	private static Campo instancia;
	private boolean derrota;
	private int acertos;
	
	private Campo() {
		setDerrota(false);
		setAcertos(0);
		this.criarCampo();
		this.addElementos();
	}
	
	public static Campo getInstancia() {
		if(instancia == null) {
			instancia = new Campo();
		}
		return instancia;
	}
	
	public void Resetar() {
		instancia = null;
	}
	
	private ArrayList<String[]> criarCampo(){
		
		for(int i = 0; i < 9; i++) {
			String[] linha = new String[9];
			campo.add(linha);
			
		}
		return campo;
	}
	
	private ArrayList<String[]> addElementos() {
		
		while(!(bombsInCamp())) {
			int index1  = (int) (Math.random() * 8);
			int index2  = (int) (Math.random() * 8);
			campo.get(index1)[index2] = "B";
		}
		
		for(int i = 0; i < campo.size(); i++) {
			for(int j = 0; j < campo.get(i).length; j++) {
				if(campo.get(i)[j] == null) {
					campo.get(i)[j] = " ";
				}
			}
		}
		
		for(int i = 0; i < campo.size(); i++) {
			int c = 0;
			for(int j = 0; j < campo.get(i).length; j++) {
				if(campo.get(i)[j].equals(" ")) {
					try {if(campo.get(i-1)[j-1].equals("B"))c++;}catch(Exception e) {}
					try {if(campo.get(i-1)[j].equals("B"))c++;}catch(Exception e) {}
					try {if(campo.get(i-1)[j+1].equals("B"))c++;}catch(Exception e) {}
					
					try {if(campo.get(i)[j-1].equals("B"))c++;}catch(Exception e) {}
					try {if(campo.get(i)[j+1].equals("B"))c++;}catch(Exception e) {}
					
					try {if(campo.get(i+1)[j-1].equals("B"))c++;}catch(Exception e) {}
					try {if(campo.get(i+1)[j].equals("B"))c++;}catch(Exception e) {}
					try {if(campo.get(i+1)[j+1].equals("B"))c++;}catch(Exception e) {}
				}
				if(c > 0)
					campo.get(i)[j] = String.valueOf(c);
				c=0;
			}
		}
		return campo;
	}
	
	public boolean bombsInCamp() {
		int c = 0;
		for(int i = 0; i < campo.size(); i++) {
			for(int j = 0; j < campo.get(i).length; j++) {
				if(campo.get(i)[j] != null && campo.get(i)[j].equals("B"))
					c ++;
			}
		}
		return c == this.bombas;
	}
	
	public ArrayList<String[]> getCampo(){
		return this.campo;
	}

	public boolean isDerrota() {
		return derrota;
	}

	public void setDerrota(boolean derrota) {
		this.derrota = derrota;
	}

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}
}
