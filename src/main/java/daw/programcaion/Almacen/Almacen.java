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

    public static void annadirObra(Scanner escaner, String tipo) {

        if (tipo.toLowerCase().equals("pintura")) {

            Pintura obraTemporal = new Pintura();
            obraTemporal.setId(generadorId());
            obraTemporal.setTipo("pintura");

            System.out.print("Introduzca nombre:  ");
            obraTemporal.setNombre(escaner.nextLine());
            System.out.print("Introduzca autor:  ");
            obraTemporal.setAutor(escaner.nextLine());
            System.out.print("Introduzca precio:  ");

            while (!escaner.hasNextDouble()) {
                System.out.print("Valor erroneo ");
                escaner.next();
                System.out.print("Introduzca un doubel: ");
            }
            obraTemporal.setPrecio(escaner.nextDouble());

            System.out.print("Introduzca altura:  ");
            while (!escaner.hasNextDouble()) {
                System.out.print("Valor erroneo ");
                escaner.next();
                System.out.print("Introduzca un doubel: ");
                obraTemporal.setAltura(escaner.nextDouble());
            }
            System.out.print("Introduzca Peso:  ");
            obraTemporal.setPeso(escaner.nextDouble());
            escaner.nextLine();
            System.out.print("Introduzca tecnica:  ");
            obraTemporal.setTecnica(escaner.nextLine());
            System.out.print("Introduzca piezas:  ");
            obraTemporal.setPiezas(escaner.nextInt());
            escaner.nextLine();
            System.out.print("Introduzca descripción:  ");
            obraTemporal.setDescripcion(escaner.nextLine());

            setPinturasTotales(obraTemporal);
        } else if (tipo.toLowerCase().equals("escultura")) {

            Escultura obraTemporal = new Escultura();
            obraTemporal.setId(generadorId());
            obraTemporal.setTipo("escultura");

            System.out.print("Introduzca nombre:  ");
            obraTemporal.setNombre(escaner.nextLine());
            System.out.print("Introduzca autor:  ");
            obraTemporal.setAutor(escaner.nextLine());
            System.out.print("Introduzca precio:  ");
            obraTemporal.setPrecio(escaner.nextDouble());
            System.out.print("Introduzca altura:  ");
            obraTemporal.setAltura(escaner.nextDouble());
            System.out.print("Introduzca Peso:  ");
            obraTemporal.setPeso(escaner.nextDouble());
            escaner.nextLine();
            System.out.print("Introduzca material:  ");
            obraTemporal.setMaterial(escaner.nextLine());
            System.out.print("Introduzca piezas:  ");
            obraTemporal.setPiezas(escaner.nextInt());
            escaner.nextLine();
            System.out.print("Introduzca descripción:  ");
            obraTemporal.setDescripcion(escaner.nextLine());

            setEsculturaTotales(obraTemporal);

        } else {

            System.out.println("*************************************************");
            System.out.println("*     El tipo de obra no es un tipo válido      *");
            System.out.println("*  Los tipos válidos son: pintura o escultura   *");
            System.out.println("*         Vuelva a iniciar el proceso           *");
            System.out.println("*************************************************");

        }
    }
    public static void visualizarObraPorId(int id) {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        Boolean existe = false;

        String tipoEncontrado = existeObra(id);

        if (!tipoEncontrado.equals("noExiste")) {
            existe = true;
        }

        if (existe) {

            int posicionArray = Integer.parseInt(tipoEncontrado.substring(tipoEncontrado.length() - 1));

            System.out.println("********************************************");
            System.out.println("*      La pintura ha sido encontrada       *");
            System.out.println("********************************************");
            System.out.println();

            if (tipoEncontrado.contains("pintura")) {
                System.out.println(pinturasTotales[posicionArray]);
            } else {
                System.out.println(esculturasTotales[posicionArray]);
            }
        } else {
            System.out.println("**********************************************");
            System.out.println("* La pintura con ID: " + id + " no ha sido encontrada *");
            System.out.println("**********************************************");
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

    private static void setPinturasTotales(Pintura obraTemp) {

        Pintura[] pinturasArrayTemp = new Pintura[pinturasTotales.length + 1];

        for (int i = 0; i < pinturasTotales.length; i++) {
            pinturasArrayTemp[i] = pinturasTotales[i];
        }

        pinturasArrayTemp[pinturasArrayTemp.length - 1] = obraTemp;
        pinturasTotales = pinturasArrayTemp;
    }

    private static void setEsculturaTotales(Escultura obraTemp) {

        Escultura[] esculturasArrayTemp = new Escultura[esculturasTotales.length + 1];

        for (int i = 0; i < esculturasTotales.length; i++) {
            esculturasArrayTemp[i] = esculturasTotales[i];
        }

        esculturasArrayTemp[esculturasArrayTemp.length - 1] = obraTemp;
        esculturasTotales = esculturasArrayTemp;
    }

    private static String existeObra(int idObra) {

        Boolean existe = false;
        String tipoEncontrado = "";

        for (int i = 0; i < pinturasTotales.length; i++) {

            if (pinturasTotales[i].getId() == idObra) {
                existe = true;
                tipoEncontrado = "pintura" + i;
            }

        }

        for (int i = 0; i < esculturasTotales.length; i++) {

            if (esculturasTotales[i].getId() == idObra) {
                existe = true;
                tipoEncontrado = "escultura" + i;
            }
        }

        if (!existe) {
            tipoEncontrado = "noExiste";
        }

        return tipoEncontrado;

    }

}
