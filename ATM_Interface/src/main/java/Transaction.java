
import java.util.Date;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Koppany
 */
public class Transaction {
    /**
     * A tranzakció összege
     */
    private double összeg;
    /**
     * A tranzakció dátuma
     */
    private Date idő;
    
    private String memo;
    /**
     * Az account amiben a tranzakció történt
     */
    private Account inAccount;
    
    public Transaction(double összeg, Account inAccount){
        this.összeg=összeg; 
        this.inAccount=inAccount;
        this.idő = new Date();
        this.memo="";
    }
    public Transaction(double összeg, String memo,Account inAccount)
    {
        this(összeg,inAccount);
        this.memo=memo;
    }
    public double getAmount(){
        return this.összeg;
    }
    public String getSummaryLine(){
        if(this.összeg>=0){
            return String.format("%s : $%.02f : %s",this.idő.toString(),this.összeg,this.memo);
        }else{
            return String.format("%s : $(%.02f) : %s",this.idő.toString(),this.összeg,this.memo);
        }
    }
    
}
