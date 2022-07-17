import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Banco {
	
	private final String NOME = "IBanco Digital 1.0";
	private final String MSG_ABERTURA = "Bem Vindo ao seu Banco Digital de testes de Opera��o!";
	
	private String nome;
	private List<Conta> contas;
	private List<Cliente> clientes;
	
	public Banco() {
		this.nome = NOME;
		this.contas = new ArrayList<>();
		this.clientes = new ArrayList<>();
		
		Cliente c1 = new Cliente("Anderson", "Ben�cio");
		Cliente c2 = new Cliente("Jo�o", "Souza");
		Cliente c3 = new Cliente("Maria", "Davila");
		clientes.add(c1);
		clientes.add(c2);
		clientes.add(c3);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void iniciar() {
		//JOptionPane.showMessageDialog(null, "Banco Iniciado");
		//boolean ativo = true;
		//while(ativo) {
		
			 JFrame frame = new JFrame( this.getNome() ); //Cria Janela e seu nome
			 frame.setSize(800, 400); //Ajusta tamanho da Janela
			 frame.setLocationRelativeTo(null); //Centra�iza Janela no meio
			 frame.addWindowListener(new WindowAdapter() { // Encerra Programa ao fechar a Janela
				 public void windowClosing(WindowEvent e){
					 System.exit(0);}
			 });
			 
			 JLabel label = new JLabel( MSG_ABERTURA ); //Cria Label de mensagem na janela
			 label.setPreferredSize(new Dimension(400, 100)); //tamanho prefer�vel da janela
			 frame.getContentPane().add(label, BorderLayout.NORTH); //adiciona label na janela
			 //frame.pack( ); //ajusta a janelka ao tamanho de prefer�ncia
			 frame.setVisible(true); //visibilidade ON
			 
			 JPanel jpanel  = new JPanel( ); // Onde ficar� os bot�es
			 frame.getContentPane().add(jpanel); 
			 
			 //Bot�es
			 JButton addCliente = new JButton("Adicionar Cliente");
			 JButton addContaCorrente = new JButton("Adicionar Conta Corrente");
			 JButton addContaPoupanca = new JButton("Adicionar Conta Poupan�a");
			 addCliente.setPreferredSize(new Dimension(200, 50));
			 addContaCorrente.setPreferredSize(new Dimension(200, 50));
			 addContaPoupanca.setPreferredSize(new Dimension(200, 50));
			 jpanel.add(addCliente);
			 jpanel.add(addContaCorrente);
			 jpanel.add(addContaPoupanca);
			 
			 
			 
			 
			
			 //Jpanel.add(b);
		//}
	}


}
