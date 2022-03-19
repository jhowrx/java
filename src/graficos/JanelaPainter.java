package graficos;

import javax.swing.JFrame;

public class JanelaPainter extends JFrame {
	
	public JanelaPainter() {
		super("Painter psicod�lico usando gr�fico");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(new PainelPainter());//substitui o painel atual pelo personalizado
		setVisible(true);
	}

	public static void main(String[] args) {
		new JanelaPainter();

	}

}
