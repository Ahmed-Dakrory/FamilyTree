/**
 * 
 */
package main.com.familyTree.marraige;

import java.util.List;

/**
 * 
 * @author Ahmed.Dakrory
 *
 */
public interface marriageRepository {

	public List<marriage> getAll();
	public List<marriage> getWomanMarriedManWithId(int id);
	public marriage addmarriage(marriage data);
	public marriage getById(int id);
	public boolean delete(marriage data) throws Exception;
}
