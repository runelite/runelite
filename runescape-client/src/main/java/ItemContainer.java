import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("oc")
	@ObfuscatedSignature(
		signature = "Lfk;"
	)
	@Export("mouseWheel")
	static MouseWheel mouseWheel;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		signature = "[Llm;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;
	@ObfuscatedName("hs")
	@ObfuscatedGetter(
		intValue = 778957861
	)
	@Export("cameraPitch")
	static int cameraPitch;
	@ObfuscatedName("f")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("b")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("h")
	@Export("Entity_unpackID")
	public static int Entity_unpackID(long var0) {
		return (int)(var0 >>> 17 & 4294967295L);
	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(Lbt;II)V",
		garbageValue = "1416714498"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		TextureProvider.worldToScreen(var0.x, var0.y, var1);
	}
}
