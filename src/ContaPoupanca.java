
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}
	
	public ContaPoupanca () {
		this.agencia = 0;
		this.numero = 0;
	}

	public void imprimirExtrato() {
		
		System.out.println( "### Extrato Conta Poupança ### ");
		this.impressaoComum();

	}
	
	public String imprimirExtratoTela() {
		
		String tipo = "### Extrato Conta Poupança ### <br>";
		String dados = this.impressaoComum2();
		
		System.out.println( tipo);
		this.impressaoComum();	
		
		String impressao =  "<html>" + tipo + dados + "</html>";
		
		return impressao;
		
	}

}
