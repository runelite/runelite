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
	ARIAL(new Font("Arial", Font.PLAIN, 16)),
	COMIC_SANS_MS(new Font("Comic Sans MS", Font.PLAIN, 16)),
	CONSOLAS(new Font("Consolas", Font.PLAIN, 16)),
	VERDANA(new Font("Verdana", Font.PLAIN, 16));

	private final Font font;
}
