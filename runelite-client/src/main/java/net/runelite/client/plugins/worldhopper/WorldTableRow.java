/*
 * Copyright (c) 2018, Psikoi <https://github.com/Psikoi>
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
package net.runelite.client.plugins.worldhopper;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EnumSet;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.ui.FontManager;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldRegion;
import net.runelite.http.api.worlds.WorldType;

class WorldTableRow extends JPanel
{
	private static final ImageIcon FLAG_AUS;
	private static final ImageIcon FLAG_UK;
	private static final ImageIcon FLAG_US;
	private static final ImageIcon FLAG_GER;

	private static final int WORLD_COLUMN_WIDTH = 60;
	private static final int PLAYERS_COLUMN_WIDTH = 40;
	private static final int PING_COLUMN_WIDTH = 35;

	private static final Color CURRENT_WORLD = new Color(66, 227, 17);
	private static final Color DANGEROUS_WORLD = new Color(251, 62, 62);
	private static final Color BETA_WORLD = new Color(79, 145, 255);
	private static final Color MEMBERS_WORLD = new Color(210, 193, 53);
	private static final Color FREE_WORLD = new Color(200, 200, 200);
	private static final Color SEASONAL_WORLD = new Color(133, 177, 178);
	private static final Color PVP_ARENA_WORLD = new Color(144, 179, 255);
	private static final Color QUEST_SPEEDRUNNING_WORLD = new Color(94, 213, 201);
	private static final Color FRESH_START_WORLD = new Color(255, 211, 83);

	static
	{
		FLAG_AUS = new ImageIcon(ImageUtil.loadImageResource(WorldHopperPlugin.class, "flag_aus.png"));
		FLAG_UK = new ImageIcon(ImageUtil.loadImageResource(WorldHopperPlugin.class, "flag_uk.png"));
		FLAG_US = new ImageIcon(ImageUtil.loadImageResource(WorldHopperPlugin.class, "flag_us.png"));
		FLAG_GER = new ImageIcon(ImageUtil.loadImageResource(WorldHopperPlugin.class, "flag_ger.png"));
	}

	private final JMenuItem favoriteMenuOption = new JMenuItem();

	private JLabel worldField;
	private JLabel playerCountField;
	private JLabel activityField;
	private JLabel pingField;
	private final BiConsumer<World, Boolean> onFavorite;

	@Getter
	private final World world;

	@Getter(AccessLevel.PACKAGE)
	private int updatedPlayerCount;

	private int ping;

	private Color lastBackground;

	WorldTableRow(World world, boolean current, boolean favorite, Integer ping, Consumer<World> onSelect, BiConsumer<World, Boolean> onFavorite)
	{
		this.world = world;
		this.onFavorite = onFavorite;
		this.updatedPlayerCount = world.getPlayers();

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(2, 0, 2, 0));

		addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent mouseEvent)
			{
				if (mouseEvent.getClickCount() == 2)
				{
					if (onSelect != null)
					{
						onSelect.accept(world);
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				if (mouseEvent.getClickCount() == 2)
				{
					setBackground(getBackground().brighter());
				}
			}

			@Override
			public void mouseReleased(MouseEvent mouseEvent)
			{
				if (mouseEvent.getClickCount() == 2)
				{
					setBackground(getBackground().darker());
				}
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				WorldTableRow.this.lastBackground = getBackground();
				setBackground(getBackground().brighter());
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				setBackground(lastBackground);
			}
		});

		setFavoriteMenu(favorite);

		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(favoriteMenuOption);

		setComponentPopupMenu(popupMenu);

		JPanel leftSide = new JPanel(new BorderLayout());
		JPanel rightSide = new JPanel(new BorderLayout());
		leftSide.setOpaque(false);
		rightSide.setOpaque(false);

		JPanel worldField = buildWorldField();
		worldField.setPreferredSize(new Dimension(WORLD_COLUMN_WIDTH, 0));
		worldField.setOpaque(false);

		JPanel pingField = buildPingField(ping);
		pingField.setPreferredSize(new Dimension(PING_COLUMN_WIDTH, 0));
		pingField.setOpaque(false);

		JPanel playersField = buildPlayersField();
		playersField.setPreferredSize(new Dimension(PLAYERS_COLUMN_WIDTH, 0));
		playersField.setOpaque(false);

		JPanel activityField = buildActivityField();
		activityField.setBorder(new EmptyBorder(5, 5, 5, 5));
		activityField.setOpaque(false);

		recolour(current);

		leftSide.add(worldField, BorderLayout.WEST);
		leftSide.add(playersField, BorderLayout.CENTER);
		rightSide.add(activityField, BorderLayout.CENTER);
		rightSide.add(pingField, BorderLayout.EAST);

		add(leftSide, BorderLayout.WEST);
		add(rightSide, BorderLayout.CENTER);
	}

	void setFavoriteMenu(boolean favorite)
	{
		String favoriteAction = favorite ?
			"Remove " + world.getId() + " from favorites" :
			"Add " + world.getId() + " to favorites";

		favoriteMenuOption.setText(favoriteAction);

		for (ActionListener listener : favoriteMenuOption.getActionListeners())
		{
			favoriteMenuOption.removeActionListener(listener);
		}

		favoriteMenuOption.addActionListener(e ->
		{
			onFavorite.accept(world, !favorite);
		});
	}

	void updatePlayerCount(int playerCount)
	{
		this.updatedPlayerCount = playerCount;
		playerCountField.setText(playerCountString(playerCount));
	}

	private static String playerCountString(int playerCount)
	{
		return playerCount < 0 ? "OFF" : Integer.toString(playerCount);
	}

	void setPing(int ping)
	{
		this.ping = ping;
		pingField.setText(ping <= 0 ? "-" : Integer.toString(ping));
	}

	void hidePing()
	{
		pingField.setText("-");
	}

	void showPing()
	{
		setPing(ping); // to update pingField
	}

	int getPing()
	{
		return ping;
	}

	public void recolour(boolean current)
	{
		playerCountField.setForeground(current ? CURRENT_WORLD : Color.WHITE);
		pingField.setForeground(current ? CURRENT_WORLD : Color.WHITE);

		if (current)
		{
			activityField.setForeground(CURRENT_WORLD);
			worldField.setForeground(CURRENT_WORLD);
			return;
		}


		EnumSet<WorldType> types = world.getTypes();
		if (types.contains(WorldType.PVP)
			|| types.contains(WorldType.HIGH_RISK)
			|| types.contains(WorldType.DEADMAN))
		{
			activityField.setForeground(DANGEROUS_WORLD);
		}
		else if (types.contains(WorldType.SEASONAL))
		{
			activityField.setForeground(SEASONAL_WORLD);
		}
		else if (types.contains(WorldType.NOSAVE_MODE) || types.contains(WorldType.BETA_WORLD))
		{
			activityField.setForeground(BETA_WORLD);
		}
		else if (types.contains(WorldType.PVP_ARENA))
		{
			activityField.setForeground(PVP_ARENA_WORLD);
		}
		else if (types.contains(WorldType.QUEST_SPEEDRUNNING))
		{
			activityField.setForeground(QUEST_SPEEDRUNNING_WORLD);
		}
		else if (types.contains(WorldType.FRESH_START_WORLD))
		{
			activityField.setForeground(FRESH_START_WORLD);
		}
		else
		{
			activityField.setForeground(Color.WHITE);
		}

		worldField.setForeground(types.contains(WorldType.MEMBERS) ? MEMBERS_WORLD : FREE_WORLD);
	}

	/**
	 * Builds the players list field (containing the amount of players logged in that world).
	 */
	private JPanel buildPlayersField()
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		playerCountField = new JLabel(playerCountString(world.getPlayers()));
		playerCountField.setFont(FontManager.getRunescapeSmallFont());

		column.add(playerCountField, BorderLayout.WEST);

		return column;
	}

	private JPanel buildPingField(Integer ping)
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		pingField = new JLabel("-");
		pingField.setFont(FontManager.getRunescapeSmallFont());

		column.add(pingField, BorderLayout.EAST);

		if (ping != null)
		{
			setPing(ping);
		}

		return column;
	}

	/**
	 * Builds the activity list field (containing that world's activity/theme).
	 */
	private JPanel buildActivityField()
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		String activity = world.getActivity();
		activityField = new JLabel(activity);
		activityField.setFont(FontManager.getRunescapeSmallFont());
		if (activity != null && activity.length() > 16)
		{
			activityField.setToolTipText(activity);
			// Pass up events - https://stackoverflow.com/a/14932443
			activityField.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					dispatchEvent(e);
				}

				@Override
				public void mousePressed(MouseEvent e)
				{
					dispatchEvent(e);
				}

				@Override
				public void mouseReleased(MouseEvent e)
				{
					dispatchEvent(e);
				}

				@Override
				public void mouseEntered(MouseEvent e)
				{
					dispatchEvent(e);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					dispatchEvent(e);
				}
			});
		}

		column.add(activityField, BorderLayout.WEST);

		return column;
	}

	/**
	 * Builds the world list field (containing the country's flag and the world index).
	 */
	private JPanel buildWorldField()
	{
		JPanel column = new JPanel(new BorderLayout(7, 0));
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		worldField = new JLabel(world.getId() + "");

		ImageIcon flagIcon = getFlag(world.getRegion());
		if (flagIcon != null)
		{
			JLabel flag = new JLabel(flagIcon);
			column.add(flag, BorderLayout.WEST);
		}
		column.add(worldField, BorderLayout.CENTER);

		return column;
	}

	private static ImageIcon getFlag(WorldRegion region)
	{
		if (region == null)
		{
			return null;
		}

		switch (region)
		{
			case UNITED_STATES_OF_AMERICA:
				return FLAG_US;
			case UNITED_KINGDOM:
				return FLAG_UK;
			case AUSTRALIA:
				return FLAG_AUS;
			case GERMANY:
				return FLAG_GER;
			default:
				return null;
		}
	}
}
