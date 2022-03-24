package com.hibernate.dao;

import java.sql.ResultSet;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;

public class StudentDao {
public void saveStudent(Student student)
{
	Transaction trans = null;
	try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		trans = session.beginTransaction();
		session.save(student);
		trans.commit();
		}
	catch(Exception e)
	{
		if(trans != null)
		{
			trans.rollback();
		}
		e.printStackTrace();
	}
}
public void updateStudent(String name,long id)
{
	Transaction trans = null;
	try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		trans = session.beginTransaction();
		Query q = session.createQuery("update Student set first_name=:name where id=:id");
		q.setParameter("name", name);
		q.setParameter("id", id);
		
		int i = q.executeUpdate();
		if(i>0)
		{
			System.out.println("updated successfully");
		}
	
		//session.save(q);
		trans.commit();
		}
	catch(Exception e)
	{
		if(trans != null)
		{
			trans.rollback();
		}
		e.printStackTrace();
	}
}
public void getStudent() {
	
}
public void DeleteStudent(long id)
{
	Transaction trans = null;
	try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		trans = session.beginTransaction();
		Query q = session.createQuery("delete from Student  where id=:id");
		q.setParameter("id", id);
		int i = q.executeUpdate();
		if(i>0)
		{
			System.out.println("Deleted successfully");
		}
	
		//session.save(q);
		trans.commit();
		}
	catch(Exception e)
	{
		if(trans != null)
		{
			trans.rollback();
		}
		e.printStackTrace();
	}

}
public void selectStudent(long id)
{
	Transaction trans = null;
	try{
		Session session = HibernateUtil.getSessionFactory().openSession();
		trans = session.beginTransaction();
		Query q = session.createQuery("from Student where id=:id");
		q.setParameter("id", id);
		List<Student> l1 = q.getResultList();
		for(Student s : l1)
		{
			System.out.println(s.getId()+" "+s.getFname()+" "+s.getLname()+" "+s.getEmail());
			 
		}
		 
	
		//session.save(q);
		trans.commit();
		}
	catch(Exception e)
	{
		if(trans != null)
		{
			trans.rollback();
		}
		e.printStackTrace();
	}
}
}
