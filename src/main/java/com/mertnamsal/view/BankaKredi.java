package com.mertnamsal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankaKredi extends JFrame {

	private JPanel contentPane;
	private JTextField textField_krediMiktari;

	
	public BankaKredi(int tc) {
		setForeground(new Color(153, 255, 153));
		setBackground(new Color(50, 205, 50));
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankaKredi.class.getResource("/com/mertnamsal/view/resources/SantaMoney.png")));
		setTitle("Kredi ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1032, 545);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(new Color(51, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblKrediSayfasına = new JLabel("  Kredi Sayfasına Hoşgeldiniz");
		lblKrediSayfasına.setForeground(Color.BLACK);
		lblKrediSayfasına.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblKrediSayfasına.setBounds(155, 28, 302, 73);
		contentPane.add(lblKrediSayfasına);
		
		JButton btnSanta = new JButton("");
		btnSanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(btnSanta, "Happy New Year !");
			}
		});
		btnSanta.setIcon(new ImageIcon(BankaKredi.class.getResource("/com/mertnamsal/view/resources/santa-gift-icon.png")));
		btnSanta.setBounds(552, -20, 464, 526);
		contentPane.add(btnSanta);
		
		JLabel lblNewLabel_1 = new JLabel("Ne kadar kredi almak istersiniz ?");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(56, 141, 258, 28);
		contentPane.add(lblNewLabel_1);
		
		textField_krediMiktari = new JTextField();
		textField_krediMiktari.setBounds(56, 222, 186, 35);
		contentPane.add(textField_krediMiktari);
		textField_krediMiktari.setColumns(10);
		
		JButton btnKrediSecenekleri = new JButton("Kredi Seçeneklerini Gör");
		btnKrediSecenekleri.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKrediSecenekleri.setForeground(Color.BLACK);
		btnKrediSecenekleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_krediMiktari.getText().isEmpty()) {
					BankaFaizEkrani dialog = new BankaFaizEkrani(Integer.parseInt(textField_krediMiktari.getText()),tc);
					dialog.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Lütfen geçerli bir kredi miktarı giriniz");
				}
				
			}
		});
		btnKrediSecenekleri.setBounds(56, 310, 186, 28);
		contentPane.add(btnKrediSecenekleri);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(BankaKredi.class.getResource("/com/mertnamsal/view/resources/falling-star-icon.png")));
		lblNewLabel.setBounds(455, 28, 57, 45);
		contentPane.add(lblNewLabel);
		
		JButton btnMenuyeDon = new JButton("Menüye Dön");
		btnMenuyeDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu(tc);
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenuyeDon.setForeground(Color.BLACK);
		btnMenuyeDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuyeDon.setBounds(280, 310, 186, 28);
		contentPane.add(btnMenuyeDon);
	}
}
