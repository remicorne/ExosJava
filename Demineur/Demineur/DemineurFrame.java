package Demineur;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class DemineurFrame extends JFrame{
	
	private  static final long serialVersionUID = 1L;
	
	public DemineurFrame() {
		setSize(500, 500);
		setBackground(Color.pink);
		setMinimumSize(new Dimension(300,300));
		setTitle("Démineur CCI 2020");

		setJMenuBar(new DemineurJMenuBar());
	}

}
