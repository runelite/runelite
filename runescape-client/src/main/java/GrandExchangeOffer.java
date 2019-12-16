import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1279002911
	)
	@Export("musicTrackFileId")
	static int musicTrackFileId;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field64;
	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("fontBold12")
	static Font fontBold12;
	@ObfuscatedName("f")
	@Export("state")
	byte state;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 903381877
	)
	@Export("id")
	public int id;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1525595903
	)
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -181305079
	)
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1020605845
	)
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 824366687
	)
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		signature = "(Lkq;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-519143415"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1944649855"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-26019402"
	)
	void method99(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1969903695"
	)
	void method100(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2077652257"
	)
	static final void method114(int var0, int var1, int var2, int var3) {
		for (int var4 = var1; var4 <= var3 + var1; ++var4) {
			for (int var5 = var0; var5 <= var0 + var2; ++var5) {
				if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
					Tiles.field496[0][var5][var4] = 127;
					if (var0 == var5 && var5 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
					}

					if (var5 == var0 + var2 && var5 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
					}

					if (var4 == var1 && var4 > 0) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
					}

					if (var4 == var3 + var1 && var4 < 103) {
						Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
					}
				}
			}
		}

	}
}
