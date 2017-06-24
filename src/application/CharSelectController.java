package application;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CharSelectController {

	private CharSelectModel model;
	private Battle battle;

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
		Character charSelected = new Character();

		switch (charact) {
		case '1':
			charSelected = model.jin;
			nomPerso = charSelected.getName();
			break;
		case '2':
			charSelected = model.yoshimitsu;
			nomPerso = charSelected.getName();
			break;
		case '3':
			charSelected = model.hitmonchan;
			nomPerso = charSelected.getName();
			break;
		case '4':
			charSelected = model.hitmonlee;
			nomPerso = charSelected.getName();
			break;
		case '5':
			charSelected = model.ryu;
			nomPerso = charSelected.getName();
			break;
		case '6':
			charSelected = model.chunLi;
			nomPerso = charSelected.getName();
			break;
		}
		if (joueur) {
			imageP1.setImage(img);
			name1.setText(nomPerso);
			battle.setChar1(charSelected);
			j1Selected = true;
		} else {
			imageP2.setImage(img);
			name2.setText(nomPerso);
			battle.setChar2(charSelected);
			j2Selected = true;
		}
	}

	@FXML
	private void randomizeChar1(ActionEvent e) {
		Random r = new Random();
		String charactS = "" + (r.nextInt(6) + 1);
		char charact = charactS.charAt(0);
		selecChar(true, charact);
		j1Selected = true;
	}

	@FXML
	private void randomizeChar2(ActionEvent e) {
		Random r = new Random();
		String charactS = "" + (r.nextInt(6) + 1);
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
	private void changeRound(MouseEvent event) {
		if (sldNumRound.getValue() <= 2)
			sldNumRound.setValue(1.0);
		else if (sldNumRound.getValue() <= 4)
			sldNumRound.setValue(3.0);
		else
			sldNumRound.setValue(5.0);
	}

	@FXML
	private void goToBattle(ActionEvent event) {
		if (!allPlayerSelectedCharacter()) {
			Stage popup = new Stage();
			popup.initModality(Modality.APPLICATION_MODAL);
			popup.setTitle("Selection de personnages");
			Label msgInfo = new Label("Veuillez selectionner un personnage\npour chaque joueur");
			Button buttonOK = new Button("    OK    ");
			buttonOK.minWidth(200);
			buttonOK.setOnAction(e -> popup.close());
			VBox layout = new VBox(10);
			layout.setAlignment(Pos.CENTER);
			layout.getChildren().add(msgInfo);
			layout.getChildren().add(buttonOK);
			Scene scenePopup = new Scene(layout, 350, 100);
			popup.setScene(scenePopup);
			popup.showAndWait();
			return;
		}

		int rnd = (int) sldNumRound.getValue();
		battle.setRounds(rnd);
		model.setRounds(rnd);
		
		((Node) (event.getSource())).getScene().getWindow().hide();
		Stage stage = new Stage();
		Parent root = null;
		FXMLLoader loader = null;
		try {
			loader = new FXMLLoader(getClass().getResource("StreetFighterZFight.fxml"));
			root = loader.load();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		FightController ctrl = loader.<FightController>getController();
		ctrl.init(battle);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	private boolean allPlayerSelectedCharacter() {
		return j1Selected && j2Selected;
	}

	public void init(int difficulty, boolean solo) {
		model = new CharSelectModel(difficulty, solo);
		battle = model.getBattle();
	}

}
