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
public class AssociativaConjunto {
    private int slot;
    private int tamanhoPlavra;    
    private double acessoCache;
    private double acessoPrincipal;
    private String substituir ="";
    private int hit;
    private int miss;

  
    public int getSlot() {
        return slot;
    } void setSlot(int slot) {
        this.slot = slot;
    }

    public int getTamanhoPlavra() {
        return tamanhoPlavra;
    }
    public void setTamanhoPlavra(int tamanhoPlavra) {
        this.tamanhoPlavra = tamanhoPlavra;
    }

    public double getAcessoCache() {
        return acessoCache;
    }
    public void setAcessoCache(double acessoCache) {
        this.acessoCache = acessoCache;
    }

    public double getAcessoPrincipal() {
        return acessoPrincipal;
    }
    public void setAcessoPrincipal(double acessoPrincipal) {
        this.acessoPrincipal = acessoPrincipal;
    }

    public String getSubstituir() {
        return substituir;
    }
    public void setSubstituir(String substituir) {
        this.substituir = substituir;
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
    
}
