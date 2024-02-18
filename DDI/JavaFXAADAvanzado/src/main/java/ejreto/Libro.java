package ejreto;

import javax.persistence.*;

@Entity
@Table(name="libros")
public class Libro {


	@Id
	@Column
	private String titulo;
	@Column
	private String editorial;
	@Column
	private String autore;
	@Column
	private int paginas;

	public Libro() {
	}

	public Libro(String titulo, String editorial, String autore, int paginas) {

		this.titulo =titulo;
		this.editorial = editorial;
		this.autore = autore;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
}
