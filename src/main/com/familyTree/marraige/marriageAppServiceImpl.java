/**
 * 
 */
package main.com.familyTree.marraige;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Ahmed.Dakrory
 *
 */
@Service("marriageFacadeImpl")
public class marriageAppServiceImpl implements ImarriageAppService{

	@Autowired
	marriageRepository marriageDataRepository;
	
	
	@Override
	public List<marriage> getAll() {
		try{
			List<marriage> course=marriageDataRepository.getAll();
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}

	

	@Override
	public marriage addmarriage(marriage data) {
		try{
			marriage data2=marriageDataRepository.addmarriage(data);
			return data2;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	@Override
	public boolean delete(marriage data) throws Exception{
		// TODO Auto-generated method stub
		try{
			marriageDataRepository.delete(data);
			return true;
			}
			catch(Exception ex)
			{
				throw ex;
			}
	}

	@Override
	public marriage getById(int id) {
		// TODO Auto-generated method stub
		try{
			marriage so=marriageDataRepository.getById(id);
			
			return so;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}


	

	@Override
	public List<marriage> getWomanMarriedManWithId(int id) {
		try{
			List<marriage> course=marriageDataRepository.getWomanMarriedManWithId(id);
			
			return course;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				return null;
			}
	}



	

	
}
		
		

	
		
	


