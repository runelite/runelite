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
	private final ClanManModeConfig config;
	private final ClanManModePlugin plugin;

	@Inject
	private ClanManModeService(Client client, ClanManModeConfig config, ClanManModePlugin plugin)
	{
		this.config = config;
		this.client = client;
		this.plugin = plugin;
	}

	private Map<String, String> interactors = new HashMap<>();

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
			if (player == null || player.getName() == null)
			{
				continue;
			}

			if (player == localPlayer)
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

			if (config.showAttackers())
			{
				if (interactor != null)
				{
					if (interactor.getName().equals(localName))
					{
						consumer.accept(player, config.getAttackerColor());
					}
				}
			}

			if (plugin.inwildy == 1)
			{
				if (isClanMember)
				{
					if (!plugin.clan.containsKey(player.getName()))
					{
						plugin.clan.put(player.getName(), player.getCombatLevel());
					}
					if (config.highlightAttacked())
					{
						if (interactor != null)
						{
							if (!interactors.containsKey(interactor.getName()))
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
								if (config.CalcSelfCB())
								{
									if (interacting.getCombatLevel() <= selfmax && interacting.getCombatLevel() - wildydiff >= selfmin && !interactor.isClanMember())
									{
										interactors.put(interactor.getName(), player.getName());
										consumer.accept(interactor, config.getClanAttackableColor());
									}
								}
								else
								{
									if (interacting.getCombatLevel() <= maxatk && interacting.getCombatLevel() - wildydiff >= minatk && !interactor.isClanMember())
									{
										interactors.put(interactor.getName(), player.getName());
										consumer.accept(interactor, config.getClanAttackableColor());
									}
								}
							}
						}
					}
				}
				else
				{
					if (config.PersistentClan())
					{
						if (plugin.clan.containsKey(player.getName()))
						{
							consumer.accept(player, config.getClanMemberColor());
						}
					}
					if (config.highlightAttacked())
					{
						if (interactors.containsKey(player.getName()))
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
											consumer.accept(player, config.getClanAttackableColor());
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
					}
					if (config.highlightAttackable())
					{
						if ((config.hideAttackable() && plugin.ticks >= config.hideTime()) || plugin.clan.containsKey(player.getName()))
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
						if (config.CalcSelfCB())
						{
							if (player.getCombatLevel() <= selfmax && player.getCombatLevel() - wildydiff >= selfmin)
							{
								consumer.accept(player, config.getAttackableColor());
							}
						}
						else
						{
							if (player.getCombatLevel() <= maxatk && player.getCombatLevel() - wildydiff >= minatk)
							{
								consumer.accept(player, config.getAttackableColor());
							}
						}
					}
				}
			}
		}
	}
}
