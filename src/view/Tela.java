package view;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControladorTela;

public class Tela extends JFrame{
	private ControladorTela c = new ControladorTela();
	private ArrayList<String[]> campo;
	private boolean isDerrota;
	
	
	
	public Tela() {
		campo  = c.invocarCampo();
		isDerrota = c.isDerrota();
		setTitle("Campo Minado");
		setResizable(false);
		setLayout(null);
		setSize(573,650);
		setLocationRelativeTo(null);
		addCampo();
		addMenu();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void addCampo() {
		int x = 2;
		int y = 2;
		for(int i = 0; i < campo.size(); i++) {
			for(int j = 0; j < campo.get(i).length; j++) {
				JButton bt = new JButton();
				bt.setBounds(y, x, 60, 60);
				bt.setBackground(Color.gray);
				if(isDerrota) {
					bt.setText(campo.get(i)[j]);
					bt.setBackground(campo.get(i)[j].equals("B") ? Color.red : Color.white);
					bt.setEnabled(false);
				}
				bt.setBorder(null);
				
				bt.addActionListener(new ListenerExternalCamposTela(i,j,campo, bt, this));
				
				add(bt);
				x+=62;
			}
			y += 62;
			x = 2;
			
		}
	
	}
	
	public void addMenu() {
		int x = 2;
		String[] nomes = {"Novo Jogo", "Mostrar Campo", "Sair"};
		
		for(int i = 0; i < nomes.length; i++) {
			JButton bt = new JButton(nomes[i]);
			bt.setBackground(Color.black);
			bt.setForeground(Color.white);
			bt.setBounds(x, 565, 170, 40);
			bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
			
			bt.addActionListener(new ListenerExternalMenuTela(i, this));
			
			add(bt);
			x+= 193;
		}
	}
	
	public void NovoJogo() {
		c.NovoJogo();
	}
}

