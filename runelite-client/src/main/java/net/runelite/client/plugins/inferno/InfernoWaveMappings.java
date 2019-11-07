/*
 * Copyright (c) 2019, Kyleeld <https://github.com/kyleeld>
 * Copyright (c) 2019, RuneLitePlus <https://runelitepl.us>
 *
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
package net.runelite.client.plugins.inferno;

import com.google.common.collect.ImmutableMap;
import java.awt.Color;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.plugins.inferno.displaymodes.InfernoNamingDisplayMode;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;

class InfernoWaveMappings
{
	@Getter(AccessLevel.PACKAGE)
	private static final Map<Integer, int[]> waveMapping;
	@Getter(AccessLevel.PACKAGE)
	private static final Map<Integer, String> npcNameMappingComplex;
	@Getter(AccessLevel.PACKAGE)
	private static final Map<Integer, String> npcNameMappingSimple;

	static
	{
		ImmutableMap.Builder<Integer, int[]> waveMapBuilder = new ImmutableMap.Builder<>();

		waveMapBuilder.put(1, new int[]{32, 32, 32, 85});
		waveMapBuilder.put(2, new int[]{32, 32, 32, 85, 85});
		waveMapBuilder.put(3, new int[]{32, 32, 32, 32, 32, 32});
		waveMapBuilder.put(4, new int[]{32, 32, 32, 165});
		waveMapBuilder.put(5, new int[]{32, 32, 32, 85, 165});
		waveMapBuilder.put(6, new int[]{32, 32, 32, 85, 85, 165});
		waveMapBuilder.put(7, new int[]{32, 32, 32, 165, 165});
		waveMapBuilder.put(8, new int[]{32, 32, 32, 32, 32, 32});
		waveMapBuilder.put(9, new int[]{32, 32, 32, 240});
		waveMapBuilder.put(10, new int[]{32, 32, 32, 85, 240});
		waveMapBuilder.put(11, new int[]{32, 32, 32, 85, 85, 240});
		waveMapBuilder.put(12, new int[]{32, 32, 32, 165, 240});
		waveMapBuilder.put(13, new int[]{32, 32, 32, 85, 165, 240});
		waveMapBuilder.put(14, new int[]{32, 32, 32, 85, 85, 165, 240});
		waveMapBuilder.put(15, new int[]{32, 32, 32, 165, 165, 240});
		waveMapBuilder.put(16, new int[]{32, 32, 32, 240, 240});
		waveMapBuilder.put(17, new int[]{32, 32, 32, 32, 32, 32});
		waveMapBuilder.put(18, new int[]{32, 32, 32, 370});
		waveMapBuilder.put(19, new int[]{32, 32, 32, 85, 370});
		waveMapBuilder.put(20, new int[]{32, 32, 32, 85, 85, 370});
		waveMapBuilder.put(21, new int[]{32, 32, 32, 165, 370});
		waveMapBuilder.put(22, new int[]{32, 32, 32, 85, 165, 370});
		waveMapBuilder.put(23, new int[]{32, 32, 32, 85, 85, 165, 370});
		waveMapBuilder.put(24, new int[]{32, 32, 32, 165, 165, 370});
		waveMapBuilder.put(25, new int[]{32, 32, 32, 240, 370});
		waveMapBuilder.put(26, new int[]{32, 32, 32, 85, 240, 370});
		waveMapBuilder.put(27, new int[]{32, 32, 32, 85, 85, 240, 370});
		waveMapBuilder.put(28, new int[]{32, 32, 32, 165, 240, 370});
		waveMapBuilder.put(29, new int[]{32, 32, 32, 85, 165, 240, 370});
		waveMapBuilder.put(30, new int[]{32, 32, 32, 85, 85, 165, 240, 370});
		waveMapBuilder.put(31, new int[]{32, 32, 32, 165, 165, 240, 370});
		waveMapBuilder.put(32, new int[]{32, 32, 32, 240, 240, 370});
		waveMapBuilder.put(33, new int[]{32, 32, 32, 370, 370});
		waveMapBuilder.put(34, new int[]{32, 32, 32, 32, 32, 32});
		waveMapBuilder.put(35, new int[]{32, 32, 32, 490});
		waveMapBuilder.put(36, new int[]{32, 32, 32, 85, 490});
		waveMapBuilder.put(37, new int[]{32, 32, 32, 85, 85, 490});
		waveMapBuilder.put(38, new int[]{32, 32, 32, 165, 490});
		waveMapBuilder.put(39, new int[]{32, 32, 32, 85, 165, 490});
		waveMapBuilder.put(40, new int[]{32, 32, 32, 85, 85, 165, 490});
		waveMapBuilder.put(41, new int[]{32, 32, 32, 165, 165, 490});
		waveMapBuilder.put(42, new int[]{32, 32, 32, 240, 490});
		waveMapBuilder.put(43, new int[]{32, 32, 32, 85, 240, 490});
		waveMapBuilder.put(44, new int[]{32, 32, 32, 85, 85, 240, 490});
		waveMapBuilder.put(45, new int[]{32, 32, 32, 165, 240, 490});
		waveMapBuilder.put(46, new int[]{32, 32, 32, 85, 165, 240, 490});
		waveMapBuilder.put(47, new int[]{32, 32, 32, 85, 85, 165, 240, 490});
		waveMapBuilder.put(48, new int[]{32, 32, 32, 165, 165, 240, 490});
		waveMapBuilder.put(49, new int[]{32, 32, 32, 240, 240, 490});
		waveMapBuilder.put(50, new int[]{32, 32, 32, 370, 490});
		waveMapBuilder.put(51, new int[]{32, 32, 32, 85, 370, 490});
		waveMapBuilder.put(52, new int[]{32, 32, 32, 85, 85, 370, 490});
		waveMapBuilder.put(53, new int[]{32, 32, 32, 165, 370, 490});
		waveMapBuilder.put(54, new int[]{32, 32, 32, 85, 165, 370, 490});
		waveMapBuilder.put(55, new int[]{32, 32, 32, 85, 85, 165, 370, 490});
		waveMapBuilder.put(56, new int[]{32, 32, 32, 165, 165, 370, 490});
		waveMapBuilder.put(57, new int[]{32, 32, 32, 240, 370, 490});
		waveMapBuilder.put(58, new int[]{32, 32, 32, 85, 240, 370, 490});
		waveMapBuilder.put(59, new int[]{32, 32, 32, 85, 85, 240, 370, 490});
		waveMapBuilder.put(60, new int[]{32, 32, 32, 165, 240, 370, 490});
		waveMapBuilder.put(61, new int[]{32, 32, 32, 85, 165, 240, 370, 490});
		waveMapBuilder.put(62, new int[]{32, 32, 32, 85, 85, 165, 240, 370, 490});
		waveMapBuilder.put(63, new int[]{32, 32, 32, 165, 165, 240, 370, 490});
		waveMapBuilder.put(64, new int[]{32, 32, 32, 240, 240, 370, 490});
		waveMapBuilder.put(65, new int[]{32, 32, 32, 370, 370, 490});
		waveMapBuilder.put(66, new int[]{32, 32, 32, 490, 490});
		waveMapBuilder.put(67, new int[]{900});
		waveMapBuilder.put(68, new int[]{900, 900, 900});
		waveMapBuilder.put(69, new int[]{1400});

		waveMapping = waveMapBuilder.build();

		ImmutableMap.Builder<Integer, String> nameMapBuilderSimple = new ImmutableMap.Builder<>();

		nameMapBuilderSimple.put(32, "Nibbler");
		nameMapBuilderSimple.put(85, "Bat");
		nameMapBuilderSimple.put(165, "Blob");
		nameMapBuilderSimple.put(240, "Meleer");
		nameMapBuilderSimple.put(370, "Ranger");
		nameMapBuilderSimple.put(490, "Mage");
		nameMapBuilderSimple.put(900, "Jad");
		nameMapBuilderSimple.put(1400, "Zuk");

		npcNameMappingSimple = nameMapBuilderSimple.build();

		ImmutableMap.Builder<Integer, String> nameMapBuilderComplex = new ImmutableMap.Builder<>();

		nameMapBuilderComplex.put(32, "Jal-Nib");
		nameMapBuilderComplex.put(85, "Jal-MejRah");
		nameMapBuilderComplex.put(165, "Jal-Ak");
		nameMapBuilderComplex.put(240, "Jal-ImKot");
		nameMapBuilderComplex.put(370, "Jal-Xil");
		nameMapBuilderComplex.put(490, "Jal-Zek");
		nameMapBuilderComplex.put(900, "JalTok-Jad");
		nameMapBuilderComplex.put(1400, "TzKal-Zuk");

		npcNameMappingComplex = nameMapBuilderComplex.build();
	}

	static void addWaveComponent(InfernoPlugin plugin, PanelComponent panelComponent, String header, int wave, Color titleColor, Color color)
	{
		int[] monsters = waveMapping.get(wave);

		if (monsters == null)
		{
			return;
		}

		panelComponent.getChildren()
			.add(TitleComponent.builder()
				.text(header)
				.color(titleColor)
				.build()
			);


		for (int i = 0; i < monsters.length; i++)
		{
			int monsterType = monsters[i];
			int count = 1;

			for (; i < monsters.length - 1 && monsters[i + 1] == monsterType; i++)
			{
				count++;
			}

			TitleComponent.TitleComponentBuilder builder = TitleComponent.builder();

			String npcNameText = "";

			if (plugin.getNpcNaming() == InfernoNamingDisplayMode.SIMPLE)
			{
				npcNameText += npcNameMappingSimple.get(monsterType);
			}
			else
			{
				npcNameText += npcNameMappingComplex.get(monsterType);
			}

			if (plugin.isNpcLevels())
			{
				npcNameText += " (" + monsterType + ")";
			}

			builder.text(count + "x " + npcNameText);
			builder.color(color);

			panelComponent.getChildren().add(builder.build());
		}
	}
}