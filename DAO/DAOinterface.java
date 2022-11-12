package DAO;

import java.util.ArrayList;

import TaiKhoan.User;

public interface DAOinterface<T> {
	public int insert(T t);
	public int update(T t);
	public int delete(T t);
	public int delete_all();
	public ArrayList<T> selecAll();
	public T selectById(T t);
	public ArrayList<T> selecByCondition(String condition);
	
}
