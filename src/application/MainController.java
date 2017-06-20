package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController {

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
	 * Methode permettant de passer à la fenêtre Character Select en mode
	 * single player
	 */
	@FXML
	private void onSingleClick(ActionEvent event) {
		System.out.println("sigle player click");
		try {
			Parent charSelectParent = FXMLLoader.load(getClass().getResource("StreetFighterZCharSelect.fxml"));
			Scene charSelectScene = new Scene(charSelectParent);
			Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			appStage.setScene(charSelectScene);
			appStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode permettant de passer à la fenêtre Character Select en mode
	 * multi player
	 */
	@FXML
	private void onMultiClick(ActionEvent event) {
		System.out.println("2 players click");
		try {
			Parent charSelectParent = FXMLLoader.load(getClass().getResource("StreetFighterZCharSelect.fxml"));
			Scene charSelectScene = new Scene(charSelectParent);
			Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			appStage.setScene(charSelectScene);
			appStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Méthode qui initialise les bindings
	 */
	public void init() {

	}
}
