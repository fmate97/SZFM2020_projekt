/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM.model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Koppany
 */
public class AdatBazis {
    Connection kapcsolat;
     Statement parancs;
     PreparedStatement parancs2;
     ResultSet eredmeny;


     String url="jdbc:mysql://localhost/atm";
     String user="root";
     String password="";
     public boolean upDateSzamla2(int osszeg,String nev,int szamlaId,int felhId)
     {
         boolean sikeres=true;
         
         String sql="UPDATE szamlak SET Osszeg=?,SzamlaNev=?,SzamlaId=? WHERE FelhasznaloId=?";
         try{
             kapcsolat=DriverManager.getConnection(url,user,password);
             parancs2=kapcsolat.prepareStatement(sql);
             parancs2.setInt(4,felhId);
             parancs2.setInt(3,szamlaId);
             parancs2.setInt(1,osszeg);
             parancs2.setString(2,nev);
             parancs2.execute();
             kapcsolat.close();
         }
         catch(Exception e)
         {
             sikeres=false;
             System.out.println(e.getMessage());
         }
         return sikeres;
        }
    public boolean upDateSzamla(int felhId,int osszeg,String nev,int szamlaId)
     {
         boolean sikeres=true;
         
         String sql="UPDATE szamlak SET FelhasznaloId=?,Osszeg=?,SzamlaNev=? WHERE SzamlaId=?";
         try{
             kapcsolat=DriverManager.getConnection(url,user,password);
             parancs2=kapcsolat.prepareStatement(sql);
             parancs2.setInt(1,felhId);
             parancs2.setInt(4,szamlaId);
             parancs2.setInt(2,osszeg);
             parancs2.setString(3,nev);
             parancs2.execute();
             kapcsolat.close();
         }
         catch(Exception e)
         {
             sikeres=false;
             System.out.println(e.getMessage());
         }
         return sikeres;
        }
    public boolean uploadSzamla(int SzamlaId,int FelhasznaloId,int Osszeg,String SzamlaNev)
     {
         boolean sikeres=true;
         
         String sql="INSERT INTO `szamlak`(`SzamlaId`, `FelhasznaloId`, `Osszeg`, `SzamlaNev`) VALUES (?,?,?,?)";
         try{
             kapcsolat=DriverManager.getConnection(url,user,password);
             parancs2=kapcsolat.prepareStatement(sql);
             parancs2.setInt(1,SzamlaId);
             parancs2.setInt(2,FelhasznaloId);
             parancs2.setInt(3,Osszeg);
             parancs2.setString(4,SzamlaNev);
             parancs2.execute();
             kapcsolat.close();
         }
         catch(Exception e)
         {
             sikeres=false;
             System.out.println(e.getMessage());
         }
         return sikeres;
        }
     public boolean upload(int Id,String Nev,int Pin)
     {
         boolean sikeres=true;
         
         String sql="INSERT INTO `felhasznalok`(`Id`, `Nev`, `Pin`) VALUES (?,?,?)";
         try{
             kapcsolat=DriverManager.getConnection(url,user,password);
             parancs2=kapcsolat.prepareStatement(sql);
             parancs2.setInt(1,Id);
             parancs2.setString(2,Nev);
             parancs2.setInt(3,Pin);
             parancs2.execute();
             kapcsolat.close();
         }
         catch(Exception e)
         {
             sikeres=false;
             System.out.println(e.getMessage());
         }
         return sikeres;
        }
      public boolean AddHistory(int HId,int SzHid,int History)
     {
         boolean sikeres=true;
         
         String sql="INSERT INTO `history`(`HistoryId`, `SzHid`, `History`) VALUES (?,?,?)";
         try{
             kapcsolat=DriverManager.getConnection(url,user,password);
             parancs2=kapcsolat.prepareStatement(sql);
             parancs2.setInt(1,HId);
             parancs2.setInt(2,SzHid);
             parancs2.setInt(3,History);
             parancs2.execute();
             kapcsolat.close();
         }
         catch(Exception e)
         {
             sikeres=false;
             System.out.println(e.getMessage());
         }
         return sikeres;
        }
      public ArrayList<Elem> getHistory()
     {
       ArrayList<Elem> lista=new ArrayList<>();
       String sql="SELECT * FROM history";
       try{
           kapcsolat=DriverManager.getConnection(url,user,password);
             parancs=kapcsolat.createStatement();
             eredmeny=parancs.executeQuery(sql);
             Elem adatok;
            while(eredmeny.next())
             {
                 adatok=new Elem(eredmeny.getInt("HistoryId"),eredmeny.getInt("SzHId"),eredmeny.getInt("History"));
                 lista.add(adatok);

             }


         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

         return lista;
         
         
         
         
     } 
     public ArrayList<Elem> getFelhasznalo()
     {
       ArrayList<Elem> lista=new ArrayList<>();
       String sql="SELECT * FROM felhasznalok";
       try{
           kapcsolat=DriverManager.getConnection(url,user,password);
             parancs=kapcsolat.createStatement();
             eredmeny=parancs.executeQuery(sql);
             Elem adatok;
            while(eredmeny.next())
             {
                 adatok=new Elem(eredmeny.getInt("Id"),eredmeny.getString("Nev"),eredmeny.getInt("Pin"));
                 lista.add(adatok);

             }


         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

         return lista;
         
         
         
         
     } 
     public ArrayList<Elem> getSzamla()
     {
       ArrayList<Elem> lista=new ArrayList<>();
       String sql="SELECT * FROM szamlak";
       try{
           kapcsolat=DriverManager.getConnection(url,user,password);
             parancs=kapcsolat.createStatement();
             eredmeny=parancs.executeQuery(sql);
             Elem adatok;
            while(eredmeny.next())
             {
                 adatok=new Elem(eredmeny.getInt("SzamlaId"),eredmeny.getInt("FelhasznaloId"),eredmeny.getInt("Osszeg"),eredmeny.getString("SzamlaNev"));
                 lista.add(adatok);

             }


         } catch (Exception e) {
             System.out.println(e.getMessage());
         }

         return lista;
         
         
         
         
     } 
     
}




