/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luizg
 */
public class Ramo {
    int x1, y1, nivel;
    
    Ramo ant;
    public Ramo(int x1, int y1, Ramo ant, int nivel){
        this.x1 = x1;
        this.y1 = y1;
        this.ant = ant;
        this.nivel = nivel;
    }

    Ramo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Ramo(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Ramo(int moveX, int moveY, Ramo pai) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
