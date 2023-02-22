package daw.programcaion.Almacen;

public class Escultura {
    private int id;
    private String tipo;
    private String nombre;
    private String autor;
    private double precio;
    private double altura;
    private double peso;
    private String material;
    private String tecnica;
    private int piezas;
    private String descripcion;

    public Escultura() {

    }

    public Escultura(int id, String tipo, String nombre, String autor, double precio, double altura, double peso,
            String material, String tecnica, int piezas, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.autor = autor;
        this.precio = precio;
        this.altura = altura;
        this.peso = peso;
        this.material = material;
        this.tecnica = tecnica;
        this.piezas = piezas;
        this.descripcion = descripcion;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTecnica() {
        return this.tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public int getPiezas() {
        return this.piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + "\n" +
                "Autor: " + getAutor() + "\n" +
                "Precio: " + getPrecio() + "\n" +
                "Altura: " + getAltura() + "\n" +
                "Peso: " + getPeso() + "\n" +
                "Piezas: " + getPiezas() + "\n" +
                "Descripcion: " + getDescripcion() + "\n";
    }
}
