public abstract class A {

      protected int _aVal;
      
      public A(){
          System.out.println("Empty");
          _aVal = 3;
      }

      public A(int aVal){
          System.out.println("A");
          _aVal = aVal;
      }
      public abstract boolean foo(int n);
      
      public boolean equals (Object obj)

{

      if (!(obj instanceof A)){


            return false;
        }
      return _aVal==((A)obj)._aVal;


}}