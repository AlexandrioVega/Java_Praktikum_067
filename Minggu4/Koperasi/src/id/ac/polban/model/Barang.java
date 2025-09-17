package Koperasi.src.id.ac.polban.model;

public class Barang{
    private String namabarang;
    private int hargabarang;
    private int stokbarang; 
    private int stokbarangpasti;
    private String tipe = "Barang biasa";

    public Barang(String nama, int harga, int stok){
        this.namabarang = nama;
        this.hargabarang = harga;
        this.stokbarang = stok;
        this.stokbarangpasti = stok;
    }

    public Barang(String nama, int harga, int stok, String tipe){
        this.namabarang = nama;
        this.hargabarang = harga;
        this.stokbarang = stok;
        this.stokbarangpasti = stok;
        this.tipe = tipe;
    }

    public String getNama(){
        return namabarang;
    }

    public int getHarga(){
        return hargabarang;
    }

    public int getStok(){
        return stokbarang;
    }
  
    public int getStokYangDibeli(){
        return this.stokbarangpasti - this.stokbarang;
    }
    
    public String getTipe(){
        return this.tipe;
    }

    public void setStok(int jumlah){
        this.stokbarang -= jumlah;
    }

    public void setTipe(String tipe){
        this.tipe = tipe;
    }


}