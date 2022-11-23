/**
 * This class represents a Rent object
 *
 * @author Tomer Peker
 * @version 1.0.0
 */
public class Rent
{
    
    private String _name;
    private Car _car;
    private Date _pickDate;
    private Date _returnDate;
     /**Creates a new Rent object
        The return date must be at least one day after the pickup date, otherwise set it to one day after the pick up date.
        @param name the client's name
        @param car the rented car
        @param pick the pickup date
        @param ret the return date*/
    public Rent (String name, Car car, Date pick, Date ret)
    {
         _name = name;
         _car = new Car(car);
         _pickDate = new Date(pick);
         _returnDate = new Date(ret);
    }
    /**Copy constructor
       @param other the rent to be copied*/
    public Rent (Rent other){
        _name = other.getName();
        _car = other.getCar();
        _pickDate = other.getPickDate();
        _returnDate = other.getReturnDate();
    }
    /**Gets the name
       @return the name*/
    public String getName(){
        return _name;
    }
    /** Gets the car
       @return the car*/
    public Car getCar(){
        return new Car(_car);
    }
    /** Gets the pick date
       @return the pick up date*/
    public Date getPickDate(){
        return new Date(_pickDate);
    }
    /** gets the return date
       @return the return date*/
    public Date getReturnDate(){
        return new Date(_returnDate);
    }
    /** sets the client name
       @param name the client name */
    public void setName(String name){
        _name = name;
    }
    /** Sets the rented car
       @param the rented car */
    public void setCar(Car car){
        _car = new Car(car);
    }
    /** Sets the pick date - The pick up date must be at least one day before the return date, otherwise - don't change the pick up date 
       @param pickDate the pick date*/
    public void setPickDate(Date pickDate){
        _pickDate = new Date(pickDate);
    }
    /** Sets the return date
     * The return date must be at least one day after the pick up date, otherwise - don't change the return date 
       @param returnDate the return date*/
    public void setReturnDate(Date returnDate){
        _returnDate = new Date(returnDate);
    }
    /**Check if 2 rents are the same
       @param the rent to compare this rent to
       @return true if the rents are the same*/
    public boolean equals(Rent other){
        return (getName().equals(other.getName())
                && getPickDate().equals(other.getPickDate())
                && getReturnDate().equals(other.getReturnDate()));
    }
    /**Returns the number of rent days
       @return the nu,ber of rent days*/
    public int howManyDays(){
        return getReturnDate().difference(getPickDate());
    }
    /**Returns the rent total price
       @return the rent total price*/
    public int getPrice(){
        int pricePerDay;
        switch (getCar().getType()){
            case 'A':
                pricePerDay = 100;
                break;
            case 'B':
                pricePerDay = 150;
                break;
            case 'C':
                pricePerDay = 180;
                break;
            default:
                pricePerDay = 240;
                break;
        }
        final double DISCOUNTAFTERSEVENDAYS = 0.9;
        return (int)(((howManyDays() / 7) * DISCOUNTAFTERSEVENDAYS * 7 +  howManyDays() % 7) * pricePerDay);
        
    }
    /**Try to upgrade the car to a better car
     * If the given car is better than the current car of the rent, upgrade it and return the upgrade additional cost, otherwise - don't upgrade
       @param newCar the car to upgrade
       @return the upgrade cost*/
    public int upgrade (Car newCar){
        if (newCar.better(getCar())){
            int currentPrice = getPrice();
            setCar(newCar);
            return getPrice() - currentPrice;
        }
        return 0;
    }
    /**Check if there is a double listing of a rent for the same person and car with an overlap in the rental days
     * If there is - return a new rent object with the unified dates, otherwise - return null.
       @param other the other rent
       @return the unified rent or null*/
    public Rent overlap (Rent other){
        if (getName().equals(other.getName()) && getCar().equals(other.getCar())){
            if (isCarDatesContainedInOther(other))
                return new Rent(getName(), new Car(getCar()), new Date(getPickDate()), new Date(getReturnDate()));
            else if (other.isCarDatesContainedInOther(this))
                return new Rent(getName(), new Car(other.getCar()), new Date(other.getPickDate()), new Date(other.getReturnDate()));
            else if (isCarDatesIntersectInOther(other))
                return new Rent(getName(), new Car(getCar()), new Date(getPickDate()), new Date(other.getReturnDate()));
            else if (other.isCarDatesIntersectInOther(this))
                return new Rent(getName(), new Car(getCar()), new Date(other.getPickDate()), new Date(getReturnDate()));
            else
            return null;
        }
        return null;
    }
    /**Checks if a date is before or equals to a given date*/
    private boolean isDateBeforeOrEquals(Date date1, Date date2){
        return (date1.before(date2) || date1.equals(date2));
    }
    /**Checks if a date is afteror equals to a given date*/
    private boolean isDateAfterOrEquals(Date date1, Date date2){
        return (date1.after(date2) || date1.equals(date2));
    }
    /**Checks if a car pickup date and return date are contained in another's car */
    private boolean isCarDatesContainedInOther(Rent other){
        return (isDateBeforeOrEquals(getPickDate(), other.getPickDate()) && isDateAfterOrEquals(getReturnDate(), other.getReturnDate()));
    }
    /**Checks if a car rent dates are intersected in another's car */
    private boolean isCarDatesIntersectInOther(Rent other){
        return (isDateBeforeOrEquals(getPickDate(), other.getPickDate()) && isDateAfterOrEquals(other.getReturnDate(), getReturnDate()));
    }
    /**
     * Returns a String that represents this rent
     * @return String that represents this rent in the following format:
        Name:Rama From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
       */ 
    public String toString(){
        return "Name:"+getName()+" From:"+getPickDate()+" To:"+ getReturnDate()+" Type:"+getCar().getType()+" Days:"+howManyDays()+" Price:"+getPrice();
    }
}
