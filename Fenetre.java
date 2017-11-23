
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Fenetre extends JFrame {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Mouvement m = new Mouvement();
	public static JButton b1 = new Bouton("Go");
	public static JButton b2 = new Bouton("Stop");
	public static JLabel label = new JLabel("Game of Thrones");
	private static boolean animated = true;
	
	
	public Fenetre(){
	    this.setTitle("Game of Thrones");
	    this.setSize(400, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    this.setVisible(true);
	  
	    // Construction des panels qui relient aux boutons.
	    JPanel pane = new JPanel();
	    b1.addActionListener(new BoutonListener());  
	    b2.addActionListener(new Bouton2Listener()); 	    
	    pane.add(b1);
	    pane.add(b2);

	    // Construction des labels.
	    JPanel pane2 = new JPanel();
	    pane2.add(label);
	    label.setFont(new Font("Tahoma", Font.BOLD, 16));
	    label.setForeground(Color.blue);
	    label.setHorizontalAlignment(JLabel.CENTER);
	    
	    // Séparer le frame en plusieurs parties.
	    this.getContentPane().add(pane, BorderLayout.SOUTH);
	    this.getContentPane().add(pane2, BorderLayout.NORTH);
	    this.getContentPane().add(m, BorderLayout.CENTER);
	    depart();
	}
	
	
	public static void depart(){
		int backX = 0;
		int backY = 0;
		int x = m.getPosX(), y = m.getPosY();
		while(animated){
		    if(backX == 0) x++;
		    if(backY == 0) y++;
		    if(backX == 1) x--;
		    if(backY == 1) y--;
		    
		    m.setPosX(x);
		    m.setPosY(y);
		    m.repaint();  
		    try {
		        Thread.sleep(5);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      }

		    // Si on rencontre les bords, on commence à reculer.
		    if(x == m.getWidth()-50) backX = 1;
		    if(x == 0) backX = 0;
		    if(y == m.getHeight()-50) backY = 1;
		    if(y == 0) backY = 0;
		  }
	}

	// Interaction avec des boutons.
	class BoutonListener implements ActionListener{
	    public void actionPerformed(ActionEvent arg0) {
	      animated = true;
	      b1.setEnabled(false);
	      b2.setEnabled(true);
	      ThreadMov t = new ThreadMov();
	      t.start();
	    }
	  }

	  class Bouton2Listener implements ActionListener{
	     public void actionPerformed(ActionEvent e) {
	      animated = false;     
	      b1.setEnabled(true);
	      b2.setEnabled(false);
	    }
	  }     
}
