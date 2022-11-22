package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BongDen.bongden_nhap;
import connectMySql.JDBCUtil;

public class bongden_xuatDAO implements DAOinterface<bongden_nhap> {

	private int check=0;
	@Override
	public int insert(bongden_nhap t) {
		try {
			//b1:ket noi co so du lieu
			Connection con=JDBCUtil.getConnection();
			//b2:tao doi tuong statement
			Statement st=con.createStatement();
			//b3:thuc thi cau lenh sql
			String sql="insert into phieuxuatsanpham2(maphieu,manvql,mahang,tenhang,loai,hang,soluong,ngayxuat)"+
						" values('"+t.getMaphieu()+"','"+t.getManvql()+"','"+t.getMa()+"','"+t.getTen()+"','"+t.getLoai()+"','"
					+t.getHang()+"',"+t.getSoluong()+",'"+t.getCurren()+"')";
			this.check += st.executeUpdate(sql);
			
			// b4
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
}

	@Override
	public int update(bongden_nhap t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "UPDATE phieuxuatsanpham2 "+
					" SET " +
					 " manv='"+ t.getManvql()+"'"+
					 ", mahang='"+ t.getMa()+"'"+
					 ", tenhang='"+ t.getTen()+"'"+
					 ", loai='"+ t.getLoai()+"'"+
					 ",hangsx='"+ t.getHang()+"'"+
					 ",soluong="+ t.getSoluong()+
					 ",ngaynhap='"+ t.getCurren()+"'"+
					 " WHERE maphieu='"+t.getMaphieu()+"\'";
			ketQua = st.executeUpdate(sql);
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(bongden_nhap t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "DELETE from phieuxuatsanpham2 "+
						 " WHERE maphieu='"+t.getMaphieu()+"'";
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
	public ArrayList<bongden_nhap> selecAll() {
		ArrayList<bongden_nhap> ketQua = new ArrayList<bongden_nhap>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();
			
			// Bước 2: tạo ra đối tượng statement
			Statement st = con.createStatement();
			
			// Bước 3: thực thi câu lệnh SQL
			
			String sql = "SELECT * FROM phieuxuatsanpham2";
			//System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			// Bước 4:
			while(rs.next()) {
				String maphieu=rs.getString("maphieu");
				String manvql = rs.getString("manvql");
				String mahang = rs.getString("mahang");
				String tenhang = rs.getString("tenhang");
				String loai = rs.getString("loai");
				String hang = rs.getString("hang");
				int soluong = rs.getInt("soluong");	
				String ngaynhap = rs.getString("ngayxuat");
				bongden_nhap sp=new bongden_nhap(maphieu,manvql,mahang, tenhang, loai, hang, soluong,ngaynhap);
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
	public bongden_nhap selectById(bongden_nhap t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<bongden_nhap> selecByCondition(String condition) {
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
			
			String sql = "DELETE from phieuxuatsanpham2 ";
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
