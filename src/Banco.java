
public class Banco {
	
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public static void main(String[] args) {
		
		System.out.println(" ---------- Banco Digital ----------");
		
		Conta cc1 = new ContaCorrente();
		Conta cc2 = new ContaCorrente();
		Conta cc3 = new ContaCorrente();
		Conta cp1 = new ContaPoupanca();
		Conta cp2 = new ContaPoupanca();
		Conta cp3 = new ContaPoupanca();
		
		cc1.imprimirExtrato();
		cp1.imprimirExtrato();
		
	}
}
