
/**
 * Object for linked list of Company
 *
 * @Tomer Peker
 * @1.0.0
 */
public class RentNode
{
    private Rent _rent;
    private RentNode _next;
    /**
     * Constructor for objects of class RentNode
     * @param r rent object of the rent
     */
    public RentNode (Rent r) 
    {
        _rent = new Rent(r);
        _next = null;
    }
    
    /**
     * Constructor for objects of class RentNode
     * @param r rent object of the rent
     * @param next RentNode object to be referenced
     */
    public RentNode (Rent r, RentNode next){
        _rent = new Rent(r);
        _next = next;        
    }
    /**
     * Constructor for objects of class RentNode
     * @param other RentNode object to be copied
         // */
    public RentNode (RentNode other) {
        _rent = new Rent(other.getRent());
        _next = other.getNext();
    }
    /**
     * Get rent object
     * @return new rent object
     */
    public Rent getRent(){
        return new Rent(_rent);
    }
    
    /**
     * Get next rentNode object
     * @return reference to the next RentNode object
     */
    public RentNode getNext(){
        return _next;
    }
    
    /**
     * Set rent object
     * @param rent object
     */
    public void setRent(Rent rent){
        _rent = new Rent(rent);
    }
    
    /**
     * Set next rentNode object
     * @param rentNode object reference
     */
    public void setNext(RentNode next){
        _next = next;
    }
    
}
