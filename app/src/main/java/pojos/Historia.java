package pojos;

import java.io.Serializable;

public class Historia implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idHistoria;
	
	private String nomeHistoria;
	
	private String conteudoHistoria;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdHistoria() {
		return idHistoria;
	}

	public void setIdHistoria(int idHistoria) {
		this.idHistoria = idHistoria;
	}

	public String getNomeHistoria() {
		return nomeHistoria;
	}

	public void setNomeHistoria(String nomeHistoria) {
		this.nomeHistoria = nomeHistoria;
	}

	public String getConteudoHistoria() {
		return conteudoHistoria;
	}

	public void setConteudoHistoria(String conteudoHistoria) {
		this.conteudoHistoria = conteudoHistoria;
	}

	public Historia(int idHistoria, String nomeHistoria, String conteudoHistoria) {
		this.idHistoria = idHistoria;
		this.nomeHistoria = nomeHistoria;
		this.conteudoHistoria = conteudoHistoria;
	}

	public Historia() {
	}
}
