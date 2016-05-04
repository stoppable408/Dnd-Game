package com.dnd.utilities;

import java.util.Calendar;
import java.util.Random;

import com.dnd.character.Character;

public class Utilities {

	public static int getDieRoll() {
		Calendar calendar = Calendar.getInstance();
		long seed = calendar.getTimeInMillis();
		Random random = new Random(seed);
		int number = random.nextInt(20) + 1;
		return number;
	}

	public static int getModifier(int attribute) {
		int modifier = (attribute - 10) / 2;
		return modifier;
	}

	public static Character updateExperience(Character character) {
		int experience = character.getExperience();
		int level = character.getLevel();
		character.setExperience(experience += 10);

		if (experience > (level * 1000)) {
			character.levelUp();
		}
		return character;
	}

	public static void checkRace(Character attacker, Character defender) {
		String attackerRace = attacker.getRace();
		String defenderRace = defender.getRace();
		int currentBonus = attacker.getAttackBonus();
		int currentDamageBonus = attacker.getDamageBonus();

		if (DwarfVsOrc(attackerRace, defenderRace)) {
			attacker.setAttackBonus(currentBonus + 2);
			attacker.setDamageBonus(currentDamageBonus + 2);
		}
		if (OrcvsElf(attackerRace, defenderRace)) {
			int armorClass = defender.getArmorClass();
			defender.setArmorClass(armorClass + 2);
		}
		if (HalflingvsEverybody(attackerRace, defenderRace)) {
			int armorClass = defender.getArmorClass();
			defender.setArmorClass(armorClass + 2);
		}

	}

	public static boolean DwarfVsOrc(String attackerRace, String defenderRace) {
		if ((attackerRace.equalsIgnoreCase("Dwarf") && defenderRace.equalsIgnoreCase("Orc")))
			return true;
		else {
			return false;
		}
	}

	public static boolean OrcvsElf(String attackerRace, String defenderRace) {
		if ((attackerRace.equalsIgnoreCase("Orc") && defenderRace.equalsIgnoreCase("Elf")))
			return true;
		else {
			return false;
		}
	}

	public static boolean HalflingvsEverybody(String attackerRace, String defenderRace) {
		if ((!attackerRace.equalsIgnoreCase("Halfling") && defenderRace.equalsIgnoreCase("Halfling")))
			return true;
		else
			return false;
	}
}
