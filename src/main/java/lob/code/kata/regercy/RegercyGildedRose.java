package lob.code.kata.regercy;

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

public class RegercyGildedRose {

	Item[] items;

	public RegercyGildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!items[i].name.equals("Aged Brie")
					&& !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (items[i].quality > 0) {
					if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
						items[i].quality = items[i].quality - 1;
					}
				}
			} else {
				if (items[i].quality < 50) {
					items[i].quality = items[i].quality + 1;

					if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].sellIn < 11) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}

						if (items[i].sellIn < 6) {
							if (items[i].quality < 50) {
								items[i].quality = items[i].quality + 1;
							}
						}
					}
				}
			}

			if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
				items[i].sellIn = items[i].sellIn - 1;
			}

			if (items[i].sellIn < 0) {
				if (!items[i].name.equals("Aged Brie")) {
					if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (items[i].quality > 0) {
							if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
								items[i].quality = items[i].quality - 1;
							}
						}
					} else {
						items[i].quality = items[i].quality - items[i].quality;
					}
				} else {
					if (items[i].quality < 50) {
						items[i].quality = items[i].quality + 1;
					}
				}
			}
		}
	}

}