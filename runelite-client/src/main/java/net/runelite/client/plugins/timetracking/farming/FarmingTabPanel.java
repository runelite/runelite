/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 *  2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
 *
 *  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 *  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 *  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 *  DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 *  ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 *  (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 *  LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 *  ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 *  (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 *  SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.timetracking.farming;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import net.runelite.api.gameval.ItemID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.timetracking.Tab;
import net.runelite.client.plugins.timetracking.TabContentPanel;
import net.runelite.client.plugins.timetracking.TimeTrackingConfig;
import net.runelite.client.plugins.timetracking.TimeablePanel;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.DragAndDropReorderPane;
import net.runelite.client.util.AsyncBufferedImage;
import net.runelite.client.util.Text;

public class FarmingTabPanel extends TabContentPanel
{
	private final FarmingTracker farmingTracker;
	private final CompostTracker compostTracker;
	private final PaymentTracker paymentTracker;
	private final ItemManager itemManager;
	private final ConfigManager configManager;
	private final TimeTrackingConfig config;
	private final Tab tab;
	private final Set<FarmingPatch> patches;
	private final List<TimeablePanel<FarmingPatch>> patchPanels = new ArrayList<>();
	private final List<DragAndDropReorderPane> groupPanes = new ArrayList<>();
	private final FarmingContractManager farmingContractManager;
	private List<FarmingPatch> patchOrder;

	FarmingTabPanel(
		FarmingTracker farmingTracker,
		CompostTracker compostTracker,
		PaymentTracker paymentTracker,
		ItemManager itemManager,
		ConfigManager configManager,
		TimeTrackingConfig config,
		Tab tab,
		Set<FarmingPatch> patches,
		FarmingContractManager farmingContractManager
	)
	{
		this.farmingTracker = farmingTracker;
		this.compostTracker = compostTracker;
		this.paymentTracker = paymentTracker;
		this.itemManager = itemManager;
		this.configManager = configManager;
		this.config = config;
		this.tab = tab;
		this.patches = patches;
		this.farmingContractManager = farmingContractManager;
		this.patchOrder = loadPatchOrder();

		setLayout(new GridBagLayout());
		setBackground(ColorScheme.DARK_GRAY_COLOR);

		rebuild();
	}

	/**
	 * Re-reads this tab's custom patch order from the now-active RuneScape profile and rebuilds.
	 * The order is loaded once at construction time, which typically happens before the player
	 * has logged in, so this must be called again whenever the active profile changes.
	 */
	public void reloadPatchOrder()
	{
		patchOrder = loadPatchOrder();
		rebuild();
	}

	@VisibleForTesting
	List<FarmingPatch> getPatchOrder()
	{
		return patchOrder;
	}

	@VisibleForTesting
	List<TimeablePanel<FarmingPatch>> getPatchPanels()
	{
		return patchPanels;
	}

	@VisibleForTesting
	List<DragAndDropReorderPane> getGroupPanes()
	{
		return groupPanes;
	}

	private String patchOrderConfigKey()
	{
		return TimeTrackingConfig.PATCH_ORDER + "." + tab.name();
	}

	/**
	 * Loads any previously saved custom order for this tab's patches, applying it within
	 * each patch implementation grouping. Patches with no saved position keep their default
	 * relative order at the end of their group.
	 */
	private List<FarmingPatch> loadPatchOrder()
	{
		String saved = configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, patchOrderConfigKey());
		List<String> savedKeys = Strings.isNullOrEmpty(saved) ? Collections.emptyList() : Text.fromCSV(saved);
		List<PatchImplementation> groups = patches.stream()
			.map(FarmingPatch::getImplementation)
			.distinct()
			.collect(Collectors.toList());

		/* The stable sort's primary key keeps each group's block of patches in place, so a saved
		 * position can only ever reorder a patch within its own group */
		List<FarmingPatch> order = new ArrayList<>(patches);
		order.sort(Comparator.<FarmingPatch>comparingInt(p -> groups.indexOf(p.getImplementation()))
			.thenComparingInt(p ->
			{
				int idx = savedKeys.indexOf(p.configKey());
				return idx < 0 ? Integer.MAX_VALUE : idx;
			}));
		return order;
	}

	private void savePatchOrder()
	{
		if (configManager.getRSProfileKey() == null)
		{
			return;
		}

		String joined = Text.toCSV(patchOrder.stream().map(FarmingPatch::configKey).collect(Collectors.toList()));
		configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, patchOrderConfigKey(), joined);
	}

	/**
	 * Called when a patch row has been dragged to a new position within its group's pane.
	 */
	private void onDrag()
	{
		patchOrder = groupPanes.stream()
			.flatMap(pane -> Arrays.stream(pane.getComponents()))
			.map(component -> (FarmingPatch) ((TimeablePanel<?>) component).getTimeable())
			.collect(Collectors.toList());
		savePatchOrder();
		rebuild();
		update();
	}

	/**
	 * Clears and recreates the patch rows in their current order.
	 * This is called on construction, and again whenever the patch order changes.
	 */
	private void rebuild()
	{
		removeAll();
		patchPanels.clear();
		groupPanes.clear();

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.gridx = 0;
		c.gridy = 0;

		PatchImplementation lastImpl = null;
		DragAndDropReorderPane groupPane = null;

		boolean first = true;
		for (FarmingPatch patch : patchOrder)
		{
			/* Show labels to subdivide tabs into sections */
			if (patch.getImplementation() != lastImpl)
			{
				lastImpl = patch.getImplementation();

				if (!Strings.isNullOrEmpty(lastImpl.getName()))
				{
					JLabel groupLabel = new JLabel(lastImpl.getName());
					groupLabel.setBorder(new EmptyBorder(first ? 4 : 15, 0, 0, 0));
					groupLabel.setFont(FontManager.getRunescapeSmallFont());
					first = false;

					add(groupLabel, c);
					c.gridy++;
				}

				/* Each section is its own reorder pane, so rows can only be dragged within their group */
				groupPane = new DragAndDropReorderPane();
				groupPane.addDragListener(component -> onDrag());
				groupPanes.add(groupPane);
				add(groupPane, c);
				c.gridy++;
			}

			String title = patch.getRegion().getName() + (Strings.isNullOrEmpty(patch.getName()) ? "" : " (" + patch.getName() + ")");
			TimeablePanel<FarmingPatch> p = new TimeablePanel<>(patch, title, 1);

			// Set toggle state of notification menu on icon click;
			JToggleButton toggleNotify = p.getNotifyButton();
			String configKey = patch.notifyConfigKey();

			toggleNotify.addActionListener(e ->
			{
				if (configManager.getRSProfileKey() != null)
				{
					configManager.setRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey, toggleNotify.isSelected());
				}
			});

			patchPanels.add(p);
			groupPane.add(p);

			/* This is a weird hack to remove the top border on the first tracker of every tab */
			if (first)
			{
				first = false;
				p.setBorder(null);
			}
		}

		revalidate();
		repaint();
	}

	@Override
	public int getUpdateInterval()
	{
		return 50; // 10 seconds
	}

	@Override
	public void update()
	{
		long unixNow = Instant.now().getEpochSecond();

		for (TimeablePanel<FarmingPatch> panel : patchPanels)
		{
			FarmingPatch patch = panel.getTimeable();
			PatchPrediction prediction = farmingTracker.predictPatch(patch);

			final boolean protected_ = paymentTracker.getProtectedState(patch);
			final CompostState compostState = compostTracker.getCompostState(patch);
			final AsyncBufferedImage img = getPatchImage(compostState, protected_);
			final String tooltip = getPatchTooltip(compostState, protected_);

			if (img != null)
			{
				img.onLoaded(() -> panel.setOverlayIconImage(img));
			}
			else
			{
				panel.setOverlayIconImage(null);
			}

			if (prediction == null)
			{
				itemManager.getImage(Produce.WEEDS.getItemID()).addTo(panel.getIcon());
				panel.getIcon().setToolTipText("Unknown state" + tooltip);
				panel.getProgress().setMaximumValue(0);
				panel.getProgress().setValue(0);
				panel.getProgress().setVisible(false);
				panel.getEstimate().setText("Unknown");
				panel.getProgress().setBackground(null);
			}
			else
			{
				if (prediction.getProduce().getItemID() < 0)
				{
					panel.getIcon().setIcon(null);
					panel.getIcon().setToolTipText("Unknown state" + tooltip);
				}
				else
				{
					itemManager.getImage(prediction.getProduce().getItemID()).addTo(panel.getIcon());
					panel.getIcon().setToolTipText(prediction.getProduce().getName() + tooltip);
				}

				switch (prediction.getCropState())
				{
					case HARVESTABLE:
						panel.getEstimate().setText("Done");
						break;
					case GROWING:
						if (prediction.getDoneEstimate() < unixNow)
						{
							panel.getEstimate().setText("Done");
						}
						else
						{
							panel.getEstimate().setText("Done " + getFormattedEstimate(prediction.getDoneEstimate() - unixNow, config.timeFormatMode()));
						}
						break;
					case DISEASED:
						panel.getEstimate().setText("Diseased");
						break;
					case DEAD:
						panel.getEstimate().setText("Dead");
						break;
					case EMPTY:
						panel.getEstimate().setText("Empty");
						break;
					case FILLING:
						panel.getEstimate().setText("Filling");
						break;
				}

				/* Hide any fully grown weeds' progress bar. */
				if (prediction.getProduce() != Produce.WEEDS || prediction.getStage() < prediction.getStages() - 1)
				{
					panel.getProgress().setVisible(true);
					panel.getProgress().setForeground(prediction.getCropState().getColor().darker());
					panel.getProgress().setMaximumValue(prediction.getStages() - 1);
					panel.getProgress().setValue(prediction.getStage());
				}
				else
				{
					panel.getProgress().setVisible(false);
				}
			}

			JLabel farmingContractIcon = panel.getFarmingContractIcon();
			if (farmingContractManager.shouldHighlightFarmingTabPanel(patch))
			{
				itemManager.getImage(ItemID.SEEDBOX).addTo(farmingContractIcon);
				farmingContractIcon.setToolTipText(farmingContractManager.getContract().getName());
			}
			else
			{
				farmingContractIcon.setIcon(null);
				farmingContractIcon.setToolTipText("");
			}

			String configKey = patch.notifyConfigKey();
			JToggleButton toggleNotify = panel.getNotifyButton();
			boolean notifyEnabled = Boolean.TRUE
				.equals(configManager.getRSProfileConfiguration(TimeTrackingConfig.CONFIG_GROUP, configKey, Boolean.class));

			toggleNotify.setSelected(notifyEnabled);
		}
	}

	private AsyncBufferedImage getPatchImage(CompostState compostState, boolean protected_)
	{
		return protected_ ? itemManager.getImage(ItemID.BASKET_APPLE_5) :
			(compostState != null ? itemManager.getImage(compostState.getItemId()) : null);
	}

	private String getPatchTooltip(CompostState compostState, boolean protected_)
	{
		StringBuilder stringBuilder = new StringBuilder();
		if (protected_)
		{
			stringBuilder.append(" protected");
			if (compostState != null)
			{
				stringBuilder.append(" and ").append(compostState.name().toLowerCase()).append("ed");
			}
		}
		else if (compostState != null)
		{
			stringBuilder.append(" with ").append(compostState.name().toLowerCase());
		}
		return stringBuilder.toString();
	}
}
