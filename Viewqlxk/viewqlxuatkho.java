package Viewqlxk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BongDen.bongden_chung;
import BongDen.chucnang_sanpham;
import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import View.viewmain;
import Viewadmin.viewadmin_changetk;
import Viewadmin.viewchangepass;
import Viewadmin.viewthongtin;
import Viewadmin.viewtonkho;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewqlxuatkho extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField text_search;
	private JTextField text_masp;
	private JTextField text_tensp;
	private JTextField text_loaisp;
	private JTextField text_hangsp;
	private JTextField text_soluong;
	public static void main(String[] args ) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewqlxuatkho frame=new viewqlxuatkho(nguoidung);
		frame.setVisible(true);
	}
	public viewqlxuatkho(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewqlxuatkho.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_sanpham chucnang=new chucnang_sanpham(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHÀO MỪNG QUẢN LÍ XUẤT KHO");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(21, 31, 605, 35);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 693, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/logout.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewqlxuatkho();
				viewmain viewmain=new viewmain();
				viewmain.showit();
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Lịch sử xuất kho");
		mntmNewMenuItem_1.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/history_icon.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewqlxuatkho();
				viewlichsuxuathang viewlichsuxuathang=new viewlichsuxuathang(nguoidung);
				viewlichsuxuathang.showviewlichsuxuathang();
				
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cập nhật thông tin");
		mntmNewMenuItem_3.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/update_icon.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewthongtin viewthongtin=new viewthongtin(nguoidung);
				viewthongtin.showviewthongtin();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_2.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/change_pass_icon.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewchangepass viewchangepass=new viewchangepass();
				viewchangepass.showviewchangepass();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Kho hàng");
		mntmNewMenuItem_1_1.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/storage_icon.png")));
		mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewtonkho viewtonkho=new viewtonkho(nguoidung);
				viewtonkho.showviewtonkho();
			}
		});
		mntmNewMenuItem_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1_1);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		
		JButton btnNewButton = new JButton("Xuất bằng phiếu");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/export_icon(2).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewphieuxuat viewphieuxuat=new viewphieuxuat(nguoidung);
				viewphieuxuat.showviewphieuxuat();
			}
		});
		btnNewButton.setBackground(new Color(159, 207, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(337, 139, 201, 35);
		contentPane.add(btnNewButton);
		
		JButton btnXemThngTin = new JButton("Làm mới");
		btnXemThngTin.setHorizontalAlignment(SwingConstants.LEFT);
		btnXemThngTin.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/refresh_icon.png")));
		btnXemThngTin.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnXemThngTin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_masp.setText("");
				text_tensp.setText("");
				text_loaisp.setText("");
				text_hangsp.setText("");
				text_soluong.setText("");
				chucnang.hienthisanpham(table);
			}
		});
		btnXemThngTin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemThngTin.setBackground(new Color(255, 145, 145));
		btnXemThngTin.setBounds(337, 266, 201, 35);
		contentPane.add(btnXemThngTin);
		
		JLabel lblNewLabel_2 = new JLabel("Sort by:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(253, 345, 71, 27);
		contentPane.add(lblNewLabel_2);
		
		JComboBox box_sort = new JComboBox();
		box_sort.setFont(new Font("Tahoma", Font.BOLD, 12));
		box_sort.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất", "Số lượng"}));
		box_sort.setBounds(273, 381, 234, 35);
		contentPane.add(box_sort);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 481, 636, 199);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectrow=table.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				text_masp.setText(model.getValueAt(selectrow, 1).toString());
				text_tensp.setText(model.getValueAt(selectrow, 2).toString());
				text_loaisp.setText(model.getValueAt(selectrow, 3).toString());
				text_hangsp.setText(model.getValueAt(selectrow, 4).toString());
				text_soluong.setText(model.getValueAt(selectrow, 5).toString());
				//System.out.println(tk);
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Số thứ tự", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất", "Số lượng"
			}
		));
		scrollPane.setViewportView(table);
		JButton but_sort_tang = new JButton(" Tăng dần");
		but_sort_tang.setBackground(new Color(128, 255, 128));
		/*
		 * Mã sản phẩm
			Tên sản phẩm
			Loại sản phẩm
			Hãng sản xuất
			Số lượng
		 * */
		but_sort_tang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_sort=box_sort.getSelectedItem().toString();
				int dulieu=1;
				if(name_sort.equalsIgnoreCase("Mã sản phẩm")) 
					{
					chucnang.hienthisanpham_masp_tang_giam(table, dulieu);
					}
				if(name_sort.equalsIgnoreCase("Tên sản phẩm")) 
					{
						chucnang.hienthisanpham_tensp_tang_giam(table, dulieu);
					}
				if(name_sort.equalsIgnoreCase("Loại sản phẩm")) 
					{
					chucnang.hienthisanpham_loaisp_tang_giam(table, dulieu);
					}
				if(name_sort.equalsIgnoreCase("Hãng sản xuất")) 
					{
						chucnang.hienthisanpham_hangsp_tang_giam(table, dulieu);
					}
				if(name_sort.equalsIgnoreCase("Số lượng")) 
					{
						chucnang.hienthisanpham_soluong_tang_giam(table, dulieu);
					}
			
		}
		});
		but_sort_tang.setFont(new Font("Tahoma", Font.BOLD, 14));
		but_sort_tang.setBounds(273, 427, 117, 44);
		contentPane.add(but_sort_tang);
		
		JButton but_sort_giam = new JButton("Giảm dần");
		but_sort_giam.setBackground(new Color(255, 128, 192));
		but_sort_giam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_sort=box_sort.getSelectedItem().toString();
				//giam
				int dulieu=2;
				if(name_sort.equalsIgnoreCase("Mã sản phẩm")) 
				{
				chucnang.hienthisanpham_masp_tang_giam(table, dulieu);
				}
			if(name_sort.equalsIgnoreCase("Tên sản phẩm")) 
				{
					chucnang.hienthisanpham_tensp_tang_giam(table, dulieu);
				}
			if(name_sort.equalsIgnoreCase("Loại sản phẩm")) 
				{
				chucnang.hienthisanpham_loaisp_tang_giam(table, dulieu);
				}
			if(name_sort.equalsIgnoreCase("Hãng sản xuất")) 
				{
					chucnang.hienthisanpham_hangsp_tang_giam(table, dulieu);
				}
			if(name_sort.equalsIgnoreCase("Số lượng")) 
				{
					chucnang.hienthisanpham_soluong_tang_giam(table, dulieu);
				}
			}
		});
		but_sort_giam.setFont(new Font("Tahoma", Font.BOLD, 14));
		but_sort_giam.setBounds(390, 427, 117, 44);
		contentPane.add(but_sort_giam);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 341, 86, 35);
		contentPane.add(lblNewLabel_3);
		
		JComboBox box_search = new JComboBox();
		box_search.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất"}));
		box_search.setFont(new Font("Tahoma", Font.BOLD, 12));
		box_search.setBounds(74, 372, 145, 27);
		contentPane.add(box_search);
		
		JLabel lblNewLabel_3_1 = new JLabel("Loại:");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1.setBounds(21, 371, 43, 27);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Tên:");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_1_1.setBounds(20, 408, 43, 27);
		contentPane.add(lblNewLabel_3_1_1);
		
		text_search = new JTextField();
		text_search.setColumns(10);
		text_search.setBounds(74, 409, 145, 27);
		contentPane.add(text_search);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_box_search=box_search.getSelectedItem().toString();
				String name_search=text_search.getText();
				if(name_box_search.equalsIgnoreCase(""))
					JOptionPane.showMessageDialog(null,"Bạn chưa chọn loại để tìm kiếm!!!");
				else {
					if(name_box_search.equalsIgnoreCase("Mã sản phẩm")) 
						{
							chucnang.hienthisanpham_masp(table, name_search);
						}
					if(name_box_search.equalsIgnoreCase("Tên sản phẩm")) 
						{
							chucnang.hienthisanpham_tensp(table, name_search);
						}
					if(name_box_search.equalsIgnoreCase("Loại sản phẩm")) 
						{
							chucnang.hienthisanpham_loaisp(table, name_search);
						}
					if(name_box_search.equalsIgnoreCase("Hãng sản xuất")) 
						{
							chucnang.hienthisanpham_hangsp(table, name_search);
						}
				}
				
			}
		});
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTmKim.setBackground(new Color(159, 207, 255));
		btnTmKim.setBounds(74, 443, 145, 35);
		contentPane.add(btnTmKim);
		
		JLabel lblNewLabel_1 = new JLabel("Hiển thị thông tin");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(21, 76, 326, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mã sản phẩm:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(21, 139, 102, 35);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Chỉ hiển thị thông tin(không chỉnh sửa được trực tiếp trên đây)");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
		lblNewLabel_1_1.setBounds(21, 107, 359, 35);
		contentPane.add(lblNewLabel_1_1);
		
		text_masp = new JTextField();
		text_masp.setBounds(133, 144, 96, 30);
		contentPane.add(text_masp);
		text_masp.setColumns(10);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(1, 179, 122, 35);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_3_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1.setBounds(1, 216, 122, 35);
		contentPane.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Hãng sản xuất:");
		lblNewLabel_3_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2.setBounds(1, 256, 122, 35);
		contentPane.add(lblNewLabel_3_2_1_2);
		
		JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Số lượng:");
		lblNewLabel_3_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2_1.setBounds(1, 296, 122, 35);
		contentPane.add(lblNewLabel_3_2_1_2_1);
		
		text_tensp = new JTextField();
		text_tensp.setColumns(10);
		text_tensp.setBounds(133, 184, 170, 30);
		contentPane.add(text_tensp);
		
		text_loaisp = new JTextField();
		text_loaisp.setColumns(10);
		text_loaisp.setBounds(133, 221, 170, 30);
		contentPane.add(text_loaisp);
		
		text_hangsp = new JTextField();
		text_hangsp.setColumns(10);
		text_hangsp.setBounds(133, 261, 170, 30);
		contentPane.add(text_hangsp);
		
		text_soluong = new JTextField();
		text_soluong.setColumns(10);
		text_soluong.setBounds(133, 301, 79, 30);
		contentPane.add(text_soluong);
		
		
		chucnang.hienthisanpham(table);
		
		JButton btnXutBngFile = new JButton("Xuất bằng file Excel");
		btnXutBngFile.setHorizontalAlignment(SwingConstants.LEFT);
		btnXutBngFile.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/export_excel_icon(2).png")));
		btnXutBngFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.outsp_byexcel(nguoidung.getManv());
			}
		});
		btnXutBngFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXutBngFile.setBackground(new Color(128, 255, 255));
		btnXutBngFile.setBounds(337, 184, 201, 35);
		contentPane.add(btnXutBngFile);
		
		JButton btnInRaFile = new JButton("In ra file Excel");
		btnInRaFile.setHorizontalAlignment(SwingConstants.LEFT);
		btnInRaFile.setIcon(new ImageIcon(viewqlxuatkho.class.getResource("/Hinhanh/print-excel-icon (1).png")));
		btnInRaFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.printtoexcel_sp();
			}
		});
		btnInRaFile.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInRaFile.setBackground(new Color(255, 255, 128));
		btnInRaFile.setBounds(337, 225, 201, 35);
		contentPane.add(btnInRaFile);
	}
	public void showviewqlxuatkho() {
		this.setVisible(true);
	}
	public void closeviewqlxuatkho() {
		this.setVisible(false);
	}
}
