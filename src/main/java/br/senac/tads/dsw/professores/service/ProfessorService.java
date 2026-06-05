package br.senac.tads.dsw.professores.service;

import br.senac.tads.dsw.professores.entidade.ProfessorEntity;
import br.senac.tads.dsw.professores.repositorio.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

	private final ProfessorRepository repository;

	// Injeção de dependência do Repository
	public ProfessorService(ProfessorRepository repository) {
		this.repository = repository;
	}

	public List<ProfessorEntity> obterTodos() {
		return repository.findAll();
	}

	public Optional<ProfessorEntity> obterPorId(Integer id) {
		return repository.findById(id);
	}

	public ProfessorEntity incluir(ProfessorEntity professor) {
		return repository.save(professor);
	}

	public ProfessorEntity alterar(Integer id, ProfessorEntity professor) {
		if (repository.existsById(id)) {
			professor.setId(id);
			return repository.save(professor);
		}
		return null;
	}

	public void excluir(Integer id) {
		repository.deleteById(id);
	}
}
