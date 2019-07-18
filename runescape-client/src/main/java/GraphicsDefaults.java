import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -598930279
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -996722769
	)
	public int field3823;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1830782467
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 2115046595
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1511309833
	)
	public int field3830;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1434571323
	)
	public int field3827;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -385142187
	)
	public int field3828;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 326746637
	)
	public int field3829;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1387311669
	)
	public int field3832;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1775888463
	)
	public int field3831;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 347558277
	)
	public int field3822;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3823 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3830 = -1;
		this.field3827 = -1;
		this.field3828 = -1;
		this.field3829 = -1;
		this.field3832 = -1;
		this.field3831 = -1;
		this.field3822 = -1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;B)V",
		garbageValue = "104"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3821.group);
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
				this.compass = var3.method5511();
				this.field3823 = var3.method5511();
				this.mapScenes = var3.method5511();
				this.headIconsPk = var3.method5511();
				this.field3830 = var3.method5511();
				this.field3827 = var3.method5511();
				this.field3828 = var3.method5511();
				this.field3829 = var3.method5511();
				this.field3832 = var3.method5511();
				this.field3831 = var3.method5511();
				this.field3822 = var3.method5511();
			}
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-122"
	)
	@Export("getWorldMapScriptIdCategory")
	public static int getWorldMapScriptIdCategory(int var0, int var1) {
		return var1 + (var0 + 40000 << 8);
	}
}
