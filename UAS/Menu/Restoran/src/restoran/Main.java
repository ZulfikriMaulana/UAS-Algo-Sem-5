/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoran;

import java.util.Scanner;
import koki.Koki;
import koki.LinkedListKoki;
import makanan.LinkedListMakanan;
import makanan.Makanan;
import relasi.LinkedListRelasi;
import relasi.Relasi;

/**
 *
 * @author L
 */
public class Main { //kelas
    static LinkedListMakanan linkedListMakanan = new LinkedListMakanan();
    static LinkedListKoki linkedListKoki = new LinkedListKoki();
    static LinkedListRelasi linkedListRelasi = new LinkedListRelasi();
    static Scanner input = new Scanner(System.in);
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { //tempat menjalankan utama menu
        // TODO code application logic here
        showMenu();

    }
    
    public static void showMenu(){ //menampilkan menu
        int pilihan = 0;

        try{
            do{
                System.out.println("----- SELAMAT DATANG DI RESTORAN ----");

                //menu
                System.out.println("---- KOKI ----");
                System.out.println("1. List Koki");
                System.out.println("2. Tambah Koki");
                System.out.println("3. Hapus Koki");
                
                //makanan
                System.out.println("---- MAKANAN ----");
                System.out.println("4. List Makanan");
                System.out.println("5. Tambah Makanan");
                System.out.println("6. Hapus Makanan");

                System.out.println("---- Keluar ----");
                System.out.println("0. Keluar");

                System.out.println("-------------------");
                System.out.print("Silahkan Pilih  : ");

                pilihan = input.nextInt();

                switch (pilihan) { //menentukan pilihan
                    case 0:
                        System.exit(0);
                        break;
                        
                    case 1:
                        listKoki();
                        break;
                    
                    case 2:
                        tambahKoki();
                        break;
                        
                    case 3:
                        hapusKoki();
                        break;
                    
                    case 4:
                        listMakanan();
                        break;
                        
                    case 5:
                        tambahMakanan();
                        break;
                        
                    case 6:
                        hapusMakanan();
                        break;    
                        
                        
                    default:
                        System.out.println("Pilihan salah!");
                }

            }while (pilihan != 0);

        }

        catch (Exception e){ //jika salah input akan muncul ini
            System.out.println(e);
            System.out.println("Masukkan data yang benar");
        }
    }
    
    
    
    public static void listKoki(){ 
        System.out.println("---- LIST KOKI ------");
        linkedListKoki.printlist();
    }
    
    public static void tambahKoki(){
        System.out.println("---- TAMBAH KOKI ----");

        //show list tambah koki
        linkedListKoki.printlist();

        //kategori
        input = new Scanner(System.in);

        System.out.print("Nama Koki         : ");
        String namakoki = input.nextLine();

        //create new koki
        Koki koki = new Koki(namakoki);

        //add koki to koki
        linkedListKoki.addKoki(koki);
    }
    
    public static void hapusKoki(){
        System.out.println("---- HAPUS KOKI ------");

        // list koki yang ingin dihapus
        linkedListKoki.printlist();

        //input koki yang ingin dihapus
        input = new Scanner(System.in);
        System.out.print("Koki         : ");
        String namakoki = input.nextLine();
        linkedListKoki.removeKoki(namakoki);
    }
    
    public static void listMakanan(){
        System.out.println("---- LIST MAKANAN ------");
        linkedListRelasi.printListAll();
    }
    
    //tambah makanan
    public static void tambahMakanan(){
        System.out.println("---- TAMBAH MAKANAN ------");

        //pilih koki
        input = new Scanner(System.in);
        linkedListKoki.printlist();
        System.out.print("Koki       : ");
        String namakoki = input.nextLine();

        //search koki found
        Koki kokiFound = linkedListKoki.searchKokiWithData(namakoki);

        if(kokiFound != null){
            //makanan
            System.out.print("Makanan           : ");
            String namaMakanan = input.nextLine();

            //create new makanan and add to makanan linkedlist
            Makanan makanan = new Makanan(namaMakanan);
            linkedListMakanan.addMakanan(makanan);

            //create new relation and add to relation linkedlist
            Relasi relasi = new Relasi(makanan, kokiFound);
            linkedListRelasi.addRelasi(relasi);
        }

        else{
            if(kokiFound == null){
                System.out.println("Maaf Koki Tidak Ditemukan");
            }

            else{
                System.out.println("Maaf Penulis dan Kategori Tidak Ditemukan");
            }
        }

    }
    
     public static void hapusMakanan(){
        System.out.println("---- HAPUS MAKANAN ------");

        //input nama makanan yang ingin dihapus
        System.out.print("Makanan      : ");
        input = new Scanner(System.in); 
        String namaMakanan = input.nextLine();

        //remove relasi linkedlist
        Relasi deleteRelasi = linkedListRelasi.removeRelasi(namaMakanan);

        //ketika makanan tidak ditemukan muncul kalimat
        if(deleteRelasi == null){
            System.out.println("Maaf Data Tidak ditemukan");
        }

        //ketika data ditemukan
        else{
            //get title
            String hapusMakanan = deleteRelasi.getMakanan().getNamaMakanan();

            //remove from makanan linkedlist
            linkedListMakanan.removeMakanan(hapusMakanan);
            System.out.println(hapusMakanan + " Berhasil di Hapus");
        }
    }
    
}
