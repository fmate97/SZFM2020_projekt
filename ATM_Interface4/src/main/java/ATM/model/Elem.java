/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM.model;

/**
 *
 * @author Koppany
 */
public class Elem {
    
   private int FelhId;
   private String FelhNev;
   private int SzHId;
   private int History;
   private int HistoryID;

    public int getHistoryID() {
        return HistoryID;
    }

    
   private int Pin;
   private int SzamlaId;
   private int Osszeg;
   private String SzamlaNev;
   
   public Elem(int SzamlaId, int FelhId, int Osszeg, String SzamlaNev) {
        this.FelhId = FelhId;
        this.SzamlaId = SzamlaId;
        this.Osszeg = Osszeg;
        this.SzamlaNev = SzamlaNev;
    }
   public int getFelhId() {
        return FelhId;
    }

    public String getFelhNev() {
        return FelhNev;
    }

    public int getPin() {
        return Pin;
    }

    public int getSzamlaId() {
        return SzamlaId;
    }

    public int getOsszeg() {
        return Osszeg;
    }

    public String getSzamlaNev() {
        return SzamlaNev;
    }

    public int getSzHId() {
        return SzHId;
    }

    public int getHistory() {
        return History;
    }
  

    public Elem(int FelhId, String FelhNev, int Pin) {
        this.FelhId = FelhId;
        this.FelhNev = FelhNev;
        this.Pin = Pin;
    }

    public Elem(int HistoryID, int SzHId, int History) {
        this.SzHId = SzHId;
        this.History = History;
        this.HistoryID = HistoryID;
    }
    
   
   
    
}
