package juegodelavida.pai;

import java.awt.Point;
import java.util.ArrayList;
import java.util.BitSet;

public class JuegoDeLaVida {
	private ArrayList<BitSet> estadoActual;
	private ArrayList<BitSet> estadoSiguiente;
	private ArrayList<BitSet> visitados;
	private BitSet reglaSupervivencia;
	private BitSet reglaNacimiento;
	private int nFilas;
	private int nCols;

	public static final int[] REGLA_NACIMIENTO_DEFECTO = {3};
	public static final int[] REGLA_SUPERVIVENCIA_DEFECTO = {2, 3};
	
	
	public JuegoDeLaVida(int nFilas, int nCols) {
		setnCols(nCols);
		setnFilas(nFilas);
		setVisitados(new ArrayList<BitSet>());
		setReglaNacimiento(REGLA_NACIMIENTO_DEFECTO);
		setReglaSupervivencia(REGLA_SUPERVIVENCIA_DEFECTO);
		setEstadoActual(new ArrayList<BitSet>());
		setEstadoSiguiente(new ArrayList<BitSet>());
		
		for (int i = 0; i < nFilas; i++)
			getEstadoActual().add(new BitSet());
		for (int i = 0; i < nFilas; i++)
			getEstadoSiguiente().add(new BitSet());
		for (int i = 0; i < nFilas; i++)
			getVisitados().add(new BitSet());
	}
	
	
	public void siguienteGeneracion() {
		ArrayList<BitSet> aux;
		 
		for (int i = 0; i < getnFilas(); i++) {
			getEstadoSiguiente().get(i).clear();
			for (int j = 0; j < getnCols(); j++) {
				if (getEstadoActual().get(i).get(j)) {
					if (getReglaSupervivencia().get(getNumeroVecinos(i, j)))
						getEstadoSiguiente().get(i).set(j);
				}
				else {
					if (getReglaNacimiento().get(getNumeroVecinos(i, j))) {
						getEstadoSiguiente().get(i).set(j);
						addVisitado(new Point(i, j));
					}
				}
			}
		}
		aux = getEstadoActual();
		setEstadoActual(getEstadoSiguiente());
		setEstadoSiguiente(aux);
	}
	
	public boolean estaViva(int i, int j) {
		i = (i + getnFilas()) % getnFilas();
		j = (j + getnCols()) % getnCols();
		return getEstadoActual().get(i).get(j);
	}
	public boolean estaVisitado(int i, int j) {
		return getVisitados().get(i).get(j);
	}
	
	public void matar (Point cel) {
		getEstadoActual().get((int)cel.getX()).clear((int)cel.getY());
	}
	public void nacer(Point cel) {
		getEstadoActual().get((int)cel.getX()).set((int)cel.getY());
		addVisitado(cel);
	}
	public void cambiarEstado(Point cel) {
		getEstadoActual().get((int)cel.getX()).flip((int)cel.getY());
		if (estaViva((int)cel.getX(), (int)cel.getY()))
			addVisitado(cel);
	}
	private void addVisitado(Point cel) {
		getVisitados().get((int)cel.getX()).set((int)cel.getY());
	}
	private int getNumeroVecinos(int indxI, int indxJ) {
		int nVecinos = 0;
		
	//	if (indxI > 0) {
			if (estaViva(indxI - 1, indxJ))
				nVecinos++;
	//		if (indxJ > 0)
				if (estaViva(indxI - 1, indxJ - 1))
					nVecinos++;
			if (estaViva(indxI - 1, indxJ + 1))
				nVecinos++;
		//}
		//if (indxJ > 0)
			if (estaViva(indxI, indxJ - 1))
				nVecinos++;
		if (estaViva(indxI, indxJ + 1))
			nVecinos++;
	//	if (indxI < getnFilas() - 1) {
			if (estaViva(indxI + 1, indxJ))
				nVecinos++;
		//	if (indxJ > 0)
				if (estaViva(indxI + 1, indxJ - 1))
					nVecinos++;
			if (estaViva(indxI + 1, indxJ + 1))
				nVecinos++;
		//}
		return nVecinos;
	}
	/**
	 * Getters y setters ******************************************************
	 * @return
	 */
	
	public int getnFilas() {
		return nFilas;
	}

	public ArrayList<BitSet> getVisitados() {
		return visitados;
	}


	public void setVisitados(ArrayList<BitSet> visitados) {
		this.visitados = visitados;
	}


	public void setnFilas(int nFilas) {
		this.nFilas = nFilas;
	}

	public int getnCols() {
		return nCols;
	}

	public void setnCols(int nCols) {
		this.nCols = nCols;
	}

	public ArrayList<BitSet> getEstadoActual() {
		return estadoActual;
	}
	public void setEstadoActual(ArrayList<BitSet> estadoActual) {
		this.estadoActual = estadoActual;
	}
	public ArrayList<BitSet> getEstadoSiguiente() {
		return estadoSiguiente;
	}
	public void setEstadoSiguiente(ArrayList<BitSet> estadoSiguiente) {
		this.estadoSiguiente = estadoSiguiente;
	}
	private BitSet getReglaSupervivencia() {
		return reglaSupervivencia;
	}
	public void setReglaSupervivencia(int[] reglaSupervivencia) {
		this.reglaSupervivencia = new BitSet();
		for (int i = 0; i < reglaSupervivencia.length; i++) {
			this.reglaSupervivencia.set(reglaSupervivencia[i]);
		}
	}
	private BitSet getReglaNacimiento() {
		return reglaNacimiento;
	}
	public void setReglaNacimiento(int[] reglaNacimiento) {
		this.reglaNacimiento = new BitSet();
		for (int i = 0; i < reglaNacimiento.length; i++) {
			this.reglaNacimiento.set(reglaNacimiento[i]);
		}
	}
	
	
	
}
