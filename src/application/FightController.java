package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

public class FightController {

    @FXML
    private ImageView imgVChar1;

    @FXML
    private ImageView imgVChar2;

    @FXML
    private ProgressBar pbHpChar1;

    @FXML
    private ProgressBar pbHChar2;

    @FXML
    private Button btnAttack1;

    @FXML
    private Button btnAttack2;

    @FXML
    private Button btnAttack3;

    @FXML
    private Button btnGiveUp;

    @FXML
    private TextArea txaLogs;
    
    @FXML
    private Label lblNumRound;
    
    @FXML
    private Label lblRndWonChar1;
    
    @FXML
    private Label lblRndLostChar1;
    
    @FXML
    private Label lblRndWonChar2;
    
    @FXML
    private Label lblRndLostChar2;

    @FXML
    private void attack(ActionEvent event) {

    }

    @FXML
    private void giveUp(ActionEvent event) {

    }
}
