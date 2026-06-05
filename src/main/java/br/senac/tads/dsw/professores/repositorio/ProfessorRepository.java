package br.senac.tads.dsw.professores.repositorio;

import br.senac.tads.dsw.professores.entidade.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Integer> {
}
