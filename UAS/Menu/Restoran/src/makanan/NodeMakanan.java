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
public class NodeMakanan {
    private NodeMakanan prev, next;
    private Makanan makanan;

    public NodeMakanan getPrev() {
        return prev;
    }

    public void setPrev(NodeMakanan prev) {
        this.prev = prev;
    }

    public NodeMakanan getNext() {
        return next;
    }

    public void setNext(NodeMakanan next) {
        this.next = next;
    }

    public Makanan getMakanan() {
        return makanan;
    }

    public void setMakanan(Makanan makanan) {
        this.makanan = makanan;
    }
    
    
}
