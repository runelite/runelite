/*
 * MIT License
 *
 * Copyright (c) 2018 Tomas Slusny
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.runelite.data.dump;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class MediaWikiTemplateTest
{
	@Test
	void parseInfoboxItem1()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Dragon claws\n" +
				"|image = [[File:Dragon claws.png]]\n" +
				"|release = [[5 January]] [[2017]]\n" +
				"|update = Dragon Claws & 3rd Birthday\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = Yes\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|high = 123000\n" +
				"|low = 82000\n" +
				"|destroy = Drop\n" +
				"|store = No\n" +
				"|exchange = gemw\n" +
				"|examine = A set of fighting claws.\n" +
				"|weight = 0\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
		assertEquals(123000, (int) template.getInt("high"));
	}

	@Test
	void parseInfoboxItem2()
	{
		final String data =
			"{{Infobox item\n" +
				"|name = Magic shortbow (i)\n" +
				"|image = [[File:Magic shortbow (i).png]]\n" +
				"|release = [[18 September]] [[2014]]\n" +
				"|update = Bounty Hunter\n" +
				"|members = Yes\n" +
				"|tradeable = No\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|quest = No\n" +
				"|low = 640\n" +
				"|high = 960\n" +
				"|store = No\n" +
				"|examine = Short and magical, but still effective.\n" +
				"|weight = 1\n" +
				"|destroy = Drop\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
		assertEquals((int) template.getInt("high"), 960);
	}

	@Test
	void parseInfoboxItem3()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Proselyte cuisse\n" +
				"|image = [[File:Proselyte cuisse.png|Proselyte cuisse]]\n" +
				"|release = [[20 September]] [[2006]]\n" +
				"|update = Slug Menace\n" +
				"|members = Yes\n" +
				"|quest = [[The Slug Menace]]\n" +
				"|tradeable = Yes\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|noteable = Yes\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value = 10000\n" +
				"|store = 10000\n" +
				"|exchange = gemw\n" +
				"|weight = 7.711\n" +
				"|examine = A Proselyte Temple Knight's leg armour.\n" +
				"|id = 9676,20565\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxItem4()
	{
		final String data =
			"{{Infobox Item\n" +
				"|name = Explorer's ring 2\n" +
				"|image = [[File:Explorer's ring 2.png]]\n" +
				"|release = [[5 March]] [[2015]]\n" +
				"|update = Achievement Diaries\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = No\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|noteable = No\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value = 0\n" +
				"|store = No\n" +
				"|weight = 0\n" +
				"|examine = A Lumbridge explorer's ring.\n" +
				"|id = 13126\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxItem5()
	{
		final String data =
			"{{Infobox Item\n" +
				"|version1 = Normal\n" +
				"|version2 = Broken\n" +
				"|name1 = Fighter hat\n" +
				"|name2 = Fighter hat (broken)\n" +
				"|image1 = [[File:Fighter hat.png]]\n" +
				"|image2 = [[File:Fighter hat (broken).png]]\n" +
				"|release1 = [[4 January]] [[2007]]\n" +
				"|release2 = [[21 July]] [[2016]]\n" +
				"|update1 = Barbarian Assault\n" +
				"|update2 = Broken Armour & Open Beta\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable = No\n" +
				"|equipable1 = Yes\n" +
				"|equipable2 = No\n" +
				"|stackable = No\n" +
				"|noteable = No\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value1 = 65002\n" +
				"|value2 = 1\n" +
				"|alchable = No\n" +
				"|store1 = 275\n" +
				"|store2 = No\n" +
				"|currency = Honour points in each role; must have also killed [[Penance Queen|Queen]]\n" +
				"|seller = Commander Connad\n" +
				"|weight = 2\n" +
				"|examine1 = A Penance Fighter hat.\n" +
				"|examine2 = A broken Penance Fighter hat.\n" +
				"|id1 = 10548\n" +
				"|id2 = 20507\n" +
				"}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxItem6()
	{
		final String data =
			"{{Infobox Item\n" +
				"|version1 = Unpoisoned\n" +
				"|version2 = Poison\n" +
				"|version3 = Poison+\n" +
				"|version4 = Poison++\n" +
				"|version5 = Karambwan poison\n" +
				"|name1 = Iron hasta\n" +
				"|name2 = Iron hasta(p)\n" +
				"|name3 = Iron hasta(p+)\n" +
				"|name4 = Iron hasta(p++)\n" +
				"|name5 = Iron hasta(kp)\n" +
				"|image1 = [[File:Iron hasta.png]]\n" +
				"|image2 = [[File:Iron hasta(p).png]]\n" +
				"|image3 = [[File:Iron hasta(p+).png]]\n" +
				"|image4 = [[File:Iron hasta(p++).png]]\n" +
				"|image5 = [[File:Iron hasta(kp).png]]\n" +
				"|release = [[3 July]] [[2007]]\n" +
				"|update = Barbarian Training\n" +
				"|members = Yes\n" +
				"|quest = No\n" +
				"|tradeable1 = Yes\n" +
				"|tradeable2 = Yes\n" +
				"|tradeable3 = Yes\n" +
				"|tradeable4 = Yes\n" +
				"|tradeable5 = No\n" +
				"|equipable = Yes\n" +
				"|stackable = No\n" +
				"|noteable1 = Yes\n" +
				"|noteable2 = Yes\n" +
				"|noteable3 = Yes\n" +
				"|noteable4 = Yes\n" +
				"|noteable5 = No\n" +
				"|placeholder = Yes\n" +
				"|destroy = Drop\n" +
				"|value = 91\n" +
				"|store = No\n" +
				"|exchange1 = gemw\n" +
				"|exchange2 = gemw\n" +
				"|exchange3 = gemw\n" +
				"|exchange4 = gemw\n" +
				"|weight1 = 2.267\n" +
				"|weight2 = 2.267\n" +
				"|weight3 = 2\n" +
				"|weight4 = 2.267\n" +
				"|weight5 = 2.267\n" +
				"|examine1 = An iron-tipped, one-handed hasta.\n" +
				"|examine2 = A poison-tipped, one-handed iron hasta.\n" +
				"|examine3 = A poison-tipped, one-handed iron hasta.\n" +
				"|examine4 = A poison-tipped, one-handed iron hasta.\n" +
				"|examine5 = A karambwan poison-tipped, one-handed iron hasta.\n" +
				"|id1 = 11369\n" +
				"|id2 = 11386\n" +
				"|id3 = 11389\n" +
				"|id4 = 11391\n" +
				"|id5 = 11388\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Item", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxBonuses1()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|astab = 41\n" +
				"|aslash = 57\n" +
				"|acrush = -4\n" +
				"|amagic = 0\n" +
				"|arange = 0\n" +
				"|dstab = 13\n" +
				"|dslash = 26\n" +
				"|dcrush = 7\n" +
				"|dmagic = 0\n" +
				"|drange = 0\n" +
				"|str = 56\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = 0\n" +
				"|caption = A player wearing dragon claws.\n" +
				"|aspeed = 4|slot = 2h\n" +
				"|image = Dragon claws equipped.png{{!}}130px}}\n";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals(4, (int) template.getInt("aspeed"));
		assertEquals("2h", template.getValue("slot"));
		assertEquals("Dragon claws equipped.png{{!}}130px", template.getValue("image"));
	}

	@Test
	void parseInfoboxBonuses2()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|version1 = Uncharged\n" +
				"|version2 = Charged\n" +
				"|image_1 = Dragonfire shield (uncharged) equipped.png{{!}}150px\n" +
				"|image_2 = Dragonfire shield equipped.png{{!}}150px\n" +
				"|astab = 0\n" +
				"|aslash = 0\n" +
				"|acrush = 0\n" +
				"|amagic = -10\n" +
				"|arange = -5\n" +
				"|dstab1 = +20\n" +
				"|dslash1 = +25\n" +
				"|dcrush1 = +22\n" +
				"|dmagic1 = +10\n" +
				"|drange1 = +22\n" +
				"|dstab2 = +70\n" +
				"|dslash2 = +75\n" +
				"|dcrush2 = +72\n" +
				"|dmagic2 = +10\n" +
				"|drange2 = +72\n" +
				"|str = +7\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = 0\n" +
				"|slot = Shield\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals(70, (int) template.getInt("dstab2"));
	}

	@Test
	void parseInfoboxBonuses3()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|astab = 0\n" +
				"|aslash = 0\n" +
				"|acrush = 0\n" +
				"|amagic = -21\n" +
				"|arange = -7\n" +
				"|dstab = +33\n" +
				"|dslash = +31\n" +
				"|dcrush = +29\n" +
				"|dmagic = -4\n" +
				"|drange = +31\n" +
				"|str = 0\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"|prayer = +6\n" +
				"|slot = Legs\n" +
				"|image = Proselyte armour equipped.png{{!}}110px\n" +
				"|caption = A player wearing proselyte armour.\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
		assertEquals((int) template.getInt("prayer"), 6);
	}

	@Test
	void parseInfoboxBonuses4()
	{
		final String data =
			"{{Infobox Bonuses\n" +
				"|image   = \n" +
				"|caption = \n" +
				"|astab   =0 \n" +
				"|aslash  =0 \n" +
				"|acrush  =0 \n" +
				"|amagic  =0 \n" +
				"|arange  =0 \n" +
				"|dstab   =0 \n" +
				"|dslash  =0 \n" +
				"|dcrush  =0 \n" +
				"|dmagic  =0 \n" +
				"|drange  =0 \n" +
				"|str     =0 \n" +
				"|prayer  =+1 \n" +
				"|slot    = ring\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
	}

	@Test
	void parseInfoboxBonuses5()
	{
		final String data =
			"{{Infobox Bonuses|| astab   = +8\n" +
				"| aspeed  = 5\n" +
				"| aslash  = -2\n" +
				"| acrush  = +6\n" +
				"| amagic  = 0\n" +
				"| arange  = 0\n" +
				"| dstab   = 0\n" +
				"| dslash  = +1\n" +
				"| dcrush  = 0\n" +
				"| dmagic  = 0\n" +
				"| drange  = 0\n" +
				"| str     = +9\n" +
				"|rstr = 0\n" +
				"|mdmg = 0\n" +
				"| prayer  = 0\n" +
				"|image = Steel pickaxe equipped.png{{!}}150px\n" +
				"|caption = A player wielding a steel pickaxe.\n" +
				"||slot = Weapon}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Bonuses", data);
		assertNotNull(template);
	}

	@Test
	void parseLua()
	{
		final String exchangeInfoData =
			"return {\n" +
				"    itemId     = 13652,\n" +
				"    price      = 83173735,\n" +
				"    last       = 83533604,\n" +
				"    date       = '12:18, November 08, 2018 (UTC)',\n" +
				"    lastDate   = '05:43, November 08, 2018 (UTC)',\n" +
				"    icon       = 'Dragon claws.png',\n" +
				"    item       = 'Dragon claws',\n" +
				"    value      = -205000,\n" +
				"    limit      = nil,\n" +
				"    members    = true,\n" +
				"    category   = nil,\n" +
				"    examine    = 'A set of fighting claws.'\n" +
				"}\n";

		final MediaWikiTemplate exchangeInfo = MediaWikiTemplate.parseLua(exchangeInfoData);
		assertNotNull(exchangeInfo);
		assertEquals((int) exchangeInfo.getInt("value"), -205000);
	}

	@Test
	void parseKeysWithSpaces()
	{
		final String data =
			"{{Infobox Monster\n" +
				"|name = Aberrant spectre\n" +
				"|combat = 96\n" +
				"|attack speed = 4\n" +
				"|foo attack style= Magic\n" +
				"|id = 2,3,4,5,6,7\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Monster", data);
		assertNotNull(template);
		assertEquals(template.getInt("combat"), 96);
		assertEquals(template.getInt("attack speed"), 4);
		assertEquals(template.getValue("foo attack style"), "Magic");
	}

	@Test
	void parseWikitextExactName()
	{
		final String data =
			"{{ Infobox Monster/sandbox \n" +
				"|version1 = Lv 51\n" +
				"|version2 = Lv 76\n" +
				"|name = Brawler\n" +
				"|combat1 = 51\n" +
				"|combat2 = 76\n" +
				"|hitpoints1 = 53\n" +
				"|hitpoints2 = 83\n" +
				"|max hit1 = 7\n" +
				"|max hit2 = 9\n" +
				"|slaylvl = No\n" +
				"|slayxp = No\n" +
				"|att1 = <!--Level 51 stats-->\n" +
				"|att2 = <!--Level 76 stats-->\n" +
				"|id1 = 1734\n" +
				"|id2 = 1735\n" +
				"}}";

		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Monster/sandbox", data);
		assertNotNull(template);

		final MediaWikiTemplate template2 = MediaWikiTemplate.parseWikitext("Infobox Monster", data);
		assertNull(template2);
	}

	@Test
	void parseSwitchInfobox()
	{
		final String data =
			"{{External|rs}}\n" +
				"{{Switch infobox\n" +
				"|item1= \n" +
				"{{Infobox Monster\n" +
					"|name = Ghast\n" +
					"|combat = 30\n" +
					"|id = 946\n" +
				"}}\n" +
				"|text1 = Level 30\n" +
				"|item2= \n" +
				"{{Infobox Monster\n" +
					"|name = Ghast\n" +
					"|combat = 79\n" +
					"|id = 5625\n" +
				"}}\n" +
				"|text2 = Level 79\n" +
				"|item3= \n" +
				"{{Infobox Monster\n" +
					"|name = Ghast\n" +
					"|combat = 109\n" +
					"|id = 5626\n" +
				"}}\n" +
				"|text3 = Level 109\n" +
				"|item4= \n" +
				"{{Infobox Monster\n" +
					"|name = Ghast\n" +
					"|combat = 139\n" +
					"|id = 5627\n" +
				"}}\n" +
				"|text4 = Level 139\n" +
				"|item5 =\n" +
				"{{Infobox non-player character\n" +
					"|name = \n" +
					"|update = Nature Spirit Quest\n" +
					"|race = Undead\n" +
					"|members = Yes\n" +
					"|quest = [[Nature Spirit]]\n" +
					"|location = [[Morytania]]\n" +
					"|shop = No\n" +
					"|gender = N/A\n" +
					"|examine = \n" +
					"|id = 945, 5622, 5623, 5624\n" +
				"}}\n" +
				"|text5 = Invisible\n" +
				"}}";

		final MediaWikiTemplate switchInfobox = MediaWikiTemplate.parseWikitext("Switch infobox", data);
		assertNotNull(switchInfobox);

		// Infobox monster
		final List<MediaWikiTemplate> templates = MediaWikiTemplate.parseSwitchInfoboxItems("Infobox monster", switchInfobox);
		assertEquals(templates.size(), 4);

		final MediaWikiTemplate item1 = templates.get(0);
		assertEquals(item1.getInt("combat"), 30);

		final MediaWikiTemplate item2 = templates.get(1);
		assertEquals(item2.getInt("combat"), 79);

		// Infobox non-player character
		final List<MediaWikiTemplate> npcs = MediaWikiTemplate.parseSwitchInfoboxItems("Infobox non-player character", switchInfobox);
		assertEquals(npcs.size(), 1);

		final MediaWikiTemplate npc1 = npcs.get(0);
		assertEquals(npc1.getValue("race"), "Undead");

		// Infobox item
		final List<MediaWikiTemplate> items = MediaWikiTemplate.parseSwitchInfoboxItems("Infobox item", switchInfobox);
		assertEquals(items.size(), 0);
	}
}