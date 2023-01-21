package com.mertnamsal.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mertnamsal.service.MusteriService;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tf_tckimlik;
	private JFrame frame;
	private MusteriService musteriService = new MusteriService();
	private JPasswordField passwordField;
	private JLabel YanlisTuslama;


	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login() {
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/mertnamsal/view/resources/SantaMoney.png")));
		setBounds(100, 100, 507, 374);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.LIGHT_GRAY);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("TC Kimlik No");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel.setBounds(77, 141, 111, 17);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Şifre");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(105, 172, 59, 15);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JButton btnLogin = new JButton("Giriş");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean check = musteriService.girisKontrol(tf_tckimlik.getText(),passwordField.getText());
					if(check == true) {
						Menu dialog = new Menu(Integer.parseInt(tf_tckimlik.getText()));
						dialog.setVisible(true);
						dispose();
					}else{
						YanlisTuslama.setText("Yanlış Tuşlama");
					}
					
				}
			});
			btnLogin.setBounds(199, 227, 89, 23);
			contentPanel.add(btnLogin);
		}
		{
			JButton btnKaydol = new JButton("Kaydol");
			btnKaydol.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					YeniHesapOlustur dialog = new YeniHesapOlustur();
					dialog.setVisible(true);
					dispose();
					
					
				}
			});
			btnKaydol.setBounds(199, 262, 89, 23);
			contentPanel.add(btnKaydol);
		}
		{
			tf_tckimlik = new JTextField();
			tf_tckimlik.setBounds(188, 141, 111, 20);
			contentPanel.add(tf_tckimlik);
			tf_tckimlik.setColumns(10);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(188, 172, 111, 17);
			contentPanel.add(passwordField);
		}
		
		JLabel lblNewLabel_2 = new JLabel("Ekmek Banka Hoşgeldiniz");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(137, 66, 332, 35);
		contentPanel.add(lblNewLabel_2);
		{
			YanlisTuslama = new JLabel("");
			YanlisTuslama.setForeground(Color.RED);
			YanlisTuslama.setBounds(198, 202, 89, 14);
			contentPanel.add(YanlisTuslama);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setForeground(Color.RED);
			lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/com/mertnamsal/view/resources/Christmas_background.jpg")));
			lblNewLabel_3.setBounds(0, 0, 498, 345);
			contentPanel.add(lblNewLabel_3);
		}
		ImageIcon img = new ImageIcon(Login.class.getResource("/com/mertnamsal/view/resources/Christmas-Santa-Cap-icon.png"));
		Image img2= img.getImage();
		Image temp = img2.getScaledInstance(50, 35, Image.SCALE_SMOOTH);
		img = new ImageIcon(temp);
	}
}
