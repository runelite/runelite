package net.runelite.client.plugins.pestcontrol;

import java.awt.Color;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.runelite.client.plugins.pestcontrol.config.NpcHighlightStyle;

@AllArgsConstructor
@Getter
@Setter
public class NpcHighlightContext
{
	private NpcHighlightStyle npcRenderStyle;
	private Color color;
	private boolean showNpcName = false;
}
