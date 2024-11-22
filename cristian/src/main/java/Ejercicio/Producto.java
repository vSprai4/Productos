package Ejercicio;

public class Producto {

    private String nombre;
    private int precio;
    private boolean especial;  // Atributo para saber si el producto es especial

    // Constructor
    public Producto(String nombre, int precio, boolean especial) {
        this.nombre = nombre;
        this.precio = precio;
        this.especial = especial;
    }

    // Getter y Setter para 'nombre'
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para 'precio'
    public int getPrecio() {
        // Si el producto es especial, multiplicamos el precio por 2
        if (especial) {
            System.out.println("Valor especial aplicado, precio final: " + (precio * 2));
            return precio * 2;
        } else {
            System.out.println("Precio normal: " + precio);
            return precio;
        }
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    // Método para saber si el producto es especial
    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }
}

