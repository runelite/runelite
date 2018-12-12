package net.runelite.http.service.loottracker;

import java.time.Instant;
import lombok.Data;
import net.runelite.http.api.loottracker.LootRecordType;

@Data
class LootResult
{
	private int killId;
	private Instant time;
	private LootRecordType type;
	private String eventId;
	private int itemId;
	private int itemQuantity;
}
