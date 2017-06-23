package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FightController {

	private static final String LOOSE = "You Gave up, you piece of shit !!";
	private static final String P1WIN = "Player 1 WIN !!";
	private static final String P2WIN = "Player 2 WIN !!";

	@FXML
	private ImageView imgVChar1;

	@FXML
	private ImageView imgVChar2;

	@FXML
	private ProgressBar pbHpChar1;

	@FXML
	private ProgressBar pbHpChar2;

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
		affichePopup(LOOSE, event);
	}

	private void affichePopup(String message, ActionEvent event) {
		Stage popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Fin de match");
		Label msgInfo = new Label(message);
		Button buttonOK = new Button("  Back to main  ");
		buttonOK.minWidth(200);
		buttonOK.setOnAction(e -> popup.close());
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(msgInfo);
		layout.getChildren().add(buttonOK);
		Scene scenePopup = new Scene(layout, 350, 100);
		popup.setScene(scenePopup);
		popup.showAndWait();
		backToMain(event);
	}

	private void backToMain(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("StreetFighterZMain.fxml"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
