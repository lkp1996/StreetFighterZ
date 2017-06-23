package application;

public class FightModel {
	private int actualRnd;
	private Battle battle;

	public boolean isFightFinished(){
		return actualRnd > battle.getRounds();
		
	}
	
	public void incrementActuelRound(){
		actualRnd++;
	}
	
	public void initBattle(Battle battle){
		actualRnd = 1;
		
	}
	
}
