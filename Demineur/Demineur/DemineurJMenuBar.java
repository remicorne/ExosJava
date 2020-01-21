package Demineur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class DemineurJMenuBar extends JMenuBar{
	private  static final long serialVersionUID = 1L;

	public DemineurJMenuBar() {
		
		JMenu options = new JMenu("Options");
		
		JMenuItem quitter = new JMenuItem("quitter");
		JMenuItem recommencer = new JMenuItem("recommencer");
		JMenuItem aide = new JMenuItem("aide");
		
		options.add(quitter);
		options.add(recommencer);
		options.add(aide);
		
		add(options);
		

		aide.addActionListener(new AideAction());
		quitter.addActionListener(new QuitterAction());

	}
}
