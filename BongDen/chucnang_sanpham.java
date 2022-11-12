package BongDen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import DAO.UserDAO;
import DAO.bongdenDAO;
import DAO.bongden_nhapDAO;
import DAO.bongden_xuatDAO;
import TaiKhoan.User;

public class chucnang_sanpham {
	public int nhapsanpham(bongden_chung sp,bongden_nhap lichsusp) {
		bongdenDAO listbBongdenDAO=new bongdenDAO();
		bongden_nhapDAO listBongden_nhapDAO=new bongden_nhapDAO();
		ArrayList<bongden_chung> list=listbBongdenDAO.selecAll();
		ArrayList<bongden_nhap> list2=listBongden_nhapDAO.selecAll();
		int sttphieu=list2.size()+1;
		String maphieu="PN"+sttphieu;
		lichsusp.setMaphieu(maphieu);
		
		for(int i=0;i<list.size();i++) {
			if(sp.getMa().equalsIgnoreCase(list.get(i).getMa())&&
					sp.getTen().equalsIgnoreCase(list.get(i).getTen())&&
					sp.getLoai().equalsIgnoreCase(list.get(i).getLoai())&&
					sp.getHang().equalsIgnoreCase(list.get(i).getHang()))
				 {	
					bongden_chung sptam=list.get(i);
					sptam.setSoluong(list.get(i).getSoluong()+sp.getSoluong());
					listbBongdenDAO.update(sptam);
					listBongden_nhapDAO.insert(lichsusp);
					return 1;
				 }
		}
		listbBongdenDAO.insert(sp);
		listBongden_nhapDAO.insert(lichsusp);
		return 2;
	}
	public int xuatsanpham(bongden_chung sp,bongden_nhap lichsuxuat) {
		bongdenDAO listbBongdenDAO=new bongdenDAO();
		bongden_xuatDAO listBongden_xuatDAO=new bongden_xuatDAO();
		ArrayList<bongden_chung> list=listbBongdenDAO.selecAll();
		ArrayList<bongden_nhap> list2=listBongden_xuatDAO.selecAll();
		int sttphieu=list2.size()+1;
		String maphieu="PX"+sttphieu;
		lichsuxuat.setMaphieu(maphieu);
		
		for(int i=0;i<list.size();i++) {
			if(sp.getMa().equalsIgnoreCase(list.get(i).getMa())&&
					sp.getTen().equalsIgnoreCase(list.get(i).getTen())&&
					sp.getLoai().equalsIgnoreCase(list.get(i).getLoai())&&
					sp.getHang().equalsIgnoreCase(list.get(i).getHang()))
					
				 {	
				if(sp.getSoluong()<=list.get(i).getSoluong())return 2;
				bongden_chung sptam=list.get(i);
				sptam.setSoluong(list.get(i).getSoluong()-sp.getSoluong());
				listbBongdenDAO.update(sptam);
				listBongden_xuatDAO.insert(lichsuxuat);
				return 1;
			}
		}
		return 0;
	}
	public void hienthisanpham(JTable table_1) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_masp(JTable table_1,String masp) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			if(masp.equalsIgnoreCase(list.get(i).getMa()))
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_tensp(JTable table_1,String tensp) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			if(tensp.equalsIgnoreCase(list.get(i).getTen()))
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_loaisp(JTable table_1,String loaisp) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			if(loaisp.equalsIgnoreCase(list.get(i).getLoai()))
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_hangsp(JTable table_1,String hangsp) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			if(hangsp.equalsIgnoreCase(list.get(i).getHang()))
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_masp_tang_giam(JTable table_1,int dulieu) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		if(dulieu==1)
			Collections.sort(list, (o1, o2) -> o1.getMa().compareTo(o2.getMa()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getMa().compareTo(o1.getMa()));
		
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_tensp_tang_giam(JTable table_1,int dulieu) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		if(dulieu==1)
			 Collections.sort(list, (o1, o2) -> o1.getTen().compareTo(o2.getTen()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getTen().compareTo(o1.getTen()));
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_loaisp_tang_giam(JTable table_1,int dulieu) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		if(dulieu==1)
			Collections.sort(list, (o1, o2) -> o1.getLoai().compareTo(o2.getLoai()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getLoai().compareTo(o1.getLoai()));
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_hangsp_tang_giam(JTable table_1,int dulieu) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		if(dulieu==1)
			 Collections.sort(list, (o1, o2) -> o1.getHang().compareTo(o2.getHang()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getHang().compareTo(o1.getHang()));
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_soluong_tang_giam(JTable table_1,int dulieu) {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		if(dulieu==1)
			list.sort((o1, o2) -> o1.getSoluong() - o2.getSoluong());
		else 
			list.sort((o1, o2) -> o2.getSoluong() - o1.getSoluong());
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_loaisp_tang_giam_table(JTable table_1,int dulieu,ArrayList<bongden_chung> list) {
		
		if(dulieu==1)
			Collections.sort(list, (o1, o2) -> o1.getLoai().compareTo(o2.getLoai()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getLoai().compareTo(o1.getLoai()));
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_hangsp_tang_giam_table(JTable table_1,int dulieu,ArrayList<bongden_chung> list) {

		if(dulieu==1)
			 Collections.sort(list, (o1, o2) -> o1.getHang().compareTo(o2.getHang()));
		else 
			 Collections.sort(list, (o1, o2) -> o2.getHang().compareTo(o1.getHang()));
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthisanpham_soluong_tang_giam_table(JTable table_1,int dulieu,ArrayList<bongden_chung> list) {

		if(dulieu==1)
			list.sort((o1, o2) -> o1.getSoluong() - o2.getSoluong());
		else 
			list.sort((o1, o2) -> o2.getSoluong() - o1.getSoluong());
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMa(),list.get(i).getTen(),list.get(i).getLoai(),list.get(i).getHang(),list.get(i).getSoluong()});
		}
	}
	public void hienthilichsusanpham_nhap(JTable table_1) {
		bongden_nhapDAO chucnang=new bongden_nhapDAO();
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMaphieu(),list.get(i).getManvql(),list.get(i).getCurren()});
		}
	}
	public bongden_nhap phieunhap(String maphieu) {
		bongden_nhapDAO chucnang=new bongden_nhapDAO();
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		for(int i=0;i<list.size();i++) {
			if(maphieu.equalsIgnoreCase(list.get(i).getMaphieu()))
				return list.get(i);
		}
		return null;
	}
	public void hienthilichsusanpham_xuat(JTable table_1) {
		bongden_xuatDAO chucnang=new bongden_xuatDAO();
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {i+1,list.get(i).getMaphieu(),list.get(i).getManvql(),list.get(i).getCurren()});
		}
	}
	public bongden_nhap phieuxuat(String maphieu) {
		bongden_xuatDAO chucnang=new bongden_xuatDAO(); 
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		for(int i=0;i<list.size();i++) {
			if(maphieu.equalsIgnoreCase(list.get(i).getMaphieu()))
				return list.get(i);
		}
		return null;
	}
	public int soloai_table(ArrayList<String> dsloai) {
		ArrayList<String> dsrong=new ArrayList<>();
		for(int i=0;i<dsloai.size();i++)
			if(dsrong.contains(dsloai.get(i))==false)
				dsrong.add(dsloai.get(i));
			return dsrong.size();
	}
	public int sohang_table(ArrayList<String> dshang) {
		ArrayList<String> dsrong=new ArrayList<>();
		for(int i=0;i<dshang.size();i++)
			if(dsrong.contains(dshang.get(i))==false)
				dsrong.add(dshang.get(i));
			return dsrong.size();
	}
	public boolean printtoexcel_sp() {
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> list=chucnang.selecAll();
		
		
		XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Danh sách sản phẩm");
        XSSFRow row;
        
        row=sheet.createRow(0);
        Cell cell0=row.createCell(0);
        Cell cell1=row.createCell(1);
        Cell cell2=row.createCell(2);
        Cell cell3=row.createCell(3);
        Cell cell4=row.createCell(4);
        Cell cell5=row.createCell(5);

        
        
        cell0.setCellValue("STT");
        cell1.setCellValue("Mã hàng");
        cell2.setCellValue("Tên hàng");
        cell3.setCellValue("Loại");
        cell4.setCellValue("Hãng sản xuất");
        cell5.setCellValue("Số lượng");

        
        for (int i = 0; i <list.size(); i++) {
            row=sheet.createRow(i+1);
            for (int j = 0; j < 11; j++) {
                Cell cell=row.createCell(j);
                if(cell.getColumnIndex()==0){
                    cell.setCellValue(i+1);
                }
                else if(cell.getColumnIndex()==1){
                    cell.setCellValue(list.get(i).getMa());
                }
                else if(cell.getColumnIndex()==2){
                	cell.setCellValue(list.get(i).getTen());
                }
                else if(cell.getColumnIndex()==3){
                	cell.setCellValue(list.get(i).getLoai());
                }
                else if(cell.getColumnIndex()==4){
                	cell.setCellValue(list.get(i).getHang());
                }
                else if(cell.getColumnIndex()==5){
                	cell.setCellValue((float)list.get(i).getSoluong());
                }

            }
        }   
        
        
        for(int i=0;i<7;i++)
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
	public boolean printtoexcel_lisunhapsp() {
		bongden_nhapDAO chucnang=new bongden_nhapDAO();
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Lịch sử nhập hàng");
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

        
        
        cell0.setCellValue("STT");
        cell1.setCellValue("Mã phiếu");
        cell2.setCellValue("Mã nhân viên quản lí");
        cell3.setCellValue("Mã hàng");
        cell4.setCellValue("Tên hàng");
        cell5.setCellValue("Loại");
        cell6.setCellValue("Hãng sản xuất");
        cell7.setCellValue("Số lượng");
        cell8.setCellValue("Thời gian nhập hàng");

        
        for (int i = 0; i <list.size(); i++) {
            row=sheet.createRow(i+1);
            for (int j = 0; j < 11; j++) {
                Cell cell=row.createCell(j);
                if(cell.getColumnIndex()==0){
                    cell.setCellValue(i+1);
                }
                else if(cell.getColumnIndex()==1){
                    cell.setCellValue(list.get(i).getMaphieu());
                }
                else if(cell.getColumnIndex()==2){
                    cell.setCellValue(list.get(i).getManvql());
                }
                else if(cell.getColumnIndex()==3){
                    cell.setCellValue(list.get(i).getMa());
                }
                else if(cell.getColumnIndex()==4){
                	cell.setCellValue(list.get(i).getTen());
                }
                else if(cell.getColumnIndex()==5){
                	cell.setCellValue(list.get(i).getLoai());
                }
                else if(cell.getColumnIndex()==6){
                	cell.setCellValue(list.get(i).getHang());
                }
                else if(cell.getColumnIndex()==7){
                	cell.setCellValue((float)list.get(i).getSoluong());
                }
                else if(cell.getColumnIndex()==8){
                	cell.setCellValue(list.get(i).getCurren());
                }

            }
        }   
        
        
        for(int i=0;i<8;i++)
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
	public boolean printtoexcel_lisuxuatsp() {
		bongden_xuatDAO chucnang=new bongden_xuatDAO();
		ArrayList<bongden_nhap> list=chucnang.selecAll();
		XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Lịch sử xuất hàng");
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

        
        
        cell0.setCellValue("STT");
        cell1.setCellValue("Mã phiếu");
        cell2.setCellValue("Mã nhân viên quản lí");
        cell3.setCellValue("Mã hàng");
        cell4.setCellValue("Tên hàng");
        cell5.setCellValue("Loại");
        cell6.setCellValue("Hãng sản xuất");
        cell7.setCellValue("Số lượng");
        cell8.setCellValue("Thời gian xuất hàng");

        
        for (int i = 0; i <list.size(); i++) {
            row=sheet.createRow(i+1);
            for (int j = 0; j < 11; j++) {
                Cell cell=row.createCell(j);
                if(cell.getColumnIndex()==0){
                    cell.setCellValue(i+1);
                }
                else if(cell.getColumnIndex()==1){
                    cell.setCellValue(list.get(i).getMaphieu());
                }
                else if(cell.getColumnIndex()==2){
                    cell.setCellValue(list.get(i).getManvql());
                }
                else if(cell.getColumnIndex()==3){
                    cell.setCellValue(list.get(i).getMa());
                }
                else if(cell.getColumnIndex()==4){
                	cell.setCellValue(list.get(i).getTen());
                }
                else if(cell.getColumnIndex()==5){
                	cell.setCellValue(list.get(i).getLoai());
                }
                else if(cell.getColumnIndex()==6){
                	cell.setCellValue(list.get(i).getHang());
                }
                else if(cell.getColumnIndex()==7){
                	cell.setCellValue((float)list.get(i).getSoluong());
                }
                else if(cell.getColumnIndex()==8){
                	cell.setCellValue(list.get(i).getCurren());
                }

            }
        }   
        
        
        for(int i=0;i<7;i++)
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
	public boolean addsp_byexcel(String manvql) {
		bongdenDAO chucnangsp=new bongdenDAO();
		bongden_nhapDAO chucnanglssp=new bongden_nhapDAO();
		
		ArrayList<bongden_chung> dsspmoi=new ArrayList<>();
		ArrayList<bongden_nhap> dslichsuspmoi=new ArrayList<>();
		
		
		
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
					bongden_chung spmoi=new bongden_chung();
					bongden_nhap lichsuspmoi=new bongden_nhap();
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
								spmoi.setMa(cell.getStringCellValue());
								lichsuspmoi.setMa(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==2) {
								spmoi.setTen(cell.getStringCellValue());
								lichsuspmoi.setTen(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==3) {
								spmoi.setLoai(cell.getStringCellValue());
								lichsuspmoi.setLoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								spmoi.setHang(cell.getStringCellValue());
								lichsuspmoi.setHang(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==5) {
								spmoi.setSoluong((int)cell.getNumericCellValue());
								lichsuspmoi.setSoluong((int)cell.getNumericCellValue());
									}
							
						}	
					}
					LocalDateTime current = LocalDateTime.now();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
					String ngaynhap=current.format(dateFormatter);
					
					
					lichsuspmoi.setCurren(ngaynhap);
					lichsuspmoi.setManvql(manvql);
					
					
					dsspmoi.add(spmoi);
					dslichsuspmoi.add(lichsuspmoi);
				} 
				dsspmoi.remove(0);
				dslichsuspmoi.remove(0);
				in.close();
				for(int i=0;i<dsspmoi.size();i++)
					nhapsanpham(dsspmoi.get(i), dslichsuspmoi.get(i));
				return true;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return false;
	}
	public boolean printtoexcel_sploi(ArrayList<bongden_chung> dsspxuatloi) {
		bongdenDAO chucnang=new bongdenDAO();

		XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Danh sách sản phẩm");
        XSSFRow row;
        row=sheet.createRow(0);
        Cell cell0=row.createCell(0);
        Cell cell1=row.createCell(1);
        Cell cell2=row.createCell(2);
        Cell cell3=row.createCell(3);
        Cell cell4=row.createCell(4);
        Cell cell5=row.createCell(5);

        
        
        cell0.setCellValue("STT");
        cell1.setCellValue("Mã hàng");
        cell2.setCellValue("Tên hàng");
        cell3.setCellValue("Loại");
        cell4.setCellValue("Hãng sản xuất");
        cell5.setCellValue("Số lượng");

        
        for (int i = 0; i <dsspxuatloi.size(); i++) {
            row=sheet.createRow(i+1);
            for (int j = 0; j < 11; j++) {
                Cell cell=row.createCell(j);
                if(cell.getColumnIndex()==0){
                    cell.setCellValue(i+1);
                }
                else if(cell.getColumnIndex()==1){
                    cell.setCellValue(dsspxuatloi.get(i).getMa());
                }
                else if(cell.getColumnIndex()==2){
                	cell.setCellValue(dsspxuatloi.get(i).getTen());
                }
                else if(cell.getColumnIndex()==3){
                	cell.setCellValue(dsspxuatloi.get(i).getLoai());
                }
                else if(cell.getColumnIndex()==4){
                	cell.setCellValue(dsspxuatloi.get(i).getHang());
                }
                else if(cell.getColumnIndex()==5){
                	cell.setCellValue((float)dsspxuatloi.get(i).getSoluong());
                }

            }
        }
        for(int i=0;i<7;i++)
        	sheet.autoSizeColumn(i);
        

			try(FileOutputStream outputStream=new FileOutputStream(new File("C:\\Users\\Admin\\OneDrive\\Máy tính\\Danh sach sản phẩm xuất lỗi.xlsx"))) {
				 workbook.write(outputStream);
                 outputStream.close();
                 return true;
                  //System.out.println("Tao file thanh cong");
			}catch (IOException e) {
				return false;
				//System.out.println("That bai");
			}
		}
		
	
	public int outsp_byexcel(String manvql) {
		int kq=1;
		bongdenDAO chucnangsp=new bongdenDAO();
		bongden_xuatDAO chucnanglssp=new bongden_xuatDAO();
		
		ArrayList<bongden_chung> dsspxuat=new ArrayList<>();
		ArrayList<bongden_nhap> dslichsuspxuat=new ArrayList<>();
		
		
		
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
					bongden_chung spmoi=new bongden_chung();
					bongden_nhap lichsuspmoi=new bongden_nhap();
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
								spmoi.setMa(cell.getStringCellValue());
								lichsuspmoi.setMa(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==2) {
								spmoi.setTen(cell.getStringCellValue());
								lichsuspmoi.setTen(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==3) {
								spmoi.setLoai(cell.getStringCellValue());
								lichsuspmoi.setLoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								spmoi.setHang(cell.getStringCellValue());
								lichsuspmoi.setHang(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==5) {
								spmoi.setSoluong((int)cell.getNumericCellValue());
								lichsuspmoi.setSoluong((int)cell.getNumericCellValue());
									}
							
						}	
					}
					LocalDateTime current = LocalDateTime.now();
					DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
					String ngaynhap=current.format(dateFormatter);
					
					lichsuspmoi.setManvql(manvql);
					lichsuspmoi.setCurren(ngaynhap);
					
					
					dsspxuat.add(spmoi);
					dslichsuspxuat.add(lichsuspmoi);
				} 
				dsspxuat.remove(0);
				dslichsuspxuat.remove(0);
				in.close();
				ArrayList<bongden_chung> dsspxuatloi=new ArrayList<>();
				for(int i=0;i<dsspxuat.size();i++)
					if(xuatsanpham(dsspxuat.get(i),dslichsuspxuat.get(i))==0)
					{
						dsspxuatloi.add(dsspxuat.get(i));
						kq=2;
					}
				printtoexcel_sploi(dsspxuatloi);
				return kq;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return kq;
	}
	public boolean updatebyexcel() {
		boolean kq=true;
		bongdenDAO chucnang=new bongdenDAO();
		ArrayList<bongden_chung> dssp=new ArrayList<>();

		
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
					bongden_chung sp=new bongden_chung();
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
									
									sp.setMa(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==2) {
								
									sp.setTen(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==3) {
								
									sp.setLoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								
									sp.setHang(cell.getStringCellValue());

									}
							else if(cell.getColumnIndex()==5) {
								
									sp.setSoluong((int)cell.getNumericCellValue());
									}
							
							
						}	
					}
					dssp.add(sp);
				} 
				dssp.remove(0);
				in.close();
				chucnang.delete_all();
				
				for(int i=0;i<dssp.size();i++)
				{
					chucnang.insert(dssp.get(i));
				}
				
				return kq;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return kq;
	}
	public boolean updatebyexcel_lsnhap() {
		boolean kq=true;
		bongden_nhapDAO chucnang=new bongden_nhapDAO();
		ArrayList<bongden_nhap> dssp=new ArrayList<>();

		
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
					bongden_nhap sp=new bongden_nhap();
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
								
									sp.setMaphieu(cell.getStringCellValue());
								}
							else if(cell.getColumnIndex()==2) {
								
								sp.setManvql(cell.getStringCellValue());
								}
							else if(cell.getColumnIndex()==3) {
									
									sp.setMa(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								
									sp.setTen(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==5) {
								
									sp.setLoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==6) {
								
									sp.setHang(cell.getStringCellValue());

									}
							else if(cell.getColumnIndex()==7) {
								
									sp.setSoluong((int)cell.getNumericCellValue());
									}
							else if(cell.getColumnIndex()==8) {
								
									sp.setCurren(cell.getStringCellValue());
								}
							
							
						}	
					}
					dssp.add(sp);
				} 
				dssp.remove(0);
				in.close();
				chucnang.delete_all();
				
				for(int i=0;i<dssp.size();i++)
				{
					chucnang.insert(dssp.get(i));
				}
				
				return kq;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return kq;
	}
	public boolean updatebyexcel_lsxuat() {
		boolean kq=true;
		bongden_xuatDAO chucnang=new bongden_xuatDAO();
		ArrayList<bongden_nhap> dssp=new ArrayList<>();

		
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
					bongden_nhap sp=new bongden_nhap();
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
								
									sp.setMaphieu(cell.getStringCellValue());
								}
							else if(cell.getColumnIndex()==2) {
								
								sp.setManvql(cell.getStringCellValue());
								}
							else if(cell.getColumnIndex()==3) {
									
									sp.setMa(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==4) {
								
									sp.setTen(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==5) {
								
									sp.setLoai(cell.getStringCellValue());
									}
							else if(cell.getColumnIndex()==6) {
								
									sp.setHang(cell.getStringCellValue());

									}
							else if(cell.getColumnIndex()==7) {
								
									sp.setSoluong((int)cell.getNumericCellValue());
									}
							else if(cell.getColumnIndex()==8) {
								
									sp.setCurren(cell.getStringCellValue());
								}
							
							
						}	
					}
					dssp.add(sp);
				} 
				dssp.remove(0);
				in.close();
				chucnang.delete_all();
				
				for(int i=0;i<dssp.size();i++)
				{
					chucnang.insert(dssp.get(i));
				}
				
				return kq;
			}catch (IOException e) {
				System.out.println("That bai");
			}
		}
		return kq;
	}
	public String[] masp_xuat() {
		bongdenDAO chucnangsp=new bongdenDAO();
		ArrayList<bongden_chung> ds=chucnangsp.selecAll();
		String[] list=new String[ds.size()];
		for(int i=0;i<ds.size();i++)
			list[i]=ds.get(i).getMa();
		return list;
	}
	public String[] tensp_xuat() {
		bongdenDAO chucnangsp=new bongdenDAO();
		ArrayList<bongden_chung> ds=chucnangsp.selecAll();
		String[] list=new String[ds.size()];
		for(int i=0;i<ds.size();i++)
			list[i]=ds.get(i).getTen();
		return list;
	}
	public String[] loaisp_xuat() {
		bongdenDAO chucnangsp=new bongdenDAO();
		ArrayList<bongden_chung> ds=chucnangsp.selecAll();
		ArrayList<String> dstam=new ArrayList<>();
		for(int i=0;i<ds.size();i++)
			if(dstam.contains(ds.get(i).getLoai())==false)
				dstam.add(ds.get(i).getLoai());
		
		
		String[] list=new String[dstam.size()];
		for(int i=0;i<dstam.size();i++)
			list[i]=dstam.get(i);
		return list;
	}
	public String[] hangsx_xuat() {
		bongdenDAO chucnangsp=new bongdenDAO();
		ArrayList<bongden_chung> ds=chucnangsp.selecAll();
		
		
		ArrayList<String> dstam=new ArrayList<>();
		for(int i=0;i<ds.size();i++)
			if(dstam.contains(ds.get(i).getHang())==false)
				dstam.add(ds.get(i).getHang());
		String[] list=new String[dstam.size()];
		for(int i=0;i<dstam.size();i++)
			list[i]=dstam.get(i);
		return list;
	}
}
