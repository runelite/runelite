package net.runelite.client.plugins.wiki.dps;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.EquipmentInventorySlot;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.ItemID;
import net.runelite.api.Skill;
import net.runelite.api.VarPlayer;
import net.runelite.api.Varbits;

@Slf4j
@Singleton
public class WikiDpsDataService
{

	private final Client client;
	private final Gson gson;

	@Inject
	private WikiDpsDataService(Client client, Gson gson)
	{
		this.client = client;
		this.gson = gson;
	}

	public JsonObject buildShortlinkData()
	{
		assert client.isClientThread();

		JsonObject j = new JsonObject();

		// Build the player's loadout data
		JsonArray loadouts = new JsonArray();
		ItemContainer eqContainer = client.getItemContainer(InventoryID.EQUIPMENT);

		JsonObject l = new JsonObject();
		JsonObject eq = new JsonObject();

		eq.add("ammo", createEquipmentObject(eqContainer, EquipmentInventorySlot.AMMO));
		eq.add("body", createEquipmentObject(eqContainer, EquipmentInventorySlot.BODY));
		eq.add("cape", createEquipmentObject(eqContainer, EquipmentInventorySlot.CAPE));
		eq.add("feet", createEquipmentObject(eqContainer, EquipmentInventorySlot.BOOTS));
		eq.add("hands", createEquipmentObject(eqContainer, EquipmentInventorySlot.GLOVES));
		eq.add("head", createEquipmentObject(eqContainer, EquipmentInventorySlot.HEAD));
		eq.add("legs", createEquipmentObject(eqContainer, EquipmentInventorySlot.LEGS));
		eq.add("neck", createEquipmentObject(eqContainer, EquipmentInventorySlot.AMULET));
		eq.add("ring", createEquipmentObject(eqContainer, EquipmentInventorySlot.RING));
		eq.add("shield", createEquipmentObject(eqContainer, EquipmentInventorySlot.SHIELD));
		eq.add("weapon", createEquipmentObject(eqContainer, EquipmentInventorySlot.WEAPON));
		l.add("equipment", eq);

		JsonObject skills = new JsonObject();
		skills.addProperty("atk", client.getRealSkillLevel(Skill.ATTACK));
		skills.addProperty("def", client.getRealSkillLevel(Skill.DEFENCE));
		skills.addProperty("hp", client.getRealSkillLevel(Skill.HITPOINTS));
		skills.addProperty("magic", client.getRealSkillLevel(Skill.MAGIC));
		skills.addProperty("mining", client.getRealSkillLevel(Skill.MINING));
		skills.addProperty("prayer", client.getRealSkillLevel(Skill.PRAYER));
		skills.addProperty("ranged", client.getRealSkillLevel(Skill.RANGED));
		skills.addProperty("str", client.getRealSkillLevel(Skill.STRENGTH));
		l.add("skills", skills);

		JsonElement style = getCombatStyle();
		if (style != null)
		{
			l.add("style", style);
		}

		JsonElement spell = getSpell();
		if (spell != null)
		{
			l.add("spell", spell);
		}

		JsonArray prayers = new JsonArray();
		for (DpsPrayer prayer : DpsPrayer.values())
		{
			if (client.isPrayerActive(prayer.getRlPrayer()))
			{
				prayers.add(prayer.getJsValue());
			}
		}
		l.add("prayers", prayers);

		JsonObject buffs = new JsonObject();
		buffs.addProperty("inWilderness", client.getVarbitValue(Varbits.IN_WILDERNESS) == 1);
		buffs.addProperty("kandarinDiary", client.getVarbitValue(Varbits.DIARY_KANDARIN_HARD) == 1);
		buffs.addProperty("onSlayerTask", client.getVarpValue(VarPlayer.SLAYER_TASK_SIZE) > 0);
		buffs.addProperty("chargeSpell", client.getVarpValue(VarPlayer.CHARGE_GOD_SPELL) > 0);
		l.add("buffs", buffs);

		l.addProperty("name", client.getLocalPlayer().getName());

		loadouts.add(l);
		j.add("loadouts", loadouts);

		return j;
	}

	@Nullable
	private JsonObject createEquipmentObject(ItemContainer itemContainer, EquipmentInventorySlot slot)
	{
		if (itemContainer == null)
		{
			return null;
		}

		if (slot == EquipmentInventorySlot.BOOTS && itemContainer.count() == 1 && itemContainer.contains(ItemID.CHEFS_HAT))
		{
			JsonObject o = new JsonObject();
			o.addProperty("id", ItemID.SNAIL_SHELL);
			return o;
		}

		Item item = itemContainer.getItem(slot.getSlotIdx());
		if (item != null)
		{
			JsonObject o = new JsonObject();
			o.addProperty("id", item.getId());
			return o;
		}
		return null;
	}

	@Nullable
	private JsonElement getCombatStyle()
	{
		WeaponCategory category = WeaponCategory.fromVarb(client.getVarbitValue(Varbits.EQUIPPED_WEAPON_TYPE));
		if (category == null)
		{
			return null;
		}

		PlayerCombatStyle style = category.styleFromVarp(client.getVarpValue(VarPlayer.ATTACK_STYLE));
		if (style == null)
		{
			return null;
		}

		if (client.getVarbitValue(Varbits.DEFENSIVE_CASTING_MODE) == 1)
		{
			style = style.withStance("Defensive Autocast");
		}

		return gson.toJsonTree(style);
	}

	@Nullable
	private JsonObject getSpell()
	{
		Spell spell = Spell.fromVarb(client.getVarbitValue(Varbits.AUTOCAST_SPELL));
		if (spell == null)
		{
			return null;
		}

		// the spell type on the site includes other metadata so only send the name and the site will expand the rest
		JsonObject spellObj = new JsonObject();
		spellObj.addProperty("name", spell.getName());
		return spellObj;
	}
}
