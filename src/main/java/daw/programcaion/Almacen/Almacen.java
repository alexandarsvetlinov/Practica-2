package daw.programcaion.Almacen;
import java.util.Scanner;

public class Almacen {
    static Pintura obra1 = new Pintura(001, "Pintura", "Guernica", "P.Picaso", 1000, 5, 2, "Oleo", 5,
            "Cuadro guerra civil");
    static Pintura obra2 = new Pintura(002, "Pintura", "La Vie", "P.Picaso", 200, 1, 1, "Oleo", 1, "Oleo");
    static Pintura obra3 = new Pintura(003, "Pintura", "El Sueño", "P.Picaso", 300, 1.3, 1, "Oleo", 1, "Oleo");
    static Pintura obra4 = new Pintura(004, "Pintura", "Retrato de Dora Maar", "P.Picaso", 400, 1, 0.8, "Oleo", 1,
            "Oleo");
    static Escultura obra5 = new Escultura(005, "Escultura", "El piel roja", "U.Checa", 350, 1, 0.8, null, "Escultura",
            1, "oleo");

    static Pintura[] pinturasTotales = { obra1, obra2, obra3, obra4 };
    static Escultura[] esculturasTotales = { obra5 };

    public static void visualizarTodoElAlmacen() {

        System.out.println("********************************************");
        System.out.println("*       Printando todas las esculturas.    *");
        System.out.println("********************************************");
        System.out.println();
        System.out.println();

        for (int i = 0; i < pinturasTotales.length; i++) {
            System.out.println(pinturasTotales[i]);
        }

        for (int i = 0; i < esculturasTotales.length; i++) {
            System.out.println(esculturasTotales[i]);
        }
    }
    private static int generadorId() {

        int numeroMayor = 0;

        for (int i = 0; i < pinturasTotales.length; i++) {
            if (pinturasTotales[i].getId() > numeroMayor) {
                numeroMayor = pinturasTotales[i].getId();
            }
        }

        for (int i = 0; i < esculturasTotales.length; i++) {
            if (esculturasTotales[i].getId() > numeroMayor) {
                numeroMayor = esculturasTotales[i].getId();
            }
        }

        return numeroMayor + 1;
    }
    
}
