package ejreto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;

@Entity
@Table
public class Libro {



	private StringProperty titulo = new SimpleStringProperty();

	private StringProperty editorial = new SimpleStringProperty();

	private StringProperty autore = new SimpleStringProperty();

	private IntegerProperty paginas = new SimpleIntegerProperty();

	@Column(name="titulo")
	private String tituloData;
	@Column(name="editorial")
	private String editorialData;
	@Column(name="autore")
	private String autoreData;
	@Column(name = "paginas")
	private int paginasData;

	public Libro() {
	}

	public Libro(String titulo, String editorial, String autore, int paginas) {
		this.titulo.set(titulo);
		this.tituloData=titulo;
		this.editorial.set(editorial);
		this.editorialData = editorial;
		this.autore.set(autore);
		this.autoreData = autore;
		this.paginas.set(paginas);
		this.paginasData = paginas;
	}

	public void setTitulo(String titulo) {
		this.titulo.set(titulo);
		this.tituloData = titulo;
	}

	public void setAutore(String autore) {
		this.autore.set(autore);
		this.autoreData = autore;
	}

	public void setEditorial(String editorial) {
		this.editorial.set(editorial);
		this.editorialData = editorial;
	}

	public void setPaginas(int paginas) {
		this.paginas.set(paginas);
		this.paginasData = paginasData;
	}

	public String getTitulo() {
		return titulo.get();
	}

	public String getEditorial() {
		return editorial.get();
	}

	public String getAutore() {
		return autore.get();
	}

	public int getPaginas() {
		return paginas.get();
	}

	public StringProperty tituloProperty(){
		return titulo;
	}
	public StringProperty editorialProperty(){
		return editorial;
	}
	public StringProperty autoreProperty(){
		return autore;
	}
	public IntegerProperty paginasProperty(){
		return paginas;
	}
}
