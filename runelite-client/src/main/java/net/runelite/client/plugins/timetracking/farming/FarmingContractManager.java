/*
 * Copyright (c) 2019, Koekkruimels <https://github.com/koekkruimels>
 * Copyright (c) 2020, melky <https://github.com/melkypie>
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
package net.runelite.client.plugins.timetracking.farming;

import com.google.inject.Singleton;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Client;
import net.runelite.api.NullNpcID;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.SummaryState;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeTrackingPlugin;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;
import net.runelite.client.util.Text;

@Singleton
public class FarmingContractManager
{
	private static final int GUILDMASTER_JANE_NPC_ID = NullNpcID.NULL_8628;
	private static final int FARMING_GUILD_REGION_ID = 4922;
	private static final Pattern CONTRACT_ASSIGN_PATTERN = Pattern.compile("(?:We need you to grow|Please could you grow) (?:some|a|an) ([a-zA-Z ]+)(?: for us\\?|\\.)");
	private static final String CONTRACT_REWARDED = "You'll be wanting a reward then. Here you go.";
	private static final String CONFIG_KEY_CONTRACT = "contract";

	@Getter
	private SummaryState summary = SummaryState.UNKNOWN;

	@Getter
	private CropState contractCropState;

	@Inject
	private Client client;

	@Inject
	private ItemManager itemManager;

	@Inject
	private TimeTrackingConfig config;

	@Inject
	private TimeTrackingPlugin plugin;

	@Inject
	private FarmingWorld farmingWorld;

	@Inject
	private FarmingTracker farmingTracker;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private ConfigManager configManager;

	@Getter
	private Produce contract = null;

	@Getter
	@Setter
	private FarmingContractInfoBox infoBox;

	@Getter
	private long completionTime;

	public void setContract(@Nullable Produce contract)
	{
		this.contract = contract;
		setStoredContract(contract);
		handleContractState();
	}

	public boolean hasContract()
	{
		return contract != null;
	}

	@Nullable
	public Tab getContractTab()
	{
		return hasContract() ? contract.getPatchImplementation().getTab() : null;
	}

	@Nullable
	public String getContractName()
	{
		return hasContract() ? contract.getContractName() : null;
	}

	public boolean shouldHighlightFarmingTabPanel(@Nonnull FarmingPatch patch)
	{
		PatchPrediction patchPrediction = farmingTracker.predictPatch(patch);
		if (contract != null &&
			patch.getRegion().getRegionID() == FARMING_GUILD_REGION_ID &&
			contract.getPatchImplementation() == patch.getImplementation() &&
			patchPrediction != null &&
			(summary == SummaryState.EMPTY &&
				(patchPrediction.getProduce() == null || patchPrediction.getProduce() == Produce.WEEDS)
				|| patchPrediction.getProduce().equals(contract)))
		{
			return true;
		}
		return false;
	}

	public void loadContractFromConfig()
	{
		contract = getStoredContract();
		handleContractState();
	}

	public boolean updateData(WorldPoint loc)
	{
		SummaryState oldSummary = summary;

		handleContractState();
		if (loc.getRegionID() == FARMING_GUILD_REGION_ID)
		{
			handleGuildmasterJaneWidgetDialog();
			handleInfoBox();
		}
		else
		{
			if (infoBox != null)
			{
				infoBoxManager.removeInfoBox(infoBox);
				infoBox = null;
			}
		}
		return oldSummary != summary;
	}

	private void handleInfoBox()
	{
		if (contract != (infoBox == null ? null : infoBox.getContract()))
		{
			if (infoBox != null)
			{
				infoBoxManager.removeInfoBox(infoBox);
				infoBox = null;
			}
			if (contract != null)
			{
				infoBox = new FarmingContractInfoBox(itemManager.getImage(contract.getItemID()), plugin, contract, config, this);
				infoBoxManager.addInfoBox(infoBox);
			}
		}
	}

	private void handleGuildmasterJaneWidgetDialog()
	{
		Widget npcDialog = client.getWidget(ComponentID.DIALOG_NPC_HEAD_MODEL);

		if (npcDialog == null || npcDialog.getModelId() != GUILDMASTER_JANE_NPC_ID)
		{
			return;
		}

		String dialogText = Text.removeTags(client.getWidget(ComponentID.DIALOG_NPC_TEXT).getText());

		if (dialogText.equals(CONTRACT_REWARDED))
		{
			setContract(null);
		}

		Matcher matcher = CONTRACT_ASSIGN_PATTERN.matcher(dialogText);

		if (!matcher.find())
		{
			return;
		}

		String name = matcher.group(1);

		Produce farmingContract = Produce.getByContractName(name);

		if (farmingContract == null)
		{
			return;
		}

		Produce currentFarmingContract = contract;

		if (farmingContract == currentFarmingContract)
		{
			return;
		}

		setContract(farmingContract);
	}

	private void handleContractState()
	{
		if (contract == null)
		{
			summary = SummaryState.UNKNOWN;
			return;
		}

		PatchImplementation patchImplementation = contract.getPatchImplementation();

		boolean hasEmptyPatch = false;
		boolean hasDiseasedPatch = false;
		boolean hasDeadPatch = false;
		completionTime = Long.MAX_VALUE;
		contractCropState = null;
		for (FarmingPatch patch : farmingWorld.getFarmingGuildRegion().getPatches())
		{
			if (patch.getImplementation() != patchImplementation)
			{
				continue;
			}

			PatchPrediction prediction = farmingTracker.predictPatch(patch);
			if (prediction == null)
			{
				continue;
			}

			Produce produce = prediction.getProduce();
			CropState state = prediction.getCropState();
			if (completionTime == Long.MAX_VALUE)
			{
				if (produce == null || produce == Produce.WEEDS)
				{
					// Don't report the empty state if there's a dead or diseased one
					if (!(hasDiseasedPatch || hasDeadPatch))
					{
						summary = SummaryState.EMPTY;
					}
					hasEmptyPatch = true;
					continue;
				}

				if ((contract.getPatchImplementation().isHealthCheckRequired() && state == CropState.HARVESTABLE)
					&& !(hasEmptyPatch || hasDiseasedPatch || hasDeadPatch))
				{
					summary = SummaryState.OCCUPIED;
					// Don't let this run into the "Completed" section!
					continue;
				}
			}

			// Herbs always turn into ANYHERB when dead, so let them through.
			if (produce != contract && produce != Produce.ANYHERB)
			{
				if (!(hasEmptyPatch || hasDiseasedPatch || hasDeadPatch) && completionTime == Long.MAX_VALUE)
				{
					summary = SummaryState.OCCUPIED;
				}
			}
			else
			{
				// Ignore if crop is dead but there's another one in progress (either normal or diseased)
				if (state == CropState.DEAD && (hasDiseasedPatch || completionTime != Long.MAX_VALUE))
				{
					continue;
				}

				// Ignore if crop is diseased but there's another patch in progress
				if (state == CropState.DISEASED && completionTime != Long.MAX_VALUE)
				{
					continue;
				}

				contractCropState = state;
				if (contractCropState == CropState.DISEASED)
				{
					hasDiseasedPatch = true;
					summary = SummaryState.IN_PROGRESS;
				}
				else if (contractCropState == CropState.DEAD)
				{
					hasDeadPatch = true;
					summary = SummaryState.IN_PROGRESS;
				}
				else
				{
					long estimatedTime = Math.min(prediction.getDoneEstimate(), completionTime);
					if (estimatedTime <= Instant.now().getEpochSecond())
					{
						summary = SummaryState.COMPLETED;
						completionTime = 0;
						break;
					}
					else
					{
						summary = SummaryState.IN_PROGRESS;
						completionTime = estimatedTime;
					}
				}
			}
		}
	}


	@Nullable
	private Produce getStoredContract()
	{
		try
		{
			return Produce.getByItemID(Integer.parseInt(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, CONFIG_KEY_CONTRACT)));
		}
		catch (NumberFormatException ignored)
		{
			return null;
		}
	}

	private void setStoredContract(@Nullable Produce contract)
	{
		if (contract != null)
		{
			configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, CONFIG_KEY_CONTRACT, String.valueOf(contract.getItemID()));
		}
		else
		{
			configManager.unsetRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, CONFIG_KEY_CONTRACT);
		}
	}
}
