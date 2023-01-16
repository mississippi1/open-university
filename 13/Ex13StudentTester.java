
public class Ex13StudentTester
{
    public static void main(String[] args) {
        System.out.println("----------------------------------------");
        System.out.println("***       Q1  - alternating         ***");
        System.out.println("----------------------------------------");
        System.out.println("s: \"00011011\"");
        int result1=Ex13.alternating("00011011");
        if (result1==2)
            System.out.println("Passed, result is 2");
        else
            System.out.println("Failed,  expected: 2   student's result: "+result1);
        System.out.println("----------------------------------------");
        System.out.println("***       Q2  - what             ***");
        System.out.println("----------------------------------------");
        what what = new what();
        {
            int []a = {2,3,1,4,5,6,7};
            System.out.println("a: [2,3,1,4,5,6,7]");
            int result2=what.what(a);
            if (result2==7)
                System.out.println("Passed, result is 7");
            else
                System.out.println("Failed,  expected: 7  student's result: "+result2);
        }
        IsWay isWay = new IsWay();
        System.out.println("----------------------------------------");
        System.out.println("***       Q3  - isWay           ***");
        System.out.println("----------------------------------------");
        int []a= {2,4,1,6,4,2,4,3,5};
        System.out.println("a: [2,4,1,6,4,2,4,3,5]");
        boolean result3=Ex13.isWay(a);
        
        if(result3==true)
            System.out.println("Passed, result is true");
        else
            System.out.println("Failed,  expected: true  student's result: "+result3);

        System.out.println("----------------------------------------");
        System.out.println("***       Q4  - prince            ***");
        System.out.println("----------------------------------------");
        int[][] drm = {{2,  0,  1,  2,  3}, 
                {2,  3,  5,  5,  4},
                {8,  -1, 6,  8,  7},
                {3,  4,  7,  2,  4},
                {2,  4,  3,  1,  2}};
        System.out.println("drm:");
        System.out.println("[2,  0,  1,  2,  3]"); 
        System.out.println("[2,  3,  5,  5,  4]"); 
        System.out.println("[8, -1,  6,  8,  7]"); 
        System.out.println("[3,  4,  7,  2,  4]"); 
        System.out.println("[2,  4,  3,  1,  2]"); 
        System.out.println("i: 0,j: 0"); 
        int result4= Ex13.prince(drm,0,0);
        if (result4==4)
            System.out.println("Passed, result is 4");
        else
            System.out.println("Failed,  expected: 4   student's result: "+result4);
        System.out.println("----------------------------------------");
        
        System.out.println("----------------------------------------");
        System.out.println("***       Q4  - prince            ***");
        System.out.println("----------------------------------------");
        int [][] drm1 = {{1,  0}, 
                        {-1,  3}};
        System.out.println("drm:");
        System.out.println("[1,  0]"); 
        System.out.println("[-1,  3]"); 
        System.out.println("i: 0,j: 1"); 
        int result5= Ex13.prince(drm1,0,1);
        if (result5==2)
            System.out.println("Passed, result is 2");
        else
            System.out.println("Failed,  expected: 2   student's result: "+result5);
        System.out.println("----------------------------------------");

    }
}

