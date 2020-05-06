package ATM.view;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ATMOpcioController implements Initializable {
    ObservableList<String> teszt = FXCollections.observableArrayList("Számla tranzakciós előzmény", "Pénzfelvétel", "Pénzbefizetés", "Átutalás", "Kilépés");
    
    @FXML
    private ChoiceBox<String> choiceboxID;
    
    @FXML
    private Label valasszonLabelID;

    @FXML
    void choiceBoxPressed(MouseEvent event) {
       valasszonLabelID.setVisible(false);
    }
    
    @FXML
    void okButtonPressed(ActionEvent event) throws InterruptedException, IOException {
        int opcio = choiceboxID.getSelectionModel().getSelectedIndex();
        
        switch (opcio) {
            case 0:
                try {
                    FXMLLoader loader = new FXMLLoader();
                    //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMElozmeny.fxml"));
                    loader.setLocation(new URL(ertekatadas.mentesihely + "/src/main/java/ATM/view/ATMElozmeny.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Elozmeny");
                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent event2) -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hiba");
                        alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                        alert.showAndWait();
                        event2.consume();
                    });
                    stage.setResizable(false);
                    stage.getIcons().add(new Image("https://cdn3.iconfinder.com/data/icons/google-material-design-icons/48/ic_history_48px-512.png"));
                    stage.show(); 
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ATMOpcioController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
            case 1:
                try {
                    FXMLLoader loader = new FXMLLoader();
                    //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMFelvetel.fxml"));
                    loader.setLocation(new URL(ertekatadas.mentesihely + "/src/main/java/ATM/view/ATMFelvetel.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Felvetel");
                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent event2) -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hiba");
                        alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                        alert.showAndWait();
                        event2.consume();
                    });
                    stage.setResizable(false);
                    stage.getIcons().add(new Image("https://cdn0.iconfinder.com/data/icons/thin-money-payment/24/thin-0431_money_atm_machine_withdrawal_cash-512.png"));
                    stage.show(); 
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ATMOpcioController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
            case 2:
                try {
                    FXMLLoader loader = new FXMLLoader();
                    //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMLetét.fxml"));
                    loader.setLocation(new URL(ertekatadas.mentesihely + "src/main/java/ATM/view/ATMLetet.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Letet");
                    stage.setOnCloseRequest((WindowEvent event2) -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hiba");
                        alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                        alert.showAndWait();
                        event2.consume();
                    });
                    stage.setScene(scene);
                    stage.setResizable(false);
                    stage.getIcons().add(new Image("https://cdn0.iconfinder.com/data/icons/banking-essentials/100/Finance_Cash_In-512.png"));
                    stage.show(); 
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ATMOpcioController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
            case 3:
                try {
                    FXMLLoader loader = new FXMLLoader();
                    //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMAtutalas.fxml"));
                    loader.setLocation(new URL(ertekatadas.mentesihely + "/src/main/java/ATM/view/ATMAtutalas.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = new Stage();
                    stage.setTitle("Atutalas");
                    stage.setScene(scene);
                    stage.setOnCloseRequest((WindowEvent event2) -> {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hiba");
                        alert.setHeaderText("A program bezárása előtt jelentkezzen ki a fiókjából!");
                        alert.showAndWait();
                        event2.consume();
                    });
                    stage.setResizable(false);
                    stage.getIcons().add(new Image("https://previews.123rf.com/images/delwarbd/delwarbd1807/delwarbd180703672/114964396-fast-money-transfer-icon.jpg"));
                    stage.show(); 
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                } catch (MalformedURLException ex) {
                    Logger.getLogger(ATMOpcioController.class.getName()).log(Level.SEVERE, null, ex);
                } 
                break;
            case 4:
                try {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.setTitle("Megerősítés");
                    alert.setHeaderText("Biztos ki akar lépni?");
                    alert.setContentText("Kérem erősítse meg a kijelentkezési szándékát!");
                    ButtonType buttonTypeOne = new ButtonType("Igen");
                    ButtonType buttonTypeCancel = new ButtonType("Nem", ButtonData.CANCEL_CLOSE);
                    alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
                    Optional<ButtonType> result = alert.showAndWait();                    
                    if (result.get() == buttonTypeOne){
                        FXMLLoader loader = new FXMLLoader();
                        //FXMLLoader loader = new FXMLLoader(ATM.class.getResource("/view/ATMOpcio.fxml"));
                        loader.setLocation(new URL(ertekatadas.mentesihely + "src/main/java/ATM/view/ATMLogin.fxml"));
                        Scene scene = new Scene(loader.load());
                        Stage stage = new Stage();
                        stage.setTitle("Login");
                        stage.setScene(scene);
                        stage.setOnCloseRequest((WindowEvent event2) -> {
                            Alert alert2 = new Alert(AlertType.CONFIRMATION);
                            alert2.setTitle("Megerősítés");
                            alert2.setHeaderText("Biztos be akarja zárni a programot?");
                            ButtonType buttonTypeOne2 = new ButtonType("Igen");
                            ButtonType buttonTypeCancel2 = new ButtonType("Nem", ButtonData.CANCEL_CLOSE);
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
                break;
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        choiceboxID.setItems(teszt);   
    }
}
