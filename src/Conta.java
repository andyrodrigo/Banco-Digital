
public abstract class Conta implements IConta {
	
	private static int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	
	public Conta ( Cliente cliente ) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.cliente.addConta(this);
	}
	
	public Conta () {
		this.agencia = 0;
		this.numero = 0;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Boolean checarSaldo( double valor ) {
		if( valor <= this.saldo ) {
			return true;
		}
		return false;
	}
	
	@Override
	public void sacar( double valor ) {
		this.saldo = saldo - valor;		
	}

	@Override
	public void depositar( double valor ) {
		this.saldo = saldo + valor;
		
	}

	@Override
	public void transferir( double valor, Conta contaDestino ) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	protected void impressaoComum() {
		System.out.println( String.format("Cliente: %s", this.cliente) );
		System.out.println( String.format("Agência: %d", this.agencia) );
		System.out.println( String.format("Número: %d", this.numero) );
		System.out.println( String.format("Saldo: %.2f", this.saldo) );
	}
	
	protected String impressaoComum2() {
		return String.format("Cliente: %s", this.cliente) + "<br>" + String.format("Agência: %d", this.agencia) + "<br>" +
				String.format("Número: %d", this.numero) + "<br>" + String.format("Saldo: %.2f", this.saldo);
	}

	protected abstract String imprimirExtratoTela();
}
