package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CharSelectModel implements ICharSelectModel {
    private IntegerProperty roundsPty;
    private Battle battle = new Battle();
    public Character ryu;
    public Character chunLi;
    public Character jin;
    public Character yoshimitsu;
    public Character hitmonchan;
    public Character hitmonlee;

    public CharSelectModel(int difficulty, boolean solo) {
	this.roundsPty = new SimpleIntegerProperty();
	battle.setSolo(solo);
	battle.setDifficulty(difficulty);

	// Character 1
	Attack hadoken = new Attack("Hadoken", 1, 0.5, 5);
	Attack flyingKick = new Attack("Flying Kick", 2, 0.3, 2);
	Attack reppuuJinraiShou = new Attack("Reppuu Jinrai Shou", 3, 0.2, 2);
	Attack[] attacksRyu = { hadoken, flyingKick, reppuuJinraiShou };
	ryu = new Character("Ryu", 21, "../imgs/ryu.jpg", attacksRyu);

	// Character 2
	Attack hyakuretsukyaku = new Attack("Hyakuretsukyaku", 2, 0.3, 1.5);
	Attack spinningBirdKick = new Attack("Spinning Bird Kick", 3, 0.15, 2);
	Attack tenshokyaku = new Attack("Tenshokyaku", 3, 0.1, 3);
	Attack[] attacksChunLi = { hyakuretsukyaku, spinningBirdKick, tenshokyaku };
	chunLi = new Character("Chun-Li", 19, "../imgs/chunli.png", attacksChunLi);

	// Character 3
	Attack reverseThrow = new Attack("Reverse Throw", 1, 0.6, 4);
	Attack ultimatePunch = new Attack("Ultimate Punch", 2, 0.3, 2);
	Attack chickenButcher = new Attack("Chicken Butcher", 3, 0.1, 2);
	Attack[] attacksJin = { reverseThrow, ultimatePunch, chickenButcher };
	jin = new Character("Jin", 20, "../imgs/jin.png", attacksJin);

	// Character 4
	Attack harakiri = new Attack("Harakiri", 2, 0.5, 2);
	Attack swordStab = new Attack("Sword Stab", 3, 0.2, 2);
	Attack kamikaze = new Attack("Kamikaze", 3, 0.05, 4);
	Attack[] attacksYoshimitsu = { harakiri, swordStab, kamikaze };
	yoshimitsu = new Character("Yoshimitsu", 18, "../imgs/yoshimitsu.png", attacksYoshimitsu);

	// Character 5
	Attack firePunch = new Attack("Fire Punch", 1, 0.5, 3);
	Attack takeDown = new Attack("Take Down", 2, 0.4, 1.5);
	Attack skullBash = new Attack("Skull Bash", 3, 0.3, 2);
	Attack[] attacksHitmonchan = { firePunch, takeDown, skullBash };
	hitmonchan = new Character("Hitmonchan", 19, "../imgs/hitmonchan.png", attacksHitmonchan);

	// Character 6
	Attack doubleKick = new Attack("Double Kick", 2, 0.4, 2);
	Attack rollingKick = new Attack("Rolling Kick", 2, 0.2, 3);
	Attack highJumpKick = new Attack("High Jump Kick", 3, 0.05, 3);
	Attack[] attacksHitmonlee = { doubleKick, rollingKick, highJumpKick };
	hitmonlee = new Character("Hitmonlee", 18, "../imgs/hitmonlee.png", attacksHitmonlee);
    }


	@Override
    public int getRounds() {
	return roundsPty.get();
    }

    @Override
    public void setRounds(int rounds) {
	this.roundsPty.set(rounds);
    }

    @Override
    public IntegerProperty getRoundsPty() {
	return roundsPty;
    }

}
