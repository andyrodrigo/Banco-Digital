
public abstract class Conta implements IConta {
	
	private static int AGENCIA_PADRAO = 0001;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	//protected Cliente cliente;
	
	public Conta () {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		//this.cliente = cliente;
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

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
		System.out.println( String.format("Agência: %d", this.agencia) );
		System.out.println( String.format("Número: %d", this.numero) );
		System.out.println( String.format("Saldo: %.2f", this.saldo) );
	}
}
