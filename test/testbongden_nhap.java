package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import BongDen.bongden_nhap;
import DAO.bongden_nhapDAO;
import DAO.bongden_xuatDAO;
import TaiKhoan.User;

public class testbongden_nhap {

	public static void main(String[] args) {
		bongden_nhapDAO list=new bongden_nhapDAO();
		bongden_xuatDAO list2=new bongden_xuatDAO();
		LocalDateTime current = LocalDateTime.now();
		DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		String ngaynhap=current.format(dateFormatter);
		bongden_nhap sp=new bongden_nhap("PX999","ADMIn","BD1","Bong den","Soi dot","PHILIPS",1000, ngaynhap);
		list.insert(sp);
		//System.out.println(sp);
		//list.insert(sp);
        //System.out.println(sp.getCurren());
		//System.out.println(current);
		/*ArrayList<bongden_nhap> list1 = list.selecAll();
		for (bongden_nhap sp : list1) {
			System.out.println(sp.toString());
		}*/
		//System.out.println("hello"+1+1);
	}
	
}
