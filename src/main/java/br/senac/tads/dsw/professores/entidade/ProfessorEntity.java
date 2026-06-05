package br.senac.tads.dsw.professores.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class ProfessorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(min = 5, max = 100)
	private String nome;

	@NotBlank
	@Size(max = 20)
	private String matricula;

	@NotBlank
	@Size(min = 5, max = 100)
	private String disciplina;

	private Boolean ativo = true;
	private String observacoes;

	// Construtor padrão
	public ProfessorEntity() { }

	// Construtor com parâmetros atualizado
	public ProfessorEntity(Integer id, String nome, String matricula, String disciplina, Boolean ativo, String observacoes) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.disciplina = disciplina;
		this.ativo = ativo != null ? ativo : true;
		this.observacoes = observacoes;
	}

	// --- Getters e Setters ---

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
}
