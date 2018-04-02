import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LAB4 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LAB4 frame = new LAB4();
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
	public LAB4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Program");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Zamknij");
		mnNewMenu_1.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Nazwa studenta");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
	
		GridBagConstraints gbc_textFieldUsername = new GridBagConstraints();
		gbc_textFieldUsername.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUsername.gridx = 3;
		gbc_textFieldUsername.gridy = 1;
		contentPane.add(textFieldUsername, gbc_textFieldUsername);
		textFieldUsername.setColumns(10);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("  ");
		lblNewLabel_2.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("Haslo studenta");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 3;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				 String uname= textFieldPassword.getText();
				 Pattern p = Pattern.compile(".{3,20}");
				 Matcher m = p.matcher(uname);
				 boolean b = m.matches();
				 
				 if(b)
				 {
					 lblNewLabel_2.setVisible(false);
				 }
				 else 
				 {
					// lblNewLabel_3.setVisible(true);
				 }
			}
			
		});
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 3;
		gbc_textFieldPassword.gridy = 3;
		contentPane.add(textFieldPassword, gbc_textFieldPassword);
		
		JLabel lblNewLabel_3 = new JLabel("   ");
		lblNewLabel_3.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				 String uname= textFieldUsername.getText();
				 String pswd=textFieldPassword.getText();
				
				
				 Pattern p = Pattern.compile(".{3,20}");
				 Matcher m = p.matcher(uname);
				 boolean b = m.matches();
				 
				 Pattern pi = Pattern.compile(".{3,20}");
				 Matcher mi = pi.matcher(pswd);
				 boolean bi = mi.matches();
				 
				/*if((pswd.equals("admin"))&&((uname.equals("admin"))))
				{
					
					//Lista.main(null);
					
				}*/
				if((b&&bi))
				{
					//lblNewLabel1.setText("Podano z³e dane!");
					lblNewLabel_2.setText("To pole powinno zawieraæ 3-20 znaków!");	
					lblNewLabel_3.setText("To pole powinno zawieraæ 3-20 znaków!");
				}
				else if(b)
				{
					
					lblNewLabel_3.setText("To pole powinno zawieraæ 3-20 znaków!");
				}
				else if(bi)
				{
					lblNewLabel_2.setText("To pole powinno zawieraæ 3-20 znaków!");	
				}
				else
				{
					//lblNewLabel1.setText("Podano z³e dane!");
				}

			}
		});
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 6;
		contentPane.add(btnLogin, gbc_btnLogin);
		textFieldUsername = new JTextField();
		textFieldUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
			
					 String uname= (String.valueOf(textFieldPassword.getPassword()));
					 Pattern p = Pattern.compile(".{3,20}");
					 Matcher m = p.matcher(uname);
					 boolean b = m.matches();
					 
					 if(b)
					 {
						 lblNewLabel_2.setVisible(false);
					 }
					 else 
					 {
						 lblNewLabel_3.setVisible(true);
					 }
				}
			
		});
	
	}

}
