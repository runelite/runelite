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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.IconButton;
import net.runelite.client.ui.components.IconTextField;
import net.runelite.client.util.ImageUtil;
import net.runelite.http.api.worlds.World;
import net.runelite.http.api.worlds.WorldType;

class WorldTableRow extends JPanel
{
	private static final ImageIcon FLAG_AUS;
	private static final ImageIcon FLAG_UK;
	private static final ImageIcon FLAG_US;
	private static final ImageIcon FLAG_GER;
	private static final ImageIcon ICON_FAVORITE_ON;
	private static final ImageIcon ICON_FAVORITE_ON_HOVER;
	private static final ImageIcon ICON_FAVORITE_OFF;
	private static final ImageIcon ICON_FAVORITE_OFF_HOVER;

	private static final int FAVORITE_COLUMN_WIDTH = 28;
	private static final int WORLD_COLUMN_WIDTH = 60;
	private static final int PLAYERS_COLUMN_WIDTH = 40;

	private static final Color CURRENT_WORLD = new Color(66, 227, 17);
	private static final Color UNAVAILABLE_WORLD = Color.GRAY.darker().darker();
	private static final Color DANGEROUS_WORLD = new Color(251, 62, 62);
	private static final Color TOURNAMENT_WORLD = new Color(79, 145, 255);
	private static final Color MEMBERS_WORLD = new Color(210, 193, 53);
	private static final Color FREE_WORLD = new Color(200, 200, 200);

	static
	{
		FLAG_AUS = new ImageIcon(ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "flag_aus.png"));
		FLAG_UK = new ImageIcon(ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "flag_uk.png"));
		FLAG_US = new ImageIcon(ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "flag_us.png"));
		FLAG_GER = new ImageIcon(ImageUtil.getResourceStreamFromClass(WorldHopperPlugin.class, "flag_ger.png"));

		final BufferedImage starOnImage = ImageUtil.getResourceStreamFromClass(IconTextField.class, "star.png");

		ICON_FAVORITE_ON = new ImageIcon(starOnImage);
		ICON_FAVORITE_ON_HOVER = new ImageIcon(ImageUtil.grayscaleOffset(starOnImage, -100));

		ICON_FAVORITE_OFF = new ImageIcon(ImageUtil.grayscaleOffset(ImageUtil.grayscaleImage(starOnImage), .77f));
		ICON_FAVORITE_OFF_HOVER = new ImageIcon(ImageUtil.grayscaleImage(starOnImage));
	}

	private Color lastBackground;
	private boolean current;
	private boolean favorite;

	WorldTableRow(World world, boolean current, boolean favorite, Consumer<World> onSelect, BiConsumer<World, Boolean> onFavorite)
	{
		this.current = current;
		this.favorite = favorite;

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

		JPanel leftSide = new JPanel(new BorderLayout());
		leftSide.setOpaque(false);

		JPanel favoriteField = buildFavoriteField(world, onFavorite);
		favoriteField.setPreferredSize(new Dimension(FAVORITE_COLUMN_WIDTH, 0));
		favoriteField.setOpaque(false);

		JPanel worldField = buildWorldField(world);
		worldField.setPreferredSize(new Dimension(WORLD_COLUMN_WIDTH, 0));
		worldField.setOpaque(false);

		JPanel playersField = buildPlayersField(world);
		playersField.setPreferredSize(new Dimension(PLAYERS_COLUMN_WIDTH, 0));
		playersField.setOpaque(false);

		JPanel activityField = buildActivityField(world);
		activityField.setBorder(new EmptyBorder(5, 5, 5, 5));
		activityField.setOpaque(false);

		leftSide.add(favoriteField, BorderLayout.WEST);
		leftSide.add(worldField, BorderLayout.CENTER);
		leftSide.add(playersField, BorderLayout.EAST);

		add(leftSide, BorderLayout.WEST);
		add(activityField, BorderLayout.CENTER);
	}

	/**
	 * Builds the players list field (containing the amount of players logged in that world).
	 */
	private JPanel buildPlayersField(World world)
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel label = new JLabel(world.getPlayers() + "");
		label.setFont(FontManager.getRunescapeSmallFont());
		label.setForeground(current ? CURRENT_WORLD : Color.WHITE);

		column.add(label, BorderLayout.WEST);

		return column;
	}

	/**
	 * Builds the activity list field (containing that world's activity/theme).
	 */
	private JPanel buildActivityField(World world)
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel label = new JLabel(world.getActivity());
		label.setFont(FontManager.getRunescapeSmallFont());

		if (current)
		{
			label.setForeground(CURRENT_WORLD);
		}
		else if (world.getTypes().contains(WorldType.PVP)
			|| world.getTypes().contains(WorldType.PVP_HIGH_RISK)
			|| world.getTypes().contains(WorldType.DEADMAN)
			|| world.getTypes().contains(WorldType.SEASONAL_DEADMAN))
		{
			label.setForeground(DANGEROUS_WORLD);
		}
		else if (world.getTypes().contains(WorldType.TOURNAMENT))
		{
			label.setForeground(TOURNAMENT_WORLD);
		}

		column.add(label, BorderLayout.WEST);

		return column;
	}

	/**
	 * Builds the world list field (containing the country's flag and the world index).
	 */
	private JPanel buildWorldField(World world)
	{
		JPanel column = new JPanel(new BorderLayout(7, 0));
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		JLabel label = new JLabel(world.getId() + "");

		if (current)
		{
			label.setForeground(CURRENT_WORLD);
		}
		else
		{
			label.setForeground(world.getTypes().contains(WorldType.MEMBERS) ? MEMBERS_WORLD : FREE_WORLD);
		}

		JLabel flag = new JLabel(getFlag(world.getLocation()));

		column.add(flag, BorderLayout.WEST);
		column.add(label, BorderLayout.CENTER);

		return column;
	}

	/**
	 * Builds the favorite field (containing the favorite star).
	 */
	private JPanel buildFavoriteField(World world, BiConsumer<World, Boolean> onFavorite)
	{
		JPanel column = new JPanel(new BorderLayout());
		column.setBorder(new EmptyBorder(0, 5, 0, 5));

		IconButton button = new IconButton(
			favorite ? ICON_FAVORITE_ON : ICON_FAVORITE_OFF,
			favorite ? ICON_FAVORITE_ON_HOVER : ICON_FAVORITE_OFF_HOVER
		);

		button.addActionListener(e -> onFavorite.accept(world, !favorite));

		column.add(button, BorderLayout.CENTER);

		return column;
	}

	private ImageIcon getFlag(int locationId)
	{
		switch (locationId)
		{
			case 0:
				return FLAG_US;
			case 1:
				return FLAG_UK;
			case 3:
				return FLAG_AUS;
			default:
				return FLAG_GER;
		}
	}
}
