/*
 * Copyright (c) 2019, lyzrds <https://discord.gg/5eb9Fe>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package net.runelite.client.plugins.coxhelper;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.client.ui.overlay.components.PanelComponent;
import net.runelite.client.ui.overlay.components.table.TableAlignment;
import net.runelite.client.ui.overlay.components.table.TableComponent;

@Singleton
public class CoxDebugBox extends Overlay
{
	private final CoxConfig config;
	private final Olm olm;
	private final PanelComponent panelComponent = new PanelComponent();

	@Inject
	CoxDebugBox(CoxConfig config, Olm olm)
	{
		this.config = config;
		this.olm = olm;
		this.setPosition(OverlayPosition.BOTTOM_LEFT);
		this.determineLayer();
		this.setPriority(OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (!this.config.olmDebug())
		{
			return null;
		}

		this.panelComponent.getChildren().clear();
		TableComponent tableComponent = new TableComponent();
		tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT);
		tableComponent.addRow("olmActive", String.valueOf(this.olm.isActive()));
		tableComponent.addRow("lastHand", String.valueOf(this.olm.getLastHandAnimation()));
		tableComponent.addRow("lastHead", String.valueOf(this.olm.getLastHeadAnimation()));
		tableComponent.addRow("olmFirstPhase", String.valueOf(this.olm.isFirstPhase()));
		tableComponent.addRow("olmFinalPhase", String.valueOf(this.olm.isFinalPhase()));
		tableComponent.addRow("olmTickCycle", String.valueOf(this.olm.getTickCycle()));
		tableComponent.addRow("olmSpecial", String.valueOf(this.olm.getSpecialCycle()));
		tableComponent.addRow("olmTicksUntilAction", String.valueOf(this.olm.ticksUntilNextAction()));
		tableComponent.addRow("olmActionCycle", String.valueOf(this.olm.actionCycle()));
		tableComponent.addRow("portalTicks", String.valueOf(this.olm.getPortalTicks()));
		tableComponent.addRow("handCrippled", String.valueOf(this.olm.isCrippled()));
		tableComponent.addRow("crippleTimer", String.valueOf(this.olm.getCrippleTicks()));
		this.panelComponent.getChildren().add(tableComponent);

		return this.panelComponent.render(graphics);
	}


	public void determineLayer()
	{
	}
}
