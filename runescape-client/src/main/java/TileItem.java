import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lag;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 809859925
	)
	@Export("id")
	int id;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1293976509
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)Lel;",
		garbageValue = "480835067"
	)
	@Export("getModel")
	protected final Model getModel() {
		return AbstractWorldMapData.ItemDefinition_get(this.id).getModel(this.quantity);
	}
}
