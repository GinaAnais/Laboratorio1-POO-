package practica1;
import java.util.*;

public class Rectangulo {
	private Coordenada esquina1;
	private Coordenada esquina2;
	private Coordenada esquina3;
	private Coordenada esquina4;
	private double base;
	private double altura; 

	
	public Rectangulo(Coordenada c1, Coordenada c2) throws NoDiagonal {
		if (c1.getX() == c2.getX() || c1.getY() == c2.getY()) {
			 throw new NoDiagonal();
		}

			this.esquina1 = c1;
		    this.esquina2 = c2;
		    this.esquina3 = new Coordenada(c1.getX(), c2.getY());
		    this.esquina4 = new Coordenada(c2.getX(), c1.getY());

		    this.base = Math.abs(esquina4.getX() - esquina1.getX());
		    this.altura = Math.abs(esquina3.getY() - esquina1.getY());
		
	}
	
	public void setEsquina1(Coordenada e1) {
		this.esquina1 = e1;
	}
	public Coordenada getEsquina1() {
		return this.esquina1;
	}
	public void setEsquina2(Coordenada e2) {
		this.esquina2 = e2;
		
	}
	public Coordenada getEsquina2() {
		return this.esquina2;
	}
	
	public Coordenada getEsquina3() {
		return esquina3;
	}

	public void setEsquina3(Coordenada esquina3) {
		this.esquina3 = esquina3;
	}

	public Coordenada getEsquina4() {
		return esquina4;
	}

	public void setEsquina4(Coordenada esquina4) {
		this.esquina4 = esquina4;
	}
	
	public double getArea() {
		return this.base*this.altura;
	}
	
	@Override
	public String toString() {
	    return "Rectangulo\n" +
	           "Esquina N1: (" + esquina1.getX() + "," + esquina1.getY() + ")\n" +
	           "Esquina N2: (" + esquina2.getX() + "," + esquina2.getY() + ")\n" +
	           "Esquina N3: (" + esquina1.getX() + "," + esquina2.getY() + ")\n" +
	           "Esquina N4: (" + esquina2.getX() + "," + esquina1.getY() + ")";
	}


}