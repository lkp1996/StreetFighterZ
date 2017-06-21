package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CharSelectController {

	private CharSelectModel model = new CharSelectModel();

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

	@FXML
	private void onCharChoosenEvent(ActionEvent e) {
		Button clickedButton = (Button) e.getSource();
		String idClick = clickedButton.getId();
		boolean joueur = idClick.endsWith("1");	// true = joueur 1
												// false = joueur 2
		char charact = idClick.charAt(7); // id du caractère séléctionné
		
		String url = "/img/" + charact + ".png";
		Image img = new Image(getClass().getResource(url).toExternalForm(), 150.0, 120.0, true, true);
		
		if(joueur) imageP1.setImage(img);
		else imageP2.setImage(img);
	}

	@FXML
	private void randomizeChar1(ActionEvent e) {

	}

	@FXML
	private void randomizeChar2(ActionEvent e) {

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
	private void goToBattle(ActionEvent e) {

	}

	public void init() {

	}

	Stage prevStage;
}
