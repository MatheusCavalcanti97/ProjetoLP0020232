package entidades;

import java.util.Objects;

public class CategoriaProduto {

	private String descricaoProduto;

	public CategoriaProduto() {

	}

	public CategoriaProduto(String descricaoProduto) {
		super();
		this.descricaoProduto = descricaoProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	@Override
	public String toString() {
		
		return this.descricaoProduto;
	}
	@Override
	public int hashCode() {
		return Objects.hash(descricaoProduto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoriaProduto other = (CategoriaProduto) obj;
		return Objects.equals(descricaoProduto, other.descricaoProduto);
	}

}
