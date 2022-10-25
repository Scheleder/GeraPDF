/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerapdf;

/**
 *
 * @author jscheleder
 */
public class Foto {
    public String numero;
    public String arquivo;
    public int item;
    public String hist;
    public int action;
    public int inc;

    public Foto() {
    }

    public Foto(String numero, String foto, int item, String hist, int action, int inc) {
        this.numero = numero;
        this.arquivo = foto;
        this.item = item;
        this.hist = hist;
        this.action = action;
        this.inc = inc;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String foto) {
        this.arquivo = foto;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getHist() {
        return hist;
    }

    public void setHist(String hist) {
        this.hist = hist;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public int getInc() {
        return inc;
    }

    public void setInc(int inc) {
        this.inc = inc;
    }
    
    
}
