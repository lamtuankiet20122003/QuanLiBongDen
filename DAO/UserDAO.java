package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import connectMySql.*;

import TaiKhoan.User;

public class UserDAO implements DAOinterface<User> {
	private int check=0;
	@Override
	//them nv vao csdl
	public int insert(User t) {
		try {
			//b1:ket noi co so du lieu
			Connection con=JDBCUtil.getConnection();
			//b2:tao doi tuong statement
			Statement st=con.createStatement();
			//b3:thuc thi cau lenh sql
			String sql="insert into thongtintaikhoan(manv,tennv,gioitinh,diachi,sdt,email,ngaysinh,user,pass,chucvu)"+
						"values('"+t.getManv()+"','"+t.getTennv()+"','"
						+t.getGioitinh()+"','"+t.getDiachi()+"','"+t.getSodienthoai()+"','"
						+t.getEmail()+"','"+t.getNgaysinh()+"','"
						+t.getUser()+"','"+t.getPassword()+"','"+t.getLoai()+"')";
			this.check += st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//cap nhat thong tin nhan vien theo manv
	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE thongtintaikhoan "+
						 " SET " +
						 " tennv='"+ t.getTennv()+"'"+
						 ",gioitinh='"+ t.getGioitinh()+"'"+
						 ", diachi='"+ t.getDiachi()+"'"+
						 ",	sdt='"+ t.getSodienthoai()+"'"+
						 ", email='"+ t.getEmail()+"'"+
						 ", ngaysinh='"+ t.getNgaysinh()+"'"+
						 ", user='"+ t.getUser()+"'"+
						 ", pass='"+ t.getPassword()+"'"+
						 ", chucvu='"+ t.getLoai()+"'"+
						 " WHERE manv='"+t.getManv()+"\'";

			ketQua = st.executeUpdate(sql);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	//xoa nhan theo manv
	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from thongtintaikhoan "+
						 " WHERE manv='"+t.getManv()+"'";
			System.out.println(sql);
			ketQua = st.executeUpdate(sql);
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}
	@Override
	public int delete_all() {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from thongtintaikhoan ";
						 

			ketQua = st.executeUpdate(sql);
			
			// Bước 4:

			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList<User> selecAll() {
		ArrayList<User> ketQua = new ArrayList<User>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM thongtintaikhoan";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String manv = rs.getString("manv");
				String tennv = rs.getString("tennv");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				String sdt = rs.getString("sdt");
				String email = rs.getString("email");
				//ngay sinh
				String ngaysinh=rs.getString("ngaysinh");
				String username = rs.getString("user");
				String password = rs.getString("pass");
				String chucvu = rs.getString("chucvu");				
				User user= new User(manv, tennv, gioitinh, diachi, sdt, email, ngaysinh, username, password, chucvu);
				ketQua.add(user);
			}
			
			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<User> selecByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
