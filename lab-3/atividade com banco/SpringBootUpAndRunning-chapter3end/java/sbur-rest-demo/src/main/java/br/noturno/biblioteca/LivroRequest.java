package br.noturno.biblioteca;

public class LivroRequest {
	private String titulo;

	public LivroRequest() {}

	public LivroRequest(String titulo) {
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}


