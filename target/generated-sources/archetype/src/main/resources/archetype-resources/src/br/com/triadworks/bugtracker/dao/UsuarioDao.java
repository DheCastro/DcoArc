#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package br.com.triadworks.bugtracker.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.triadworks.bugtracker.modelo.Usuario;

@Transactional
@Repository
public class UsuarioDao extends DaoGenerico<Usuario>{

	@PersistenceContext
	private EntityManager manager;
	
	public List<Usuario> lista() {
		
			return manager.createQuery("select u from Usuario u", Usuario.class)
					.getResultList();
	}

	public Usuario buscaPor(String login, String senha) {
		try {
			return manager
					.createQuery(
							"select u from Usuario u "
									+ "where u.login = :login and u.senha = :senha", Usuario.class)
					.setParameter("login", login)
					.setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
