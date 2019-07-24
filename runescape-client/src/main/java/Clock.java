import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("Clock")
public abstract class Clock {
	@ObfuscatedName("oi")
	@ObfuscatedSignature(
		signature = "Lca;"
	)
	@Export("varcs")
	static Varcs varcs;

	Clock() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1402657312"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-333181863"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1434133306"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field868 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (AbstractWorldMapIcon.getWindowedMode() == 1) {
			WorldMapSprite.client.setMaxCanvasSize(765, 503);
		} else {
			WorldMapSprite.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			HealthBarUpdate.method1677();
		}

	}
}
