package rs.api;

import api.FontTypeFace;
import net.runelite.mapping.Import;

public interface RSAbstractFont extends FontTypeFace
{
	@Import("stringWidth")
	@Override
	int getTextWidth(String text);

	@Import("ascent")
	@Override
	int getBaseline();

	@Import("draw")
	void drawTextLeftAligned(String text, int x, int y, int fontColor, int shadowColor);
}
