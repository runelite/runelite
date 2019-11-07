import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("kb")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 355639221
	)
	@Export("compass")
	public int compass;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1345037469
	)
	public int field3787;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1267920099
	)
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1711317783
	)
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 1346521291
	)
	public int field3790;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 850710053
	)
	public int field3786;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 258806615
	)
	public int field3791;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1735079565
	)
	public int field3793;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 579452143
	)
	public int field3794;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 942987761
	)
	public int field3795;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2075865955
	)
	public int field3796;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3787 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3790 = -1;
		this.field3786 = -1;
		this.field3791 = -1;
		this.field3793 = -1;
		this.field3794 = -1;
		this.field3795 = -1;
		this.field3796 = -1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;I)V",
		garbageValue = "-1902520988"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3785.group);
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
				this.compass = var3.method5638();
				this.field3787 = var3.method5638();
				this.mapScenes = var3.method5638();
				this.headIconsPk = var3.method5638();
				this.field3790 = var3.method5638();
				this.field3786 = var3.method5638();
				this.field3791 = var3.method5638();
				this.field3793 = var3.method5638();
				this.field3794 = var3.method5638();
				this.field3795 = var3.method5638();
				this.field3796 = var3.method5638();
			}
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "1720763557"
	)
	static int method6006(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}
}
