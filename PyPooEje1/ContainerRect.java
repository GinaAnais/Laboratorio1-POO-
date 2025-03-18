package Ejercicio1;


import java.util.Arrays;

public class ContainerRect {
    private Rectangulo arrRect[];
    private double arrDist[];
    private double arrAreas[];
    private int n;
    private int numRec;

    public ContainerRect(int n) {
        this.n = n;
        this.arrRect = new Rectangulo[n];
        this.arrDist = new double[n];
        this.arrAreas = new double[n];
        this.numRec = 0;  
    }

    public void addRectangulo(Rectangulo r1) {
        if (numRec < n) {
            arrRect[numRec] = r1;
            arrDist[numRec] = Coordenada.distancia(r1.getEsquina1(), r1.getEsquina2());
            arrAreas[numRec] = r1.getArea();
            numRec++;
        } else {
            System.out.println("El contenedor está lleno, no se pueden agregar más rectángulos.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo\tCoordenadas\tDistancia\tÁrea\n");
        for (int i = 0; i < numRec; i++) {
            sb.append((i + 1)).append("\t")
              .append(arrRect[i]).append("\t")
              .append(String.format("%.3f", arrDist[i])).append("\t")
              .append(String.format("%.2f", arrAreas[i])).append("\n");
        }
        return sb.toString();
    }
}
