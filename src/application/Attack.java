package application;

public class Attack {
    private String name;
    private int damage;
    private double criticalChance;

    public Attack(String name, int damage, double criticalChance) {
	this.name = name;
	this.damage = damage;
	this.criticalChance = criticalChance;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getDamage() {
	return damage;
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

}
