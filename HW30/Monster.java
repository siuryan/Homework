// Team FileNotFound -- Ryan Siu, Jonathan Quang, Rihui Zheng
// APCS1 pd5
// HW30 -- Ye Olde Role Playing Game
// 2016-11-16

/* Monster class */
public class Monster {
    
    // instance vars
    public int hp;
    public int strength;
    public int defense;
    public double attRate;
    
    //constructor: set monster's attributes
    public Monster() {
	this.hp = 150;
	this.strength = (int)(Math.random() * 45) + 20; // [20,65)
	this.defense = 20;
	this.attRate = 1;
    }//end constructor
    
    //checks to see if monster is alive
    public boolean isAlive() {
	return this.hp > 0;
    }//end isAlive

    public String getName() {
	return "Monster";
    }

    //gets defense attribute of monster
    public int getDefense() {
	return this.defense;
    }//end getDefense

    //monster takes damage
    public void lowerHP (int damage) {
	this.hp -= damage;
    }//end lowerHP

    //returns how much damage is done by warrior
    public int attack (Warrior w) {
	int damage = (int)(this.strength * this.attRate) - w.getDefense();
	if (damage < 0) {
	    damage = 0;
	}
	w.lowerHP(damage);
	return damage;
    }//end attack

}//end class
