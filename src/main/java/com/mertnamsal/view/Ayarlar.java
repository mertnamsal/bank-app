package com.mertnamsal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mertnamsal.service.MusteriService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ayarlar extends JFrame {
	private JPanel contentPane;
	private MusteriService musteriService= new MusteriService();
	
	public Ayarlar(int tc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMenuyeDon = new JButton("Menüye Dön");
		btnMenuyeDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu(tc);
				menu.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnHesabSil = new JButton("Hesabı Sil");
		btnHesabSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				musteriService.hesabiSil(tc);
			}
		});
		btnHesabSil.setForeground(new Color(0, 0, 0));
		btnHesabSil.setBackground(Color.RED);
		btnHesabSil.setBounds(467, 329, 117, 25);
		contentPane.add(btnHesabSil);
		btnMenuyeDon.setForeground(Color.BLACK);
		btnMenuyeDon.setBackground(Color.WHITE);
		btnMenuyeDon.setBounds(160, 164, 257, 25);
		contentPane.add(btnMenuyeDon);
		
		JButton btnNewButton = new JButton("Şifre Değiştirme");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eskiSifre =JOptionPane.showInputDialog("Eski şifrenizi giriniz");
				boolean kontrol =musteriService.girisKontrol(Integer.toString(tc), eskiSifre);
				while(kontrol) {
					String yeniSifre = JOptionPane.showInputDialog("Yeni şifrenizi giriniz");
					String kontrolYeniSifre = JOptionPane.showInputDialog("Yeni şifrenizi tekrar giriniz");
					if(eskiSifre.equals(yeniSifre)) {
						JOptionPane.showMessageDialog(null,"Lütfen yeni bir şifre giriniz");
					}
					else if(yeniSifre.equals(kontrolYeniSifre)) {
						JOptionPane.showMessageDialog(null,"Şifreniz başarıyla değiştirilmiştir");
						musteriService.sifreDegistir(tc,yeniSifre);
						break;
					}else {
						JOptionPane.showMessageDialog(null,"Girdiğiniz şifreler eşleşmemektedir.");
					}
				}
				
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(160, 113, 257, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Ayarlar");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(234, 39, 98, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Ayarlar.class.getResource("/com/mertnamsal/view/resources/ayarlarbackground.jpg")));
		lblNewLabel.setBounds(0, 0, 605, 383);
		contentPane.add(lblNewLabel);
	}
}
