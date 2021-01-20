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
public class NodeKoki {
    private NodeKoki prev, next;
    private Koki koki;

    public NodeKoki getPrev() {
        return prev;
    }

    public void setPrev(NodeKoki prev) {
        this.prev = prev;
    }

    public NodeKoki getNext() {
        return next;
    }

    public void setNext(NodeKoki next) {
        this.next = next;
    }

    public Koki getKoki() {
        return koki;
    }

    public void setKoki(Koki koki) {
        this.koki = koki;
    }
    
    
    
}
