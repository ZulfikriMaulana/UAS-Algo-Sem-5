/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koki;

/**
 *
 * @author L
 */
public class LinkedListKoki {
    private NodeKoki head = null;
    private NodeKoki tail = null;
    private int size = 0;
    
    public int getSize() {
        System.out.println("Banyak Kategori " + size);
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public NodeKoki head() {
        if (isEmpty()) return null;
        return head;
    }

    public NodeKoki tail() {
        if (isEmpty()) return null;
        return tail;
    }
    
    //kategori paling baru akan ditambah paling depan
    public void addKoki(Koki koki){
        NodeKoki newKoki = new NodeKoki();

        newKoki.setPrev(null);
        newKoki.setKoki(koki);
        newKoki.setNext(head);

        if(size == 0){
            head = newKoki;
            tail = head;
        }
        else{
            head.setPrev(newKoki);
            head = newKoki;
        }
    
        size++;
    }
    
    //remove category
    public Koki removeKoki(String koki){
        if(isEmpty() || head == null){
            System.out.println("Maaf Data Kosong");
            return null;
        }

        else{
            NodeKoki data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getKoki().namaKoki.toLowerCase().equals(koki.toLowerCase())) {
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
                Koki removeKoki = data.getKoki();
                NodeKoki nextData = data.getNext();
                NodeKoki beforeData = data.getPrev();

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

                System.out.println("Berhasil Remove " + removeKoki.namaKoki + " dari Kategori");
                return removeKoki;
            }
        }
    }
    
    //search koki with data
    public Koki searchKokiWithData(String koki){
        if(isEmpty() || head == null){
            return null;
        }
        else{
            NodeKoki data = head;
            int i = 0;

            //looping if category didnt found
            while (!data.getKoki().namaKoki.toLowerCase().equals(koki.toLowerCase())) {
                data = data.getNext();
                i++;
                if(i + 1 > size)
                    break;
            }

            if( i + 1 > size){
                return null;
            }
            else{
                return data.getKoki();
            }
        }
    }
    
    public void printlist(){
        NodeKoki data = head;

        if(isEmpty()){
            System.out.println("List kategori kosong");
        }
        else if(data.getNext() == null){
            System.out.println(data.getKoki().namaKoki + " ");
        }
        else{
            while (data.getNext() != null){
                System.out.print(data.getKoki().namaKoki + ", ");
                data = data.getNext();
            }
            System.out.print(data.getKoki().namaKoki + ", ");
            System.out.println("");
        }
    }
    
}
