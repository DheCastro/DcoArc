#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package br.com.triadworks.bugtracker.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.triadworks.bugtracker.dao.QuerysGenericas;
import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.FacesUtils;

@Controller
@Scope("request")
public class UsuarioBean {

	@Autowired
	private UsuarioDao dao;
	
	@Autowired
	private FacesUtils facesUtil;
	
	private Usuario usuario = new Usuario();
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario getUsuario(){
		return this.usuario;
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public void adiciona(){
		dao.adiciona(this.usuario);
		this.usuario = new Usuario();
		facesUtil.adicionaMensagemDeSucesso("Usu�rio adicionado com sucesso!");
	}
	
	public void lista(){
		this.usuarios = dao.lista(Usuario.class, QuerysGenericas.LISTA_USUARIOS());
	}
	
	public void remove(Usuario usuario){
		dao.remove(usuario);
		this.usuarios = dao.lista(Usuario.class, QuerysGenericas.LISTA_USUARIOS());
		facesUtil.adicionaMensagemDeSucesso("Usu�rio removido com sucesso!");
	}
	
	public void atualiza(){
		dao.atualiza(this.usuario); 
		facesUtil.adicionaMensagemDeSucesso("Usu�rio atualizado com sucesso!");
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDao getDao() {
		return dao;
	}

	public void setDao(UsuarioDao dao) {
		this.dao = dao;
	}

	public FacesUtils getFacesUtil() {
		return facesUtil;
	}

	public void setFacesUtil(FacesUtils facesUtil) {
		this.facesUtil = facesUtil;
	}
}
