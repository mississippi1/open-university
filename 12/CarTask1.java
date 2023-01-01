
/**
 * This class defines a car and it's methods
 *
 * @Tomer Peker
 * @2022-10-30
 */
public class CarTask1
{
    // instance variables - replace the example below with your own
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;
    private final int DEFAULT_ID = 9999999;
    private final char DEFAULT_TYPE = 'A';
    public CarTask1(int id, char type, String brand, boolean isManual)
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
    public CarTask1(CarTask1 other){
        _type = other._type;
        _id = other._id;
        _brand = other._brand;
        _isManual = other._isManual;
    }
    
    public int getId(){
        return this._id;
    }
    public String getBrand(){
        return this._brand;
    }
    public char getType(){
        return this._type;
    }
    public boolean isManual(){
        return this._isManual;
    }
    
    public void setId(int id){
        if ((id >= 1000000) || (id < 9999999))
            _id = id;
            
    }
    public void setBrand(String brand){
        _brand = brand;
    }
    public void setType(char type){
        if (('A' == type) || 
            ('B' == type) || 
            ('C' == type) || 
            ('D' == type))
            _type = type;
        
        
    }
    public void setIsManual(boolean manual){
        _isManual = manual;
    }
    
    public String toString(){
        return ("id:" + _id + "type:" + _type + " brand:" + _brand + " gear:" + _isManual);
    }
    
    public boolean equals (CarTask1 other){
        if ((_type == other.getType()) && 
            (_brand.equals(other.getBrand())) &&
            (_isManual == other.isManual()))
            return true;
        return false;
            
    }
    
    public boolean better (CarTask1 other){
        if (_type <= other.getType()){
            if (_isManual && !other.isManual())
                return true;
        }
        return false;
    }
    
    public boolean worse (CarTask1 other){
         return !this.better(other);   
    }
}
