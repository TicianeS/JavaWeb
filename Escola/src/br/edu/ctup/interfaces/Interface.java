package br.edu.ctup.interfaces;

import java.util.List;

public interface Interface <T, E> {

	public String cadastrar(T t);
	
	public String alterar(T t);
	
	public String excluir(T t);
	
	public List<E> listarTodos();
	
}
