/**
 * 
 */
package main.com.familyTree.nodes;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author A7med Al-Dakrory
 *
 */
@Repository
@Transactional
public class nodeRepositoryImpl implements nodeRepository{

	@Autowired
	private SessionFactory sessionFactory;
	Session session; 
	

	

	@Override
	public node addnode(node data) {
		try{
			data.setLastUpdate(Calendar.getInstance());
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.saveOrUpdate(data);
			tx1.commit();
			session.close(); 
			return data; 
			}
			catch(Exception ex)
			{
				System.out.println(">>>>>>>>>>");
				ex.printStackTrace();
				return null;
			}
	}

	@Override
	public List<node> getAll() {
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("node.getAll");

				 @SuppressWarnings("unchecked")
				List<node> results=query.list();
				 if(results.size()!=0){
					 return results;
				 }else{
					 return null;
				 }
	}

	
	@Override
	public boolean delete(node data) throws Exception {
		// TODO Auto-generated method stub
		try {
			session = sessionFactory.openSession();
			Transaction tx1 = session.beginTransaction();
			session.delete(data);
			tx1.commit();
			session.close();
			return true;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public node getById(int id) {
		// TODO Auto-generated method stub
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("node.getById").setInteger("id",id);

		 @SuppressWarnings("unchecked")
		List<node> results=query.list();
		 if(results.size()!=0){
			 return results.get(0);
		 }else{
			 return null;
		 }
	}

	@Override
	public node getByNameAndFatherAndGrand(String name,String father, String grand){
		// TODO Auto-generated method stub
				 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("node.getByNameAndFatherAndGrand").setString("firstName", name)
						 .setString("fatherIdName", father).setString("grandPaIdName", grand);

				 @SuppressWarnings("unchecked")
				List<node> results=query.list();
				 if(results.size()!=0){
					 return results.get(0);
				 }else{
					 return null;
				 }
	}

	@Override
	public List<node> getSonsOfParent(int id) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("node.getSonsOfParent").setInteger("fatherId", id);

		 @SuppressWarnings("unchecked")
		List<node> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}

	@Override
	public List<node> getSonsOfGrand(int id) {
		 Query query 	=sessionFactory.getCurrentSession().getNamedQuery("node.getSonsOfGrand").setInteger("grandPaId", id);

		 @SuppressWarnings("unchecked")
		List<node> results=query.list();
		 if(results.size()!=0){
			 return results;
		 }else{
			 return null;
		 }
	}
	

}
