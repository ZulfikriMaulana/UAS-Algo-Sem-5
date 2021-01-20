/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relasi;

import koki.Koki;
import koki.NodeKoki;

/**
 *
 * @author L
 */
public class LinkedListRelasi {
    private NodeRelasi head = null;
    private NodeRelasi tail = null;
    private int size = 0;
    
    public int getSize() {
        System.out.println("Banyak  " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeRelasi head() {
        if (isEmpty()) return null;
        return head;
    }

    public NodeRelasi tail() {
        if (isEmpty()) return null;
        return tail;
    }
    
    //kategori paling baru akan ditambah paling depan
    public void addRelasi(Relasi relasi){
        NodeRelasi newRelasi = new NodeRelasi();

        newRelasi.setPrev(null);
        newRelasi.setRelasi(relasi);
        newRelasi.setNext(head);

        if(size == 0){
            head = newRelasi;
            tail = head;
        }
        else{
            head.setPrev(newRelasi);
            head = newRelasi;
        }
    
        size++;
    }
    
    //remove category
    public Relasi removeRelasi(String makanan){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeRelasi data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getRelasi().makanan.getNamaMakanan().toLowerCase().equals(makanan.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            //ketika data tidak ditemukan
            if( i + 1 > size){
                System.out.println("Maaf Data Tidak Ditemukan");
                return null;
            }

            //ditemukan
            else{
                Relasi removeRelasi = data.getRelasi();
                NodeRelasi nextData = data.getNext();
                NodeRelasi beforeData = data.getPrev();

                //if remove account in head
                if(beforeData == null){

                    //when next data didnt null
                    if(nextData != null)
                        nextData.setPrev(null);


                    size--;

                    //if size 1
                    if(size == 1){
                        head = nextData;
                        tail = nextData;
                    }

                    //else
                    else{
                        head = nextData;
                    }
                }

                //if remove tail data
                else if(nextData == null){

                    if(beforeData != null)
                        beforeData.setNext(null);


                    size--;

                    //if size 1
                    if(size == 1){
                        head = beforeData;
                        tail = beforeData;
                    }

                    //else
                    else{
                        tail = beforeData;
                    }
                }

                //else
                else{
                    beforeData.setNext(nextData);
                    nextData.setPrev(beforeData);

                    size--;

                    if(size == 1){
                        head = nextData;
                        tail = nextData;
                    }
                }

                System.out.println("Berhasil Remove " + removeRelasi.makanan + " dari Kategori");
                return removeRelasi;
            }
        }
    }
    
    public void printListAll(){
        int number = 1;
        NodeRelasi data = head;
        String makanan = "";
        String koki = "";
        
        
        if(isEmpty()){
            System.out.println("Maaf Data Kosong");
        }
        else if(data.getNext() == null){
            makanan = data.getRelasi().makanan.getNamaMakanan();
            koki = data.getRelasi().koki.getNamaKoki();

            System.out.println( "("+ number + ") " + makanan + ", " + koki );
        }
        else{

            while (data.getNext() != null){

                //print data
                makanan = data.getRelasi().makanan.getNamaMakanan();
                koki = data.getRelasi().koki.getNamaKoki();

                System.out.println( "("+ number + ") " + makanan + ", " + koki );

                //get next data while data founded
                data = data.getNext();
                number++;
            }

            makanan = data.getRelasi().makanan.getNamaMakanan();
            koki = data.getRelasi().koki.getNamaKoki();

            System.out.println( "("+ number + ") " + makanan + ", " + koki );
        }
    }
}