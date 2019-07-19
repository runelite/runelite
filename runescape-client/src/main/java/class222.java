import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class222 {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Liw;",
		garbageValue = "-673469339"
	)
	@Export("getWorldMapElement")
	public static WorldMapElement getWorldMapElement(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}
}
