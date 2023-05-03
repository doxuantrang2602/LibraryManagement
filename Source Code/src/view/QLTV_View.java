package view;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import org.jfree.util.Rotation;


import com.toedter.calendar.JDateChooser;

import Entities.PhieuMuon;
import Entities.QLPhieuMuon_Model;
import Entities.QLSV_Model;
import Entities.QLSach_Model;
import Entities.QLThongTin_model;
import Entities.Sach;
import Entities.SinhVien;
import Entities.Tinh;
import controller.QLPhieuMuon_controller;
import controller.QLSV_controller;
import controller.QLSach_controller;
import controller.ThongTin_controller;
import dao.PhieuMuonDao;
import dao.SachDAO;
import dao.SinhVienDao;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JSeparator;

import java.awt.Toolkit;
import javax.swing.Icon;

import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

import javax.swing.JComboBox;

import java.awt.Panel;

public class QLTV_View extends JFrame {
	DefaultTableModel model;
	DefaultTableModel model2;
	public QLSach_Model model_Sach;
	public JPanel contentPane;
	public JTable table_QLSach;
	
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	public JTextField textField_TuKhoaSach_Tim;
	public JTextField textField_idSach;
	public JTextField textField_tenSach;
	public JTextField textField_tacGia;
	public JTextField textField_theLoai;
	public JTextField textField_namXB;
	public JTextField textField_soLuongCon;
	public Component btn_thoat_QLSach;
	public JTable table_QLSV;
	
	
	
	// SINH VIÊN
	public QLSV_Model model_SV;
	public JTextField textField_maSV;
	public JTextField textField_hoVaTenSV;
	public JTextField textField_lopKhoa;
	public JTextField textField_EmailSV;
	public JTextField textField_SdtSV;
	public JTextField textField_msv_timKiem;
	public JComboBox<String> comboBox_queQuanSV;
	public JDateChooser textField_ngaySinhSV;
	
	
	// Phiếu mượn
	public QLPhieuMuon_Model model_PM;
	public JTable table_QLPM;
	public JTextField textField_maPhieu;
	public JTextField textField_soLuongMuon;
	public JTextField textField_tongSachMuon;
	public JTextField textField_tim_MaPhieu;
	public JComboBox<Integer> comboBox_maSV;
	public JComboBox<Integer> comboBox_maSach;
	public JDateChooser textField_ngayMuon;
	
	//thông tin
		public QLThongTin_model model_TT;
		public JLabel Lable_name1;
		public JLabel Lable_email1;
		public JLabel Lable_SDT1;
		public JTextField textField_Ten2;
		public JTextField textField_Email2;
		public JTextField textField_SDT2;
		private JTextField textField_6;
		private JTextField textField_7;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLTV_View frame = new QLTV_View();
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
	public QLTV_View() {
		this.model_Sach = new QLSach_Model();
		this.model_SV = new QLSV_Model();
		this.model_PM = new QLPhieuMuon_Model();
		this.model_TT = new QLThongTin_model();
		this.setTitle("Quản lý Thư viện");
		setIconImage(Toolkit.getDefaultToolkit().getImage(QLTV_View.class.getResource("/Image/title.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 80, 841, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
		);
		
		ActionListener ac = new QLSach_controller(this);
		Font font = new Font("Tahoma", Font.PLAIN, 15);
		
		
		JPanel panel_QLSach = new JPanel();
		panel_QLSach.setBorder(null);
		panel_QLSach.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Quản lý Sách", (Icon) null, panel_QLSach, null);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel_2 = new JPanel();
		
		JLabel label_thongtin = new JLabel("Thông tin Sách");
		label_thongtin.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel label_dsts = new JLabel("Danh sách Sách");
		label_dsts.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Box horizontalBox_2_1 = Box.createHorizontalBox();
		horizontalBox_2_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_thongtin_1 = new JLabel("Chức năng");
		label_thongtin_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_QLSach = new GroupLayout(panel_QLSach);
		gl_panel_QLSach.setHorizontalGroup(
			gl_panel_QLSach.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
				.addGroup(gl_panel_QLSach.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_QLSach.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_QLSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_QLSach.createSequentialGroup()
							.addComponent(horizontalBox_2, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_panel_QLSach.createSequentialGroup()
							.addComponent(label_thongtin, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_QLSach.createParallelGroup(Alignment.LEADING)
						.addComponent(horizontalBox_2_1, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
						.addComponent(label_thongtin_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
				.addGroup(gl_panel_QLSach.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_dsts, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(648, Short.MAX_VALUE))
		);
		gl_panel_QLSach.setVerticalGroup(
			gl_panel_QLSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QLSach.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label_dsts, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_QLSach.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_thongtin, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_thongtin_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_QLSach.createParallelGroup(Alignment.LEADING, false)
						.addComponent(horizontalBox_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(horizontalBox_2, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
					.addGap(14))
		);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(new Color(248, 248, 255));
		horizontalBox_2.add(panel_5);
		
		JLabel label_maSach = new JLabel("Mã sách");
		label_maSach.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_idSach = new JTextField();
		textField_idSach.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_idSach.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("*Mã sách không quá 6 chữ số");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBackground(new Color(245, 255, 250));
		
		JLabel label_tenSach = new JLabel("Tên sách");
		label_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_tenSach = new JTextField();
		textField_tenSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tenSach.setColumns(10);
		
		JLabel label_tacGia = new JLabel("Tác giả");
		label_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_tacGia = new JTextField();
		textField_tacGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_tacGia.setColumns(10);
		
		JLabel label_theLoai = new JLabel("Thể loại");
		label_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_theLoai = new JTextField();
		textField_theLoai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_theLoai.setColumns(10);
		
		JLabel label_namXB = new JLabel("Năm XB");
		label_namXB.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_namXB = new JTextField();
		textField_namXB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_namXB.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("*0 < x < 2023");
		lblNewLabel_1_3.setForeground(Color.RED);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBackground(new Color(245, 255, 250));
		
		JLabel label_soLuongCon = new JLabel("Số lượng ");
		label_soLuongCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_soLuongCon = new JTextField();
		textField_soLuongCon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_soLuongCon.setColumns(10);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("*x thuộc N");
		lblNewLabel_1_3_1.setForeground(Color.RED);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBackground(new Color(245, 255, 250));
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(label_maSach, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_tenSach, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_5.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())
								.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_5.createSequentialGroup()
										.addComponent(textField_idSach, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addGap(125))
									.addGroup(gl_panel_5.createSequentialGroup()
										.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
											.addComponent(textField_tenSach, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
											.addComponent(textField_theLoai, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
											.addComponent(textField_tacGia, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
											.addComponent(textField_namXB, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))
										.addGap(124)))))
						.addComponent(label_tacGia, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_theLoai, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(label_namXB, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_soLuongCon, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_soLuongCon, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addContainerGap(124, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_maSach, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_idSach, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_tenSach, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_tenSach, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_tacGia, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_tacGia, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_theLoai, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_theLoai, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(label_namXB, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addComponent(textField_namXB, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(label_soLuongCon, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_soLuongCon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_5.setLayout(gl_panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		panel_6.setBackground(new Color(248, 248, 255));
		horizontalBox_2_1.add(panel_6);
		
		JLabel lblTKhaCn = new JLabel("Từ khóa cần tìm");
		lblTKhaCn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_TuKhoaSach_Tim = new JTextField();
		textField_TuKhoaSach_Tim.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_TuKhoaSach_Tim.setColumns(10);
		
		JButton btn_huyTimSach = new JButton("Hủy");
		btn_huyTimSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/resetSearch.png")));
		btn_huyTimSach.addActionListener(ac);
		btn_huyTimSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_timSach = new JButton("Tìm");
		btn_timSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/searchBook.png")));
		btn_timSach.addActionListener(ac);
		btn_timSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1_1 = new JLabel("*Nhập từ khóa bạn muốn tìm");
		lblNewLabel_1_1.setForeground(Color.RED);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBackground(new Color(245, 255, 250));
		
		JLabel lblSearch = new JLabel("Search Book");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton btn_themSach = new JButton("Thêm");

		btn_themSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/addBook.png")));
		btn_themSach.addActionListener(ac);
		btn_themSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_suaSach = new JButton("Sửa");
		btn_suaSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/updateBook.png")));
		btn_suaSach.addActionListener(ac);
		btn_suaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_xoaSach = new JButton("Xóa");
		btn_xoaSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/deleteBook.png")));
		btn_xoaSach.addActionListener(ac);
		btn_xoaSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_luuSach = new JButton("Lưu");
		btn_luuSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/saveBook.png")));
		btn_luuSach.addActionListener(ac);
		btn_luuSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_resetBook = new JButton("Reset");
		btn_resetBook.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/return.png")));
		btn_resetBook.addActionListener(ac);
		btn_resetBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_thoat_QLSach = new JButton("Thoát chương trình");
		btn_thoat_QLSach.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		btn_thoat_QLSach.addActionListener(ac);
		btn_thoat_QLSach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(8)
							.addComponent(lblTKhaCn, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel_6.createSequentialGroup()
									.addGroup(gl_panel_6.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_TuKhoaSach_Tim, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
										.addGroup(gl_panel_6.createSequentialGroup()
											.addGap(6)
											.addComponent(btn_timSach, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(btn_huyTimSach, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
											.addGap(24))
										.addComponent(lblSearch, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
									.addGap(17))))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_themSach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_xoaSach, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_suaSach, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_luuSach, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_resetBook, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btn_thoat_QLSach, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(19)))
					.addGap(0))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearch, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_TuKhoaSach_Tim, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTKhaCn, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_huyTimSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_timSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(30)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
							.addComponent(btn_themSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addComponent(btn_xoaSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
							.addComponent(btn_suaSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
						.addComponent(btn_luuSach, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_resetBook, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_thoat_QLSach, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(55))
		);
		panel_6.setLayout(gl_panel_6);
		
		JMenuBar menuBar = 
				new JMenuBar();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addComponent(menuBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar.add(mnFile);
		
		JMenuItem menu_Open = new JMenuItem("Open");
		menu_Open.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		menu_Open.addActionListener(ac);
		menu_Open.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile.add(menu_Open);
		
		JMenuItem menu_Save = new JMenuItem("Save");
		menu_Save.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/save.png")));
		menu_Save.addActionListener(ac);
		menu_Save.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile.add(menu_Save);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem menu_Exit = new JMenuItem("Exit");
		menu_Exit.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		menu_Exit.addActionListener(ac);
		menu_Exit.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile.add(menu_Exit);
		
		JMenu mnProject = new JMenu("Project");
		mnProject.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar.add(mnProject);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New project");
		mntmNewMenuItem_3.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/newProject.png")));
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Open project");
		mntmNewMenuItem_2.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject.add(mntmNewMenuItem_2);
		
		JSeparator separator_1 = new JSeparator();
		mnProject.add(separator_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Properties");
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject.add(mntmNewMenuItem);
		panel_2.setLayout(gl_panel_2);
		
		table_QLSach = new JTable();
		new SachDAO().getListSach(model_Sach);
		model = (DefaultTableModel) table_QLSach.getModel();
		model.setColumnIdentifiers(new Object[] {
			"Mã sách", "Tên sách", "Tác giả", "Thể loại", "Năm xuất bản", "Số lượng còn"
		});
		table_QLSach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTableHeader header = table_QLSach.getTableHeader();
		header.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_QLSach.setRowHeight(25);
		scrollPane.setViewportView(table_QLSach);
		panel_QLSach.setLayout(gl_panel_QLSach);
		showTable_Sach();
		
		
		
		// Quản li Sinh Viên
		
		ActionListener ac_sv = new QLSV_controller(this);
		
		JPanel panel_QLSinhVien = new JPanel();
		panel_QLSinhVien.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Quản lý Sinh Viên", null, panel_QLSinhVien, null);
		
		JPanel panel_2_1 = new JPanel();
		
		JMenuBar menuBar_1 = new JMenuBar();
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 812, Short.MAX_VALUE)
				.addComponent(menuBar_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 32, Short.MAX_VALUE)
				.addGroup(gl_panel_2_1.createSequentialGroup()
					.addComponent(menuBar_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenu mnFile_1 = new JMenu("File");
		mnFile_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar_1.add(mnFile_1);
		
		JMenuItem menu_Open_1 = new JMenuItem("Open");
		menu_Open_1.addActionListener(ac_sv);
		menu_Open_1.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		menu_Open_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile_1.add(menu_Open_1);
		
		JMenuItem menu_Save_1 = new JMenuItem("Save");
		menu_Save_1.addActionListener(ac_sv);
		menu_Save_1.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/save.png")));
		menu_Save_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile_1.add(menu_Save_1);
		
		JSeparator separator_2 = new JSeparator();
		mnFile_1.add(separator_2);
		
		JMenuItem menu_Exit_1 = new JMenuItem("Exit");
		menu_Exit_1.addActionListener(ac_sv);
		menu_Exit_1.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		menu_Exit_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnFile_1.add(menu_Exit_1);
		
		JMenu mnProject_1 = new JMenu("Project");
		mnProject_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		menuBar_1.add(mnProject_1);
		
		JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("New project");
		mntmNewMenuItem_3_1.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mntmNewMenuItem_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject_1.add(mntmNewMenuItem_3_1);
		
		JMenuItem mntmNewMenuItem_2_1 = new JMenuItem("Open project");
		mntmNewMenuItem_2_1.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/newProject.png")));
		mntmNewMenuItem_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject_1.add(mntmNewMenuItem_2_1);
		
		JSeparator separator_1_1 = new JSeparator();
		mnProject_1.add(separator_1_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Properties");
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnProject_1.add(mntmNewMenuItem_1);
		panel_2_1.setLayout(gl_panel_2_1);
		
		JLabel lblDanhSchSinh = new JLabel("Danh sách Sinh viên");
		lblDanhSchSinh.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JLabel label_thongtin_2 = new JLabel("Thông tin Sinh Viên");
		label_thongtin_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel label_thongtin_1_1 = new JLabel("Chức năng");
		label_thongtin_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_panel_QLSinhVien = new GroupLayout(panel_QLSinhVien);
		gl_panel_QLSinhVien.setHorizontalGroup(
			gl_panel_QLSinhVien.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_2_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(gl_panel_QLSinhVien.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_QLSinhVien.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDanhSchSinh, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(620, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_QLSinhVien.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_QLSinhVien.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_QLSinhVien.createSequentialGroup()
							.addComponent(horizontalBox, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(gl_panel_QLSinhVien.createSequentialGroup()
							.addComponent(label_thongtin_2, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
							.addGap(199)))
					.addGroup(gl_panel_QLSinhVien.createParallelGroup(Alignment.LEADING)
						.addComponent(label_thongtin_1_1, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_QLSinhVien.setVerticalGroup(
			gl_panel_QLSinhVien.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QLSinhVien.createSequentialGroup()
					.addComponent(panel_2_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDanhSchSinh, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(10)
					.addGroup(gl_panel_QLSinhVien.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_thongtin_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_thongtin_1_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_QLSinhVien.createParallelGroup(Alignment.LEADING, false)
						.addComponent(horizontalBox_1, 0, 0, Short.MAX_VALUE)
						.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 348, Short.MAX_VALUE))
					.addGap(21))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(248, 248, 255));
		horizontalBox_1.add(panel_1);
		
		JLabel lblSearch_1 = new JLabel("Search Student");
		lblSearch_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel lblTKhaCn_1 = new JLabel("Từ khóa cần tìm");
		lblTKhaCn_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_msv_timKiem = new JTextField();
		textField_msv_timKiem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_msv_timKiem.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("*Nhập từ khóa bạn cần tìm");
		lblNewLabel_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBackground(new Color(245, 255, 250));
		
		JButton btn_TimMaSV = new JButton("Tìm");
		btn_TimMaSV.addActionListener(ac_sv);
		btn_TimMaSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/searchBook.png")));
		btn_TimMaSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_huyTim_maSV = new JButton("Hủy");
		btn_huyTim_maSV.addActionListener(ac_sv);
		btn_huyTim_maSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/resetSearch.png")));
		btn_huyTim_maSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_themSV = new JButton("Thêm");
		btn_themSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/addSV.png")));
		btn_themSV.addActionListener(ac_sv);
		btn_themSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_xoaSV = new JButton("Xóa");
		btn_xoaSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/deleteSV.png")));
		btn_xoaSV.addActionListener(ac_sv);
		btn_xoaSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_updateSV = new JButton("Sửa");
		btn_updateSV.addActionListener(ac_sv);
		btn_updateSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/updateSV.png")));
		btn_updateSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_luuSV = new JButton("Lưu");
		btn_luuSV.addActionListener(ac_sv);
		btn_luuSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/SaveSV.png")));
		btn_luuSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_resetSV = new JButton("Reset");
		btn_resetSV.addActionListener(ac_sv);
		btn_resetSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/return.png")));
		btn_resetSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_thoat_QLSV = new JButton("Thoát chương trình");
		btn_thoat_QLSV.addActionListener(ac_sv);
		btn_thoat_QLSV.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		btn_thoat_QLSV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTKhaCn_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(btn_TimMaSV, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(btn_huyTim_maSV, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
											.addGap(18))
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
									.addGap(9))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(textField_msv_timKiem, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
									.addGap(10))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_themSV, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_xoaSV, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_updateSV, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_luuSV, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btn_resetSV, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_thoat_QLSV, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
							.addGap(9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(146)
							.addComponent(lblSearch_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearch_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTKhaCn_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_msv_timKiem, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(15)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_TimMaSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_huyTim_maSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_themSV, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_xoaSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_updateSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_luuSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_resetSV, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
						.addComponent(btn_thoat_QLSV, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(47))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(null);
		horizontalBox.add(panel);
		
		JLabel label_maSv = new JLabel("Mã sinh viên");
		label_maSv.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_maSV = new JTextField();
		textField_maSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_maSV.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("*Mã sinh viên không được trùng lặp");
		lblNewLabel_1_2.setForeground(Color.RED);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBackground(new Color(245, 255, 250));
		
		JLabel label_hoVaTenSV = new JLabel("Họ và tên");
		label_hoVaTenSV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_hoVaTenSV = new JTextField();
		textField_hoVaTenSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_hoVaTenSV.setColumns(10);
		
		JLabel label_queQuanSV = new JLabel("Quê quán");
		label_queQuanSV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		comboBox_queQuanSV = new JComboBox<String>();
		comboBox_queQuanSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox_queQuanSV.addItem("");
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		for (Tinh tinh : listTinh) {
			comboBox_queQuanSV.addItem(tinh.getTenTinh());
		}
		
		JLabel label_ngaySinhSV = new JLabel("Ngày sinh");
		label_ngaySinhSV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		JLabel lblNewLabel_1_2_1 = new JLabel("*YYYY/MM/DD");
		lblNewLabel_1_2_1.setForeground(Color.RED);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBackground(new Color(245, 255, 250));
		
		JLabel lblLpKha = new JLabel("Lớp - Khóa");
		lblLpKha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_lopKhoa = new JTextField();
		textField_lopKhoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_lopKhoa.setColumns(10);
		
		JLabel label_email = new JLabel("Email");
		label_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_EmailSV = new JTextField();
		textField_EmailSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_EmailSV.setColumns(10);
		
		JLabel label_Sdt = new JLabel("Số điện thoại");
		label_Sdt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_SdtSV = new JTextField();
		textField_SdtSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_SdtSV.setColumns(10);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("*Sđt phải đủ 10 số và bắt dầu bằng 0");
		lblNewLabel_1_2_2.setForeground(Color.RED);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_2.setBackground(new Color(245, 255, 250));
		
		textField_ngaySinhSV = new JDateChooser();
		textField_ngaySinhSV.setFont(font);
		textField_ngaySinhSV.setDateFormatString("yyyy-MM-dd");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_queQuanSV, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_hoVaTenSV, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_ngaySinhSV, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLpKha, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_email, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(textField_EmailSV, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
									.addGap(67))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField_lopKhoa, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
										.addComponent(textField_ngaySinhSV, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_1_2_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
									.addGap(67))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(comboBox_queQuanSV, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_hoVaTenSV, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
									.addGap(67))
								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(label_Sdt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(label_maSv, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_maSV, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(textField_SdtSV, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
							.addGap(67)))
					.addGap(22))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(115)
					.addComponent(lblNewLabel_1_2_2, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_maSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_maSv, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_hoVaTenSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_hoVaTenSV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_queQuanSV, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_queQuanSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_ngaySinhSV, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_ngaySinhSV, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_2_1)
					.addGap(2)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLpKha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_lopKhoa, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_email, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_EmailSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_Sdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_SdtSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_2_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		

		table_QLSV = new JTable();
		new SinhVienDao().getListSV(model_SV);
		model = (DefaultTableModel) table_QLSV.getModel();
		model.setColumnIdentifiers(new Object[] {
				"Mã sinh viên", "Họ và tên", "Quê quán", "Ngày sinh", "Lớp-Khóa", "Email", "Số điện thoại"	
		});
		table_QLSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JTableHeader header_QLSV =  table_QLSV.getTableHeader();
		header_QLSV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_QLSV.setRowHeight(25);
		
		scrollPane_1.setViewportView(table_QLSV);
		panel_QLSinhVien.setLayout(gl_panel_QLSinhVien);
		showTable_SV();
		
		
		
		
		// Quản lí Phiếu Mượn
		
		ActionListener ac_pm = new QLPhieuMuon_controller(this);
		
		JPanel panel_QLPhieuMuon = new JPanel();
		panel_QLPhieuMuon.setBackground(new Color(248,248,255));
		tabbedPane.addTab("Quản lí Phiếu mượn", null, panel_QLPhieuMuon, null);
		
		JPanel panel_3 = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Danh Sách Phiếu Mượn");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin Phiếu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		horizontalBox_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Box horizontalBox_3_1 = Box.createHorizontalBox();
		horizontalBox_3_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JLabel lblNewLabel_2_1 = new JLabel("Chức năng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		GroupLayout gl_panel_QLPhieuMuon = new GroupLayout(panel_QLPhieuMuon);
		gl_panel_QLPhieuMuon.setHorizontalGroup(
			gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
					.addGap(0))
				.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(578, Short.MAX_VALUE))
				.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
					.addGap(9)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING)
						.addComponent(horizontalBox_3, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_3_1, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_QLPhieuMuon.setVerticalGroup(
			gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_QLPhieuMuon.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
							.addComponent(horizontalBox_3, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE))
						.addGroup(gl_panel_QLPhieuMuon.createSequentialGroup()
							.addComponent(horizontalBox_3_1, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
					.addGap(30))
		);
		
		Panel panel_7 = new Panel();
		horizontalBox_3_1.add(panel_7);
		
		JLabel lblSearch_1_1 = new JLabel("Search Function");
		lblSearch_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JLabel label_mts_1_1_1 = new JLabel("Mã PM cần tìm");
		label_mts_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("*Nhập mã phiếu cần tìm");
		lblNewLabel_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBackground(new Color(245, 255, 250));
		
		JButton btn_TimMaPhieu = new JButton("Tìm");
		btn_TimMaPhieu.addActionListener(ac_pm);
		btn_TimMaPhieu.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/searchBook.png")));
		btn_TimMaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_huyTim_maPhieu = new JButton("Hủy");
		btn_huyTim_maPhieu.addActionListener(ac_pm);
		btn_huyTim_maPhieu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel label_mts_1_1_1_1 = new JLabel("Tổng sách mượn");
		label_mts_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_tongSachMuon = new JTextField();
		textField_tongSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_tongSachMuon.setColumns(10);
		
		JButton btn_tinhTongSachMuon = new JButton("Sum");
		btn_tinhTongSachMuon.addActionListener(ac_pm);
		btn_tinhTongSachMuon.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/Calculate.png")));
		btn_tinhTongSachMuon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		textField_tim_MaPhieu = new JTextField();
		textField_tim_MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_tim_MaPhieu.setColumns(10);
		
		JButton btn_themPM = new JButton("Thêm");
		btn_themPM.addActionListener(ac_pm);
		btn_themPM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/addPhieuMuon.png")));
		btn_themPM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_xoaPM = new JButton("Xóa");
		btn_xoaPM.addActionListener(ac_pm);
		btn_xoaPM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/deletePM.png")));
		btn_xoaPM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_updatePM = new JButton("Sửa");
		btn_updatePM.addActionListener(ac_pm);
		btn_updatePM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/updatePM.png")));
		btn_updatePM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_luuPM = new JButton("Lưu");
		btn_luuPM.addActionListener(ac_pm);
		btn_luuPM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/save.png")));
		btn_luuPM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_resetPM = new JButton("Reset");
		btn_resetPM.addActionListener(ac_pm);
		btn_resetPM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/refresh.png")));
		btn_resetPM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btn_thoat_QLPM = new JButton("Thoát chương trình");
		btn_thoat_QLPM.addActionListener(ac_pm);
		btn_thoat_QLPM.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		btn_thoat_QLPM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(121)
							.addComponent(lblSearch_1_1, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addContainerGap()
							.addComponent(label_mts_1_1_1)
							.addGap(22)
							.addComponent(textField_tim_MaPhieu, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btn_TimMaPhieu, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(142)
							.addComponent(lblNewLabel_1_1_1_1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btn_huyTim_maPhieu, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addGap(0))
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(btn_themPM, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_xoaPM, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_updatePM, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_luuPM, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addGap(15))
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(label_mts_1_1_1_1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_resetPM, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(textField_tongSachMuon, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
							.addGap(12)
							.addComponent(btn_tinhTongSachMuon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addComponent(btn_thoat_QLPM, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addComponent(lblSearch_1_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(7)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_mts_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_TimMaPhieu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField_tim_MaPhieu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_huyTim_maPhieu, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(58)
							.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
								.addComponent(btn_themPM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_xoaPM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_updatePM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_luuPM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))))
					.addGap(16)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_mts_1_1_1_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_tongSachMuon, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_tinhTongSachMuon, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_resetPM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_thoat_QLPM, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		
		Panel panel_4 = new Panel();
		horizontalBox_3.add(panel_4);
		
		JLabel lblMPhiu = new JLabel("Mã phiếu");
		lblMPhiu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_maPhieu = new JTextField();
		textField_maPhieu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_maPhieu.setColumns(10);
		
		JLabel label_maSv_1_1 = new JLabel("Mã sinh viên");
		label_maSv_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel label_ngaySinhSV_1 = new JLabel("Ngày mượn");
		label_ngaySinhSV_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_ngayMuon = new JDateChooser();
		textField_ngayMuon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_ngayMuon.setDateFormatString("yyyy-MM-dd");
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("*YYYY/MM/DD");
		lblNewLabel_1_2_1_1.setForeground(Color.RED);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBackground(new Color(245, 255, 250));
		
		JLabel label_maSach_1 = new JLabel("Mã sách");
		label_maSach_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel label_soLuongCon_1 = new JLabel("Số lượng ");
		label_soLuongCon_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_soLuongMuon = new JTextField();
		textField_soLuongMuon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField_soLuongMuon.setColumns(10);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("*x thuộc N");
		lblNewLabel_1_3_1_1.setForeground(Color.RED);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1.setBackground(new Color(245, 255, 250));
		
		
		// Tạo danh sách dữ liệu
		ArrayList<Integer> dataList = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
			// Tạo kết nối đến cơ sở dữ liệu
			Connection conn = DriverManager.getConnection(url, username, password);

			// Truy vấn dữ liệu từ bảng Sinh viên bằng PrepareStatement
			String sql = "SELECT maSV FROM sinhvien";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			dataList = new ArrayList<Integer>();
			while (rs.next()) {
			    int maSinhVien = rs.getInt("maSV");
			    dataList.add(maSinhVien);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		comboBox_maSV = new JComboBox<Integer>();
		comboBox_maSV.addItem(null);
		for (int data : dataList) {
			comboBox_maSV.addItem(data);
		}
		comboBox_maSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		

		// Tạo danh sách dữ liệu
		ArrayList<Integer> data_maSach = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
			// Tạo kết nối đến cơ sở dữ liệu
			Connection conn = DriverManager.getConnection(url, username, password);

			// Truy vấn dữ liệu từ bảng Sinh viên bằng PrepareStatement
			String sql = "SELECT maSach FROM sach";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			data_maSach = new ArrayList<Integer>();
			while (rs.next()) {
			    int maSach = rs.getInt(1);
			    data_maSach.add(maSach);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		comboBox_maSach = new JComboBox<Integer>();
		comboBox_maSach.addItem(null);
		for (int data : data_maSach) {
			comboBox_maSach.addItem(data);
		}
		comboBox_maSach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		

		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(lblMPhiu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField_maPhieu, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(label_maSv_1_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comboBox_maSV, 0, 169, Short.MAX_VALUE)
								.addGap(7))
							.addGroup(gl_panel_4.createSequentialGroup()
								.addComponent(label_ngaySinhSV_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblNewLabel_1_3_1_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_soLuongMuon, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
										.addComponent(textField_ngayMuon, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel_4.createSequentialGroup()
										.addComponent(comboBox_maSach, 0, 169, Short.MAX_VALUE)
										.addGap(7)))))
						.addComponent(label_maSach_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_soLuongCon_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addGap(98))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_maPhieu, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMPhiu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_maSv_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_maSV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_ngayMuon, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_ngaySinhSV_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1_2_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_maSach_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_maSach, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(label_soLuongCon_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addComponent(textField_soLuongMuon, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_1_3_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		table_QLPM = new JTable();
		table_QLPM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		new PhieuMuonDao().getListPM(model_PM);
		model2 = (DefaultTableModel) table_QLPM.getModel();
		model2.setColumnIdentifiers(new Object[] {
			"Mã phiếu", "Mã sinh viên", "Ngày mượn", "Mã sách", "Số lượng"	
		});
		JTableHeader header_PM = table_QLPM.getTableHeader();
		header_PM.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table_QLPM.setRowHeight(25);
		scrollPane_2.setViewportView(table_QLPM);
		panel_QLPhieuMuon.setLayout(gl_panel_QLPhieuMuon);
		showTablePM();
		
					
		JMenuBar menuBar_2 = new JMenuBar();
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar_2.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Open");
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_4.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Save");
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_5.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/SaveSV.png")));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_6.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenu mnNewMenu_1 = new JMenu("Project");
		mnNewMenu_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar_2.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("New Project");
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_7.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Open Project");
		mntmNewMenuItem_8.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_8.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/newProject.png")));
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_1.add(separator_4);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Properties");
		mntmNewMenuItem_9.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_1.add(mntmNewMenuItem_9);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar_2, GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
		);
		panel_3.setLayout(gl_panel_3);
		panel_QLPhieuMuon.setLayout(gl_panel_QLPhieuMuon);
		
		JPanel panel_ThongKe = new JPanel();
		panel_ThongKe.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Thông tin đăng nhập", null, panel_ThongKe, null);
		
		JPanel panel_8 = new JPanel();
		
		JPanel panel_9 = new JPanel();
		
		JPanel panel_10 = new JPanel();
		GroupLayout gl_panel_ThongKe = new GroupLayout(panel_ThongKe);
		gl_panel_ThongKe.setHorizontalGroup(
			gl_panel_ThongKe.createParallelGroup(Alignment.TRAILING)
				.addComponent(panel_8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
				.addGroup(Alignment.LEADING, gl_panel_ThongKe.createSequentialGroup()
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
		);
		gl_panel_ThongKe.setVerticalGroup(
			gl_panel_ThongKe.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_ThongKe.createSequentialGroup()
					.addComponent(panel_8, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_ThongKe.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_10, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
						.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)))
		);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		GroupLayout gl_panel_10 = new GroupLayout(panel_10);
		gl_panel_10.setHorizontalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_10.createSequentialGroup()
					.addGap(187)
					.addComponent(horizontalBox_6, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(202))
				.addGroup(Alignment.TRAILING, gl_panel_10.createSequentialGroup()
					.addGap(43)
					.addComponent(horizontalBox_7, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addGap(40))
		);
		gl_panel_10.setVerticalGroup(
			gl_panel_10.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_10.createSequentialGroup()
					.addGap(39)
					.addComponent(horizontalBox_6, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(horizontalBox_7, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
					.addGap(42))
		);
		
		JPanel panel_12 = new JPanel();
		horizontalBox_7.add(panel_12);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Tên");
		lblNewLabel_4_1_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_Ten2 = new JTextField();
		textField_Ten2.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Email");
		lblNewLabel_4_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_Email2 = new JTextField();
		textField_Email2.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_2 = new JLabel("SĐT");
		lblNewLabel_4_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_SDT2 = new JTextField();
		textField_SDT2.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_3 = new JLabel("Mật Khẩu Mới");
		lblNewLabel_4_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_4 = new JLabel("Mật Khẩu");
		lblNewLabel_4_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		ActionListener ec = new ThongTin_controller(this);
		JButton btnCpNht_Update = new JButton("Cập Nhật");

		btnCpNht_Update.addActionListener(ec);
		btnCpNht_Update.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panel_12 = new GroupLayout(panel_12);
		gl_panel_12.setHorizontalGroup(
			gl_panel_12.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_panel_12.createSequentialGroup()
							.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_4_1_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4_1_2_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4_1_2_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addGap(67))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGroup(gl_panel_12.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_4_1_2_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4_1_2_4, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_Email2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(textField_Ten2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(textField_SDT2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
						.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
					.addGap(31))
				.addGroup(gl_panel_12.createSequentialGroup()
					.addContainerGap(253, Short.MAX_VALUE)
					.addComponent(btnCpNht_Update)
					.addGap(40))
		);
		gl_panel_12.setVerticalGroup(
			gl_panel_12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_12.createSequentialGroup()
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel_4_1_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(26)
							.addComponent(textField_Ten2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_4_1_2_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(32)
							.addComponent(textField_Email2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_4_1_2_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(32)
							.addComponent(textField_SDT2, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
					.addGroup(gl_panel_12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(33)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(36)
							.addComponent(lblNewLabel_4_1_2_3, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(gl_panel_12.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_panel_12.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
						.addComponent(lblNewLabel_4_1_2_4, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(69)
					.addComponent(btnCpNht_Update, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_12.setLayout(gl_panel_12);
		
		JLabel lblNewLabel_5 = new JLabel("Cập Nhật");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_6.add(lblNewLabel_5);
		panel_10.setLayout(gl_panel_10);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		
		Box horizontalBox_8 = Box.createHorizontalBox();
		horizontalBox_8.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panel_9 = new GroupLayout(panel_9);
		gl_panel_9.setHorizontalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(30)
					.addComponent(horizontalBox_5, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
					.addGap(25))
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(70)
					.addComponent(horizontalBox_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(74))
				.addGroup(Alignment.TRAILING, gl_panel_9.createSequentialGroup()
					.addGap(99)
					.addComponent(horizontalBox_8, GroupLayout.PREFERRED_SIZE, 141, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_panel_9.setVerticalGroup(
			gl_panel_9.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_9.createSequentialGroup()
					.addGap(33)
					.addComponent(horizontalBox_4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(horizontalBox_8, GroupLayout.PREFERRED_SIZE, 151, Short.MAX_VALUE)
					.addGap(31)
					.addComponent(horizontalBox_5, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
		);
		
		JPanel panel_13 = new JPanel();
		horizontalBox_8.add(panel_13);
		
		JLabel lblNewLabel_6 = new JLabel("Ảnh Đại Diện");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_panel_13 = new GroupLayout(panel_13);
		gl_panel_13.setHorizontalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(40)
					.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
					.addGap(32))
		);
		gl_panel_13.setVerticalGroup(
			gl_panel_13.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_13.createSequentialGroup()
					.addGap(66)
					.addComponent(lblNewLabel_6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(60))
		);
		panel_13.setLayout(gl_panel_13);
		
		JPanel panel_11 = new JPanel();
		horizontalBox_5.add(panel_11);
		
		JLabel lblNewLabel_name = new JLabel("Tên");
		lblNewLabel_name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_email = new JLabel("Email");
		lblNewLabel_email.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel lblNewLabel_SDT = new JLabel("SĐT");
		lblNewLabel_SDT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
	//	ActionListener ec = new ThongTin_controller(this);
		
		JButton btnNewButton_updateTK = new JButton("Cập Nhật Tài Khoản");
		btnNewButton_updateTK.addActionListener(ec);

		btnNewButton_updateTK.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel Label_name1 = new JLabel("");
		Label_name1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel Label_email1 = new JLabel("");
		Label_email1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JLabel Label_SDT1 = new JLabel("");
		Label_SDT1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_panel_11 = new GroupLayout(panel_11);
		gl_panel_11.setHorizontalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addGroup(gl_panel_11.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_11.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_name, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addGap(31)
							.addComponent(Label_name1, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
							.addGap(19))
						.addGroup(gl_panel_11.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_11.createSequentialGroup()
									.addComponent(lblNewLabel_email, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(30))
								.addComponent(lblNewLabel_SDT, GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
							.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel_11.createSequentialGroup()
									.addGap(18)
									.addComponent(btnNewButton_updateTK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel_11.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
										.addComponent(Label_SDT1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
										.addComponent(Label_email1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
									.addGap(28)))))
					.addContainerGap())
		);
		gl_panel_11.setVerticalGroup(
			gl_panel_11.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_11.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_name, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_11.createSequentialGroup()
							.addGap(2)
							.addComponent(Label_name1, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
					.addGap(21)
					.addGroup(gl_panel_11.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_11.createSequentialGroup()
							.addComponent(lblNewLabel_email, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(lblNewLabel_SDT, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_11.createSequentialGroup()
							.addComponent(Label_email1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(25)
							.addComponent(Label_SDT1, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)))
					.addGap(55)
					.addComponent(btnNewButton_updateTK, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_11.setLayout(gl_panel_11);
		
		JLabel lblNewLabel_3 = new JLabel("Thông Tin Tài Khoản");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		horizontalBox_4.add(lblNewLabel_3);
		panel_9.setLayout(gl_panel_9);
		
		JMenuBar menuBar_3 = new JMenuBar();
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addComponent(menuBar_3, GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_8.createSequentialGroup()
					.addComponent(menuBar_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenu mnNewMenu_2 = new JMenu("File");
		mnNewMenu_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar_3.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Open");
		mntmNewMenuItem_10.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_10.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mnNewMenu_2.add(mntmNewMenuItem_10);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Save");
		mntmNewMenuItem_11.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_11.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/SaveSV.png")));
		mnNewMenu_2.add(mntmNewMenuItem_11);
		
		JSeparator separator_5 = new JSeparator();
		mnNewMenu_2.add(separator_5);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Exit");
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_12.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/exit.png")));
		mnNewMenu_2.add(mntmNewMenuItem_12);
		
		JMenu mnNewMenu_3 = new JMenu("Project");
		mnNewMenu_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		menuBar_3.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("New Project");
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_13.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/newProject.png")));
		mnNewMenu_3.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Open Project");
		mntmNewMenuItem_14.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mntmNewMenuItem_14.setIcon(new ImageIcon(QLTV_View.class.getResource("/Image/open.png")));
		mnNewMenu_3.add(mntmNewMenuItem_14);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_3.add(separator_6);
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Properties");
		mntmNewMenuItem_15.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		mnNewMenu_3.add(mntmNewMenuItem_15);
		panel_8.setLayout(gl_panel_8);
		panel_ThongKe.setLayout(gl_panel_ThongKe);
		
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}

	
	private void showTable_SV() {
		for(SinhVien sv : this.model_SV.getDsSinhVien()) {
			model.addRow( new Object[] {
				sv.getMaSV(), sv.getHoVaTen(), sv.getQueQuan(), sv.getNgaySinh(), sv.getLopKhoa(), sv.getEmail(), sv.getsDT()
			});
		}
		
	}

	private void showTable_Sach() {
		for (Sach s : this.model_Sach.getDsSach()) {
			model.addRow(new Object[] {
				s.getMaSach(),s.getTenSach(),s.getTagGia(),s.getTheLoai(),s.getNamXB(),s.getSoLuongCon()
			});
		}
	}
	
	private void showTablePM() {
		for (PhieuMuon pm : this.model_PM.getDsPhieuMuon()) {
			model2.addRow(new Object[] {
					pm.getMaPhieu(), pm.getMaSV(), pm.getNgayMuon(), pm.getMaSach(), pm.getSoLuong()
			});
		}
		
	}

	// SÁCH

		public void xoaFormSach() {
			executorService.execute(() ->{
				textField_idSach.setText("");
				textField_tenSach.setText("");
				textField_tacGia.setText("");
				textField_theLoai.setText("");
				textField_namXB.setText("");
				textField_soLuongCon.setText(""); 
			  }
			);
			
		}

		public void thoatChuongTrinh() {
			executorService.execute(() ->{
				int lc = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát chương trình");	
				if(lc == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			  }
			);		
		}
		
		// Button Thêm
		public void thucHienThemSach() {
			int maSach = Integer.valueOf(this.textField_idSach.getText());
			String tenSach = this.textField_tenSach.getText();
			String tacGia = this.textField_tacGia.getText();
			String theLoai = this.textField_theLoai.getText();
			int namXB = Integer.valueOf(this.textField_namXB.getText());
			int soLuongCon = Integer.valueOf(this.textField_soLuongCon.getText());
			
			Sach s = new Sach(maSach, tenSach, tacGia, theLoai, namXB, soLuongCon);
			this.themSach(s);
			
		}
		public void themSachVaoTable(Sach s) {
			DefaultTableModel model_table_sach = (DefaultTableModel) table_QLSach.getModel();
			model_table_sach.addRow(new Object[] {
					s.getMaSach()+"",
					s.getTenSach(),
					s.getTagGia(),
					s.getTheLoai(),
					s.getNamXB()+"",
					s.getSoLuongCon()+""
			});
		}

		public void themSach(Sach s) {
			if(!this.model_Sach.kiemTraTonTaiSach(s)) {
				this.model_Sach.insert(s);
				this.themSachVaoTable(s);
				if(new SachDAO().addSach(s)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công !");
					int maSach = s.getMaSach();
					this.comboBox_maSach.addItem(maSach);
					return;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Mã sách này đã tồn tại !");
				textField_idSach.setText("");
				return;
				
			}
			
		}
		

		// Button Lưu
		public void thucHienLuuSach() {
			int maSach = Integer.valueOf(this.textField_idSach.getText());
			String tenSach = this.textField_tenSach.getText();
			String tacGia = this.textField_tacGia.getText();
			String theLoai = this.textField_theLoai.getText();
			int namXB = Integer.valueOf(this.textField_namXB.getText());
			int soLuongCon = Integer.valueOf(this.textField_soLuongCon.getText());
			
			Sach s = new Sach(maSach, tenSach, tacGia, theLoai, namXB, soLuongCon);
			this.luuSach(s);
			
		}
		public void luuSach(Sach s) {
				DefaultTableModel model_table_sach = (DefaultTableModel) table_QLSach.getModel();
				this.model_Sach.update(s);
				int soLuongDong = model_table_sach.getRowCount();
				for(int i=0;i<soLuongDong;i++) {
					String maSach = model_table_sach.getValueAt(i, 0)+"";
					if(maSach.equals(s.getMaSach()+"")) {
						model_table_sach.setValueAt(s.getMaSach()+"", i, 0);
						model_table_sach.setValueAt(s.getTenSach()+"", i, 1);
						model_table_sach.setValueAt(s.getTagGia()+"", i, 2);
						model_table_sach.setValueAt(s.getTheLoai()+"", i, 3);
						model_table_sach.setValueAt(s.getNamXB()+"", i, 4);
						model_table_sach.setValueAt(s.getSoLuongCon()+"", i, 5);
					}
				}
				if(new SachDAO().updateSach(s)) {
					JOptionPane.showMessageDialog(this, "Cập nhật sách thành công !");
					return;
				}
				
				
			}
		
		
		public Sach getSachDangChon() {
			DefaultTableModel model_table_Sach = (DefaultTableModel) table_QLSach.getModel();
			int i_row = table_QLSach.getSelectedRow();
			
			int maSach = Integer.valueOf(model_table_Sach.getValueAt(i_row, 0)+"");
			String tenSach = table_QLSach.getValueAt(i_row, 1)+"";
			String tacGia = table_QLSach.getValueAt(i_row, 2)+"";
			String theLoai = table_QLSach.getValueAt(i_row, 3)+"";
			int namXB = Integer.valueOf(model_table_Sach.getValueAt(i_row, 4)+"");
			int soLuongCon = Integer.valueOf(model_table_Sach.getValueAt(i_row, 5)+"");
			
			
			Sach s = new Sach(maSach, tenSach, tacGia, theLoai, namXB, soLuongCon);
			return s;
		}
		
		public void hienThiThongTinSachDaChon() {
			// get dữ liệu
			Sach s = getSachDangChon();
			
			this.textField_idSach.setText(s.getMaSach()+"");
			this.textField_tenSach.setText(s.getTenSach());
			this.textField_tacGia.setText(s.getTagGia());
			this.textField_theLoai.setText(s.getTheLoai());
			this.textField_namXB.setText(s.getNamXB()+"");
			this.textField_soLuongCon.setText(s.getSoLuongCon()+"");
			
		}

		// Button Xóa
		public void thucHienXoaSach() {
			DefaultTableModel model_table_Sach = (DefaultTableModel) table_QLSach.getModel();
			int i_row = table_QLSach.getSelectedRow();
		
			int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dòng đã chọn ?");
			if(luaChon == JOptionPane.YES_OPTION) {
				Sach s = getSachDangChon();
				if(new SachDAO().deleteSach(s)) {
					JOptionPane.showMessageDialog(this, "Delete Success !");
					this.model_Sach.delete(s);
					model_table_Sach.removeRow(i_row);
					int maSach = s.getMaSach();
					this.comboBox_maSach.removeItem(maSach);
					return;
				} else {
					JOptionPane.showMessageDialog(this, "Delete false !");
					return;
				}
			}
		}
		
		
//		public void timSach() {
//		    int maSachCanTim = Integer.parseInt(this.textField_maSach_Tim.getText());
//		    DefaultTableModel model_table_Sach = (DefaultTableModel) table_QLSach.getModel();
//		    Sach sach = new SachDAO().selectByid(maSachCanTim);
//		    if (sach != null) {
//		    	JOptionPane.showMessageDialog(null, "Found !");
//		    	model_table_Sach.setColumnCount(6); // Cập nhật số lượng cột
//		        model_table_Sach.setRowCount(0); 
//		        model_table_Sach.addRow(new Object[] {
//		            sach.getMaSach(), sach.getTenSach(), sach.getTagGia(), sach.getTheLoai(), sach.getNamXB(), sach.getSoLuongCon()
//		        });
//		    } else {
//		        JOptionPane.showMessageDialog(this, "Không tìm thấy sách có mã " + maSachCanTim);
//		    }
//		}

		public void timSach() {
	    String keyword = this.textField_TuKhoaSach_Tim.getText();
	    DefaultTableModel model_table_Sach = (DefaultTableModel) table_QLSach.getModel();
	    ArrayList<Sach> sachCanTim = new SachDAO().selectByKeyword(keyword);
	    if (!sachCanTim.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Found !");
	        model_table_Sach.setColumnCount(6); // Cập nhật số lượng cột
	        model_table_Sach.setRowCount(0);
	        for (Sach sach : sachCanTim) {
	            model_table_Sach.addRow(new Object[] {
	                sach.getMaSach(), sach.getTenSach(), sach.getTagGia(), sach.getTheLoai(), sach.getNamXB(), sach.getSoLuongCon()
	            });
	        }
	    } else {
	        JOptionPane.showMessageDialog(this, "Không tìm thấy sách phù hợp cho từ khóa: " + keyword);
	    }
	}

		

		
		
		public void huyTimSach() {
			DefaultTableModel model_table_Sach = (DefaultTableModel) table_QLSach.getModel();
			while(true) {
				int soLuongDong = model_table_Sach.getRowCount();
				if(soLuongDong == 0) {
					break;
				} else {
					model_table_Sach.removeRow(0);
				}
			}
			for (Sach s : this.model_Sach.getDsSach()) {
				model_table_Sach.addRow(new Object[] {
						s.getMaSach(),s.getTenSach(),s.getTagGia(),s.getTheLoai(),s.getNamXB(),s.getSoLuongCon()
					});
			}
			
		}

		public void saveFile(String path) {
			try {
				this.model_Sach.setTenFile(path);
				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for (Sach s : this.model_Sach.getDsSach()) {
					oos.writeObject(s);
				}
				oos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void thucHienSave() {
			if(this.model_Sach.getTenFile().length()>0) {
				saveFile(this.model_Sach.getTenFile());
			}else {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showSaveDialog(this);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fc.getSelectedFile();
					saveFile(file.getAbsolutePath());
				}
			}		
		}
		
		
		public void openFile(File file) {
			ArrayList<Sach> ds = new ArrayList<Sach>();
			try {
				this.model_Sach.setTenFile(file.getAbsolutePath());
				FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Sach s = null;
				while((s = (Sach) ois.readObject())!=null) {
					ds.add(s);
				}
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			 catch (Exception e) {
				 System.out.println(e.getMessage());
				e.printStackTrace();
			}
			this.model_Sach.setDsSach(ds);
		}

		public void thucHienOpen() {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				openFile(file);
				huyTimSach();
		}
			
		}

		

		
		
		// CHỨC NĂNG SINH VIÊN
		
		
		public void xoaForm_SV() {
			this.textField_maSV.setText("");
			this.textField_hoVaTenSV.setText("");
			this.comboBox_queQuanSV.setSelectedIndex(-1);
			this.textField_ngaySinhSV.setDate(null);
			this.textField_lopKhoa.setText("");
			this.textField_EmailSV.setText("");
			this.textField_SdtSV.setText("");		
		}
		
		public void thoat_QLSV() {
			int lc = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát chương trình ?");
			if(lc == JOptionPane.YES_OPTION) {
				System.exit(0);
				return;
			}
		}

		public void thucHienThemSinhVien(){
			int maSV = Integer.parseInt(this.textField_maSV.getText()) ;
			String hoVaTen = this.textField_hoVaTenSV.getText();
			String queQuan = (String) this.comboBox_queQuanSV.getSelectedItem();					
			java.sql.Date ngaySinh = new java.sql.Date(textField_ngaySinhSV.getDate().getTime());			
			String lopKhoa = this.textField_lopKhoa.getText();
			String email = this.textField_EmailSV.getText();
			String sDT = this.textField_SdtSV.getText();
			
			SinhVien sv = new SinhVien(maSV, hoVaTen, queQuan, ngaySinh, lopKhoa, email, sDT);
			
			this.themSV(sv);		
		}
		
		public void themSVvaoTable(SinhVien sv) {
			DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
			model_table_SV.addRow(new Object[] {
				sv.getMaSV()+"", 
				sv.getHoVaTen(), 
				sv.getQueQuan(), 
				sv.getNgaySinh(), 
				sv.getLopKhoa(), 
				sv.getEmail(), 
				sv.getsDT()
			});
		}
		
		public void themSV(SinhVien sv) {
			if(!this.model_SV.kiemTraTonTaiSV(sv)) {
				this.model_SV.insert(sv);
				this.themSVvaoTable(sv);
				if(new SinhVienDao().addSV(sv)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công !");
					int maSV = sv.getMaSV();
					this.comboBox_maSV.addItem(maSV);
					return;
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "Mã sinh viên này đã tồn tại !");
				this.textField_maSV.setText("");
				return;
			}
		}
		
		public void thucHienLuuSinhVien() {
			int maSV = Integer.parseInt(this.textField_maSV.getText()) ;
			String hoVaTen = this.textField_hoVaTenSV.getText();
			String queQuan = (String) this.comboBox_queQuanSV.getSelectedItem();					
			java.sql.Date ngaySinh = new java.sql.Date(textField_ngaySinhSV.getDate().getTime());			
			String lopKhoa = this.textField_lopKhoa.getText();
			String email = this.textField_EmailSV.getText();
			String sDT = this.textField_SdtSV.getText();
			
			SinhVien sv = new SinhVien(maSV, hoVaTen, queQuan, ngaySinh, lopKhoa, email, sDT);
			
			this.luuSV(sv);	
			
		}


		public void luuSV(SinhVien sv) {
			DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
			this.model_SV.update(sv);
			int soLuongDong = model_table_SV.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String maSV = model_table_SV.getValueAt(i, 0)+"";
				if(maSV.equals(sv.getMaSV()+"")) {
					model_table_SV.setValueAt(sv.getMaSV()+"", i, 0);
					model_table_SV.setValueAt(sv.getHoVaTen()+"", i, 1);
					model_table_SV.setValueAt(sv.getQueQuan()+"", i, 2);
					model_table_SV.setValueAt(sv.getNgaySinh()+"", i, 3);
					model_table_SV.setValueAt(sv.getLopKhoa()+"", i, 4);
					model_table_SV.setValueAt(sv.getEmail()+"", i, 5);
					model_table_SV.setValueAt(sv.getsDT()+"",i, 6);
				}
				
			}
			if(new SinhVienDao().updateSV(sv)) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
				return;
			}

		}

		public void thucHienXoaSV() {
			DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
			int i_row = table_QLSV.getSelectedRow();
			
			int lc = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa dòng đã chọn ?");
			if(lc == JOptionPane.YES_OPTION) {
				SinhVien sv = getSinhVienDangChon();
				
				if(new SinhVienDao().deteleSV(sv)) {
					JOptionPane.showMessageDialog(this, "Delete Success !");
					this.model_SV.delete(sv);
					model_table_SV.removeRow(i_row);
					int maSV = sv.getMaSV();
					this.comboBox_maSV.removeItem(maSV);
					return;
				} else {
					JOptionPane.showMessageDialog(this, "Delete false !");
					return;
				}
			}
		}

		public SinhVien getSinhVienDangChon(){
			DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
			int i_row = table_QLSV.getSelectedRow();
			
			int maSV = Integer.valueOf(model_table_SV.getValueAt(i_row,0)+"");
			String hoVaTen = model_table_SV.getValueAt(i_row, 1)+""; 
			String queQuan = model_table_SV.getValueAt(i_row, 2)+"";
			
			String s_ngaySinh = model_table_SV.getValueAt(i_row, 3) + "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilNgaySinh = null;
		    try {
		        utilNgaySinh = dateFormat.parse(s_ngaySinh);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    java.sql.Date ngaySinh = new java.sql.Date(utilNgaySinh.getTime());
			
			String lopKhoa = model_table_SV.getValueAt(i_row, 4)+"";
			String email = model_table_SV.getValueAt(i_row, 5)+"";
			String sDT = model_table_SV.getValueAt(i_row, 6)+"";
			
			
			SinhVien sv = new SinhVien(maSV, hoVaTen, queQuan, ngaySinh, lopKhoa, email, sDT);
			return sv;
			 
		}
		
		public void hienThiThongtinSinhVienDaChon() {
			SinhVien sv = getSinhVienDangChon();
			
			this.textField_maSV.setText(sv.getMaSV()+"");
			this.textField_hoVaTenSV.setText(sv.getHoVaTen()+"");
			this.comboBox_queQuanSV.setSelectedItem(sv.getQueQuan());
			this.textField_ngaySinhSV.setDate(sv.getNgaySinh());
			this.textField_lopKhoa.setText(sv.getLopKhoa());
			this.textField_EmailSV.setText(sv.getEmail());
			this.textField_SdtSV.setText(sv.getsDT());
		}

//		public void thucHienTimSV() {
//			int maSvCanTim = Integer.parseInt(this.textField_msv_timKiem.getText());
//		    DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
//		    SinhVien sv = new SinhVienDao().selectByID_SV(maSvCanTim);
//		    if (sv != null) {
//		    	JOptionPane.showMessageDialog(null, "Found !");
//		    	model_table_SV.setColumnCount(6); // Cập nhật số lượng cột
//		    	model_table_SV.setRowCount(0); 
//		    	model_table_SV.addRow(new Object[] {
//		            sv.getMaSV(), sv.getHoVaTen(), sv.getQueQuan(),sv.getNgaySinh(), sv.getLopKhoa(), sv.getLopKhoa(), sv.getEmail(),sv.getsDT()
//		        });
//		    } else {
//		        JOptionPane.showMessageDialog(this, "Không tìm thấy sách có mã " + maSvCanTim);
//		    }
//			
//		}
		
		public void thucHienTimSV() {
			String maSvCanTim = this.textField_msv_timKiem.getText();
		    DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
		    ArrayList<SinhVien> dataSV = new SinhVienDao().selectByKeyword(maSvCanTim);
		    if (!maSvCanTim.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Found !");
		        model_table_SV.setColumnCount(7); // Cập nhật số lượng cột
		        model_table_SV.setRowCount(0);
		        for (SinhVien sv : dataSV) {
		        	model_table_SV.addRow(new Object[] {
		                sv.getMaSV(), sv.getHoVaTen(), sv.getQueQuan(), sv.getNgaySinh(), sv.getLopKhoa(), sv.getEmail(), sv.getsDT()
		            });
		        }
		    } else {
		        JOptionPane.showMessageDialog(this, "Không tìm thấy Sinh viên phù hợp cho từ khóa: " + maSvCanTim);
		    }
			
		}
		
		
		

		public void thucHienHuyTimSV() {
			DefaultTableModel model_table_SV = (DefaultTableModel) table_QLSV.getModel();
			while(true) {
				int soLuongDong = model_table_SV.getRowCount();
				if(soLuongDong == 0) {
					break;
				} else {
					model_table_SV.removeRow(0);
				}
			}
			for (SinhVien sv : this.model_SV.getDsSinhVien()) {
				model_table_SV.addRow(new Object[] {
						sv.getMaSV(), sv.getHoVaTen(), sv.getQueQuan(), sv.getNgaySinh(), sv.getLopKhoa(), sv.getEmail(), sv.getsDT()
					});
			}
			
		}

		
		
		
		// PHIẾU MƯỢN
		
		public void xoaForm_PM() {
			this.textField_maPhieu.setText("");
			this.comboBox_maSV.setSelectedIndex(-1);
			this.textField_ngayMuon.setDate(null);
			this.comboBox_maSach.setSelectedIndex(-1);
			this.textField_soLuongMuon.setText("");
			this.textField_tongSachMuon.setText("");	
		}
		
		
		public void thucHienThem_PM() {
			String maPhieu = this.textField_maPhieu.getText();
			int maSV = (int) this.comboBox_maSV.getSelectedItem();					
			java.sql.Date ngayMuon = new java.sql.Date(textField_ngayMuon.getDate().getTime());			
			int maSach = (int) this.comboBox_maSach.getSelectedItem();
			int soLuong = Integer.valueOf(this.textField_soLuongMuon.getText()) ;
			
			PhieuMuon pm = new PhieuMuon(maPhieu, maSV, ngayMuon, maSach, soLuong);
			
			this.themPM(pm);
			
		}

		public void themPMvaoTable(PhieuMuon pm) {
			DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
			model_table_PM.addRow(new Object[] {
				pm.getMaPhieu(), 
				pm.getMaSV()+"", 
				pm.getNgayMuon(), 
				pm.getMaSach()+"", 
				pm.getSoLuong()+"", 
			});
		}
		
		public void themPM(PhieuMuon pm) {
			if(!this.model_PM.kiemTraTonTai_PM(pm)) {
				this.model_PM.getDsPhieuMuon().add(pm);
				this.themPMvaoTable(pm);
				if(new PhieuMuonDao().addPM(pm)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công !");
					return;
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "Mã Phiếu mượn này đã tồn tại !");
				return;
			}
		}

		public void thucHienLuu_PM() {
			String maPhieu = this.textField_maPhieu.getText();
			int maSV = (int) this.comboBox_maSV.getSelectedItem();					
			java.sql.Date ngayMuon = new java.sql.Date(textField_ngayMuon.getDate().getTime());			
			int maSach = (int) this.comboBox_maSach.getSelectedItem();
			int soLuong = Integer.valueOf(this.textField_soLuongMuon.getText()) ;
			
			PhieuMuon pm = new PhieuMuon(maPhieu, maSV, ngayMuon, maSach, soLuong);
			
			this.luuPM(pm);
			
		}
		
		public void luuPM(PhieuMuon pm) {
			DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
			this.model_PM.updatePM(pm);
			int soLuongDong = model_table_PM.getRowCount();
			for(int i=0;i<soLuongDong;i++) {
				String maPhieu = model_table_PM.getValueAt(i, 0)+"";
				if(maPhieu.equals(pm.getMaPhieu()+"")) {
					model_table_PM.setValueAt(pm.getMaPhieu()+"", i, 0);
					model_table_PM.setValueAt(pm.getMaSV()+"", i, 1);
					model_table_PM.setValueAt(pm.getNgayMuon()+"", i, 2);
					model_table_PM.setValueAt(pm.getMaSach()+"", i, 3);
					model_table_PM.setValueAt(pm.getSoLuong()+"", i, 4);
					
				}
				
			}
			if(new PhieuMuonDao().updatePM(pm)) {
				JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
				return;
			}

		}

		public void thucHienXoa_PM() {
			DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
			int i_row = table_QLPM.getSelectedRow();
			
			int lc = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa dòng đã chọn ?");
			if(lc == JOptionPane.YES_OPTION) {
				PhieuMuon pm = getPhieuMuonDangChon();
				this.model_PM.deletePM(pm);
				model_table_PM.removeRow(i_row);
				if(new PhieuMuonDao().deletePM(pm)) {
					JOptionPane.showMessageDialog(this, "Delete Success !");
					return;
				}
				
			}
			
		}
		
		
		public PhieuMuon getPhieuMuonDangChon(){
			DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
			int i_row = table_QLPM.getSelectedRow();
			
			String maPhieu = model_table_PM.getValueAt(i_row,0)+"";
			int maSV = Integer.valueOf(model_table_PM.getValueAt(i_row, 1)+""); 
			
			String s_ngayMuon = model_table_PM.getValueAt(i_row, 2) + "";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		    java.util.Date utilNgayMuon = null;
		    try {
		    	utilNgayMuon = dateFormat.parse(s_ngayMuon);
		    } catch (ParseException e) {
		        e.printStackTrace();
		    }
		    java.sql.Date ngayMuon = new java.sql.Date(utilNgayMuon.getTime());
			
		    int maSach = Integer.valueOf(model_table_PM.getValueAt(i_row,3)+"");
		    int soLuong = Integer.valueOf(model_table_PM.getValueAt(i_row,4)+"");
			
			
			PhieuMuon pm = new PhieuMuon(maPhieu, maSV, ngayMuon, maSach, soLuong);
			return pm;
			 
		}
		
		public void hienThiThongtinPhieuMuonDaChon() {
			PhieuMuon pm = getPhieuMuonDangChon();
			
			this.textField_maPhieu.setText(pm.getMaPhieu()+"");
			this.comboBox_maSV.setSelectedItem(pm.getMaSV());
			this.textField_ngayMuon.setDate(pm.getNgayMuon());
			this.comboBox_maSach.setSelectedItem(pm.getMaSach());
			this.textField_soLuongMuon.setText(pm.getSoLuong()+"");
		}
		

		public void timPhieuMuon() {
			String maPhieuCanTim = this.textField_tim_MaPhieu.getText();
		    DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
		    PhieuMuon pm = new PhieuMuonDao().selectByid(maPhieuCanTim);
		    if (pm != null) {
		    	JOptionPane.showMessageDialog(null, "Found !");
		    	model_table_PM.setColumnCount(5); // Cập nhật số lượng cột
		    	model_table_PM.setRowCount(0); 
		    	model_table_PM.addRow(new Object[] {
		            pm.getMaPhieu(), pm.getMaSV(), pm.getNgayMuon(), pm.getMaSach(), pm.getSoLuong()
		        });
		    	
		    } else {
		        JOptionPane.showMessageDialog(null, "Không tìm thấy Phiếu có mã " + maPhieuCanTim);
		        return;
		    }
			
		}

		public void huyTimPhieuMuon() {
			DefaultTableModel model_table_PM = (DefaultTableModel) table_QLPM.getModel();
			while(true) {
				int soLuongDong = model_table_PM.getRowCount();
				if(soLuongDong == 0) {
					break;
				} else {
					model_table_PM.removeRow(0);
				}
			}
			for (PhieuMuon pm : this.model_PM.getDsPhieuMuon()) {
				model_table_PM.addRow(new Object[] {
						pm.getMaPhieu(), pm.getMaSV(), pm.getNgayMuon(), pm.getMaSach(), pm.getSoLuong()
					});
			}
		}

		public void tinhTongSach() {
			this.textField_tongSachMuon.setText(Integer.toString(new PhieuMuonDao().tinhTongSach()));
			
		}
		
}
