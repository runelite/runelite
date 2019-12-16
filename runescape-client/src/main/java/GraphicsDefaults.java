import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1707006757
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 990004197
	)
	public int field3803;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1541922539
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1405131859
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1085795545
	)
	public int field3798;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1754657277
	)
	public int field3807;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -939471917
	)
	public int field3804;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -773091265
	)
	public int field3805;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -1993061967
	)
	public int field3806;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1849016603
	)
	public int field3799;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 735486601
	)
	public int field3808;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3803 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3798 = -1;
		this.field3807 = -1;
		this.field3804 = -1;
		this.field3805 = -1;
		this.field3806 = -1;
		this.field3799 = -1;
		this.field3808 = -1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lhz;B)V",
		garbageValue = "-29"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3796.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch(var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.method5560();
				this.field3803 = var3.method5560();
				this.mapScenes = var3.method5560();
				this.headIconsPk = var3.method5560();
				this.field3798 = var3.method5560();
				this.field3807 = var3.method5560();
				this.field3804 = var3.method5560();
				this.field3805 = var3.method5560();
				this.field3806 = var3.method5560();
				this.field3799 = var3.method5560();
				this.field3808 = var3.method5560();
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "([BB)V",
		garbageValue = "-116"
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
				for (int var1 = 0; var1 < ByteArrayPool.ByteArrayPool_alternativeSizes.length; ++var1) {
					if (var0.length == ByteArrayPool.ByteArrayPool_alternativeSizes[var1] && Interpreter.ByteArrayPool_altSizeArrayCounts[var1] < ByteArrayPool.ByteArrayPool_arrays[var1].length) {
						ByteArrayPool.ByteArrayPool_arrays[var1][Interpreter.ByteArrayPool_altSizeArrayCounts[var1]++] = var0;
						return;
					}
				}
			}

		}
	}
}
