/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapearmemoriacache;

/**
 *
 * @author Rafael
 */
public class TotalmenteAssociativa {
    private int slot;
    private int TamanhoPlavra;
    private int Associatividade;
    private double AcessoCache;
    private double AcessoPrincipal;
    private String substituir ="";
    private int hit;
    private int miss;
    

    public int getSlot() {
        return slot;
    }
     public void setSlot(int slot) {
        this.slot = slot;
    }

     public int getTamanhoPlavra() {
        return TamanhoPlavra;
    }
     public void setTamanhoPlavra(int TamanhoPlavra) {
        this.TamanhoPlavra = TamanhoPlavra;
    }

    public double getAcessoCache() {
        return AcessoCache;
    }
    public void setAcessoCache(double AcessoCache) {
        this.AcessoCache = AcessoCache;
    }

    public double getAcessoPrincipal() {
        return AcessoPrincipal;
    }
    public void setAcessoPrincipal(double AcessoPrincipal) {
        this.AcessoPrincipal = AcessoPrincipal;
    }

 
    public int getHit() {
        return hit;
    }  
    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getMiss() {
        return miss;
    }
    public void setMiss(int miss) {
        this.miss = miss;
    }

    public int getAssociatividade() {
        return Associatividade;
    }
    public void setAssociatividade(int Associatividade) {
        this.Associatividade = Associatividade;
    }

    public String getSubstituir() {
        return substituir;
    }
    public void setSubstituir(String substituir) {
        this.substituir = substituir;
    }
}
