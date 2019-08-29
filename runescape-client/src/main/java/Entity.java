import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("en")
@Implements("Entity")
public abstract class Entity extends DualNode {
	@ObfuscatedName("cn")
	@ObfuscatedGetter(
		intValue = 747190067
	)
	@Export("height")
	public int height;

	protected Entity() {
		this.height = 1000;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)Ldo;",
		garbageValue = "-419920513"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("cm")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([BZB)Ljava/lang/Object;",
		garbageValue = "42"
	)
	public static Object method3209(byte[] var0, boolean var1) {
		if (var0 == null) {
			return null;
		} else if (var0.length > 136) {
			DirectByteArrayCopier var2 = new DirectByteArrayCopier();
			var2.set(var0);
			return var2;
		} else {
			return var0;
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(DDII)[D",
		garbageValue = "-361048020"
	)
	public static double[] method3211(double var0, double var2, int var4) {
		int var5 = var4 * 2 + 1;
		double[] var6 = new double[var5];
		int var7 = -var4;

		for (int var8 = 0; var7 <= var4; ++var8) {
			var6[var8] = class195.method3623((double)var7, var0, var2);
			++var7;
		}

		return var6;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-1173626349"
	)
	static int method3210(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.LOGOUT) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(Lbu;II)V",
		garbageValue = "558636836"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		WorldMapAreaData.worldToScreen(var0.x, var0.y, var1);
	}
}
