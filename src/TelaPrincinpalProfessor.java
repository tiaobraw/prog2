import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class TelaPrincinpalProfessor {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincinpalProfessor window = new TelaPrincinpalProfessor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincinpalProfessor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(6, 6, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matricula:");
		lblNewLabel_1.setBounds(6, 34, 69, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Eventos");
		lblNewLabel_2.setBounds(74, 62, 61, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_2 = new JButton("Ver Evento");
		btnNewButton_2.setBounds(282, 94, 117, 29);
		frame.getContentPane().add(btnNewButton_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(54, 6, 167, 16);
		frame.getContentPane().add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(74, 34, 147, 16);
		frame.getContentPane().add(textPane_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(6, 84, 215, 127);
		frame.getContentPane().add(textPane_2);
		
		JButton btnNewButton_3 = new JButton("Criar Evento");
		btnNewButton_3.setBounds(282, 132, 117, 29);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Sair");
		btnNewButton.setBounds(6, 243, 117, 29);
		frame.getContentPane().add(btnNewButton);
	}

}
