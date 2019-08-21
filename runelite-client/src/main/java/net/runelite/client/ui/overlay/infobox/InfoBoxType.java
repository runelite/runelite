package net.runelite.client.ui.overlay.infobox;

import java.util.function.Predicate;
import net.runelite.client.plugins.boosts.BoostIndicator;
import net.runelite.client.plugins.boosts.StatChangeIndicator;

public enum InfoBoxType
{
	ALL		(infoBox -> true),
	BOOSTS	(infoBox -> infoBox instanceof BoostIndicator || infoBox instanceof StatChangeIndicator);

	public final Predicate<InfoBox> predicate;

	InfoBoxType(Predicate<InfoBox> predicate)
	{
		this.predicate = predicate;
	}
}
