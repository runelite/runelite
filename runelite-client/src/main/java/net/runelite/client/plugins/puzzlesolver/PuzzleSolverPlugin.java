/*
 * Copyright (c) 2018, Lotto <https://github.com/devLotto>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.puzzlesolver;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Provides;
import java.util.Arrays;
import javax.inject.Inject;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
	name = "Puzzle Solver"
)
public class PuzzleSolverPlugin extends Plugin
{
	@Inject
	private PuzzleSolverOverlay puzzleSolverOverlay;

	@Inject
	private LightBoxSolverOverlay lightBoxSolverOverlay;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private Client client;

	@Provides
	PuzzleSolverConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(PuzzleSolverConfig.class);
	}

	@Getter
	private int count = 0;

	@Getter
	private int[] solution = new int[LightBox.COMBINATIONS_POWER];

	@Getter
	private boolean solving = false;

	private boolean[][] lightBoxState = new boolean[LightBox.WIDTH][LightBox.HEIGHT];
	private boolean[][][] lightBoxChanges = new boolean[LightBox.COMBINATIONS_POWER][LightBox.WIDTH][LightBox.HEIGHT];

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (client.getWidget(WidgetInfo.LIGHT_BOX) != null)
		{
			boolean changed = false;
			boolean[][] tempLightBox = new boolean[LightBox.WIDTH][LightBox.HEIGHT];

			int index = 0;
			for (Widget light : client.getWidget(WidgetInfo.LIGHT_BOX).getDynamicChildren())
			{
				tempLightBox[index / LightBox.WIDTH][index % LightBox.HEIGHT] = light.getItemId() == LightBox.LIGHT_BULB_ON;
				index++;
			}

			for (int h = 0; h < LightBox.WIDTH; h++)
			{
				for (int k = 0; k < LightBox.HEIGHT; k++)
				{
					if (tempLightBox[h][k] != lightBoxState[h][k])
					{
						if (!solving)
						{
							lightBoxChanges[count][h][k] = true;
						}
						changed = true;
					}
				}
			}

			if (changed && !solving)
			{
				lightBoxState = deepCopy(tempLightBox);

				if (count < 7)
				{
					solution = solve();
					if (solution == null)
					{
						count++;
					}
					else
					{
						solving = true;
						count = 0;
					}
				}
				else
				{
					solving = true;
					solution = solve();
					count = 0;
				}
			}
			else if (changed)
			{
				lightBoxState = deepCopy(tempLightBox);
				count++;
			}
		}
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetInfo.LIGHT_BOX.getGroupId())
		{
			int index = 0;
			for (Widget light : client.getWidget(WidgetInfo.LIGHT_BOX).getDynamicChildren())
			{
				lightBoxState[index / LightBox.WIDTH][index % LightBox.HEIGHT] = light.getItemId() == LightBox.LIGHT_BULB_ON;
				index++;
			}
			count = 0;
			solving = false;
			lightBoxChanges = new boolean[LightBox.COMBINATIONS_POWER][LightBox.WIDTH][LightBox.HEIGHT];
		}
	}

	private int[] solve()
	{
		int[] current = new int[] {0, -1, -1, -1, -1, -1, -1, -1};
		boolean[][] tempLightBox;
		int currentCount = 0;

		while (current[7] != 7)
		{
			boolean optimal = true;

			for (int i = 1; i < 7; i++)
			{
				if (current[i + 1] >= current[i] && current[i + 1] != -1)
				{
					optimal = false;
					break;
				}
			}

			if (optimal)
			{
				tempLightBox = deepCopy(lightBoxState);

				while (current[currentCount] != -1)
				{
					tempLightBox = xor(current[currentCount], tempLightBox).clone();
					currentCount++;
					if (currentCount == count + 1)
					{
						return null;
					}
				}

				currentCount = 0;
				if (Arrays.deepEquals(tempLightBox, LightBox.SOLVED_STATE))
				{
					break;
				}
			}

			current[0]++;

			if (current[0] == 8)
			{
				current[0] = 0;
				current[1]++;
			}

			for (int i = 1; i < 7; i++)
			{
				if (current[i] == 7)
				{
					current[i] = 0;
					if (current[i + 1] != 7)
					{
						current[i + 1]++;
					}
					else
					{
						return null;
					}
				}
			}
		}
		return current;
	}

	private boolean[][] xor(int num, boolean[][] box)
	{
		boolean[][] tempLightBox = box.clone();
		for (int i = 0; i < LightBox.WIDTH; i++)
		{
			for (int j = 0; j < LightBox.HEIGHT; j++)
			{
				if (lightBoxChanges[num][i][j])
				{
					tempLightBox[i][j] = !tempLightBox[i][j];
				}
			}
		}
		return tempLightBox;
	}

	private boolean[][] deepCopy(boolean[][] original)
	{
		if (original == null)
		{
			return null;
		}

		final boolean[][] result = new boolean[original.length][];
		for (int i = 0; i < original.length; i++)
		{
			result[i] = Arrays.copyOf(original[i], original[i].length);
		}
		return result;
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(puzzleSolverOverlay);
		overlayManager.add(lightBoxSolverOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(puzzleSolverOverlay);
		overlayManager.remove(lightBoxSolverOverlay);
	}
}
