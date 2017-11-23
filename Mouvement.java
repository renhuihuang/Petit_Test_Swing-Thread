import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Mouvement extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int posX = 0;
	private int posY = 0;
	  
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void paintComponent(Graphics g){
		// Pour supprimer l'ancien.
		g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
	    
	    // Afficher le nouveau.
		g.setColor(Color.red);
	    g.fillOval(posX, posY, 50, 50);
	}
}
