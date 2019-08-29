import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("s")
	@Export("FileSystem_hasPermissions")
	public static boolean FileSystem_hasPermissions;
	@ObfuscatedName("j")
	@Export("FileSystem_cacheDir")
	public static File FileSystem_cacheDir;
	@ObfuscatedName("i")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lip;",
		garbageValue = "-760710815"
	)
	public static VarcInt method3447(int var0) {
		VarcInt var1 = (VarcInt)VarcInt.VarcInt_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarcInt.VarcInt_archive.takeFile(19, var0);
			var1 = new VarcInt();
			if (var2 != null) {
				var1.method4314(new Buffer(var2));
			}

			VarcInt.VarcInt_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(IIB)Lbi;",
		garbageValue = "17"
	)
	@Export("Messages_getByChannelAndID")
	static Message Messages_getByChannelAndID(int var0, int var1) {
		ChatChannel var2 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var2.getMessage(var1);
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;III)Lkb;",
		garbageValue = "1068587353"
	)
	@Export("SpriteBuffer_getFont")
	public static Font SpriteBuffer_getFont(AbstractArchive var0, AbstractArchive var1, int var2, int var3) {
		if (!World.SpriteBuffer_bufferFile(var0, var2, var3)) {
			return null;
		} else {
			byte[] var5 = var1.takeFile(var2, var3);
			Font var4;
			if (var5 == null) {
				var4 = null;
			} else {
				Font var6 = new Font(var5, class325.SpriteBuffer_xOffsets, class325.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, class225.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, WorldMapSection1.SpriteBuffer_pixels);
				UserComparator7.SpriteBuffer_clear();
				var4 = var6;
			}

			return var4;
		}
	}
}
