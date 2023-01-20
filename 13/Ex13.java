
/**
 * 
 *
 * @Tomer Peker
 * @1.2.0
 */
public class Ex13
{
    
    public  Ex13()
    {

    }
    /**
     * Method calculates the minimum switches between bits in string to make it alternating
     * There are two possible options (010101... / 1010101....), so check how much operations 
     * are needed for each of them, and choose the loweest
     * Time Complexity - We go over the string only once, so O(N)
     * Space Complexity - We do not initialize any arrays in memory, so O(1)
     * @param n string with only 0 and 1 and the same number of chars
     * @returns the minimum transitions
     */
    public static int alternating( String n)
    {
        char currentChar;
        char nextChar;
        boolean areLastCharsBeenTheSame = false;
        int numberOfTransitions = 0;
        
        if (n.length() < 3){
            return 0;
        }
        for (int i = 0; i < n.length() - 1; i++){
            if (n.charAt(i) == '0' && i%2 ==0){ // String should start at one
                numberOfTransitions++;
            }
            if (n.charAt(i) == '1' && i%2 ==1){ // String should have zeroes at even index
                numberOfTransitions++;
            }
        }
        return Math.min(numberOfTransitions, n.length() - numberOfTransitions - 1) / 2 
                + Math.min(numberOfTransitions, n.length() - numberOfTransitions - 1) % 2 
                ;
        // Either the number of transitions to 1010... or the opposite for 01010....
        // Add the reminder
    }
    private static boolean isAtTheEndOfString(int idx, String n){
        return !(idx > 0 && idx < n.length()-1);
    }
    
    private static int f(int[] a, int low, int high){
        int res = 0;
        for (int i=low; i <high; i++)
            res += a[i];
        return res;
    }
    /**
     * 1.The methods looks for the longest series of numbers in an array 
     * which their sum is even (returns 0 for mod 2).
     * 2. Time Complexity - Going over the array to caclucate the sum (O(n)), for every element (O(N)), for every element (O(n)) -> O(N**3)
     * Memory Complexity - The example did not initialize any new arrays, for O(1)
     * 3.
     * Time complexity - Going over a in the first loop (O(n)) to calculate the sum o(n), 
     *  if even than finished.
     *  If not, find the first odd number (because odd minus odd is even), 
     *      which requires going over the array again (O(n)).
     *  So, at worst case O(2*n) = O(n).
     * Memory complexity - Array a is already in memory, so O(1).
     * @param a array of natural numbers
     * @return longest streak of numbers whose sum divides by 2
     */
    public static int what(int[] a)
    {
        int currentInt;
        int currentIntFromEnd;
        int totalSum = f(a, 0, a.length);
        if (totalSum % 2 == 0){
            return a.length;
        }
        return idxOfFirstOddNumber(a);
    }
    private static int idxOfFirstOddNumber(int[] a){
        for (int i = 0 ; i < a.length; i++){
            if ((a[i] % 2 != 0) || (a[a.length-i -1] % 2 != 0)){
                return Math.max(a.length - i - 1, i);
            }
        }
        return a.length;
    }
    
    
    /**
     * Methods finds if there is a way to traverse all points in the array
     *
     * @param  a array to traverse
     * @return    if it can be traversed
     */
    public static boolean isWay(int [] a)
    {
        int [] aTemp = a.clone();
        if (a.length == 1){
            return true;
        }
        return isWayPrivate(aTemp, 0, 0, a.length);
    }
    private static boolean isWayPrivate(int [] a, int currentIdx, int steps, int lengthOfA){
        if (currentIdx + steps == lengthOfA - 1 || currentIdx - steps == lengthOfA - 1){
            return true;
        }
        boolean foundPath = false;
        int nextIdx;
        int [] reqursiveArray;
        if ((currentIdx + steps < lengthOfA && a[currentIdx + steps] < lengthOfA) && (a[currentIdx + steps] != 0)){
            nextIdx = a[currentIdx + steps];
            reqursiveArray = a.clone();
            reqursiveArray[currentIdx]= 0;
            foundPath = isWayPrivate(reqursiveArray, currentIdx + steps, nextIdx, lengthOfA);
            
        }
        if ((currentIdx - steps > 0) && (a[currentIdx - steps] != 0) && a[currentIdx - steps] < lengthOfA){
            nextIdx = a[currentIdx - steps];
            reqursiveArray = a.clone();
            reqursiveArray[currentIdx]= 0;
            foundPath |= isWayPrivate(reqursiveArray, currentIdx - steps, nextIdx, lengthOfA);            
            
        }
        return foundPath;
        }
        
    
    /**
     * The methods calulates the shortest path to the villan. 
     *
     * @param  drm array for all the rooftops and their respective heights
     * @param  i starting point X for the good guy
     * @param  j starting point Y for the good guy
     * @return    the number of tiles needed to be passed (including the first and last)
     */
    public static int prince(int[][] drm, int i, int j)
    {
        int [][] drmTemp = drm.clone();
        if (drmTemp[i][j] == -1){
            return 1;
        }
        int shortestPath = Math.min(Math.min(
                            Math.min(tryGetPoint(drmTemp, i + 1, j, 
                                i, j, 1),
                            tryGetPoint(drmTemp, i - 1, j, 
                                i, j, 1)),
                            tryGetPoint(drmTemp, i, j + 1, 
                                i, j, 1)),
                            tryGetPoint(drmTemp, i, j - 1, 
                                i, j, 1));
        return  shortestPath > drm.length * drm[0].length ? -1 : shortestPath;
        
    }
    
    private static boolean isPointValid(int i, int j, int columnsLength, int rowsLength){
        return (i > -1 && i < columnsLength && j > -1 && j < rowsLength);
    }
    private static int tryGetPoint(int[][] drmTemp, int newI, int newJ, int oldI, int oldJ, 
                                    int stepsToGetHere){
        
        if (isPointValid(newI, newJ, drmTemp.length, drmTemp[0].length)){
            if (drmTemp[newI][newJ] == -1){
                return stepsToGetHere +1 ;
            }
            else if (
                (drmTemp[newI][newJ] - drmTemp[oldI][oldJ] <= 1) 
                    && (drmTemp[newI][newJ] - drmTemp[oldI][oldJ] >= -2)){
                        int [][] drmTempReqursive = drmTemp.clone();
                        drmTempReqursive[oldI] = drmTemp[oldI].clone();
                        // Used because the array.clone() copies the references to the inner arrays, so we should be copying the actual data 
                        drmTempReqursive[oldI][oldJ] = 999;
                        return Math.min(Math.min(
                            Math.min(tryGetPoint(drmTempReqursive, newI + 1, newJ, 
                                newI, newJ, stepsToGetHere+1),
                            tryGetPoint(drmTempReqursive, newI - 1, newJ, 
                                newI, newJ, stepsToGetHere+1)),
                            tryGetPoint(drmTempReqursive, newI, newJ + 1, 
                                newI, newJ, stepsToGetHere+1)),
                            tryGetPoint(drmTempReqursive, newI, newJ - 1, 
                                newI, newJ, stepsToGetHere+1));
                    }
        }
        return drmTemp.length * drmTemp[0].length + 1;
    }
    

}
