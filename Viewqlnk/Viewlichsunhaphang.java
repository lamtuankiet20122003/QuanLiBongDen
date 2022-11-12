package Viewqlnk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BongDen.bongden_nhap;
import BongDen.chucnang_sanpham;
import TaiKhoan.User;
import View.viewmain;
import Viewadmin.viewchangepass;
import Viewadmin.viewthongtin;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Viewlichsunhaphang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField text_search;
	private JTextField text_masp;
	private JTextField text_tensp;
	private JTextField text_loaisp;
	private JTextField text_hangsp;
	private JTextField text_soluong;
	private JTextField text_tgnhap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		Viewlichsunhaphang frame=new Viewlichsunhaphang(nguoidung);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Viewlichsunhaphang(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Viewlichsunhaphang.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_sanpham list=new chucnang_sanpham();
		setTitle("Lịch sử nhập kho hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 692);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LỊCH SỬ NHẬP HÀNG");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(1, 11, 738, 54);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("Hiển thị thông tin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 76, 326, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mã sản phẩm:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(21, 139, 119, 35);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chỉ hiển thị thông tin(không chỉnh sửa được trực tiếp trên đây)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_1.setBounds(21, 107, 359, 35);
		contentPane.add(lblNewLabel_1_1);
		
		text_masp = new JTextField();
		text_masp.setBounds(150, 144, 96, 30);
		contentPane.add(text_masp);
		text_masp.setColumns(10);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(1, 179, 139, 35);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_3_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1.setBounds(1, 216, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Hãng sản xuất:");
		lblNewLabel_3_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2.setBounds(1, 256, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2);
		
		JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Số lượng đã thêm:");
		lblNewLabel_3_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2_1.setBounds(1, 296, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2_1);
		
		text_tensp = new JTextField();
		text_tensp.setColumns(10);
		text_tensp.setBounds(150, 184, 170, 30);
		contentPane.add(text_tensp);
		
		text_loaisp = new JTextField();
		text_loaisp.setColumns(10);
		text_loaisp.setBounds(150, 221, 170, 30);
		contentPane.add(text_loaisp);
		
		text_hangsp = new JTextField();
		text_hangsp.setColumns(10);
		text_hangsp.setBounds(150, 261, 170, 30);
		contentPane.add(text_hangsp);
		
		text_soluong = new JTextField();
		text_soluong.setColumns(10);
		text_soluong.setBounds(150, 301, 79, 30);
		contentPane.add(text_soluong);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 419, 661, 226);
		contentPane.add(scrollPane);
		
		text_tgnhap = new JTextField();
		text_tgnhap.setColumns(10);
		text_tgnhap.setBounds(150, 341, 197, 30);
		contentPane.add(text_tgnhap);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectrow=table.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				bongden_nhap phieu=list.phieunhap(tk);
				text_masp.setText(phieu.getMa());
				text_tensp.setText(phieu.getTen());
				text_loaisp.setText(phieu.getLoai());
				text_hangsp.setText(phieu.getHang());
				String soluongString=String.valueOf(phieu.getSoluong());
				text_soluong.setText(soluongString);
				text_tgnhap.setText(phieu.getCurren());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 th\u1EE9 t\u1EF1", "M\u00E3 phi\u1EBFu", "Ng\u00E0y nh\u1EADp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(66);
		table.getColumnModel().getColumn(2).setPreferredWidth(169);
		

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 866, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/logout.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewlichsunhaphang();
				viewmain viewmain=new viewmain();
				viewmain.showit();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cập nhật thông tin");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/update_icon.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewthongtin viewthongtin=new viewthongtin(nguoidung);
				viewthongtin.showviewthongtin();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_2.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/change_pass_icon.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewchangepass viewchangepass=new viewchangepass();
				viewchangepass.showviewchangepass();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Quay lại");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/back_icon.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewlichsunhaphang();
				viewqlnhapkho viewqlnhapkho=new viewqlnhapkho(nguoidung);
				viewqlnhapkho.showviewqlnhapkho();
			}
		});
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/refresh_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_masp.setText("");
				text_tensp.setText("");
				text_loaisp.setText("");
				text_hangsp.setText("");
				text_soluong.setText("");
				text_tgnhap.setText("");
				list.hienthilichsusanpham_nhap(table);
			}
		});
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(491, 365, 177, 44);
		contentPane.add(btnNewButton);
		list.hienthilichsusanpham_nhap(table);
		
		JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("Thời gian nhập:");
		lblNewLabel_3_2_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2_1_1.setBounds(1, 341, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2_1_1);
		
		JButton btnInRaFile = new JButton("In ra file Excel");
		btnInRaFile.setHorizontalAlignment(SwingConstants.LEFT);
		btnInRaFile.setIcon(new ImageIcon(Viewlichsunhaphang.class.getResource("/Hinhanh/print-excel-icon (1).png")));
		btnInRaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.printtoexcel_lisunhapsp();
			}
		});
		btnInRaFile.setForeground(Color.BLACK);
		btnInRaFile.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnInRaFile.setBackground(new Color(128, 255, 128));
		btnInRaFile.setBounds(491, 298, 177, 44);
		contentPane.add(btnInRaFile);
		
		
		//lichsunhaphang.displayonjtable_líchunhaphang(table);
	}
	public void showviewlichsunhaphang() {
		this.setVisible(true);
	}
	public void closeviewlichsunhaphang() {
		this.setVisible(false);
	}
}
