
/**
 * Write a description of class carTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class carTester
{
    public static void main(String[] args){
    
        System.out.println("********** car class tester ********");
        System.out.println("------ author: Meir kurnitz --------");
        System.out.println("1. regolar constructor + toString method:\n");
        
        Car c1 = new Car(11111, 'E', "mazda", true);
        Car c2 = new Car(111111111, 'E', "mazda", true);
        System.out.println("\tboth Car objects shold be with id:9999999 and type:A");
        System.out.println("\talso, check manualy if the printing is right");
        System.out.println("\t" + c1);
        System.out.println("\t" + c2);
        
        System.out.println("\n\n2. Copy constructor + equals method:\n");
        c1 = new Car(1234567, 'D' , "Mazda", true);
        Car c3 = new Car(c1);
        System.out.println("\tthe next to line shold be the same:");
        String str1 = c1.toString();
        String str3 = c3.toString();
        System.out.println("\t\t" + c1);
        System.out.println("\t\t" + c3);
        if(str1.equals(str3)){
            System.out.println("\t-the copy constructor is good+++");
        }else{
            System.out.println("\t-you got a problem in the copy constructor---");
        }
        if(c1.equals(c3)){
            System.out.println("\t-equals method is good+++");
        }else{
            System.out.println("\t-you got a problem in the equals method---");
        }
        
        System.out.println("\n\n3. get methods:\n");
        c1 = new Car(1234567, 'D' , "Mazda", true);
        int getId = c1.getId();
        char getType = c1.getType();
        String getBrand = c1.getBrand();
        boolean isManual = c1.isManual();
        if(getId == 1234567){
            System.out.println("\t-getId is good+++");
        }else{
            System.out.println("\t-problem in getId---");
        }
        if(getType == 'D'){
            System.out.println("\t-getType is good+++");
        }else{
            System.out.println("\t-problem in getType---");
        }
        if(getBrand.equals("Mazda")){
            System.out.println("\t-getBrand is good+++");
        }else{
            System.out.println("\t-problem in getBrand---");
        }
        if(isManual == true){
            System.out.println("\t-isManual is good+++");
        }else{
            System.out.println("\t-problem in isManual---");
        }
        
        System.out.println("\n\n4. set methods:\n");
        c1 = new Car(1234567, 'D' , "Mazda", true);
        c1.setId(7654321);
        c1.setId(123456);
        c1.setType('B');
        c1.setType('Z');
        c1.setBrand("toyota");
        c1.setIsManual(false);
        if(c1.getId() == 7654321){
            System.out.println("\t-setId is good+++");
        }else if(c1.getId() == 1234567){
            System.out.println("\t-problem in setId--- the methd dident set the new value");
        }else if(c1.getId() == 123456){
            System.out.println("\t-problem in setId--- the methd dident check the new value");
        }
        
        if(c1.getType() == 'B'){
            System.out.println("\t-setType is good+++");
        }else if(c1.getType() == 'D'){
            System.out.println("\t-problem in setType--- the methd dident set the new value");
        }else if(c1.getType() == 'Z'){
            System.out.println("\t-problem in setType--- the methd dident check the new value");
        }
        
        if(c1.getBrand().equals("toyota")){
            System.out.println("\t-setBrand is good+++");
        }else{
            System.out.println("\t-problem in setBrand--- the method didnt set the new value");
        }
        if(c1.isManual() == false){
            System.out.println("\t-setIsManual is good+++");
        }else{
            System.out.println("\t-problem in setIsManual--- the method dident set the new value");
        }
        
        System.out.println("\n\n5. better and worse methods:\n");
        c1 = new Car(1111111, 'A', "mazda", true);
        c2 = new Car(2222222, 'B', "mazda", true);
        c3 = new Car(3333333, 'C', "mazda", true);
        Car c4 = new Car(4444444, 'D', "mazda", true);
        
        if(!(c4.better(c1))){
            System.out.println("\tproblem in better method--- type D shold be better then A");
        }
        else if(!(c3.better(c1))){
            System.out.println("\tproblem in better method--- type C shold be better then A");
        }
        else if(!(c2.better(c1))){
            System.out.println("\tproblem in better method--- type B shold be better then A");
        }
        else if(c1.better(c1)){
            System.out.println("\tproblem in better method--- type A shold !not! be better then A");
        }

        else if(!(c4.better(c2))){
            System.out.println("\tproblem in better method--- type D shold be better then B");
        }
        else if(!(c3.better(c2))){
            System.out.println("\tproblem in better method--- type C shold be better then B");
        }
        else if(c2.better(c2)){
            System.out.println("\tproblem in better method--- type B shold !not! be better then B");
        }
        
        else if(!(c4.better(c3))){
            System.out.println("\tproblem in better method--- type D shold be better then C");
        }
        else if(c3.better(c3)){
            System.out.println("\tproblem in better method--- type C shold !not! be better then C");
        }
        
        else if(c4.better(c4)){
            System.out.println("\tproblem in better method--- type D shold !not! be better then D");
        } 
        else{
            System.out.println("\tbetter method is good+++");
        }
        
        if(!(c1.worse(c4))){
            System.out.println("\tproblem in worse method--- type A shold be worse then D");
        }
        else if(!(c1.worse(c3))){
            System.out.println("\tproblem in worse method--- type A shold be worse then C");
        }
        else if(!(c1.worse(c2))){
            System.out.println("\tproblem in worse method--- type A shold be worse then B");
        }
        else if(c1.worse(c1)){
            System.out.println("\tproblem in worse method--- type A shold !not! be worse then A");
        }

        else if(!(c2.worse(c4))){
            System.out.println("\tproblem in worse method--- type B shold be worse then D");
        }
        else if(!(c2.worse(c3))){
            System.out.println("\tproblem in worse method--- type B shold be worse then C");
        }
        else if(c2.worse(c2)){
            System.out.println("\tproblem in worse method--- type B shold !not! be worse then B");
        }
        
        else if(!(c3.worse(c4))){
            System.out.println("\tproblem in worse method--- type C shold be worse then D");
        }
        else if(c3.worse(c3)){
            System.out.println("\tproblem in worse method--- type C shold !not! be worse then C");
        }
        
        else if(c4.worse(c4)){
            System.out.println("\tproblem in worse method--- type D shold !not! be worse then D");
        } 
        else{
            System.out.println("\tworse method is good+++");
        }
        
        System.out.println("\n********** End of Car class tester **********\n");

    }

}
