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
        RentNode currentRentNode = _head;
        while (currentRentNode != null){
            if (currentRentNode.getRent().equals(newRent)){
                return false;
            }
            if (currentRentNode.getRent().getPickDate().after(currentRentNode.getRent().getPickDate())
                || currentRentNode.getRent().getPickDate().equals(currentRentNode.getRent().getPickDate())){
                if (currentRentNode.getRent().getReturnDate().after(newRent.getRent().getReturnDate())
                    || currentRentNode.getRent().getReturnDate().equals(newRent.getRent().getReturnDate())){
                    continue;
                }
                else{
                    break;
                }
            }
            currentRentNode = currentRentNode.getNext();
        }
        currentRentNode.setNext(newRent);
        return true;
    }
    
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
        }
        return false;
    }
    
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
