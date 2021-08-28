package br.dev.projeto.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "DEPARTAMENTOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "DEPT_NO" }) })
public class Departamentos {

	private Integer departamentoId;
	private String departamentoNo;
	private String departamentoNome;
	private String localicazao;
	private Set<Funcionarios> funcionarios = new HashSet<Funcionarios>(0);

	public Departamentos() {

	}

	public Departamentos(int departamentoId, String departamentoNome, String Localizacao) {
		this.departamentoId = departamentoId;
		this.departamentoNo = "D" + departamentoId;
		this.departamentoNome = departamentoNome;
		this.localicazao = localicazao;
	}

	@Id
	@Column(name = "DEPT_ID")
	public Integer getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}

	@Column(name = "DEPT_NO", length = 32, nullable = false)
	public String getDepartamentoNo() {
		return departamentoNo;
	}

	public void setDepartamentoNo(String departamentoNo) {
		this.departamentoNo = departamentoNo;
	}

	@Column(name = "DEPT_NOME", nullable = false)
	public String getDepartamentoNome() {
		return departamentoNome;
	}

	public void setDepartamentoNome(String departamentoNome) {
		this.departamentoNome = departamentoNome;
	}

	@Column(name = "LOCALIZACAO")
	public String getLocalicazao() {
		return localicazao;
	}

	public void setLocalicazao(String localicazao) {
		this.localicazao = localicazao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamentos")
	public Set<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
