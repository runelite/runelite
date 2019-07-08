package net.runelite.client.plugins.clanmanmode;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Actor;
import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Player;
import net.runelite.api.coords.WorldPoint;

@Singleton
public class ClanManModeService
{
	private final Client client;
	private final ClanManModePlugin plugin;

	@Inject
	private ClanManModeService(final Client client, final ClanManModePlugin plugin)
	{
		this.client = client;
		this.plugin = plugin;
	}

	private final Map<String, String> interactors = new HashMap<>();

	public void forEachPlayer(final BiConsumer<Player, Color> consumer)
	{
		int minatk = plugin.clanmax - plugin.wildernessLevel;
		int maxatk = plugin.clanmin + plugin.wildernessLevel;
		final Player localPlayer = client.getLocalPlayer();
		final String localName = localPlayer.getName();
		int selfmin = localPlayer.getCombatLevel() - plugin.wildernessLevel;
		int selfmax = localPlayer.getCombatLevel() + plugin.wildernessLevel;
		for (Player player : client.getPlayers())
		{
			if (player == null || player.getName() == null || player.equals(localPlayer))
			{
				continue;
			}

			boolean isClanMember = player.isClanMember();
			Actor interacting = player.getInteracting();
			Player interactor = null;
			if (interacting != null && !(interacting instanceof NPC))
			{
				interactor = ((Player) interacting);
			}

			if (plugin.isShowAttackers() && interactor != null && interactor.getName().equals(localName))
			{
				consumer.accept(player, plugin.getGetAttackerColor());
			}

			if (plugin.inwildy == 1)
			{
				if (isClanMember)
				{
					if (!plugin.clan.containsKey(player.getName()))
					{
						plugin.clan.put(player.getName(), player.getCombatLevel());
					}
					if (plugin.isHighlightAttacked() && interactor != null && !interactors.containsKey(interactor.getName()))
					{
						WorldPoint a = interactor.getWorldLocation();
						int underLevel = ((a.getY() - 9920) / 8) + 1;
						int upperLevel = ((a.getY() - 3520) / 8) + 1;
						int wildernessLevel = a.getY() > 6400 ? underLevel : upperLevel;
						int wildydiff = plugin.wildernessLevel - wildernessLevel;
						if (wildydiff < 0)
						{
							wildydiff = 0;
						}
						if (plugin.isCalcSelfCB())
						{
							if (interacting.getCombatLevel() <= selfmax && interacting.getCombatLevel() - wildydiff >= selfmin && !interactor.isClanMember())
							{
								interactors.put(interactor.getName(), player.getName());
								consumer.accept(interactor, plugin.getGetClanAttackableColor());
							}
						}
						else
						{
							if (interacting.getCombatLevel() <= maxatk && interacting.getCombatLevel() - wildydiff >= minatk && !interactor.isClanMember())
							{
								interactors.put(interactor.getName(), player.getName());
								consumer.accept(interactor, plugin.getGetClanAttackableColor());
							}
						}
					}
				}
				else
				{
					if (plugin.isPersistentClan() && plugin.clan.containsKey(player.getName()))
					{
						consumer.accept(player, plugin.getGetClanMemberColor());
					}
					if (plugin.isHighlightAttacked() && interactors.containsKey(player.getName()))
						{
						String attackername = interactors.get(player.getName());
						boolean found = false;
						for (Player attacker : client.getPlayers())
						{
							if (attacker == null || attacker.getName() == null)
							{
								continue;
							}
							if (attacker.getName().equals(attackername))
							{
								found = true;
								Actor ainteract = attacker.getInteracting();
								if (ainteract != null)
								{
									if (ainteract.getName().equals(player.getName()))
									{
										consumer.accept(player, plugin.getGetClanAttackableColor());
									}
									else
									{
										interactors.remove(player.getName());
									}
								}
								else
								{
									interactors.remove(player.getName());
								}
								break;
							}
						}
						if (!found)
						{
							interactors.remove(player.getName());
						}
						continue;
					}
					if (plugin.isHighlightAttackable())
					{
						if ((plugin.isHideAttackable() && plugin.ticks >= plugin.getHideTime()) || plugin.clan.containsKey(player.getName()))
						{
							continue;
						}
						WorldPoint a = player.getWorldLocation();
						int underLevel = ((a.getY() - 9920) / 8) + 1;
						int upperLevel = ((a.getY() - 3520) / 8) + 1;
						int wildernessLevel = a.getY() > 6400 ? underLevel : upperLevel;
						int wildydiff = plugin.wildernessLevel - wildernessLevel;
						if (wildydiff < 0)
						{
							wildydiff = 0;
						}
						if (plugin.isCalcSelfCB())
						{
							if (player.getCombatLevel() <= selfmax && player.getCombatLevel() - wildydiff >= selfmin)
							{
								consumer.accept(player, plugin.getGetAttackableColor());
							}
						}
						else
						{
							if (player.getCombatLevel() <= maxatk && player.getCombatLevel() - wildydiff >= minatk)
							{
								consumer.accept(player, plugin.getGetAttackableColor());
							}
						}
					}
				}
			}
		}
	}
}
