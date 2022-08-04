package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

import controller.ControladorTela;

public class ListenerExternalCamposTela implements ActionListener{
	private int index;
	private int index2;
	private ArrayList<String[]> c;
	private JButton bt;
	private JFrame tela;
	private ArrayList<JButton[]> bts;
	private ControladorTela ct;
	
	public ListenerExternalCamposTela(int i, int j, ArrayList<String[]> cp, JButton b, JFrame t, ArrayList<JButton[]> bts) {
		index = i;
		index2 = j;
		c = cp;
		bt = b;
		tela = t;
		this.bts = bts;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ct = new ControladorTela();
		if(c.get(index)[index2].equals("B")) {
			JOptionPane.showMessageDialog(null, "BOMMMM!");
			bt.setBackground(Color.red);
			bt.setText(c.get(index)[index2]);
			ct.setDerrota(true);
			tela.dispose();
			new Tela();
			
		}else {
			
			bt.setBackground(Color.white);
			bt.setText(c.get(index)[index2]);
			ct.setAcertos(ct.getAcertos()+1);
			for(int i = 0; i < 20; i++)
				abrirCampos();
		}
		
		bt.setBorder(null);
		bt.setEnabled(false);
		
		if(ct.getAcertos() == 71) {
			JOptionPane.showMessageDialog(null, "VOCÊ GANHOU BEBER");
			ct.setDerrota(true);
			tela.dispose();
			new Tela();
		}	
	}
	public void setar(int i, int j) {
		bts.get(i)[j].setBackground(Color.white);
		bts.get(i)[j].setText(c.get(i)[j]);
		bts.get(i)[j].setBorder(null);
		bts.get(i)[j].setEnabled(false);
		ct.setAcertos(ct.getAcertos()+1);
	}
	
	public void abrirCampos() {
		for(int i = 0; i < bts.size(); i++) {
			for(int j = 0; j < bts.get(i).length; j++) {
				if(bts.get(i)[j].getBackground() == Color.white && c.get(i)[j].equals(" ")) {
					try {if(!c.get(i-1)[j-1].equals("B") && c.get(i-1)[j-1].equals(" ")) {setar(i-1, j-1);}
					}catch(Exception e) {}
					
					try {if(!c.get(i-1)[j].equals("B")) {setar(i-1, j);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i-1)[j+1].equals("B") && c.get(i-1)[j+1].equals(" ")) {setar(i-1, j+1);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i)[j-1].equals("B")) {setar(i, j-1);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i)[j+1].equals("B")) {setar(i, j+1);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i+1)[j-1].equals("B") && c.get(i+1)[j-1].equals(" ")) {setar(i+1, j-1);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i+1)[j].equals("B")) {setar(i+1, j);}	
					}catch(Exception e) {}
					
					try {if(!c.get(i+1)[j+1].equals("B") && c.get(i+1)[j+1].equals(" ")) {setar(i+1, j+1);}	
					}catch(Exception e) {}
				}
			}
		}
	}

}
