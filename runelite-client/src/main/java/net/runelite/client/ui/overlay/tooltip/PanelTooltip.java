/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
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
package net.runelite.client.ui.overlay.tooltip;

import lombok.Getter;
import lombok.Setter;
import net.runelite.client.ui.overlay.components.PanelComponent;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * A tooltip that displays key value data.
 *
 * @see PanelComponent The component the tooltip uses.
 */
public class PanelTooltip implements Tooltip
{
	@Setter
	private String title;

	@Setter
	private Color titleColor;

	@Getter
	private List<PanelComponent.Line> lines = new ArrayList<>();

	@Getter
	@Setter
	private boolean followMouse = true;

	@Setter
	@Getter
	private Point position = new Point();

	/**
	 * Creates the TooltipComponent for the tooltip.
	 *
	 * @return The TooltipComponent
	 */
	@Override
	public TooltipComponent getTooltipComponent()
	{
		PanelComponent component = new PanelComponent();
		component.getLines().addAll(this.lines);
		component.setTitle(title);
		component.setTitleColor(titleColor);
		return component;
	}
}
