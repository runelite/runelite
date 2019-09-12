import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("qd")
	@ObfuscatedGetter(
		intValue = 1877422611
	)
	static int field2027;
	@ObfuscatedName("c")
	@Export("FileSystem_hasPermissions")
	static boolean FileSystem_hasPermissions;
	@ObfuscatedName("t")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("title_muteSprite")
	static IndexedSprite[] title_muteSprite;
	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		signature = "[Llt;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("kl")
	@ObfuscatedGetter(
		intValue = -841195075
	)
	@Export("menuX")
	static int menuX;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)[Llt;",
		garbageValue = "584570356"
	)
	public static IndexedSprite[] method3489() {
		IndexedSprite[] var0 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class325.SpriteBuffer_spriteCount; ++var1) {
			IndexedSprite var2 = var0[var1] = new IndexedSprite();
			var2.width = class325.SpriteBuffer_spriteWidth;
			var2.height = class325.SpriteBuffer_spriteHeight;
			var2.xOffset = class325.SpriteBuffer_xOffsets[var1];
			var2.yOffset = SecureRandomCallable.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class325.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = SoundSystem.SpriteBuffer_spriteHeights[var1];
			var2.palette = class325.SpriteBuffer_spritePalette;
			var2.pixels = InvDefinition.SpriteBuffer_pixels[var1];
		}

		class192.SpriteBuffer_clear();
		return var0;
	}
}
