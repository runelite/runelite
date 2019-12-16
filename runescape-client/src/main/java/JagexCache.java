import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("p")
	@Export("cacheDir")
	static File cacheDir;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -593345699
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lmy;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lmy;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lmy;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("t")
	static String[] field2024;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}
}
