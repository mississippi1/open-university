/**
 * Tester for students for class Rent.
 * IMPORTENT: This tester checks only the methods' names and not their correctness. 
 * 
 * @author Course Stass
 */

public class RentStudentTester
{
    public static void main(String[] args) {
        System.out.println("********** Test Rent - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");
        Rent r1=new Rent("Ruthi", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020));  
        System.out.println("\tr1:"+r1);
        Rent r2=new Rent(r1);
        System.out.println("\tr2:"+r2);
        System.out.println("\n2. Testing accessors and mutators:");
        r1.setName("Maya");
        r1.setCar(new Car(9876543,'B', "BMW", true));
        r1.setPickDate(new Date(3,2,2020));
        r1.setReturnDate(new Date(9,2,2020));
        System.out.println("\tr1:"+r1);
        System.out.println("\tname of r1:"+r1.getName());
        System.out.println("\tcar of r1:"+r1.getCar());
        System.out.println("\tpickDate of r1:"+r1.getPickDate()); 
        System.out.println("\treturnDate of r1:"+r1.getReturnDate()); 
        System.out.println("\n3. Testing equals method:");
        Rent r3=new Rent("Rambo", new Car (3344556, 'D', "Volvo", false), new Date(10,4,2021), new Date(20,4,2021)); 
        Rent r4=new Rent("Rambo", new Car (1234567, 'D', "Volvo", false), new Date(10,4,2021), new Date(20,4,2021));  
        System.out.println("\tr2:"+r2);
        System.out.println("\tr3:"+r3);
        System.out.println("\tr4:"+r4);
        if(r2.equals(r3))
            System.out.println("\tr2 is the same Rent as r3");
        else 
            System.out.println("\tr2 isn't the same Rent as r3");
        if(r3.equals(r4))
            System.out.println("\tr3 is the same Rent as r4");
        else 
            System.out.println("\tr3 isn't the same Rent as r4");

        System.out.println("\n4. Testing howMantDays method:");
        System.out.println("\tr2: "+r2.howManyDays()+" days."); 
        System.out.println("\tr3: "+r3.howManyDays()+" days.");      
        System.out.println("\n5. Testing getPrice method:");
        System.out.println("\tprice of r2: "+r2.getPrice()); 
        System.out.println("\tprice of r3: "+r3.getPrice()); 
        System.out.println("\n6. Testing upgrade method:");

        System.out.println("\tupgrade r2 to car type 'D' returns: "+r2.upgrade(new Car(1234567, 'D', "Volvo", false)));
        System.out.println("\n7. Testing overlap method:");
        Rent r5 = new Rent("Bob", new Car (1234567, 'A', "Opel", false), new Date(1,2,2020), new Date(5,2,2020)); 
        Rent r6 = new Rent("Bob", new Car (1234567, 'A', "Opel", false), new Date(4,2,2020), new Date(8,2,2020));  
        System.out.println("\tr5:"+r5);
        System.out.println("\tr6:"+r6);
        System.out.println("\toverlap of r5 and r6 is: "+r5.overlap(r6));

        System.out.println("\n********** Test Rent - Finished **********\n");

    }
}

