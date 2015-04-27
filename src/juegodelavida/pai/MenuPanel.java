package juegodelavida.pai;

/**
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
/**
 * Clase contenedora del menu GUI.
 * @author Sabato
 *
 */
public class MenuPanel extends JPanel {
	private JButton reset;
	private JButton lanzar;
	private JButton recorrido;
	private JButton color1;
	private JButton color2;
	private JSlider vel;
	private JButton apuntar;
	
	private JuegoDeLaVidaFrame containerFrame;			// Componente a cambiar.
	
	public MenuPanel(JuegoDeLaVidaFrame parent) {
		setContainerFrame(parent);
		setLanzar(new JButton("Empezar"));
		setRecorrido(new JButton("Paso"));
		setColor1(new JButton("Color celda"));
		setColor2(new JButton("Color visitado"));
		setVel(new JSlider(10, 20, 15));
		setReset(new JButton("Reset"));
		apuntar = new JButton("Apuntar");
		apuntar.addActionListener(new ButtonsHandler());
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2, 1));
		panel2.add(getColor1());
		panel2.add(getColor2());
		panel.setLayout(new FlowLayout());
		panel.setLayout(new BorderLayout());
		panel.add(new JLabel("Velocidad"), BorderLayout.WEST);
		panel.add(getVel(), BorderLayout.CENTER);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.setLayout(new GridLayout(1, 4));	  

		getVel().setMajorTickSpacing(2);
	//	getVel().setMinorTickSpacing(25);
		getVel().setPaintLabels(true);
		getVel().setPaintTicks(true);
		getVel().addChangeListener(new SliderHandler());
		getLanzar().addActionListener(new ButtonsHandler());
		getReset().addActionListener(new ButtonsHandler());
		getRecorrido().addActionListener(new ButtonsHandler());
		getColor1().addActionListener(new ButtonsHandler());
		getColor2().addActionListener(new ButtonsHandler());
		this.add(getLanzar());
		this.add(panel);
		this.add(getRecorrido());
		//this.add(panel2);
		this.add(getReset());
		this.requestFocus();
	}

	public JButton getReset() {
		return reset;
		
	}

	public void setReset(JButton reset) {
		this.reset = reset;
	}

	public JButton getLanzar() {
		return lanzar;
	}

	public void setLanzar(JButton lanzar) {
		this.lanzar = lanzar;
	}

	public JButton getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(JButton recorrido) {
		this.recorrido = recorrido;
	}

	public JButton getColor1() {
		return color1;
	}

	public void setColor1(JButton color1) {
		this.color1 = color1;
	}

	public JButton getColor2() {
		return color2;
	}

	public void setColor2(JButton color2) {
		this.color2 = color2;
	}

	public JSlider getVel() {
		return vel;
	}

	public void setVel(JSlider vel) {
		this.vel = vel;
	}

	public JuegoDeLaVidaFrame getContainerFrame() {
		return containerFrame;
	}

	public void setContainerFrame(JuegoDeLaVidaFrame panelObj) {
		this.containerFrame = panelObj;
	}
	
	class SliderHandler implements javax.swing.event.ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			int vel = getVel().getValue();
			
			getContainerFrame().getTemporizador().setDelay(1000 / vel);
		}

	
	}
	/**
	 * Manejadores para los botones.
	 * @author Sabato
	 *
	 */
	class ButtonsHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == getLanzar()) {
				if (getContainerFrame().getTemporizador().isRunning()) {
					getContainerFrame().getTemporizador().stop();
					getLanzar().setText("Empezar");
				}
				else {
					getContainerFrame().getTemporizador().start();
					getLanzar().setText("Parar");
				}
			}
			else if(e.getSource() == getReset()) {
				getContainerFrame().reset();
				getLanzar().setText("Empezar");
			}
			else if (e.getSource() == getRecorrido()) {
				getLanzar().setText("Empezar");
				getContainerFrame().getTemporizador().stop();
				getContainerFrame().getJuegoPanel().siguienteGeneracion();
			}
			else if (e.getSource() == getColor1()) {
				Color color = JColorChooser.showDialog(getContainerFrame(), "Elija un color", Color.BLACK);
				if (color != null)
					getContainerFrame().getJuegoPanel().setColorCelda(color);
			}
			else if (e.getSource() == getColor2()) {
				Color color = JColorChooser.showDialog(getContainerFrame(), "Elija un color", Color.WHITE);
				if (color != null)
					getContainerFrame().getJuegoPanel().setColorRecorrido(color);
			}
		}
		
	}
}
