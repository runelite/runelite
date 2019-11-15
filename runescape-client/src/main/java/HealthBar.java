import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("HealthBar")
public class HealthBar extends Node {
	@ObfuscatedName("v")
	@Export("SpriteBuffer_yOffsets")
	public static int[] SpriteBuffer_yOffsets;
	@ObfuscatedName("fj")
	@ObfuscatedGetter(
		intValue = 1157381415
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lil;"
	)
	@Export("definition")
	HealthBarDefinition definition;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("updates")
	IterableNodeDeque updates;

	@ObfuscatedSignature(
		signature = "(Lil;)V"
	)
	HealthBar(HealthBarDefinition var1) {
		this.updates = new IterableNodeDeque();
		this.definition = var1;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "703172784"
	)
	@Export("put")
	void put(int var1, int var2, int var3, int var4) {
		HealthBarUpdate var5 = null;
		int var6 = 0;

		for (HealthBarUpdate var7 = (HealthBarUpdate)this.updates.last(); var7 != null; var7 = (HealthBarUpdate)this.updates.previous()) {
			++var6;
			if (var7.cycle == var1) {
				var7.set(var1, var2, var3, var4);
				return;
			}

			if (var7.cycle <= var1) {
				var5 = var7;
			}
		}

		if (var5 == null) {
			if (var6 < 4) {
				this.updates.addLast(new HealthBarUpdate(var1, var2, var3, var4));
			}

		} else {
			IterableNodeDeque.IterableNodeDeque_addBefore(new HealthBarUpdate(var1, var2, var3, var4), var5);
			if (var6 >= 4) {
				this.updates.last().remove();
			}

		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lbo;",
		garbageValue = "1147155972"
	)
	@Export("get")
	HealthBarUpdate get(int var1) {
		HealthBarUpdate var2 = (HealthBarUpdate)this.updates.last();
		if (var2 != null && var2.cycle <= var1) {
			for (HealthBarUpdate var3 = (HealthBarUpdate)this.updates.previous(); var3 != null && var3.cycle <= var1; var3 = (HealthBarUpdate)this.updates.previous()) {
				var2.remove();
				var2 = var3;
			}

			if (this.definition.int5 + var2.cycleOffset + var2.cycle > var1) {
				return var2;
			} else {
				var2.remove();
				return null;
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "-47"
	)
	@Export("isEmpty")
	boolean isEmpty() {
		return this.updates.method5004();
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2136910933"
	)
	protected static final void method2161() {
		GameShell.clock.mark();

		int var0;
		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.graphicsTickTimes[var0] = 0L;
		}

		for (var0 = 0; var0 < 32; ++var0) {
			GameShell.clientTickTimes[var0] = 0L;
		}

		ArchiveLoader.gameCyclesToDo = 0;
	}
}
