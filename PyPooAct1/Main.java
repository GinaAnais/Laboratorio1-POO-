package practica1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) { 
            System.out.println("Ingrese una esquina del 1er rectángulo:");
            System.out.print("x: ");
            double posXR1 = sc.nextDouble();
            System.out.print("y: ");
            double posYR1 = sc.nextDouble();
            Coordenada cor1R1 = new Coordenada(posXR1, posYR1);
            
            System.out.println("Ingrese la esquina opuesta del 1er rectángulo:");
            System.out.print("x: ");
            double posXR1O = sc.nextDouble();
            System.out.print("y: ");
            double posYR1O = sc.nextDouble();
            Coordenada cor2R1 = new Coordenada(posXR1O, posYR1O);
            
            Rectangulo r1 = new Rectangulo(cor1R1, cor2R1);
            
            System.out.println("Ingrese una esquina del 2do rectángulo:");
            System.out.print("x: ");
            double posXR2 = sc.nextDouble();
            System.out.print("y: ");
            double posYR2 = sc.nextDouble();
            Coordenada cor1R2 = new Coordenada(posXR2, posYR2);
            
            System.out.println("Ingrese la esquina opuesta del 2do rectángulo:");
            System.out.print("x: ");
            double posXR2O = sc.nextDouble();
            System.out.print("y: ");
            double posYR2O = sc.nextDouble();
            Coordenada cor2R2 = new Coordenada(posXR2O, posYR2O);
            
            Rectangulo r2 = new Rectangulo(cor1R2, cor2R2);
            
            System.out.println(r1);
            System.out.println(r2);
            
            if (Verificador.esSobrePos(r1, r2)) {
                System.out.println("Los rectángulos A y B se sobreponen");
                Rectangulo r3 = rectanguloSobre(r1, r2);
                if (r3 != null) {
                    System.out.println("Área de sobreposición: " + r3.getArea());
                }
            } else if (Verificador.esJunto(r1, r2)) {
                System.out.println("Los rectángulos A y B están juntos");
            } else {
                System.out.println("Los rectángulos A y B son disjuntos");
            }

            

        } catch (NoDiagonal e) {
            System.out.println(e.getMessage());
        }
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) throws NoDiagonal {
        if (Verificador.esSobrePos(r1, r2)) {
            double minX = Math.max(Math.min(r1.getEsquina1().getX(), r1.getEsquina2().getX()), 
                                   Math.min(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
            double maxX = Math.min(Math.max(r1.getEsquina1().getX(), r1.getEsquina2().getX()), 
                                   Math.max(r2.getEsquina1().getX(), r2.getEsquina2().getX()));
            double minY = Math.max(Math.min(r1.getEsquina1().getY(), r1.getEsquina2().getY()), 
                                   Math.min(r2.getEsquina1().getY(), r2.getEsquina2().getY()));
            double maxY = Math.min(Math.max(r1.getEsquina1().getY(), r1.getEsquina2().getY()), 
                                   Math.max(r2.getEsquina1().getY(), r2.getEsquina2().getY()));

            return new Rectangulo(new Coordenada(minX, minY), new Coordenada(maxX, maxY));
        }
        return null;
    }

}
