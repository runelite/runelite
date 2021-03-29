/*
 * Copyright (c) 2021, Jonathan Rousseau <https://github.com/JoRouss>
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

package net.runelite.client.plugins.party;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.plugins.party.data.PartyData;
import net.runelite.client.ui.ColorScheme;
import net.runelite.client.ui.DynamicGridLayout;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.components.MouseDragEventForwarder;
import net.runelite.client.ui.components.ProgressBar;
import net.runelite.client.util.ImageUtil;

class PartyMemberBox extends JPanel
{
	private static final Color HP_FG = new Color(0, 146, 54, 230);
	private static final Color HP_BG = new Color(102, 15, 16, 230);
	private static final Color PRAY_FG = new Color(0, 149, 151);
	private static final Color PRAY_BG = Color.black;

	@Getter(AccessLevel.PACKAGE)
	private final PartyData memberPartyData;

	private final ProgressBar hpBar = new ProgressBar();
	private final ProgressBar prayerBar = new ProgressBar();

	private final JLabel topName = new JLabel();
	private final JLabel bottomName = new JLabel();

	private final JLabel avatar = new JLabel();

	private final PartyConfig config;

	private boolean avatarSet;

	PartyMemberBox(final PartyConfig config, final JComponent panel, final PartyData memberPartyData)
	{
		this.config = config;
		this.memberPartyData = memberPartyData;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		/* The box's wrapping container */
		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		// Create Toggle overlay
		final JMenuItem overlay = new JMenuItem("Toggle overlay");
		overlay.addActionListener(e -> memberPartyData.setShowOverlay(!memberPartyData.isShowOverlay()));

		// Create popup menu
		final JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
		popupMenu.add(overlay);

		// create a line border with the specified color and width
		Border border = BorderFactory.createLineBorder(Color.gray, 1);
		avatar.setBorder(border);

		avatar.setHorizontalAlignment(SwingConstants.CENTER);
		avatar.setVerticalAlignment(SwingConstants.CENTER);
		avatar.setPreferredSize(new Dimension(35, 35));

		/* Contains the avatar and the names */
		final JPanel headerPanel = new JPanel();
		headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		headerPanel.setLayout(new BorderLayout());
		headerPanel.setBorder(new EmptyBorder(0, 0, 3, 0));

		/* Contains ServiceName name and osrs name */
		final JPanel namesPanel = new JPanel();
		namesPanel.setLayout(new DynamicGridLayout(2, 1));
		namesPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		namesPanel.setBorder(new EmptyBorder(2, 5, 2, 5));

		topName.setFont(FontManager.getRunescapeSmallFont());
		bottomName.setFont(FontManager.getRunescapeSmallFont());

		topName.putClientProperty("html.disable", Boolean.TRUE);
		bottomName.putClientProperty("html.disable", Boolean.TRUE);

		namesPanel.add(topName);     // top
		namesPanel.add(bottomName);  // bottom

		headerPanel.add(avatar, BorderLayout.WEST);
		headerPanel.add(namesPanel, BorderLayout.CENTER);

		JPanel progressWrapper = new JPanel();
		progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		progressWrapper.setLayout(new DynamicGridLayout(2, 1, 0, 2));

		hpBar.setBackground(HP_BG);
		hpBar.setForeground(HP_FG);

		prayerBar.setBackground(PRAY_BG);
		prayerBar.setForeground(PRAY_FG);

		progressWrapper.add(hpBar);      // top
		progressWrapper.add(prayerBar);  // bottom

		container.add(headerPanel, BorderLayout.NORTH);
		container.add(progressWrapper, BorderLayout.SOUTH);

		container.setComponentPopupMenu(popupMenu);

		// forward mouse drag events to parent panel for drag and drop reordering
		MouseDragEventForwarder mouseDragEventForwarder = new MouseDragEventForwarder(panel);
		container.addMouseListener(mouseDragEventForwarder);
		container.addMouseMotionListener(mouseDragEventForwarder);

		add(container, BorderLayout.NORTH);

		update();
	}

	void update()
	{
		// Avatar
		if (!avatarSet && memberPartyData.getMember().getAvatar() != null)
		{
			ImageIcon icon = new ImageIcon(ImageUtil.resizeImage(memberPartyData.getMember().getAvatar(), 32, 32));
			icon.getImage().flush();
			avatar.setIcon(icon);

			avatarSet = true;
		}

		// Update progress bars
		hpBar.setValue(memberPartyData.getHitpoints());
		hpBar.setMaximumValue(memberPartyData.getMaxHitpoints());
		hpBar.setCenterLabel(progressBarLabel(memberPartyData.getHitpoints(), memberPartyData.getMaxHitpoints()));

		prayerBar.setValue(memberPartyData.getPrayer());
		prayerBar.setMaximumValue(memberPartyData.getMaxPrayer());
		prayerBar.setCenterLabel(progressBarLabel(memberPartyData.getPrayer(), memberPartyData.getMaxPrayer()));

		// Update name labels
		Color playerColor = config.recolorNames() ? memberPartyData.getColor() : Color.WHITE;
		boolean isLoggedIn = !memberPartyData.getCharacterName().isEmpty();

		topName.setForeground(playerColor);
		topName.setText(memberPartyData.getMember().getName());

		bottomName.setForeground(isLoggedIn ? playerColor : Color.GRAY);
		bottomName.setText(isLoggedIn ? memberPartyData.getCharacterName() : "Logged out");
	}

	private static String progressBarLabel(int current, int max)
	{
		return current + "/" + max;
	}
}
