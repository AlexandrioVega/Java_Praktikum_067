package id.ac.polban.model;

public class Barang{
    private String namabarang;
    private int hargabarang;
    private int stokbarang; 
    private int stokbarangpasti;

    public Barang(String nama, int harga, int stok){
        this.namabarang = nama;
        this.hargabarang = harga;
        this.stokbarang = stok;
        this.stokbarangpasti = stok;
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

    public void setStok(int jumlah){
        this.stokbarang -= jumlah;
    }

}