package ATM.view;

import ATM.model.AdatBazis;
import ATM.model.Elem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

public class ATMFelvetelController extends ATMLoginController implements Initializable {
    int valasztas;
    String egyenleg;
    ArrayList<Elem> History;
    
    AdatBazis db = new AdatBazis();
 
    @FXML
    private Label nincsszamlaLabel;

    @FXML
    private ChoiceBox<String> choiceBoxID;

    @FXML
    private Label keremLabelID;
    
    @FXML
    private Button megerositButtonID;

    @FXML
    private Label osszegLabelID;

    @FXML
    private TextField osszegID;

    @FXML
    private Label nagyobbosszegID;

    @FXML
    private Label ervenytelenID;
    
    @FXML
    private Label sikeresID;
    
    @FXML
    private Label ID1;

    @FXML
    private Label ID2;

    @FXML
    private Label ID3;

    @FXML
    private Label ID4;

    @FXML
    private Button okButtonID;
    
    @FXML
    void okButtonPressed(ActionEvent event) {
        ervenytelenID.setVisible(false);
        nagyobbosszegID.setVisible(false);
        sikeresID.setVisible(false);
        
        String osszeg = osszegID.getText();
        if(osszeg.equals("")) {
            ervenytelenID.setVisible(true);
        }
        else {
            int osszeg2 = Integer.parseInt(osszeg);        
            String osszeg3 = osszegLabelID.getText();
            int osszeg4 = Integer.parseInt(osszeg3);

            if(osszeg2 == 0 || osszeg.substring(0, 1).equals("-"))
                ervenytelenID.setVisible(true);
            else if(osszeg2 > osszeg4)
                nagyobbosszegID.setVisible(true);
            else{
                sikeresID.setVisible(true);
                osszegLabelID.setText(Integer.toString(osszeg4 - osszeg2));
                db.upDateSzamla(itt,osszeg4-osszeg2,Szamlak.get(valasztas).getSzamlaNev(),Szamlak.get(valasztas).getSzamlaId());
                
                History=db.getHistory();
                db.AddHistory(db.getHistory().size()+1,Szamlak.get(valasztas).getSzamlaId(),-osszeg2);
                
            }
        }
    }

    @FXML
    void megerositButtonPressed(ActionEvent event) {
       ervenytelenID.setVisible(false);
        sikeresID.setVisible(false);
        valasztas = choiceBoxID.getSelectionModel().getSelectedIndex();
        egyenleg=Integer.toString(Szamlak.get(valasztas).getOsszeg());
        osszegLabelID.setText(egyenleg);
        ID1.setVisible(true);
        ID2.setVisible(true);
        ID3.setVisible(true);
        ID4.setVisible(true);
        osszegID.setVisible(true);
        osszegLabelID.setVisible(true);
        okButtonID.setDisable(false);
    }

    @FXML
    void choiceBoxPressed(MouseEvent event) {
        keremLabelID.setVisible(false);
    }

    @FXML
    void exitButtonID(ActionEvent event) throws IOException {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }     
    }
    ATMLoginController ATM = new ATMLoginController();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int itt=ATM.getItt();
        
        int szamlaDb=0;
        for(int i=0;i<Szamlak.size();i++)
                    {
                        
                    if(Szamlak.get(i).getFelhId()==itt)
                    {
                        szamlaDb++;
                     
                        
                    }
                    }
        
        if(szamlaDb==0){
            nincsszamlaLabel.setVisible(true);
            choiceBoxID.setDisable(true);
            keremLabelID.setVisible(false);
            megerositButtonID.setVisible(false);
        } else {
           
            
            choiceBoxID.setItems(FXCollections.observableArrayList(ATM.getSzamla()));
            keremLabelID.setVisible(true);
            megerositButtonID.setVisible(true);
        }
    } 
}
