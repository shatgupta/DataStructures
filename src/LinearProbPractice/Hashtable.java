package LinearProbPractice;

import linearProbing.Employee;
import linearProbing.StoredEmployee;

public class Hashtable {

	private StoredEmployeeNew[] hashtable;
	
	public Hashtable() {
		hashtable= new StoredEmployeeNew[10];
	}


	public void put(String key, Employee1 employee) {
        int hashedKey = hashKey(key);
        if (occupied(hashedKey)) {
            int stopIndex = hashedKey;
            if (hashedKey == hashtable.length - 1) {
                hashedKey = 0;
            }
            else {
                hashedKey++;
            }

            while (occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if (occupied(hashedKey)) {
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        }
        else {
            hashtable[hashedKey] = new StoredEmployeeNew(key, employee);
    }
	}
	public Employee1 get(String key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }
	
	public int findKey(String key) {
		int hashedkey=hashKey(key);
		if(hashtable[hashedkey]!=null && hashtable[hashedkey].key.equals(key)){
			return hashedkey;
		}
		int stopIndex = hashedkey;
        if (hashedkey == hashtable.length - 1) {
        	hashedkey = 0;
           }
        else {
        	hashedkey++;
           }

         while (hashedkey != stopIndex && hashtable[hashedkey]!=null
        		 && !hashtable[hashedkey].key.equals(key)) {
        	hashedkey = (hashedkey + 1) % hashtable.length;
           }
         if (stopIndex == hashedkey) {
             return -1;
         }
         else {
             return hashedkey;
         }
         
       }
		
	public Employee1 remove(String key) {
		 int hashedKey=hashKey(key);
		 Employee1 emp=hashtable[hashedKey].employee;
		 hashtable[hashedKey]=null;
		 return emp;
		 
	 }
	
 private int hashKey(String key) {
     return key.length() % hashtable.length;
 }
 
 
 private boolean occupied(int index) {
     return hashtable[index] != null;
 }
 
 
 
 

 public void printHashtable() {
     for (int i = 0; i < hashtable.length; i++) {
         if (hashtable[i] == null) {
             System.out.println("empty");
         }
         else {
             System.out.println("Position " + i + ": " +hashtable[i].employee);
         }
     }
 }
}

