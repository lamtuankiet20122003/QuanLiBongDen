package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.bouncycastle.mime.MimeWriter;

import com.itextpdf.text.List;

import BongDen.bongden_chung;
import BongDen.chucnang_sanpham;
import TaiKhoan.User;
import View.viewmain;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class viewtonkho extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField text_soluong;
	private JTextField text_timkiem;
	private JTextField text_soloai;
	private JTextField text_sohangsx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

			User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
			
					viewtonkho frame = new viewtonkho(nguoidung);
					frame.setVisible(true);
			
	}

	/**
	 * Create the frame.
	 */
	public viewtonkho(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewtonkho.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_sanpham chucnang=new chucnang_sanpham();
		setTitle("Hàng tồn kho");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 749);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KHO HÀNG");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(153, 10, 287, 88);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 614, 421);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 th\u1EE9 t\u1EF1", "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "Lo\u1EA1i", "H\u00E3ng s\u1EA3n xu\u1EA5t", "S\u1ED1 l\u01B0\u1EE3ng"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(58);
		table.getColumnModel().getColumn(2).setPreferredWidth(143);
		table.getColumnModel().getColumn(3).setPreferredWidth(131);
		table.getColumnModel().getColumn(4).setPreferredWidth(138);
		chucnang.hienthisanpham(table);
		
		JButton btnNewButton = new JButton("Làm mới");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/refresh_icon.png")));
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.hienthisanpham(table);
				text_soluong.setText("");
				text_timkiem.setText("");
				text_soloai.setText("");
				text_sohangsx.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(711, 78, 144, 46);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(173, 21, 247, 77);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(628, 134, 227, 190);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 10, 207, 32);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2_1.setBounds(10, 52, 64, 32);
		panel_1.add(lblNewLabel_2_1);
		
		JComboBox box_loai = new JComboBox();
		box_loai.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất"}));
		box_loai.setBounds(84, 52, 133, 32);
		panel_1.add(box_loai);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Tên:");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2_1_1.setBounds(10, 94, 64, 32);
		panel_1.add(lblNewLabel_2_1_1);
		
		text_timkiem = new JTextField();
		text_timkiem.setColumns(10);
		text_timkiem.setBounds(84, 94, 133, 27);
		panel_1.add(text_timkiem);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setBackground(new Color(168, 211, 255));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_box_search=box_loai.getSelectedItem().toString();
				String name_search=text_timkiem.getText();
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
		btnTmKim.setBounds(84, 136, 133, 31);
		panel_1.add(btnTmKim);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(628, 375, 227, 180);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sắp xếp");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2_2.setBounds(10, 10, 207, 32);
		panel_1_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Loại:");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2_1_2.setBounds(10, 52, 64, 32);
		panel_1_1.add(lblNewLabel_2_1_2);
		
		JComboBox box_sapxep = new JComboBox();
		box_sapxep.setModel(new DefaultComboBoxModel(new String[] {"", "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất", "Số lượng"}));
		box_sapxep.setBounds(84, 52, 133, 32);
		panel_1_1.add(box_sapxep);
		
		JButton btnTng = new JButton("Tăng");
		btnTng.setBackground(new Color(128, 255, 128));
		btnTng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_sort=box_sapxep.getSelectedItem().toString();
				
				ArrayList<bongden_chung> danhsach=new ArrayList<>();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int sohang= table.getRowCount();
				String string=new String();
				for(int i=0;i<sohang;i++)
				{
					bongden_chung sp=new bongden_chung();
					for(int j=0;j<table.getColumnCount();j++) {
						 string=model.getValueAt(i, j).toString();
						switch (j) {
						case 1: 
								sp.setMa(string);			
							break;	
											
						case 2: 
								sp.setTen(string);			
							
							break;
											
						case 3: 
							sp.setLoai(string);
							
							break;
						
						case 4: 
							sp.setHang(string);
							
							break;
						
						case 5:
							sp.setSoluong(Integer.parseInt(string));
							break;
						default: 
							break;
						}
					}
					danhsach.add(sp);
					
				}
				
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
					chucnang.hienthisanpham_loaisp_tang_giam_table(table, dulieu, danhsach);
					}
				if(name_sort.equalsIgnoreCase("Hãng sản xuất")) 
					{
						chucnang.hienthisanpham_hangsp_tang_giam_table(table, dulieu, danhsach);
					}
				if(name_sort.equalsIgnoreCase("Số lượng")) 
					{
						chucnang.hienthisanpham_soluong_tang_giam_table(table, dulieu, danhsach);
					}
			}
			
		});
		btnTng.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTng.setBounds(84, 94, 133, 31);
		panel_1_1.add(btnTng);
		
		JButton btnTmKim_1_1 = new JButton("Giảm");
		btnTmKim_1_1.setBackground(new Color(255, 128, 192));
		btnTmKim_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name_sort=box_sapxep.getSelectedItem().toString();
				
				
				ArrayList<bongden_chung> danhsach=new ArrayList<>();
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int sohang= table.getRowCount();
				String string=new String();
				for(int i=0;i<sohang;i++)
				{
					bongden_chung sp=new bongden_chung();
					for(int j=0;j<table.getColumnCount();j++) {
						 string=model.getValueAt(i, j).toString();
						switch (j) {
						case 1: 
								sp.setMa(string);			
							break;	
											
						case 2: 
								sp.setTen(string);			
							
							break;
											
						case 3: 
							sp.setLoai(string);
							
							break;
						
						case 4: 
							sp.setHang(string);
							
							break;
						
						case 5:
							sp.setSoluong(Integer.parseInt(string));
							break;
						default: 
							break;
						}
					}
					danhsach.add(sp);
					
				}
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
				chucnang.hienthisanpham_loaisp_tang_giam_table(table, dulieu, danhsach);
				}
			if(name_sort.equalsIgnoreCase("Hãng sản xuất")) 
				{
					chucnang.hienthisanpham_hangsp_tang_giam_table(table, dulieu, danhsach);
				}
			if(name_sort.equalsIgnoreCase("Số lượng")) 
				{
					chucnang.hienthisanpham_soluong_tang_giam_table(table, dulieu, danhsach);
				}
			}
		});
		btnTmKim_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTmKim_1_1.setBounds(84, 135, 133, 31);
		panel_1_1.add(btnTmKim_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(10, 565, 385, 137);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		text_sohangsx = new JTextField();
		text_sohangsx.setBounds(145, 97, 96, 30);
		panel_2.add(text_sohangsx);
		text_sohangsx.setColumns(10);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số hãng sản xuất:");
		lblNewLabel_1_1_1.setBounds(10, 94, 139, 31);
		panel_2.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		text_soloai = new JTextField();
		text_soloai.setBounds(145, 60, 96, 27);
		panel_2.add(text_soloai);
		text_soloai.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số loại hiện có:");
		lblNewLabel_1_1.setBounds(10, 56, 122, 31);
		panel_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		text_soluong = new JTextField();
		text_soluong.setBounds(145, 23, 96, 27);
		panel_2.add(text_soluong);
		text_soluong.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Số lượng:");
		lblNewLabel_1.setBounds(63, 15, 69, 31);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnKimTra = new JButton("Kiểm tra");
		btnKimTra.setBackground(new Color(255, 255, 128));
		btnKimTra.setBounds(251, 60, 96, 67);
		panel_2.add(btnKimTra);
		btnKimTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tong so san pham hien co trong kho
				int sohang= table.getRowCount();
				int s=0;
				for(int i=0;i<sohang;i++)
				{
					DefaultTableModel model=(DefaultTableModel)table.getModel();

					String sostring=model.getValueAt(i, 5).toString();
					int so=Integer.parseInt(sostring);
					s=s+so;
				}
				String sumstring=String.valueOf(s);
				//So luong loai hien co trong kho
				ArrayList<String> dsloai=new ArrayList<>();
				for(int i=0;i<sohang;i++)
				{
					DefaultTableModel model=(DefaultTableModel)table.getModel();

					String sostring=model.getValueAt(i, 3).toString();
					dsloai.add(sostring);
				}
				text_soloai.setText(String.valueOf(chucnang.soloai_table(dsloai)));
				//So luong hang san xuat
				ArrayList<String> dshang=new ArrayList<>();
				for(int i=0;i<sohang;i++)
				{
					DefaultTableModel model=(DefaultTableModel)table.getModel();

					String sostring=model.getValueAt(i, 4).toString();
					dshang.add(sostring);
				}
				text_sohangsx.setText(String.valueOf(chucnang.sohang_table(dshang)));
				
				
				
				
				text_soluong.setText(sumstring);
				//text_soluong.setText(String.valueOf(soluong));
			}
		});
		btnKimTra.setFont(new Font("Tahoma", Font.BOLD, 14));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 863, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/logout.png")));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			closeviewtonkho();
				viewmain viewmain=new viewmain();
				viewmain.showit();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thông tin cá nhân");
		mntmNewMenuItem_3.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/user-info-icon.png")));
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewthongtin viewthongtin=new viewthongtin(nguoidung);
				viewthongtin.showviewthongtin();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_2.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/change_pass_icon.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewchangepass viewchangepass=new viewchangepass();
				viewchangepass.showviewchangepass();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Quay lại");
		mntmNewMenuItem_4.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/back_icon.png")));
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewtonkho();
				
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Excel");
	
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Print to Excel");
		mntmNewMenuItem_5.setIcon(new ImageIcon(viewtonkho.class.getResource("/Hinhanh/print-excel-icon.png")));
	
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chucnang.printtoexcel_sp()==true)
					JOptionPane.showMessageDialog(null,"In ra file Excel thành công");
				else 
					JOptionPane.showMessageDialog(null,"In ra file Excel thất bại");
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu_1.add(mntmNewMenuItem_5);
	}
	public void showviewtonkho() {
		this.setVisible(true);
	}
	public void closeviewtonkho() {
		this.setVisible(false);
	}
}
