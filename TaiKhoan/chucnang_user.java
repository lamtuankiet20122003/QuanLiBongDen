package TaiKhoan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.mime.MimeWriter;


import BongDen.bongden_chung;
import BongDen.bongden_nhap;
import DAO.UserDAO;
import DAO.bongdenDAO;
import DAO.bongden_xuatDAO;

public class chucnang_user {
	public User kiemtra_dangnhap(String username,String password) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		
		for(int i=0;i<list.size();i++)
		{
			if(username.equalsIgnoreCase(list.get(i).getUser())&&password.equalsIgnoreCase(list.get(i).getPassword()))
				return list.get(i);
		}
		return null;
	}
	public boolean themtk(User user) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if (user.getUser().compareTo(list.get(i).getUser()) == 0) 
				return false;	
		}
		usDAO.insert(user);
		return true;
	}
	public boolean thaydoithongtin(User user) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if (user.getManv().compareTo(list.get(i).getManv()) == 0) 
				{
					user.setUser(list.get(i).getUser());
					user.setPassword(list.get(i).getPassword());
					user.setLoai(list.get(i).getLoai());
					usDAO.update(user);
					return true;
				}	
		}
		return false;
	}
	public boolean thaydoimatkhau(User user,String passmoi) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if (user.getUser().compareTo(list.get(i).getUser())==0
					&&user.getPassword().compareTo(list.get(i).getPassword())==0) 
				{
					user.setManv(list.get(i).getManv());
					user.setTennv(list.get(i).getTennv());
					user.setDiachi(list.get(i).getDiachi());
					user.setSodienthoai(list.get(i).getSodienthoai());
					user.setEmail(list.get(i).getEmail());
					user.setNgaysinh(list.get(i).getNgaysinh());
					user.setPassword(passmoi);
					user.setLoai(list.get(i).getLoai());
					usDAO.update(user);
					return true;
				}	
		}
		return false;
	}
	public boolean xoataikhoan(String manv) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if(manv.compareTo(list.get(i).getManv())==0)
			{
				User user=new User(manv, "","","","","","","","","");
				usDAO.delete(user);
				return true;
			}
		}
		return false;
	}
	public void hienthithongtintaikhoanlenbang(JTable table_1) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getManv(),list.get(i).getUser(),list.get(i).getPassword(),list.get(i).getLoai()});
		}		
	}
	public User timkiemtaikhoantheomanv(String manv) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if(manv.equalsIgnoreCase(list.get(i).getManv()))
				return list.get(i);		
		}
		return null;
	}
	public User timkiemtaikhoan_sdt(String sdt) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		for (int i = 0; i < list.size(); i++) {
			if(sdt.equalsIgnoreCase(list.get(i).getSodienthoai()))
				return list.get(i);		
		}
		return null;
	}
	public void thongtintaikhoanlenbang_theomanv(JTable table_1,String manv) {
		UserDAO usDAO=new UserDAO();
		ArrayList<User> list=usDAO.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			if(manv.equalsIgnoreCase(list.get(i).getManv()))
			model.addRow(new Object[] {1,list.get(i).getManv(),list.get(i).getUser(),list.get(i).getPassword(),list.get(i).getLoai()});
		}		
	}
	public boolean printtoexcel_user() {
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
        
        
        for(int i=0;i<12;i++)
        	sheet.autoSizeColumn(i);
        
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
                 return true;
                  //System.out.println("Tao file thanh cong");
			}catch (IOException e) {
				return false;
				//System.out.println("That bai");
			}
		}
		return false;
	}

	public boolean updatebyexcel() {
		boolean kq=true;
		UserDAO chucnang=new UserDAO();
		ArrayList<User> dstk=new ArrayList<>();

		
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
									if(cell.getStringCellValue()==null)
										user.setManv("");
									else
										user.setManv(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==2) {
									if(cell.getStringCellValue()==null)
										user.setTennv("");
									else
										user.setTennv(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==3) {
									if(cell.getStringCellValue()==null)
										user.setGioitinh("");
									else
										user.setGioitinh(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
									if(cell.getStringCellValue()==null)
										user.setDiachi("");
									else
										user.setDiachi(cell.getStringCellValue());

									}
							else if(cell.getColumnIndex()==5) {
									if(cell.getStringCellValue()==null)
										user.setSodienthoai("");
									else
										user.setSodienthoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==6) {
									if(cell.getStringCellValue()==null)
										user.setEmail("");
									else
										user.setEmail(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==7) {
									if(cell.getStringCellValue()==null)
										user.setNgaysinh("");
									else
										user.setNgaysinh(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==8) {
									if(cell.getStringCellValue()==null)
										user.setUser("");
									else
										user.setUser(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==9) {
									if(cell.getStringCellValue()==null)
										user.setPassword("");
									else
										user.setPassword(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==10) {
									if(cell.getStringCellValue()==null)
										user.setLoai("");
									else
										user.setLoai(cell.getStringCellValue());
									}
							
						}	
					}
					dstk.add(user);
				} 
				dstk.remove(0);
				in.close();
				chucnang.delete_all();
				if (dstk.get(0).getDiachi()==null) {
					dstk.get(0).setDiachi("");
				}
				if (dstk.get(0).getSodienthoai()==null) {
					dstk.get(0).setSodienthoai("");
				}
				if (dstk.get(0).getEmail()==null) {
					dstk.get(0).setEmail("");
				}
				if (dstk.get(0).getNgaysinh()==null) {
					dstk.get(0).setNgaysinh("");
				}
				for(int i=0;i<dstk.size();i++)
				{
					chucnang.insert(dstk.get(i));
				}
				
				return kq;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return kq;
	}
	
}
