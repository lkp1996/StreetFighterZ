package application;

import java.util.Random;

public class Attack {
	private String name;
	private int damage;
	private double criticalChance;
	private double timesCriticalDamage;

	public Attack(String name, int damage, double criticalChance, double timesCriticalDamage) {
		this.name = name;
		this.damage = damage;
		this.criticalChance = criticalChance;
		this.timesCriticalDamage = timesCriticalDamage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		int dmgtmp = damage;
		Random r = new Random();
		int rndm = r.nextInt(99) + 1;
		if (rndm < criticalChance)
			dmgtmp = (int) (dmgtmp * timesCriticalDamage);
		return dmgtmp;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getCriticalChance() {
		return criticalChance;
	}

	public void setCriticalChance(double criticalChance) {
		this.criticalChance = criticalChance;
	}

	public double getTimesCriticalDamage() {
		return timesCriticalDamage;
	}

	public void setTimesCriticalDamage(double timesCriticalDamage) {
		this.timesCriticalDamage = timesCriticalDamage;
	}

}
