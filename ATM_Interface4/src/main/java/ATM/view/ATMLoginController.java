package ATM.view;

import ATM.model.AdatBazis;
import ATM.model.Elem;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;



public class ATMLoginController implements Initializable {
    static int itt;
     

    public int getItt() {
        return itt;
    }
    
    static ArrayList<String> szamla = new ArrayList<String>();
    static ArrayList<String> felhasznalo =new ArrayList<String>();

    public ArrayList<String> getFelhasznalo() {
        return felhasznalo;
    }
    public ArrayList<String> getSzamla() {
        return szamla;
    }
    ArrayList<Elem> Felhasznalok;
    ArrayList<Elem> Szamlak;
    public ATMLoginController(){
        
        
        AdatBazis db = new AdatBazis();
        Felhasznalok=db.getFelhasznalo();
        Szamlak=db.getSzamla();
    
        
        
    }
    
    
    @FXML
    private TextField felhasznalonevField;

    @FXML
    private PasswordField jelszoField;

    @FXML
    private Label hibasLabel;

    @FXML
    private Label nincsadatLabel;
    
    @FXML
    private Label betoltesLabel;
    
    @FXML
    private Label helyesLabel;
    
    @FXML
    private ProgressBar progressBarID;
    
    @FXML
    private ProgressIndicator progressindicatorID;

    @FXML
    @SuppressWarnings("unchecked")  
    void BelepesButtonPressed(ActionEvent event) throws InterruptedException {
        hibasLabel.setVisible(false);
        nincsadatLabel.setVisible(false);
        String Pin=jelszoField.getText();
        String UserID=felhasznalonevField.getText();
        if(Pin.compareTo("") == 0 || UserID.compareTo("") == 0 ){
            nincsadatLabel.setVisible(true);
        } else {
            betoltesLabel.setVisible(true);
            progressBarID.setVisible(true);
            progressindicatorID.setVisible(true);
                    
            Task task = taskCreator(100);
            progressBarID.progressProperty().unbind();
            progressBarID.progressProperty().bind(task.progressProperty());
            progressindicatorID.progressProperty().unbind();
            progressindicatorID.progressProperty().bind(task.progressProperty());
            new Thread(task).start();
            
            task.setOnSucceeded(g -> {
                betoltesLabel.setVisible(false);
                progressBarID.setVisible(false);
                progressindicatorID.setVisible(false);
                int igen=0;
                
                for(int i=0;i<Felhasznalok.size();i++)
                {
                    if(UserID.compareTo(Felhasznalok.get(i).getFelhNev())==0)
                    {   
                        if(Pin.compareTo(Integer.toString(Felhasznalok.get(i).getPin()))==0)
                        {
                            igen=1;
                            itt=Felhasznalok.get(i).getFelhId();
                            break;
                            
                        }
                    }
                    
                }
                for(int i=0;i<Felhasznalok.size();i++)
                {
                    felhasznalo.add(Felhasznalok.get(i).getFelhNev());
                }
                for(int i=0;i<Szamlak.size();i++)
                {
                    if(Szamlak.get(i).getFelhId()==itt)
                    {
                        szamla.add(Szamlak.get(i).getSzamlaNev());
                     
                        //szamlak.add(Szamlak.get(i).getSzamlaNev());
                    }
                }
                if(igen==0){ 
                    hibasLabel.setVisible(true);
                } else {
                    
                    
                    helyesLabel.setVisible(true);   
                    Task<Void> sleeper = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException k) {}
                            return null;
                        } };
                    new Thread(sleeper).start();
                    sleeper.setOnSucceeded(b -> {
                        try {
                            if(UserID.equals("admin")){
                                FXMLLoader loader = new FXMLLoader();
                                //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMOpcio.fxml"));
                                loader.setLocation(new URL(ertekatadas.mentesihely + "/src/main/java/ATM/view/ATMAdmin.fxml"));
                                Scene scene = new Scene(loader.load());
                                Stage stage = new Stage();
                                stage.setTitle("Admin felulet");
                                stage.setScene(scene);
                                stage.setOnCloseRequest((WindowEvent event2) -> {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Hiba");
                                    alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                                    alert.showAndWait();
                                    event2.consume();
                                });
                                stage.setResizable(false);
                                stage.getIcons().add(new Image("https://clipartart.com/images/admin-icon-clipart-1.jpg"));
                                stage.show(); 
                                ((Node)(event.getSource())).getScene().getWindow().hide();
                            } else {
                                FXMLLoader loader = new FXMLLoader();
                                //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMOpcio.fxml"));
                                loader.setLocation(new URL(ertekatadas.mentesihely + "/src/main/java/ATM/view/ATMOpcio.fxml"));
                                Scene scene = new Scene(loader.load());
                                Stage stage = new Stage();
                                stage.setTitle("Opcio");
                                stage.setScene(scene);
                                stage.setOnCloseRequest((WindowEvent event2) -> {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Hiba");
                                    alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                                    alert.showAndWait();
                                    event2.consume();
                                });
                                stage.setResizable(false);
                                stage.getIcons().add(new Image("https://c7.uihere.com/files/465/868/892/computer-icons-login-vector-graphics-illustration-image-income-icon.jpg"));
                                stage.show(); 
                                ((Node)(event.getSource())).getScene().getWindow().hide();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } );
                }
            });
        }
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
    
    private Task taskCreator(int seconds){
        return new Task(){
            @Override
            protected Object call() throws Exception{
                for(int i = 0; i < seconds + 1; i++){
                    Thread.sleep(50);
                    updateProgress(i, seconds);
                }
                return true;
            }
        };
    }
}
