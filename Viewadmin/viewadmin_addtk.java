package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import View.viewmain;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class viewadmin_addtk extends JFrame {
	private JPanel contentPane;
	private JTextField text_tk;
	private JPasswordField text_mk;
	private JPasswordField text_xacnhan;
	private JTextField text_manv;
	private JTextField text_tennv;
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewadmin_addtk frameadmin_addtk=new viewadmin_addtk(nguoidung);
		frameadmin_addtk.showviewadmin_addtk();
	}
	public viewadmin_addtk(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewadmin_addtk.class.getResource("/Hinhanh/bulb_icon.png")));
		setTitle("Thêm tài khoản");	
		chucnang_user chucnang=new chucnang_user();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THÊM TÀI KHOẢN");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 27, 565, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên tài khoản:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 274, 168, 45);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 317, 168, 45);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Xác nhận mật khẩu");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(10, 372, 168, 45);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Chức vụ:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 416, 168, 45);
		contentPane.add(lblNewLabel_1_3);
		
		text_tk = new JTextField();
		text_tk.setBounds(188, 284, 244, 30);
		contentPane.add(text_tk);
		text_tk.setColumns(10);
		
		text_mk = new JPasswordField();
		text_mk.setBounds(188, 327, 244, 30);
		contentPane.add(text_mk);
		
		text_xacnhan = new JPasswordField();
		text_xacnhan.setBounds(188, 382, 244, 30);
		contentPane.add(text_xacnhan);
		
		JComboBox box_chucvu = new JComboBox();
		box_chucvu.setForeground(new Color(0, 64, 128));
		box_chucvu.setModel(new DefaultComboBoxModel(new String[] {".......", "Quản lí nhập kho", "Quản lí xuất kho"}));
		box_chucvu.setFont(new Font("Tahoma", Font.BOLD, 15));
		box_chucvu.setBounds(188, 423, 244, 31);
		contentPane.add(box_chucvu);
		//sau khi bam nut them tai khoan
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		menuBar.setBounds(0, 0, 565, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setBackground(new Color(128, 128, 128));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JMenuItem menu_quaylai = new JMenuItem("Exit");
		menu_quaylai.setIcon(new ImageIcon(viewadmin_addtk.class.getResource("/Hinhanh/logout.png")));
		menu_quaylai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewadmin_addtk();
			}
		});
		menu_quaylai.setFont(new Font("Segoe UI", Font.BOLD, 13));
		mnNewMenu.add(menu_quaylai);
		
		JLabel lblNewLabel_1_4 = new JLabel("Mã nhân viên:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(10, 102, 168, 45);
		contentPane.add(lblNewLabel_1_4);
		
		text_manv = new JTextField();
		text_manv.setColumns(10);
		text_manv.setBounds(188, 112, 158, 30);
		contentPane.add(text_manv);
		
		JLabel lblNewLabel_1_5 = new JLabel("Tên nhân viên:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5.setBounds(10, 164, 168, 45);
		contentPane.add(lblNewLabel_1_5);
		
		text_tennv = new JTextField();
		text_tennv.setColumns(10);
		text_tennv.setBounds(188, 174, 244, 30);
		contentPane.add(text_tennv);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Giới tính:");
		lblNewLabel_1_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_5_1.setBounds(10, 219, 168, 45);
		contentPane.add(lblNewLabel_1_5_1);
		
		JRadioButton nut_nam = new JRadioButton("Nam");
		nut_nam.setFont(new Font("Tahoma", Font.BOLD, 14));
		nut_nam.setBounds(188, 233, 72, 22);
		contentPane.add(nut_nam);
		
		JRadioButton nut_nu = new JRadioButton("Nữ");
		nut_nu.setFont(new Font("Tahoma", Font.BOLD, 14));
		nut_nu.setBounds(293, 232, 53, 22);
		contentPane.add(nut_nu);
		 ButtonGroup group = new ButtonGroup();
	        group.add(nut_nam);
	        group.add(nut_nu);
	     //them nut va su kien nut
	        JButton btnNewButton = new JButton("Thêm tài khoản");
	        btnNewButton.setIcon(new ImageIcon(viewadmin_addtk.class.getResource("/Hinhanh/add_icon.png")));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String kt1=new String(text_mk.getPassword());
					String kt2=new String(text_xacnhan.getPassword());
					if(kt1.equals(kt2))
					{	
						String gioitinh=new String();
						if(nut_nam.isSelected()==false&&nut_nu.isSelected()==false)
							JOptionPane.showMessageDialog(null,"Ban chưa chọn giới tính!");
						else {
							if(nut_nam.isSelected())
								gioitinh="Nam";
							else 
								gioitinh="Nữ";
							String manv=text_manv.getText();
							String tennv=text_tennv.getText();
							String user=text_tk.getText();
							String password=new String(text_mk.getPassword());
							String loai=box_chucvu.getSelectedItem().toString();
							User taikhoan =new User(manv,tennv,gioitinh,"","","","",user,password,loai);
							
							if(chucnang.themtk(taikhoan)==true)
							JOptionPane.showMessageDialog(null,"Tạo tài khoản thành công.");
							else {
								JOptionPane.showMessageDialog(null,"Đã có tài khoản tồn tại");
							}
						}
						
						}
					else 
					{
						JOptionPane.showMessageDialog(null,"Xác nhận mật khẩu sai!");
					}
					
				}
			});
			btnNewButton.setBackground(new Color(128, 255, 255));
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(188, 464, 244, 45);
			contentPane.add(btnNewButton);
	}
	public void showviewadmin_addtk() {
		this.setVisible(true);
	}
	public void closeviewadmin_addtk() {
		this.setVisible(false);
	}
}
