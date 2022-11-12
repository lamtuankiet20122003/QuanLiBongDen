package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import View.viewmain;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewadmin_changetk extends JFrame {
	private JPanel contentPane;
	private JTextField text_manv;
	private JTextField text_tennv;
	private JTextField text_gioitinh;
	private JTextField text_diachi;
	private JTextField text_sdt;
	private JTextField text_email;
	private JTextField text_ngaysinh;
	public static void main(String[] args) {
		viewadmin_changetk frame=new viewadmin_changetk();
		frame.showviewadmin_changetk();
	}

	public viewadmin_changetk() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewadmin_changetk.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_user chucnang=new chucnang_user();
		setTitle("Chỉnh sửa thông tin tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chỉnh sửa thông tin cá nhân");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Admin\\OneDrive\\Máy tính\\icon_java\\Administrator-icon.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 28, 498, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(22, 104, 107, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(0, 145, 129, 31);
		contentPane.add(lblNewLabel_1_1);
		
		text_manv = new JTextField();
		text_manv.setBounds(139, 106, 193, 31);
		contentPane.add(text_manv);
		text_manv.setColumns(10);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 691, 18);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setBackground(new Color(128, 128, 128));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem(" Quay lại");
		mntmNewMenuItem.setIcon(new ImageIcon(viewadmin_changetk.class.getResource("/Hinhanh/back_icon.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewadmin_changetk();
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới tính:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(0, 186, 129, 31);
		contentPane.add(lblNewLabel_1_1_1);
		
		text_tennv = new JTextField();
		text_tennv.setColumns(10);
		text_tennv.setBounds(139, 147, 193, 31);
		contentPane.add(text_tennv);
		
		text_gioitinh = new JTextField();
		text_gioitinh.setColumns(10);
		text_gioitinh.setBounds(139, 188, 193, 31);
		contentPane.add(text_gioitinh);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setBounds(0, 227, 129, 31);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		text_diachi = new JTextField();
		text_diachi.setColumns(10);
		text_diachi.setBounds(139, 229, 193, 31);
		contentPane.add(text_diachi);
		
		text_sdt = new JTextField();
		text_sdt.setColumns(10);
		text_sdt.setBounds(139, 270, 193, 31);
		contentPane.add(text_sdt);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Số điện thoại:");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBounds(0, 270, 129, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1.setBounds(0, 311, 129, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		text_email = new JTextField();
		text_email.setColumns(10);
		text_email.setBounds(139, 311, 193, 31);
		contentPane.add(text_email);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(0, 352, 129, 31);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		text_ngaysinh = new JTextField();
		text_ngaysinh.setColumns(10);
		text_ngaysinh.setBounds(139, 352, 193, 31);
		contentPane.add(text_ngaysinh);
		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setIcon(new ImageIcon(viewadmin_changetk.class.getResource("/Hinhanh/update_icon.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String manv=text_manv.getText();
				String tennv=text_tennv.getText();
				String gioitinh=text_gioitinh.getText();
				String diachi=text_diachi.getText();
				String sdt=text_sdt.getText();
				String email=text_email.getText();
				String ngaysinh=text_ngaysinh.getText();
				User user=new User(manv, tennv, gioitinh, diachi, sdt, email, ngaysinh,"","","");
				if(chucnang.thaydoithongtin(user))
					JOptionPane.showMessageDialog(null,"Thay đổi thông tin thành công");
				else 
					JOptionPane.showMessageDialog(null,"Nhân viên không tồn tại");
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(139, 393, 193, 50);
		contentPane.add(btnNewButton);
	}
	public void showviewadmin_changetk() {
		this.setVisible(true);
	}
	public void closeviewadmin_changetk() {
		this.setVisible(false);
	}
}
