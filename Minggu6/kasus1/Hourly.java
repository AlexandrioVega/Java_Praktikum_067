package kasus1;

//**********************************************************
// Hourly.java
// Represents an employee that gets paid by the hour.
//**********************************************************

public class Hourly extends Employee {
    private int hoursWorked;

    public Hourly(String name, String address, String phone,
                  String socialSecurityNumber, double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        hoursWorked = 0;
    }

    public void addHours(int moreHours) {
        hoursWorked += moreHours;
    }

    public double pay() {
        double payment = payRate * hoursWorked;
        hoursWorked = 0; // reset hours after paying
        return payment;
    }

    public String toString() {
        String result = super.toString();
        result += "\nCurrent hours: " + hoursWorked;
        return result;
    }
}
