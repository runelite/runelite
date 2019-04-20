package net.runelite.client.plugins.freezetimers;

import java.awt.Color;
import java.util.List;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.plugins.freezetimers.FreezeTimersConfig;
import net.runelite.client.plugins.freezetimers.FreezeTimersPlugin;

@Singleton
public class FreezeTimersService {
    private final Client client;
    private final FreezeTimersConfig config;
    private final FreezeTimersPlugin plugin;

    @Inject
    private FreezeTimersService(Client client, FreezeTimersConfig config, FreezeTimersPlugin plugin) {
        this.config = config;
        this.plugin = plugin;
        this.client = client;
    }

    public void forEachPlayer(BiConsumer<Player, Color> consumer) {
        for (Player player : this.client.getPlayers()) {
            if (player == null || player.getName() == null) continue;
            String name = player.getName();
            int freezetype = this.plugin.freezetype(name);
			long tbed = plugin.istbed(name);
            long dtime = this.plugin.opponentfreezetime(name);
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
            if (dtime <= 0L) continue;
            long currenttime = System.currentTimeMillis();
            long timediff = currenttime - dtime;
            if (timediff < (long)freezetime) {
                WorldPoint lastWorldPoint;
                WorldPoint currentWorldPoint = player.getWorldLocation();
                if (currentWorldPoint.equals(lastWorldPoint = this.plugin.playerpos(name))) {
                    consumer.accept(player, this.config.FreezeTimerColor());
                    continue;
                }
                if (timediff < 605L) {
                    this.plugin.updatePosition(name, currentWorldPoint);
                    consumer.accept(player, this.config.FreezeTimerColor());
                    continue;
                }
                this.plugin.deleteopponent(name);
                continue;
            }
            if (timediff < (long)(freezetime + 3000)) {
                consumer.accept(player, Color.YELLOW);
                continue;
            } else {
            this.plugin.deleteopponent(name);
			}
			if (tbed > 0) {
				consumer.accept(player, config.FreezeTimerColor());
				return;
			}
        }
    }
}

