/*
 * Copyright (c) 2019, Twiglet1022 <https://github.com/Twiglet1022>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.cluescrolls.clues;

import com.google.common.collect.ImmutableList;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.api.Item;
import static net.runelite.api.ItemID.*;
import net.runelite.api.NPC;
import net.runelite.api.coords.WorldPoint;
import static net.runelite.client.plugins.cluescrolls.ClueScrollOverlay.TITLED_CONTENT_COLOR;
import net.runelite.client.plugins.cluescrolls.ClueScrollPlugin;
import static net.runelite.client.plugins.cluescrolls.ClueScrollWorldOverlay.IMAGE_Z_OFFSET;
import net.runelite.client.plugins.cluescrolls.clues.item.AnyRequirementCollection;
import net.runelite.client.plugins.cluescrolls.clues.item.ItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.item.RangeItemRequirement;
import net.runelite.client.plugins.cluescrolls.clues.item.SingleItemRequirement;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

@Getter(AccessLevel.PUBLIC)
public class FaloTheBardClue extends ClueScroll implements TextClueScroll, NpcClueScroll
{
	private static final List<FaloTheBardClue> CLUES = ImmutableList.of(
		new FaloTheBardClue("A blood red weapon, a strong curved sword, found on the island of primate lords.", item(DRAGON_SCIMITAR)),
		new FaloTheBardClue("A book that preaches of some great figure, lending strength, might and vigour.", any("Any god book (must be complete)", item(HOLY_BOOK), item(BOOK_OF_BALANCE), item(UNHOLY_BOOK), item(BOOK_OF_LAW), item(BOOK_OF_WAR), item(BOOK_OF_DARKNESS))),
		new FaloTheBardClue("A bow of elven craft was made, it shimmers bright, but will soon fade.", any("Crystal Bow", item(CRYSTAL_BOW), item(CRYSTAL_BOW_24123))),
		new FaloTheBardClue("A fiery axe of great inferno, when you use it, you'll wonder where the logs go.", item(INFERNAL_AXE)),
		new FaloTheBardClue("A mark used to increase one's grace, found atop a seer's place.", item(MARK_OF_GRACE)),
		new FaloTheBardClue("A molten beast with fiery breath, you acquire these with its death.", item(LAVA_DRAGON_BONES)),
		new FaloTheBardClue("A shiny helmet of flight, to obtain this with melee, struggle you might.", item(ARMADYL_HELMET)),
		// The wiki doesn't specify whether the trimmed dragon defender will work so I've assumed that it doesn't
		new FaloTheBardClue("A sword held in the other hand, red its colour, Cyclops strength you must withstand.", item(DRAGON_DEFENDER)),
		new FaloTheBardClue("A token used to kill mythical beasts, in hopes of a blade or just for an xp feast.", item(WARRIOR_GUILD_TOKEN)),
		new FaloTheBardClue("Green is my favourite, mature ale I do love, this takes your herblore above.", item(GREENMANS_ALEM)),
		new FaloTheBardClue("It can hold down a boat or crush a goat, this object, you see, is quite heavy.", item(BARRELCHEST_ANCHOR)),
		new FaloTheBardClue("It comes from the ground, underneath the snowy plain. Trolls aplenty, with what looks like a mane.", item(BASALT)),
		new FaloTheBardClue("No attack to wield, only strength is required, made of obsidian, but with no room for a shield.", item(TZHAARKETOM)),
		new FaloTheBardClue("Penance healers runners and more, obtaining this body often gives much deplore.", item(FIGHTER_TORSO)),
		new FaloTheBardClue("Strangely found in a chest, many believe these gloves are the best.", item(BARROWS_GLOVES)),
		new FaloTheBardClue("These gloves of white won't help you fight, but aid in cooking, they just might.", item(COOKING_GAUNTLETS)),
		new FaloTheBardClue("They come from some time ago, from a land unto the east. Fossilised they have become, this small and gentle beast.", item(NUMULITE)),
		new FaloTheBardClue("To slay a dragon you must first do, before this chest piece can be put on you.", item(RUNE_PLATEBODY)),
		new FaloTheBardClue("Vampyres are agile opponents, damaged best with a weapon of many components.", any("Rod of Ivandis or Ivandis flail", range(ROD_OF_IVANDIS_10, ROD_OF_IVANDIS_1), item(IVANDIS_FLAIL)))
	);

	private static final WorldPoint LOCATION = new WorldPoint(2689, 3550, 0);
	private static final String FALO_THE_BARD = "Falo the Bard";

	private static SingleItemRequirement item(int itemId)
	{
		return new SingleItemRequirement(itemId);
	}

	private static AnyRequirementCollection any(String name, ItemRequirement... requirements)
	{
		return new AnyRequirementCollection(name, requirements);
	}

	private static RangeItemRequirement range(int startItemId, int endItemId)
	{
		return range(null, startItemId, endItemId);
	}

	private static RangeItemRequirement range(String name, int startItemId, int endItemId)
	{
		return new RangeItemRequirement(name, startItemId, endItemId);
	}

	private final String text;
	@Nonnull
	private final ItemRequirement[] itemRequirements;

	private FaloTheBardClue(String text, @Nonnull ItemRequirement... itemRequirements)
	{
		this.text = text;
		this.itemRequirements = itemRequirements;
	}

	@Override
	public void makeOverlayHint(PanelComponent panelComponent, ClueScrollPlugin plugin)
	{
		panelComponent.getChildren().add(TitleComponent.builder().text("Falo the Bard Clue").build());

		panelComponent.getChildren().add(LineComponent.builder().left("NPC:").build());
		panelComponent.getChildren().add(LineComponent.builder()
			.left(FALO_THE_BARD)
			.leftColor(TITLED_CONTENT_COLOR)
			.build());

		panelComponent.getChildren().add(LineComponent.builder().left("Item:").build());

		Item[] inventory = plugin.getInventoryItems();

		// If inventory is null, the player has nothing in their inventory
		if (inventory == null)
		{
			inventory = new Item[0];
		}

		for (ItemRequirement requirement : itemRequirements)
		{
			boolean inventoryFulfilled = requirement.fulfilledBy(inventory);

			panelComponent.getChildren().add(LineComponent.builder()
				.left(requirement.getCollectiveName(plugin.getClient()))
				.leftColor(TITLED_CONTENT_COLOR)
				.right(inventoryFulfilled ? "\u2713" : "\u2717")
				.rightColor(inventoryFulfilled ? Color.GREEN : Color.RED)
				.build());
		}
	}

	@Override
	public void makeWorldOverlayHint(Graphics2D graphics, ClueScrollPlugin plugin)
	{
		if (!LOCATION.isInScene(plugin.getClient()))
		{
			return;
		}

		for (NPC npc : plugin.getNpcsToMark())
		{
			OverlayUtil.renderActorOverlayImage(graphics, npc, plugin.getClueScrollImage(), Color.ORANGE, IMAGE_Z_OFFSET);
		}
	}

	@Override
	public String[] getNpcs()
	{
		return new String[]{FALO_THE_BARD};
	}

	public static FaloTheBardClue forText(String text)
	{
		for (FaloTheBardClue clue : CLUES)
		{
			if (clue.text.equalsIgnoreCase(text))
			{
				return clue;
			}
		}

		return null;
	}
}
