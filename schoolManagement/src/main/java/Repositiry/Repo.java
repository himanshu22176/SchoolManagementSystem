package Repositiry;

import java.util.ArrayList;


public interface Repo <T>{
	public boolean add(T s);
	public ArrayList<T> getAll();
	public boolean delete(int id);
	public T findById(int id);
	public int getCount();
}
