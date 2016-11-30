import java.util.ArrayList;

/**
* creates a class of author_name - used for entity
*/
public class author_name{
	private ArrayList<String> names;

	///constructor
	public author_name(){
		names = new ArrayList<String>();
	}

	///adds an author name
	public void addAuthName(String name){
		names.add(name);
	}

	///returns author and his/her aliases
	public ArrayList<String> getAuthNames(){
		return names;
	}

	///overridden toString method
	@Override
	public String toString(){
		return "Author Names:" + names;
	}

}