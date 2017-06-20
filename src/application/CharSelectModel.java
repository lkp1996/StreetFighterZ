package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CharSelectModel implements ICharSelectModel {
    private IntegerProperty roundsPty;

    public CharSelectModel() {
	this.roundsPty = new SimpleIntegerProperty();

	// Character 1
	Attack hadoken = new Attack("Hadoken", 2, 0.5);
	Attack flyingKick = new Attack("Flying Kick", 3, 0.3);
	Attack reppuuJinraiShou = new Attack("Reppuu Jinrai Shou", 4, 0.2);
	Attack[] attacksRyu = { hadoken, flyingKick, reppuuJinraiShou };
	Character ryu = new Character("Ryu", 20, "../imgs/ryu.jpg", attacksRyu);

	// Character 2
	Attack hyakuretsukyaku = new Attack("Hyakuretsukyaku", 2, 0.5);
	Attack spinningBirdKick = new Attack("Spinning Bird Kick", 3, 0.3);
	Attack tenshokyaku = new Attack("Tenshokyaku", 4, 0.2);
	Attack[] attacksChunLi = { hyakuretsukyaku, spinningBirdKick, tenshokyaku };
	Character chunLi = new Character("Chun-Li", 20, "../imgs/chunli.png", attacksChunLi);

	// Character 3
	Attack reverseThrow = new Attack("Reverse Throw", 2, 0.5);
	Attack ultimatePunch = new Attack("Ultimate Punch", 3, 0.3);
	Attack chickenButcher = new Attack("Chicken Butcher", 4, 0.2);
	Attack[] attacksJin = { reverseThrow, ultimatePunch, chickenButcher };
	Character jin = new Character("Jin", 20, "../imgs/jin.png", attacksJin);

	// Character 4
	Attack harakiri = new Attack("Harakiri", 2, 0.5);
	Attack swordStab = new Attack("Sword Stab", 3, 0.3);
	Attack kamikaze = new Attack("Kamikaze", 4, 0.2);
	Attack[] attacksYoshimitsu = { harakiri, swordStab, kamikaze };
	Character yoshimitsu = new Character("Yoshimitsu", 20, "../imgs/yoshimitsu.png", attacksYoshimitsu);

	// Character 5
	Attack firePunch = new Attack("Fire Punch", 2, 0.5);
	Attack takeDown = new Attack("Take Down", 3, 0.3);
	Attack skullBash = new Attack("Skull Bash", 4, 0.2);
	Attack[] attacksHitmonchan = { firePunch, takeDown, skullBash };
	Character hitmonchan = new Character("Hitmonchan", 20, "../imgs/hitmonchan.png", attacksHitmonchan);

	// Character 6
	Attack doubleKick = new Attack("Double Kick", 2, 0.5);
	Attack rollingKick = new Attack("Rolling Kick", 3, 0.3);
	Attack highJumpKick = new Attack("High Jump Kick", 4, 0.2);
	Attack[] attacksHitmonlee = { doubleKick, rollingKick, highJumpKick };
	Character hitmonlee = new Character("Hitmonlee", 20, "../imgs/hitmonlee.png", attacksHitmonlee);
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
