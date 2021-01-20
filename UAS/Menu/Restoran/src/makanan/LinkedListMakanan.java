/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makanan;

/**
 *
 * @author L
 */
public class LinkedListMakanan {
    private NodeMakanan head = null;
    private NodeMakanan tail = null;
    private int size = 0;
    
    public int getSize() {
        System.out.println("Banyak Kategori " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeMakanan head() {
        if (isEmpty()) return null;
        return head;
    }

    public NodeMakanan tail() {
        if (isEmpty()) return null;
        return tail;
    }
    
    //kategori paling baru akan ditambah paling depan
    public void addMakanan(Makanan makanan){
        NodeMakanan newMakanan = new NodeMakanan();

        newMakanan.setPrev(null);
        newMakanan.setMakanan(makanan);
        newMakanan.setNext(head);

        if(size == 0){
            head = newMakanan;
            tail = head;
        }
        else{
            head.setPrev(newMakanan);
            head = newMakanan;
        }
    
        size++;
    }
    
    //remove category
    public Makanan removeMakanan(String makanan){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeMakanan data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getMakanan().namaMakanan.toLowerCase().equals(makanan.toLowerCase())) {
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
                Makanan removeMakanan = data.getMakanan();
                NodeMakanan nextData = data.getNext();
                NodeMakanan beforeData = data.getPrev();

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

                System.out.println("Berhasil Remove " + removeMakanan.namaMakanan + " dari Kategori");
                return removeMakanan;
            }
        }
    }
    
    //search category with data
    public Makanan searchMakananWithData(String makanan){
        if(isEmpty() || head == null){
            return null;
        }
        else{
            NodeMakanan data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getMakanan().namaMakanan.toLowerCase().equals(makanan.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                return null;
            }
            else{
                return data.getMakanan();
            }
        }
    }
}
