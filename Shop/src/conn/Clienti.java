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
class Clienti {
    private int cod;
    private String nume;
    private String  telefon;
    private String  strada;
    private String  numar;
    private String  tip;
     
    public Clienti(int pcod, String pnume, String ptelefon,String pstada,String pnumar,String ptip){
        this.cod=pcod;
        this.nume=pnume;
        this.telefon=ptelefon;
        this.strada=pstada;
        this.numar=pnumar;
        this.tip=ptip;
    }
    
    public int getcod(){
        return cod;
    }
    
    public String getnume(){
        return nume;
    }
    
    public String gettelefon(){
        return telefon;
    }
    public String getstrada(){
        return strada;
    }
    public String getnumar(){
        return numar;
    }
    public String gettip(){
        return tip;
    }
}
