/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

/**
 *
 * @author stroe
 */
class Produse {
    private int cod;
    private String denumire;
    private String  pret;
     
    public Produse(int pcod, String pdenumire, String ppret){
        this.cod=pcod;
        this.denumire=pdenumire;
        this.pret=ppret;
    }
    
    public int getcod(){
        return cod;
    }
    
    public String getdenumire(){
        return denumire;
    }
    
    public String getpret(){
        return pret;
    }
    
    
}
