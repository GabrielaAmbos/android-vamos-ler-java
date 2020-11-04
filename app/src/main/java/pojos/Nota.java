package pojos;

import java.io.Serializable;

public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idNota;

	private int desempenho;

	private int acertos;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;
	}

	public int getDesempenho() {
		return desempenho;
	}

	public void setDesempenho(int desempenho) {
		this.desempenho = desempenho;
	}

	public int getAcertos() {
		return acertos;
	}

	public void setAcertos(int acertos) {
		this.acertos = acertos;
	}

	public Nota(int desempenho, int acertos) {
		this.desempenho = desempenho;
		this.acertos = acertos;
	}

	public Nota(){

	}
}
