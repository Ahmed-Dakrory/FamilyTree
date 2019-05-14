/**
 * 
 */
package main.com.familyTree.nodes;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface InodeAppService {

	public List<node> getAll();
	public List<node> getSonsOfParent(int id);
	public List<node> getSonsOfGrand(int id);
	public node addnode(node data);
	public node getById(int id);
	public node getByNameAndFatherAndGrand(String name,String father, String grand);
	public boolean delete(node data) throws Exception;
}
