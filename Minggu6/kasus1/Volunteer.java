package kasus1;
//**********************************************************
// Volunteer.java
// Represents a staff member that works as a volunteer.
//**********************************************************

public class Volunteer extends StaffMember {

    public Volunteer(String name, String address, String phone) {
        super(name, address, phone);
    }

    public double pay() {
        return 0.0;
    }
}
