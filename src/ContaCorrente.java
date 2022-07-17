
public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		// TODO Auto-generated constructor stub
	}

	public void imprimirExtrato() {
		
		System.out.println( "### Extrato Conta Corrente ### ");
		this.impressaoComum();;
		
	}
	
	public String imprimirExtratoTela() {
		
		String tipo = "### Extrato Conta Corrente ### <br>";
		String dados = this.impressaoComum2();
		
		System.out.println( tipo);
		this.impressaoComum();
		
		String impressao =  "<html>" + tipo + dados + "</html>";
		
		return impressao;
		
	}

}
