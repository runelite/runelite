import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("p")
	@Export("JagexCache_locationFile")
	static File JagexCache_locationFile;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Lmn;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("g")
	@Export("JagexCache_validCacheLocations")
	static String[] JagexCache_validCacheLocations;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive1")
	static Archive archive1;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}
}
