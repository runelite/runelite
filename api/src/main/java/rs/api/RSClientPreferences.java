package rs.api;

import api.Preferences;
import net.runelite.mapping.Import;

public interface RSClientPreferences extends Preferences
{
	@Import("rememberedUsername")
	@Override
	String getRememberedUsername();

	@Import("rememberedUsername")
	@Override
	void setRememberedUsername(String username);
}
