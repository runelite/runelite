import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Skeleton")
public class Skeleton extends Node {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1226731601
	)
	@Export("id")
	int id;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1996239831
	)
	@Export("count")
	int count;
	@ObfuscatedName("t")
	@Export("transformTypes")
	int[] transformTypes;
	@ObfuscatedName("g")
	@Export("labels")
	int[][] labels;

	Skeleton(int var1, byte[] var2) {
		this.id = var1;
		Buffer var3 = new Buffer(var2);
		this.count = var3.readUnsignedByte();
		this.transformTypes = new int[this.count];
		this.labels = new int[this.count][];

		int var4;
		for (var4 = 0; var4 < this.count; ++var4) {
			this.transformTypes[var4] = var3.readUnsignedByte();
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			this.labels[var4] = new int[var3.readUnsignedByte()];
		}

		for (var4 = 0; var4 < this.count; ++var4) {
			for (int var5 = 0; var5 < this.labels[var4].length; ++var5) {
				this.labels[var4][var5] = var3.readUnsignedByte();
			}
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Lhz;Lhz;Ljava/lang/String;Ljava/lang/String;I)Lkf;",
		garbageValue = "1144321855"
	)
	@Export("SpriteBuffer_getFontByName")
	public static Font SpriteBuffer_getFontByName(AbstractArchive var0, AbstractArchive var1, String var2, String var3) {
		int var4 = var0.getGroupId(var2);
		int var5 = var0.getFileId(var4, var3);
		byte[] var8 = var0.takeFile(var4, var5);
		boolean var7;
		if (var8 == null) {
			var7 = false;
		} else {
			GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var8);
			var7 = true;
		}

		Font var6;
		if (!var7) {
			var6 = null;
		} else {
			byte[] var9 = var1.takeFile(var4, var5);
			Font var11;
			if (var9 == null) {
				var11 = null;
			} else {
				Font var10 = new Font(var9, class325.SpriteBuffer_xOffsets, SecureRandomCallable.SpriteBuffer_yOffsets, class325.SpriteBuffer_spriteWidths, SoundSystem.SpriteBuffer_spriteHeights, class325.SpriteBuffer_spritePalette, InvDefinition.SpriteBuffer_pixels);
				class192.SpriteBuffer_clear();
				var11 = var10;
			}

			var6 = var11;
		}

		return var6;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IZI)Ljava/lang/String;",
		garbageValue = "-1925003342"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		if (var1 && var0 >= 0) {
			int var3 = var0;
			String var2;
			if (var1 && var0 >= 0) {
				int var4 = 2;

				for (int var5 = var0 / 10; var5 != 0; ++var4) {
					var5 /= 10;
				}

				char[] var6 = new char[var4];
				var6[0] = '+';

				for (int var7 = var4 - 1; var7 > 0; --var7) {
					int var8 = var3;
					var3 /= 10;
					int var9 = var8 - var3 * 10;
					if (var9 >= 10) {
						var6[var7] = (char)(var9 + 87);
					} else {
						var6[var7] = (char)(var9 + 48);
					}
				}

				var2 = new String(var6);
			} else {
				var2 = Integer.toString(var0, 10);
			}

			return var2;
		} else {
			return Integer.toString(var0);
		}
	}
}
