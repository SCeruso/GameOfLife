package juegodelavida.pai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class JuegoDeLaVidaPanel extends JPanel{

	private JuegoDeLaVidaGrafico juego;
	public static final int SIZE_CELDA = 6;
	
	public JuegoDeLaVidaPanel() {
		setJuego(new JuegoDeLaVidaGrafico(0, 0, 0, 0));
		MouseHandler mousehandler = new MouseHandler();
		this.addComponentListener(new SizeChangeListener());
		this.addMouseListener(mousehandler);
		this.addMouseMotionListener(mousehandler);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g.create());
		getJuego().paint(g.create());
	}
	public void reset(){
		setJuego(new JuegoDeLaVidaGrafico(getWidth(), getHeight(), getHeight() / SIZE_CELDA, getWidth() / SIZE_CELDA));
	}
	public void siguienteGeneracion() {
		getJuego().siguienteGeneracion();
		repaint();
	}
	public void setColorCelda(Color color) {
		getJuego().setColorCelda(color);
		repaint();
	}
	public void setColorRecorrido(Color color) {
		getJuego().setColorRecorrido(color);
		repaint();
	}
	public JuegoDeLaVidaGrafico getJuego() {
		return juego;
	}

	public void setJuego(JuegoDeLaVidaGrafico juego) {
		this.juego = juego;
	}
	class MouseHandler implements MouseListener, MouseMotionListener {
			private boolean matando;

		@Override
		public void mouseClicked(MouseEvent e) {
			getJuego().cambiarEstado(e.getPoint());
			matando = false;
			repaint();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {	
			if (!getJuego().estaViva(e.getPoint())) {
				matando = false;
			}
			else {
				matando = true;
			}	
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			matando = false;
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		
			if (!matando)
				getJuego().nacer(e.getPoint());
			else
				getJuego().matar(e.getPoint());
			
			repaint();
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class SizeChangeListener implements ComponentListener {

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
			setJuego(new JuegoDeLaVidaGrafico(getWidth(), getHeight(), getHeight() / SIZE_CELDA, getWidth() / SIZE_CELDA));
			repaint();
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
