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
		JButton b1 = new JButton("b1");
		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3");
		JButton b4 = new JButton("b4");
		
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
		 
		 
		 //Actions
		 addCliente.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	String nome = JOptionPane.showInputDialog("Nome do Cliente: ");
			    	String sobrenome = JOptionPane.showInputDialog("Sobrenome do Cliente: ");
			    	if(nome != null && sobrenome != null ) {
				    	Cliente cliente = new Cliente(nome, sobrenome);
				    	Sistema.this.banco.AdicionarCliente(cliente);
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
				    	JOptionPane.showMessageDialog(null, "Conta Poupança criada para " + nome );
				    	String dados = conta.imprimirExtratoTela();
				    	label1.setText(dados);
					}
			    }
		});
		 
		 
		 
		 
		 
		 /*

		 //frame.pack( ); //ajusta a janelka ao tamanho de preferência
		 
		 
		 
		 
		 
		 JPanel jpanel  = new JPanel( ); // Onde ficará os botões
		 jpanel.setPreferredSize(new Dimension(400, 100)); //tamanho preferível da janela
		 frame.getContentPane().add(jpanel);
		 JPanel jpanel2  = new JPanel( ); // Onde ficará os botões
		 jpanel2.setPreferredSize(new Dimension(400, 100)); //tamanho preferível da janela
		 frame.getContentPane().add(jpanel2);
		 

		 JButton listaClientes = new JButton("Listar Clientes");
		 JButton listaContas = new JButton("Listar Contas");
		 addCliente.setPreferredSize(new Dimension(200, 50));
		 addContaCorrente.setPreferredSize(new Dimension(200, 50));
		 addContaPoupanca.setPreferredSize(new Dimension(200, 50));
		 listaClientes.setPreferredSize(new Dimension(200, 50));
		 listaContas.setPreferredSize(new Dimension(200, 50));
		 jpanel.add(addCliente);
		 jpanel.add(addContaCorrente);
		 jpanel.add(addContaPoupanca);
		 jpanel.add(listaClientes);
		 jpanel.add(listaContas);
		 

		 

		 
*/
		 
		 
		 
		 
		 
		 
	}

	
	

}
