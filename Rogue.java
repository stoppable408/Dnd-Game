package com.dnd.character;

import com.dnd.utilities.Utilities;

public class Rogue extends Character {
	final int hitPointsPerLevel = 5;
	final int minimumDamage = 1;
	final int criticalHit = 20;
	final int criticalDamageMultiplier = 3;
	public int attackBonus = 0;

	@Override

	public void attack(Character enemy) {
		int currentAttackBonus = attackBonus;
		int roll = Utilities.getDieRoll();

		int dexterity = this.getDexterity();
		int dexterityModifier = Utilities.getModifier(dexterity);

		int defense = enemy.getArmorClass();
		int attack = roll + dexterityModifier + attackBonus;
		int damage = minimumDamage + dexterityModifier;
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
		if (newLevel % 2 == 0) {
			attackBonus++;
		}
	}

}
