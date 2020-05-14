package ATM.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ATMElozmenyController implements Initializable {
    
    void setElozmeny(){
        grid00.setText("-30000");
        if(Integer.parseInt(grid00.getText()) < 0)
            grid00.setTextFill(Color.web("#FF0000"));
        else
            grid00.setTextFill(Color.web("#32CD32"));
        grid10.setText("Pénzlevétel");
        grid20.setText("Pénzlevétel XY.utcai ATMből");
        
        grid01.setText("+500000");
        if(Integer.parseInt(grid01.getText()) < 0)
            grid01.setTextFill(Color.web("#FF0000"));
        else
            grid01.setTextFill(Color.web("#32CD32"));
        grid11.setText("Pénz utalás");
        grid21.setText("Havi fizetés");
        
        grid02.setText("-150000");
        if(Integer.parseInt(grid02.getText()) < 0)
            grid02.setTextFill(Color.web("#FF0000"));
        else
            grid02.setTextFill(Color.web("#32CD32"));
        grid12.setText("Pénz utalás");
        grid22.setText("Utalás másik számlámra");
        
        grid03.setText("+45000");
        if(Integer.parseInt(grid03.getText()) < 0)
            grid03.setTextFill(Color.web("#FF0000"));
        else
            grid03.setTextFill(Color.web("#32CD32"));
        grid13.setText("Pénzfeltétel");
        grid23.setText("Pénzfelvétel XY.utcai ATMbe");
        
        grid04.setText("-50000");
        if(Integer.parseInt(grid04.getText()) < 0)
            grid04.setTextFill(Color.web("#FF0000"));
        else
            grid04.setTextFill(Color.web("#32CD32"));
        grid14.setText("Pénzutalás");
        grid24.setText("Utalás XY számlájára");
        
        grid05.setVisible(false);
        grid15.setVisible(false);
        grid25.setVisible(false);
    }
    
    @FXML
    private Label nincsszamlaLabel;

    @FXML
    private ChoiceBox<String> choiceBoxID;

    @FXML
    private Label keremLabelID;

    @FXML
    private Label ID2;

    @FXML
    private Label osszegLabelID;

    @FXML
    private Label ID3;

    @FXML
    private Button megerositButtonID;
    
    @FXML
    private GridPane gridPanel;
    
    @FXML
    private Label grid00;

    @FXML
    private Label grid01;

    @FXML
    private Label grid02;

    @FXML
    private Label grid03;

    @FXML
    private Label grid04;

    @FXML
    private Label grid05;

    @FXML
    private Label grid10;

    @FXML
    private Label grid11;

    @FXML
    private Label grid12;

    @FXML
    private Label grid13;

    @FXML
    private Label grid14;

    @FXML
    private Label grid15;

    @FXML
    private Label grid20;

    @FXML
    private Label grid21;

    @FXML
    private Label grid22;

    @FXML
    private Label grid23;

    @FXML
    private Label grid24;

    @FXML
    private Label grid25;

    @FXML
     void choiceBoxPressed(MouseEvent event) {
        keremLabelID.setVisible(false);
    }

    @FXML
    void megerositButtonPressed(ActionEvent event) {
        int valasztas = choiceBoxID.getSelectionModel().getSelectedIndex();
            switch (valasztas) {
                case 0:
                    osszegLabelID.setText("10000000");
                    break;
                case 1:
                    osszegLabelID.setText("50000");
                    break;
                case 2:
                    osszegLabelID.setText("0");
                    break;
            }
            ID2.setVisible(true);
            ID3.setVisible(true);
            osszegLabelID.setVisible(true);
            setElozmeny();
            gridPanel.setVisible(true);
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
            stage.setResizable(false);
            stage.getIcons().add(new Image("https://c7.uihere.com/files/465/868/892/computer-icons-login-vector-graphics-illustration-image-income-icon.jpg"));
            stage.show(); 
            ((Node)(event.getSource())).getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(ertekatadas.bankszamladb == 0){
            nincsszamlaLabel.setVisible(true);
            choiceBoxID.setDisable(true);
            keremLabelID.setVisible(false);
            megerositButtonID.setVisible(false);
        } else {
            choiceBoxID.setItems(ertekatadas.teszt);
            keremLabelID.setVisible(true);
            megerositButtonID.setVisible(true);
        }
    }
}
