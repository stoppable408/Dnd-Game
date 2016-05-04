package com.dnd.character;

import com.dnd.Battle;
import com.dnd.utilities.Utilities;

public abstract class Character implements Battle {
	private String name;
	private byte alignment;
	private int strength = 10;
	private int dexterity = 10;
	private int constitution = 10;
	private int wisdom = 10;
	private int charisma = 10;
	private int intelligence = 10;
	private int experience = 0;
	private int level = 1;
	private int armorClass = 10;
	private int hitPoints = 5;
	private String race;
	private int attackBonus = 0;
	private int damageBonus = 0;
	private boolean criticalHit = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAlignment() {
		return alignment;
	}

	public void setAlignment(byte alignment) {
		this.alignment = alignment;
	}

	public int getArmorClass() {
		int dexterity = this.getDexterity();
		int dexterityModifier = Utilities.getModifier(dexterity);
		return (armorClass + dexterityModifier);
	}

	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}

	public int getHitPoints() {
		int constitution = this.getConstitution();
		int constitutionModifier = Utilities.getModifier(constitution);
		return (hitPoints + constitutionModifier);
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAttackBonus() {
		return attackBonus;
	}

	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	public void setDamageBonus(int damageBonus) {
		this.damageBonus = damageBonus;
	}

	public boolean isCriticalHit(int roll) {
		if ((roll == 20) || ((roll == 19) && (this.getRace() == "Elf")))
			;
		this.setCriticalHit(true);
		return criticalHit;
	}

	public void setCriticalHit(boolean criticalHit) {
		this.criticalHit = criticalHit;
	}

	public abstract void levelUp();

}
