package Task2;

import java.util.HashSet;
import java.util.Set;

public class CountryCollection {

    public static void main(String[] args) {
        Set<String> countries = new HashSet<>();
      
        countries.add("Indonesia");              
        countries.add("Malaysia");             
        countries.add("Jepang");              
        countries.add("Thailand");              
        countries.add("Jepang"); 
        countries.add("Singapura");

        System.out.println("\n--- Hasil Koleksi Set ---");
        System.out.println("Negara dalam Set: " + countries);
        System.out.println("Total negara (duplikat diabaikan): " + countries.size());
    }
}