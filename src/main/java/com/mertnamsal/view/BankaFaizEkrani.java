package com.mertnamsal.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.mertnamsal.service.MusteriService;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BankaFaizEkrani extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JComboBox comboBoxAy;
	private JButton btnHesapla;
	private JTextField textFieldFaizliBorcToplami;
	private JButton btnMenuyeDon;
	private MusteriService musteriService = new MusteriService();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BankaFaizEkrani frame = new BankaFaizEkrani();
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
	public BankaFaizEkrani(int para,int tc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BankaFaizEkrani.class.getResource("/com/mertnamsal/view/resources/SantaMoney.png")));
		setTitle("Kredi Hesaplama");
		setBounds(100, 100, 976, 533);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(303, 83, 532, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.GRAY);
		table.setForeground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ay", "Faizsiz Bor\u00E7", "Faizli Bor\u00E7", "Faiz Miktar\u0131 (%)"
			}
		));
		scrollPane.setViewportView(table);
		
		comboBoxAy = new JComboBox();
		comboBoxAy.setModel(new DefaultComboBoxModel(new String[] {"12", "18", "24", "36"}));
		comboBoxAy.setBounds(90, 115, 66, 27);
		contentPane.add(comboBoxAy);
		
		btnHesapla = new JButton("Hesapla");
		btnHesapla.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnHesapla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabloyuDoldur(para);
			}
		});
		btnHesapla.setBounds(59, 225, 153, 23);
		contentPane.add(btnHesapla);
		
		textFieldFaizliBorcToplami = new JTextField();
		textFieldFaizliBorcToplami.setColumns(10);
		textFieldFaizliBorcToplami.setBounds(529, 368, 144, 27);
		contentPane.add(textFieldFaizliBorcToplami);
		
		JLabel lblFaizliBorToplam = new JLabel("Faizli Borç Toplamı :");
		lblFaizliBorToplam.setBackground(Color.BLACK);
		lblFaizliBorToplam.setForeground(Color.WHITE);
		lblFaizliBorToplam.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFaizliBorToplam.setBounds(327, 371, 192, 17);
		contentPane.add(lblFaizliBorToplam);
		
		btnMenuyeDon = new JButton("Menüye Dön");
		btnMenuyeDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = new Menu(tc);
				menu.setVisible(true);
				dispose();
			}
		});
		btnMenuyeDon.setForeground(Color.BLACK);
		btnMenuyeDon.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenuyeDon.setBounds(801, 437, 118, 28);
		contentPane.add(btnMenuyeDon);
		
		JButton btnKrediOnayla = new JButton("Kredi Onayla");
		btnKrediOnayla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sayi =JOptionPane.showConfirmDialog(null,"Emin misin ?");
				if(sayi == 1) {
					double borc =musteriService.borcGetir(tc);
					borc += Double.parseDouble(textFieldFaizliBorcToplami.getText());
					musteriService.borcGuncelle(tc,borc);
				}
			}
		});
		btnKrediOnayla.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnKrediOnayla.setBounds(59, 274, 153, 27);
		contentPane.add(btnKrediOnayla);
	}
	public void tabloyuDoldur(int para) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		Object[] columns = new Object[Integer.parseInt(comboBoxAy.getSelectedItem().toString())];
		for (int i = 0; i < columns.length; i++) {
			columns[0] = i+1;
			columns[1] = ondalik( para / Double.parseDouble(comboBoxAy.getSelectedItem().toString()),2) ;
			columns[3] = ondalik (Double.parseDouble(comboBoxAy.getSelectedItem().toString())/10,2);
			columns[2] = ondalik(Double.parseDouble(columns[1].toString())+Double.parseDouble(columns[3].toString()),2);
			model.addRow(columns);
		}
		double toplamBorc = para*ondalik(Double.parseDouble(comboBoxAy.getSelectedItem().toString())/10,2);
		textFieldFaizliBorcToplami.setText(String.valueOf(toplamBorc));
	
		
		
	}
	public double ondalik(double sayi, int ondalikAdedi) {
		String ondalikBicimi = "##.";
		for (int i = 0; i < ondalikAdedi; i++) {
			ondalikBicimi+="#";
		}
		return Double.parseDouble(new DecimalFormat(ondalikBicimi).format(sayi));
	}
}
