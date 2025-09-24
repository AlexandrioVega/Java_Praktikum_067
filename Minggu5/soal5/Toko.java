package soal5;
public class Toko {
    public static void main(String[] args) {        
        
        Food apel = new Food("Apel merah", 0.50, 95);
        System.out.println("--- Food Detail ---");
        apel.display();
        System.out.println();

        Book javaBook = new Book("Effective Java 3rd Edition", 45.00, "Joshua Bloch");
        System.out.println("--- Book Detail ---");
        javaBook.display();
        double bookTax = javaBook.calculateTax();
        System.out.println("Tax: $" + String.format("%.2f", bookTax));
        System.out.println(); 

        Toy legoCar = new Toy("LEGO Ninjago", 19.99, 7);
        System.out.println("--- Toy Detail ---");
        legoCar.display();
        double toyTax = legoCar.calculateTax();
        System.out.println("Tax: $" + String.format("%.2f", toyTax));
        System.out.println(); // Spasi
    }
}