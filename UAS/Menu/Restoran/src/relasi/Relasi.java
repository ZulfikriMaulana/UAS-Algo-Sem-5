/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relasi;

import koki.Koki;
import makanan.Makanan;

/**
 *
 * @author L
 */
public class Relasi {
    final Makanan makanan;
    final Koki koki;

    public Relasi(Makanan makanan, Koki koki) {
        this.makanan = makanan;
        this.koki = koki;
    }

    public Makanan getMakanan() {
        return makanan;
    }

    public Koki getKoki() {
        return koki;
    }
    
    
    
    
    
    
}
