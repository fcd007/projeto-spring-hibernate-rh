package br.dev.projeto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALARIOS")
public class Salarios {

	private Integer categoria;
	private Float salarioBaixo;
	private Float salarioAlto;

	public Salarios() {

	}

	public Salarios(Integer categoria, Float salarioBaixo, Float salarioAlto) {
		this.categoria = categoria;
		this.salarioBaixo = salarioBaixo;
		this.salarioBaixo = salarioAlto;
	}

	@Id
	@Column(name = "SALARIOS")
	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	@Column(name = "SALARIO_BAIXO", nullable = false)
	public Float getSalarioBaixo() {
		return salarioBaixo;
	}

	public void setSalarioBaixo(Float salarioBaixo) {
		this.salarioBaixo = salarioBaixo;
	}

	@Column(name = "SALARIO_ALTO", nullable = false)
	public Float getSalarioAlto() {
		return salarioAlto;
	}

	public void setSalarioAlto(Float salarioAlto) {
		this.salarioAlto = salarioAlto;
	}
}
