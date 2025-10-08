package kasus1;

//**********************************************************
// Executive.java
// Represents an executive staff member, who can earn a bonus.
//**********************************************************

public class Executive extends Employee {
    private double bonus;

    public Executive(String name, String address, String phone,
                     String socialSecurityNumber, double payRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        bonus = 0;  // default
    }

    public void awardBonus(double execBonus) {
        bonus = execBonus;
    }

    public double pay() {
        double payment = super.pay() + bonus;
        bonus = 0;  // reset after paying
        return payment;
    }
}
