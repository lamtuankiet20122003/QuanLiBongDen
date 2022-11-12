package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import View.viewmain;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewchangepass extends JFrame {

	private JPanel contentPane;
	private JTextField text_tk;
	private JPasswordField text_mkcu;
	private JPasswordField text_mkmoi;
	private JPasswordField text_xnmk;

	public static void main(String[] args) {
		viewchangepass frame=new viewchangepass();
		frame.setVisible(true);
	}

	
	public viewchangepass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewchangepass.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_user chucnang=new chucnang_user();
		setTitle("Thay đổi mật khẩu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đổi mật khẩu");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 40, 436, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(21, 92, 124, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu cũ:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(21, 160, 124, 42);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 233, 135, 42);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Xác nhận mật khẩu:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 303, 146, 42);
		contentPane.add(lblNewLabel_1_3);
		
		text_tk = new JTextField();
		text_tk.setBounds(155, 102, 135, 28);
		contentPane.add(text_tk);
		text_tk.setColumns(10);
		
		text_mkcu = new JPasswordField();
		text_mkcu.setBounds(155, 170, 135, 28);
		contentPane.add(text_mkcu);
		
		text_mkmoi = new JPasswordField();
		text_mkmoi.setBounds(155, 243, 135, 28);
		contentPane.add(text_mkmoi);
		
		text_xnmk = new JPasswordField();
		text_xnmk.setBounds(155, 313, 135, 28);
		contentPane.add(text_xnmk);
		
		JButton btnNewButton = new JButton("Thay đổi");
		btnNewButton.setIcon(new ImageIcon(viewchangepass.class.getResource("/Hinhanh/update_icon (1).png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tk=text_tk.getText();
				String passcu=new String(text_mkcu.getPassword());
				String passmoi=new String(text_mkmoi.getPassword());
				String passxn=new String(text_xnmk.getPassword());
				User usercu=new User("","","","","","","",tk, passcu,"");
				if(passmoi.equals(passxn))
				{
					if(chucnang.thaydoimatkhau(usercu, passmoi))
						JOptionPane.showMessageDialog(null,"Thay đổi mật khẩu thành công");
					else 
						JOptionPane.showMessageDialog(null,"Thay đổi mật khẩu thất bại!!");
				}
				else 
				{
					JOptionPane.showMessageDialog(null,"Mật khẩu xác nhận không đúng!!!");
				}
					
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 255, 128));
		btnNewButton.setBounds(155, 375, 135, 42);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 436, 30);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Thoát tài khoản");
		mntmNewMenuItem_1.setIcon(new ImageIcon(viewchangepass.class.getResource("/Hinhanh/logout.png")));
		mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewchangepass();
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quay lại");
		mntmNewMenuItem.setIcon(new ImageIcon(viewchangepass.class.getResource("/Hinhanh/back_icon.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewchangepass();
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mnNewMenu.add(mntmNewMenuItem_1);
	}
	public void showviewchangepass() {
		this.setVisible(true);
	}
	public void closeviewchangepass() {
		this.setVisible(false);
	}
}
