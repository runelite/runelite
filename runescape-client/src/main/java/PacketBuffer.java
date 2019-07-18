import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
@Implements("PacketBuffer")
public class PacketBuffer extends Buffer {
	@ObfuscatedName("w")
	static final int[] field3724;
	@ObfuscatedName("hd")
	@ObfuscatedGetter(
		intValue = -1521348339
	)
	@Export("cameraX")
	static int cameraX;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("isaacCipher")
	IsaacCipher isaacCipher;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1484140069
	)
	@Export("bitIndex")
	int bitIndex;

	static {
		field3724 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
	}

	public PacketBuffer(int var1) {
		super(var1);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([II)V",
		garbageValue = "-1645876260"
	)
	@Export("newIsaacCipher")
	public void newIsaacCipher(int[] var1) {
		this.isaacCipher = new IsaacCipher(var1);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Llv;B)V",
		garbageValue = "102"
	)
	@Export("setIsaacCipher")
	public void setIsaacCipher(IsaacCipher var1) {
		this.isaacCipher = var1;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-624366105"
	)
	@Export("writeByteIsaac")
	public void writeByteIsaac(int var1) {
		super.array[++super.offset - 1] = (byte)(var1 + this.isaacCipher.nextInt());
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1669588152"
	)
	@Export("readByteIsaac")
	public int readByteIsaac() {
		return super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "1288814590"
	)
	public boolean method5441() {
		int var1 = super.array[super.offset] - this.isaacCipher.method6254() & 255;
		return var1 >= 128;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-588340710"
	)
	@Export("readSmartByteShortIsaac")
	public int readSmartByteShortIsaac() {
		int var1 = super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
		return var1 < 128 ? var1 : (var1 - 128 << 8) + (super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "2009256610"
	)
	public void method5443(byte[] var1, int var2, int var3) {
		for (int var4 = 0; var4 < var3; ++var4) {
			var1[var4 + var2] = (byte)(super.array[++super.offset - 1] - this.isaacCipher.nextInt());
		}

	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1671880174"
	)
	@Export("importIndex")
	public void importIndex() {
		this.bitIndex = super.offset * 8;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-1296046831"
	)
	@Export("readBits")
	public int readBits(int var1) {
		int var2 = this.bitIndex >> 3;
		int var3 = 8 - (this.bitIndex & 7);
		int var4 = 0;

		for (this.bitIndex += var1; var1 > var3; var3 = 8) {
			var4 += (super.array[var2++] & field3724[var3]) << var1 - var3;
			var1 -= var3;
		}

		if (var3 == var1) {
			var4 += super.array[var2] & field3724[var3];
		} else {
			var4 += super.array[var2] >> var3 - var1 & field3724[var1];
		}

		return var4;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-100"
	)
	@Export("exportIndex")
	public void exportIndex() {
		super.offset = (this.bitIndex + 7) / 8;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IS)I",
		garbageValue = "4225"
	)
	@Export("bitsRemaining")
	public int bitsRemaining(int var1) {
		return var1 * 8 - this.bitIndex;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhp;III)Llx;",
		garbageValue = "-1232611828"
	)
	static IndexedSprite method5474(AbstractArchive var0, int var1, int var2) {
		if (!Friend.SpriteBuffer_loadSprite(var0, var1, var2)) {
			return null;
		} else {
			IndexedSprite var4 = new IndexedSprite();
			var4.width = class326.SpriteBuffer_spriteWidth;
			var4.height = class326.SpriteBuffer_spriteHeight;
			var4.xOffset = Varps.SpriteBuffer_xOffsets[0];
			var4.yOffset = class326.SpriteBuffer_yOffsets[0];
			var4.subWidth = class326.SpriteBuffer_spriteWidths[0];
			var4.subHeight = class216.SpriteBuffer_spriteHeights[0];
			var4.palette = Frames.SpriteBuffer_spritePalette;
			var4.pixels = class326.SpriteBuffer_pixels[0];
			class16.method174();
			return var4;
		}
	}
}
