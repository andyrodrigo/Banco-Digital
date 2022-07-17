import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		/*
		   // Algo que deseja mostrar (aviso, mensagem de erro)
	    String erro = "Erro 404: não foi possível encontrar o batman";

	    // Cria um JFrame
	    JFrame frame = new JFrame("JOptionPane exemplo");

	    // Cria o JOptionPane por showMessageDialog
	    JOptionPane.showMessageDialog(frame,
	        "Houve um problema ao procurar o batman:\n\n '" + erro + "'.", //mensagem
	        "Erro 404", // titulo da janela 
	        JOptionPane.INFORMATION_MESSAGE);
	    System.exit(0);*/
	    
		
		System.out.println(" ---------- Banco Digital ----------");
		
		int num = JOptionPane.showConfirmDialog(null, "Entrar no Banco Digital", null, JOptionPane.OK_CANCEL_OPTION );
		System.out.println(num);
		
		if(num == 0) {
			Sistema sistema = new Sistema();
			sistema.iniciar();
		}else {
			JOptionPane.showMessageDialog(null, "Operação Encerrada");
			System.exit(0);
		}
		
		/*
		Conta cc1 = new ContaCorrente();
		Conta cc2 = new ContaCorrente();
		Conta cc3 = new ContaCorrente();
		Conta cp1 = new ContaPoupanca();
		Conta cp2 = new ContaPoupanca();
		Conta cp3 = new ContaPoupanca();
		
		cc1.imprimirExtrato();
		cp1.imprimirExtrato();*/
		
	}

}
