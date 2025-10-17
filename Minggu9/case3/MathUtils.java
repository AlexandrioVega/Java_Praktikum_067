package case3;

// ****************************************************************
// MathUtils.java
//
// Provides static mathematical utility functions.
//
// ****************************************************************
public class MathUtils{
    //-------------------------------------------------------------
    // Returns the factorial of the argument given
    //-------------------------------------------------------------
    public static int factorial(int n) throws IllegalArgumentException{
        if (n < 0){
            throw new IllegalArgumentException("Faktorial tidak terdefinisi untuk bilangan negatif");
        }
        else if(n > 16){
            throw new IllegalArgumentException("Hasil faktorial terlalu besar (overflow) untuk tipe int");
        }
        int fac = 1;
        for (int i=n; i>0; i--)
            fac *= i;
        return fac;
    }
}