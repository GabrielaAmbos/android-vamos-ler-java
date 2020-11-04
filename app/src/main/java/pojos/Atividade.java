package pojos;

import java.io.Serializable;


public class Atividade implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idAtividade;
	
	private String Pergunta;

	private String AtividadeNomeHistoria;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(int idAtividade) {
		this.idAtividade = idAtividade;
	}

	public String getPergunta() {
		return Pergunta;
	}

	public void setPergunta(String pergunta) {
		Pergunta = pergunta;
	}

	public String getAtividadeNomeHistoria() {
		return AtividadeNomeHistoria;
	}

	public void setAtividadeNomeHistoria(String atividadeNomeHistoria) {
		AtividadeNomeHistoria = atividadeNomeHistoria;
	}

	public Atividade(int idAtividade, String pergunta, String atividadeNomeHistoria) {
		this.idAtividade = idAtividade;
		Pergunta = pergunta;
		AtividadeNomeHistoria = atividadeNomeHistoria;
	}
	public Atividade(){

	}
}
