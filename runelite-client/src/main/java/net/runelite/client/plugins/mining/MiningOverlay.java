package net.runelite.client.plugins.mining;

import com.google.common.collect.ImmutableSet;
import static net.runelite.api.AnimationID.MINING_3A_PICKAXE;
import static net.runelite.api.AnimationID.MINING_ADAMANT_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BLACK_PICKAXE;
import static net.runelite.api.AnimationID.MINING_BRONZE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_DRAGON_PICKAXE_ORN;
import static net.runelite.api.AnimationID.MINING_INFERNAL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_IRON_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MITHRIL_PICKAXE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_ADAMANT;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BLACK;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_BRONZE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_DRAGON_ORN;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_INFERNAL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_IRON;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_MITHRIL;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_RUNE;
import static net.runelite.api.AnimationID.MINING_MOTHERLODE_STEEL;
import static net.runelite.api.AnimationID.MINING_RUNE_PICKAXE;
import static net.runelite.api.AnimationID.MINING_STEEL_PICKAXE;
import net.runelite.api.Client;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.LineComponent;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.TitleComponent;
import javax.inject.Inject;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Set;

/**
 * Displays information about the players current mining state & rocks mined
 */
public class MiningOverlay extends Overlay
{

	private static final Set<Integer> MINING_ANIMATION_IDS = ImmutableSet.of(
			MINING_3A_PICKAXE, MINING_ADAMANT_PICKAXE, MINING_BLACK_PICKAXE,
			MINING_BRONZE_PICKAXE, MINING_DRAGON_PICKAXE, MINING_DRAGON_PICKAXE_ORN,
			MINING_INFERNAL_PICKAXE, MINING_IRON_PICKAXE, MINING_MITHRIL_PICKAXE,
			MINING_RUNE_PICKAXE, MINING_STEEL_PICKAXE, MINING_MOTHERLODE_BRONZE,
			MINING_MOTHERLODE_IRON, MINING_MOTHERLODE_STEEL, MINING_MOTHERLODE_BLACK,
			MINING_MOTHERLODE_MITHRIL, MINING_MOTHERLODE_ADAMANT, MINING_MOTHERLODE_RUNE,
			MINING_MOTHERLODE_DRAGON, MINING_MOTHERLODE_DRAGON_ORN, MINING_MOTHERLODE_INFERNAL
	);

	private final MiningConfig config;
	private final Client client;
	private final MiningPlugin plugin;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	MiningOverlay(Client client, MiningPlugin plugin, MiningConfig config, SkillIconManager iconManager)
	{
		setPosition(OverlayPosition.TOP_LEFT);
		this.client = client;
		this.config = config;
		this.plugin = plugin;
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (config.disableInMLM() && plugin.checkInMlm())
		{ // If player is in the motherloade mine & they have it disabled in the config, then exit out here
			return null;
		}

		panelComponent.getChildren().clear();

		if (config.showMiningState())
		{ // Check if player wishes to see their current mining state (Mining/Not Mining)
			if (MINING_ANIMATION_IDS.contains(client.getLocalPlayer().getAnimation()))
			{ // Player is actively mining
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("Mining")
					.color(Color.GREEN)
					.build());
			}
			else
			{ // Player is not mining
				panelComponent.getChildren().add(TitleComponent.builder()
					.text("NOT mining")
					.color(Color.RED)
					.build());
			}
		}

		MiningSession session = plugin.getSession();
		if (session.getLastMined() != null)
		{ // Checks if the player has a session yet
			Duration statTimeout = Duration.ofMinutes(config.statTimeout());
			Duration sinceCut = Duration.between(session.getLastMined(), Instant.now());
			if (sinceCut.compareTo(statTimeout) >= 0)
			{ // Checks if player has not mined within the config controlled timeout
				return null;
			}
		}
		else
		{
			return null;
		}

		if (!config.showMiningStats())
		{ // Exit here if player does not want to see mining stats
			return null;
		}

		for (MiningRockType rock : MiningRockType.values())
		{ // Goes through every rock the player could have mined
			if (session.showOreRespawns(rock))
			{ // Check if they have mined this rock within the current session. Each rock has it's own 'session timeout' - which is configured by the user
				int index = rock.getIndex();
				panelComponent.getChildren().add(LineComponent.builder()
					.left(rock.getName() + " mined:")
					.right(Integer.toString(session.getTotalMined()[index]))
					.build()); // Show the total amount mined (not just during this session)
				panelComponent.getChildren().add(LineComponent.builder()
					.left(rock.getName() + "/hr:")
					.right(session.getRecentMined()[index] > 2 ? Integer.toString(session.getPerHour()[index]) : "")
					.build()); // Show the estimated amount mined per hour, based on the amount mined this session
			}
		}
		return panelComponent.render(graphics);
	}

}
