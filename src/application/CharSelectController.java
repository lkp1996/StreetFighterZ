package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

public class CharSelectController {

    private CharSelectModel model = new CharSelectModel();

    @FXML
    private Button btnP1Char1;

    @FXML
    private Button btnP1Char2;

    @FXML
    private Button btnP1Char3;

    @FXML
    private Button btnP1Char4;

    @FXML
    private Button btnP1Char5;

    @FXML
    private Button btnP1Char6;

    @FXML
    private Button btnP2Char1;

    @FXML
    private Button btnP2Char2;

    @FXML
    private Button btnP2Char3;

    @FXML
    private Button btnP2Char4;

    @FXML
    private Button btnP2Char5;

    @FXML
    private Button btnP2Char6;
    
    @FXML
    private Button btnBack;
    
    @FXML
    private Button btnRandomP1;
    
    @FXML
    private Button btnRandomP2;
    
    @FXML
    private Button btnBattle;
    
    @FXML
    private Slider sldNumRound;

    @FXML
    private void onCharChoosenEvent(ActionEvent e) {

    }
    
    @FXML
    private void randomizeChar1(ActionEvent e){
	
    }

    @FXML
    private void randomizeChar2(ActionEvent e){
	
    }
    
    @FXML
    private void goBackToMain(ActionEvent e){
	
    }
    
    @FXML
    private void goToBattle(ActionEvent e){
	
    }
    
    public void init() {
	model.getRoundsPty().bind(sldNumRound.valueProperty());
    }
}
