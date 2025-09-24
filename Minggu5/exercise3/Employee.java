package exercise3;
public class Employee extends Sortable { 
    private String name;
    private double salary;
    private int hireday;
    private int hiremonth;
    private int hireyear;

    public Employee(String n, double s, int day, int month, int year) {
        name = n;
        salary = s;
        hireday = day;
        hiremonth = month;
        hireyear = year;
    }

    // ... method lain seperti print(), raiseSalary(), etc. tetap sama ...
    public void print() {
        System.out.println(name + " | Gaji: " + salary + " | Tahun bekerja: " + hireYear());
    }

    public void raiseSalary(double byPercent) {
        salary *= 1 + byPercent / 100;
    }

    public int hireYear() {
        return hireyear;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
    
    // IMPLEMENTASI METHOD DARI SORTABLE
    @Override
    public int compare(Sortable b) {
        Employee eb = (Employee) b; // Casting objek Sortable ke Employee
        if (this.salary < eb.salary) {
            return -1; // Gaji objek ini lebih kecil
        }
        if (this.salary > eb.salary) {
            return 1; // Gaji objek ini lebih besar
        }
        return 0; // Gaji sama
    }
}