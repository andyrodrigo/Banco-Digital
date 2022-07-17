import java.util.ArrayList;
import java.util.List;

public class Cliente {

	private String nome;
	private String sobreNome;
	private List<Conta> contas;
	
	public Cliente(String nome, String sobreNome) {
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.contas = new ArrayList<>();;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public void addConta( Conta conta ) {
		this.contas.add(conta);
	}
	
	public void verContas() {
		System.out.println("Contas de " + this.getNome() + " " + this.getSobreNome() + ": " + contas);
	}
	
}
