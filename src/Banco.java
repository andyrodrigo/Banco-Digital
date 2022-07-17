import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private final String NOME = "IBanco Digital 1.0";
	public final String MSG_ABERTURA = "Bem Vindo ao seu Banco Digital de testes de Operações!";
	
	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;
	
	public Banco() {
		this.nome = NOME;
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>();
		
		Cliente c1 = new Cliente("Anderson", "Benício");
		Cliente c2 = new Cliente("João", "Souza");
		Cliente c3 = new Cliente("Maria", "Davila");
		this.clientes.add(c1);
		this.clientes.add(c2);
		this.clientes.add(c3);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void AdicionarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	
	public void AdicionarConta(Conta conta) {
		this.contas.add(conta);
	}
	
	public Cliente getCliente( int indice) {
		return this.clientes.get(indice);
	}
	
	public String[] getClientes() {
		
		String[] lista = new String[ this.clientes.size() ];
		int i = 0;
		Iterator<Cliente> iterador = this.clientes.iterator();
	    while( iterador.hasNext() ) {
	    	Cliente next = iterador.next();
	    	lista[i] = next.toString();
	    	i++;
	    }
		return lista;
		
	}

}
