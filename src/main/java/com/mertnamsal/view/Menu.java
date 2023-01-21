package com.mertnamsal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import com.mertnamsal.service.MusteriService;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class Menu extends JFrame {

	private JPanel contentPane;
	private MusteriService musteriService = new MusteriService();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Menu frame = new Menu();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Menu(int tc) {
		setTitle("Menu");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/com/mertnamsal/view/resources/SantaMoney.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAyarlar = new JButton("Ayarlar");
		btnAyarlar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ayarlar ayarlar = new Ayarlar(tc);
				ayarlar.setVisible(true);
				dispose();
			}
		});
		btnAyarlar.setForeground(Color.BLACK);
		btnAyarlar.setBackground(Color.WHITE);
		btnAyarlar.setBounds(302, 256, 247, 23);
		contentPane.add(btnAyarlar);
		
		JLabel lblSantaMoneyIcon = new JLabel("");
		lblSantaMoneyIcon.setIcon(new ImageIcon(Menu.class.getResource("/com/mertnamsal/view/resources/santa-money-icon.png")));
		lblSantaMoneyIcon.setBounds(251, 319, 51, 42);
		contentPane.add(lblSantaMoneyIcon);
		
		JLabel lblBakiye = new JLabel("");
		lblBakiye.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBakiye.setForeground(Color.WHITE);
		lblBakiye.setBounds(391, 335, 91, 17);
		contentPane.add(lblBakiye);
		
		JLabel lblBakiyeYazisi = new JLabel("Bakiye :");
		lblBakiyeYazisi.setForeground(Color.WHITE);
		lblBakiyeYazisi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBakiyeYazisi.setBounds(306, 332, 76, 23);
		contentPane.add(lblBakiyeYazisi);
		
		JLabel lblNewLabel = new JLabel("Menü");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(391, 44, 98, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnKrediIslemleri = new JButton("Kredi İşlemleri");
		btnKrediIslemleri.setBackground(Color.WHITE);
		btnKrediIslemleri.setForeground(Color.BLACK);
		btnKrediIslemleri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankaKredi bankaKredi = new BankaKredi(tc);
				bankaKredi.setVisible(true);
				dispose();
			}
		});
		btnKrediIslemleri.setBounds(302, 122, 247, 23);
		contentPane.add(btnKrediIslemleri);
		
		JButton btnParaYkle = new JButton("Para Yükle");
		btnParaYkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yüklencekPara = JOptionPane.showInputDialog("Yüklemek istediğiniz miktarı giriniz");
				Double bakiye = Double.parseDouble(yüklencekPara)+Double.parseDouble(lblBakiye.getText());
				lblBakiye.setText(Double.toString(bakiye));
				musteriService.bakiyeGuncelle(tc,bakiye);
			}
		});
		btnParaYkle.setForeground(Color.BLACK);
		btnParaYkle.setBackground(Color.WHITE);
		btnParaYkle.setBounds(302, 168, 247, 23);
		contentPane.add(btnParaYkle);
		
		JButton btnParaCek = new JButton("Para Çekme");
		btnParaCek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cekilecekPara = JOptionPane.showInputDialog("Çekmek istediğiniz miktarı giriniz");
				if(Double.parseDouble(lblBakiye.getText())>Double.parseDouble(cekilecekPara)) {
					Double bakiye = Double.parseDouble(lblBakiye.getText())-Double.parseDouble(cekilecekPara);
					lblBakiye.setText(Double.toString(bakiye));
					musteriService.bakiyeGuncelle(tc,bakiye);
				}else {
					JOptionPane.showMessageDialog(null, "Bakiye Yetersiz");
				}
				
			}
		});
		btnParaCek.setForeground(Color.BLACK);
		btnParaCek.setBackground(Color.WHITE);
		btnParaCek.setBounds(302, 212, 247, 23);
		contentPane.add(btnParaCek);
		
		JButton btnCikis = new JButton("Çıkış");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
		});
		btnCikis.setForeground(Color.BLACK);
		btnCikis.setBackground(Color.WHITE);
		btnCikis.setBounds(302, 301, 247, 23);
		contentPane.add(btnCikis);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/com/mertnamsal/view/resources/MenuBackground.jpg")));
		lblNewLabel_1.setBounds(0, -33, 902, 488);
		contentPane.add(lblNewLabel_1);
		
		double guncelBakiye = musteriService.bakiyeGetir(tc);
		lblBakiye.setText(Double.toString(guncelBakiye));
		
		
	}
}
