package BongDen;

import java.time.LocalDateTime;

public class bongden_nhap extends bongden_chung {
	private String maphieu;
	private String curren;
	private String manvql;
	public bongden_nhap() {}
	public bongden_nhap(String maphieu,String manvql,String ma, String ten, String loai, String hang, int soluong,String current) {
		super(ma, ten, loai, hang, soluong);
		this.maphieu=maphieu;
		this.curren=current;
		this.manvql=manvql;
	}
	public String getCurren() {
		return curren;
	}
	public void setCurren(String curren) {
		this.curren = curren;
	}
	
	public String getMaphieu() {
		return maphieu;
	}
	public void setMaphieu(String maphieu) {
		this.maphieu = maphieu;
	}
	
	public String getManvql() {
		return manvql;
	}
	public void setManvql(String manvql) {
		this.manvql = manvql;
	}
	@Override
	public String toString() {
		
		return "bongden_chung [maphieu="+this.getMaphieu()+"nguoiquanli="+this.getManvql()+",masp=" + this.getMa() + ", ten=" + this.getTen() + 
				", loai=" + this.getLoai() + ", hang=" +this.getHang() + ", soluong=" + this.getSoluong()	
				+ ", Ngày nhập=" + this.getCurren()+"]";
	}
	
}
