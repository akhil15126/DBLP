import java.util.ArrayList;

public class author_name{
	private ArrayList<String> names;

	public author_name(){
		names = new ArrayList<String>();
	}

	public void addAuthName(String name){
		names.add(name);
	}

	public ArrayList<String> getAuthNames(){
		return names;
	}

	@Override
	public String toString(){
		return "Author Names:" + names;
	}

}