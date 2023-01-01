
/**
 * Write a description of class dateTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class dateTester
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){

        System.out.println("********** Date class tester **********");
        System.out.println("-------- author: Meir kurnitz ---------\n");

        System.out.println("1. regolar constructor + toString method:\n");
        
        
        Date d3 = new Date(1, 11, 2000);  
        Date d4 = new Date(16, 2, 2000);
        String str3 = "01/11/2000";
        String str4 = "16/02/2000";
        boolean isGood = true;
        
        if(!d3.toString().equals(str3)){
            System.out.println("\tproblem in toString method--- string shold be 01/11/2000, but he was " + d3); 
            isGood = false;
        }
        
        if(!d4.toString().equals(str4)){
            System.out.println("\tproblem in toString method--- string shold be 16/02/2000, but he was " + d4); 
            isGood = false;
        }
        
        if(isGood)
            System.out.println("\ttoString method is good+++");
            
        Date d1 = new Date(0,1,2000);
        Date d2 = new Date(1,0,2000);
        d3 = new Date(1,1,0);
        d4 = new Date(-10,1,2000);
        Date d5 = new Date(1,-10,2000);
        Date d6 = new Date(1,1,-100);

        System.out.println("\n\tthe next 6 lines shold be 01/01/2000:");
        System.out.println("\tif one of the lins is not the same,\n\tthere is a problem in the method that validate the date,\n\tprobably you didnt check for too low values");

        System.out.println("\t\t1. " + d1);
        System.out.println("\t\t2. " + d2);
        System.out.println("\t\t3. " + d3);
        System.out.println("\t\t4. " + d4);
        System.out.println("\t\t5. " + d5);
        System.out.println("\t\t6. " + d6);
        System.out.println("\talso, check manualy if the printing is right");

        d1 = new Date(32,1,2000);
        d2 = new Date(1,13,2000);
        d3 = new Date(30,1,11900);
        System.out.println("\n\tthe next 3 lines shold be 01/01/2000:");
        System.out.println("\tif one of the lins is not the same,\n\tthere is a problem in the method that validate the date,\n\tprobably you didnt check for too high values");
        System.out.println("\t\t1. " + d1);
        System.out.println("\t\t2. " + d2);
        System.out.println("\t\t3. " + d3);

        d1 = new Date(31,4, 2000);
        d2 = new Date(31,6,2000);
        d3 = new Date(31,9,2000);
        d4 = new Date(31,11,2000);
        System.out.println("\n\tthe next 4 lines shold be 01/01/2000:");
        System.out.println("\tif one of the lins is not the same,\n\tthere is a problem in the method that validate the date,\n\tprobably you didnt check that the months 4,6,9 and 11 has only 31 days");
        System.out.println("\t\t1. " + d1);
        System.out.println("\t\t2. " + d2);
        System.out.println("\t\t3. " + d3);
        System.out.println("\t\t4. " + d4);

        System.out.println("\n\tthe next 2 lines shold be 01/01/2000:");
        System.out.println("\tif one of the lins is not the same,\n\tthere is a problem in the method that validate the date,\n\tprobably your leap year check is wrong");
        d1 = new Date(29,2, 1901);
        d2 = new Date(29,2,1900);
        System.out.println("\t\t1. " + d1);
        System.out.println("\t\t2. " + d2);

        System.out.println("\n\n2. Copy constructor + equals method:\n");
        d1 = new Date(10, 10, 2000);
        d2 = new Date(d1);
        System.out.println("\tthe next to line shold be the same:");
        String str1 = d1.toString();
        String str2 = d2.toString();
        System.out.println("\t\t" + d1);
        System.out.println("\t\t" + d2);
        if(str1.equals(str2))
            System.out.println("\t-the copy constructor is good+++");
        else
            System.out.println("\t-you got a problem in the copy constructor---");

        if(d1.equals(d2))
            System.out.println("\t-equals method is good+++");
        else
            System.out.println("\t-you got a problem in the equals method---");

        System.out.println("\n\n3. get methods:\n");
        d1 = new Date(10, 10, 2000);
        int getDay = d1.getDay();
        int getMonth = d1.getMonth();
        int getYear = d1.getYear();
        isGood = true;
        if(getDay != 10){
            System.out.println("\tproblem in getDay method---");
            isGood = false;
        }else
            System.out.println("\tgetDay method is good+++");

        if(getMonth != 10){
            System.out.println("\tproblem in getMonth method---");
            isGood = false;
        }else
            System.out.println("\tgetMoth method is good+++");

        if(getYear != 2000){
            System.out.println("\tproblem in getYear method---");
            isGood = false;
        }else
            System.out.println("\tgetYear method is good+++");

        System.out.println("\n\n4. set methods:\n");
        d1 = new Date(10, 10, 2000);  
        d2 = new Date(10, 10, 2000);
        boolean goodDay = true;
        boolean goodMonth = true;
        boolean goodYear = true;
        d2.setDay(32);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setDay method--- didnt check for too high day");
            goodDay = false;
        }
        d2.setDay(-10);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setDay method--- didnt check for too low day");
            goodDay = false;
        }
        d2.setMonth(13);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setMonth method--- didnt check for too high month");
            goodMonth = false;
        }
        d2.setMonth(-5);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setMonth method--- didnt check for too low month");
            goodMonth = false;
        }
        d2.setYear(900);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setYear method--- didnt check for too low year");
            goodYear = false;
        }
        d2.setYear(12010);
        if(!d1.equals(d2)){
            System.out.println("\tproblem in the setYear method--- didnt check for too high year");
            goodYear = false;
        }

        if(goodDay)
            System.out.println("\tsetDay is good+++");
        if(goodMonth)
            System.out.println("\tsetMonth is good+++");
        if(goodYear)
            System.out.println("\tsetYear is good+++");

        System.out.println("\n\n5. before and after methods:\n");
        d1 = new Date(10, 10, 2000);  
        d2 = new Date(10, 10, 2001);
        d3 = new Date(10, 11, 2000); 
        d4 = new Date(11, 11, 2000); 
        isGood = true;

        if(!d1.before(d2)){
            System.out.println("\tproblem in before method--- " + d1 + " shold be before " + d2);
            isGood = false;
        }
        if(!d1.before(d3)){
            System.out.println("\tproblem in before method--- " + d1 + " shold be before " + d3);
            isGood = false;
        }
        if(!d1.before(d4)){
            System.out.println("\tproblem in before method--- " + d1 + " shold be before " + d4);
            isGood = false;
        }
        if(d1.before(d1)){
            System.out.println("\tproblem in before method--- " + d1 + " shold !not! be before " + d1);
            isGood = false;
        }
        if(isGood)
            System.out.println("\tbefore method is good+++");

        isGood = true;

        if(!d2.after(d1)){
            System.out.println("\tproblem in after method--- " + d2 + " shold be after " + d1);
            isGood = false;
        }
        if(!d3.after(d1)){
            System.out.println("\tproblem in after method--- " + d3 + " shold be after " + d1);
            isGood = false;
        }
        if(!d4.after(d1)){
            System.out.println("\tproblem in after method--- " + d4 + " shold be after " + d1);
            isGood = false;
        }
        if(d1.after(d1)){
            System.out.println("\tproblem in after method--- " + d1 + " shold !not! be after " + d1);
            isGood = false;
        }
        if(isGood)
            System.out.println("\tafter method is good+++");

        System.out.println("\n\n6. difference method:\n");

        d1 = new Date(10, 10, 2000);  
        d2 = new Date(12, 3, 1970);
        d3 = new Date(2, 7, 2004);
        d4 = new Date(8, 1, 3940);
        d5 = new Date(27, 9, 1994);
        d6 = new Date(30, 5, 2000);

        int difference1 = d1.difference(d1);
        int difference2 = d1.difference(d2); 
        int difference3 = d1.difference(d3); 
        int difference4 = d1.difference(d4); 
        int difference5 = d1.difference(d5); 
        int difference6 = d1.difference(d6); 

        isGood = true;

        if(difference1 != 0){
            System.out.println("\tproblem in difference method---, difference shold be 0 but was " + difference1);
            isGood = false;
        }
        if(difference2 != 11170){
            System.out.println("\tproblem in difference method---, difference shold be 11170 but was " + difference2);
            isGood = false;
        }
        if(difference3 != 1361){
            System.out.println("\tproblem in difference method---, difference shold be 1361 but was " + difference3);
            isGood = false;
        }
        if(difference4 != 708294){
            System.out.println("\tproblem in difference method---, difference shold be 708,294 but was " + difference4);
            isGood = false;
        }
        if(difference5 != 2205 ){
            System.out.println("\tproblem in difference method---, difference shold be 2205 but was " + difference5);
            isGood = false;
        }
        if(difference6 != 133){
            System.out.println("\tproblem in difference method---, difference shold be 133 but was " + difference6);
            isGood = false;
        }

        difference1 = d2.difference(d1);
        if(difference1 < 0){
            System.out.println("\tproblem in difference method---, the difference shold be a non negative value");
            isGood = false;
        }

        if(isGood)
            System.out.println("\tdifference method is good+++");

        System.out.println("\n\n7. tomorrw method:\n");
        d1 = new Date(28, 2, 2000);  
        d2 = new Date(29, 2, 2000);
        d3 = new Date( 1, 3, 2000);
        d4 = new Date(31, 1, 2000);  
        d5 = new Date(1 , 2, 2000);
        d6 = new Date( 30, 4, 2000);
        Date d7 = new Date( 1, 5, 2000);

        isGood = true;

        if(!d1.tomorrow().equals(d2)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d1 + " to " + d2 + " but 2000 is a leap year");
            isGood = false;
        }

        if(!d2.tomorrow().equals(d3)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d2 + " to " + d3);
            isGood = false;
        }

        if(!d4.tomorrow().equals(d5)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d4 + " to " + d5 + " but month number 1 has 31 days");
            isGood = false;
        }

        if(!d6.tomorrow().equals(d7)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d6+ " to " + d6 + " but month number 4 has only 30 days");
            isGood = false;
        }

        d1 = new Date(15, 2, 2000);  
        d2 = new Date(16, 2, 2000);
        d3 = new Date( 4, 8, 2000);
        d4 = new Date( 5, 8, 2000);

        if(!d1.tomorrow().equals(d2)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d1 + " to " + d2);
            isGood = false;
        }

        if(!d3.tomorrow().equals(d4)){
            System.out.println("\tproblem in tomorrow method--- the date didnt jump from " + d3 + " to " + d4);
            isGood = false;
        }
        
        d1 = new Date(15, 2, 2000);  
        d2 = d1.tomorrow();
        isGood = true;
        if(d1.equals(d2)){
            System.out.println("!!!!!! you got alising in tomorrow method--- !!!!!!");
            isGood = false;
        }
        if(isGood){
            System.out.println("\ttomorrow method is good+++");
        }
        
        System.out.println("\n********** End of Date class tester **********\n");
    }
}
