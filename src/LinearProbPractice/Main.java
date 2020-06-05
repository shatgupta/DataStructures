package LinearProbPractice;

public class Main {

    public static void main(String[] args) {
        Employee1 janeJones = new Employee1("Jane", "Jones", 123);
        Employee1 johnDoe = new Employee1("John", "Doe", 4567);
        Employee1 marySmith = new Employee1("Mary", "Smith", 22);
        Employee1 mikeWilson = new Employee1("Mike", "Wilson", 3245);
        Employee1 billEnd = new Employee1("Bill", "End", 78);

        Hashtable ht = new Hashtable();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

		
		  System.out.println("Retrieve key Wilson: " + ht.get("Wilson"));
		  System.out.println("Retrieve key Smith: " + ht.get("Smith"));
		  
		 ht.remove("Wilson"); ht.remove("Jones"); ht.printHashtable();
		  
		  System.out.println("Retrieve key Smith: " + ht.get("Smith"));
		 



    }

}
