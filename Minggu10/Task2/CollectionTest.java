package Task2;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class CollectionTest {
    public static void main(String[] args) {
        ArrayList<String> countriesSet = new ArrayList<String>();
        
        countriesSet.add("Indonesia");
        countriesSet.add("Jepang");
        countriesSet.add("Argentina");
        countriesSet.add("Maroko");
        countriesSet.add("Thailand");
        countriesSet.add("Brunei");
        
        System.out.println("Before Collections.sort");
        System.out.println("Set countriesSet : "+ countriesSet);
        
        Collections.sort(countriesSet);

        System.out.println("After Collections.sort");
        System.out.println("Set countriesSet : "+ countriesSet);
    }
}
