import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("TileItem")
public final class TileItem extends Entity {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -431370449
	)
	@Export("id")
	int id;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -143029991
	)
	@Export("quantity")
	int quantity;

	TileItem() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected final Model getModel() {
		return WorldMapData_0.ItemDefinition_get(this.id).getModel(this.quantity);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-10"
	)
	public static void method2048() {
		SpotAnimationDefinition.SpotAnimationDefinition_cached.clear();
		SpotAnimationDefinition.SpotAnimationDefinition_cachedModels.clear();
	}
}
