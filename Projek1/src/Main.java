import java.util.ArrayList;
import java.util.Scanner;
import id.ac.polban.model.Barang;
import id.ac.polban.service.*;


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

    private static void menuBeliBarang(Scanner sc){
        lihatMenu(koperasi.getBarang());
        beliBarang(sc);
    }

    private static void beliBarang(Scanner sc){
        System.out.println("===========================");
        int nomer;
        int jumlah;
        
        do{
            Barang beliBarang; 
            System.out.print("Masukkan nomor = ");
            nomer = sc.nextInt();
            if(nomer == 7){
                break;
            }
            if(nomer < 1 || nomer > 6){
                continue;
            }
            try{
                System.out.print("Masukkan Jumlah = ");
                jumlah = sc.nextInt();
                beliBarang = koperasi.getBarangSatuan(nomer - 1);
                // pengecekan
                if( beliBarang.getStok() >= jumlah){
                    koperasi.hitungTotalHarga(beliBarang.getHarga() * jumlah);
                    koperasi.setStokBarang(jumlah, nomer - 1);
                }
                else{
                    System.out.println("Jumlah tidak tersedia");
                }


            }catch(Exception e){
                System.out.println("Input salah...");
            }
               
            
        }while(nomer != 7);

        System.out.println("Total harga = "+koperasi.getTotalHarga());
        System.out.println();
        koperasi.setTotalHarga(0);
    }

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

    private static void lihatMenu(ArrayList<Barang>tampilkanBarang){
        System.out.println();
        int i = 1;
        System.out.println("===== Daftar Barang =====");
        for(Barang tampilkan:tampilkanBarang){
            System.out.println(i+". "+tampilkan.getNama()+" Rp-"+ tampilkan.getHarga() +" Stock = "+ tampilkan.getStok());
            i += 1;
        }
        System.out.println(i+". Bayar");
        System.out.println();

    }
   
    
    private static ArrayList<Barang> setDaftarBarang(){
        ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
        daftarBarang.add(new Barang("Spidol",5000 , 25));
        daftarBarang.add(new Barang("Pulpen",5000 , 25));
        daftarBarang.add(new Barang("Buku",7500 , 25));
        daftarBarang.add(new Barang("Kertas",100 , 10000));
        daftarBarang.add(new Barang("Topi sekolah",20000 , 20));
        daftarBarang.add(new Barang("Dasi sekolah",15000 , 20));

        return daftarBarang;

    }
}