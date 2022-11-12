package View;



import javax.print.DocFlavor.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import TaiKhoan.User;
import TaiKhoan.chucnang_user;
import Viewadmin.viewadmin_info;
import Viewadmin.viewforgetpass;
import Viewqlnk.viewqlnhapkho;
import Viewqlxk.viewqlxuatkho;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.BevelBorder;


public class viewmain extends JFrame{
	private JPanel contentPane;
	private JTextField text_taikhoan;
	private JPasswordField text_mk;
	public static void main(String[] args) {
		viewmain viewmain=new viewmain();
		viewmain.showit();
	}
		public viewmain() {
			setIconImage(Toolkit.getDefaultToolkit().getImage(viewmain.class.getResource("/Hinhanh/bulb_icon.png")));
			chucnang_user chucnang=new chucnang_user();
			ImageIcon icon = new ImageIcon("login.png", "Lock");
			setTitle("Login");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 618, 540);
			contentPane = new JPanel();
			contentPane.setToolTipText("");
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblTiKhon = new JLabel("Tài khoản:");
			lblTiKhon.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblTiKhon.setHorizontalAlignment(SwingConstants.CENTER);
			lblTiKhon.setBounds(10, 241, 110, 38);
			contentPane.add(lblTiKhon);
			
			
			text_taikhoan = new JTextField();
			text_taikhoan.setBounds(140, 249, 312, 26);
			contentPane.add(text_taikhoan);
			text_taikhoan.setColumns(10);
			
			JLabel lblMtKhu = new JLabel("Mật khẩu:");
			lblMtKhu.setHorizontalAlignment(SwingConstants.CENTER);
			lblMtKhu.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblMtKhu.setBounds(10, 278, 110, 38);
			contentPane.add(lblMtKhu);
			
			

			JButton nut_login = new JButton("Login",new ImageIcon(viewmain.class.getResource("/Hinhanh/login.png")));
			
			
			nut_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String user=text_taikhoan.getText();
					String password=new String(text_mk.getPassword());
					User nguoidung=chucnang.kiemtra_dangnhap(user, password);
					if(nguoidung==null)
						JOptionPane.showMessageDialog(null,"Tai khoan khong ton tai");
					if(nguoidung.getLoai().equalsIgnoreCase("ADMIN"))
						{
						closemain();
							viewadmin_info viewadmin_info=new viewadmin_info(nguoidung);
							viewadmin_info.showviewadmin_info();
						}
						else 
							if(nguoidung.getLoai().equalsIgnoreCase("Quản lí nhập kho")){
								closemain();
								viewqlnhapkho framViewqlnhapkho=new viewqlnhapkho(nguoidung);
								framViewqlnhapkho.showviewqlnhapkho();
							}
							else
								if(nguoidung.getLoai().equalsIgnoreCase("Quản lí xuất kho")){
									closemain();
									viewqlxuatkho framViewqlxuatkho=new viewqlxuatkho(nguoidung);
									framViewqlxuatkho.showviewqlxuatkho();
								}
								
					 
				}
			});
			nut_login.setBackground(new Color(128, 128, 128));
			nut_login.setFont(new Font("Tahoma", Font.BOLD, 13));
			nut_login.setBounds(140, 323, 151, 38);
			contentPane.add(nut_login);
			
			
			text_mk = new JPasswordField();
			text_mk.setBounds(140, 286, 312, 26);
			contentPane.add(text_mk);
			
			JButton nut_login_1 = new JButton("Forget pass");
			nut_login_1.setIcon(new ImageIcon(viewmain.class.getResource("/Hinhanh/forgot_icon.png")));
			nut_login_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					viewforgetpass viewforgetpass=new viewforgetpass();
					viewforgetpass.showviewforgetpass();
				}
			});
			nut_login_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			nut_login_1.setBackground(Color.GRAY);
			nut_login_1.setBounds(301, 323, 151, 38);
			contentPane.add(nut_login_1);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(viewmain.class.getResource("/Hinhanh/Banner.png")));
			lblNewLabel.setBounds(0, 0, 600, 199);
			contentPane.add(lblNewLabel);
		}
		public void showit() {
			this.setVisible(true);
		}
		public void closemain() {
			this.setVisible(false);
		}
}