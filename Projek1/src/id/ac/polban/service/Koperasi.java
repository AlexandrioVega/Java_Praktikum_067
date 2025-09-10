package id.ac.polban.service;
import id.ac.polban.model.*;

import java.util.ArrayList;

public class Koperasi{
    private int totalHarga = 0;
    private ArrayList <Barang> daftarBarang = new ArrayList<Barang>();
    private int totalHargaPembelian = 0; 


    public Koperasi(ArrayList<Barang>daftarBarang){
        this.daftarBarang = daftarBarang;
    }

    public ArrayList<Barang> getBarang(){
        return daftarBarang;
    }

    public Barang getBarangSatuan(int nomer){
        return daftarBarang.get(nomer);
    }

    public void setTotalHarga(int harga){
        this.totalHarga = harga;
    }

    public void hitungTotalHarga(int harga){
        this.totalHarga += harga;
        this.totalHargaPembelian += harga;
    }
    
    public void setStokBarang(int jumlah, int nomer){
        this.daftarBarang.get(nomer).setStok(jumlah);
    }

    public int getTotalHarga(){
        return this.totalHarga;
    }

    public int getTotalHargaPembelian(){
        return this.totalHargaPembelian;
    }


}