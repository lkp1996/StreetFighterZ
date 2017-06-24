package application;

public class FightModel {
    private int actualRnd;
    private Battle battle;
    private int actualPlayer;

    public FightModel(int actualRnd, Battle battle, int actualPlayer) {
	this.actualRnd = actualRnd;
	this.battle = battle;
	this.actualPlayer = actualPlayer;
    }

    public boolean isFightFinished() {
	return this.actualRnd > this.battle.getRounds();

    }

    public void nextRound() {
	this.actualRnd++;
	nextPlayer();
    }

    public void nextPlayer() {
	if (actualPlayer == 1) {
	    actualPlayer = 2;
	} else {
	    actualPlayer = 1;
	}
    }

    public int getActualRnd() {
	return actualRnd;
    }

    public int getActualPlayer() {
	return actualPlayer;
    }

}
