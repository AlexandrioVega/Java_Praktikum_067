package Task1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alexandrio", "Computer Science", "Jakarta"));
        studentList.add(new Student(2, "Raihan", "Computer Science", "Cimahi"));
        studentList.add(new Student(3, "Gema", "Mathematics", "Bandung"));
        studentList.add(new Student(4, "Ibnu", "Art", "Banten"));
        studentList.add(new Student(5, "Ikhsan", "Astronomy", "Tangerang"));

        studentList.sort(Comparator.comparing(Student::getName));    
        
        System.out.println("============================================");
        System.out.println("Sorting ArrayList berdasarkan nama dari A-Z");
        System.out.println("============================================\n");
        for(Student s : studentList){
            System.out.println(s.toString());
        }
        System.out.println();

        Vector<Student> studentList2 = new Vector<>();
        studentList2.add(new Student(1, "Alexandrio", "Computer Science", "Jakarta"));
        studentList2.add(new Student(2, "Raihan", "Computer Science", "Cimahi"));
        studentList2.add(new Student(3, "Gema", "Mathematics", "Bandung"));
        studentList2.add(new Student(4, "Ibnu", "Art", "Banten"));
        studentList2.add(new Student(5, "Ikhsan", "Astronomy", "Tangerang"));
        
        System.out.println("====================================================================");
        System.out.println("Menampilkan mahasiswa yang berasal dari department Computer Science");
        System.out.println("====================================================================\n");
        for(Student s : studentList2){
            if(s.getDepartment().equals("Computer Science")){
                System.out.println(s.toString());
            }
        }
    }
}
