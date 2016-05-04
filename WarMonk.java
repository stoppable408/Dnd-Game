package com.dnd.character;

import com.dnd.utilities.Utilities;

public class WarMonk extends Character {
	final int hitPointsPerLevel = 6;
	final int minimumDamage = 3;
	final int criticalHit = 20;
	final int criticalDamageMultiplier = 2;
	public int attackBonus = 0;

	public int getArmorClass(int currentArmorClass) {
		currentArmorClass = this.getArmorClass();
		int wisdom = this.getWisdom();
		int wisdomModifier = Utilities.getModifier(wisdom);
		int dexterity = this.getDexterity();
		int dexterityModifier = Utilities.getModifier(dexterity);
		return (currentArmorClass + (dexterityModifier + wisdomModifier));
	}

	@Override
	public void attack(Character enemy) {
		int currentAttackBonus = attackBonus;
		int roll = Utilities.getDieRoll();

		int strength = this.getStrength();
		int strengthModifier = Utilities.getModifier(strength);

		int enemyDexterity = enemy.getDexterity();
		int enemyDexterityModifier = Utilities.getModifier(enemyDexterity);

		int defense = enemy.getArmorClass() + enemyDexterityModifier;
		int attack = roll + strengthModifier;
		int damage = minimumDamage + strengthModifier;
		if (roll == criticalHit) {
			damage *= criticalDamageMultiplier;
		}
		if (attack > defense) {
			enemy.setHitPoints(enemy.getHitPoints() - damage);
			Utilities.updateExperience(this);
		}
		attackBonus = currentAttackBonus;
	}

	@Override
	public void levelUp() {
		int currentHitPoints = this.getHitPoints();
		int constitutionModifier = Utilities.getModifier(currentHitPoints);
		int currentLevel = this.getLevel();
		this.setHitPoints(currentHitPoints + (hitPointsPerLevel + constitutionModifier));
		this.setLevel(++currentLevel);
		int newLevel = this.getLevel();
		if ((newLevel % 3 == 0) || (newLevel % 2 == 0)) {
			attackBonus++;
		}

	}

	public int getAttackBonus() {
		return attackBonus;
	}
}
