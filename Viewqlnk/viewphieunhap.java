package Viewqlnk;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BongDen.bongden_chung;
import BongDen.bongden_nhap;
import BongDen.chucnang_sanpham;
import TaiKhoan.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class viewphieunhap extends JFrame {

	private JPanel contentPane;
	private JTextField text_ma;
	private JTextField text_ten;
	private JTextField text_loai;
	private JTextField text_hangsx;
	private JTextField text_soluong;
	public static void main(String[] args) {
		User nguoidung=new User("ADMIN1", "Lam Tuan Kiet","Nam","","","","","admin","admin","ADMIN");
		viewphieunhap frame=new viewphieunhap(nguoidung);
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public viewphieunhap(User nguoidung) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(viewphieunhap.class.getResource("/Hinhanh/bulb_icon.png")));
		chucnang_sanpham list=new chucnang_sanpham();
		setTitle("Phiếu nhập hàng");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Phiếu nhập hàng");
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 24, 296, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(31, 103, 92, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên hàng:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(31, 153, 92, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Loại mặt hàng:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(10, 210, 119, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Hãng sảng xuất:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(10, 277, 119, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Số lượng:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(31, 342, 92, 25);
		contentPane.add(lblNewLabel_1_4);
		
		text_ma = new JTextField();
		text_ma.setBounds(133, 102, 165, 31);
		contentPane.add(text_ma);
		text_ma.setColumns(10);
		
		text_ten = new JTextField();
		text_ten.setColumns(10);
		text_ten.setBounds(133, 153, 220, 31);
		contentPane.add(text_ten);
		
		text_loai = new JTextField();
		text_loai.setColumns(10);
		text_loai.setBounds(133, 210, 165, 31);
		contentPane.add(text_loai);
		
		text_hangsx = new JTextField();
		text_hangsx.setColumns(10);
		text_hangsx.setBounds(133, 271, 165, 31);
		contentPane.add(text_hangsx);
		
		text_soluong = new JTextField();
		text_soluong.setColumns(10);
		text_soluong.setBounds(133, 336, 92, 31);
		contentPane.add(text_soluong);
		
		JButton but_nhap = new JButton("Nhập hàng");
		but_nhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String masp=text_ma.getText();
				String tensp=text_ten.getText();
				String loai=text_loai.getText();
				String hangsx=text_hangsx.getText();
				int soluong=Integer.parseUnsignedInt(text_soluong.getText());
				//tao ra san pham
				bongden_chung sp=new bongden_chung(masp, tensp, loai, hangsx, soluong);
				//tao ra chuoi chua tg luc moi nhap
				LocalDateTime current = LocalDateTime.now();
				DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
				String ngaynhap=current.format(dateFormatter);
				//----------------------------------
				bongden_nhap lichsusp=new bongden_nhap("",nguoidung.getManv(),masp, tensp, loai, hangsx, soluong, ngaynhap);

				if(masp.equalsIgnoreCase("")==true||
						tensp.equalsIgnoreCase("")==true||
						loai.equalsIgnoreCase("")==true||
						hangsx.equalsIgnoreCase("")==true
						) 
					JOptionPane.showMessageDialog(null,"Thiếu dữ liệu!!!!!!");
				
				else {
					list.nhapsanpham(sp, lichsusp);
					JOptionPane.showMessageDialog(null,"Nhập hàng thành công.");
				}
				closeviewphieunhap();
			}
		});
		but_nhap.setBackground(new Color(128, 255, 128));
		but_nhap.setFont(new Font("Tahoma", Font.BOLD, 16));
		but_nhap.setBounds(133, 394, 173, 42);
		contentPane.add(but_nhap);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 442, 25);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Quay lại");
		mntmNewMenuItem.setIcon(new ImageIcon(viewphieunhap.class.getResource("/Hinhanh/back_icon.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeviewphieunhap();
			}
		});
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
	}
	public void showviewphieunhap() {
		this.setVisible(true);
	}
	public void closeviewphieunhap() {
		this.setVisible(false);
	}
}
