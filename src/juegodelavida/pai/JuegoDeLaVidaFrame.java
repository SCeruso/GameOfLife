package juegodelavida.pai;
/**
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

public class JuegoDeLaVidaFrame extends JFrame{
	private MenuPanel menu;
	private JuegoDeLaVidaPanel juegoPanel;
	
	public JuegoDeLaVidaFrame() {
		setJuegoPanel(new JuegoDeLaVidaPanel());
		setMenu(new MenuPanel(this));
		this.addComponentListener(new WindowHandler());
		this.add(getMenu(), BorderLayout.SOUTH);
		this.add(getJuegoPanel());
	//	getTiroParabolicoPanel().getSkyPanel().requestFocus();
	
		
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
	class WindowHandler implements ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}

