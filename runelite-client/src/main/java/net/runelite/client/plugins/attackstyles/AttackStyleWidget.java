package net.runelite.client.plugins.attackstyles;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.widgets.WidgetInfo;

@Getter
@RequiredArgsConstructor
public enum AttackStyleWidget
{
	ONE(WidgetInfo.COMBAT_STYLE_ONE, WidgetInfo.COMBAT_STYLE_ONE_ICON, WidgetInfo.COMBAT_STYLE_ONE_TEXT),
	TWO(WidgetInfo.COMBAT_STYLE_TWO, WidgetInfo.COMBAT_STYLE_TWO_ICON, WidgetInfo.COMBAT_STYLE_TWO_TEXT),
	THREE(WidgetInfo.COMBAT_STYLE_THREE, WidgetInfo.COMBAT_STYLE_THREE_ICON, WidgetInfo.COMBAT_STYLE_THREE_TEXT),
	FOUR(WidgetInfo.COMBAT_STYLE_FOUR, WidgetInfo.COMBAT_STYLE_FOUR_ICON, WidgetInfo.COMBAT_STYLE_FOUR_TEXT);

	private final WidgetInfo container;
	private final WidgetInfo icon;
	private final WidgetInfo text;

	@Getter
	private static final AttackStyleWidget[] attackStyles;

	static
	{
		attackStyles = new AttackStyleWidget[values().length];
		int i = 0;
		for (AttackStyleWidget attackStyleWidget : values())
		{
			attackStyles[i] = attackStyleWidget;
			i++;
		}
	}
}
