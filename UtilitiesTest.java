package com.dnd.utilities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dnd.character.*;

public class UtilitiesTest {

	@Test
	public void ShouldLevelUp() {
		Fighter fighter = new Fighter();
		fighter.setExperience(999);
		fighter = (Fighter) Utilities.updateExperience(fighter);
		int level = fighter.getLevel();
		assertEquals(level, 2);
	}

	@Test
	public void WarMonkShouldHaveWisdomAddedToArmorClass() {
		WarMonk warmonk = new WarMonk();
		warmonk.setWisdom(30);
		int number = warmonk.getArmorClass(warmonk.getArmorClass());
		assertEquals(20, number);
	}

	@Test
	public void MonkShouldCalculateAttackBonusCorrectly() {
		WarMonk warmonk = new WarMonk();
		for (int i = 0; i < 10; i++) {
			warmonk.levelUp();
		}
		int attack = warmonk.getAttackBonus();
		assertNotEquals(attack, 0);
	}

	@Test
	public void DexterityModifierShouldChangeArmorClass() {
		Rogue rogue = new Rogue();
		rogue.setDexterity(30);
		int number = rogue.getArmorClass();
		assertEquals(number, 20);
	}

	@Test
	public void OrcRogueShouldHaveAugmentedStats() {
		Rogue rogue = new Rogue();
		int currentStr = rogue.getStrength();
		Race.makeOrc(rogue);
		int newStr = rogue.getStrength();
		assertNotEquals(currentStr, newStr);
	}

	@Test
	public void DwarfChracterShouldChangeWithOrcDefender() {
		Rogue rogue = new Rogue();
		rogue.setRace("Dwarf");
		int currentBonus = rogue.getAttackBonus();
		Fighter fighter = new Fighter();
		fighter.setRace("Orc");
		rogue.attack(fighter);
		int newBonus = rogue.getAttackBonus();
		assertEquals(currentBonus, newBonus);
	}

	@Test
	public void ElfShouldGainArmorClassWhenFightingOrc() {
		Rogue rogue = new Rogue();
		rogue.setRace("Orc");
		int currentBonus = rogue.getArmorClass();
		Fighter fighter = new Fighter();
		fighter.setRace("Elf");
		rogue.attack(fighter);
		int newBonus = rogue.getArmorClass();
		assertEquals(currentBonus, newBonus);
	}

}
