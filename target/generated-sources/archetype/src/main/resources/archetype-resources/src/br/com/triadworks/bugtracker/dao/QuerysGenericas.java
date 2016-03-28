#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package br.com.triadworks.bugtracker.dao;

public class QuerysGenericas {

	public static String LISTA_USUARIOS(){
		return "select u from Usuario u";
	}
}
