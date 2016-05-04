package com.dnd.character;

import com.dnd.utilities.Utilities;

public class Paladin extends Character {
	final int hitPointsPerLevel = 8;
	final int minimumDamage = 1;
	final int criticalHit = 20;
	private int criticalDamageMultiplier = 2;
	private int attackBonus = 0;
	private int evilBonus = 0;

	@Override
	public void attack(Character enemy) {
		int currentAttackBonus = attackBonus;
		if (isEnemyEvil(enemy)) {
			criticalDamageMultiplier = 3;
			evilBonus = 2;
		}
		int roll = Utilities.getDieRoll();

		int strength = this.getStrength();
		int strengthModifier = Utilities.getModifier(strength);

		int enemyDexterity = enemy.getDexterity();
		int enemyDexterityModifier = Utilities.getModifier(enemyDexterity);

		int defense = enemy.getArmorClass() + enemyDexterityModifier;
		int attack = roll + strengthModifier + attackBonus + evilBonus;
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

	public boolean isEnemyEvil(Character enemy) {
		if (enemy.getAlignment() == -1) {
			return true;
		}
		return false;
	}

	@Override
	public void levelUp() {
		int currentHitPoints = this.getHitPoints();
		int constitutionModifier = Utilities.getModifier(currentHitPoints);
		int currentLevel = this.getLevel();
		this.setHitPoints(currentHitPoints + (hitPointsPerLevel + constitutionModifier));
		this.setLevel(++currentLevel);
		++attackBonus;

	}
}
