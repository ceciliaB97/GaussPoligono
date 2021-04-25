import javax.swing.JTextField;

/**
 * * Esta clase convierte los datos ingresados en valores numericos y 
 * calcula el area de un poligono irregular con sus coordenadas X e Y

 * @author: Cecilia B.

 * @version: 10/06/2020/A
 */

public class Datos {

	/**
	 * Atributos de Datos - privados
	 */
	private static String coordsX;
	private static String coordsY;
	
	/**
	 * Setter de coordenadas X de Datos
	 * @param String, obtenido de valores ingresados en coordsX de la clase Ventana1
	 */
	public static void setCoordsXDatos(String l) {
		coordsX = Ventana1.getCoordsX().getText().replaceAll("\\s+","");
		l = coordsX;
	}
	
	/**
	 * Setter de coordenadas Y de Datos
	 * @param String, obtenido de valores ingresados en coordsX de la clase Ventana1
	 */
	public static void setCoordsYDatos(String p) {
		coordsY = Ventana1.getCoordsY().getText().replaceAll("\\s+","");
		p = coordsY;
	}
		
	/**
	 * Getter de coordenadas X de Datos
	 * @return un array de doubles a partir de un String
	 */
	public static double[] getCoordsXDatos() {
		coordsX = Ventana1.getCoordsX().getText().replaceAll("\\s+","");
		String[] coordsXS = coordsX.split(",");
		double[] coordsXD = new double[coordsXS.length];
		for(int i = 0; i < coordsXS.length; i++) {
		    try {
		    	
		    	coordsXD[i] = Double.parseDouble(coordsXS[i]);

		    } catch (NumberFormatException e) {
		       // The string does not contain a parsable integer.
		    }
		}
		return coordsXD;
	}
	
	/**
	 * Getter de coordenadas Y de Datos
	 * @return un array de doubles a partir de un String
	 */
	public static double[] getCoordsYDatos() {
		coordsY = Ventana1.getCoordsY().getText().replaceAll("\\s+","");
		String[] coordsYS = coordsY.split(",");
		double[] coordsYD = new double[coordsYS.length];
		for(int i = 0; i < coordsYD.length; i++) {
		    try {
		    	coordsYD[i] = Double.parseDouble(coordsYS[i]);
		    } catch (NumberFormatException e) {
		       // The string does not contain a parsable integer.
		    }
		}
		return coordsYD;
	}
	
	/**
	 * Recorrer el bucle multiplicando cada elemento x * y+1 y viceversa
	 * @return un array de doubles con la multiplicacion de elementos a partir de dos arrays de doubles
	 */
	public static double[] recorrerCoordsDatos(double[] x, double[] y) {
		double[] tmp = new double[x.length];
		double s = 0;
		for (int i = 0; i <= x.length - 2; i++) {
				s = x[i]*y[i+1];
				tmp[i] = s;
				
		}
		tmp[x.length-1] = x[x.length-1]*y[0];
		
		return tmp;		
	}
	
	/**
	 * Construye la fórmula de Gauss de acuerdo al numero de coordenadas pasadas por parámetros
	 * @return un array de Strings con la implementacion de elementos a partir de dos arrays de doubles
	 */
	public static String[] formulaGaussLetras(double[] x, double[] y, String m, String n) {
		String[] tmp = new String[x.length+1];
		int l = x.length-1;
		for(int i=1; i<x.length-1;i++) {
			tmp[i] = "("+m+String.valueOf(i+1)+"*("+n+String.valueOf(i+2)+"-"+n+String.valueOf(i)+")+";
		}
		tmp[0] = "[("+m+String.valueOf(1)+"*("+n+String.valueOf(2)+"-"+n+String.valueOf(x.length)+")+";
		tmp[l] = "("+m+String.valueOf(l+1)+"*("+n+String.valueOf(1)+"-"+n+String.valueOf(l)+")";
		tmp[x.length] = "] / 2";

		return tmp;		
	}
	
	/**
	 * Construye la fórmula de Gauss con las coordenadas pasadas por parámetros
	 * @return un array de Strings con la implementacion de elementos a partir de dos arrays de doubles
	 */
	public static String[] formulaGaussValores(double[] x, double[] y, String m, String n) {
		String[] tmp = new String[x.length+1];
		int l = x.length;
		for(int i=1; i<x.length-1;i++) {
			tmp[i] = "("+x[i]+"*("+y[i+1]+"-"+y[i-1]+")+";
		}
		tmp[0] = "[("+x[0]+"*("+y[1]+"-"+y[x.length-1]+")+";
		tmp[l-1] = "("+x[l-1]+"*("+y[1]+"-"+y[l-2]+")+";
		tmp[x.length] = "] / 2";

		return tmp;		
	}
	
	/**
	 * Sums all elements from the double array
	 * @param un array de doubles
	 * @return valor numerico double como sumatoria
	 */
	public static double sumatoriaDatos(double[] tmp) {
		double sum = 0;
		for(int i=0; i<tmp.length; i++) {
			sum += tmp[i];
		}
		return sum;
	}
	
	
}
