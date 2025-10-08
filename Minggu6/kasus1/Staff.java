package kasus1;

//**********************************************************
// Staff.java
// Sets up a list of staff members for a firm.
//**********************************************************

public class Staff {
    private StaffMember[] staffList;

    public Staff() {
        staffList = new StaffMember[8];

        staffList[0] = new Executive("Sam", "123 Main Line", "555-0469",
                "123-45-6789", 2423.07);

        staffList[1] = new Employee("Carla", "456 Off Line", "555-0101",
                "987-65-4321", 1246.15);

        staffList[2] = new Employee("Woody", "789 Off Rocker", "555-0000",
                "010-20-3040", 1169.23);

        staffList[3] = new Hourly("Diane", "678 Fifth Ave.", "555-0690",
                "958-47-3625", 10.55);

        staffList[4] = new Volunteer("Norm", "987 Suds Blvd.", "555-8374");
        staffList[5] = new Volunteer("Cliff", "321 Duds Lane", "555-7282");

        // Dua pegawai bertipe Commission
        Commission c1 = new Commission("Alex Vega", "Jl. Merdeka 1", "555-1111",
                "111-22-3333", 6.25, 0.20);
        Commission c2 = new Commission("Bonito Vega", "Jl. Sudirman 5", "555-2222",
                "444-55-6666", 9.75, 0.15);

        staffList[6] = c1;
        staffList[7] = c2;

        // Set jam kerja dan penjualan
        ((Executive) staffList[0]).awardBonus(500.00);
        ((Hourly) staffList[3]).addHours(40);

        c1.addHours(35);
        c1.addSales(400);
        c2.addHours(40);
        c2.addSales(950);
    }

    public void payday() {
        double amount;

        for (int count = 0; count < staffList.length; count++) {
            System.out.println(staffList[count]);

            amount = staffList[count].pay();  // polymorphic call

            if (amount == 0.0)
                System.out.println("Thanks!");
            else
                System.out.printf("Paid: $%.2f\n", amount);

            System.out.println("-----------------------------------");
        }
    }
}

