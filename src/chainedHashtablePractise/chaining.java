package chainedHashtablePractise;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import chaining.StoredEmployee;

public class chaining {
	
	private LinkedList<StoredEmployee2>[] hashtable;
	
	public chaining() {
		hashtable= new LinkedList[10];
		for(int i=0; i<hashtable.length;i++) {
			hashtable[i]= new LinkedList<StoredEmployee2>();
		}
	}
	
	public void put(String key, Employee2 emp) {
		int hashedkey=hashKey(key);
		hashtable[hashedkey].add(new StoredEmployee2(key, emp));
	}
	
	
	public Employee2 getEmployee(String key) {
		int hashedkey=hashKey(key);
		ListIterator<StoredEmployee2> iterator=hashtable[hashedkey].listIterator();
		StoredEmployee2 emp=null;
		while(iterator.hasNext()) {
			emp=iterator.next();
			if(emp.key.equals(key)) {
				return emp.employee;
			}
		}
		return null;
	}
	
	
	public Employee2 remove(String key) {
		int hashedkey=hashKey(key);
		ListIterator<StoredEmployee2> iterator=hashtable[hashedkey].listIterator();
		StoredEmployee2 emp=null;
		int index=-1;
		while(iterator.hasNext()) {
			emp=iterator.next();
			index++;
			if(emp.key.equals(key)) {
			 break;
			}
		}
		
		hashtable[hashedkey].remove(index);
		return emp.employee;
		
		
		
	}
	
	 private int hashKey(String key) {
	        return key.length() % hashtable.length;
	    }

	  public void printHashtable() {
	        for (int i = 0; i < hashtable.length; i++) {
	            if (hashtable[i].isEmpty()) {
	                System.out.println("Position " + i + ": empty");
	            }
	            else {
	                System.out.print("Position " + i + ": ");
	                ListIterator<StoredEmployee2> iterator = hashtable[i].listIterator();
	                while (iterator.hasNext()) {
	                    System.out.print(iterator.next().employee);
	                    System.out.print("->");
	                }
	                System.out.println("null");
	            }
	        }
	    }

}
