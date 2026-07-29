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
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Objects;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import lombok.AccessLevel;
import lombok.Getter;
import net.runelite.client.party.PartyMember;
import net.runelite.client.party.PartyService;
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
	private static final Color READY_COLOR = new Color(0, 200, 83);
	private static final int AVATAR_SIZE = 32;
	private static final int TICK_SIZE = 14;
	private static final BufferedImage READY_TICK = ImageUtil.resizeImage(
		ImageUtil.loadImageResource(PartyPlugin.class, "confirm_icon.png"), TICK_SIZE, TICK_SIZE);

	@Getter(AccessLevel.PACKAGE)
	private final PartyData memberPartyData;
	private final PartyService partyService;

	private final ProgressBar hpBar = new ProgressBar();
	private final ProgressBar prayerBar = new ProgressBar();

	private final JLabel name = new JLabel();
	private final JLabel avatar = new JLabel();

	private final PartyConfig config;

	private BufferedImage avatarBase;
	private boolean avatarIconSet;
	private Boolean renderedReady;

	PartyMemberBox(final PartyConfig config, final JComponent panel, final PartyData memberPartyData,
		final PartyService partyService)
	{
		this.config = config;
		this.memberPartyData = memberPartyData;
		this.partyService = partyService;

		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(5, 0, 0, 0));

		/* The box's wrapping container */
		final JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		container.setBackground(ColorScheme.DARKER_GRAY_COLOR);
		container.setBorder(new EmptyBorder(5, 5, 5, 5));

		// border color reflects ready-check state; updated in update()
		avatar.setBorder(BorderFactory.createLineBorder(Color.gray, 1));

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

		name.setFont(FontManager.getRunescapeSmallFont());
		name.putClientProperty("html.disable", Boolean.TRUE);

		namesPanel.add(name);

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

		// forward mouse drag events to parent panel for drag and drop reordering
		MouseDragEventForwarder mouseDragEventForwarder = new MouseDragEventForwarder(panel);
		container.addMouseListener(mouseDragEventForwarder);
		container.addMouseMotionListener(mouseDragEventForwarder);

		add(container, BorderLayout.NORTH);

		update();
	}

	void update()
	{
		final PartyMember member = partyService.getMemberById(memberPartyData.getMemberId());

		final Boolean ready = memberPartyData.getReady();
		final boolean isReady = Boolean.TRUE.equals(ready);

		// Cache the resized avatar once it becomes available
		if (avatarBase == null && member.getAvatar() != null)
		{
			avatarBase = ImageUtil.resizeImage(member.getAvatar(), AVATAR_SIZE, AVATAR_SIZE);
		}

		// (Re)build the avatar icon when it first becomes available or the ready state changes,
		// overlaying a green tick on members that have answered ready
		if (avatarBase != null && (!avatarIconSet || !Objects.equals(renderedReady, ready)))
		{
			ImageIcon icon = new ImageIcon(isReady ? withTick(avatarBase) : avatarBase);
			icon.getImage().flush();
			avatar.setIcon(icon);
			avatarIconSet = true;
			renderedReady = ready;
		}

		// Outline ready members in green
		avatar.setBorder(BorderFactory.createLineBorder(isReady ? READY_COLOR : Color.gray, 1));

		// Update progress bars
		hpBar.setValue(memberPartyData.getHitpoints());
		hpBar.setMaximumValue(memberPartyData.getMaxHitpoints());
		hpBar.setCenterLabel(progressBarLabel(memberPartyData.getHitpoints(), memberPartyData.getMaxHitpoints()));

		prayerBar.setValue(memberPartyData.getPrayer());
		prayerBar.setMaximumValue(memberPartyData.getMaxPrayer());
		prayerBar.setCenterLabel(progressBarLabel(memberPartyData.getPrayer(), memberPartyData.getMaxPrayer()));

		// Update name label
		Color playerColor = config.recolorNames() ? memberPartyData.getColor() : Color.WHITE;
		boolean isLoggedIn = member.isLoggedIn();

		name.setForeground(isLoggedIn ? playerColor : Color.GRAY);
		name.setText(member.getDisplayName());
	}

	private static String progressBarLabel(int current, int max)
	{
		return current + "/" + max;
	}

	private static BufferedImage withTick(BufferedImage base)
	{
		BufferedImage out = new BufferedImage(base.getWidth(), base.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics g = out.getGraphics();
		g.drawImage(base, 0, 0, null);
		// bottom-right corner
		g.drawImage(READY_TICK, base.getWidth() - READY_TICK.getWidth(), base.getHeight() - READY_TICK.getHeight(), null);
		g.dispose();
		return out;
	}
}
