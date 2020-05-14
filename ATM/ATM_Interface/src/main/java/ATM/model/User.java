package ATM.model;

import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User {
    private String keresztnév;
    
    private String vezetéknév;
    
    private String id;
    /**
     * pinkód (hash kódja)
     */
    private byte pinHash[];
    /**
     * Accountok
     */
    private ArrayList<Account> accounts;
    /**
     * Új felhasználó létrehozása
     * @param keresztnév
     * @param vezetéknév
     * @param pin
     * @param theBank 
     */
    public User(String keresztnév,String vezetéknév,String pin,Bank theBank)
    {
       //felhasználó neve
      this.keresztnév=keresztnév;
      this.vezetéknév=vezetéknév;
      
      //pinkód hash tárolása az eredeti pinkód helyett
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            this.pinHash=md.digest(pin.getBytes());
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Hiba,NoSuchAlgorithmException");
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        //új id a usernek
        this.id=theBank.getNewUserID();
        //üres accountlistra létrehozása
        this.accounts = new ArrayList<Account>();
        //print log message
        System.out.printf("Új user %s, %s ID %s -vel létrehozva.\n",vezetéknév,keresztnév,this.id);
    }
    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
    public String getID(){
        return this.id;
    } 
    
    public boolean validatePin(String aPin){
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return MessageDigest.isEqual(md.digest(aPin.getBytes()),this.pinHash);
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Hiba,NoSuchAlgorithmException");
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
      return false;
    }
    public String getkeresztnev()
    {
        return this.keresztnév;
    }
    public void printAccountsSummary(){
        System.out.printf("\n\n%s's accounts summary\n", this.keresztnév);
        for(int a=0;a<this.accounts.size();a++)
        {
            System.out.printf("%d) %s\n",a+1, this.accounts.get(a).getSummaryLine());
        }
        System.out.println();
               
    }
    public int numAccounts()
    {
        return this.accounts.size();
    }
    public void printAcctTransHistory(int acctIdx){
        this.accounts.get(acctIdx).printTransHistory();
    }
    public double getAcctBalance(int acctIdx){
        return this.accounts.get(acctIdx).getBalance();
    }
    public String getAcctID(int acctIdx)
    {
        return this.accounts.get(acctIdx).getID();
    }
    public void addAcctTransaction(int acctIdx,double amount,String memo)
    {
        this.accounts.get(acctIdx).addTransaction(amount,memo);
    }
    
    
}
