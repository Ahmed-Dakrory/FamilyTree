/**
 * 
 */
package main.com.familyTree.nodes;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Ahmed.Dakrory
 *
 */
@Service("nodeFacadeImpl")
public class nodeAppServiceImpl implements InodeAppService{

	@Autowired
	nodeRepository nodeDataRepository;
	
	
	@Override
	public List<node> getAll() {
		try{
			List<node> course=nodeDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public node addnode(node data) {
		try{
			node data2=nodeDataRepository.addnode(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(node data) throws Exception{
		// TODO Auto-generated method stub
		try{
			nodeDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public node getById(int id) {
		// TODO Auto-generated method stub
		try{
			node so=nodeDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public node getByNameAndFatherAndGrandAndFamily(String name,String father, String grand,String familyName) {
		// TODO Auto-generated method stub
				try{
					node so=nodeDataRepository.getByNameAndFatherAndGrandAndFamily(name, father, grand, familyName);
					
					return so;
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
						return null;
					}
	}



	@Override
	public List<node> getSonsOfParent(int id) {
		try{
			List<node> course=nodeDataRepository.getSonsOfParent(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	@Override
	public List<node> getSonsOfGrand(int id) {
		try{
			List<node> course=nodeDataRepository.getSonsOfGrand(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}
	

	
}
		
		

	
		
	


