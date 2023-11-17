package mvcproductos;

import java.util.List;

public class ProductoView {
	
	public void mostrarProductos(List<Producto> productos) {
		for(Producto producto : productos) {
			System.out.println("id: "+ producto.getId());
			System.out.println("nombre: "+producto.getNombre());
			System.out.println("descripcion: "+ producto.getDescripcion());
			System.out.println("fabricante: "+producto.getFabricante());
			System.out.println("precio" + producto.getPrecio());
			System.out.println("n_serie: " + producto.getN_serie());
			
		}
		
		
	}

}
