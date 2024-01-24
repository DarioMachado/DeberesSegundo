package orm;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="compras")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idcompras;
	
	@Column
	private Date fecha;
	
	@Column
	private int id_producto;
	
	@Column
	private int unidades;
	
	public Compra() {}
	
	public Compra(Date fecha, Producto producto,  int unidades) {
		this.fecha=fecha;
		this.id_producto=producto.getCodigo();
		this.unidades=unidades;
	}

	public int getIdcompras() {
		return idcompras;
	}

	public void setIdcompras(int idcompras) {
		this.idcompras = idcompras;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	@Override
	public String toString() {
		return "Compra [idcompras=" + idcompras + ", fecha=" + fecha + ", id_producto=" + id_producto + ", unidades="
				+ unidades + "]";
	}
	

}
