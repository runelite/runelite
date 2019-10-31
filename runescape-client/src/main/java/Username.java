import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
@Implements("Username")
public class Username implements Comparable {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Lbk;"
	)
	@Export("World_worlds")
	static World[] World_worlds;
	@ObfuscatedName("a")
	@Export("name")
	String name;
	@ObfuscatedName("t")
	@Export("cleanName")
	String cleanName;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lln;)V"
	)
	public Username(String var1, LoginType var2) {
		this.name = var1;
		String var4;
		if (var1 == null) {
			var4 = null;
		} else {
			int var5 = 0;

			int var6;
			for (var6 = var1.length(); var5 < var6 && class13.method200(var1.charAt(var5)); ++var5) {
			}

			while (var6 > var5 && class13.method200(var1.charAt(var6 - 1))) {
				--var6;
			}

			int var7 = var6 - var5;
			if (var7 >= 1 && var7 <= WorldMapDecoration.method388(var2)) {
				StringBuilder var8 = new StringBuilder(var7);

				for (int var9 = var5; var9 < var6; ++var9) {
					char var10 = var1.charAt(var9);
					if (WallDecoration.method3420(var10)) {
						char var11 = Buddy.method5286(var10);
						if (var11 != 0) {
							var8.append(var11);
						}
					}
				}

				if (var8.length() == 0) {
					var4 = null;
				} else {
					var4 = var8.toString();
				}
			} else {
				var4 = null;
			}
		}

		this.cleanName = var4;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "-1911798816"
	)
	@Export("getName")
	public String getName() {
		return this.name;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "121"
	)
	@Export("hasCleanName")
	public boolean hasCleanName() {
		return this.cleanName != null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lju;S)I",
		garbageValue = "-11004"
	)
	@Export("compareToTyped")
	public int compareToTyped(Username var1) {
		if (this.cleanName == null) {
			return var1.cleanName == null ? 0 : 1;
		} else {
			return var1.cleanName == null ? -1 : this.cleanName.compareTo(var1.cleanName);
		}
	}

	public boolean equals(Object var1) {
		if (var1 instanceof Username) {
			Username var2 = (Username)var1;
			if (this.cleanName == null) {
				return var2.cleanName == null;
			} else if (var2.cleanName == null) {
				return false;
			} else {
				return this.hashCode() != var2.hashCode() ? false : this.cleanName.equals(var2.cleanName);
			}
		} else {
			return false;
		}
	}

	public int hashCode() {
		return this.cleanName == null ? 0 : this.cleanName.hashCode();
	}

	public String toString() {
		return this.getName();
	}

	public int compareTo(Object var1) {
		return this.compareToTyped((Username)var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-300654930"
	)
	@Export("ViewportMouse_unpackX")
	public static int ViewportMouse_unpackX(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 14 & 3L);
		return var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Llx;",
		garbageValue = "-2059953793"
	)
	static Sprite method5338() {
		Sprite var0 = new Sprite();
		var0.width = class325.SpriteBuffer_spriteWidth;
		var0.height = class325.SpriteBuffer_spriteHeight;
		var0.xOffset = SecureRandomFuture.SpriteBuffer_xOffsets[0];
		var0.yOffset = HealthBar.SpriteBuffer_yOffsets[0];
		var0.subWidth = SecureRandomCallable.SpriteBuffer_spriteWidths[0];
		var0.subHeight = AttackOption.SpriteBuffer_spriteHeights[0];
		int var1 = var0.subHeight * var0.subWidth;
		byte[] var2 = class325.SpriteBuffer_pixels[0];
		var0.pixels = new int[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var0.pixels[var3] = class325.SpriteBuffer_spritePalette[var2[var3] & 255];
		}

		WorldMapData_1.method787();
		return var0;
	}
}
