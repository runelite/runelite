package net.runelite.client.plugins.notes;

import java.awt.Font;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.client.ui.FontManager;

@Getter
@RequiredArgsConstructor
public enum FontNotes
{
	RUNESCAPE_STANDARD(FontManager.getRunescapeFont()),
	RUNESCAPE_BOLD(FontManager.getRunescapeBoldFont()),
	RUNESCAPE_SMALL(FontManager.getRunescapeSmallFont()),
	RUNESCAPE_MONOSPACE(FontManager.getRunescapeMonospaceFont());

	private final Font font;
}
