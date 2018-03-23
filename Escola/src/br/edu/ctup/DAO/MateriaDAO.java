package br.edu.ctup.DAO;

import java.util.List;

import br.edu.ctup.interfaces.Interface;
import br.edu.ctup.model.Aluno;
import br.edu.ctup.model.Materia;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class MateriaDAO extends DAO implements Interface{

	@Override
	public String cadastrar(Object t) {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return "sucesso";
		}
		catch (Exception e) 
		{
			em.getTransaction().rollback();
		}
		
		return null;
	}

	@Override
	public String alterar(Object t) {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
			return "sucesso";
		}
		catch (Exception e) 
		{
			em.getTransaction().rollback();
		}
		
		return null;
	}

	@Override
	public String excluir(Object t) {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
			return "sucesso";
		}
		catch (Exception e) 
		{
			em.getTransaction().rollback();
		}
		
		return null;
	}

	@Override
	public List<?> listarTodos() {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		
		try
		{
			Query q = em.createQuery("select object(m) from Materia as m");
			
			List<?> materias = q.getResultList();
			
			return materias;
		}
		finally
		{
			em.close();
		}
		
	}
	
	
	public List<Materia> pesquisarMateria(String nome) {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		
		try
		{
			Query q = em.createQuery("select object(m) from Materia as m WHERE m.nome LIKE '%"+nome+"%'");
			
			List<Materia> materias = q.getResultList();
			
			return materias;
		}
		finally
		{
			em.close();
		}

	}

}
