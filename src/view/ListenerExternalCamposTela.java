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
	
	public ListenerExternalCamposTela(int i, int j, ArrayList<String[]> cp, JButton b, JFrame t) {
		index = i;
		index2 = j;
		c = cp;
		bt = b;
		tela = t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorTela ct = new ControladorTela();
		if(c.get(index)[index2].equals("B")) {
			
			bt.setBackground(Color.red);
			bt.setText(c.get(index)[index2]);
			ct.setDerrota(true);
			tela.dispose();
			new Tela();
			
		}else {
			
			bt.setBackground(Color.white);
			bt.setText(c.get(index)[index2]);
			
			ct.setAcertos(ct.getAcertos()+1);
		}
		
		bt.setBorder(null);
		bt.setEnabled(false);
		
		if(ct.getAcertos() == 71)
			JOptionPane.showMessageDialog(null, "VOCÊ GANHOU BEBER");
			
	}
	

	

}
