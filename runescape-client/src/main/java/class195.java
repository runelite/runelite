import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class195 {
	static {
		new HashMap();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lgs;I)I",
		garbageValue = "265459979"
	)
	@Export("compareStrings")
	public static int compareStrings(CharSequence var0, CharSequence var1, Language var2) {
		int var3 = var0.length();
		int var4 = var1.length();
		int var5 = 0;
		int var6 = 0;
		byte var7 = 0;
		byte var8 = 0;

		while (var5 - var7 < var3 || var6 - var8 < var4) {
			if (var5 - var7 >= var3) {
				return -1;
			}

			if (var6 - var8 >= var4) {
				return 1;
			}

			char var9;
			if (var7 != 0) {
				var9 = (char)var7;
				boolean var14 = false;
			} else {
				var9 = var0.charAt(var5++);
			}

			char var10;
			if (var8 != 0) {
				var10 = (char)var8;
				boolean var15 = false;
			} else {
				var10 = var1.charAt(var6++);
			}

			byte var11;
			if (var9 == 198) {
				var11 = 69;
			} else if (var9 == 230) {
				var11 = 101;
			} else if (var9 == 223) {
				var11 = 115;
			} else if (var9 == 338) {
				var11 = 69;
			} else if (var9 == 339) {
				var11 = 101;
			} else {
				var11 = 0;
			}

			var7 = var11;
			byte var12;
			if (var10 == 198) {
				var12 = 69;
			} else if (var10 == 230) {
				var12 = 101;
			} else if (var10 == 223) {
				var12 = 115;
			} else if (var10 == 338) {
				var12 = 69;
			} else if (var10 == 339) {
				var12 = 101;
			} else {
				var12 = 0;
			}

			var8 = var12;
			var9 = Interpreter.standardizeChar(var9, var2);
			var10 = Interpreter.standardizeChar(var10, var2);
			if (var9 != var10 && Character.toUpperCase(var9) != Character.toUpperCase(var10)) {
				var9 = Character.toLowerCase(var9);
				var10 = Character.toLowerCase(var10);
				if (var10 != var9) {
					return FloorOverlayDefinition.lowercaseChar(var9, var2) - FloorOverlayDefinition.lowercaseChar(var10, var2);
				}
			}
		}

		int var16 = Math.min(var3, var4);

		int var17;
		char var20;
		for (var17 = 0; var17 < var16; ++var17) {
			if (var2 == Language.Language_FR) {
				var5 = var3 - 1 - var17;
				var6 = var4 - 1 - var17;
			} else {
				var6 = var17;
				var5 = var17;
			}

			char var18 = var0.charAt(var5);
			var20 = var1.charAt(var6);
			if (var20 != var18 && Character.toUpperCase(var18) != Character.toUpperCase(var20)) {
				var18 = Character.toLowerCase(var18);
				var20 = Character.toLowerCase(var20);
				if (var20 != var18) {
					return FloorOverlayDefinition.lowercaseChar(var18, var2) - FloorOverlayDefinition.lowercaseChar(var20, var2);
				}
			}
		}

		var17 = var3 - var4;
		if (var17 != 0) {
			return var17;
		} else {
			for (int var19 = 0; var19 < var16; ++var19) {
				var20 = var0.charAt(var19);
				char var13 = var1.charAt(var19);
				if (var13 != var20) {
					return FloorOverlayDefinition.lowercaseChar(var20, var2) - FloorOverlayDefinition.lowercaseChar(var13, var2);
				}
			}

			return 0;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhz;Ljava/lang/String;Ljava/lang/String;I)[Lli;",
		garbageValue = "900834692"
	)
	public static IndexedSprite[] method3667(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		IndexedSprite[] var5;
		if (!HitSplatDefinition.method4586(var0, var3, var4)) {
			var5 = null;
		} else {
			IndexedSprite[] var7 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

			for (int var8 = 0; var8 < class325.SpriteBuffer_spriteCount; ++var8) {
				IndexedSprite var9 = var7[var8] = new IndexedSprite();
				var9.width = class325.SpriteBuffer_spriteWidth;
				var9.height = class325.SpriteBuffer_spriteHeight;
				var9.xOffset = class325.SpriteBuffer_xOffsets[var8];
				var9.yOffset = class325.SpriteBuffer_yOffsets[var8];
				var9.subWidth = UserComparator1.SpriteBuffer_spriteWidths[var8];
				var9.subHeight = class325.SpriteBuffer_spriteHeights[var8];
				var9.palette = class268.SpriteBuffer_spritePalette;
				var9.pixels = class290.SpriteBuffer_pixels[var8];
			}

			Message.method1223();
			var5 = var7;
		}

		return var5;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkq;IB)Ljava/lang/String;",
		garbageValue = "125"
	)
	static String method3664(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class206.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = class225.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("fd")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1463713032"
	)
	@Export("updateGameState")
	static void updateGameState(int var0) {
		if (var0 != Client.gameState) {
			if (Client.gameState == 0) {
				class206.client.method947();
			}

			if (var0 == 20 || var0 == 40 || var0 == 45) {
				Client.loginState = 0;
				Client.field663 = 0;
				Client.field740 = 0;
				Client.timer.method5017(var0);
				if (var0 != 20) {
					AbstractWorldMapIcon.method612(false);
				}
			}

			if (var0 != 20 && var0 != 40 && VertexNormal.field1730 != null) {
				VertexNormal.field1730.close();
				VertexNormal.field1730 = null;
			}

			if (Client.gameState == 25) {
				Client.field734 = 0;
				Client.field824 = 0;
				Client.field859 = 1;
				Client.field683 = 0;
				Client.field684 = 1;
			}

			if (var0 != 5 && var0 != 10) {
				if (var0 == 20) {
					DevicePcmPlayerProvider.method841(ServerBuild.archive10, class3.archive8, true, Client.gameState == 11 ? 4 : 0);
				} else if (var0 == 11) {
					DevicePcmPlayerProvider.method841(ServerBuild.archive10, class3.archive8, false, 4);
				} else {
					Frames.method3280();
				}
			} else {
				DevicePcmPlayerProvider.method841(ServerBuild.archive10, class3.archive8, true, 0);
			}

			Client.gameState = var0;
		}
	}
}
