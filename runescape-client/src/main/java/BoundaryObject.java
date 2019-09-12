import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("ok")
	@ObfuscatedSignature(
		signature = "Lcj;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("sm")
	@Export("foundItemIds")
	static short[] foundItemIds;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -2123632967
	)
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1852557733
	)
	@Export("y")
	int y;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 728809035
	)
	@Export("x")
	int x;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = 848853075
	)
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1849497569
	)
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity1")
	public Entity entity1;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lel;"
	)
	@Export("entity2")
	public Entity entity2;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		longValue = -720242261539970297L
	)
	@Export("tag")
	public long tag;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1272619537
	)
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "-17"
	)
	static final String method3230(int var0) {
		if (var0 < 100000) {
			return "<col=ffff00>" + var0 + "</col>";
		} else {
			return var0 < 10000000 ? "<col=ffffff>" + var0 / 1000 + "K" + "</col>" : "<col=00ff80>" + var0 / 1000000 + "M" + "</col>";
		}
	}
}
