package kasus1;

//**********************************************************
// Commission.java
// Represents an employee that is paid hourly and also earns
// a commission on sales.
//**********************************************************

public class Commission extends Hourly {
    private double totalSales;     // total penjualan
    private double commissionRate; // komisi 

    public Commission(String name, String address, String phone,
                      String socialSecurityNumber, double payRate,
                      double commissionRate) {
        super(name, address, phone, socialSecurityNumber, payRate);
        this.commissionRate = commissionRate;
        this.totalSales = 0;
    }

    public void addSales(double totalSales) {
        this.totalSales += totalSales;
    }

    @Override
    public double pay() {
        double payment = super.pay() + (commissionRate * totalSales);
        totalSales = 0; 
        return payment;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTotal Sales: " + totalSales;
    }
}
