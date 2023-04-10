package dao;

import java.util.List;

// T represente l'objet et K represente la variable
public interface IDAO <T,K>{

	public T findById(K Id);
	public List <T> findAll();
	public void delete( K Id);
	public void save(T ob);
}