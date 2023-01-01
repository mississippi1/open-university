
/**
 * Write a description of class B here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class B extends A
{
    // instance variables - replace the example below with your own
    private int _bVal;

    /**
     * Constructor for objects of class B
     */
    public B(int aVal, int bVal)
    {
        super(aVal);
        _bVal = bVal;
    }

    public boolean foo(int n){
        return n == _bVal;
    }
    public boolean equals (A obj)

{

      if(!(obj instanceof B))
            return false;

      return _aVal == obj._aVal && _bVal == ((B)obj)._bVal;


}
}
