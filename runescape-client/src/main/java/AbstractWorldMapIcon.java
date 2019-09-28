import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
@Implements("AbstractWorldMapIcon")
public abstract class AbstractWorldMapIcon {
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	@Export("NetCache_reference")
	static Buffer NetCache_reference;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("coord2")
	public final Coord coord2;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lhb;"
	)
	@Export("coord1")
	public final Coord coord1;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -744946711
	)
	@Export("screenX")
	int screenX;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1215104535
	)
	@Export("screenY")
	int screenY;

	@ObfuscatedSignature(
		signature = "(Lhb;Lhb;)V"
	)
	AbstractWorldMapIcon(Coord var1, Coord var2) {
		this.coord1 = var1;
		this.coord2 = var2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "16"
	)
	@Export("getElement")
	public abstract int getElement();

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Law;",
		garbageValue = "13348956"
	)
	@Export("getLabel")
	abstract WorldMapLabel getLabel();

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-175699296"
	)
	@Export("getSubWidth")
	abstract int getSubWidth();

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "806304417"
	)
	@Export("getSubHeight")
	abstract int getSubHeight();

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "1521252994"
	)
	@Export("fitsScreen")
	boolean fitsScreen(int var1, int var2) {
		if (this.elementFitsScreen(var1, var2)) {
			return true;
		} else {
			return this.labelFitsScreen(var1, var2);
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "36"
	)
	@Export("hasValidElement")
	boolean hasValidElement() {
		return this.getElement() >= 0;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-2112119378"
	)
	@Export("elementFitsScreen")
	boolean elementFitsScreen(int var1, int var2) {
		if (!this.hasValidElement()) {
			return false;
		} else {
			WorldMapElement var3 = Decimator.WorldMapElement_get(this.getElement());
			int var4 = this.getSubWidth();
			int var5 = this.getSubHeight();
			switch(var3.horizontalAlignment.value) {
			case 0:
				if (var1 >= this.screenX && var1 < var4 + this.screenX) {
					break;
				}

				return false;
			case 1:
				if (var1 > this.screenX - var4 && var1 <= this.screenX) {
					break;
				}

				return false;
			case 2:
				if (var1 < this.screenX - var4 / 2 || var1 > var4 / 2 + this.screenX) {
					return false;
				}
			}

			switch(var3.verticalAlignment.value) {
			case 0:
				if (var2 <= this.screenY - var5 || var2 > this.screenY) {
					return false;
				}
				break;
			case 1:
				if (var2 < this.screenY || var2 >= var5 + this.screenY) {
					return false;
				}
				break;
			case 2:
				if (var2 < this.screenY - var5 / 2 || var2 > var5 / 2 + this.screenY) {
					return false;
				}
			}

			return true;
		}
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(IIB)Z",
		garbageValue = "122"
	)
	@Export("labelFitsScreen")
	boolean labelFitsScreen(int var1, int var2) {
		WorldMapLabel var3 = this.getLabel();
		if (var3 == null) {
			return false;
		} else if (var1 >= this.screenX - var3.width / 2 && var1 <= var3.width / 2 + this.screenX) {
			return var2 >= this.screenY && var2 <= this.screenY + var3.height;
		} else {
			return false;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BILjava/lang/CharSequence;I)I",
		garbageValue = "1746697865"
	)
	public static int method640(byte[] var0, int var1, CharSequence var2) {
		int var3 = var2.length();
		int var4 = var1;

		for (int var5 = 0; var5 < var3; ++var5) {
			char var6 = var2.charAt(var5);
			if (var6 <= 127) {
				var0[var4++] = (byte)var6;
			} else if (var6 <= 2047) {
				var0[var4++] = (byte)(192 | var6 >> 6);
				var0[var4++] = (byte)(128 | var6 & '?');
			} else {
				var0[var4++] = (byte)(224 | var6 >> '\f');
				var0[var4++] = (byte)(128 | var6 >> 6 & 63);
				var0[var4++] = (byte)(128 | var6 & '?');
			}
		}

		return var4 - var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Llf;",
		garbageValue = "-1750401163"
	)
	static Sprite[] method642() {
		Sprite[] var0 = new Sprite[class325.SpriteBuffer_spriteCount];

		for (int var1 = 0; var1 < class325.SpriteBuffer_spriteCount; ++var1) {
			Sprite var2 = var0[var1] = new Sprite();
			var2.width = class325.SpriteBuffer_spriteWidth;
			var2.height = Frames.SpriteBuffer_spriteHeight;
			var2.xOffset = class325.SpriteBuffer_xOffsets[var1];
			var2.yOffset = MusicPatchPcmStream.SpriteBuffer_yOffsets[var1];
			var2.subWidth = class325.SpriteBuffer_spriteWidths[var1];
			var2.subHeight = RunException.SpriteBuffer_spriteHeights[var1];
			int var3 = var2.subHeight * var2.subWidth;
			byte[] var4 = PacketBufferNode.SpriteBuffer_pixels[var1];
			var2.pixels = new int[var3];

			for (int var5 = 0; var5 < var3; ++var5) {
				var2.pixels[var5] = class325.SpriteBuffer_spritePalette[var4[var5] & 255];
			}
		}

		class325.SpriteBuffer_xOffsets = null;
		MusicPatchPcmStream.SpriteBuffer_yOffsets = null;
		class325.SpriteBuffer_spriteWidths = null;
		RunException.SpriteBuffer_spriteHeights = null;
		class325.SpriteBuffer_spritePalette = null;
		PacketBufferNode.SpriteBuffer_pixels = null;
		return var0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "431385014"
	)
	@Export("isDigit")
	public static boolean isDigit(char var0) {
		return var0 >= '0' && var0 <= '9';
	}
}
