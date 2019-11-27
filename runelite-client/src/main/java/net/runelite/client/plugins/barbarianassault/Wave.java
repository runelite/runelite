/*
 * Copyright (c) 2018, Jacob M <https://github.com/jacoblairm>
 * Copyright (c) 2019, 7ate9 <https://github.com/se7enAte9>
 * Copyright (c) 2019, https://openosrs.com
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
package net.runelite.client.plugins.barbarianassault;

import com.google.common.collect.ImmutableList;
import java.awt.Color;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.chat.ChatMessageBuilder;

@Data
public class Wave
{
	@Getter(AccessLevel.NONE)
	private static final ImmutableList<WidgetInfo> WIDGETS = ImmutableList.of(
		WidgetInfo.BA_FAILED_ATTACKER_ATTACKS,
		WidgetInfo.BA_RUNNERS_PASSED,
		WidgetInfo.BA_EGGS_COLLECTED,
		WidgetInfo.BA_HITPOINTS_REPLENISHED,
		WidgetInfo.BA_WRONG_POISON_PACKS,
		WidgetInfo.BA_HONOUR_POINTS_REWARD
	);

	@Getter(AccessLevel.NONE)
	private static final ImmutableList<WidgetInfo> POINTSWIDGETS = ImmutableList.of(
		//Base
		WidgetInfo.BA_BASE_POINTS,
		//Attacker
		WidgetInfo.BA_FAILED_ATTACKER_ATTACKS_POINTS,
		WidgetInfo.BA_RANGERS_KILLED,
		WidgetInfo.BA_FIGHTERS_KILLED,
		//Defender
		WidgetInfo.BA_RUNNERS_PASSED_POINTS,
		WidgetInfo.BA_RUNNERS_KILLED,
		//Collector
		WidgetInfo.BA_EGGS_COLLECTED_POINTS,
		//Healer
		WidgetInfo.BA_HEALERS_KILLED,
		WidgetInfo.BA_HITPOINTS_REPLENISHED_POINTS,
		WidgetInfo.BA_WRONG_POISON_PACKS_POINTS
	);

	@Getter(AccessLevel.NONE)
	private final Client client;

	private final Timer waveTimer;

	private boolean runnersKilled;

	private boolean rangersKilled;

	private boolean healersKilled;

	private boolean fightersKilled;

	private int collectedEggCount = 0;

	private int positiveEggCount = 0;

	private int wrongEggs = 0;

	private int hpHealed = 0;

	private int totalCollectedEggCount = 0;

	private int totalHpHealed = 0;

	private int[] amounts = new int[6];

	private int[] allPointsList = new int[10];

	private int[] points = new int[6];

	private int[] otherRolesPointsList = new int[4];

	private String[] descriptions = {" A: ", "; D: ", "; C: ", "; Vial: ", "; H packs: ", "; Total: "};

	private String[] otherPointsDescriptions = {" A: ", " D: ", " C: ", " H: "};

	Wave(Client client)
	{
		this.client = client;
		this.waveTimer = new Timer();
	}

	void setAmounts()
	{
		for (int i = 0; i < WIDGETS.size(); i++)
		{
			Widget w = client.getWidget(WIDGETS.get(i));
			if (w != null)
			{
				amounts[i] = Integer.parseInt(w.getText());
			}
		}
	}

	void setPoints()
	{
		for (int i = 0; i < POINTSWIDGETS.size(); i++)
		{
			Widget w = client.getWidget(POINTSWIDGETS.get(i));
			allPointsList[i] = Integer.parseInt(w.getText());
			switch (i)
			{
				case 1:
					points[0] += allPointsList[i];
					break;
				case 4:
					points[1] += allPointsList[i];
					break;
				case 6:
					points[2] += allPointsList[i];
					break;
				case 8:
				case 9:
					points[3] += allPointsList[i];
					break;
				default:
					break;
			}
		}
		points[5] = 0;
		for (int i = 0; i < points.length - 1; i++)
		{
			points[5] += points[i];
		}
		for (int i = 0; i < POINTSWIDGETS.size(); i++)
		{
			Widget w = client.getWidget(POINTSWIDGETS.get(i));
			switch (i)
			{
				case 0:
					otherRolesPointsList[0] += Integer.parseInt(w.getText());
					otherRolesPointsList[1] += Integer.parseInt(w.getText());
					otherRolesPointsList[2] += Integer.parseInt(w.getText());
					otherRolesPointsList[3] += Integer.parseInt(w.getText());
					break;
				case 1:
				case 2:
				case 3:
					otherRolesPointsList[0] += Integer.parseInt(w.getText());
					break;
				case 4:
				case 5:
					otherRolesPointsList[1] += Integer.parseInt(w.getText());
					break;
				case 6:
					otherRolesPointsList[2] += Integer.parseInt(w.getText());
					break;
				case 7:
				case 8:
				case 9:
					otherRolesPointsList[3] += Integer.parseInt(w.getText());
					break;
			}
		}
	}

	ChatMessageBuilder getSummary()
	{
		ChatMessageBuilder message = new ChatMessageBuilder();
		message.append("Wave points:");
		for (int i = 0; i < descriptions.length; i++)
		{
			message.append(descriptions[i]);
			if (i != 5)
			{
				message.append(String.valueOf(amounts[i]));
			}
			message.append("(");
			if (points[i] < 0)
			{
				message.append(Color.RED, String.valueOf(points[i]));
			}
			else if (points[i] > 0)
			{
				message.append(Color.BLUE, String.valueOf(points[i]));
			}
			else
			{
				message.append(String.valueOf(points[i]));
			}
			message.append(")");
		}
		message.append(System.getProperty("line.separator"));
		message.append("All roles points this wave: ");
		for (int i = 0; i < otherPointsDescriptions.length; i++)
		{
			message.append(otherPointsDescriptions[i]);
			message.append(String.valueOf(otherRolesPointsList[i]));
		}
		return message;
	}
}
