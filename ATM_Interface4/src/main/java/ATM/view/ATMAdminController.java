package ATM.view;

import ATM.model.AdatBazis;
import ATM.model.Elem;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.swing.event.ChangeEvent;

public class ATMAdminController extends ATMLoginController implements Initializable{
    AdatBazis db = new AdatBazis();
    ArrayList<Elem> Szamlak;
      ArrayList<Elem> Szamlak2;
      ArrayList<Elem> Felhasznalok;
          int itt=1;
          int itt2=1;

    @FXML
    private PasswordField ujfiok_5;

    @FXML
    private TextField ujfiok_3;

    @FXML
    private Button ujfiokButton;

    @FXML
    private CheckBox ujfiokID;

    @FXML
    private ChoiceBox<String> szamlaszam_3;

    @FXML
    private CheckBox szamlaszamID;

    @FXML
    private Label ujfiok_1;

    @FXML
    private Label ujfiok_2;

    @FXML
    private Label ujfiok_4;

    @FXML
    private Label ujfiok_6;

    @FXML
    private PasswordField ujfiok_7;

    @FXML
    private CheckBox osszegID;

    @FXML
    private Label szamlaszam_1;

    @FXML
    private Label szamlaszam_2;

    @FXML
    private Label szamlaszam_Kerem1;

    @FXML
    private Label szamlaszam_6;

    @FXML
    private TextField szamlaszam_7;

    @FXML
    private Label szamlaszam_4;

    @FXML
    private ChoiceBox<String> szamlaszam_5;

    @FXML
    private Label szamlaszam_Kerem2;

    @FXML
    private Button szamlaszamButton;

    @FXML
    private Label osszeg_1;

    @FXML
    private ChoiceBox<String> osszeg_3;

    @FXML
    private Label osszeg_2;

    @FXML
    private Label osszeg_Kerem1;

    @FXML
    private Label osszeg_4;

    @FXML
    private ChoiceBox<String> osszeg_5;

    @FXML
    private Label osszeg_Kerem2;

    @FXML
    private Label osszeg_6;

    @FXML
    private TextField osszeg_7;

    @FXML
    private Button osszegButton;

    @FXML
    private Label letezofiok;

    @FXML
    private Label jelszofiok;

    @FXML
    private Label sikeresfiok;

    @FXML
    private Label letezoszamlaszam;

    @FXML
    private Label sikeresszamlaszam;

    @FXML
    private Label sikeresosszeg;
    
    @FXML
    private Label hibasfiok;

    @FXML
    private Label hibasosszeg;

    @FXML
    private Label hibasszamlaszam;
    
    void ujfiok(boolean beallitas){
        ujfiok_1.setVisible(beallitas);
        ujfiok_2.setVisible(beallitas);
        ujfiok_3.setVisible(beallitas);
        ujfiok_4.setVisible(beallitas);
        ujfiok_5.setVisible(beallitas);
        ujfiok_6.setVisible(beallitas);
        ujfiok_7.setVisible(beallitas);
        ujfiokButton.setVisible(beallitas);
    }
    
    void szamlaszam(boolean beallitas){
        szamlaszam_1.setVisible(beallitas);
        szamlaszam_2.setVisible(beallitas);
        szamlaszam_3.setVisible(beallitas);
        szamlaszam_4.setVisible(beallitas);
        szamlaszam_5.setVisible(beallitas);
        szamlaszam_6.setVisible(beallitas);
        szamlaszam_7.setVisible(beallitas);
        szamlaszamButton.setVisible(beallitas);
    }
    
    void osszeg(boolean beallitas){
        osszeg_1.setVisible(beallitas);
        osszeg_2.setVisible(beallitas);
        osszeg_3.setVisible(beallitas);
        osszeg_4.setVisible(beallitas);
        osszeg_5.setVisible(beallitas);
        osszeg_6.setVisible(beallitas);
        osszeg_7.setVisible(beallitas);
        osszegButton.setVisible(beallitas);
    }

    @FXML
    void osszegButtonPressed(ActionEvent event) {
        sikeresosszeg.setVisible(false);
        hibasosszeg.setVisible(false);
        
        if(osszeg_7.getText().equals("") || osszeg_7.getText().substring(0, 1).equals("-") || osszeg_7.getText().equals("0")){
            hibasosszeg.setVisible(true);
        } else {
            Szamlak=db.getSzamla();
            Felhasznalok=db.getFelhasznalo();
            int szamlaid=-1;
            int felhid=-1;
           for(int i=0;i<Szamlak.size();i++)
              { 
                  
                  
               if(osszeg_3.getSelectionModel().getSelectedItem().compareTo(Felhasznalok.get(Szamlak.get(i).getFelhId()-1).getFelhNev())==0);
               {
                   if( osszeg_5.getSelectionModel().getSelectedItem().compareTo(Szamlak.get(i).getSzamlaNev())==0)
                   {
                   szamlaid=Szamlak.get(i).getSzamlaId();
                        felhid=Szamlak.get(i).getFelhId();
                 
                   db.upDateSzamla(felhid,Integer.parseInt(osszeg_7.getText()),osszeg_5.getSelectionModel().getSelectedItem(), szamlaid);
                   break;
                   }
               }
               
               
           }
            sikeresosszeg.setVisible(true);
           
           
            
        }
    }

    @FXML
    void osszegPressed(MouseEvent event) {
        sikeresosszeg.setVisible(false);
        hibasosszeg.setVisible(false);
        ATMLoginController ATM = new ATMLoginController();
        AdatBazis db = new AdatBazis();
          Szamlak2=db.getSzamla();
        if(osszegID.isSelected()){
            osszeg_3.setItems(FXCollections.observableArrayList(ATM.getFelhasznalo()));
            osszeg(true);
            osszeg_Kerem1.setVisible(true);
            osszeg_Kerem2.setVisible(true);
        } else {
            osszeg(false);
            osszeg_7.setText("");
            osszeg_Kerem1.setVisible(false);
            osszeg_Kerem2.setVisible(false);
        }
    }

    @FXML
    void osszeg_3Pressed(MouseEvent event) {
        osszeg_Kerem1.setVisible(false);
    }

    @FXML
    void osszeg_5Pressed(MouseEvent event) {
        osszeg_Kerem2.setVisible(false);
    }

    @FXML
    void szamlaszamButtonPressed(ActionEvent event) {
        sikeresszamlaszam.setVisible(false);
        hibasszamlaszam.setVisible(false);
        AdatBazis db = new AdatBazis();
        int van=0;
          Szamlak=db.getSzamla();
          for(int i=0;i<Szamlak.size();i++)
          {
              if(Szamlak.get(i).getSzamlaNev().compareTo(szamlaszam_7.getText())==0)
                  van=1;
          }
        letezoszamlaszam.setVisible(false);
        if(szamlaszam_7.getText().equals("")){
            hibasszamlaszam.setVisible(true);
        } else if(van==1){ //létezik-e a számlaszám akkor lépjen be az if-ciklusba!
            letezoszamlaszam.setVisible(true);
        } 
        else {
            sikeresszamlaszam.setVisible(true);
            db.uploadSzamla(db.getSzamla().size()+1,itt,0,szamlaszam_7.getText());
            
        }
    }
   
    @FXML
    void szamlaszamPressed(MouseEvent event) {
       
        sikeresszamlaszam.setVisible(false);
        letezoszamlaszam.setVisible(false);
        hibasszamlaszam.setVisible(false);
         ATMLoginController ATM = new ATMLoginController();
          
          AdatBazis db = new AdatBazis();
          Szamlak=db.getSzamla();
        if(szamlaszamID.isSelected()){
            
            szamlaszam_3.setItems(FXCollections.observableArrayList(ATM.getFelhasznalo()));
            
            
            
            szamlaszam(true);
            szamlaszam_Kerem1.setVisible(true);
            szamlaszam_Kerem2.setVisible(true);
            
        } else {
            szamlaszam(false);
            szamlaszam_7.setText("");
            szamlaszam_Kerem1.setVisible(false);
            szamlaszam_Kerem2.setVisible(false);
        }
    }
 
    
    @FXML
    void szamlaszam_3Pressed(MouseEvent event) {
          szamlaszam_Kerem1.setVisible(false);
        
         }
        
    

    @FXML
    void szamlaszam_5Pressed(MouseEvent event) {
        szamlaszam_Kerem2.setVisible(false);
        
    }

    @FXML
    void ujfiokButtonPressed(ActionEvent event) {
        sikeresfiok.setVisible(false);
        hibasfiok.setVisible(false);
        int van=0;
        Felhasznalok=db.getFelhasznalo();
        for(int i=0;i<Felhasznalok.size();i++)
        {
            if(Felhasznalok.get(i).getFelhNev().compareTo(ujfiok_3.getText())==0)
            {
                van=1;
            }
            
        }
        letezofiok.setVisible(false);
        jelszofiok.setVisible(false);
        if(ujfiok_7.getText().equals("") || ujfiok_5.getText().equals("") || ujfiok_3.getText().equals("")){
            hibasfiok.setVisible(true);
        } else if(van==1){ //létezik már ilyen felhasználó névvel fiók akkor lépjen be!
            letezofiok.setVisible(true);
        } else if(ujfiok_5.getText().equals(ujfiok_7.getText()) == false){
            jelszofiok.setVisible(true);
        } else {
            sikeresfiok.setVisible(true);
            ArrayList<Elem> Felhasznalok;
            AdatBazis db = new AdatBazis();
            Felhasznalok=db.getFelhasznalo();
            db.upload(Felhasznalok.size()+1, ujfiok_3.getText(),Integer.parseInt(ujfiok_7.getText()));
            Felhasznalok=db.getFelhasznalo();
        }
    }

    @FXML
    void ujfiokPressed(MouseEvent event) {
        sikeresfiok.setVisible(false);
        hibasfiok.setVisible(false);
        letezofiok.setVisible(false);
        jelszofiok.setVisible(false);
        if(ujfiokID.isSelected()){
            ujfiok(true);
        } else {
            ujfiok_3.setText("");
            ujfiok_5.setText("");
            ujfiok_7.setText("");
            ujfiok(false);
        }
    }

    @FXML
    void visszaButtonPressed(ActionEvent event) throws IOException {
        try {
                            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Megerősítés");
            alert.setHeaderText("Biztos ki akar lépni?");
            alert.setContentText("Kérem erősítse meg a kijelentkezési szándékát!");
            ButtonType buttonTypeOne = new ButtonType("Igen");
            ButtonType buttonTypeCancel = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();                    
            if (result.get() == buttonTypeOne){
                
                szamlaszam_5.getItems().clear();
                szamlaszam_3.getItems().clear();
                osszeg_3.getItems().clear();
                osszeg_5.getItems().clear();
                FXMLLoader loader = new FXMLLoader();
                //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMOpcio.fxml"));
                loader.setLocation(new URL(ertekatadas.mentesihely + "src/main/java/ATM/view/ATMLogin.fxml"));
                Scene scene = new Scene(loader.load());
                Stage stage = new Stage();
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.setOnCloseRequest((WindowEvent event2) -> {
                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("Megerősítés");
                    alert2.setHeaderText("Biztos be akarja zárni a programot?");
                    ButtonType buttonTypeOne2 = new ButtonType("Igen");
                    ButtonType buttonTypeCancel2 = new ButtonType("Nem", ButtonBar.ButtonData.CANCEL_CLOSE);
                    alert2.getButtonTypes().setAll(buttonTypeOne2, buttonTypeCancel2);
                    Optional<ButtonType> result2 = alert2.showAndWait();                    
                    if (result2.get() == buttonTypeCancel2){
                        event2.consume();
                    }
                });
                stage.setResizable(false);
                stage.getIcons().add(new Image("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSeNyd-NMf4cIUDltZC_Z2-6xCxRpDWBXpYL4aYljDUGb7EHPuh&usqp=CAU"));
                stage.show(); 
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(ATMOpcioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {     
          szamlaszam_3.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
              public void changed (ObservableValue ov,Number value,Number  new_value){
                  ArrayList<String> szamla2 = new ArrayList<String>();
       
        
             itt=szamlaszam_3.getSelectionModel().getSelectedIndex()+1;
        
            for(int i=0;i<Szamlak.size();i++)
            {
                if(Szamlak.get(i).getFelhId()==itt)
                    {
                        szamla2.add(Szamlak.get(i).getSzamlaNev());
                     
                        
                    }
            }
            szamlaszam_5.setItems(FXCollections.observableArrayList(szamla2));
              }
          });
                    osszeg_3.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
              public void changed (ObservableValue ov,Number value,Number  new_value){
                  ArrayList<String> szamla2 = new ArrayList<String>();
       
        
             itt2=osszeg_3.getSelectionModel().getSelectedIndex()+1;
             
            for(int i=0;i<Szamlak2.size();i++)
            {
                if(Szamlak2.get(i).getFelhId()==itt2)
                    {
                        szamla2.add(Szamlak2.get(i).getSzamlaNev());
                     
                        
                    }
            }
            osszeg_5.setItems(FXCollections.observableArrayList(szamla2));
              }
          });
    }
}
