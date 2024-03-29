package application;

public class FightModel {
    private int actualRnd;
    private Battle battle;
    private int actualPlayer;
    private boolean solo;

    public FightModel(int actualRnd, Battle battle, int actualPlayer, boolean solo) {
	this.actualRnd = actualRnd;
	this.battle = battle;
	this.actualPlayer = actualPlayer;
	this.solo = solo;
    }

    public boolean isFightFinished() {
	return this.actualRnd > this.battle.getRounds();

    }

    public void nextRound() {
	this.actualRnd++;
	if(!solo) nextPlayer();
    }

    public void setActualPlayer(int actualPlayer) {
		this.actualPlayer = actualPlayer;
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
