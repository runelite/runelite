import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -2112004677
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -258294563
	)
	public int field3806;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 701602469
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -2141260483
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -479103763
	)
	public int field3805;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -556598901
	)
	public int field3802;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 885733673
	)
	public int field3798;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1784857591
	)
	public int field3804;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 2055927251
	)
	public int field3797;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1869072211
	)
	public int field3801;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1312425167
	)
	public int field3807;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3806 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3805 = -1;
		this.field3802 = -1;
		this.field3798 = -1;
		this.field3804 = -1;
		this.field3797 = -1;
		this.field3801 = -1;
		this.field3807 = -1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lhz;I)V",
		garbageValue = "-2074842335"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3794.group);
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
				this.compass = var3.method5602();
				this.field3806 = var3.method5602();
				this.mapScenes = var3.method5602();
				this.headIconsPk = var3.method5602();
				this.field3805 = var3.method5602();
				this.field3802 = var3.method5602();
				this.field3798 = var3.method5602();
				this.field3804 = var3.method5602();
				this.field3797 = var3.method5602();
				this.field3801 = var3.method5602();
				this.field3807 = var3.method5602();
			}
		}
	}
}
