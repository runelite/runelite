import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("g")
	@Export("JagexCache_locationFile")
	static File JagexCache_locationFile;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 546367141
	)
	@Export("idxCount")
	static int idxCount;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lmw;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}
}
