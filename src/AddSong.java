import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddSong extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldSongName;
	private JTextField textFieldAlbum;
	private JTextField textFieldGenre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSong frame = new AddSong();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddSong() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSongName = new JLabel("Song Name");
		lblSongName.setBounds(29, 34, 64, 14);
		contentPane.add(lblSongName);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(29, 91, 46, 14);
		contentPane.add(lblGenre);
		
		JLabel lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(29, 59, 46, 14);
		contentPane.add(lblAlbum);
		
		textFieldSongName = new JTextField();
		textFieldSongName.setBounds(103, 31, 86, 20);
		contentPane.add(textFieldSongName);
		textFieldSongName.setColumns(10);
		
		textFieldAlbum = new JTextField();
		textFieldAlbum.setColumns(10);
		textFieldAlbum.setBounds(103, 56, 86, 20);
		contentPane.add(textFieldAlbum);
		
		textFieldGenre = new JTextField();
		textFieldGenre.setColumns(10);
		textFieldGenre.setBounds(103, 88, 86, 20);
		contentPane.add(textFieldGenre);
		
		JButton btnNewButton = new JButton("Add Song");
		btnNewButton.setBounds(306, 203, 89, 23);
		contentPane.add(btnNewButton);
	}

}
