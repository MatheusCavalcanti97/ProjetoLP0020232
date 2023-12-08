package exceptionsClass;

public class ProdutoNaoEncontradoCadastradoException extends Exception {

	private static final long serialVersionUID = 1317523168095288162L;

	public ProdutoNaoEncontradoCadastradoException(String str) {
		super(str);
	}
}
