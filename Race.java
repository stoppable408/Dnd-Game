package com.dnd.character;

public class Race {

	public static void makeHuman(Character character) {
		character.setRace("Human");
	}

	public static void makeOrc(Character character) {
		character.setRace("Orc");
		int strength = character.getStrength();
		int intelligence = character.getIntelligence();
		int wisdom = character.getWisdom();
		int charisma = character.getCharisma();
		int armorClass = character.getArmorClass();

		character.setStrength(strength + 2);
		character.setIntelligence(intelligence - 1);
		character.setWisdom(wisdom - 1);
		character.setCharisma(charisma - 1);
		character.setArmorClass(armorClass + 2);

	}
	/*
	 * As a player I want to play a Dwarf so that I can drink more than the orc
	 * 
	 * +1 to Constitution Modifier, -1 to Charisma Modifier doubles Constitution
	 * Modifier when adding to hit points per level (if positive) +2 bonus to
	 * attack/damage when attacking orcs (Dwarves hate Orcs)
	 */

	public static void makeDwarf(Character character) {
		character.setRace("Dwarf");
		int constitution = character.getConstitution();
		int charisma = character.getCharisma();

		character.setConstitution(constitution + 1);
		character.setCharisma(charisma - 1);

	}

}
