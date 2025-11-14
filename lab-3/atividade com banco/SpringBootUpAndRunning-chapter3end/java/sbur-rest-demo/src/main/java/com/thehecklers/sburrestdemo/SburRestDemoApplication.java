package br.noturno.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class BibliotecaDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaDbApplication.class, args);
	}

}

@RestController
@RequestMapping("/livros")
class LivrosController {
	private final LivroRepository repository;

	public LivrosController(LivroRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	Iterable<Livro> getLivros() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Livro> getLivroPorId(@PathVariable String id) {
		return repository.findById(id);
	}

	@PostMapping
	RespostaLivro postLivro(@RequestBody LivroRequest request) {
		Livro inserido = repository.insert(new Livro(request.getTitulo()));
		return new RespostaLivro(inserido.getId(), inserido.getTitulo());
	}

	@PutMapping("/{id}")
	ResponseEntity<Livro> putLivro(@PathVariable String id,
	                               @RequestBody LivroRequest request) {
		Livro atualizado = new Livro(id, request.getTitulo());
		int rows = repository.update(atualizado);
		if (rows == 0) {
			repository.insert(atualizado);
			return new ResponseEntity<>(atualizado, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(atualizado, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteLivro(@PathVariable String id) {
		repository.deleteById(id);
	}
}

class Livro {
	private final String id;
	private String titulo;

	public Livro(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public Livro(String titulo) {
		this(UUID.randomUUID().toString(), titulo);
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}

class RespostaLivro {
	private final String id;
	private final String titulo;

	public RespostaLivro(String id, String titulo) {
		this.id = id;
		this.titulo = titulo;
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}