
public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	public void imprimirExtrato() {
		
		System.out.println( "### Extrato Conta Poupan�a ### ");
		this.impressaoComum();

	}
	
	public String imprimirExtratoTela() {
		
		String tipo = "### Extrato Conta Poupan�a ### <br>";
		String dados = this.impressaoComum2();
		
		System.out.println( tipo);
		this.impressaoComum();	
		
		String impressao =  "<html>" + tipo + dados + "</html>";
		
		return impressao;
		
	}

}
