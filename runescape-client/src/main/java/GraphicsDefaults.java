import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 576730349
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 262749653
	)
	public int field3808;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1408165655
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -951498167
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 62857473
	)
	public int field3799;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1864495415
	)
	public int field3804;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1605363745
	)
	public int field3805;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -177407337
	)
	public int field3806;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -410491181
	)
	public int field3807;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -270590657
	)
	public int field3800;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 838114045
	)
	public int field3809;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3808 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3799 = -1;
		this.field3804 = -1;
		this.field3805 = -1;
		this.field3806 = -1;
		this.field3807 = -1;
		this.field3800 = -1;
		this.field3809 = -1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhf;B)V",
		garbageValue = "16"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3797.group);
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
				this.compass = var3.method5618();
				this.field3808 = var3.method5618();
				this.mapScenes = var3.method5618();
				this.headIconsPk = var3.method5618();
				this.field3799 = var3.method5618();
				this.field3804 = var3.method5618();
				this.field3805 = var3.method5618();
				this.field3806 = var3.method5618();
				this.field3807 = var3.method5618();
				this.field3800 = var3.method5618();
				this.field3809 = var3.method5618();
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lhf;Ljava/lang/String;Ljava/lang/String;I)[Lln;",
		garbageValue = "-1956835175"
	)
	public static Sprite[] method5997(AbstractArchive var0, String var1, String var2) {
		int var3 = var0.getGroupId(var1);
		int var4 = var0.getFileId(var3, var2);
		return UserComparator5.SpriteBuffer_getSpriteArray(var0, var3, var4);
	}
}
