package br.dev.projeto.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RELOGIO_PONTOS")
public class RelogioPontos {

	private String relogioPontoId;
	private Date DataTempo;
	private Funcionarios funcionario;

	// 'E' ou 'S']
	private char inEntradaSaida;

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name = "RelogioPonto_Id", length = 36)
	public String getRelogioPontoId() {
		return relogioPontoId;
	}

	public void setRelogioPontoId(String relogioPontoId) {
		this.relogioPontoId = relogioPontoId;
	}

	@Column(name = "Data_Tempo", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataTempo() {
		return DataTempo;
	}

	public void setDataTempo(Date dataTempo) {
		DataTempo = dataTempo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUNC_ID", nullable = false)
	public Funcionarios getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionarios funcionario) {
		this.funcionario = funcionario;
	}

	@Column(name = "in_Entrada_Saida")
	public char getInEntradaSaida() {
		return inEntradaSaida;
	}

	public void setInEntradaSaida(char inEntradaSaida) {
		this.inEntradaSaida = inEntradaSaida;
	}

}
