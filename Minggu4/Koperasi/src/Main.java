package Koperasi.src;
import java.util.ArrayList;
import java.util.Scanner;
import Koperasi.src.id.ac.polban.model.*;
import Koperasi.src.id.ac.polban.service.Koperasi;

// javac Koperasi/src/id/ac/polban/model/Barang.java Koperasi/src/id/ac/polban/model/BarangElektronik.java Koperasi/src/id/ac/polban/service/Koperasi.java Koperasi/src/Main.java
public class Main{
    private static Koperasi koperasi;
    public static void main(String[] args){
        ArrayList<Barang> daftarBarang = setDaftarBarang();
        koperasi = new Koperasi(daftarBarang);
        Scanner sc = new Scanner(System.in);
        int pilih;
       
       
        do{ 
            
            System.out.println("=====  Menu Koperasi  =====");
            System.out.println("= 1. Beli Barang          =");
            System.out.println("= 2. Data pembelian       =");
            System.out.println("= 3. Keluar               =");
            System.out.println("===========================");
            System.out.print("Pilih opsi [1/2/3] = ");
            pilih = sc.nextInt();
            if(pilih == 1){
                menuBeliBarang(sc);
            }
            if(pilih == 2){
                dataPembelian(koperasi.getBarang());
            }
            if(pilih == 3){
                System.exit(0);
            }
    
            
        }while(pilih != 3);
        sc.close();
    }

    // Methode untuk memanggil methode lihatMenu() dan beliBarang() 
    private static void menuBeliBarang(Scanner sc){
        lihatMenu(koperasi.getBarang());
        beliBarang(sc);
    }

    // Methode untuk melakukan transaksi pembelian barang
    private static void beliBarang(Scanner sc){
        System.out.println("===========================");
        int nomer;
        int jumlah;
        Barang beliBarang; 
        
        do{
            System.out.print("Masukkan nomor = ");
            nomer = sc.nextInt();
            if(nomer == 0){
                break;
            }
            if(nomer < 1 || nomer > 10){
                continue;
            }
            if(nomer == 10){
                lihatGaransi(koperasi.getBarang());
                continue;
            }
            try{
                System.out.print("Masukkan Jumlah = ");
                jumlah = sc.nextInt();
                beliBarang = koperasi.getBarangSatuan(nomer - 1);
                
                // pengecekan stok barang
                if( beliBarang.getStok() >= jumlah){
                    // jika stok barang <= barang yang dibeli, maka dilakukan pembelian
                    koperasi.hitungTotalHarga(beliBarang.getHarga() * jumlah);
                    // pengurangan stok barang setelah dibeli
                    koperasi.setStokBarang(jumlah, nomer - 1);
                }
                else{
                    System.out.println("Jumlah tidak tersedia");
                }


            }catch(Exception e){
                System.out.println("Input salah...");
            }
               
            
        }while(nomer != 0);

        System.out.println();
        System.out.println("===========================");
        System.out.println("Total harga = "+koperasi.getTotalHarga());
        System.out.println("===========================");
        System.out.println();
        koperasi.setTotalHarga(0);
    }

    // Menampilkan detail pembelian yang pernah dilakukan
    private static void dataPembelian(ArrayList<Barang>tampilkanBarang){
        System.out.println();
        System.out.println("Total pembelian:"+koperasi.getTotalHargaPembelian());
        int i = 1;
        for(Barang tampilkan : tampilkanBarang){
            System.out.println(i+". "+tampilkan.getNama()+" jumlah yang terjual: "+tampilkan.getStokYangDibeli());
            i++;
        }
        System.out.println();
    
    }

    // Menampilkan menu barang yang dijual
    private static void lihatMenu(ArrayList<Barang>tampilkanBarang){
        System.out.println();
        int i = 1;
        System.out.println("===== Daftar Barang =====");
        for(Barang tampilkan:tampilkanBarang){
            System.out.println(i+". "+tampilkan.getNama()+" Rp-"+ tampilkan.getHarga() +" Stock = "+ tampilkan.getStok());
            i += 1;
        }
        System.err.println(i + ". Lihat garansi barang elektronik");
        System.out.println("0 . Bayar");
        System.out.println();
    }

    // Menampilkan lama waktu garansi khusus untuk barang Elektronik
    private static void lihatGaransi(ArrayList<Barang> tampilkanBarang){
        
        System.out.println();
        System.out.println("===== Daftar Barang =====");

        for(Barang barang: tampilkanBarang){
            barang.getTipe();
            // Bisa pakai instanceof

            // pengecekan apakah barang yang sedang dicek bertipe Elektronik
            if("Elektronik".equals(barang.getTipe())){
                BarangElektronik barangElektronik = (BarangElektronik) barang;
                System.out.println(barangElektronik.getNama()+" Garansi "+ barangElektronik.getGaransi()+ " bulan");
            }
        }

        System.out.println();
    }
   
    // Methode untuk memasukkan data barang yang dijual
    private static ArrayList<Barang> setDaftarBarang(){
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
        daftarBarang.add(new Barang("Spidol",5000 , 25));
        daftarBarang.add(new Barang("Pulpen",5000 , 25));
        daftarBarang.add(new Barang("Buku",7500 , 25));
        daftarBarang.add(new Barang("Kertas",100 , 10000));
        daftarBarang.add(new Barang("Topi sekolah",20000 , 20));
        daftarBarang.add(new Barang("Dasi sekolah",15000 , 20));
        daftarBarang.add(new BarangElektronik("kalkulator",30000 , 7, 12));
        daftarBarang.add(new BarangElektronik("Baterai",20000 , 15, 6));
        daftarBarang.add(new BarangElektronik("LCD Writing",500000 , 15, 12));

        return daftarBarang;

    }
}