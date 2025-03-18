package practica1;

public class Verificador {

    public static boolean esSobrePos(Rectangulo r1, Rectangulo r2) {
        double x1A = r1.getEsquina1().menorX(r1.getEsquina2());
        double x2A = r1.getEsquina1().mayorX(r1.getEsquina2());
        double y1A = r1.getEsquina1().menorY(r1.getEsquina2());
        double y2A = r1.getEsquina1().mayorY(r1.getEsquina2());

        double x1B = r2.getEsquina1().menorX(r2.getEsquina2());
        double x2B = r2.getEsquina1().mayorX(r2.getEsquina2());
        double y1B = r2.getEsquina1().menorY(r2.getEsquina2());
        double y2B = r2.getEsquina1().mayorY(r2.getEsquina2());

        if (x1A >= x2B || x2A <= x1B || y1A >= y2B || y2A <= y1B) {
            return false;
        }
        return true;
    }

    public static double areaSobreposicion(Rectangulo r1, Rectangulo r2) {
        if (!esSobrePos(r1, r2)) {
            return 0;
        }

        double x1 = Math.max(r1.getEsquina1().menorX(r1.getEsquina2()), r2.getEsquina1().menorX(r2.getEsquina2()));
        double x2 = Math.min(r1.getEsquina1().mayorX(r1.getEsquina2()), r2.getEsquina1().mayorX(r2.getEsquina2()));
        double y1 = Math.max(r1.getEsquina1().menorY(r1.getEsquina2()), r2.getEsquina1().menorY(r2.getEsquina2()));
        double y2 = Math.min(r1.getEsquina1().mayorY(r1.getEsquina2()), r2.getEsquina1().mayorY(r2.getEsquina2()));

        return (x2 - x1) * (y2 - y1);
    }

    public static boolean esJunto(Rectangulo r1, Rectangulo r2) {
        double x1A = r1.getEsquina1().menorX(r1.getEsquina2());
        double x2A = r1.getEsquina1().mayorX(r1.getEsquina2());
        double y1A = r1.getEsquina1().menorY(r1.getEsquina2());
        double y2A = r1.getEsquina1().mayorY(r1.getEsquina2());

        double x1B = r2.getEsquina1().menorX(r2.getEsquina2());
        double x2B = r2.getEsquina1().mayorX(r2.getEsquina2());
        double y1B = r2.getEsquina1().menorY(r2.getEsquina2());
        double y2B = r2.getEsquina1().mayorY(r2.getEsquina2());

        boolean bordeVertical = (x2A == x1B || x2B == x1A) && (y1A < y2B && y2A > y1B);
        boolean bordeHorizontal = (y2A == y1B || y2B == y1A) && (x1A < x2B && x2A > x1B);

        return bordeVertical || bordeHorizontal;
    }

    public static boolean esDisjunto(Rectangulo r1, Rectangulo r2) {
        return !esSobrePos(r1, r2) && !esJunto(r1, r2);
    }
}
