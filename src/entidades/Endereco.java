package entidades;

public class Endereco {

	private String nomeRua;
	public String numeroImovel;
	public String cidade;
	public String estado;
	
	public Endereco() {
		
	}

	public Endereco(String nomeRua, String numeroImovel, String cidade, String estado) {
		super();
		this.nomeRua = nomeRua;
		this.numeroImovel = numeroImovel;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getNomeRua() {
		return nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public String getNumeroImovel() {
		return numeroImovel;
	}

	public void setNumeroImovel(String numeroImovel) {
		this.numeroImovel = numeroImovel;
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

}
