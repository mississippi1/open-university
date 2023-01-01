
/**
 * Write a description of class rentTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class rentTester
{
    public static void main(String[] args){
        System.out.println("********** Rent class tester **********");
        System.out.println("-------- author: Meir kurnitz ---------\n");

        System.out.println("1. regular constructor + toString method:\n");
        
        Car c1 = new Car(1234567, 'A', "Mazda", false);
        Date dp1 = new Date(1,2,2000);
        Date dr1 = new Date(1,1,2000);
        Rent r1 = new Rent("David", c1, dp1, dr1);
        Rent r2 = new Rent("David", c1, dp1, dp1);
        boolean isGood = true;
        
        if(!r1._returnDate.equals(dp1.tomorrow())){
            System.out.println("\tproblem in regular constructor---, the return date shold be " + dp1.tomorrow() + " because the return date is before the pick date, but he was " + r1._returnDate);
            isGood = false;
        }
        if(!r2._returnDate.equals(dp1.tomorrow())){
            System.out.println("\tproblem in regular constructor---, the return date shold be " + dp1.tomorrow() + "because the return date is the same date with the pick date, but he was " + r2._returnDate);
            isGood = false;
        }
        if(isGood)
            System.out.println("\tregular constructor is good+++\n");
        
        isGood = true;
        String str1 = "Name:David From:01/02/2000 To:02/02/2000 Type:A Days:1 Price:100";
        
        System.out.println("\tthe next 2 lines shold be the same:");
        System.out.println("\t" + str1);
        System.out.println("\t" + r1);

        if(!str1.equals(r1.toString())){
            System.out.println("\tproblem in toString method---");
            isGood = false;    
        }
        if(isGood)
            System.out.println("\n\ttoString method is good+++");
        
        System.out.println("\n\n2. Copy constructor + equals method:\n");
        c1 = new Car(1234567, 'A', "Mazda", false);
        dp1 = new Date(1,1,2000);
        dr1 = new Date(1,2,2000);
        r1 = new Rent("David", c1, dp1, dr1);
        r2 = new Rent(r1);
        
        isGood = true;
        
        System.out.println("\tthe next 2 lines shold be the same:");
        System.out.println("\t" + r1);
        System.out.println("\t" + r2);
        
        if(!r1.equals(r2)){
            System.out.println("\n\tproblem in equals method---");
            isGood = false;
        }
        if(isGood)
            System.out.println("\n\tequals method is good+++");

        
        r2._car.setType('D');
        isGood = true;
        
        if(r1.equals(r2)){
            System.out.println("\t!!!!!! you got alising in the copy constructor, probably in the _car variable copy !!!!!!!");
            isGood = false;
        }
        if(isGood)
            System.out.println("\tcopy constructor method is good+++");
        
        System.out.println("\n\n3. howManyDays method:\n");
        
        c1 = new Car(1234567, 'A', "Mazda", false);
        dp1 = new Date(1,1,2000);
        dr1 = new Date(1,2,2000);
        Date dp2 = new Date(2,5,2001);
        Date dr2 = new Date(20,6,2401);
        Date dp3 = new Date(2,5,1989);
        Date dr3 = new Date(7,4,2000);
        Date dp4 = new Date(1,5,1000);
        Date dr4 = new Date(1,6,1004);
        
        r1 = new Rent("David", c1, dp1, dr1);
        r2 = new Rent("David", c1, dp2, dr2);
        Rent r3 = new Rent("David", c1, dp3, dr3);
        Rent r4 = new Rent("David", c1, dp4, dr4);
        
        isGood = true;
        
        int days1 = r1.howManyDays();
        int days2 = r2.howManyDays();
        int days3 = r3.howManyDays();
        int days4 = r4.howManyDays();
        
        if(days1 != 31){
            System.out.println("\tproblem in howManyDays method--- number of days shold be 31 but he was " + days1);
            isGood = false;
        }
        if(days2 != 146146){
            System.out.println("\tproblem in howManyDays method--- number of days shold be 146146 but he was " + days2);
            isGood = false;
        }
        if(days3 != 3993){
            System.out.println("\tproblem in howManyDays method--- number of days shold be 3993 but he was " + days3);
            isGood = false;
        }
        if(days4 != 1492 ){
            System.out.println("\tproblem in howManyDays method--- number of days shold be 1492  but he was " + days4);
            isGood = false;
        }
        if(isGood)
            System.out.println("\thowManyDays method is good+++");
        
        System.out.println("\n\n4. getPrice method:\n");
        
            c1 = new Car(1111111, 'A', "Mazda", false);
        Car c2 = new Car(2222222, 'B', "Mazda", false);
        Car c3 = new Car(3333333, 'C', "Mazda", false);
        Car c4 = new Car(4444444, 'D', "Mazda", false);
        
        dp1 = new Date(1,1,2000);
        dr1 = new Date(1,2,2000);
        dp2 = new Date(2,5,2001);
        dr2 = new Date(10,5,2001);
        dp3 = new Date(2,5,2000);
        dr3 = new Date(4,5,2000);
        dp4 = new Date(1,5,1000);
        dr4 = new Date(1,6,1004);
        
        r1 = new Rent("David", c1, dp1, dr1);
        r2 = new Rent("David", c2, dp2, dr2);
        r3 = new Rent("David", c3, dp3, dr3);
        r4 = new Rent("David", c4, dp4, dr4);
        
        int price1 = r1.getPrice(); //2820
        int price2 = r2.getPrice(); //1095
        int price3 = r3.getPrice(); //360
        int price4 = r4.getPrice(); //322296
        
        isGood = true;
        
        if(price1 != 2820){
            System.out.println("\tproblem in getPrice method--- price shold be 2820, but price is " + price1 + " the car type is A");
            isGood = false;
        }
        if(price2 != 1095){
            System.out.println("\tproblem in getPrice method--- price shold be 1095, but price is " + price2 + " the car type is B");
            isGood = false;
        }
        if(price3 != 360){
            System.out.println("\tproblem in getPrice method--- price shold be 360, but price is " + price3 + " the car type is C");
            isGood = false;
        }
        if(price4 != 322296){
            System.out.println("\tproblem in getPrice method--- price shold be 322296, but price is " + price4 + " the car type is D");
            isGood = false;
        }
        if(isGood)
            System.out.println("\thowManyDays method is good+++");
        
        System.out.println("\n\n5. upgrade method:\n");
        isGood = true;
        
        dp1 = new Date(1,1,2000);
        dr1 = new Date(1,2,2000);
        
        c1 = new Car(1111111, 'A', "Mazda", true);
        c2 = new Car(2222222, 'A', "Mazda", false);
        c3 = new Car(3333333, 'C', "Mazda", false);
        c4 = new Car(4444444, 'D', "Mazda", false);
        
        r1 = new Rent("David", c2, dp1, dr1);
        r1.upgrade(c1);
        if(r1._car.equals(c1)){
            System.out.println("\tproblem in upgrade method--- the method set a worse car1111");
            isGood = false;
        }
        
        r1 = new Rent("David", c3, dp1, dr1);
        r1.upgrade(c2);        
        if(r1._car.equals(c2)){
            System.out.println("\tproblem in upgrade method--- the method set a worse car");
            isGood = false;
        }
        
        r1 = new Rent("David", c1, dp1, dr1);
        int upgrade = r1.upgrade(c2);        
        if(upgrade != 0){
            System.out.println("\tproblem in upgrade method--- the method set a better car with no additional cost, but return an additional cost = " + upgrade);
            isGood = false;
        }
        if(!r1._car.equals(c2)){
            System.out.println("\tproblem in upgrade method--- the method !didnt! set a better car11111");
            isGood = false;
        }
        
        r1 = new Rent("David", c1, dp1, dr1);
        upgrade = r1.upgrade(c3);        
        if(!r1._car.equals(c3)){
            System.out.println("\tproblem in upgrade method--- the method !didnt! set a better car");
            isGood = false;
        }
        else if(upgrade != 2256){
            System.out.println("\tproblem in upgrade method--- the method set a better, the additional cost shold be 2256, but he was " + upgrade);
            isGood = false;
        }
        
        r1 = new Rent("David", c1, dp1, dr1);
        upgrade = r1.upgrade(c4);        
        if(!r1._car.equals(c4)){
            System.out.println("\tproblem in upgrade method--- the method !didnt! set a better car");
            isGood = false;
        }
        else if(upgrade != 3948){
            System.out.println("\tproblem in upgrade method--- the method set a better, the additional cost shold be 3948, but he was " + upgrade);
            isGood = false;
        }
        
        r1 = new Rent("David", c1, dp1, dr1);
        upgrade = r1.upgrade(c3); 
        r1._car.setType('D');
        
        if(r1._car.equals(c3)){
            System.out.println("\t!!!!!! you got alising in upgrade method, probably in the set of the new car !!!!!!!");
            isGood = false;
        }
        if(isGood)
            System.out.println("\tupgrade method is good+++");
        
        System.out.println("\n\n6. overlap method:\n");
        isGood = true;
        
        c1 = new Car(1111111, 'A', "Mazda", false);
        c2 = new Car(2222222, 'B', "Mazda", false);
        
        dp1 = new Date(1,1,2000);
        dr1 = new Date(1,2,2000);
        
        r1 = new Rent("David", c1, dp1, dr1);
        r2 = new Rent("David", c2, dp1, dr1);
        r3 = new Rent("Tal"  , c2, dp1, dr1);
        
        if(r1.overlap(r2) != null){
            System.out.println("\tproblem in overlap method--- tow rents overlap but they have a fifferent car");
            isGood = false;
        }
        if(r2.overlap(r3) != null){
            System.out.println("\tproblem in overlap method--- tow rents overlap but they have a fifferent name");
            isGood = false;
        }
        if(r1.overlap(r3) != null){
            System.out.println("\tproblem in overlap method--- tow rents overlap but they have a fifferent name and a different car");
            isGood = false;
        }
        
        dp1 = new Date(1,1,2000);
        dp2 = new Date(1,2,2000);
        dp3 = new Date(1,3,2000);
        dp4 = new Date(1,4,2000);
        
        c1 = new Car(1111111, 'A', "Mazda", false);
        
        r1 = new Rent("David", c1, dp1, dp2);
        r2 = new Rent("David", c1, dp2, dp3);
        
        r3 = new Rent("David", c1, dp1, dp3);
        r4 = new Rent("David", c1, dp2, dp4);
        
        Rent r5 = new Rent("David", c1, dp1, dp2);
        Rent r6 = new Rent("David", c1, dp3, dp4);
        
        if(r1.overlap(r2) == null || r2.overlap(r1) == null){
            System.out.println("\tproblem in overlap method--- tow rents !dont! overlap but they shold be, because the return day of one is the pick day of the other");
            isGood = false;
        }
        if(r3.overlap(r4) == null || r4.overlap(r3) == null){
            System.out.println("\tproblem in overlap method--- tow rents !dont! overlap but they shold be, because the return day of one, is after the pick day ofthe other");
            isGood = false;
        }
        
        if(!(r5.overlap(r6) == null) || !(r6.overlap(r5) == null)){
            System.out.println("\tproblem in overlap method--- tow rents overlap but they have no overlaping days");
            isGood = false;
        }
        
        Rent R1andR2 = r1.overlap(r2);
        R1andR2._pickDate.setDay(5);
        R1andR2._returnDate.setDay(5);
        R1andR2._car.setType('B');
        
        if(R1andR2._pickDate.equals(dp1)){
            System.out.println("\t!!!!!! you got alising in overlap method, probably in the set of the new pickDate");
            isGood = false;
        }
        if(R1andR2._returnDate.equals(dp3)){
            System.out.println("\t!!!!!! you got alising in overlap method, probably in the set of the new reutrnDate");
            isGood = false;
        }
        if(R1andR2._car.equals(c1)){
            System.out.println("\t!!!!!! you got alising in overlap method, probably in the set of the car");
            isGood = false;
        }
        if(isGood)
            System.out.println("\toverlap method is good+++");
        
        System.out.println("\n********** End of Rent class tester **********\n");

    }

}
