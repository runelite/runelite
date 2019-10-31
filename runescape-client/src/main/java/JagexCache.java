import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("v")
	@Export("cacheDir")
	static File cacheDir;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 642051021
	)
	@Export("idxCount")
	static int idxCount;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1587061671
	)
	static int field2030;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lmz;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lmz;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmz;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("br")
	@ObfuscatedSignature(
		signature = "[Llw;"
	)
	@Export("worldSelectFlagSprites")
	static IndexedSprite[] worldSelectFlagSprites;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("gy")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1986411014"
	)
	static void method3624() {
		if (Login.worldMap != null) {
			Login.worldMap.method6437(Player.Client_plane, UserComparator8.baseX * 64 + (class215.localPlayer.x >> 7), HealthBar.baseY * 64 + (class215.localPlayer.y >> 7), false);
			Login.worldMap.loadCache();
		}

	}
}
