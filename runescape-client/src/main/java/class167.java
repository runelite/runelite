import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class167 {
	@ObfuscatedName("p")
	static File field2038;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("randomDat")
	public static BufferedFile randomDat;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("dat2File")
	public static BufferedFile dat2File;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lmn;"
	)
	@Export("idx255File")
	public static BufferedFile idx255File;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Lmn;"
	)
	@Export("idxFiles")
	public static BufferedFile[] idxFiles;
	@ObfuscatedName("g")
	static String[] field2043;
	@ObfuscatedName("dh")
	@ObfuscatedSignature(
		signature = "Liu;"
	)
	@Export("archive1")
	static Archive archive1;

	static {
		randomDat = null;
		dat2File = null;
		idx255File = null;
	}
}
