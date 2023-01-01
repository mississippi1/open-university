public class Driver

{

     public static void main (String [] args)

    {

A b1 = new B(5,2);
A c1 = new C(5,2);
B b2 = new B(5,2);
C c2 = new C (3,4);

    System.out.println( b1.foo(2));
    System.out.println( !b2.foo(5));
    System.out.println( b2.foo(2));
    System.out.println( c1.foo(3));
    System.out.println( c2.foo(3));
    System.out.println( !c2.foo(4));
    System.out.println(b1.equals(b2));
    System.out.println(b2.equals(b1));
    System.out.println(b2.equals(b2));
    // System.out.println(b2._bVal);
    }

}