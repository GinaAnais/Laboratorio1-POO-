package Ejercicio1;

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

    public Coordenada getEsquina1() {
        return this.esquina1;
    }

    public Coordenada getEsquina2() {
        return this.esquina2;
    }

    public Coordenada getEsquina3() {
        return this.esquina3;
    }

    public Coordenada getEsquina4() {
        return this.esquina4;
    }

    public double getArea() {
        return this.base * this.altura;
    }

    public double distancia() {
        return Math.max(base, altura);
    }

    // Método para imprimir detalles 
    public String detalles() {
        return String.format("Esquina N1: (%.1f,%.1f)\nEsquina N2: (%.1f,%.1f)\n" +
                             "Esquina N3: (%.1f,%.1f)\nEsquina N4: (%.1f,%.1f)",
                             esquina1.getX(), esquina1.getY(),
                             esquina2.getX(), esquina2.getY(),
                             esquina3.getX(), esquina3.getY(),
                             esquina4.getX(), esquina4.getY());
    }

    // Método para una impresión más compacta 
    public String resumen() {
        return String.format("(%.1f,%.1f), (%.1f,%.1f)",
                             esquina1.getX(), esquina1.getY(),
                             esquina2.getX(), esquina2.getY());
    }

    @Override
    public String toString() {
        return "Rectangulo\n" + detalles();
    }
}
