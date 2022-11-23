
/**
 * This class represents a Car object
 *
 * @Tomer Peker
 * @2022-10-30
 */
public class Car
{
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;
    private final int DEFAULT_ID = 9999999;
    private final char DEFAULT_TYPE = 'A';
    /**
     Creates a new Car object
     id should be a 7 digits number, otherwise set it to 9999999
     type should be 'A', 'B', 'C' or 'D' otherwise set it to 'A'
     * @param  id the id of the car (7 digits number)
     * @param type the type of the car ('A', 'B', 'C' or 'D')
     * @param brand the car's brand
     * @param isManual falg if the car is manual
     */
    public Car(int id, char type, String brand, boolean isManual)
    {
        if ((id < 1000000) || (id > 9999999))
            _id = DEFAULT_ID;
        else 
            _id = id;
            
        if (('A' == type) || 
            ('B' == type) || 
            ('C' == type) || 
            ('D' == type))
            _type = type;
        else 
            _type = DEFAULT_TYPE;
        
        _isManual = isManual;
        _brand = brand;
        
    }
    /**Copy cunstructor 
       @param other the car to be copied*/
    public Car(Car other){
        _type = other._type;
        _id = other._id;
        _brand = other._brand;
        _isManual = other._isManual;
    }
    /**Gets the id
        @return the id*/
    public int getId(){
        return this._id;
    }
    /**Gets the brand
        @return the brand*/
    public String getBrand(){
        return this._brand;
    }
    /**Gets the tyoe
        @return the type*/
    public char getType(){
        return this._type;
    }
    /**Gets the isManual flag
        @return the iManual flag*/
    public boolean isManual(){
        return this._isManual;
    }
    /**Sets the id (only if the given id is valid)
        @param id the id value to be set*/
    public void setId(int id){
        if ((id >= 1000000) || (id < 9999999))
            _id = id;
            
    }
    /**Sets the barnd
        @param brand the brand value to be set*/
    public void setBrand(String brand){
        _brand = brand;
    }
    /**Sets the type (only if the given type is valid)
        @param type the type value to be set*/
    public void setType(char type){
        if (('A' == type) || 
            ('B' == type) || 
            ('C' == type) || 
            ('D' == type))
            _type = type;
        
        
    }
    /**Sets the isManual flag
        @param ismanual the isManual flag to be set*/
    public void setIsManual(boolean manual){
        _isManual = manual;
    }
    /**Returns a String object that represents this car
     * @return String that represents this car in the following format:
        id:1234567 type:B brand:Toyota gear:manual (or auto)

       */
    public String toString(){
        return ("id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + (_isManual ? "manual": "auto"));
    }
    /**Check if two cars are the same
        Cars are considered the same if they have the same type, brand and gear
        @param other the car to compare this car to
        @return the car to compare this car to*/
    public boolean equals (Car other){
        if ((_type == other.getType()) && 
            (_brand.equals(other.getBrand())) &&
            (_isManual == other.isManual()))
            return true;
        return false;
            
    }
    /**Check if this car is better than the other car
        A car is considered better than another car if its type is higher.
        If both cars have the same type, an automated car is better than a manual car.
        @param other car to compare this car to
        @return true if this car is better than the other car, otherwise false*/
    public boolean better (Car other){
        System.out.println(_type+ " "+ other.getType());
        if (_type > other.getType()){
            return true;
        }
        else if ((_type == other.getType()) && (!_isManual && other.isManual()))
                return true;
        return false;
    }
    /**Check if this car is worse than the other car
       @param other car to compare this car to
       @return true if this car is worse than the other car, otherwise false
       */
    public boolean worse (Car other){
         return !this.better(other);   
    }
}
