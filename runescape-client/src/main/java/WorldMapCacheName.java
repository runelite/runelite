import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("DETAILS")
	public static final WorldMapCacheName DETAILS;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("COMPOSITEMAP")
	public static final WorldMapCacheName COMPOSITEMAP;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("COMPOSITETEXTURE")
	public static final WorldMapCacheName COMPOSITETEXTURE;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("AREA")
	static final WorldMapCacheName AREA;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	@Export("LABELS")
	public static final WorldMapCacheName LABELS;
	@ObfuscatedName("c")
	public static short[] field309;
	@ObfuscatedName("de")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -380277113
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("l")
	@Export("name")
	public final String name;

	static {
		DETAILS = new WorldMapCacheName("details");
		COMPOSITEMAP = new WorldMapCacheName("compositemap");
		COMPOSITETEXTURE = new WorldMapCacheName("compositetexture");
		AREA = new WorldMapCacheName("area");
		LABELS = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhj;IB)V",
		garbageValue = "67"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2650 == null) {
			throw new RuntimeException();
		}
		if (var0.field2578 == null) {
			var0.field2578 = new int[var0.field2650.length];
		}

		var0.field2578[var1] = Integer.MAX_VALUE;
	}
}
