package net.runelite.client.plugins.vorkath;

import net.runelite.api.events.*;
import net.runelite.client.eventbus.Subscribe;
import com.google.inject.Provides;
import javax.inject.Inject;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.game.SpriteManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;
import org.apache.commons.lang3.ArrayUtils;

@PluginDescriptor(
	name = "Vorkath",
	description = "Vorkath Helper",
	tags = {"Vorkath", "Helper"},
		type = "PVM"
)
public class VorkathPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;

	@Inject
	private VorkathConfig config;

	@Inject
	private VorkathOverlay VorkathOverlay;

	@Inject
	private VorkathIndicatorOverlay VorkathIndicatorOverlay;

	@Inject
	private Client client;

	@Inject
	private SpriteManager spriteManager;

	@Provides
	VorkathConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(VorkathConfig.class);
	}

	NPC Vorkath;
	int hits;
	int ticks;
	Boolean ice = false;
	LocalPoint fireball;
	int fireballticks = 0;
	int lastattack;
	int venomticks;

	int[] VorkathIDs = {393, 395, 1470, 1471, 1477, 1479};

	@Override
	protected void startUp() throws Exception {
		overlayManager.add(VorkathOverlay);
		overlayManager.add(VorkathIndicatorOverlay);
	}

	@Override
	protected void shutDown() throws Exception {
		overlayManager.remove(VorkathOverlay);
		overlayManager.remove(VorkathIndicatorOverlay);
		Vorkath = null;
		hits = 0;
		fireball = null;
		fireballticks = 0;
		ice = false;
		lastattack = 0;
	}

	@Subscribe
	public void onGameTick(GameTick event) {
		if (!config.EnableVorkath()) {
			return;
		}
		ticks++;
		if (ticks - fireballticks > 5) {
			fireballticks = 0;
			fireball = null;
		}

		if (venomticks + 30 <= ticks) {
			venomticks = 0;
		}

		boolean foundVorkath = false;
		for (NPC monster : client.getNpcs())
		{
			if (monster == null || monster.getName() == null || monster.getCombatLevel() == 0)
			{
				continue;
			}
			if (monster.getName().equalsIgnoreCase("Vorkath")) {
				foundVorkath = true;
				Vorkath = monster;
				break;
			}
		}
		if (!foundVorkath) {
			Vorkath = null;
			hits = 0;
			fireball = null;
			fireballticks = 0;
			ice = false;
			lastattack = 0;
		}
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event) {
		if (Vorkath != null) {
			Projectile ball = event.getProjectile();
			if (ArrayUtils.contains(VorkathIDs, ball.getId())) {
				if (ticks - lastattack > 4) {
					if (ball.getId() == 395) {
						ice = true;
					}
					hits++;
					lastattack = ticks;
					if (hits == 7) {
						hits = 0;
					}
				}
			}
		}
	}

	@Subscribe
	public void onAnimationChanged(AnimationChanged event) {
		Actor vorki = event.getActor();
		Actor local = client.getLocalPlayer();
		if (vorki instanceof NPC) {
			if (vorki.equals(Vorkath)) {
				if (vorki.getAnimation() != -1 && vorki.getAnimation() != 7948 && vorki.getAnimation() != 7952) {
					if (ice) {
						ice = false;
					} else {
						hits++;
						if (hits == 7) {
							venomticks = ticks;
							hits = 0;
						}
						if (vorki.getAnimation() == 7960) {
							fireball = local.getLocalLocation();
							fireballticks = ticks;
						}
					}
				}

			}
		}
	}
}
