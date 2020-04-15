package ATM.model;

import java.util.ArrayList;

public class Account {
      /**
     * Account neve
     */
    private  String név;
    /** 
     * Account id
     */
    private String id;
    private User tulaj;
    /**
     * tranzakciók listája
     */
    private ArrayList<Transaction> transactions;
    /**
     * Új account
     * @param név
     * @param tulaj
     * @param theBank 
     */
    public Account(String név, User tulaj,Bank theBank)
    {
        //account név és tulaj
        this.név=név;
        this.tulaj=tulaj;
        
        //új account id
        this.id=theBank.getNewAccountID();
        
        //init tranzakciókat
        this.transactions=new ArrayList<Transaction>();
        
        //tulaj és bank listákhoz adás
        
    }
    public String getID(){
        return this.id;
    }
    public String getSummaryLine(){
        double balance = this.getBalance();
        if(balance>=0){
            return String.format("%s : $%.02f : %s",this.id,balance,this.név);
        }
        else
        {
           return String.format("%s : $(%.02f) : %s",this.id,balance,this.név); 
        }
    }
    public double getBalance(){
        double balance=0;
        for(Transaction t:this.transactions){
            balance+=t.getAmount();
        }
        return balance;
    }
    public void printTransHistory(){
        System.out.printf("\nTransaction history for account %s\n", this.id);
        for(int t=this.transactions.size()-1;t>=0;t--){
            System.out.printf(this.transactions.get(t).getSummaryLine());
        }
        System.out.println();
    }
    public void addTransaction(double amount,String memo){
        Transaction newTrans = new Transaction(amount,memo,this);
        this.transactions.add(newTrans);
    }
}
