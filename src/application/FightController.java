package application;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FightController {

	private static final String LOOSE = "You gave up !?! Ya piece of shit !!";
	private static final String P1WIN = "Player 1 WIN !!";
	private static final String P2WIN = "Player 2 WIN !!";
	private Battle battle;
	private FightModel model;

	private int hpChar1 = 0;
	private int hpChar2 = 0;

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
		Button clickedButton = (Button) event.getSource();
		String idClick = clickedButton.getId();
		Attack currAttack = null;
		if (this.model.getActualPlayer() == 1) {
			int currChar2HP = this.battle.getChar2().getHealthPoints();
			if (idClick.endsWith("1")) {
				currAttack = this.battle.getChar1().getAttacks()[0];
			} else if (idClick.endsWith("2")) {
				currAttack = this.battle.getChar1().getAttacks()[1];
			} else {
				currAttack = this.battle.getChar1().getAttacks()[2];
			}
			txaLogs.appendText(this.battle.getChar1().getName() + " attacked " + this.battle.getChar2().getName()
					+ " with " + currAttack.getName() + "\n");
			updateHPBar(2, currAttack.getDamage());
			this.battle.getChar2().setHealthPoints(currChar2HP - currAttack.getDamage());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			boolean fini = checkPlayerWonRound(1, this.battle.getChar2().getHealthPoints(), event);
			txaLogs.appendText("Player 2's turn : \n");
			if(fini) return;
		} else if(!battle.isSolo()) {
			int currChar1HP = this.battle.getChar1().getHealthPoints();
			if (idClick.endsWith("1")) {
				currAttack = this.battle.getChar2().getAttacks()[0];
			} else if (idClick.endsWith("2")) {
				currAttack = this.battle.getChar2().getAttacks()[1];
			} else {
				currAttack = this.battle.getChar2().getAttacks()[2];
			}
			txaLogs.appendText(this.battle.getChar2().getName() + " attacked " + this.battle.getChar1().getName()
					+ " with " + currAttack.getName() + "\n");
			updateHPBar(1, currAttack.getDamage());
			this.battle.getChar1().setHealthPoints(currChar1HP - currAttack.getDamage());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			checkPlayerWonRound(2, this.battle.getChar1().getHealthPoints(), event);
			txaLogs.appendText("Player 1's turn : \n");
		}
		if (battle.isSolo()) {
			attackAuto(event);
		}else{
			this.model.nextPlayer();
			changeCharAttacks();
		}
		System.out.println("HP Char 1 : " + this.battle.getChar1().getHealthPoints());
		System.out.println("HP Char 2 : " + this.battle.getChar2().getHealthPoints() + "\n");
		
	}

	private void attackAuto(ActionEvent event) {
		Random r = new Random();
		int currChar1HP = this.battle.getChar1().getHealthPoints();
		Attack currAttack = this.battle.getChar1().getAttacks()[r.nextInt(2)];

		txaLogs.appendText(this.battle.getChar2().getName() + " attacked " + this.battle.getChar1().getName() + " with "
				+ currAttack.getName() + "\n");
		updateHPBar(1, currAttack.getDamage());
		this.battle.getChar1().setHealthPoints(currChar1HP - currAttack.getDamage());

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkPlayerWonRound(2, this.battle.getChar1().getHealthPoints(), event);
		txaLogs.appendText("Player 1's turn : \n");
	}

	private void changeCharAttacks() {
		if (this.model.getActualPlayer() == 1) {
			btnAttack1.setText(this.battle.getChar1().getAttacks()[0].getName());
			btnAttack2.setText(this.battle.getChar1().getAttacks()[1].getName());
			btnAttack3.setText(this.battle.getChar1().getAttacks()[2].getName());
		} else {
			btnAttack1.setText(this.battle.getChar2().getAttacks()[0].getName());
			btnAttack2.setText(this.battle.getChar2().getAttacks()[1].getName());
			btnAttack3.setText(this.battle.getChar2().getAttacks()[2].getName());
		}
	}

	public boolean checkPlayerWonRound(int numPlayer, int hpOponent, ActionEvent event) {
		if (hpOponent <= 0) {
			if (numPlayer == 1) {
				lblRndWonChar1.setText((Integer.parseInt(lblRndWonChar1.getText()) + 1) + "");
				lblRndLostChar2.setText((Integer.parseInt(lblRndLostChar2.getText()) + 1) + "");
				txaLogs.appendText(this.battle.getChar1().getName() + " win this round \n");
			} else {
				lblRndWonChar2.setText((Integer.parseInt(lblRndWonChar2.getText()) + 1) + "");
				lblRndLostChar1.setText((Integer.parseInt(lblRndLostChar1.getText()) + 1) + "");
				txaLogs.appendText(this.battle.getChar2().getName() + " win this round \n");
			}
			nextRound(Integer.parseInt(lblRndWonChar1.getText()), Integer.parseInt(lblRndWonChar2.getText()), event);
			return  true;
		}
		return false;
	}

	public void nextRound(int roundWonChar1, int roundWonChar2, ActionEvent event) {
		this.model.nextRound();
		if (this.model.isFightFinished()) {
			if (roundWonChar1 > roundWonChar2) {
				affichePopup(P1WIN);
			} else {
				affichePopup(P2WIN);
			}
			backToMain(event);
		} else {
			lblNumRound.setText(this.model.getActualRnd() + "");

			this.battle.getChar1().setHealthPoints(hpChar1);
			this.battle.getChar2().setHealthPoints(hpChar2);

			pbHpChar1.setProgress(1);
			pbHpChar2.setProgress(1);
		}
	}

	private void updateHPBar(int numPlayer, int damageReceived) {
		if (numPlayer == 1) {
			int playerHP = this.battle.getChar1().getHealthPoints();
			double newHP = (pbHpChar1.getProgress() / playerHP) * (playerHP - damageReceived);
			pbHpChar1.setProgress(newHP);
		} else {
			int playerHP = this.battle.getChar2().getHealthPoints();
			double newHP = (pbHpChar2.getProgress() / playerHP) * (playerHP - damageReceived);
			pbHpChar2.setProgress(newHP);
		}
	}

	public void initFight() {
		this.battle = CharSelectController.getBattle();
		
		this.model = new FightModel(1, this.battle, 1, battle.isSolo());

		hpChar1 = this.battle.getChar1().getHealthPoints();
		hpChar2 = this.battle.getChar2().getHealthPoints();

		String urlChar1 = "/img/" + this.battle.getChar1().getId() + ".png";
		Image imgChar1 = new Image(getClass().getResource(urlChar1).toExternalForm(), 150.0, 120.0, true, true);
		this.imgVChar1.setImage(imgChar1);

		String urlChar2 = "/img/" + this.battle.getChar2().getId() + ".png";
		Image imgChar2 = new Image(getClass().getResource(urlChar2).toExternalForm(), 150.0, 120.0, true, true);
		imgVChar2.setImage(imgChar2);

		lblNumRound.setText(this.model.getActualRnd() + "");

		btnAttack1.setText(this.battle.getChar1().getAttacks()[0].getName());
		btnAttack2.setText(this.battle.getChar1().getAttacks()[1].getName());
		btnAttack3.setText(this.battle.getChar1().getAttacks()[2].getName());

		lblRndWonChar1.setText("0");
		lblRndLostChar1.setText("0");

		lblRndWonChar2.setText("0");
		lblRndLostChar2.setText("0");

		pbHpChar1.setProgress(1);
		pbHpChar2.setProgress(1);

		txaLogs.setText("Player 1's turn : \n");
	}

	@FXML
	private void giveUp(ActionEvent event) {
		affichePopup(LOOSE);
		backToMain(event);
	}

	private void affichePopup(String message) {
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

	@FXML
	public void initialize() {
		initFight();
	}

}
