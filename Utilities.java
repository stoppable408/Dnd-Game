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

		if ((attackerRace.equalsIgnoreCase("Dwarf")) && (defenderRace.equalsIgnoreCase("Orc"))) {
			attacker.setAttackBonus(currentBonus + 2);

		}

	}
}
