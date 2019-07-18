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
	public static final WorldMapCacheName field308;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	public static final WorldMapCacheName field302;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	public static final WorldMapCacheName field303;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	static final WorldMapCacheName field304;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lae;"
	)
	public static final WorldMapCacheName field305;
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
		field308 = new WorldMapCacheName("details");
		field302 = new WorldMapCacheName("compositemap");
		field303 = new WorldMapCacheName("compositetexture");
		field304 = new WorldMapCacheName("area");
		field305 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhj;IB)V",
		garbageValue = "67"
	)
	static final void method600(Widget var0, int var1) {
		if (var0.field2650 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2578 == null) {
				var0.field2578 = new int[var0.field2650.length];
			}

			var0.field2578[var1] = Integer.MAX_VALUE;
		}
	}
}
