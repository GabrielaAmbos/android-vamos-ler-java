package pojos;

import java.io.Serializable;

public class Responsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idResponsavel;

	private String nomeResponsavel;

	private String email;

	private String senha;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(Integer idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Responsavel(Integer idResponsavel, String nomeResponsavel, String email, String senha) {
		this.idResponsavel = idResponsavel;
		this.nomeResponsavel = nomeResponsavel;
		this.email = email;
		this.senha = senha;
	}

	public Responsavel(){

	}

	@Override
	public String toString() {
		return this.nomeResponsavel;
	}
}
