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

	private void increaseQualityWhenLessThanGivenQualityAndSellIn(final Item item, int sellIn, int quality) {
		if (item.sellIn < sellIn) {
			if (item.quality < quality) {
				++item.quality;
			}
		}
	}

	private void increaseQualityWhenLessThanGivenQuality(final Item item, int quality) {
		if (item.quality < quality) {
			++item.quality;
		}
	}

	private void reduceQualityWhenLessThanGivenQuality(final Item item, int quality) {
		if (item.quality > quality) {
			--item.quality;
		}
	}

	private void zeroQualityWhenLessThanGivenSellIn(final Item item, int sellIn) {
		if (item.sellIn < sellIn) {
			item.quality = 0;
		}
	}

	private void reduceShelfLife(final Item item) {
		--item.sellIn;
	}

	public void agedBrie(Item item) {

		reduceShelfLife(item);

		increaseQualityWhenLessThanGivenQuality(item, 50);

		if (item.sellIn >= 0) return;

		increaseQualityWhenLessThanGivenQuality(item, 50);
	}

	public void backstagePasses(Item item) {

		if (item.quality < 50) {
			++item.quality;

			increaseQualityWhenLessThanGivenQualityAndSellIn(item, 11, 50);

			increaseQualityWhenLessThanGivenQualityAndSellIn(item, 6, 50);
		}

		reduceShelfLife(item);

		zeroQualityWhenLessThanGivenSellIn(item, 0);
	}

	public void anotherItems(Item item) {

		reduceShelfLife(item);

		reduceQualityWhenLessThanGivenQuality(item, 0);

		if (item.sellIn >= 0) return;

		reduceQualityWhenLessThanGivenQuality(item, 0);
	}

	public void increaseQuality() {

		for (Item item : items) {

			if ("Aged Brie".equals(item.name)) {
				agedBrie(item);
			} else if ("Backstage passes to a TAFKAL80ETC concert".equals(item.name)) {
				backstagePasses(item);
			} else if ("Sulfuras, Hand of Ragnaros".equals(item.name)) {
			} else {
				anotherItems(item);
			}
		}

	}
}
