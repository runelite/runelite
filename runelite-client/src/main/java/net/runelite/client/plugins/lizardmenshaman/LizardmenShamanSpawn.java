package net.runelite.client.plugins.lizardmenshaman;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
class LizardmenShamanSpawn
{
	private final Instant start = Instant.now();
	private double countdownTimer;
	private Instant end;
}
