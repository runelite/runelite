import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapSprite")
public final class WorldMapSprite {
	@ObfuscatedName("j")
	static String[] field219;
	@ObfuscatedName("ak")
	@Export("loginScreenFontMetrics")
	static FontMetrics loginScreenFontMetrics;
	@ObfuscatedName("i")
	@Export("tileColors")
	final int[] tileColors;

	WorldMapSprite() {
		this.tileColors = new int[4096];
	}

	WorldMapSprite(int[] var1) {
		this.tileColors = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "-1062686446"
	)
	@Export("getTileColor")
	final int getTileColor(int var1, int var2) {
		return this.tileColors[var1 + var2 * 64];
	}

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1175490871"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.field767) {
			Actor.method1755();
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && Client.musicVolume != 0 && !Client.field767) {
			class4.method59(2, GrandExchangeOfferWorldComparator.archive6, var0, 0, Client.musicVolume, false);
		}

		Client.currentTrackGroupId = var0;
	}

	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "(IIB)V",
		garbageValue = "-50"
	)
	static final void method408(int var0, int var1) {
		if (Client.hintArrowType == 2) {
			KeyHandler.worldToScreen((Client.hintArrowX - MusicPatchPcmStream.baseX * 64 << 7) + Client.hintArrowSubX * 4096, (Client.hintArrowY - ScriptEvent.baseY * 64 << 7) + Client.hintArrowSubY * 4096, Client.hintArrowHeight * 2);
			if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
				WorldMapData_0.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
			}

		}
	}
}
