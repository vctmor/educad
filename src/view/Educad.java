package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class Educad extends JFrame {

	DAO dao = new DAO();
	private Connection con;
	private PreparedStatement pst;
	private ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	private JTextField textRa;
	private JLabel labelStatus;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnErase;
	private JButton btnReset;
	private JButton btnPdf;
	private JLabel label;
	private JButton btnSearch;
	private JButton btnLoadPhoto;
	private JLabel labelDate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					Educad frame = new Educad();
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
	public Educad() {


		addWindowListener((WindowListener) new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {

				status();
				setarData();
				
				setLocationRelativeTo(null);
			}
		});


		setTitle("Educad");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Educad.class.getResource("/img/camera.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(0, 245, 420, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelStatus = new JLabel("");
		labelStatus.setIcon(new ImageIcon(Educad.class.getResource("/img/dboff.png")));
		
		labelStatus.setBounds(359, 12, 32, 32);
		panel.add(labelStatus);
		
		labelDate = new JLabel("");
		labelDate.setForeground(SystemColor.text);
		labelDate.setFont(new Font("Dialog", Font.BOLD, 14));
		labelDate.setBounds(12, 23, 316, 21);
		panel.add(labelDate);
		
		JLabel lblRa = new JLabel("Ra:");
		lblRa.setBounds(16, 37, 34, 15);
		contentPane.add(lblRa);
		
		JLabel lblName = new JLabel("Nome:");
		lblName.setBounds(10, 74, 63, 15);
		contentPane.add(lblName);
		
		textName = new JTextField();
		textName.setBounds(68, 72, 225, 19);
		contentPane.add(textName);
		textName.setColumns(10);
		
		textRa = new JTextField();
		textRa.setColumns(10);
		textRa.setBounds(68, 35, 81, 19);
		contentPane.add(textRa);
		
		btnEdit = new JButton("");
		btnEdit.setEnabled(false);
		btnEdit.setIcon(new ImageIcon(Educad.class.getResource("/img/update.png")));
		btnEdit.setBounds(new Rectangle(0, 0, 64, 64));
		btnEdit.setBounds(86, 170, 64, 64);
		contentPane.add(btnEdit);
		
		btnSearch = new JButton("Buscar");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSearch.setBounds(211, 32, 117, 25);
		contentPane.add(btnSearch);
		
		btnAdd = new JButton("");
		btnAdd.setEnabled(false);
		btnAdd.setIcon(new ImageIcon(Educad.class.getResource("/img/create.png")));
		btnAdd.setBounds(new Rectangle(0, 0, 64, 64));
		btnAdd.setBounds(10, 170, 64, 64);
		contentPane.add(btnAdd);
		
		btnErase = new JButton("");
		btnErase.setEnabled(false);
		btnErase.setIcon(new ImageIcon(Educad.class.getResource("/img/delete.png")));
		btnErase.setBounds(new Rectangle(0, 0, 64, 64));
		btnErase.setBounds(193, 170, 64, 64);
		contentPane.add(btnErase);
		
		btnReset = new JButton("");
		btnReset.setIcon(new ImageIcon(Educad.class.getResource("/img/eraser.png")));
		btnReset.setBounds(new Rectangle(0, 0, 64, 64));
		btnReset.setBounds(269, 170, 64, 64);
		contentPane.add(btnReset);
		
		btnPdf = new JButton("");
		btnPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnPdf.setIcon(new ImageIcon(Educad.class.getResource("/img/pdf.png")));
		btnPdf.setBounds(new Rectangle(0, 0, 64, 64));
		btnPdf.setBounds(336, 94, 64, 64);
		contentPane.add(btnPdf);
		
		btnLoadPhoto = new JButton("Carregar Foto");
		btnLoadPhoto.setEnabled(false);
		btnLoadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLoadPhoto.setBounds(12, 115, 117, 25);
		contentPane.add(btnLoadPhoto);
		
		label = new JLabel("");
		label.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label.setAlignmentY(0.0f);
		label.setIcon(new ImageIcon(Educad.class.getResource("/img/camera.png")));
		label.setBounds(418, 0, 260, 309);
		contentPane.add(label);
		
		JScrollPane scrollPaneList = new JScrollPane();
		scrollPaneList.setVisible(false);
		scrollPaneList.setBounds(68, 86, 225, 86);
		contentPane.add(scrollPaneList);
		
		JList listNames = new JList();
		scrollPaneList.setViewportView(listNames);

	}// FIM Construtor

	private void status(){

		try {
			
			con = dao.conectar();

			if (con == null) {

				 System.out.println("Erro");
				labelStatus.setIcon(new ImageIcon(Educad.class.getResource("/img/dboff.png")));
			} else {

				System.out.println("Conectou");
				labelStatus.setIcon(new ImageIcon(Educad.class.getResource("/img/dbon.png")));

			}
			con.close();

		} catch (Exception e) {
			
			System.out.println(e);
		}
	}

	private void setarData(){

		// Obter a data atual
    java.util.Date dataUtil = new java.util.Date();
    
    // Convertendo java.util.Date para java.sql.Date
    java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
		DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL);
		labelDate.setText((formatter.format(dataSql)));
	}

/*

ok status()
ok setarData()
insertDB()
buscarRA()
listarNomes()
buscarNome()
editar()
excluir()
carregarFoto()
reset()
gerarPdf()

	 */
}
