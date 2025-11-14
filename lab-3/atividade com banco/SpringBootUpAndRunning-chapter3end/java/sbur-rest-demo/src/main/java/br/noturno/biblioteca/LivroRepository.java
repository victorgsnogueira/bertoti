package br.noturno.biblioteca;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LivroRepository {
	private final JdbcTemplate jdbcTemplate;

	private static final RowMapper<Livro> LIVRO_ROW_MAPPER = (rs, rowNum) ->
		new Livro(rs.getString("id"), rs.getString("titulo"));

	public LivroRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Livro> findAll() {
		return jdbcTemplate.query("SELECT id, titulo FROM livros ORDER BY titulo", LIVRO_ROW_MAPPER);
	}

	public Optional<Livro> findById(String id) {
		try {
			Livro livro = jdbcTemplate.queryForObject(
				"SELECT id, titulo FROM livros WHERE id = ?",
				LIVRO_ROW_MAPPER,
				id
			);
			return Optional.ofNullable(livro);
		} catch (EmptyResultDataAccessException ex) {
			return Optional.empty();
		}
	}

	public Livro insert(Livro livro) {
		jdbcTemplate.update(
			"INSERT INTO livros (id, titulo) VALUES (?, ?)",
			livro.getId(),
			livro.getTitulo()
		);
		return livro;
	}

	public int update(Livro livro) {
		return jdbcTemplate.update(
			"UPDATE livros SET titulo = ? WHERE id = ?",
			livro.getTitulo(),
			livro.getId()
		);
	}

	public int deleteById(String id) {
		return jdbcTemplate.update("DELETE FROM livros WHERE id = ?", id);
	}
}


