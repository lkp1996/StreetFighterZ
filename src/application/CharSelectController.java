package application;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CharSelectController {

	private CharSelectModel model = new CharSelectModel();

	@FXML
	private Label name1;

	@FXML
	private Label name2;

	@FXML
	private ImageView imageP1;

	@FXML
	private ImageView imageP2;

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
	
	private boolean j1Selected = false;
	private boolean j2Selected = false;

	@FXML
	private void onCharChoosenEvent(ActionEvent e) {
		Button clickedButton = (Button) e.getSource();
		String idClick = clickedButton.getId();
		boolean joueur = idClick.endsWith("1"); // true = joueur 1
												// false = joueur 2
		char charact = idClick.charAt(7); // id du caractère séléctionné

		selecChar(joueur, charact);
	}

	private void selecChar(boolean joueur, char charact) {
		String nomPerso = "";
		String url = "/img/" + charact + ".png";
		Image img = new Image(getClass().getResource(url).toExternalForm(), 150.0, 120.0, true, true);

		switch (charact) {
		case '1':
			nomPerso = "Jin";
			break;
		case '2':
			nomPerso = "Yoshimitsu";
			break;
		case '3':
			nomPerso = "Hitmonchan";
			break;
		case '4':
			nomPerso = "Hitmonlee";
			break;
		case '5':
			nomPerso = "Ryo";
			break;
		case '6':
			nomPerso = "Chunlee";
			break;
		}
		if (joueur) {
			imageP1.setImage(img);
			name1.setText(nomPerso);
			j1Selected = true;
		} else {
			imageP2.setImage(img);
			name2.setText(nomPerso);
			j2Selected = true;
		}
	}

	@FXML
	private void randomizeChar1(ActionEvent e) {
		Random r = new Random();
		String charactS =  "" + (r.nextInt(6) + 1);
		char charact = charactS.charAt(0);
		selecChar(true, charact);
		j1Selected = true;
	}

	@FXML
	private void randomizeChar2(ActionEvent e) {
		Random r = new Random();
		String charactS =  "" + (r.nextInt(6) + 1);
		char charact = charactS.charAt(0);
		selecChar(false, charact);
		j2Selected = true;
	}

	@FXML
	private void goBackToMain(ActionEvent event) {
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

	@FXML
	private void goToBattle(ActionEvent event) {
		if(!allPlayerSelectedCharacter()){
			// affiche popup pour séléctionner un personnage
			System.out.println("veuillez séléctionner un personnage pour chaque joueur");
			return;
		}
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = null;

		try {
			root = FXMLLoader.load(getClass().getResource("StreetFighterZFight.fxml"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void init() {

	}
	
	private boolean allPlayerSelectedCharacter(){
		return true;
	}

}
