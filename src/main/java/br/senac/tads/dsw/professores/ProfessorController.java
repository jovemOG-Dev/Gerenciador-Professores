package br.senac.tads.dsw.professores;

import br.senac.tads.dsw.professores.entidade.ProfessorEntity;
import br.senac.tads.dsw.professores.service.ProfessorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

	private final ProfessorService professorService;

	public ProfessorController(ProfessorService professorService) {
		this.professorService = professorService;
	}

	@GetMapping("/{id}")
	public ProfessorEntity obterPorId(@PathVariable Integer id) {
		Optional<ProfessorEntity> optProfessor = professorService.obterPorId(id);
		if (optProfessor.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Professor não encontrado");
		}
		return optProfessor.get();
	}

	@PostMapping
	public ResponseEntity<?> incluir(@Valid @RequestBody ProfessorEntity professor) {
		ProfessorEntity professorCriado = professorService.incluir(professor);
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest().path("/{id}")
			.buildAndExpand(professorCriado.getId()).toUri();

		return ResponseEntity.status(HttpStatus.CREATED)
			.location(uri).body(professorCriado);
	}

	@GetMapping
	public List<ProfessorEntity> listarTodos() {
		return professorService.obterTodos();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Integer id, @Valid @RequestBody ProfessorEntity professor) {
		Optional<ProfessorEntity> optProfessor = professorService.obterPorId(id);

		if (optProfessor.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
				"Professor não encontrado");
		}

		ProfessorEntity professorAtualizado = professorService.alterar(id, professor);
		return ResponseEntity.ok(professorAtualizado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		professorService.excluir(id);
		return ResponseEntity.noContent().build();
	}
}
