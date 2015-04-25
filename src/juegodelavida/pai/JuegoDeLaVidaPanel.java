package juegodelavida.pai;

import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class JuegoDeLaVidaPanel extends JPanel{
	private Tabla tabla;
	private JuegoDeLaVida juegoDeLaVida;
	private boolean a = false;
	
	public JuegoDeLaVidaPanel() {
		this.addComponentListener(new SizeChangeListener());
		this.addMouseListener(new MouseHandler());
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g.create());
		getTabla().paintTabla(g.create());
		
		for (int i = 0; i < getJuegoDeLaVida().getnFilas(); i++) {
			for (int j = 0; j < getJuegoDeLaVida().getnCols(); j++) {
				if (getJuegoDeLaVida().estaViva(i, j))
					getTabla().paintCell(j, i, g.create());
			}
		}
	}
	public void siguienteGeneracion() {
		getJuegoDeLaVida().siguienteGeneracion();
		repaint();
	}
	public JuegoDeLaVida getJuegoDeLaVida() {
		return juegoDeLaVida;
	}
	public void setJuegoDeLaVida(JuegoDeLaVida juegoDeLaVida) {
		this.juegoDeLaVida = juegoDeLaVida;
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println(e.getPoint());
			getJuegoDeLaVida().cambiarEstado(getTabla().getCoordinates(e.getPoint()));
			System.out.println(getTabla().getCoordinates(e.getPoint()));
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
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
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
			setTabla(new Tabla(getWidth(), getHeight(), getHeight() / 10, getWidth() / 10));
		//	setTabla(new Tabla(getWidth(), getHeight(), 8, 5));
			setJuegoDeLaVida(new JuegoDeLaVida(getTabla().getNfilas(), getTabla().getNcols()));
			repaint();
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
