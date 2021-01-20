/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relasi;

/**
 *
 * @author L
 */
public class NodeRelasi {
    private NodeRelasi next, prev;
    private Relasi relasi;

    public NodeRelasi getNext() {
        return next;
    }

    public void setNext(NodeRelasi next) {
        this.next = next;
    }

    public NodeRelasi getPrev() {
        return prev;
    }

    public void setPrev(NodeRelasi prev) {
        this.prev = prev;
    }

    public Relasi getRelasi() {
        return relasi;
    }

    public void setRelasi(Relasi relasi) {
        this.relasi = relasi;
    }
    
    
    
}
