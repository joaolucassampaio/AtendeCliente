package Base;
import java.util.ArrayList;
import io.InOut;

public class UsaCliente {
	
	public static void main(String[] args) {
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		String opcao;
		
		do {
			opcao = exibirMenu();
			switch(opcao) {
			case "1":
				gerarSenha(listaDeClientes);
				break;
				
			case "2":
				atendimento(listaDeClientes);
				break;
				
			case "3":
				sairDaFila(listaDeClientes);
				break;
				
			case "4":
				clientesNaoAtendidos(listaDeClientes);
				break;
				
			case "5":
				InOut.msgDeAviso(null, "Encerando o programa...");
				break;
			}
		} while(!opcao.equals("5"));
		InOut.msgDeAviso(null, "Programa encerrado com sucesso!");
	}

	private static void clientesNaoAtendidos(ArrayList<Cliente> listaDeClientes) {
		if(listaDeClientes.isEmpty()) {
			InOut.msgDeAviso(null, "Não há clientes a serem atendidos no momento!");
			return;
		}
		for(int i=0; i<listaDeClientes.size(); i++) {
			InOut.msgSemIcone("Senhas não atendidas:", "Cliente: " + 
					listaDeClientes.get(i).getNome() + 
					"\nSenha: " + listaDeClientes.get(i).getSenhaDoCliente());
		}
	}

	private static void sairDaFila(ArrayList<Cliente> listaDeClientes) {
		int inputSenhaDoCliente = InOut.leInt("Por favor, informe a sua senha:");
		int senhaDoCliente;
		
		for(int i=0; i<listaDeClientes.size(); i++) {
			senhaDoCliente = listaDeClientes.get(i).getSenhaDoCliente();
			if(inputSenhaDoCliente == senhaDoCliente) {
				listaDeClientes.remove(i);
				InOut.msgDeAviso(null, "A senha " + senhaDoCliente + " foi removida com sucesso!");
				return;
			}
		}
		InOut.msgDeAviso(null, "Senha não encontrada!");
	}

	private static void atendimento(ArrayList<Cliente> listaDeClientes) {
		while(listaDeClientes.isEmpty() != true) {
            int senhaDeAtendimento = Cliente.getSenhaDeAtendimento();
            Cliente clienteAtendido = null;

            senhaDeAtendimento = Cliente.proximo();

            for (int j = 0; j < listaDeClientes.size(); j++) {
                int senhaDoUsuario = listaDeClientes.get(j).getSenhaDoCliente();
                if (senhaDeAtendimento == senhaDoUsuario) {
                    clienteAtendido = listaDeClientes.get(j);
                    listaDeClientes.remove(j);
                    break;
                }
            }

            if (clienteAtendido != null) {
                InOut.msgSemIcone(null, "Cliente que será atendido:\n" +
                        "Nome: " + clienteAtendido.getNome() +
                        "\nSenha: " + clienteAtendido.getSenhaDoCliente());
            } else {
                InOut.msgDeErro(null, "Não existe cliente com a senha " + senhaDeAtendimento +
                        "!\nPassando para o próximo...");
                //senhaDeAtendimento = Cliente.proximo();
            }
        }
		InOut.msgDeAviso(null, "Não há clientes na fila de atendimento!");
	}
	
	private static void gerarSenha(ArrayList<Cliente> listaDeClientes) {
		String nome = InOut.leString("Digite o seu nome:");
		Cliente cliente = new Cliente(nome);
		listaDeClientes.add(cliente);
		
		InOut.msgDeInformacao(null, "Nome do usuário: " + cliente.getNome() +
				"\nSenha: " + cliente.getSenhaDoCliente());
	}

	private static String exibirMenu() {
		String opcao;
        opcao = InOut.leString("Bem-vindo(a) ao Sistema de Atendimento ao Cliente!\n\n"
            + "Como posso te ajudar hoje?\n"
            + "1- Gerar senha;\n"
            + "2- Atendimento;\n"
            + "3- Sair da fila;\n"
            + "4- Mostrar todos os clientes não atendidos;\n"
            + "5- Sair do Programa.\n\n"
            + "Digite a opção desejada:");
        return opcao;
	}

}
