package tp1;

public class Produto {
	private String nomeProduto;
	private String descricao;
	private String valor;
	private String lucro;
	private int qtdEstoque;
	
	//Construtor
	public Produto(String nomeProduto, String descricao, String valor, String lucro, int qtdEstoque) {
		
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.valor = valor;
		this.lucro = lucro;
		this.qtdEstoque = qtdEstoque;
	}
	
	//Getters e Setters

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNome(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getLucro() {
		return lucro;
	}

	public void setLucro(String lucro) {
		this.lucro = lucro;
	}

	public int getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(int qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}
	
}

