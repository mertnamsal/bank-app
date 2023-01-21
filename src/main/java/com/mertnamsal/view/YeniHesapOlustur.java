package com.mertnamsal.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mertnamsal.entity.Musteri;
import com.mertnamsal.entity.MusteriDetay;
import com.mertnamsal.service.MusteriService;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class YeniHesapOlustur extends JDialog {
	private JTextField tf_tckimlik;
	private JTextField tf_ad;
	private JTextField tf_soyad;
	private JTextField tf_telefon;
	private JPasswordField passwordField;
	private MusteriService musteriService = new MusteriService();
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			YeniHesapOlustur dialog = new YeniHesapOlustur();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public YeniHesapOlustur() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(YeniHesapOlustur.class.getResource("/com/mertnamsal/view/resources/SantaMoney.png")));
		
		setTitle("Hesap Oluşturma");
		setBounds(100, 100, 346, 502);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TC Kimlik :");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(40, 140, 90, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblAd = new JLabel("Ad :");
		lblAd.setForeground(Color.BLACK);
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAd.setBounds(40, 190, 90, 14);
		getContentPane().add(lblAd);
		
		JLabel lblSoyad = new JLabel("Soyad :");
		lblSoyad.setForeground(Color.BLACK);
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSoyad.setBounds(40, 240, 90, 14);
		getContentPane().add(lblSoyad);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setForeground(Color.BLACK);
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTelefon.setBounds(40, 340, 90, 14);
		getContentPane().add(lblTelefon);
		
		JLabel lblifre = new JLabel("Şifre :");
		lblifre.setForeground(Color.BLACK);
		lblifre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblifre.setBounds(40, 290, 90, 14);
		getContentPane().add(lblifre);
		
		tf_tckimlik = new JTextField();
		tf_tckimlik.setBounds(140, 137, 120, 20);
		getContentPane().add(tf_tckimlik);
		tf_tckimlik.setColumns(10);
		
		tf_ad = new JTextField();
		tf_ad.setColumns(10);
		tf_ad.setBounds(140, 187, 120, 20);
		getContentPane().add(tf_ad);
		
		tf_soyad = new JTextField();
		tf_soyad.setColumns(10);
		tf_soyad.setBounds(140, 237, 120, 20);
		getContentPane().add(tf_soyad);
		
		tf_telefon = new JTextField();
		tf_telefon.setColumns(10);
		tf_telefon.setBounds(140, 337, 120, 20);
		getContentPane().add(tf_telefon);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(140, 288, 120, 20);
		getContentPane().add(passwordField);
		
		JButton btnKayıtOl = new JButton("Kayıt Ol");
		btnKayıtOl.setForeground(Color.BLACK);
		btnKayıtOl.setBackground(Color.WHITE);
		btnKayıtOl.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKayıtOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MusteriDetay musteriDetay = new MusteriDetay(Long.parseLong(tf_tckimlik.getText()), 0, 0);
				Musteri musteri = new Musteri(Long.parseLong(tf_tckimlik.getText()),tf_ad.getText(),tf_soyad.getText(),Long.parseLong(tf_telefon.getText()),passwordField.getText(),musteriDetay);
				musteriService.save(musteri);
				JOptionPane.showMessageDialog(null, "Kayıt Başarılı");
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnKayıtOl.setBounds(140, 384, 89, 23);
		getContentPane().add(btnKayıtOl);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(YeniHesapOlustur.class.getResource("/com/mertnamsal/view/resources/hesapOlustrumaBackground.jpg")));
		lblNewLabel_1.setBounds(0, 0, 339, 470);
		getContentPane().add(lblNewLabel_1);
	}
}
