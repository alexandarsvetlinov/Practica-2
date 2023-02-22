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
    public static void modificarObra(Scanner escaner, int idObra) {

        String tipo = existeObra(idObra);

        if (!tipo.equals("noExiste")) {

            int posicionArray = Integer.parseInt(tipo.substring(tipo.length() - 1));

            System.out.println("*************************************************");
            System.out.println("*     Comenzamos el proceso de modificación      *");
            System.out.println("*Deja en blanco aquello que no quieras modificar *");
            System.out.println("*************************************************");
            System.out.println();
            System.out.println("*             Vas a modificar al obra           *");
            System.out.println("*************************************************");
            System.out.println();
            escaner.nextLine();
            visualizarObraPorId(idObra);
            System.out.println();
            System.out.print("Introduzca nombre: ");
            String nombre = escaner.nextLine();

            System.out.print("Introduzca autor: ");
            String autor = escaner.nextLine();

            System.out.print("Introduzca precio: ");
            Double precio = null;

            String linea = escaner.nextLine();

            if (!linea.isBlank()) {

                try {
                    precio = Double.parseDouble(linea);
                } catch (Exception e) {
                    System.out.print("Valor erroneo ");
                    System.out.print("Introduzca un doubel: ");
                    while (!escaner.hasNextDouble()) {
                        System.out.print("Valor erroneo ");
                        escaner.next();
                        System.out.print("Introduzca un doubel: ");
                    }
                    precio = escaner.nextDouble();
                }

            }

            System.out.print("Introduzca altura: ");
            linea = "";
            linea = escaner.nextLine();

            Double altura = null;

            if (!linea.isBlank()) {

                try {
                    altura = Double.parseDouble(linea);
                } catch (Exception e) {
                    System.out.print("Valor erroneo ");
                    System.out.print("Introduzca un doubel: ");
                    while (!escaner.hasNextDouble()) {
                        System.out.print("Valor erroneo ");
                        escaner.next();
                        System.out.print("Introduzca un doubel: ");
                    }
                    altura = escaner.nextDouble();
                }

            }

            System.out.print("Introduzca peso: ");
            Double peso = null;

            linea = escaner.nextLine();

            if (!linea.isBlank()) {

                try {
                    peso = Double.parseDouble(linea);
                } catch (Exception e) {
                    System.out.print("Valor erroneo ");
                    System.out.print("Introduzca un doubel: ");
                    while (!escaner.hasNextDouble()) {
                        System.out.print("Valor erroneo ");
                        escaner.next();
                        System.out.print("Introduzca un doubel: ");
                    }
                    peso = escaner.nextDouble();
                }

            }

            System.out.print("Introduzca piezas: ");
            int piezas = -1;
            linea = escaner.nextLine();

            if (!linea.isBlank()) {

                try {
                    piezas = Integer.parseInt(linea);
                } catch (Exception e) {
                    System.out.print("Valor erroneo ");
                    System.out.print("Introduzca un doubel: ");
                    while (!escaner.hasNextInt()) {
                        System.out.print("Valor erroneo ");
                        escaner.next();
                        System.out.print("Introduzca un doubel: ");
                    }
                    piezas = escaner.nextInt();
                }

            }

            System.out.print("Introduzca descripción:  ");
            String descripcion = escaner.nextLine();

            if (tipo.contains("pintura")) {

                System.out.print("Introduzca tecnica:  ");
                String tecnica = escaner.nextLine();

                pinturasTotales[posicionArray]
                        .setNombre(nombre.isBlank() ? pinturasTotales[posicionArray].getNombre() : nombre);
                pinturasTotales[posicionArray]
                        .setAutor(autor.isBlank() ? pinturasTotales[posicionArray].getAutor() : autor);
                pinturasTotales[posicionArray]
                        .setPrecio(precio == null ? pinturasTotales[posicionArray].getPrecio() : precio);
                pinturasTotales[posicionArray]
                        .setAltura(altura == null ? pinturasTotales[posicionArray].getAltura() : altura);
                pinturasTotales[posicionArray].setPeso(peso == null ? pinturasTotales[posicionArray].getPeso() : peso);
                pinturasTotales[posicionArray]
                        .setTecnica(tecnica.isBlank() ? pinturasTotales[posicionArray].getTecnica() : tecnica);
                pinturasTotales[posicionArray]
                        .setPiezas(piezas == -1 ? pinturasTotales[posicionArray].getPiezas() : piezas);
                pinturasTotales[posicionArray].setDescripcion(
                        descripcion.isBlank() ? pinturasTotales[posicionArray].getDescripcion() : descripcion);

                System.out.println("*************************************************");
                System.out.println();
                visualizarObraPorId(idObra);

            } else {
                System.out.print("Introduzca material:  ");
                String material = escaner.nextLine();

                esculturasTotales[posicionArray]
                        .setNombre(nombre.isBlank() ? esculturasTotales[posicionArray].getNombre() : nombre);
                esculturasTotales[posicionArray]
                        .setAutor(autor.isBlank() ? esculturasTotales[posicionArray].getAutor() : autor);
                esculturasTotales[posicionArray]
                        .setPrecio(precio == null ? esculturasTotales[posicionArray].getPrecio() : precio);
                esculturasTotales[posicionArray]
                        .setAltura(altura == null ? esculturasTotales[posicionArray].getAltura() : altura);
                esculturasTotales[posicionArray]
                        .setPeso(peso == null ? esculturasTotales[posicionArray].getPeso() : peso);
                esculturasTotales[posicionArray]
                        .setTecnica(material.isBlank() ? esculturasTotales[posicionArray].getTecnica() : material);
                esculturasTotales[posicionArray]
                        .setPiezas(piezas == -1 ? esculturasTotales[posicionArray].getPiezas() : piezas);
                esculturasTotales[posicionArray].setDescripcion(
                        descripcion.isBlank() ? esculturasTotales[posicionArray].getDescripcion() : descripcion);

                System.out.println("*************************************************");
                System.out.println();
                visualizarObraPorId(idObra);

            }

        } else {
            System.out.println("*************************************************");
            System.out.println("*     El tipo de obra no es un tipo válido      *");
            System.out.println("*       La obra no existe en la BBDD            *");
            System.out.println("*         Vuelva a iniciar el proceso           *");
            System.out.println("*************************************************");
        }

    }
    public static void precioVenta(Scanner escaner, int idObra) {

        String tipo = existeObra(idObra);

        if (!tipo.equals("noExiste")) {
            Double precioActualObra;
            Double importePorPeso;
            Double importePorAltura;
            Double importePorPiezas = 0.0;
            int posicionArray = Integer.parseInt(tipo.substring(tipo.length() - 1));

            if (tipo.contains("escultura")) {
                precioActualObra = esculturasTotales[posicionArray].getPrecio();

                System.out.println("Nombre: " + esculturasTotales[posicionArray].getNombre());
                System.out.println("Altura(m): " + esculturasTotales[posicionArray].getAltura());
                System.out.println("Peso(t): " + esculturasTotales[posicionArray].getPeso());
                System.out.println("Número de piezas: " + esculturasTotales[posicionArray].getPiezas());
                System.out.println("Precio(€): " + esculturasTotales[posicionArray].getPrecio());
                System.out.println("Comisión galería(€): " + (esculturasTotales[posicionArray].getPrecio() * 0.25));

                importePorPeso = (esculturasTotales[posicionArray].getPeso() > 0.001) ? 100.0 : 20.0;
                System.out.println("Importe por peso(€): " + importePorPeso);

                importePorAltura = (esculturasTotales[posicionArray].getAltura() > 2) ? 100.0 : 20.0;
                System.out.println(
                        "Importe por altura(€): " + importePorAltura * esculturasTotales[posicionArray].getPiezas());

                if (esculturasTotales[posicionArray].getPiezas() > 2) {
                    for (int i = 2; i < esculturasTotales[posicionArray].getPiezas(); i++) {
                        System.out.println("Importe adicional - Pieza " + (i + 1) + "(€): 10");
                        importePorPiezas = importePorPiezas + 10;
                    }
                }

                Double precioDeVenta = precioActualObra + (esculturasTotales[posicionArray].getPrecio() * 0.25)
                        + importePorAltura + importePorPeso + importePorPiezas + 50;
                System.out.println("Precio de venta(€): " + precioDeVenta);

                System.out.println("Descuento por escultura(€): " + (precioDeVenta * 0.20));
                System.out.println("Descuento por minipulación(€): " + 50);
                System.out.println("Precio final de venta(€): " + (precioDeVenta - (precioDeVenta * 0.20)));

            } else {
                precioActualObra = pinturasTotales[posicionArray].getPrecio();

                System.out.println("Nombre: " + pinturasTotales[posicionArray].getNombre());
                System.out.println("Altura(m): " + pinturasTotales[posicionArray].getAltura());
                System.out.println("Peso(t): " + pinturasTotales[posicionArray].getPeso());
                System.out.println("Número de piezas: " + pinturasTotales[posicionArray].getPiezas());
                System.out.println("Precio(€): " + pinturasTotales[posicionArray].getPrecio());
                System.out.println("Comisión galería(€): " + (pinturasTotales[posicionArray].getPrecio() * 0.25));

                importePorPeso = (pinturasTotales[posicionArray].getPeso() > 0.001) ? 100.0 : 20.0;
                System.out.println("Importe por peso(€): " + importePorPeso);

                importePorAltura = (pinturasTotales[posicionArray].getAltura() > 2) ? 100.0 : 20.0;
                System.out.println(
                        "Importe por altura(€): " + importePorAltura * pinturasTotales[posicionArray].getPiezas());

                if (pinturasTotales[posicionArray].getPiezas() > 2) {
                    for (int i = 2; i < pinturasTotales[posicionArray].getPiezas(); i++) {
                        System.out.println("Importe adicional - Pieza " + (i + 1) + "(€): 10");
                        importePorPiezas = importePorPiezas + 10;
                    }
                }

                Double precioDeVenta = precioActualObra + (pinturasTotales[posicionArray].getPrecio() * 0.25)
                        + importePorAltura + importePorPeso + importePorPiezas;
                System.out.println("Precio de venta(€): " + precioDeVenta);

                System.out.println("Descuento por pictorica(€): " + (precioDeVenta * 0.10));
                System.out.println("Precio final de venta(€): " + (precioDeVenta - (precioDeVenta * 0.10)));
            }

        }
    }
    public static void visualizarEtiquetaObra(int id) {

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
            System.out.println("*           Etiqueta de la Obra            *");
            System.out.println("********************************************");
            System.out.println();

            if (tipoEncontrado.contains("pintura")) {
                System.out.println("Nombre: " + pinturasTotales[posicionArray].getNombre() + "\n" +
                        "Autor: " + pinturasTotales[posicionArray].getAutor() + "\n" +
                        "Descripcion: " + pinturasTotales[posicionArray].getDescripcion() + "\n");
            } else {
                System.out.println("Nombre: " + esculturasTotales[posicionArray].getNombre() + "\n" +
                "Autor: " + esculturasTotales[posicionArray].getAutor() + "\n" +
                "Descripcion: " + esculturasTotales[posicionArray].getDescripcion() + "\n");
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
