package daw.programcaion;

import java.util.Scanner;
import daw.programcaion.Almacen.Almacen;

public class App {
    public static void main(String[] args) {
        System.out.println("\u001B[31m");
        Scanner escaner = new Scanner(System.in);
        boolean salir = false;

        printearMenu();

        while (!salir) {
            int opcionSeleccionada = escaner.nextInt();
            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (opcionSeleccionada) {
                case 1:
                    Almacen.visualizarTodoElAlmacen();
                    break;
                case 2:
                    System.out.println("********************************************");
                    System.out.println("*    Proceso para añadir una nueva obra    *");
                    System.out.println("********************************************");
                    System.out.println();

                    System.out.print("¿Quieres crear una escultura o una pintura? ");
                    escaner.nextLine();
                    Almacen.annadirObra(escaner, escaner.nextLine());
                    break;
                case 3:
                    System.out.println("********************************************");
                    System.out.println("* Proceso para modificar una nueva obra    *");
                    System.out.println("********************************************");
                    System.out.println();

                    System.out.print("¿Que obra quieres modificar? ");
                    escaner.nextLine();
                    Almacen.modificarObra(escaner, escaner.nextInt());
                    break;
                case 4:
                    System.out.print("¿Cual es el ID de la obra que quieres mostrar? ");
                    Almacen.visualizarObraPorId(escaner.nextInt());
                    break;
                case 5:
                    System.out.println("********************************************");
                    System.out.println("*              Precio de Venta             *");
                    System.out.println("********************************************");
                    System.out.println();

                    System.out.print("¿De que obra quieres saber el precio de venta?(Introduce el id) ");
                    escaner.nextLine();
                    Almacen.precioVenta(escaner, escaner.nextInt());
                    break;
                case 6:
                    System.out.print("¿Cual es el ID de la obra que quieres mostrar? ");
                    Almacen.visualizarEtiquetaObra(escaner.nextInt());
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    break;
            }

            esperarTecla(escaner);
            if (escaner.nextLine() != null) {
                limpiarConsola(escaner);
                printearMenu();
            }

        }
    }

    private static void printearMenu() {

        System.out.println();
        System.out.println("********************************************");
        System.out.println("*          Selecciona una opcion           *");
        System.out.println("********************************************");
        System.out.println("* 1. Visualizar todas las obras.           *");
        System.out.println("* 2. Dar de alta una obra.                 *");
        System.out.println("* 3. Modificar los datos de una obra.      *");
        System.out.println("* 4. Visualizar una obra.                  *");
        System.out.println("* 5. Optener precio de venta de una obra.  *");
        System.out.println("* 6. Imprimir etiqueta.                    *");
        System.out.println("* 0. Salir                                 *");
        System.out.println("********************************************");
        System.out.println();
    }

    private static void esperarTecla(Scanner escaner) {
        System.out.println();
        System.out.println("Pulsa cualquier tecla para continuar");
        escaner.nextLine();
    }

    private static void limpiarConsola(Scanner escaner) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
