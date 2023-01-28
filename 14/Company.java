/**
 * Company linked list
 *
 * @Tomer Peker
 * @1.0.0
 */
public class Company
{
    private RentNode _head;

    /**
     * Constructor for empty Company
     */
    public Company()
    {
        _head = null;
    }
    
    
    /**
     * Add rent object
     *
     * @param  name name of rent
     * @param  car Car object
     * @param  pick pick date object
     * @param  ret return date object
     * @return true if succeeded,false if already exists
     */
    public boolean addRent(String name, Car car, Date pick, Date ret){
        RentNode newRent = new RentNode(new Rent(name, car, pick, ret));
        if (_head == null){
            _head = newRent;
            return true;
        }
        if (isOtherBeforeRentInList(_head, newRent)){
            RentNode temp = _head;
            _head = newRent;
            _head.setNext(temp);
            return true;
        }
        RentNode currentRentNode = _head;
        while (currentRentNode.getNext() != null){
            if (currentRentNode.getRent().equals(newRent.getRent())){
                return false;
            }
            if (isOtherBeforeRentInList(currentRentNode.getNext(), newRent)){
                break;
            }
            currentRentNode = currentRentNode.getNext();
        }
        if (currentRentNode.getNext() != null){
            RentNode temp = currentRentNode.getNext();
            currentRentNode.setNext(newRent);
            newRent.setNext(temp);
        }
        else{
            currentRentNode.setNext(newRent);
        }
        return true;
    }
    /**
     * Remove rent object
     *
     * @param d return date object
     * @return true if succeeded,false if already exists
     */
    public boolean removeRent(Date d){
        if (_head == null){
            return false;
        }
        RentNode currentRentNode = _head;
        while (currentRentNode != null){
            if (currentRentNode.getRent().getReturnDate().equals(d)){
                currentRentNode = new RentNode(currentRentNode.getNext());
                return true;
            }
            currentRentNode = currentRentNode.getNext();
        }
        return false;
    }
    
    
    
    /**
     * Count number of rent objects
     * @return number of objects in Company
     */
    public int getNumOfRents(){
        int num = 0;
        if (_head == null){
            return num;
        }
        RentNode currentRentNode = _head;
        while (currentRentNode != null){
            num++;
            currentRentNode = currentRentNode.getNext();
        }
        return num;
    }
    
    /**
     * Sum prices of rent objects
     * @return total sum in Company
     */
    public int getSumOfPrices(){
        int sum = 0;
        if (_head == null){
            return sum;
        }
        RentNode currentRentNode = _head;
        while (currentRentNode != null){
            sum+= currentRentNode.getRent().getPrice();
            currentRentNode = currentRentNode.getNext();
        }
        return sum;
    }
    
    /**
     * Sum of days with rent
     * @return total days in Company
     */
    public int getSumOfDays(){
        int sum = 0;
        if (_head == null){
            return sum;
        }
        RentNode currentRentNode = _head;
        while (currentRentNode != null){
            sum+= currentRentNode.getRent().howManyDays();
            currentRentNode = currentRentNode.getNext();
        }
        return sum;
    }
    
    
    /**
     * Average days per rent
     * @return the average length of rent
     */
    public int averageRent(){
        int sum = getSumOfDays();
        int cnt = getNumOfRents();
        return cnt == 0 ? 0 : sum/cnt;
    }
    
    /**
     * Last rentNode object per return date
     * @return the farthest rent object
     */
    public Car lastCarRent(){
        if (_head == null){
            return null;
        }
        RentNode currentRentNode = _head;
        Rent currentMinRent = currentRentNode.getRent();
        while (currentRentNode != null){
            if (currentRentNode.getRent().getReturnDate().after(currentMinRent.getReturnDate())){
                currentMinRent  = currentRentNode.getRent();
            }
            currentRentNode = currentRentNode.getNext();
        }
        return currentMinRent.getCar();
    }
    
    
    /**
     * The method returns the longest rent
     * @return the Rent with the longest duration 
     */
    public Rent longestRent(){
        if (_head == null){
            return null;
        }
        RentNode currentRentNode = _head;
        Rent currentMinRent = currentRentNode.getRent();
        while (currentRentNode != null){
            if (currentRentNode.getRent().howManyDays() > currentMinRent.howManyDays()){
                currentMinRent  = currentRentNode.getRent();
            }
            currentRentNode = currentRentNode.getNext();
        }
        return currentMinRent;
    }
    
    /**
     * The method calculates what is the most common rating in the Company
     * @return the Rent with the longest duration 
     */
    public char mostCommonRate(){
        if (_head == null){
            return 'N';
        }
        RentNode currentRentNode = _head;
        Rent currentMinRent = currentRentNode.getRent();
        int countA = 0, countB = 0, countC = 0, countD = 0;
        while (currentRentNode != null){
            switch(currentRentNode.getRent().getCar().getType()){
                case 'A':
                    countA++;
                    break;
                case 'B':
                    countB++;
                    break;
                case 'C':
                    countC++;
                    break;
                case 'D':
                    countD++;
                    break;
                }
            currentRentNode = currentRentNode.getNext();
        }
        if (countD >= Math.max(countA, Math.max(countB, countC))){
            return 'D';
        }
        if (countC >= Math.max(countA, countB)){
            return 'C';
        }
        if (countB >= countA){
            return 'B';
        }
        return 'A';
    }
    
    /**
     * The method checks if other Company is included in this Company
     * @return is the Company is a subset of this company
     */
    public boolean includes(Company other){
        if (_head == null){
            return false;
        }
        if (other._head == null){
            return true;
        }
        RentNode currentRentNode = _head;
        RentNode currentOtherRentNode = other._head;
        if (currentRentNode.getRent().getPickDate().after(currentOtherRentNode.getRent().getPickDate())){
            return false; // The lists are sorted by pick date, so if the first object of the other list is before this list, the other list can not exits in this list
        }
        while (currentRentNode != null && currentOtherRentNode != null){
            if (currentOtherRentNode.equals(currentRentNode)){
                currentOtherRentNode = currentOtherRentNode.getNext();
            }
            currentRentNode = currentRentNode.getNext();
        }
        return currentOtherRentNode != null;
    }
    
    
    /**
     * The method combines two Company objects into one
     * @return the merged Company object
     */
    public void merge(Company other){
        if (_head == null){
            _head = other._head;
        }
        if (other._head == null){
            return;
        }
        
        RentNode currentRentNode = _head;
        RentNode currentOtherRentNode = other._head;
        
        if (isOtherBeforeRentInList(currentRentNode, currentOtherRentNode)){
                RentNode temp = currentRentNode;
                _head = currentOtherRentNode;
                _head.setNext(temp);
                currentOtherRentNode = currentOtherRentNode.getNext();
        }
        
        
        RentNode currentRentNodeNext = currentRentNode.getNext();
        RentNode currentOtherRentNodeNext = currentOtherRentNode.getNext();
        RentNode temp;
        RentNode tempOther;
        while (currentRentNodeNext != null && currentOtherRentNodeNext != null){
            if (isOtherBeforeRentInList(currentRentNodeNext, currentOtherRentNodeNext)){
                temp = currentRentNodeNext;
                tempOther = currentOtherRentNodeNext;
                currentRentNode.setNext(currentOtherRentNodeNext);
                currentOtherRentNodeNext.setNext(currentRentNodeNext);
                currentOtherRentNode = tempOther;
                
                currentOtherRentNodeNext = currentOtherRentNode.getNext();
                currentOtherRentNode = currentOtherRentNode.getNext();
            }
            currentRentNode = currentRentNode.getNext();
            currentRentNodeNext = currentRentNode.getNext();
        }
        if (currentRentNodeNext == null){
            currentRentNode.setNext(currentOtherRentNode);
        }
        
    }
    
    /**
       Method checks if two RentNode objects should be switched*/
    private static boolean isOtherBeforeRentInList(RentNode currentRentNode, RentNode currentOtherRentNode){
        return (currentRentNode.getRent().getPickDate().after(currentOtherRentNode.getRent().getPickDate())
                || (currentRentNode.getRent().getPickDate().equals(currentOtherRentNode.getRent().getPickDate()) 
                        && currentRentNode.getRent().howManyDays() < currentOtherRentNode.getRent().howManyDays()));
    }
    
    public String toString(){
        int numOfRents = getNumOfRents();
        String s = "The company has " + (numOfRents > 0 ? (numOfRents + " rents: ") : "0 rents.");
        RentNode currentRentNode = _head;
        Rent currentRent;
        while (currentRentNode != null){
            currentRent = currentRentNode.getRent();
            s = s + "\nName:" + currentRent.getName()+ " From:"+ currentRent.getPickDate() 
                +" To:" + currentRent.getPickDate() + " Type:"+currentRent.getCar().getType()+" Days:"+ currentRent.howManyDays()+" Price:" + currentRent.getPrice();
            currentRentNode = currentRentNode.getNext();
                
        }
        return s;
    }
    
}
