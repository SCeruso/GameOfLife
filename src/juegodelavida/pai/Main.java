package juegodelavida.pai;

import javax.swing.JFrame;


public class Main {

	public static void main(String[] args) {
		 JuegoDeLaVidaFrame frame = new JuegoDeLaVidaFrame();
		 frame.setTitle("Juego de la vida");
		 frame.setSize(1200, 500);
		// frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 

	}

}
