package Koperasi.src.id.ac.polban.model;

public class BarangElektronik extends Barang{
    private int garansi;
    

    //Constructor dengan memanggil constructor pada superclass yaitu class Barang
    public BarangElektronik(String nama, int harga, int stok, int garansi){
        super(nama, harga, stok, "Elektronik");
        this.garansi = garansi;
    }

    public int getGaransi(){
        return this.garansi;
    }


    // Override agar barang ditandai dengan nama elektronik
    @Override
    public String getNama(){
        return super.getNama() + " (" + super.getTipe() + ")";
    }

}
