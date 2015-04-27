package juegodelavida.pai;
/**
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;

public class JuegoDeLaVidaFrame extends JApplet{
	private MenuPanel menu;
	private JuegoDeLaVidaPanel juegoPanel;
	private Timer temporizador;
	
	public static final int DELAY_DEFECTO = 66;
	
	public JuegoDeLaVidaFrame() {
		setJuegoPanel(new JuegoDeLaVidaPanel());
		setMenu(new MenuPanel(this));
		setTemporizador(new Timer(DELAY_DEFECTO, new HandlerTemporizador()));
		this.add(getMenu(), BorderLayout.SOUTH);
		this.add(getJuegoPanel());	
	}

	public void init() {
		//setTitle("Juego de la vida");
		setSize(1200, 800);
		//this.set
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	public static void main(String[] args) {
		 JFrame frame = new JFrame();
		 frame.setTitle("Juego de la vida");
		 frame.setSize(1200, 500);
		 frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.add(new JuegoDeLaVidaFrame());
		 frame.setVisible(true);
		 

	}
	
	
	public void reset() {
		getTemporizador().stop();
		getJuegoPanel().reset();
		repaint();
	}
	public Timer getTemporizador() {
		return temporizador;
	}


	public void setTemporizador(Timer temporizador) {
		this.temporizador = temporizador;
	}


	public MenuPanel getMenu() {
		return menu;
	}


	public JuegoDeLaVidaPanel getJuegoPanel() {
		return juegoPanel;
	}


	public void setJuegoPanel(JuegoDeLaVidaPanel juegoPanel) {
		this.juegoPanel = juegoPanel;
	}


	public void setMenu(MenuPanel menu) {
		this.menu = menu;
	}
	class HandlerTemporizador implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			getJuegoPanel().siguienteGeneracion();
			
		}
		
	}
}

