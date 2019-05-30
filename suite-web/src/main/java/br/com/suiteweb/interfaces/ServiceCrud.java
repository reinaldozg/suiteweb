package br.com.suiteweb.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface ServiceCrud <T, ID> {

	public void delete(T entity);
	public T obter(ID id);
	public List<T> Lista();
	public Page<T> Lista(String paramLike, PageRequest page);
	public Page<T> Lista(PageRequest page);
	public T salva(T entity);
	public List<T> salva(List<T> entitys);	
	
}
