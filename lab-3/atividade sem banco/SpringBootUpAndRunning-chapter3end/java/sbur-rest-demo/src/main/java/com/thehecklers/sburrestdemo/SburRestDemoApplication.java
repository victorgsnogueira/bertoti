package br.noturno.catalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class CatalogoLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoLivrosApplication.class, args);
	}

}

@RestController
@RequestMapping("/livros")
class LivrosController {
	private List<Livro> livros = new ArrayList<>();

	public LivrosController() {
		livros.addAll(List.of(
				new Livro("Dom Casmurro"),
				new Livro("Memórias Póstumas de Brás Cubas"),
				new Livro("Vidas Secas"),
				new Livro("Grande Sertão: Veredas")
		));
	}

	@GetMapping
	Iterable<Livro> getLivros() {
		return livros;
	}

	@GetMapping("/search")
	List<Livro> search(@RequestParam String titulo) {
		String q = titulo.toLowerCase();
		List<Livro> result = new ArrayList<>();
		for (Livro l : livros) {
			if (l.getTitulo().toLowerCase().contains(q)) {
				result.add(l);
			}
		}
		return result;
	}

	@GetMapping("/{id}")
	Optional<Livro> getLivroPorId(@PathVariable String id) {
		for (Livro l: livros) {
			if (l.getId().equals(id)) {
				return Optional.of(l);
			}
		}

		return Optional.empty();
	}

	@PostMapping
	Livro postLivro(@RequestBody Livro livro) {
		livros.add(livro);
		return livro;
	}

	@PutMapping("/{id}")
	ResponseEntity<Livro> putLivro(@PathVariable String id,
								 @RequestBody Livro livro) {
		int bookIndex = -1;

		for (Livro l: livros) {
			if (l.getId().equals(id)) {
				bookIndex = livros.indexOf(l);
				livros.set(bookIndex, livro);
			}
		}

		return (bookIndex == -1) ?
				new ResponseEntity<>(postLivro(livro), HttpStatus.CREATED) :
				new ResponseEntity<>(livro, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteLivro(@PathVariable String id) {
		livros.removeIf(l -> l.getId().equals(id));
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