package Ejercicio;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route
public class MainView extends VerticalLayout {

    // Lista para guardar los productos en el carrito
    private List<Producto> carrito = new ArrayList<>();
    
    // Contenedor para mostrar los productos seleccionados
    private VerticalLayout contenedor = new VerticalLayout();

    VerticalLayout carritoWrapper = new VerticalLayout();
    
    public MainView() {
        // Crear productos
        Producto notebook1 = new Producto("Dell",100, true);
        notebook1.setNombre("Dell");
        notebook1.setPrecio(100);
        
        Producto iphone = new Producto("Iphone 15",500, true);
        iphone.setNombre("Iphone 15");
        iphone.setPrecio(500);
        
        Producto PC = new Producto("Intel 7",1000, true);
        PC.setNombre("Intel 7");
        PC.setPrecio(1000);

        // Botones para seleccionar productos
        Button button = new Button("Notebook");
        Button button2 = new Button("Celular");
        Button button3 = new Button("Computadora");

        // Campo de texto para ingresar el nombre del cliente
        TextField campoNombre = new TextField();
        campoNombre.setLabel("Ingrese nombre");

        // Botón para ver el precio del notebook
        button.addClickListener(click -> {
            Image imagen = new Image("https://www.megatone.net/Images/Articulos/zoom2x/200/NOT2529HEW.jpg", "NOTEBOOK");
            contenedor.removeAll();
            contenedor.add(imagen);
            imagen.setHeight("250px");
            imagen.setWidth("250px");
            Button PrecioNotebook = new Button("Precio Notebook");
            contenedor.add(PrecioNotebook);
            PrecioNotebook.addClickListener(click1 -> {
                // Agregar el producto al carrito
                carrito.add(notebook1);
                Notification notibutton2 = new Notification(notebook1.getNombre() + " $" + notebook1.getPrecio());
                notibutton2.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
                notibutton2.setDuration(10000);
                notibutton2.open();
                // Actualizar el carrito y total
                actualizarCarrito();
            });
        });

        // Botón para ver el precio del Iphone
        button2.addClickListener(click -> {
            Image imagen2 = new Image("https://th.bing.com/th/id/OIP.cifHwgmzXZRcwr9fKU7QEAHaHa?rs=1&pid=ImgDetMain", "IPHONE 15");
            contenedor.removeAll();
            contenedor.add(imagen2);
            imagen2.setHeight("250px");
            imagen2.setWidth("250px");
            Button PrecioIphone = new Button("Precio Iphone");
            contenedor.add(PrecioIphone);
            PrecioIphone.addClickListener(click2 -> {
                // Agregar el producto al carrito
                carrito.add(iphone);
                Notification notibutton = new Notification(iphone.getNombre() + " $" + iphone.getPrecio());
                notibutton.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
                notibutton.setDuration(10000);
                notibutton.open();
                // Actualizar el carrito y total
                actualizarCarrito();
            });
        });

        // Botón para ver el precio de la computadora
        button3.addClickListener(click -> {
            Image imagen3 = new Image("https://th.bing.com/th/id/OIP.tZaJxU6VSZ7897D1SeBn2QAAAA?rs=1&pid=ImgDetMain", "PC");
            contenedor.removeAll();
            contenedor.add(imagen3);
            imagen3.setHeight("250px");
            imagen3.setWidth("250px");
            Button PrecioComputadora = new Button("Precio Computadora");
            contenedor.add(PrecioComputadora);
            PrecioComputadora.addClickListener(click3 -> {
                // Agregar el producto al carrito
                carrito.add(PC);
                Notification notibutton3 = new Notification(PC.getNombre() + " $" + PC.getPrecio());
                notibutton3.addThemeVariants(NotificationVariant.LUMO_CONTRAST);
                notibutton3.setDuration(10000);
                notibutton3.open();
                // Actualizar el carrito y total
                actualizarCarrito();
            });
        });

        carritoWrapper = new VerticalLayout();
        
        // Agregar los botones a la vista
        add(button, button2, button3, contenedor, carritoWrapper);
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
    }

    // Método para actualizar el carrito y el total
    private void actualizarCarrito() {
        // Limpiar el contenedor del carrito
    	carritoWrapper.removeAll();
        
        // Mostrar los productos en el carrito
        for (Producto producto : carrito) {
        	carritoWrapper.add(new Span(producto.getNombre() + " - $" + producto.getPrecio()));
        }

        // Calcular el total
        int total = carrito.stream().mapToInt(Producto::getPrecio).sum();
        carritoWrapper.add(new Span("Total: $" + total));

    }
}
