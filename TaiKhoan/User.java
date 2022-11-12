
package TaiKhoan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class User implements Comparable<User>,Serializable{
	private String manv;
	private String tennv;
	private String gioitinh;
	private String diachi;
	private String sodienthoai;
	private String email;
	private String ngaysinh;
	private String user;
    private String password;
    private String loai;
    public User() {
    }
	public User(String manv, String tennv, String gioitinh, String diachi, String sodienthoai, String email,
			String ngaysinh, String user, String password, String loai) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sodienthoai = sodienthoai;
		this.email = email;
		this.ngaysinh = ngaysinh;
		this.user = user;
		this.password = password;
		this.loai = loai;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodienthoai() {
		return sodienthoai;
	}
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	@Override
	public String toString() {
		return "User [manv=" + manv + ", tennv=" + tennv + ", gioitinh=" + gioitinh + ", diachi=" + diachi
				+ ", sodienthoai=" + sodienthoai + ", email=" + email + ", ngaysinh=" + ngaysinh + ", user=" + user
				+ ", password=" + password + ", loai=" + loai + "]";
	}
	@Override
	public int compareTo(User o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
   
}
