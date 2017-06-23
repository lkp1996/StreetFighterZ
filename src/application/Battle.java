package application;

public class Battle {
    private Character char1;
    private Character char2;
    private int rounds;

    public Battle(Character char1, Character char2, int rounds) {
	this.char1 = char1;
	this.char2 = char2;
	this.rounds = rounds;
    }
    
    public Battle(){
	
    }

    public Character getChar1() {
	return char1;
    }

    public void setChar1(Character char1) {
	this.char1 = char1;
    }

    public Character getChar2() {
	return char2;
    }

    public void setChar2(Character char2) {
	this.char2 = char2;
    }

    public int getRounds() {
	return rounds;
    }

    public void setRounds(int rounds) {
	this.rounds = rounds;
    }

}
