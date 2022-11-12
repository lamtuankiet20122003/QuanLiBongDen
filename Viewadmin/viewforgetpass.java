package Viewadmin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UserDAO;
import TaiKhoan.User;
import TaiKhoan.chucnang_user;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class viewforgetpass extends JFrame {

	private JPanel contentPane;
	private JTextField text_sdt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		viewforgetpass frame=new viewforgetpass();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public viewforgetpass() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewforgetpass.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_user chucnang=new chucnang_user();
		setTitle("Quên tài khoản");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập số điện thoại:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(34, 101, 153, 23);
		contentPane.add(lblNewLabel);
		
		text_sdt = new JTextField();
		text_sdt.setBounds(200, 101, 196, 27);
		contentPane.add(text_sdt);
		text_sdt.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.setBackground(new Color(128, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String timkiem=text_sdt.getText();
				User user=chucnang.timkiemtaikhoan_sdt(timkiem);
				if(user==null)
					JOptionPane.showMessageDialog(null,"Không có tài khoản tồn tại");
				else 
					JOptionPane.showMessageDialog(null,"Tên tài khoản:"+user.getUser()+"\n"+
														"Mật khẩu:"+user.getPassword());
				closeviewforgetpass();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(139, 161, 163, 33);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Quên tài khoản");
		lblNewLabel_1.setForeground(new Color(255, 128, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 20, 434, 43);
		contentPane.add(lblNewLabel_1);
	}
	public void showviewforgetpass() {
		this.setVisible(true);
	}
	public void closeviewforgetpass() {
		this.setVisible(false);
	}
}
