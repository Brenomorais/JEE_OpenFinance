package com.buildsoftware.openfinance.finance.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;		
	private String nome;
	private Date dataNascimento;
	private String email;
	private RamoAtividade ramoAtividade;
	private TipoPessoa tipoPessoa;
	
		
	@Id
	@GeneratedValue()
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}		
	
	@Column(name="data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToOne
	@JoinColumn(name="ramoatividade")
	public RamoAtividade getRamoAtividade() {
		return ramoAtividade;
	}
	public void setRamoAtividade(RamoAtividade ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	@Enumerated(EnumType.STRING)
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
