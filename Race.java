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

	public static void makeDwarf(Character character) {
		character.setRace("Dwarf");
		int constitution = character.getConstitution();
		int charisma = character.getCharisma();

		character.setConstitution(constitution + 1);
		character.setCharisma(charisma - 1);

	}

	public static void makeElf(Character character) {
		character.setRace("Elf");
		int dexterity = character.getDexterity();
		int constitution = character.getConstitution();

		character.setConstitution(constitution - 1);
		character.setDexterity(dexterity + 1);

	}

	public static void makeHalfling(Character character) {
		character.setRace("Halfling");
		int dexterity = character.getDexterity();
		int strength = character.getStrength();

		character.setStrength(strength - 1);
		character.setDexterity(dexterity + 1);
	}
}
