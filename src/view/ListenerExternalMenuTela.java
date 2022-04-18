package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControladorTela;

public class ListenerExternalMenuTela implements ActionListener{

	private int i;
	private Tela tela;
	
	public ListenerExternalMenuTela(int i, Tela tela) {
		this.i = i;
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorTela c = new ControladorTela();
		
		switch(i) {
			case 0:
				c.NovoJogo();
				new Tela();
				break;
			case 1:
				c.setDerrota(true);
				new Tela();

		}
		tela.dispose();
		
	}

}
