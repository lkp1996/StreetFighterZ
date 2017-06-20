package application;

public class Character {
    private String name;
    private int healthPoints;
    private String imgUrl;
    private Attack[] attacks;

    public Character(String name, int healthPoints, String imgUrl, Attack[] attacks) {
	this.name = name;
	this.healthPoints = healthPoints;
	this.imgUrl = imgUrl;
	this.attacks = attacks;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public int getHealthPoints() {
	return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
	this.healthPoints = healthPoints;
    }

    public String getImgUrl() {
	return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
    }

    public Attack[] getAttacks() {
	return attacks;
    }

    public void setAttacks(Attack[] attacks) {
	this.attacks = attacks;
    }

}
