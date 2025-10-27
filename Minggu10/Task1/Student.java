package Task1;
public class Student{
    private int StudentID;
    private String Name;
    private String Department;
    private String Address;

    public Student(int StudentID, String Name, String Department, String Address){
        this.StudentID = StudentID;
        this.Name = Name;
        this.Department = Department;
        this.Address = Address;
    }

    public void setStudentID(int StudentID){this.StudentID = StudentID;}
    public void setName(String Name){this.Name = Name;}
    public void setDepartment(String Department){this.Department = Department;}
    public void setAddress(String Address){this.Address = Address;}

    public int getStudentID(){return this.StudentID;}
    public String getName(){return this.Name;}
    public String getDepartment(){return this.Department;}
    public String getAddress(){return this.Address;}

    @Override
    public String toString() {
        return "StudentID = '" + StudentID + "',\n" +
               "Name = '" + Name + "',\n" +
               "Address = '" + Address + "',\n" +
               "Department = " + Department + "\n";
    }

}
