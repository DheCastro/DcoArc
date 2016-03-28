package br.com.triadworks.bugtracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.bugtracker.modelo.EntidadeBase;

@Transactional
@Repository
public class DaoGenerico<T extends EntidadeBase> {

	@PersistenceContext
	private EntityManager manager;

	public void adiciona(T t) {
		manager.persist(t);
	}

	public void atualiza(T t) {
		manager.merge(t);
	}

	public void remove(T t) {
		manager.remove(manager.merge(t));
	}

	public T busca(Class<T> clazz, Integer id) {
		return manager.find(clazz, id);
	}
	
	public List<T> lista(Class<T> clazz, String query){
		List<T> lista = manager.createQuery(query, clazz).getResultList();
		
		if(lista.isEmpty() || lista.size() == 0){
			return null;
		}
		
		return lista;
	}

}
