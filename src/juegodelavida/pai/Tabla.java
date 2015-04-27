package juegodelavida.pai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Tabla {
	private int nfilas;
	private int ncols;
	private double espacioFilas;
	private double espacioCols;
	private int ancho;
	private int alto;
	private Color cellColor;
	
	
	
	public Tabla (int ancho, int alto, int nfilas, int ncols) {
		setAlto(alto);
		setAncho(ancho);
		setNfilas(nfilas);
		setNcols(ncols);
		setEspacioCols((double)((double)ancho / (double)ncols));
		setEspacioFilas((double)((double)alto / (double)nfilas));
		setCellColor(JuegoDeLaVidaGrafico.COLOR_CELDA_DEFECTO);
	}

	public void paintTabla (Graphics g) {		
		g.setColor(Color.GRAY);
		
		for (int i = 1; i < getNfilas(); i++) {
			g.drawLine(0, (int)(i * getEspacioFilas()), getAncho(), (int)(i * getEspacioFilas()));
		}
		
		for (int i = 1; i < getNcols(); i++) {
			g.drawLine((int)(i * getEspacioCols()), 0, (int)(i * getEspacioCols()), getAlto());
		}
	}
	public void paintCell(int coordX, int coordY, Graphics g) {
		int ancho = (int)Math.ceil(getEspacioCols());
		int alto = (int)Math.ceil(getEspacioFilas());
		
		g.setColor(getCellColor());
		
		g.fillRect((int)(coordX * getEspacioCols()), (int)(coordY * getEspacioFilas()), ancho, alto);
	}
	
	public Point getCoordinates(Point p) {
		return new Point((int)(p.getX() / getEspacioCols()),
						(int)(p.getY() / getEspacioFilas()));
	}
	public int getNfilas() {
		return nfilas;
	}

	public void setNfilas(int nfilas) {
		this.nfilas = nfilas;
	}

	public int getNcols() {
		return ncols;
	}

	public void setNcols(int ncols) {
		this.ncols = ncols;
	}

	public double getEspacioFilas() {
		return espacioFilas;
	}

	public void setEspacioFilas(double espacioFilas) {
		this.espacioFilas = espacioFilas;
	}

	public double getEspacioCols() {
		return espacioCols;
	}

	public void setEspacioCols(double espacioCols) {
		this.espacioCols = espacioCols;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public Color getCellColor() {
		return cellColor;
	}

	public void setCellColor(Color cellColor) {
		this.cellColor = cellColor;
	}
	
	
}
