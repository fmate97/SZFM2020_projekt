
import java.util.ArrayList;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Koppany
 */
public class Bank {
    private String név;
    private ArrayList<User> user;
    private ArrayList<Account> accounts; 
    public Bank(String név)
    {
        this.név=név;
        this.user=new ArrayList<User>();
        this.accounts= new ArrayList<Account>();
    }
    
    public String getNewUserID(){
      String id;
      Random rng = new Random();
      int len=6;
      boolean nonUnique;
      do{
          id="";
          for(int i=0;i<len;i++)
          {
              id+=((Integer)rng.nextInt(10)).toString();
          }
          nonUnique=false;
          for(User u:this.user)
          {
              if(id.compareTo(u.getID())==0){
                  nonUnique=true;
                  break;
              }
          }
      }while(nonUnique);
      return id;
    }
    public String getNewAccountID(){
        
        String id;
      Random rng = new Random();
      int len=10;
      boolean nonUnique;
      do{
          id="";
          for(int i=0;i<len;i++)
          {
              id+=((Integer)rng.nextInt(10)).toString();
          }
          nonUnique=false;
          for(Account a:this.accounts)
          {
              if(id.compareTo(a.getID())==0){
                  nonUnique=true;
                  break;
              }
          }
      }while(nonUnique);
      return id;
        
    }
    public void addAccount(Account anAcct)
    {
        this.accounts.add(anAcct);
    }
    public User addUser(String keresztnév,String vezetéknév,String pin)
    {
        User newUser= new User(keresztnév,vezetéknév,pin,this);
        this.user.add(newUser);
        Account newAccount = new Account("Savings",newUser,this);
        newUser.addAccount(newAccount);
        this.addAccount(newAccount);
        return newUser;
    }
    public User userLogin(String userID,String pin){
        
        for(User u:this.user){
            if(u.getID().compareTo(userID)==0 && u.validatePin(pin)){
                return u;
            }
        }
        return null;
    }
    public String getName(){
        return this.név;
    }
    
}
