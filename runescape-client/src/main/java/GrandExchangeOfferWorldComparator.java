import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("sl")
	@ObfuscatedGetter(
		longValue = 7996115852397139965L
	)
	static long field25;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 850096723
	)
	@Export("PcmPlayer_sampleRate")
	public static int PcmPlayer_sampleRate;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("options_buttons_0Sprite")
	static IndexedSprite options_buttons_0Sprite;
	@ObfuscatedName("i")
	static String[] field30;
	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	static IndexedSprite field32;

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lv;Lv;I)I",
		garbageValue = "2009087817"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lkz;I)Ljava/lang/String;",
		garbageValue = "-1287260544"
	)
	public static String method60(Buffer var0) {
		String var1;
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > 32767) {
				var2 = 32767;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class210.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = class51.decodeStringCp1252(var3, 0, var2);
			var1 = var4;
		} catch (Exception var6) {
			var1 = "Cabbage";
		}

		return var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "236963295"
	)
	public static void method62() {
		FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1642239877"
	)
	@Export("SpriteBuffer_decode")
	public static void SpriteBuffer_decode(byte[] var0) {
		Buffer var1 = new Buffer(var0);
		var1.offset = var0.length - 2;
		class325.SpriteBuffer_spriteCount = var1.readUnsignedShort();
		class325.SpriteBuffer_xOffsets = new int[class325.SpriteBuffer_spriteCount];
		SecureRandomCallable.SpriteBuffer_yOffsets = new int[class325.SpriteBuffer_spriteCount];
		class325.SpriteBuffer_spriteWidths = new int[class325.SpriteBuffer_spriteCount];
		SoundSystem.SpriteBuffer_spriteHeights = new int[class325.SpriteBuffer_spriteCount];
		InvDefinition.SpriteBuffer_pixels = new byte[class325.SpriteBuffer_spriteCount][];
		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8;
		class325.SpriteBuffer_spriteWidth = var1.readUnsignedShort();
		class325.SpriteBuffer_spriteHeight = var1.readUnsignedShort();
		int var2 = (var1.readUnsignedByte() & 255) + 1;

		int var3;
		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_xOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			SecureRandomCallable.SpriteBuffer_yOffsets[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			class325.SpriteBuffer_spriteWidths[var3] = var1.readUnsignedShort();
		}

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			SoundSystem.SpriteBuffer_spriteHeights[var3] = var1.readUnsignedShort();
		}

		var1.offset = var0.length - 7 - class325.SpriteBuffer_spriteCount * 8 - (var2 - 1) * 3;
		class325.SpriteBuffer_spritePalette = new int[var2];

		for (var3 = 1; var3 < var2; ++var3) {
			class325.SpriteBuffer_spritePalette[var3] = var1.readMedium();
			if (class325.SpriteBuffer_spritePalette[var3] == 0) {
				class325.SpriteBuffer_spritePalette[var3] = 1;
			}
		}

		var1.offset = 0;

		for (var3 = 0; var3 < class325.SpriteBuffer_spriteCount; ++var3) {
			int var4 = class325.SpriteBuffer_spriteWidths[var3];
			int var5 = SoundSystem.SpriteBuffer_spriteHeights[var3];
			int var6 = var5 * var4;
			byte[] var7 = new byte[var6];
			InvDefinition.SpriteBuffer_pixels[var3] = var7;
			int var8 = var1.readUnsignedByte();
			int var9;
			if (var8 == 0) {
				for (var9 = 0; var9 < var6; ++var9) {
					var7[var9] = var1.readByte();
				}
			} else if (var8 == 1) {
				for (var9 = 0; var9 < var4; ++var9) {
					for (int var10 = 0; var10 < var5; ++var10) {
						var7[var9 + var4 * var10] = var1.readByte();
					}
				}
			}
		}

	}
}
