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
	 * Methode permettant de passer a� la fenetre Character Select en mode
	 * single player
	 */
	@FXML
	private void onSingleClick(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StreetFighterZCharSelect.fxml"));
			VBox charSelectParent = loader.load();
			Scene charSelectScene = new Scene(charSelectParent);
			Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			CharSelectController ctrl = loader.<CharSelectController>getController();
			int difficulty;
			if(rbEasy.isSelected()) difficulty = 1;
			else if (rbMedium.isSelected()) difficulty = 2;
			else difficulty = 3;
			ctrl.init(difficulty, true);
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
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("StreetFighterZCharSelect.fxml"));
			VBox charSelectParent = loader.load();
			Scene charSelectScene = new Scene(charSelectParent);
			Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			CharSelectController ctrl = loader.<CharSelectController>getController();
			ctrl.init(0, false);
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
