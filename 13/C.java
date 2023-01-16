public class C {

       public static void main(String[] args) {
        
        System.out.println("For call match({2,3,57}, {1,0,2}), result is " + match(new int[]{2,3,57}, new int[]{1,0,2}));
        System.out.println("For call match({5,39,67}, {1,0,2}), result is " + match(new int[]{5,39,67}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,34,35}, {1,0,2}), result is " + match(new int[]{2,3,573,4,34,35}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,324,35}, {}), result is " + match(new int[]{2,3,573,4,324,35}, new int[]{}));
        System.out.println("For call match({2,3}, {1,0,2}), result is " + match(new int[]{2,3}, new int[]{1,0,2}));
        System.out.println("For call match({2,3,573,4,324,35}, {1,0,2}), result is " + match(new int[]{2,3,573,4,324,35}, new int[]{1,0,2}));
    }
    
    public static boolean match (int [] a, int [] pattern){
        return match(a, pattern, 0, 0);
    }
    
    private  static boolean match (int [] a, int [] pattern, int idx, int numberOfMatchesInARow){
        if (numberOfMatchesInARow == pattern.length){
            return true;
        }
        if (idx >= a.length){
            return false;
        }
        if (checkIfValueFromPatternInA(a[idx], pattern[numberOfMatchesInARow])){
            return match(a, pattern, idx + 1, numberOfMatchesInARow + 1);
        }
        return match(a, pattern, idx + 1, 0);
    }
    
    private static boolean checkIfValueFromPatternInA(int aVal, int patternVal){
        return ((patternVal == 1 && aVal < 10 && aVal >= 0) 
            || (patternVal == 2 && aVal < 100 && aVal >= 10)
            || (patternVal == 0 && aVal < 100 && aVal >= 0));
    }
}
