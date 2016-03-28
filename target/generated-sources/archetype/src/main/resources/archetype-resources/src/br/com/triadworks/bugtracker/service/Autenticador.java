#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package br.com.triadworks.bugtracker.service;

import br.com.triadworks.bugtracker.modelo.Usuario;

public interface Autenticador {

	public Usuario autentica(String login, String senha);
	
}