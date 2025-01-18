package DAO;

import java.util.List;

public interface IDAO<T> {
	
	public boolean Create(T o);
	public boolean Update(T o);
	public boolean Delete(T o);
	public T findById(int id);
	public List<T> findAll();
	
}
