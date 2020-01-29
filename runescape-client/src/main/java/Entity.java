import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Entity")
public abstract class Entity extends DualNode {
	@ObfuscatedName("nj")
	@ObfuscatedSignature(
		signature = "[Lhn;"
	)
	static Widget[] field1866;
	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("compass")
	static Sprite compass;
	@ObfuscatedName("cy")
	@ObfuscatedGetter(
		intValue = -384609857
	)
	@Export("height")
	public int height;

	protected Entity() {
		this.height = 1000;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Ldx;",
		garbageValue = "-2133076860"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("cn")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-553494705"
	)
	static final void method3332() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			Player var3 = Client.players[var1[var2]];
			if (var3 != null) {
				ScriptFrame.updateActorSequence(var3, 1);
			}
		}

	}
}
