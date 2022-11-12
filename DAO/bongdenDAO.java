package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BongDen.bongden_chung;
import TaiKhoan.User;
import connectMySql.JDBCUtil;

public class bongdenDAO implements DAOinterface<bongden_chung> {
	private int check=0;
	@Override
	public int insert(bongden_chung t) {
		try {
			//b1:ket noi co so du lieu
			Connection con=JDBCUtil.getConnection();
			//b2:tao doi tuong statement
			Statement st=con.createStatement();
			//b3:thuc thi cau lenh sql
			String sql="insert into khohang(mahang,tenhang,loai,hangsx,soluong)"+
						"values('"+t.getMa()+"','"+t.getTen()+"','"+t.getLoai()+"','"+t.getHang()+"',"+t.getSoluong()+")";
			this.check += st.executeUpdate(sql);
			
		
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(bongden_chung t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE khohang "+
						 " SET " +
						 " tenhang='"+ t.getTen()+"'"+
						 ", loai='"+ t.getLoai()+"'"+
						 ",hangsx='"+ t.getHang()+"'"+
						 ",soluong="+ t.getSoluong()+
						 " WHERE mahang='"+t.getMa()+"\'";
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(bongden_chung t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from khohang "+
						 " WHERE mahang='"+t.getMa()+"'";
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
	public ArrayList<bongden_chung> selecAll() {
		ArrayList<bongden_chung> ketQua = new ArrayList<bongden_chung>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM khohang";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String mahang = rs.getString("mahang");
				String tenhang = rs.getString("tenhang");
				String loai = rs.getString("loai");
				String hang = rs.getString("hangsx");
				int soluong = rs.getInt("soluong");			
				bongden_chung sp=new bongden_chung(mahang, tenhang, loai, hang, soluong);
				ketQua.add(sp);
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
	public bongden_chung selectById(bongden_chung t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<bongden_chung> selecByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
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
			
			String sql = "DELETE from khohang ";
						
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
	
}
