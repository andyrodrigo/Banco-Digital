import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Sistema {
	
	private Banco banco;

	public Sistema() {
		this.banco = new Banco();
	}
	
	public void iniciar() {
		
		//Paineis Principais
		JPanel p1  = new JPanel();
		JPanel p2  = new JPanel();
		JPanel p3  = new JPanel();
		JPanel p4  = new JPanel();
		
		//Paineis Secundarios
		JPanel p31  = new JPanel();
		JPanel p32  = new JPanel();
		JPanel p33  = new JPanel();
		JPanel p34  = new JPanel();		
		
		 //Botões
		JButton addCliente = new JButton("Adicionar Cliente");
		JButton addContaCorrente = new JButton("Adicionar Conta Corrente");
		JButton addContaPoupanca = new JButton("Adicionar Conta Poupança");
		JButton depositar = new JButton("Depositar");
		JButton sacar = new JButton("Sacar");
		JButton transferir = new JButton("Transferir");
		JButton saldo = new JButton("Verificar Saldo");

		
		//Combox de Clientes
		JComboBox comboBoxClientes = new JComboBox( this.banco.getClientes() );
		
		JLabel label1 = new JLabel( "<html>" + this.banco.MSG_ABERTURA + "</html>", SwingConstants.CENTER ); //Cria Label de mensagem na janela
		 //label.setPreferredSize(new Dimension(400, 100)); //tamanho preferível da janela
		 //frame.getContentPane().add(label, BorderLayout.NORTH); //adiciona label na janela
		

		 JFrame frame = new JFrame( this.banco.getNome() ); //Cria Janela e seu nome
		 frame.setSize(800, 400); //Ajusta tamanho da Janela
		 frame.setLocationRelativeTo(null); //Centraçiza Janela no meio
		 frame.addWindowListener(new WindowAdapter() { // Encerra Programa ao fechar a Janela
			 public void windowClosing(WindowEvent e){
				 System.exit(0);}
		 });
		 frame.setLayout( new GridLayout(2,2));
		 frame.setVisible(true); //visibilidade ON
		 
		 frame.add(p1);
		 frame.add(p2);
		 frame.add(p3);
		 frame.add(p4);
		 
		 p1.add(label1);
		 
		 p3.setLayout( new GridLayout(4,1));
		 p3.add(p31);
		 p3.add(p32);
		 p3.add(p33);
		 p3.add(p34);
		 
		 p31.add(addCliente);
		 p32.add(comboBoxClientes);
		 p33.add(addContaCorrente);
		 p34.add(addContaPoupanca);
		 
		 p4.add(saldo);
		 p4.add(depositar);
		 p4.add(sacar);
		 p4.add(transferir);
		 
		 
		 //Actions
		 addCliente.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String nome = JOptionPane.showInputDialog("Nome do Cliente: ");
			    	String sobrenome = JOptionPane.showInputDialog("Sobrenome do Cliente: ");
			    	if(nome != null && sobrenome != null ) {
				    	Cliente cliente = new Cliente(nome, sobrenome);
				    	Sistema.this.banco.adicionarCliente(cliente);
				    	comboBoxClientes.addItem(cliente);
				    	JOptionPane.showMessageDialog(null, "Cliente " + nome + " " + sobrenome + " Inserido no Sistema");
				    	
			    	}else {
			    		JOptionPane.showMessageDialog(null, "O Nome ou o Sobrenome não podem estar vazios!");
			    	}
			    }
		 });
		 
		 addContaCorrente.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	
			    	String nome = comboBoxClientes.getSelectedItem().toString();
					int num = JOptionPane.showConfirmDialog(null, "Criar Conta Corrente para " + nome +"?", null, JOptionPane.OK_CANCEL_OPTION );
					System.out.println(num);
					
					if(num == 0) {
				    	int i = comboBoxClientes.getSelectedIndex();
				    	Cliente cliente = Sistema.this.banco.getCliente(i);
				    	Conta conta = new ContaCorrente( cliente );
				    	Sistema.this.banco.adicionarConta(conta);
				    	JOptionPane.showMessageDialog(null, "Conta Corrente criada para " + nome );
				    	String dados = conta.imprimirExtratoTela();
				    	label1.setText(dados);
					}
			    }
		});
		 
		 addContaPoupanca.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	
			    	String nome = comboBoxClientes.getSelectedItem().toString();
					int num = JOptionPane.showConfirmDialog(null, "Criar Conta Poupança para " + nome +"?", null, JOptionPane.OK_CANCEL_OPTION );
					System.out.println(num);
					
					if(num == 0) {
				    	int i = comboBoxClientes.getSelectedIndex();
				    	Cliente cliente = Sistema.this.banco.getCliente(i);	    	
				    	Conta conta = new ContaCorrente( cliente );
				    	Sistema.this.banco.adicionarConta(conta);
				    	JOptionPane.showMessageDialog(null, "Conta Poupança criada para " + nome );
				    	String dados = conta.imprimirExtratoTela();
				    	label1.setText(dados);
					}
			    }
		});
		 
		
		 saldo.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String numConta = JOptionPane.showInputDialog("Número da Conta: ");
					try {
						int num = Integer.parseInt(numConta);
					    Conta conta = Sistema.this.banco.buscaConta(num);
					    	
					    if( conta.getNumero() == 0 ) {
				    		//Não existe esta conta
				    		JOptionPane.showMessageDialog(null, "Não existe conta com este número!");
				    		System.out.println("Invalida");
					    }else {
					    		System.out.println("Imprimir");
					    		JOptionPane.showMessageDialog(null, "Saldo Atual: " + String.format("%.2f", conta.getSaldo() ) +"R$ ");
						    	String dados = conta.imprimirExtratoTela();
						    	label1.setText(dados);
					    }
					}catch(NumberFormatException erro){
						JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
					}
			    }
		});
		 
		 depositar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String numConta = JOptionPane.showInputDialog("Número da Conta: ");
					try {
						int num = Integer.parseInt(numConta);
				    	String deposito = JOptionPane.showInputDialog("Valor do depósito R$: ");
				    	
				    	try {
					    	Double valor = Double.parseDouble(deposito);
					    	
					    	Conta conta = Sistema.this.banco.buscaConta(num);
					    	if( conta.getNumero() == 0 ) {
					    		//Não existe esta conta
					    		JOptionPane.showMessageDialog(null, "Não existe conta com este número!");
					    		System.out.println("Invalida");
					    	}else {
					    		System.out.println("Pode Depositar");
					    		Sistema.this.banco.buscaConta(num).depositar(valor);
						    	String dados = conta.imprimirExtratoTela();
						    	label1.setText(dados);
						    	JOptionPane.showMessageDialog(null, "Depositado " + String.format("%.2f", valor) +"R$ " + "na conta número "+ num);
					    	}
				    		
						}catch(NumberFormatException erro){
							JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
						}
					}catch(NumberFormatException erro){
						JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
					}
			    }
		});
		 
		 sacar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String numConta = JOptionPane.showInputDialog("Número da Conta: ");
					try {
						int num = Integer.parseInt(numConta);
				    	String saque = JOptionPane.showInputDialog("Valor do saque R$: ");
				    	
				    	try {
					    	Double valor = Double.parseDouble(saque);
					    	
					    	Conta conta = Sistema.this.banco.buscaConta(num);
					    	if( conta.getNumero() == 0 ) {
					    		//Não existe esta conta
					    		JOptionPane.showMessageDialog(null, "Não existe conta com este número!");
					    		System.out.println("Invalida");
					    	}else {
					    		if( Sistema.this.banco.buscaConta(num).checarSaldo(valor) ) {
						    		System.out.println("Pode Sacar");
						    		Sistema.this.banco.buscaConta(num).sacar(valor);
							    	String dados = conta.imprimirExtratoTela();
							    	label1.setText(dados);
							    	JOptionPane.showMessageDialog(null, "Sacado " + String.format("%.2f", valor) +"R$ " + "da conta número "+ num);
					    		}else {
					    			JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
					    		}
					    	}
				    		
						}catch(NumberFormatException erro){
							JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
						}
					}catch(NumberFormatException erro){
						JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
					}
			    }
		});
		 
		 transferir.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String numConta1 = JOptionPane.showInputDialog("Número da Conta Debitada: ");
			    	String numConta2 = JOptionPane.showInputDialog("Número da Conta Creditada: ");
					try {
						int num1 = Integer.parseInt(numConta1);
						int num2 = Integer.parseInt(numConta2);
						
				    	String transferencia = JOptionPane.showInputDialog("Valor da transferência R$: ");
				    	
				    	try {
					    	Double valor = Double.parseDouble(transferencia);
					    	
					    	Conta conta1 = Sistema.this.banco.buscaConta(num1);
					    	Conta conta2 = Sistema.this.banco.buscaConta(num2);
					    	if( conta1.getNumero() == 0 ) {
					    		//Não existe esta conta
					    		JOptionPane.showMessageDialog(null, "Não existe conta de número " + num1);
					    		System.out.println("Invalida");
					    	}else if( conta2.getNumero() == 0 ){
					    		//Não existe esta conta
					    		JOptionPane.showMessageDialog(null, "Não existe conta de número " + num2);
					    		System.out.println("Invalida");
					    	}else{
					    		if( Sistema.this.banco.buscaConta(num1).checarSaldo(valor) ) {
						    		System.out.println("Pode Transferir");
						    		Sistema.this.banco.buscaConta(num1).transferir(valor, Sistema.this.banco.buscaConta(num2) );
							    	String dados = conta1.imprimirExtratoTela() + conta2.imprimirExtratoTela() ;
							    	label1.setText(dados);
							    	JOptionPane.showMessageDialog(null, "Tranferido " + String.format("%.2f", valor) +"R$ " + "da conta "+ num1 + " para a conta " + num2 );
					    		}else {
					    			JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
					    		}
					    	}
				    		
						}catch(NumberFormatException erro){
							JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
						}
					}catch(NumberFormatException erro){
						JOptionPane.showMessageDialog(null, "Entrada Inválida: " + erro.getMessage());
					}
			    }
		});
		 
	}
}
