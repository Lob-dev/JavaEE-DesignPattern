package lob.code.kata.refactoring;

import lob.code.kata.regercy.Item;
import lob.code.kata.regercy.*;

import java.util.Arrays;
import java.util.Objects;

public class TexttestFixture {
	public static void main(String[] args) {
		System.out.println("OMGHAI!");

		Item[] items1 = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };

		Item[] items2 = new Item[] {
				new Item("+5 Dexterity Vest", 10, 20),
				new Item("Aged Brie", 2, 0),
				new Item("Elixir of the Mongoose", 5, 7),
				new Item("Sulfuras, Hand of Ragnaros", 0, 80),
				new Item("Sulfuras, Hand of Ragnaros", -1, 80),
				new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
				new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new Item("Conjured Mana Cake", 3, 6) };


		RegercyGildedRose regercyGildedRose = new RegercyGildedRose(items1);
		RefactoringGildedRose refactoringRose = new RefactoringGildedRose(items2);


		int days = 2;
		if (args.length > 0) {
			days = Integer.parseInt(args[0]) + 1;
		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items1) {
				System.out.println(item);
			}
			System.out.println();
			regercyGildedRose.updateQuality();

		}

		for (int i = 0; i < days; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (Item item : items2) {
				System.out.println(item);
			}
			System.out.println();
			refactoringRose.increaseQuality();

		}

		boolean condition = Objects.equals(Arrays.toString(items1), Arrays.toString(items2));
		System.out.println(condition);
	}
}
