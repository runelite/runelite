import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("JagexCache")
public class JagexCache {
	@ObfuscatedName("u")
	@Export("JagexCache_locationFile")
	static File JagexCache_locationFile;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 34524443
	)
	@Export("idxCount")
	public static int idxCount;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -424456649
	)
	@Export("ItemDefinition_fileCount")
	public static int ItemDefinition_fileCount;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("JagexCache_randomDat")
	public static BufferedFile JagexCache_randomDat;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("JagexCache_dat2File")
	public static BufferedFile JagexCache_dat2File;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("JagexCache_idx255File")
	public static BufferedFile JagexCache_idx255File;
	@ObfuscatedName("j")
	@Export("userHomeDirectory")
	public static String userHomeDirectory;

	static {
		JagexCache_randomDat = null;
		JagexCache_dat2File = null;
		JagexCache_idx255File = null;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)Lir;",
		garbageValue = "62"
	)
	@Export("StructDefinition_getStructDefinition")
	public static StructDefinition StructDefinition_getStructDefinition(int var0) {
		StructDefinition var1 = (StructDefinition)StructDefinition.StructDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = StructDefinition.StructDefinition_archive.takeFile(34, var0);
			var1 = new StructDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			var1.postDecode();
			StructDefinition.StructDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}
