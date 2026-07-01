/*
 * Copyright (c) 2023 Abex
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
package net.runelite.client.ui.laf;

import com.formdev.flatlaf.ui.FlatStylingSupport;
import com.formdev.flatlaf.ui.FlatToggleButtonUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

public class RuneLiteToggleButtonUI extends FlatToggleButtonUI
{
	@FlatStylingSupport.Styleable
	protected float rolloverIconAlpha = 1.0f;

	public static ComponentUI createUI(JComponent c)
	{
		return FlatUIUtils.canUseSharedUI(c)
			? FlatUIUtils.createSharedUI(RuneLiteToggleButtonUI.class, () -> new RuneLiteToggleButtonUI(true))
			: new RuneLiteToggleButtonUI(false);
	}

	protected RuneLiteToggleButtonUI(boolean shared)
	{
		super(shared);
	}

	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect)
	{
		if (rolloverIconAlpha != 1.0f && RuneLiteButtonUI.useRolloverEffect(c))
		{
			Graphics2D g2d = (Graphics2D) g;
			Composite composite = g2d.getComposite();
			try
			{
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, rolloverIconAlpha));
				super.paintIcon(g, c, iconRect);
			}
			finally
			{
				g2d.setComposite(composite);
			}
			return;
		}

		super.paintIcon(g, c, iconRect);
	}
}
