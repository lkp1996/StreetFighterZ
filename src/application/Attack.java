package application;

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

    public double getTimesCriticalDamage() {
	return timesCriticalDamage;
    }

    public void setTimesCriticalDamage(double timesCriticalDamage) {
	this.timesCriticalDamage = timesCriticalDamage;
    }

}
