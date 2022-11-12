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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingContainer;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BongDen.bongden_nhap;
import BongDen.chucnang_sanpham;
import DAO.bongdenDAO;
import DAO.bongden_nhapDAO;
import DAO.bongden_xuatDAO;
import TaiKhoan.User;
import View.viewmain;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewaminlichsukhohang extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField text_masp;
	private JTextField text_tensp;
	private JTextField text_loai;
	private JTextField text_hang;
	private JTextField text_soluong;
	private JTextField text_thoigian;
	private JTextField text_loaiphieu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewaminlichsukhohang frame=new viewaminlichsukhohang(nguoidung,1);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public viewaminlichsukhohang(User nguoidung,int temp) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewaminlichsukhohang.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_sanpham chucnang=new chucnang_sanpham();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 772);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phần mềm quản lí lịch sử kho hàng");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(23, 10, 732, 71);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(375, 132, 484, 271);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectrow=table.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				bongden_nhap phieu=chucnang.phieunhap(tk);
				text_loaiphieu.setText("Phiếu nhập hàng");
				text_masp.setText(phieu.getMa());
				text_tensp.setText(phieu.getTen());
				text_loai.setText(phieu.getLoai());
				text_hang.setText(phieu.getHang());
				String soluongString=String.valueOf(phieu.getSoluong());
				text_soluong.setText(soluongString);
				text_thoigian.setText(phieu.getCurren());
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 th\u1EE9 t\u1EF1", "M\u00E3 phi\u1EBFu", "M\u00E3 nh\u00E2n vi\u00EAn qu\u1EA3n l\u00ED", "Th\u1EDDi gian nh\u1EADp"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(2).setPreferredWidth(126);
		table.getColumnModel().getColumn(3).setPreferredWidth(218);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(373, 454, 486, 271);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int selectrow=table_1.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				bongden_nhap phieu=chucnang.phieuxuat(tk);
				text_loaiphieu.setText("Phiếu xuất hàng");
				text_masp.setText(phieu.getMa());
				text_tensp.setText(phieu.getTen());
				text_loai.setText(phieu.getLoai());
				text_hang.setText(phieu.getHang());
				String soluongString=String.valueOf(phieu.getSoluong());
				text_soluong.setText(soluongString);
				text_thoigian.setText(phieu.getCurren());
				
			}
		});
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"S\u1ED1 th\u1EE9 t\u1EF1", "M\u00E3 phi\u1EBFu", "M\u00E3 nh\u00E2n vi\u00EAn qu\u1EA3n l\u00ED", "Th\u1EDDi gian xu\u1EA5t"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(121);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(205);
		
		text_masp = new JTextField();
		text_masp.setColumns(10);
		text_masp.setBounds(154, 176, 96, 30);
		contentPane.add(text_masp);
		
		text_tensp = new JTextField();
		text_tensp.setColumns(10);
		text_tensp.setBounds(154, 216, 170, 30);
		contentPane.add(text_tensp);
		
		text_loai = new JTextField();
		text_loai.setColumns(10);
		text_loai.setBounds(154, 253, 170, 30);
		contentPane.add(text_loai);
		
		text_hang = new JTextField();
		text_hang.setColumns(10);
		text_hang.setBounds(154, 293, 170, 30);
		contentPane.add(text_hang);
		
		text_soluong = new JTextField();
		text_soluong.setColumns(10);
		text_soluong.setBounds(154, 333, 79, 30);
		contentPane.add(text_soluong);
		
		text_thoigian = new JTextField();
		text_thoigian.setColumns(10);
		text_thoigian.setBounds(154, 373, 197, 30);
		contentPane.add(text_thoigian);
		
		JLabel lblNewLabel_3_2 = new JLabel("Mã sản phẩm:");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2.setBounds(25, 171, 119, 35);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_1 = new JLabel("Hiển thị thông tin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(-2, 91, 326, 35);
		contentPane.add(lblNewLabel_1);
		
		text_loaiphieu = new JTextField();
		text_loaiphieu.setColumns(10);
		text_loaiphieu.setBounds(154, 136, 125, 30);
		contentPane.add(text_loaiphieu);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Loại phiếu");
		lblNewLabel_3_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1.setBounds(23, 136, 119, 35);
		contentPane.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_3_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1.setBounds(5, 211, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_3_2_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_1_1.setBounds(5, 248, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_1_1);
		
		JLabel lblNewLabel_3_2_1_2 = new JLabel("Hãng sản xuất:");
		lblNewLabel_3_2_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2.setBounds(5, 293, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2);
		
		JLabel lblNewLabel_3_2_1_2_1 = new JLabel("Số lượng đã thêm:");
		lblNewLabel_3_2_1_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2_1.setBounds(5, 333, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2_1);
		
		JLabel lblNewLabel_3_2_1_2_1_1 = new JLabel("Thời gian :");
		lblNewLabel_3_2_1_2_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3_2_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3_2_1_2_1_1.setBounds(5, 373, 139, 35);
		contentPane.add(lblNewLabel_3_2_1_2_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Lịch sử nhập hàng");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(373, 91, 193, 35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lịch sử xuất hàng");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1_1.setBounds(373, 415, 197, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Sửa          ");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/update_icon (1).png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_loaiphieu.getText().equalsIgnoreCase("Phiếu nhập hàng"))
					{
						DefaultTableModel model=(DefaultTableModel)table.getModel();
						int selectrow=table.getSelectedRow();
						String tk=model.getValueAt(selectrow, 1).toString();
						bongden_nhap phieu=chucnang.phieunhap(tk);

						phieu.setTen(text_tensp.getText());
						phieu.setLoai(text_loai.getText());
						phieu.setHang(text_hang.getText());
						int soluong=Integer.parseUnsignedInt(text_soluong.getText());
						phieu.setSoluong(soluong);
						bongden_nhapDAO list=new bongden_nhapDAO();
						int kq= list.update(phieu);
						if(kq!=0)
							JOptionPane.showMessageDialog(null,"Cập nhật thành công");
						else 
							JOptionPane.showMessageDialog(null,"Cập nhật thất bại");
						chucnang.hienthilichsusanpham_nhap(table);
						chucnang.hienthilichsusanpham_xuat(table_1);
					}
				else 
					{
					DefaultTableModel model=(DefaultTableModel)table_1.getModel();
					int selectrow=table_1.getSelectedRow();
					String tk=model.getValueAt(selectrow, 1).toString();
					bongden_nhap phieu=chucnang.phieuxuat(tk);
					phieu.setTen(text_tensp.getText());
					phieu.setLoai(text_loai.getText());
					phieu.setHang(text_hang.getText());
					int soluong=Integer.parseUnsignedInt(text_soluong.getText());
					phieu.setSoluong(soluong);
					bongden_xuatDAO list=new bongden_xuatDAO();
					int kq= list.update(phieu);
					if(kq!=0)
						JOptionPane.showMessageDialog(null,"Cập nhật thành công");
					else 
						JOptionPane.showMessageDialog(null,"Cập nhật thất bại");
					chucnang.hienthilichsusanpham_nhap(table);
					chucnang.hienthilichsusanpham_xuat(table_1);
					}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(154, 461, 170, 35);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa          ");
		btnXa.setHorizontalAlignment(SwingConstants.LEFT);
		btnXa.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/delete_icon.png")));
		btnXa.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bongden_nhapDAO listnhap=new bongden_nhapDAO();
				bongden_xuatDAO listxuat=new bongden_xuatDAO();
				if(text_loaiphieu.getText().equalsIgnoreCase("Phiếu nhập hàng"))
				{
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					int selectrow=table.getSelectedRow();
					String tk=model.getValueAt(selectrow, 1).toString();	
					bongden_nhap phieu=chucnang.phieunhap(tk);
					int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc muốn xóa hóa đơn này",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION)
	                {
	                	if(listnhap.delete(phieu)!=0)
	    					JOptionPane.showMessageDialog(null,"Xóa thành công");
	    				else {
	    					JOptionPane.showMessageDialog(null,"Tài khoản này ko tồn tại");
	    				}
	                }else if (result == JOptionPane.NO_OPTION) 
		                {
		                    //System.out.println("Ban chon no");
		                }
				}
			else 
				{
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int selectrow=table_1.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				bongden_nhap phieu=chucnang.phieuxuat(tk);
				int result = JOptionPane.showConfirmDialog(null,
                        "Bạn có chắc muốn xóa hóa đơn này",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION)
                {
                	if(listxuat.delete(phieu)!=0)
    					JOptionPane.showMessageDialog(null,"Xóa thành công");
    				else {
    					JOptionPane.showMessageDialog(null,"Tài khoản này ko tồn tại");
    				}
                }else if (result == JOptionPane.NO_OPTION) 
	                {
	                    //System.out.println("Ban chon no");
	                }
				}
				
			}
		});
		btnXa.setBackground(new Color(255, 128, 0));
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXa.setBounds(154, 507, 170, 35);
		contentPane.add(btnXa);
		
		JButton btnLmMi = new JButton("Làm mới  ");
		btnLmMi.setHorizontalAlignment(SwingConstants.LEFT);
		btnLmMi.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/refresh_icon.png")));
		btnLmMi.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnLmMi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text_loaiphieu.setText("");
				text_masp.setText("");
				text_tensp.setText("");
				text_loai.setText("");
				text_hang.setText("");
				text_soluong.setText("");
				text_thoigian.setText("");
				chucnang.hienthilichsusanpham_nhap(table);
				chucnang.hienthilichsusanpham_xuat(table_1);
			}
		});
		btnLmMi.setBackground(new Color(128, 255, 255));
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLmMi.setBounds(154, 415, 170, 35);
		contentPane.add(btnLmMi);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 885, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/logout.png")));
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			closeviewaminlichsukhohang();
				viewmain viewmain=new viewmain();
				viewmain.showit();
			}
		});
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Thông tin cá nhân");
		mntmNewMenuItem_3.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/user-info-icon.png")));
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewthongtin viewthongtin=new viewthongtin(nguoidung);
				viewthongtin.showviewthongtin();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_2.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/change_pass_icon.png")));
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
		mntmNewMenuItem_4.setIcon(new ImageIcon(viewaminlichsukhohang.class.getResource("/Hinhanh/back_icon.png")));
		
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(temp==1)
				{
					closeviewaminlichsukhohang();
					viewadmin_info viewadmin_info=new viewadmin_info(nguoidung);
					viewadmin_info.showviewadmin_info();
				}
				else {
					closeviewaminlichsukhohang();
					viewadminquanlikhohang viewadminquanlikhohang=new viewadminquanlikhohang(nguoidung);
					viewadminquanlikhohang.showviewadminquanlikhohang();
				}

			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		
		
		
		chucnang.hienthilichsusanpham_nhap(table);
		chucnang.hienthilichsusanpham_xuat(table_1);
		
		JButton btnNewButton_1 = new JButton("Print to Excel");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chucnang.printtoexcel_lisunhapsp()==true)
					JOptionPane.showMessageDialog(null,"In ra file Excel thành công");
				else 
					JOptionPane.showMessageDialog(null,"In ra file Excel thất bại");
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(576, 92, 193, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Print to Excel");
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chucnang.printtoexcel_lisuxuatsp()==true)
					JOptionPane.showMessageDialog(null,"In ra file Excel thành công");
				else 
					JOptionPane.showMessageDialog(null,"In ra file Excel thất bại");
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(new Color(128, 255, 128));
		btnNewButton_1_1.setBounds(580, 414, 197, 30);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Update");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.updatebyexcel_lsnhap();
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBackground(new Color(255, 255, 128));
		btnNewButton_1_2.setBounds(771, 92, 106, 30);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.updatebyexcel_lsxuat();
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(Color.YELLOW);
		btnNewButton_1_1_1.setBounds(779, 413, 98, 30);
		contentPane.add(btnNewButton_1_1_1);
	}
	public void showviewaminlichsukhohang() {
		this.setVisible(true);
	}
	public void closeviewaminlichsukhohang() {
		this.setVisible(false);
	}
}
