
package net.runelite.client.plugins.idlechecker;

import java.time.Instant;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

class IdleCheckerSession
{
	@Getter(AccessLevel.PACKAGE)
	private Instant lastActionTime;

	@Getter(AccessLevel.PACKAGE)
	@Setter(AccessLevel.PACKAGE)
	private boolean active;

	void setLastActionTime()
	{
		lastActionTime = Instant.now();
	}
}
