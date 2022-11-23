public class Cheese {
    private String _type;
    private double _fatPercentage;
    private final String DType = "Mozzarella";
    private final double FFatPercentage = 0;
    public Cheese(String type, double fatPercentage){
        this._type = validateTypeOrDefault(type);
        this._fatPercentage = validatePerOrDefault(fatPercentage);
        
    }
    private String validateTypeOrDefault(String type){
        return ((type != null) &&("".equals(type))) ? type : DType;
    }
    private double validatePerOrDefault(double fatPercentage ){
        return ((fatPercentage >=0) &&(fatPercentage <= 100 )) ? fatPercentage : FFatPercentage;
    }
    public Cheese(){
        _type = DType;
        _fatPercentage = FFatPercentage;
        
    }
    public Cheese(Cheese other){
        _type = other._type;
        _fatPercentage = other._fatPercentage;
    }
    public String getType(){
        return _type;
    }
    public double getPercentage(){
        return _fatPercentage;
    }
    public void setType(String type){
        _type = validateTypeOrDefault(type);
    }
    public void setPercentage(double per){
        _fatPercentage = validatePerOrDefault(per);
    }
    public boolean isGoodaCheese(Cheese cheese){
        return "Gooda".equals(cheese.getType());
    }
    public boolean equals(Cheese other){
        return (other.getType().equals(getType()) && other.getPercentage() == getPercentage());
    }
    
}