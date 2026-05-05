package Controller;

import java.util.ArrayList;

public interface Controller <T, V> {

	public int add(int id, String name, V marks);
	public ArrayList<T> getall();
	public int delete(int id);
	public T findById(int id);
	public int getCount();
	
}
