package Base;

//Classe que define um objeto
public class Cliente {
	//Atributos de classe/estáticos
	//private/public static tipo nome
	private static int senhaDeAtendimento = 0, geradorDeSenha = 1;
	
	//Atributos de instância
	private int senhaDoCliente;
	private String nome;
	
	//Métodos:
	
	//Construtor
					//recebe o nome
	public Cliente(String nome) { 
		this.nome = nome;//inicializa o nome
		this.senhaDoCliente = geradorDeSenha;//inicializa senhaDoCliente
		geradorDeSenha++;
	}

	//Gets e Set:
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static int getSenhaDeAtendimento() {
		return senhaDeAtendimento;
	}

	public int getSenhaDoCliente() {
		return senhaDoCliente;
	}

	//To String:
	
	@Override
	public String toString() {
		return "Cliente [senhaDoCliente=" + senhaDoCliente + ", nome=" + nome + "]";
	}
	
	//"Proximo":
	
	public static int proximo() {
		return ++senhaDeAtendimento;
	}
}