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
class Factura {
 
    private int cod;
    private String denumire;
    private String  pret;
    private String  codc;
    private String  nume;
    private String  numar;
    private String  cantitate;
    private String  pretfact;
    private String  titular;
    private String  nrcard;
    private String  cvc;
    private String  exptcard;
    private String  datafact;
     
    public Factura(int pcod, String pdenumire, String ppret,String pcodc,String pnume,String pnumar,String pcantitate,String ppretfact,String ptitular,String pnrcard,String pcvc,String pexpcard,String pdatafact){
        this.cod=pcod;
        this.denumire=pdenumire;
        this.pret=ppret;
        this.codc=pcodc;
        this.nume=pnume;
        this.numar=pnumar;
        this.cantitate=pcantitate;
        this.pretfact=ppretfact;
        this.titular=ptitular;
        this.nrcard=pnrcard;
        this.cvc=pcvc;
        this.exptcard=pexpcard;
        this.datafact=pdatafact;    
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
    
    public String getcodc(){
        return codc;
    }
    public String getnume(){
        return nume;
    }
     public String getnumar(){
        return numar;
    }
    public String getcantitate(){
        return cantitate;
    }
    public String getpretfact(){
        return pretfact;
    }
    public String gettitular(){
        return titular;
    }
    public String getnrcad(){
        return nrcard;
    }
    public String getcvc(){
        return cvc;
    }
    public String getexptcard(){
        return exptcard;
    }
    public String getdatafact(){
        return datafact;
    }
}

