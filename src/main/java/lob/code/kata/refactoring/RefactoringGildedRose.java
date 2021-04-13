package lob.code.kata.refactoring;

import lob.code.kata.regercy.Item;

/*
	-------- day 0 --------
	name, sellIn, quality
	+5 Dexterity Vest, 10, 20
	Aged Brie, 2, 0
	Elixir of the Mongoose, 5, 7
	Sulfuras, Hand of Ragnaros, 0, 80
	Sulfuras, Hand of Ragnaros, -1, 80
	Backstage passes to a TAFKAL80ETC concert, 15, 20
	Backstage passes to a TAFKAL80ETC concert, 10, 49
	Backstage passes to a TAFKAL80ETC concert, 5, 49
	Conjured Mana Cake, 3, 6

	-------- day 1 --------
	name, sellIn, quality
	+5 Dexterity Vest, 9, 19
	Aged Brie, 1, 1
	Elixir of the Mongoose, 4, 6
	Sulfuras, Hand of Ragnaros, 0, 80
	Sulfuras, Hand of Ragnaros, -1, 80
	Backstage passes to a TAFKAL80ETC concert, 14, 21
	Backstage passes to a TAFKAL80ETC concert, 9, 50
	Backstage passes to a TAFKAL80ETC concert, 4, 50
	Conjured Mana Cake, 2, 5
 */
public class RefactoringGildedRose {

	Item[] items;

	public RefactoringGildedRose(Item[] items) {
		this.items = items;
	}

	// quality 품질
	// sellIn 유통기한

	private void addQuality(Item item, int sellIn, int quality) {
		if (item.sellIn < sellIn) {
			if (item.quality < quality) {
				++item.quality;
			}
		}
	}

	public void agedBrie(Item item) {

		--item.sellIn;

		if (item.quality < 50) {
			++item.quality;
		}

		if (item.sellIn >= 0) return;

		if (item.quality < 50) {
			++item.quality;
		}
	}

	public void backstagePassesToATafkal80etConcert(Item item) {

		if (item.quality < 50) {
			++item.quality;

			addQuality(item, 11, 50);
			addQuality(item, 6, 50);
		}
		--item.sellIn;

		if (item.sellIn < 0) {
			item.quality = 0;
		}
	}

	public void muyaho(Item item) {

		--item.sellIn;

		if (item.quality > 0) {
			--item.quality;
		}

		if (item.sellIn >= 0) return;

		if (item.quality > 0) {
			--item.quality;
		}
	}

	public void addQuality() {

		for (Item item : items) {

			if ("Aged Brie".equals(item.name)) {
				agedBrie(item);
			} else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
				backstagePassesToATafkal80etConcert(item);
			} else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
			} else {
				muyaho(item);
			}
		}

	}
}
