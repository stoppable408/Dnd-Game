package com.dnd.character;

import com.dnd.utilities.Utilities;

public class Fighter extends Character {
	final int hitPointsPerLevel = 10;
	final int classBonus = 5;
	final int minimumDamage = 1;
	final int criticalHit = 20;
	final int criticalDamageMultiplier = 2;

	public Fighter() {
		this.setConstitution(getConstitution() + classBonus);

	}

	@Override
	public void attack(Character enemy) {
		int currentAttackBonus = getAttackBonus();
		Utilities.checkRace(this, enemy);
		int roll = Utilities.getDieRoll();

		int strength = this.getStrength();
		int strengthModifier = Utilities.getModifier(strength);

		int enemyDexterity = enemy.getDexterity();
		int enemyDexterityModifier = Utilities.getModifier(enemyDexterity);

		int defense = enemy.getArmorClass() + enemyDexterityModifier;
		int attack = roll + strengthModifier + getAttackBonus();
		int damage = minimumDamage + strengthModifier + getDamageBonus();
		if (isCriticalHit(roll)) {
			damage *= criticalDamageMultiplier;
		}
		if (attack > defense) {
			enemy.setHitPoints(enemy.getHitPoints() - damage);
			Utilities.updateExperience(this);
		}
		this.setAttackBonus(currentAttackBonus);
	}

	@Override
	public void levelUp() {

		int currentHitPoints = this.getHitPoints();
		int constitutionModifier = Utilities.getModifier(currentHitPoints);
		int currentLevel = this.getLevel();
		this.setHitPoints(currentHitPoints + (hitPointsPerLevel + constitutionModifier));
		this.setLevel(++currentLevel);
		this.setAttackBonus(this.getAttackBonus() + 1);
	}

}
