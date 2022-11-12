package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.io.File;
import java.util.List;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.UserDAO;
import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import View.viewmain;

import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewadmin_info extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JSeparator separator;
	private JMenuItem mntmNewMenuItem_1;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JLabel lable_tennv;
	private JTextField text_tennv;
	private JLabel lable_tennv_1;
	private JLabel lable_tennv_2;
	private JLabel lable_tennv_3;
	private JLabel lable_tennv_4;
	private JLabel lable_tennv_5;
	private JTextField text_gioitinh;
	private JTextField text_diachi;
	private JTextField text_sdt;
	private JTextField text_email;
	private JTextField text_ngaysinh;
	private JLabel lblNewLabel_1;
	private JTextField text_timkiemnhanvien;
	private JButton btnNewButton_1;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_5;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JMenuItem mntmNewMenuItem_7;
	
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewadmin_info frame=new viewadmin_info(nguoidung);
		frame.setVisible(true);
	}

	public viewadmin_info(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewadmin_info.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_user chucnang=new chucnang_user();
		setTitle("Admin-Hiển thị thông tin tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 882, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("Danh sách tài khoản mật khẩu");
		lblNewLabel.setBounds(126, 29, 642, 49);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 868, 22);
		contentPane.add(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Thêm tài khoản");
		mntmNewMenuItem_2.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/add_icon.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewadmin_addtk viewadmin_addtk=new viewadmin_addtk(nguoidung);
				viewadmin_addtk.showviewadmin_addtk();
			}
		});
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Thông tin cá nhân");
		mntmNewMenuItem_4.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/user-info-icon.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewthongtin viewthongtin=new viewthongtin(nguoidung);
				viewthongtin.showviewthongtin();
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_4);
		mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem_3.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/change_pass_icon.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewchangepass viewchangepass=new viewchangepass();
				viewchangepass.showviewchangepass();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		separator = new JSeparator();
		mnNewMenu.add(separator);
		
		mntmNewMenuItem_1 = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem_1.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/logout.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewadmin_info();
				viewmain viewmain=new viewmain();
				viewmain.showit();
			}
		});
		lable_tennv = new JLabel("Tên nhân viên:");
		lable_tennv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv.setForeground(new Color(0, 0, 0));
		lable_tennv.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv.setBounds(542, 107, 109, 30);
		contentPane.add(lable_tennv);
		
		text_tennv = new JTextField();
		text_tennv.setBounds(649, 107, 194, 30);
		contentPane.add(text_tennv);
		text_tennv.setColumns(10);
		
		lable_tennv_1 = new JLabel("Giới tính:");
		lable_tennv_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv_1.setForeground(Color.BLACK);
		lable_tennv_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv_1.setBounds(542, 147, 109, 30);
		contentPane.add(lable_tennv_1);
		
		lable_tennv_2 = new JLabel("Địa chỉ:");
		lable_tennv_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv_2.setForeground(Color.BLACK);
		lable_tennv_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv_2.setBounds(542, 187, 109, 30);
		contentPane.add(lable_tennv_2);
		
		lable_tennv_3 = new JLabel("Số điện thoại:");
		lable_tennv_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv_3.setForeground(Color.BLACK);
		lable_tennv_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv_3.setBounds(542, 227, 109, 30);
		contentPane.add(lable_tennv_3);
		
		lable_tennv_4 = new JLabel("Email:");
		lable_tennv_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv_4.setForeground(Color.BLACK);
		lable_tennv_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv_4.setBounds(542, 267, 109, 30);
		contentPane.add(lable_tennv_4);
		
		lable_tennv_5 = new JLabel("Ngày sinh:");
		lable_tennv_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lable_tennv_5.setForeground(Color.BLACK);
		lable_tennv_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lable_tennv_5.setBounds(542, 307, 109, 30);
		contentPane.add(lable_tennv_5);
		
		text_gioitinh = new JTextField();
		text_gioitinh.setColumns(10);
		text_gioitinh.setBounds(649, 147, 71, 30);
		contentPane.add(text_gioitinh);
		
		text_diachi = new JTextField();
		text_diachi.setColumns(10);
		text_diachi.setBounds(649, 187, 194, 30);
		contentPane.add(text_diachi);
		
		text_sdt = new JTextField();
		text_sdt.setColumns(10);
		text_sdt.setBounds(649, 227, 194, 30);
		contentPane.add(text_sdt);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(649, 267, 194, 30);
		contentPane.add(text_email);
		
		lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(20, 94, 106, 23);
		contentPane.add(lblNewLabel_1);
		
		text_timkiemnhanvien = new JTextField();
		text_timkiemnhanvien.setBounds(126, 88, 140, 35);
		contentPane.add(text_timkiemnhanvien);
		text_timkiemnhanvien.setColumns(10);
		
		btnNewButton_1 = new JButton("Tìm kiếm");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive\\Máy tính\\icon_java\\Start-Menu-Search-icon.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manhanvien=text_timkiemnhanvien.getText();
				chucnang.thongtintaikhoanlenbang_theomanv(table_1, manhanvien);
				//System.out.println(manhanvien);
			}
		});
		btnNewButton_1.setBackground(new Color(128, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(278, 88, 161, 35);
		contentPane.add(btnNewButton_1);
		
		text_ngaysinh = new JTextField();
		text_ngaysinh.setColumns(10);
		text_ngaysinh.setBounds(649, 307, 194, 30);
		contentPane.add(text_ngaysinh);
		
		mntmNewMenuItem = new JMenuItem("Phần mềm quản lí");
		mntmNewMenuItem.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/bulb-icon2.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewadmin_info();
				viewadminquanlikhohang viewadminquanlikhohang=new viewadminquanlikhohang(nguoidung);
				viewadminquanlikhohang.showviewadminquanlikhohang();
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_5 = new JMenuItem("Lịch sử kho hàng");
		mntmNewMenuItem_5.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/history_icon.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewadmin_info();
				viewaminlichsukhohang viewaminlichsukhohang=new viewaminlichsukhohang(nguoidung,1);
				viewaminlichsukhohang.showviewaminlichsukhohang();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Print to Excel");
		mntmNewMenuItem_6.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/print-excel-icon.png")));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chucnang.printtoexcel_user()==true)
					JOptionPane.showMessageDialog(null,"Xuất ra file excel thanh công ");
				else 
					JOptionPane.showMessageDialog(null,"Xuất ra file excel thất bại");
				
			}});
		mntmNewMenuItem_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		mntmNewMenuItem_7 = new JMenuItem("Update by Excel");
		mntmNewMenuItem_7.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/update_excel_icon.png")));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.updatebyexcel();
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		btnNewButton = new JButton("Làm mới                 ");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/refresh_icon.png")));
		btnNewButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(0, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chucnang.hienthithongtintaikhoanlenbang(table_1);
				text_tennv.setText("");
				text_gioitinh.setText("");
				text_diachi.setText("");
				text_sdt.setText("");
				text_email.setText("");
				text_ngaysinh.setText("");
				text_timkiemnhanvien.setText("");
				
			}
		});
		btnNewButton.setBounds(597, 453, 246, 43);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 129, 522, 378);
		contentPane.add(scrollPane);
		
		table_1 = new JTable();
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int selectrow=table_1.getSelectedRow();
				String tk=model.getValueAt(selectrow, 1).toString();
				User user=chucnang.timkiemtaikhoantheomanv(tk);
				text_tennv.setText(user.getTennv());
				text_gioitinh.setText(user.getGioitinh());
				text_diachi.setText(user.getDiachi());
				text_sdt.setText(user.getSodienthoai());
				text_email.setText(user.getEmail());
				text_ngaysinh.setText(user.getNgaysinh());
				//System.out.println(model.getValueAt(selectrow, 1).toString());
			}
		});
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"S\u1ED1 th\u1EE9 t\u1EF1", "M\u00E3 nh\u00E2n vi\u00EAn", "T\u00E0i kho\u1EA3n", "M\u1EADt kh\u1EA9u", "Ch\u1EE9c v\u1EE5"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(59);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(125);
		chucnang.hienthithongtintaikhoanlenbang(table_1);
		
		JButton btnXaTiKhon = new JButton("Xóa tài khoản         ");
		btnXaTiKhon.setHorizontalAlignment(SwingConstants.LEFT);
		btnXaTiKhon.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/delete_icon.png")));
		btnXaTiKhon.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnXaTiKhon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int selectrow=table_1.getSelectedRow();
				String manv=model.getValueAt(selectrow, 1).toString();
				 int result = JOptionPane.showConfirmDialog(null,
	                        "Bạn có chắc muốn xóa tài khoản này",
	                        "Xác nhận",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);
	                if(result == JOptionPane.YES_OPTION)
	                {
	                	if(chucnang.xoataikhoan(manv))
	    					JOptionPane.showMessageDialog(null,"Xóa thành công");
	    				else {
	    					JOptionPane.showMessageDialog(null,"Tài khoản này ko tồn tại");
	    				}
	                }else if (result == JOptionPane.NO_OPTION) 
		                {
		                    //System.out.println("Ban chon no");
		                }
				/*if(chucnang.xoataikhoan(tkremove))
					JOptionPane.showMessageDialog(null,"Xóa thành công");
				else {
					JOptionPane.showMessageDialog(null,"Tài khoản này ko tồn tại");
				}*/
			}
		});
		btnXaTiKhon.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnXaTiKhon.setBackground(new Color(255, 128, 64));
		btnXaTiKhon.setBounds(597, 400, 246, 43);
		contentPane.add(btnXaTiKhon);
		
		JButton btnCpNhtTi = new JButton("Cập nhật tài khoản");
		btnCpNhtTi.setHorizontalAlignment(SwingConstants.LEFT);
		btnCpNhtTi.setIcon(new ImageIcon(viewadmin_info.class.getResource("/Hinhanh/update_icon (1).png")));
		btnCpNhtTi.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnCpNhtTi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model=(DefaultTableModel)table_1.getModel();
				int selectrow=table_1.getSelectedRow();
				String manv=model.getValueAt(selectrow, 1).toString();
				String tennv=text_tennv.getText();
				String gioitinh=text_gioitinh.getText();
				String diachi=text_diachi.getText();
				String sdt=text_sdt.getText();
				String email=text_email.getText();
				String ngaysinh=text_ngaysinh.getText();
				String username=model.getValueAt(selectrow, 2).toString();
				String password=model.getValueAt(selectrow, 3).toString();
				String chucvu=model.getValueAt(selectrow, 4).toString();
				User user=new User(manv, tennv, gioitinh, diachi, sdt, email, ngaysinh,username,password,chucvu);
				if(chucnang.thaydoithongtin(user))
					JOptionPane.showMessageDialog(null,"Thay đổi thông tin thành công");
				else 
					JOptionPane.showMessageDialog(null,"Nhân viên không tồn tại");
			}
		});
		btnCpNhtTi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCpNhtTi.setBackground(new Color(255, 255, 128));
		btnCpNhtTi.setBounds(597, 347, 246, 43);
		contentPane.add(btnCpNhtTi);
		
		
		
		
	}
	public void showviewadmin_info() {
		this.setVisible(true);
	}
	public void closeviewadmin_info() {
		this.setVisible(false);
	}
}
