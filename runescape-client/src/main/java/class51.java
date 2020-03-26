import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class51 implements WorldMapSection {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("ItemDefinition_fontPlain11")
	public static Font ItemDefinition_fontPlain11;
	@ObfuscatedName("h")
	static int[][][] field404;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 575472127
	)
	int field398;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -1833803509
	)
	int field393;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1774846813
	)
	int field394;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1983880403
	)
	int field397;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -821206197
	)
	int field396;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1047570917
	)
	int field401;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -347542775
	)
	int field402;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -311502303
	)
	int field399;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -912860035
	)
	int field400;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1883208611
	)
	int field395;

	class51() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Las;I)V",
		garbageValue = "1890497148"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field396) {
			var1.regionLowX = this.field396;
		}

		if (var1.regionHighX < this.field396) {
			var1.regionHighX = this.field396;
		}

		if (var1.regionLowY > this.field401) {
			var1.regionLowY = this.field401;
		}

		if (var1.regionHighY < this.field401) {
			var1.regionHighY = this.field401;
		}

	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIII)Z",
		garbageValue = "-65934716"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field398 && var1 < this.field398 + this.field393) {
			return var2 >= (this.field394 << 6) + (this.field402 << 3) && var2 <= (this.field394 << 6) + (this.field402 << 3) + 7 && var3 >= (this.field397 << 6) + (this.field399 << 3) && var3 <= (this.field397 << 6) + (this.field399 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(III)Z",
		garbageValue = "-240937232"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field396 << 6) + (this.field400 << 3) && var1 <= (this.field396 << 6) + (this.field400 << 3) + 7 && var2 >= (this.field401 << 6) + (this.field395 << 3) && var2 <= (this.field401 << 6) + (this.field395 << 3) + 7;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(IIII)[I",
		garbageValue = "1656767825"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field396 * 64 - this.field394 * 64) + (this.field400 * 8 - this.field402 * 8), var3 + (this.field401 * 64 - this.field397 * 64) + (this.field395 * 8 - this.field399 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)Lhj;",
		garbageValue = "-226825052"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field394 * 64 - this.field396 * 64 + (this.field402 * 8 - this.field400 * 8) + var1;
			int var4 = var2 + (this.field397 * 64 - this.field401 * 64) + (this.field399 * 8 - this.field395 * 8);
			return new Coord(this.field398, var3, var4);
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkb;I)V",
		garbageValue = "-1393433755"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field398 = var1.readUnsignedByte();
		this.field393 = var1.readUnsignedByte();
		this.field394 = var1.readUnsignedShort();
		this.field402 = var1.readUnsignedByte();
		this.field397 = var1.readUnsignedShort();
		this.field399 = var1.readUnsignedByte();
		this.field396 = var1.readUnsignedShort();
		this.field400 = var1.readUnsignedByte();
		this.field401 = var1.readUnsignedShort();
		this.field395 = var1.readUnsignedByte();
		this.method876();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "211103794"
	)
	void method876() {
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)[Lgb;",
		garbageValue = "-1687776366"
	)
	static LoginPacket[] method895() {
		return new LoginPacket[]{LoginPacket.field2315, LoginPacket.field2313, LoginPacket.field2317, LoginPacket.field2319, LoginPacket.field2314, LoginPacket.field2311};
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lmf;"
	)
	@Export("newRunException")
	public static RunException newRunException(Throwable var0, String var1) {
		RunException var2;
		if (var0 instanceof RunException) {
			var2 = (RunException)var0;
			var2.message = var2.message + ' ' + var1;
		} else {
			var2 = new RunException(var0, var1);
		}

		return var2;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "([BI)V",
		garbageValue = "1515618060"
	)
	@Export("ByteArrayPool_release")
	public static synchronized void ByteArrayPool_release(byte[] var0) {
		if (var0.length == 100 && ByteArrayPool.ByteArrayPool_smallCount < 1000) {
			ByteArrayPool.ByteArrayPool_small[++ByteArrayPool.ByteArrayPool_smallCount - 1] = var0;
		} else if (var0.length == 5000 && ByteArrayPool.ByteArrayPool_mediumCount < 250) {
			ByteArrayPool.ByteArrayPool_medium[++ByteArrayPool.ByteArrayPool_mediumCount - 1] = var0;
		} else if (var0.length == 30000 && ByteArrayPool.ByteArrayPool_largeCount < 50) {
			ByteArrayPool.ByteArrayPool_large[++ByteArrayPool.ByteArrayPool_largeCount - 1] = var0;
		} else {
			if (ByteArrayPool.ByteArrayPool_arrays != null) {
				for (int var1 = 0; var1 < RunException.ByteArrayPool_alternativeSizes.length; ++var1) {
					if (var0.length == RunException.ByteArrayPool_alternativeSizes[var1] && ByteArrayPool.ByteArrayPool_altSizeArrayCounts[var1] < ByteArrayPool.ByteArrayPool_arrays[var1].length) {
						ByteArrayPool.ByteArrayPool_arrays[var1][ByteArrayPool.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
						return;
					}
				}
			}

		}
	}

	@ObfuscatedName("jc")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-24"
	)
	@Export("getTapToDrop")
	static boolean getTapToDrop() {
		return Client.tapToDrop;
	}
}
