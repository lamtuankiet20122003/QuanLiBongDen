package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.UserDAO;
import TaiKhoan.User;
import TaiKhoan.chucnang_user;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class testinfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		testinfo farme=new testinfo();
		farme.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public void docfileexcel() {
		ArrayList<User> list=new ArrayList<>();
		ArrayList<String> header=new ArrayList<>();
		ArrayList<Integer> stt=new ArrayList<>();
		JFileChooser openFileChooser=new JFileChooser();
		openFileChooser.setDialogTitle("Open File");
		openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Excel file (.xlsx)","xlsx");
		openFileChooser.setFileFilter(filter);
		
		
		if(openFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File inputFile=openFileChooser.getSelectedFile();
			try(FileInputStream in=new FileInputStream(inputFile)) {
				
				
				XSSFWorkbook imporetedfile =new XSSFWorkbook(in);
				XSSFSheet sheet1=imporetedfile.getSheetAt(0);
				
				
				Iterator<Row> rowiterator=sheet1.iterator();
				
				
				
				while(rowiterator.hasNext()) {
					Row row=rowiterator.next();
					Iterator<Cell> cellIterator=row.cellIterator();
					User user=new User();
					while(cellIterator.hasNext()) {
						
						Cell cell=cellIterator.next();
						if(row.getRowNum()==0)
						{
							header.add(cell.getStringCellValue());
						}
						else {
							if(cell.getColumnIndex()==0) {
								stt.add((int)cell.getNumericCellValue());
									}
							else if(cell.getColumnIndex()==1) {
								user.setManv(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==2) {
								user.setTennv(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==3) {
								user.setGioitinh(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								user.setDiachi(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==5) {
								user.setSodienthoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==6) {
								user.setEmail(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==7) {
								user.setNgaysinh(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==8) {
								user.setUser(cell.getStringCellValue());;
									}
							else if(cell.getColumnIndex()==9) {
								user.setPassword(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==10) {
								user.setLoai(cell.getStringCellValue());
									}
						}	
					}
					
					list.add(user);
				} 
				list.remove(0);
				in.close();
				for(int i=0;i<list.size();i++)
					System.out.println(list.get(i));
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
	}
	public void ghifileexcel() {
		UserDAO chucnang=new UserDAO();
		ArrayList<User> list=chucnang.selecAll();
		XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Result");
        XSSFRow row;
        row=sheet.createRow(0);
        Cell cell0=row.createCell(0);
        Cell cell1=row.createCell(1);
        Cell cell2=row.createCell(2);
        Cell cell3=row.createCell(3);
        Cell cell4=row.createCell(4);
        Cell cell5=row.createCell(5);
        Cell cell6=row.createCell(6);
        Cell cell7=row.createCell(7);
        Cell cell8=row.createCell(8);
        Cell cell9=row.createCell(9);
        Cell cell10=row.createCell(10);
        
        
        cell0.setCellValue("STT");
        cell1.setCellValue("Mã nhân viên");
        cell2.setCellValue("Tên nhân viên");
        cell3.setCellValue("Giới tính");
        cell4.setCellValue("Địa chỉ");
        cell5.setCellValue("Số điện thoại");
        cell6.setCellValue("Email");
        cell7.setCellValue("Ngày sinh");
        cell8.setCellValue("Tài khoản");
        cell9.setCellValue("Mật khẩu");
        cell10.setCellValue("Chức vụ");
        
        
        for (int i = 0; i <list.size(); i++) {
            row=sheet.createRow(i+1);
            for (int j = 0; j < 11; j++) {
                Cell cell=row.createCell(j);
                if(cell.getColumnIndex()==0){
                    cell.setCellValue(i+1);
                }
                else if(cell.getColumnIndex()==1){
                    cell.setCellValue(list.get(i).getManv());
                }
                else if(cell.getColumnIndex()==2){
                	cell.setCellValue(list.get(i).getTennv());
                }
                else if(cell.getColumnIndex()==3){
                	cell.setCellValue(list.get(i).getGioitinh());
                }
                else if(cell.getColumnIndex()==4){
                	cell.setCellValue(list.get(i).getDiachi());
                }
                else if(cell.getColumnIndex()==5){
                	cell.setCellValue(list.get(i).getSodienthoai());
                }
                else if(cell.getColumnIndex()==6){
                	cell.setCellValue(list.get(i).getEmail());
                }
                else if(cell.getColumnIndex()==7){
                	cell.setCellValue(list.get(i).getNgaysinh());
                }
                else if(cell.getColumnIndex()==8){
                	cell.setCellValue(list.get(i).getUser());
                }
                else if(cell.getColumnIndex()==9){
                	cell.setCellValue(list.get(i).getPassword());
                }
                else if(cell.getColumnIndex()==10){
                	cell.setCellValue(list.get(i).getLoai());
                }
            }
        }   
        JFileChooser openFileChooser=new JFileChooser();
		openFileChooser.setDialogTitle("Open File");
		openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
		FileNameExtensionFilter filter=new FileNameExtensionFilter("Excel file (.xlsx)","xlsx");
		openFileChooser.setFileFilter(filter);
		
		
		if(openFileChooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			File inputFile=openFileChooser.getSelectedFile();
			try(FileOutputStream outputStream=new FileOutputStream(inputFile)) {
				 workbook.write(outputStream);
                 outputStream.close();
                  System.out.println("Tao file thanh cong");
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
       
	}

	public testinfo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\JAVA\\QuanLiBongDen\\src\\login.png"));
		chucnang_user chucnang=new chucnang_user();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xuất ra excel");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(64, 23, 712, 58);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Print to Excel");
		btnNewButton.setIcon(new ImageIcon("D:\\JAVA\\QuanLiBongDen\\src\\login.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ghifileexcel();
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(52, 218, 305, 137);
		contentPane.add(btnNewButton);
		
		JButton btnExportExcel = new JButton("Export Excel");
		btnExportExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				docfileexcel();
			}
		});
		btnExportExcel.setForeground(Color.BLACK);
		btnExportExcel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExportExcel.setBackground(new Color(0, 0, 255));
		btnExportExcel.setBounds(394, 218, 305, 137);
		contentPane.add(btnExportExcel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JAVA\\QuanLiBongDen\\src\\login.png"));
		lblNewLabel_1.setBounds(74, 52, 191, 121);
		contentPane.add(lblNewLabel_1);
	}
}
