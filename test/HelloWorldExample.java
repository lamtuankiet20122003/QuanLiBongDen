package test;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.UserDAO;
import TaiKhoan.User;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.print.attribute.standard.PageRanges;

import org.bouncycastle.util.encoders.UTF8;

import java.io.FileNotFoundException;

public class HelloWorldExample {

    public static void main(String[] args) {
		// tạo một document
        Document document = new Document();
        UserDAO chucnang=new UserDAO();
        ArrayList<User> dstk=chucnang.selecAll();
        try {
        	// khởi tạo một PdfWriter truyền vào document và FileOutputStream
            PdfWriter.getInstance(document, new FileOutputStream("thongtintaikhoan.pdf"));

            // mở file để thực hiện viết
            document.open();
            // thêm nội dung sử dụng add function
            //document.add(new Paragraph("A Hello World PDF document."));
            //Khởi tạo một table có 3 cột
            PdfPTable table = new PdfPTable(11);
        	//Khởi tạo 3 ô header
            PdfPCell header1 = new PdfPCell(new Paragraph("Stt"));
            PdfPCell header2 = new PdfPCell(new Paragraph("Mã nhân viên"));
            PdfPCell header3 = new PdfPCell(new Paragraph("Tên nhân viên"));
            PdfPCell header4 = new PdfPCell(new Paragraph("Giới tính"));
            PdfPCell header5 = new PdfPCell(new Paragraph("Địa chỉ"));
            PdfPCell header6 = new PdfPCell(new Paragraph("Số điện thoại"));
            PdfPCell header7 = new PdfPCell(new Paragraph("Email"));
            PdfPCell header8 = new PdfPCell(new Paragraph("Ngày sinh"));
            PdfPCell header9 = new PdfPCell(new Paragraph("Tài khoản"));
            PdfPCell header10 = new PdfPCell(new Paragraph("Mật khẩu"));
            PdfPCell header11 = new PdfPCell(new Paragraph("Chức vụ"));
        	//Thêm 3 ô header vào table
            table.addCell(header1);
            table.addCell(header2);
            table.addCell(header3);
            table.addCell(header4);
            table.addCell(header5);
            table.addCell(header6);
            table.addCell(header7);
            table.addCell(header8);
            table.addCell(header9);
            table.addCell(header10);
            table.addCell(header11);

            for(int i=0;i<dstk.size();i++) {
            	int stt=i+1;
            	String s = String.valueOf(stt);
            	PdfPCell data1 = new PdfPCell(new Paragraph(s));
                PdfPCell data2 = new PdfPCell(new Paragraph(dstk.get(i).getManv()));
                PdfPCell data3 = new PdfPCell(new Paragraph(dstk.get(i).getTennv()));
                PdfPCell data4 = new PdfPCell(new Paragraph(dstk.get(i).getGioitinh()));
                PdfPCell data5 = new PdfPCell(new Paragraph(dstk.get(i).getDiachi()));
                PdfPCell data6 = new PdfPCell(new Paragraph(dstk.get(i).getSodienthoai()));
                PdfPCell data7 = new PdfPCell(new Paragraph(dstk.get(i).getEmail()));
                PdfPCell data8 = new PdfPCell(new Paragraph(dstk.get(i).getNgaysinh()));
                PdfPCell data9 = new PdfPCell(new Paragraph(dstk.get(i).getUser()));
                PdfPCell data10 = new PdfPCell(new Paragraph(dstk.get(i).getPassword()));
                PdfPCell data11 = new PdfPCell(new Paragraph(dstk.get(i).getLoai()));
                table.addCell(data1);
                table.addCell(data2);
                table.addCell(data3);
                table.addCell(data4);
                table.addCell(data5);
                table.addCell(data6);
                table.addCell(data7);
                table.addCell(data8);
                table.addCell(data9);
                table.addCell(data10);
                table.addCell(data11);
            }
        	//Khởi tạo 3 ô data: ô số 1 là string, ô số 2 là ảnh, ô số 3 là table



           
        	//Thêm data vào bảng.
           
            


            document.add(table);
            // đóng file
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}