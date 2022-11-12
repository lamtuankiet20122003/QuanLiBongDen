package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import TaiKhoan.User;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewthongtin extends JFrame {

	private JPanel contentPane;
	private JTextField text_manv;
	private JTextField text_tennv;
	private JTextField text_gioitinh;
	private JTextField text_diachi;
	private JTextField text_sdt;
	private JTextField text_email;
	private JTextField text_ngaysinh;
	private JTextField text_tk;
	private JTextField text_chucvu;
	private JPasswordField text_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewthongtin frame=new viewthongtin(nguoidung);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public viewthongtin(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewthongtin.class.getResource("/Hinhanh/bulb_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông tin tài khoản đang đăng nhập");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(0, 27, 518, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 77, 114, 20);
		contentPane.add(lblNewLabel_1);
		
		text_manv = new JTextField();
		text_manv.setBounds(120, 75, 105, 30);
		contentPane.add(text_manv);
		text_manv.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 117, 114, 20);
		contentPane.add(lblNewLabel_1_1);
		
		text_tennv = new JTextField();
		text_tennv.setColumns(10);
		text_tennv.setBounds(120, 115, 160, 30);
		contentPane.add(text_tennv);
		
		text_gioitinh = new JTextField();
		text_gioitinh.setColumns(10);
		text_gioitinh.setBounds(120, 155, 80, 30);
		contentPane.add(text_gioitinh);
		
		text_diachi = new JTextField();
		text_diachi.setColumns(10);
		text_diachi.setBounds(120, 195, 279, 30);
		contentPane.add(text_diachi);
		
		text_sdt = new JTextField();
		text_sdt.setColumns(10);
		text_sdt.setBounds(120, 235, 205, 30);
		contentPane.add(text_sdt);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(120, 274, 234, 30);
		contentPane.add(text_email);
		
		text_ngaysinh = new JTextField();
		text_ngaysinh.setColumns(10);
		text_ngaysinh.setBounds(120, 314, 187, 30);
		contentPane.add(text_ngaysinh);
		
		text_tk = new JTextField();
		text_tk.setColumns(10);
		text_tk.setBounds(120, 354, 160, 30);
		contentPane.add(text_tk);
		
		text_chucvu = new JTextField();
		text_chucvu.setColumns(10);
		text_chucvu.setBounds(120, 434, 205, 30);
		contentPane.add(text_chucvu);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(0, 157, 114, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(0, 197, 114, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(0, 235, 114, 20);
		contentPane.add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Email:");
		lblNewLabel_1_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_4.setBounds(0, 274, 114, 20);
		contentPane.add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_5.setBounds(0, 314, 114, 20);
		contentPane.add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("Tên tài khoản:");
		lblNewLabel_1_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_6.setBounds(0, 354, 114, 20);
		contentPane.add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Password:");
		lblNewLabel_1_1_7.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_7.setBounds(0, 394, 114, 20);
		contentPane.add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_8.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_8.setBounds(0, 434, 114, 20);
		contentPane.add(lblNewLabel_1_1_8);
		
		text_pass = new JPasswordField();
		text_pass.setBounds(120, 394, 160, 30);
		contentPane.add(text_pass);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 518, 17);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quay lại");
		mntmNewMenuItem.setIcon(new ImageIcon(viewthongtin.class.getResource("/Hinhanh/back_icon.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewthongtin();
				
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		
	
		text_manv.setText(nguoidung.getManv());
		text_tennv.setText(nguoidung.getTennv());
		text_gioitinh.setText(nguoidung.getGioitinh());
		text_diachi.setText(nguoidung.getDiachi());
		text_sdt.setText(nguoidung.getSodienthoai());
		text_email.setText(nguoidung.getEmail());
		text_ngaysinh.setText(nguoidung.getNgaysinh());
		text_tk.setText(nguoidung.getUser());
		text_pass.setText(nguoidung.getPassword());
		text_chucvu.setText(nguoidung.getLoai());
		
		JButton btnNewButton = new JButton("Cập nhật thông tin");
		btnNewButton.setIcon(new ImageIcon(viewthongtin.class.getResource("/Hinhanh/update_icon (1).png")));
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tennv=text_tennv.getText();
				String gioitinh=text_gioitinh.getText();
				String diachi=text_diachi.getText();
				String sdt=text_sdt.getText();
				String email=text_email.getText();
				String ngaysinh=text_ngaysinh.getText();
				nguoidung.setTennv(tennv);
				nguoidung.setGioitinh(gioitinh);
				nguoidung.setDiachi(diachi);
				nguoidung.setSodienthoai(sdt);
				nguoidung.setEmail(email);
				nguoidung.setNgaysinh(ngaysinh);
				UserDAO list=new UserDAO();
				int kq=list.update(nguoidung);
				if(kq!=0) {
					JOptionPane.showMessageDialog(null,"Cập nhật thông tin thành công");
				}
				else {
					JOptionPane.showMessageDialog(null,"Cập nhật thông tin thất bại");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(120, 474, 205, 40);
		contentPane.add(btnNewButton);
	}
	public void showviewthongtin() {
		this.setVisible(true);
	}
	public void closeviewthongtin() {
		this.setVisible(false);
	}
}
