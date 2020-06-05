package HashtableWithArray;

public class Hashtables {
	
	private Employee[] hashtable;
	
	public Hashtables() {
		hashtable=new Employee[10];
	}
	
	public void put(String key,Employee emp) {
		int hashIndex=hashIndex(key);
		if(hashtable[hashIndex] !=null) {
			System.out.println("place occupied");
		}else {
			hashtable[hashIndex]=emp;
		}
	}
	
	
	public int hashIndex(String key) {
		int hashIndex= key.length() % hashtable.length;
		return hashIndex;
		
	}
	
	public Employee getEmployee(String key) {
		int hashIndex=hashIndex(key);
		return hashtable[hashIndex];
		
	}
	
	 public void printHashtable() {
	        for (int i = 0; i < hashtable.length; i++) {
	            System.out.println(hashtable[i]);
	        }
	    }

}
