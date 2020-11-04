package pojos;

import java.io.Serializable;


public class Crianca implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCrianca;

	private String nomeCrianca;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdCrianca() {
		return idCrianca;
	}

	public void setIdCrianca(int idCrianca) {
		this.idCrianca = idCrianca;
	}

	public String getNomeCrianca() {
		return nomeCrianca;
	}

	public void setNomeCrianca(String nomeCrianca) {
		this.nomeCrianca = nomeCrianca;
	}

	public Crianca(String nomeCrianca) {
		this.nomeCrianca = nomeCrianca;
	}

	public Crianca(){

	}
	@Override
	public String toString() {
		return this.nomeCrianca;
	}
}
