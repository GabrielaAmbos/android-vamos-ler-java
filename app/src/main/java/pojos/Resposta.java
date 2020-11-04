package pojos;

import java.io.Serializable;

public class Resposta implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idResposta;
	
	private String resposta1;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdResposta() {
		return idResposta;
	}

	public void setIdResposta(int idResposta) {
		this.idResposta = idResposta;
	}

	public String getResposta1() {
		return resposta1;
	}

	public void setResposta1(String resposta1) {
		this.resposta1 = resposta1;
	}

	public Resposta(int idResposta, String resposta1, String resposta2, String resposta3, String resposta4) {
		this.idResposta = idResposta;
		this.resposta1 = resposta1;
	}

	public Resposta(){

	}
}
