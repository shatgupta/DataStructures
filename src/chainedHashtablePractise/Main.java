package chainedHashtablePractise;

public class Main {

    public static void main(String[] args) {
        Employee2 janeJones = new Employee2("Jane", "Jones", 123);
        Employee2 johnDoe = new Employee2("John", "Doe", 4567);
        Employee2 marySmith = new Employee2("Mary", "Smith", 22);
        Employee2 mikeWilson = new Employee2("Mike", "Wilson", 3245);

        chaining ht = new chaining();
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marySmith);

        ht.printHashtable();

      System.out.println("Retrieve key Smith: " + ht.getEmployee("Smith"));
//
//        ht.remove("Doe");
//        ht.remove("Jones");
//        ht.printHashtable();
//

    }
}
