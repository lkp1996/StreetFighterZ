package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class MainController {

    private MainModel model = new MainModel();

    @FXML
    private Button btnSinglePlayer;

    @FXML
    private Button btnMultiPlayers;

    @FXML
    private RadioButton rbEasy;

    @FXML
    private RadioButton rbMedium;

    @FXML
    private RadioButton rbHard;

    /**
     * Méthode permettant de passer à la fenêtre Character Select en mode single
     * player
     */
    @FXML
    private void onSingleClick(ActionEvent e) {

    }

    /**
     * Méthode permettant de passer à la fenêtre Character Select en mode multi
     * player
     */
    @FXML
    private void onMultiClick(ActionEvent e) {

    }

    /**
     * Méthode qui initialise les bindings
     */
    public void init() {

    }
}
