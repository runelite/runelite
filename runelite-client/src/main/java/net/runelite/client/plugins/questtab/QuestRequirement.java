/*
 * Copyright (c) 2018, Eadgars Ruse <https://github.com/Eadgars-Ruse>
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
package net.runelite.client.plugins.questtab;

import java.util.HashMap;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.widgets.WidgetInfo;

@AllArgsConstructor
@Getter
public class QuestRequirement
{
	private Quest[] questReqs;
	private String[] miscReqs;
	private int questPoints;
	private int enemy;
	private int combat;
	private HashMap<Skill, Integer> skillReqs;
	
	public QuestRequirement()
	{
		this.questReqs = new Quest[] {};
		this.miscReqs = new String[] {};
		this.questPoints = 0;
		this.enemy = 0;
		this.combat = 0;
		this.skillReqs = new HashMap<>();
	}

	public void initReq(Quest[] questReqs, String[] miscReqs, int questPoints, int enemy, int combat, int attack, int defence,
						int strength, int hitpoints, int ranged, int prayer, int magic, int cooking, int woodcutting, int fletching,
						int fishing, int firemaking, int crafting, int smithing, int mining, int herblore, int agility, int thieving,
						int slayer, int farming, int runecraft, int hunter, int construction)
	{
		this.questReqs = questReqs;
		this.miscReqs = miscReqs;
		this.questPoints = questPoints;
		this.enemy = enemy;
		this.combat = combat;

		if (attack != 0) this.skillReqs.put(Skill.ATTACK, attack);

		if (defence != 0) this.skillReqs.put(Skill.DEFENCE, defence);

		if (strength != 0) this.skillReqs.put(Skill.STRENGTH, strength);

		if (hitpoints != 0) this.skillReqs.put(Skill.HITPOINTS, hitpoints);

		if (ranged != 0) this.skillReqs.put(Skill.RANGED, ranged);

		if (prayer != 0) this.skillReqs.put(Skill.PRAYER, prayer);

		if (magic != 0) this.skillReqs.put(Skill.MAGIC, magic);

		if (cooking != 0) this.skillReqs.put(Skill.COOKING, cooking);

		if (woodcutting != 0) this.skillReqs.put(Skill.WOODCUTTING, woodcutting);

		if (fletching != 0) this.skillReqs.put(Skill.FLETCHING, fletching);

		if (fishing != 0) this.skillReqs.put(Skill.FISHING, fishing);

		if (firemaking != 0) this.skillReqs.put(Skill.FIREMAKING, firemaking);

		if (crafting != 0) this.skillReqs.put(Skill.CRAFTING, crafting);

		if (smithing != 0) this.skillReqs.put(Skill.SMITHING, smithing);

		if (mining != 0) this.skillReqs.put(Skill.MINING, mining);

		if (herblore != 0) this.skillReqs.put(Skill.HERBLORE, herblore);

		if (agility != 0) this.skillReqs.put(Skill.AGILITY, agility);

		if (thieving != 0) this.skillReqs.put(Skill.THIEVING, thieving);

		if (slayer != 0) this.skillReqs.put(Skill.SLAYER, slayer);

		if (farming != 0) this.skillReqs.put(Skill.FARMING, farming);

		if (runecraft != 0) this.skillReqs.put(Skill.RUNECRAFT, runecraft);

		if (hunter != 0) this.skillReqs.put(Skill.HUNTER, hunter);

		if (construction != 0) this.skillReqs.put(Skill.CONSTRUCTION, construction);

	}

	public boolean isMet(QuestTabPlugin plugin, Client client)
	{
		for (Quest q : questReqs)
		{
			if (plugin.getQuestStatus().get(q) != QuestTabPlugin.QuestStatus.COMPLETE)
			{
				return false;
			}
		}

		for (Skill s : skillReqs.keySet())
		{
			if (client.getRealSkillLevel(s) < skillReqs.get(s))
			{
				return false;
			}
		}

		int combatLevel = client.getLocalPlayer().getCombatLevel();

		if (combatLevel < this.combat)
		{
			return false;
		}

		int qp = Integer.parseInt(client.getWidget(WidgetInfo.QUEST_LIST_QP).getText().replaceAll("[^0-9?!.]", ""));

		return (qp >= this.questPoints);
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("");

		for (Quest q : questReqs)
		{
			sb.append(q.toString());
			sb.append(", ");
		}


		for (String r : miscReqs)
		{
			sb.append(r.toString());
			sb.append(", ");
		}

		if (questPoints != 0)
		{
			sb.append("qp: ");
			sb.append(questPoints);
			sb.append(", ");
		}

		if (enemy != 0)
		{
			sb.append("enemy:");
			sb.append(enemy);
			sb.append(", ");
		}

		if (combat != 0)
		{
			sb.append("combat");
			sb.append(combat);
			sb.append(", ");
		}

		for (Skill s : skillReqs.keySet())
		{
			sb.append(skillReqs.get(s));
			sb.append(" ");
			sb.append(s.toString());
			sb.append(", ");
		}

		if (sb.length() > 2)
		{
			sb.setLength(sb.length() - 2);
		}

		return sb.toString();
	}

}
