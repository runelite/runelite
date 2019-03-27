package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;


@Singleton
public class FreezeTimersService
{
	private final Client client;
	private final FreezeTimersConfig config;
	private final FreezeTimersPlugin plugin;

	@Inject
	private FreezeTimersService(Client client, FreezeTimersConfig config, FreezeTimersPlugin plugin)
	{
		this.config = config;
		this.plugin = plugin;
		this.client = client;
	}

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{

		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null)
			{
				continue;
			}

			String name = player.getName();
			int freezetype = plugin.freezetype(name);
			long dtime = plugin.opponentfreezetime(name);
			int freezetime = 0;
			if (freezetype == 1 || freezetype == 4) {
				freezetime = 5000;
			} else if (freezetype == 2 || freezetype == 5) {
				freezetime = 10000;
			} else if (freezetype == 3 || freezetype == 6) {
				freezetime = 15000;
			} else if (freezetype == 7) {
				freezetime = 20000;
			} else if (freezetype == 8) {
				freezetime = 2500;
			} else if (freezetype == 9) {
				freezetime = 5000;
			} else if (freezetype == 10) {
				freezetime = 7500;
			}
			if (dtime > 0) {
				long currenttime = System.currentTimeMillis();
				long timediff = currenttime - dtime;
				if (timediff < freezetime) {
					WorldPoint currentWorldPoint = player.getWorldLocation();
					WorldPoint lastWorldPoint = plugin.playerpos(name);
					if (currentWorldPoint.equals(lastWorldPoint)) {
						consumer.accept(player, config.FreezeTimerColor());
					} else {
						if (timediff < 605) {
							plugin.updatepos(name, currentWorldPoint);
							consumer.accept(player, config.FreezeTimerColor());
						} else {
							plugin.deleteopponent(name);
						}
					}
				} else {
					if (timediff < freezetime + 3000) {
						consumer.accept(player, Color.YELLOW);
					} else {
						plugin.deleteopponent(name);
					}
				}
			}
		}
	}
}
