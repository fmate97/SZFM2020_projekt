package ATM.view;

import ATM.model.AdatBazis;
import ATM.model.Elem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.WindowEvent;

public class ATMAtutalasController extends ATMLoginController implements Initializable {
    int szamlalo = 0;
    int szamlaDb=0;
   
    int valasztas2;
    int valasztas;
     ArrayList<Elem> History;
     AdatBazis db = new AdatBazis();
    String egyenleg;
    @FXML
    private Label nincsszamlaLabel;

    @FXML
    private ChoiceBox<String> choiceBoxID;

    @FXML
    private Label keremLabelID;

    @FXML
    private Label ID1;

    @FXML
    private Label ID2;

    @FXML
    private Label osszegLabelID;

    @FXML
    private Label ID3;

    @FXML
    private TextField osszegID;

    @FXML
    private Label ID4;
    
    @FXML
    private Label ID5;

    @FXML
    private Label nagyobbosszegID;

    @FXML
    private Label ervenytelenID;

    @FXML
    private Button okButtonID;

    @FXML
    private Button megerositButtonID;

    @FXML
    private Label sikeresID;

    @FXML
    private ChoiceBox<String> choiceBoxID1;

    @FXML
    private Button megerositButtonID1;

    @FXML
    private Label ID21;

    @FXML
    private Label osszegLabelID1;
    
    @FXML
    private Label nincsszamlaLabel11;

    @FXML
    private Label ID31;

    @FXML
    private Label nincsszamlaLabel1;

    @FXML
    private Label keremLabelID1;

    @FXML
    void choiceBoxPressed(MouseEvent event) {
        keremLabelID.setVisible(false);
    }
    
    @FXML
    void choiceBoxPressed1(MouseEvent event) {
        keremLabelID1.setVisible(false);
    }


    @FXML
    void megerositButtonPressed(ActionEvent event) {
        ervenytelenID.setVisible(false);
        sikeresID.setVisible(false);
        nincsszamlaLabel11.setVisible(false);
        valasztas = choiceBoxID.getSelectionModel().getSelectedIndex();
        valasztas2 = choiceBoxID1.getSelectionModel().getSelectedIndex();
        if(valasztas == valasztas2)
            nincsszamlaLabel11.setVisible(true);
        else {
            egyenleg=Integer.toString(Szamlak.get(valasztas).getOsszeg());
            osszegLabelID.setText(egyenleg);
            ID2.setVisible(true);
            ID3.setVisible(true);
            ID5.setVisible(true);
            osszegLabelID.setVisible(true);

            if(szamlaDb== 1){
                nincsszamlaLabel1.setVisible(true);
                choiceBoxID1.setVisible(true);
                choiceBoxID1.setDisable(true);
                keremLabelID1.setVisible(false);
                megerositButtonID1.setVisible(false);
            } else {
                choiceBoxID1.setItems(FXCollections.observableArrayList(ATM.getSzamla()));
                choiceBoxID1.setVisible(true);
                if(szamlalo == 0)
                    keremLabelID1.setVisible(true);
                megerositButtonID1.setVisible(true);
                szamlalo++;
            }
        }
    }
    
    @FXML
    void megerositButtonPressed2(ActionEvent event) {
        ervenytelenID.setVisible(false);
        sikeresID.setVisible(false);
        nincsszamlaLabel11.setVisible(false);
        int valasztas = choiceBoxID1.getSelectionModel().getSelectedIndex();
        int valasztas2 = choiceBoxID.getSelectionModel().getSelectedIndex();
        if(valasztas == valasztas2)
            nincsszamlaLabel11.setVisible(true);
        else {
            egyenleg=Integer.toString(Szamlak.get(valasztas).getOsszeg());
            osszegLabelID1.setText(egyenleg);
            ID1.setVisible(true);
            ID21.setVisible(true);
            ID31.setVisible(true);
            ID4.setVisible(true);
            osszegID.setVisible(true);
            osszegLabelID1.setVisible(true);
            okButtonID.setDisable(false);
        }
    }

    @FXML
    void okButtonPressed(ActionEvent event) {
        ervenytelenID.setVisible(false);
        sikeresID.setVisible(false);
        nincsszamlaLabel11.setVisible(false);
        nagyobbosszegID.setVisible(false);
        valasztas = choiceBoxID.getSelectionModel().getSelectedIndex();
        valasztas2 = choiceBoxID1.getSelectionModel().getSelectedIndex();
        if(valasztas == valasztas2)
            nincsszamlaLabel11.setVisible(true);
        else {
            String osszeg = osszegID.getText();
            if(osszeg.equals("")) {
                ervenytelenID.setVisible(true);
            }
            else {
                int osszeg2 = Integer.parseInt(osszeg);        
                String osszeg3 = osszegLabelID.getText();
                int osszeg4 = Integer.parseInt(osszeg3);
                String osszeg5 = osszegLabelID1.getText();
                int osszeg6 = Integer.parseInt(osszeg5);

                if(osszeg2 == 0 || osszeg.substring(0, 1).equals("-"))
                    ervenytelenID.setVisible(true);
                else if(osszeg2 > osszeg4)
                    nagyobbosszegID.setVisible(true);
                else{
                    sikeresID.setVisible(true);
                    osszegLabelID.setText(Integer.toString(osszeg4 - osszeg2));
                    osszegLabelID1.setText(Integer.toString(osszeg6 + osszeg2));
                    db.upDateSzamla(itt,osszeg4-osszeg2,Szamlak.get(valasztas).getSzamlaNev(),Szamlak.get(valasztas).getSzamlaId());
                    db.upDateSzamla(itt,osszeg6+osszeg2,Szamlak.get(valasztas2).getSzamlaNev(),Szamlak.get(valasztas2).getSzamlaId());
                     History=db.getHistory();
                    db.AddHistory(db.getHistory().size()+1,Szamlak.get(valasztas).getSzamlaId(),-osszeg2);
                     
                    db.AddHistory(db.getHistory().size()+2,Szamlak.get(valasztas2).getSzamlaId(),+osszeg2);
                    
                }
            }
        }
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
