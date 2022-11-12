package BongDen;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

import TaiKhoan.User;

public class bongden_chung implements Comparable<bongden_chung>,Serializable {
	private String ma;
	private String ten;
	private String loai;
	private String hang;
	private int soluong;
	public bongden_chung() {}
	
	public bongden_chung(String ma, String ten, String loai, String hang, int soluong) {
		this.ma = ma;
		this.ten = ten;
		this.loai = loai;
		this.hang = hang;
		this.soluong = soluong;

	}


	public String getMa() {
		return ma;
	}


	public void setMa(String ma) {
		this.ma = ma;
	}


	public String getTen() {
		return ten;
	}


	public void setTen(String ten) {
		this.ten = ten;
	}


	public String getLoai() {
		return loai;
	}


	public void setLoai(String loai) {
		this.loai = loai;
	}


	public String getHang() {
		return hang;
	}


	public void setHang(String hang) {
		this.hang = hang;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	@Override
	public int hashCode() {
		return Objects.hash(hang, loai, ma, soluong, ten);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		bongden_chung other = (bongden_chung) obj;
		return Objects.equals(hang, other.hang) && Objects.equals(loai, other.loai) && Objects.equals(ma, other.ma)
				&& soluong == other.soluong && Objects.equals(ten, other.ten);
	}


	@Override
	public String toString() {
		return "bongden_chung [ma=" + ma + ", ten=" + ten + ", loai=" + loai + ", hang=" + hang + ", soluong=" + soluong
				+ "]";
	}


	@Override
	public int compareTo(bongden_chung o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
