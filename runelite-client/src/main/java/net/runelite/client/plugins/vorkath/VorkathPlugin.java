package net.runelite.client.plugins.vorkath;

import javax.inject.Inject;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.*;
import net.runelite.api.events.AnimationChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
		name = "Vorkath"
)
public class VorkathPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private QueryRunner queryRunner;

	@Inject
	private VorkathOverlay overlay;

	private VorkathAttack attack;

	int vorkathAttackCounter = 6;
	String vorkathNextSpecial = "Unknown";
	boolean vorkathIsAlive = false;

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onAimationChanged(AnimationChanged event)
	{
		if (client.getGameState() != GameState.LOGGED_IN || !client.isInInstancedRegion())
		{
			vorkathIsAlive = false;
			vorkathAttackCounter = 6;
			vorkathNextSpecial = "Unknown";
			return;
		}

		Actor actor = event.getActor();

		if (actor != null && actor.getName().equals("Vorkath"))
		{
			vorkathIsAlive = true;

			if ((actor.getAnimation() == VorkathAttack.REGULAR.getAnimation() || actor.getAnimation() == VorkathAttack.MELEE.getAnimation() || actor.getAnimation() == VorkathAttack.TOSS.getAnimation()) && vorkathAttackCounter > 0)
			{
				attack = VorkathAttack.REGULAR;
				vorkathAttackCounter--;
			}
			else if (actor.getAnimation() == VorkathAttack.TOSS.getAnimation() && vorkathAttackCounter == 0)
			{
				attack = VorkathAttack.TOSS;
				vorkathAttackCounter = 6;
				vorkathNextSpecial = "Poison";
			}
			else if (actor.getAnimation() == VorkathAttack.POISON.getAnimation())
			{
				attack = VorkathAttack.POISON;
				vorkathAttackCounter = 6;
				vorkathNextSpecial = "Ice";
			}
			else if (actor.getAnimation() == VorkathAttack.DEATH.getAnimation())
			{
				attack = VorkathAttack.DEATH;
				vorkathAttackCounter = 6;
				vorkathNextSpecial = "Unknown";
			}
			else
			{
				attack = null;
			}
		}
	}

	VorkathAttack getAttack()
	{
		return attack;
	}

}
