package exercise3;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        
        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi",3000000 , 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 2500000, 1, 11, 1993);

        System.out.println("--- Sebelum Sorting ---");
        for (Employee e : staff) {
            e.print();
        }
        
        // Panggil method static shell_sort dari kelas Sortable
        Sortable.shell_sort(staff);

        System.out.println("\n--- Setelah Sorting berdasarkan gaji ---");
        for (Employee e : staff) {
            e.print();
        }
    }
}