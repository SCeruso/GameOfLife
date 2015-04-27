package juegodelavida.pai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class JuegoDeLaVidaGrafico {
	private Tabla tabla;
	private JuegoDeLaVida juego;
	private Color colorCelda;
	private Color colorRecorrido;
	public static Color COLOR_CELDA_DEFECTO = Color.BLACK;
	public static Color COLOR_VISITADO_DEFECTO = new Color(101, 255, 111);
	
	public JuegoDeLaVidaGrafico(int ancho, int alto, int nfilas, int ncols) {
		setTabla(new Tabla(ancho, alto, nfilas, ncols));
		setJuego(new JuegoDeLaVida(ncols, nfilas));			// Aqui tambien
		setColorCelda(COLOR_CELDA_DEFECTO);
		setColorRecorrido(COLOR_VISITADO_DEFECTO);
	}
	public void generarAleatorio(int max) {
		// Implementar un generador aleatorio.
	}
	public boolean estaViva(Point p) {
		Point aux = getTabla().getCoordinates(p);
		return getJuego().estaViva((int)aux.getX(), (int)aux.getY());
	}
	public void nacer(Point p) {
		getJuego().nacer(getTabla().getCoordinates(p));
	}
	public void matar(Point p) {
		getJuego().matar(getTabla().getCoordinates(p));
	}
	public void cambiarEstado(Point p) {	//Aqui se puede intercambiar.
		getJuego().cambiarEstado(getTabla().getCoordinates(p));
	}
	public void siguienteGeneracion() {
		getJuego().siguienteGeneracion();
	}
	public void paint(Graphics g) {
		getTabla().paintTabla(g.create());
		
		for (int i = 0; i < getJuego().getnFilas(); i++) {
			for (int j = 0; j < getJuego().getnCols(); j++) {
				if (getJuego().estaViva(i, j)) {
					getTabla().setCellColor(getColorCelda());
					getTabla().paintCell(i, j, g.create());		// y aqui
				}
				else if(getJuego().estaVisitado(i, j)) {
					getTabla().setCellColor(getColorRecorrido());
					getTabla().paintCell(i, j, g.create());
				}
			}
		}
	}
	public Tabla getTabla() {
		return tabla;
	}
	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}
	public JuegoDeLaVida getJuego() {
		return juego;
	}
	public void setJuego(JuegoDeLaVida juego) {
		this.juego = juego;
	}

	public Color getColorCelda() {
		return colorCelda;
	}

	public void setColorCelda(Color colorCelda) {
		this.colorCelda = colorCelda;
	}

	public Color getColorRecorrido() {
		return colorRecorrido;
	}

	public void setColorRecorrido(Color colorRecorrido) {
		this.colorRecorrido = colorRecorrido;
	}
	
	
}
