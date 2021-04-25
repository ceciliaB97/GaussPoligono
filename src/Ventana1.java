import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.Data;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;

public class Ventana1 extends JFrame {

	private JPanel contentPane;
	private static JTextField coordsX;
	private static JTextField coordsY;

	
	public static void setCoordsX(JTextField s) {
		s = coordsX;
	}
	
	public static void setCoordsY(JTextField r) {
		r = coordsY;
	}
	
	public static JTextField getCoordsX() {
		return coordsX;
	}
	
	public static JTextField getCoordsY() {
		return coordsY;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana1 frame = new Ventana1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventana1() {
		setTitle("GaussPoligono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtCoordsX = new JLabel("Ingrese las coordenadas en x: ");
		txtCoordsX.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		txtCoordsX.setBounds(12, 56, 184, 16);
		contentPane.add(txtCoordsX);
		
		coordsX = new JTextField();
		coordsX.setBounds(219, 56, 188, 22);
		contentPane.add(coordsX);
		coordsX.setColumns(10);
		
		JLabel txtCoordsY = new JLabel("Ingrese las coordenadas en y: ");
		txtCoordsY.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		txtCoordsY.setBounds(12, 85, 184, 16);
		contentPane.add(txtCoordsY);
		
		coordsY = new JTextField();
		coordsY.setColumns(10);
		coordsY.setBounds(219, 85, 188, 22);
		contentPane.add(coordsY);
		
		
		final Datos area = new Datos();
		JButton btnCalculate = new JButton("Calcular");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double[] coordsYM = Datos.getCoordsYDatos();
				double[] coordsXM = Datos.getCoordsXDatos();
				
				//JOptionPane.showMessageDialog(null, "Coordenadas en X son: " + Arrays.toString(coordsXM));
				//JOptionPane.showMessageDialog(null, "Coordenadas en Y son: " + Arrays.toString(coordsYM));
				
				double[] valoresX = Datos.recorrerCoordsDatos(coordsXM, coordsYM);
				double[] valoresY = Datos.recorrerCoordsDatos(coordsYM, coordsXM);
				
				double sumatoriaX = Datos.sumatoriaDatos(valoresX);
				double sumatoriaY = Datos.sumatoriaDatos(valoresY);
				
				//JOptionPane.showMessageDialog(null, "Sumatoria de X es: " + sumatoriaX);
				//JOptionPane.showMessageDialog(null, "Sumatoria de Y es: " + sumatoriaY);
				
				if(coordsYM.length != coordsXM.length) {
					JOptionPane.showMessageDialog(null, "Las coordenadas deben de X e Y deben tener la misma longitud, intentelo nuevamente");
				}
			
				if(coordsYM.length > 0 && coordsYM.length <= 3 || coordsXM.length > 0 && coordsXM.length <= 3 ) {
					JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
				}
				
				if(coordsYM.length > 3 && coordsXM.length > 3) {
				if(sumatoriaX > sumatoriaY) {
					double diferenciaXY = sumatoriaX - sumatoriaY;
					double resultado = diferenciaXY/2;
					JOptionPane.showMessageDialog(null, "El area del poligono irregular en valor absoluto es: \n" + resultado);
				} else if(sumatoriaY > sumatoriaX) {
					double diferenciaXY = sumatoriaY - sumatoriaX;
					double resultado = diferenciaXY/2;
					JOptionPane.showMessageDialog(null, "El area del poligono irregular en valor absoluto es: \n" + resultado);
					}
				}
	
			}
		});
		btnCalculate.setBounds(125, 120, 170, 25);
		contentPane.add(btnCalculate);
		
		JLabel lblTitulo = new JLabel("Formula de Gauss: Ingresa los valores separados por una coma \",\".");
		lblTitulo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitulo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		lblTitulo.setBounds(12, 13, 397, 16);
		contentPane.add(lblTitulo);
		
		JButton btnFormula = new JButton("Mostrar Formula");
		btnFormula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double[] coordsYM = Datos.getCoordsYDatos();
				double[] coordsXM = Datos.getCoordsXDatos();
	
				String x = "x";
				String y = "y";
				
				String[] formulaXLetras = Datos.formulaGaussLetras(coordsXM, coordsYM, x, y);
				String[] formulaYLetras = Datos.formulaGaussLetras(coordsYM, coordsXM, y, x);
				
				if(coordsYM.length != coordsXM.length) {
					JOptionPane.showMessageDialog(null, "Las coordenadas deben de X e Y deben tener la misma longitud, intentelo nuevamente");
				}
			
				if(coordsYM.length > 0 && coordsYM.length <= 3 || coordsXM.length > 0 && coordsXM.length <= 3 ) {
					JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
				}
				
				if(coordsYM.length > 3 && coordsXM.length > 3) {
					JOptionPane.showMessageDialog(null, "La formula de X en Gauss es: \n" + Arrays.toString(formulaXLetras).replaceAll(", ", ""));
					JOptionPane.showMessageDialog(null, "La formula de Y en Gauss es: \n" + Arrays.toString(formulaYLetras).replaceAll(", ", ""));
					}

			}
		});
		btnFormula.setBounds(125, 158, 170, 25);
		contentPane.add(btnFormula);
		
		JButton btnCalculoValores = new JButton("Mostrar Calculo");
		btnCalculoValores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double[] coordsYM = Datos.getCoordsYDatos();
				double[] coordsXM = Datos.getCoordsXDatos();
	
				String x = "x";
				String y = "y";
				
				try {
					  //  Block of code to try
					String[] formulaXValores = Datos.formulaGaussValores(coordsXM, coordsYM, x, y);
					String[] formulaYValores = Datos.formulaGaussValores(coordsYM, coordsXM, y, x);
					
					}
					catch(Exception l) {
					  //  Block of code to handle errors
						JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
					}
						
				String[] formulaXValores = Datos.formulaGaussValores(coordsXM, coordsYM, x, y);
				String[] formulaYValores = Datos.formulaGaussValores(coordsYM, coordsXM, y, x);
				
				if(coordsYM.length != coordsXM.length) {
					JOptionPane.showMessageDialog(null, "Las coordenadas deben de X e Y deben tener la misma longitud, intentelo nuevamente");
				}
			
				if(coordsYM.length > 0 && coordsYM.length <= 3 || coordsXM.length > 0 && coordsXM.length <= 3 ) {
					JOptionPane.showMessageDialog(null, "El numero de coordenadas debe ser mayor a 3 puntos, intentelo nuevamente");
				}
				
				if(coordsYM.length > 3 && coordsXM.length > 3) {
					JOptionPane.showMessageDialog(null, "Los valores de la formula de X en Gauss es: \n" + Arrays.toString(formulaXValores).replaceAll(", ", ""));
					JOptionPane.showMessageDialog(null, "Los valores de la formula de Y en Gauss es: \n" + Arrays.toString(formulaYValores).replaceAll(", ", ""));
					}
			}
		});
		btnCalculoValores.setBounds(125, 196, 170, 25);
		contentPane.add(btnCalculoValores);
		
		JFormattedTextField frmtdtxtfldSiTeInteresa = new JFormattedTextField();
		frmtdtxtfldSiTeInteresa.setBackground(Color.LIGHT_GRAY);
		frmtdtxtfldSiTeInteresa.setEditable(false);
		frmtdtxtfldSiTeInteresa.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtfldSiTeInteresa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		frmtdtxtfldSiTeInteresa.setText("Si te interesa este proyecto, puedes colaborar en GitHub \"GaussPoligono\"");
		frmtdtxtfldSiTeInteresa.setBounds(12, 234, 408, 48);
		contentPane.add(frmtdtxtfldSiTeInteresa);
	}
}
