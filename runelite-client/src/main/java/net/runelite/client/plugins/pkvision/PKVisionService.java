package net.runelite.client.plugins.pkvision;

import java.awt.Color;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.Player;
import net.runelite.client.util.MiscUtils;

@Singleton
public class PKVisionService
{
    private final Client client;
    private final PKVisionConfig config;

    @Inject
    private PKVisionService(Client client, PKVisionConfig config)
    {
        this.config = config;
        this.client = client;
    }

    public void forEachPlayer(final BiConsumer<Player, Color> consumer)
    {
        final Player localPlayer = client.getLocalPlayer();

        for (Player player : client.getPlayers())
        {
            if (player == null || player.getName() == null)
                continue;

            if (player == localPlayer)
            {
                if (config.highlightOwnPlayer())
                    consumer.accept(player, config.getOwnPlayerColor());

                continue;
            }

            if (config.highlightFriends() && (player.isFriend() || player.isClanMember()))
            {
                consumer.accept(player, config.getFriendColor());
            }
            else if (player != localPlayer && !player.isFriend() && !player.isClanMember())
            {
                int lvlDelta =  player.getCombatLevel() - localPlayer.getCombatLevel();
                int wildyLvl = MiscUtils.getWildernessLevelFrom(client, player.getWorldLocation());

                if (wildyLvl <= 0)
                    continue;

                if (Math.abs(lvlDelta) > wildyLvl)
                    continue;

                int R = MiscUtils.clamp((int)(((float)(lvlDelta + wildyLvl) / (float)(wildyLvl * 2)) * 255.f), 0, 255);
                int G = MiscUtils.clamp(255 - R, 0, 255);

                consumer.accept(player, Color.getHSBColor(Color.RGBtoHSB(R, G, 0, null)[0], 1.f, 1.f));
            }
        }
    }
}