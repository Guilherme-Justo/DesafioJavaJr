package DesafioJavaJr.project.entities;

import java.io.Serializable;
import java.util.Objects;

public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco() {
	}

	public Endereco(String logradouro, String complemento, String bairro, String cidade, String estado) {
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, complemento, estado, logradouro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(complemento, other.complemento) && Objects.equals(estado, other.estado)
				&& Objects.equals(logradouro, other.logradouro);
	}

	@Override
	public String toString() {
		return logradouro + ", " + complemento + ", " + bairro
				+ ", " + cidade + ", " + estado;
	}
}
