package br.dev.projeto.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "FUNCIONARIOS", uniqueConstraints = { @UniqueConstraint(columnNames = { "FUNC_NO" }) })
public class Funcionarios {

	private Long funcionarioId;
	private String funcionarioNo;

	private String funcionarioNome;
	private String cargo;
	private Funcionarios gerente;
	private Date hideDate;
	private Float salario;
	private byte[] imagem;

	private Departamentos departamento;
	private Set<Funcionarios> funcionarios = new HashSet<Funcionarios>(0);

	public Funcionarios() {

	}

	public Funcionarios(Long funcionarioId, String funcionarioNome, String cargo, Funcionarios gerente, Date hideDate,
			Float salario, Float comm, Departamentos departamento) {

		this.funcionarioId = funcionarioId;
		this.funcionarioNo = "E" + this.funcionarioId;
		this.funcionarioNome = funcionarioNome;
		this.cargo = cargo;
		this.gerente = gerente;
		this.hideDate = hideDate;
		this.salario = salario;
		this.departamento = departamento;
	}

	@Id
	@Column(name = "FUNC_ID")
	public Long getFuncionarioId() {
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId) {
		this.funcionarioId = funcionarioId;
	}

	@Column(name = "FUNC_NO, length = 32", nullable = false)
	public String getFuncionarioNo() {
		return funcionarioNo;
	}

	public void setFuncionarioNo(String funcionarioNo) {
		this.funcionarioNo = funcionarioNo;
	}

	@Column(name = "FUNC_NOME", length = 128, nullable = false)
	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	@Column(name = "FUNC_CARGO", length = 64, nullable = false)
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GERENTE_ID")
	public Funcionarios getGerente() {
		return gerente;
	}

	public void setGerente(Funcionarios gerente) {
		this.gerente = gerente;
	}

	@Column(name = "HIDE_DATE", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getHideDate() {
		return hideDate;
	}

	public void setHideDate(Date hideDate) {
		this.hideDate = hideDate;
	}

	@Column(name = "SALARIO", nullable = false)
	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	@Column(name = "IMAGEM", length = 1111111, nullable = false)
	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPT_ID", nullable = false)
	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "funcionarioId")
	public Set<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Set<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
