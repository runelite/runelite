/*
 * MIT License
 *
 * Copyright (c) 2019 TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package net.runelite.data.dump.wiki;

import java.util.List;
import net.runelite.data.dump.MediaWikiTemplate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class NpcStatsDumperTest
{
	@Test
	void npcVariantFallThrough()
	{
		final String data =
			"{{Infobox Monster\n" +
				"|combat = 2\n" +
				"|combat8 = \n" +
				"|combat10 = 4\n" +
				"}}";


		final MediaWikiTemplate template = MediaWikiTemplate.parseWikitext("Infobox Monster", data);
		assertNotNull(template);

		assertEquals(NpcStatsDumper.getInt("combat", 0, template), 2);
		assertEquals(NpcStatsDumper.getInt("combat", 7, template), 2);
		assertNull(NpcStatsDumper.getInt("combat", 8, template));
		assertNull(NpcStatsDumper.getInt("combat", 9, template));
		assertEquals(NpcStatsDumper.getInt("combat", 10, template), 4);
	}

	@Test
	void parseSwitchInfoboxItems()
	{
		final String data =
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
		final List<MediaWikiTemplate> templates = NpcStatsDumper.parseSwitchInfoboxItems("Infobox monster", switchInfobox);
		assertEquals(templates.size(), 4);

		final MediaWikiTemplate item1 = templates.get(0);
		assertEquals(item1.getInt("combat"), 30);

		final MediaWikiTemplate item2 = templates.get(1);
		assertEquals(item2.getInt("combat"), 79);

		// Infobox non-player character
		final List<MediaWikiTemplate> npcs = NpcStatsDumper.parseSwitchInfoboxItems("Infobox non-player character", switchInfobox);
		assertEquals(npcs.size(), 1);

		final MediaWikiTemplate npc1 = npcs.get(0);
		assertEquals(npc1.getValue("race"), "Undead");

		// Infobox item
		final List<MediaWikiTemplate> items = NpcStatsDumper.parseSwitchInfoboxItems("Infobox item", switchInfobox);
		assertEquals(items.size(), 0);
	}
}
