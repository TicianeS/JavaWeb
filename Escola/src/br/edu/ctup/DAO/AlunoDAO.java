package br.edu.ctup.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ctup.interfaces.Interface;
import br.edu.ctup.model.Aluno;


public class AlunoDAO extends DAO implements Interface{

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
			Query q = em.createQuery("select object(a) from Aluno as a");
			
			List<?> alunos = q.getResultList();
			
			return alunos;
		}
		finally
		{
			em.close();
		}

	}
	
	public List<Aluno> pesquisarAluno(String nome) {
		// TODO Auto-generated method stub
		
		EntityManager em = getEntityManager();
		
		try
		{
			Query q = em.createQuery("select object(a) from Aluno as a WHERE a.nome LIKE '%"+nome+"%'");
			
			List<Aluno> alunos = q.getResultList();
			
			return alunos;
		}
		finally
		{
			em.close();
		}

	}
	

}
