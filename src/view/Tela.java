package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import controller.ControladorTela;

public class Tela extends JFrame{
	
	private ControladorTela c = new ControladorTela();
	private ArrayList<String[]> campo;
	private boolean isDerrota;
	private ArrayList<JButton[]> bts;
	private Image bomb;
	
	public Tela() {
		try {bomb = ImageIO.read(getClass().getResource("/img/bomb.png"));} 
		catch(Exception ex) {ex.printStackTrace();}
		campo  = c.invocarCampo();
		isDerrota = c.isDerrota();
		bts = new ArrayList<JButton[]>();
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
			JButton[] linhaBts = new JButton[9];
			for(int j = 0; j < campo.get(i).length; j++) {
				JButton bt = new JButton();
				bt.setBounds(y, x, 60, 60);
				bt.setBackground(Color.gray);
				if(isDerrota) {
					if(campo.get(i)[j].equals("B")) 
						bt.setIcon(new ImageIcon(bomb));
					else 
						bt.setText(campo.get(i)[j]);
					bt.setBackground(Color.white);
					bt.setEnabled(false);
					
				}
				bt.setToolTipText("Botão direito para sinalizar ou remover bomba");
				bt.setBorder(null);
				bt.setCursor(new Cursor(Cursor.HAND_CURSOR));
				bt.addMouseListener(new ListenerExternalCamposTela(i,j,campo, bt, this, bts));
				
				linhaBts[j] = bt;
				add(bt);
				x+=62;
			}
			y += 62;
			x = 2;
			bts.add(linhaBts);
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

