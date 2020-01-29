import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gj")
public class class197 {
	@ObfuscatedName("og")
	@ObfuscatedSignature(
		signature = "Lcu;"
	)
	@Export("varcs")
	static Varcs varcs;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("musicPatchesArchive")
	static AbstractArchive musicPatchesArchive;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("musicSamplesArchive")
	static AbstractArchive musicSamplesArchive;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lgw;"
	)
	@Export("midiPcmStream")
	public static MidiPcmStream midiPcmStream;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1658116117
	)
	public static int field2414;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1762609869
	)
	@Export("musicTrackGroupId")
	public static int musicTrackGroupId;
	@ObfuscatedName("l")
	@Export("Widget_loadedInterfaces")
	static boolean[] Widget_loadedInterfaces;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lii;"
	)
	@Export("Widget_archive")
	static AbstractArchive Widget_archive;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -623019541
	)
	public static int field2412;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Ldv;"
	)
	@Export("soundCache")
	public static SoundCache soundCache;

	static {
		field2414 = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IIII)Lce;",
		garbageValue = "473257926"
	)
	@Export("getWorldMapScript")
	static Script getWorldMapScript(int var0, int var1, int var2) {
		int var3 = (var1 << 8) + var0;
		Script var5 = MilliClock.method3529(var3, var0);
		if (var5 != null) {
			return var5;
		} else {
			int var4 = class210.method4029(var2, var0);
			var5 = MilliClock.method3529(var4, var0);
			return var5 != null ? var5 : null;
		}
	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZI)V",
		garbageValue = "-802729568"
	)
	@Export("drawLoadingMessage")
	static final void drawLoadingMessage(String var0, boolean var1) {
		if (Client.showLoadingMessages) {
			byte var2 = 4;
			int var3 = var2 + 6;
			int var4 = var2 + 6;
			int var5 = class13.fontPlain12.lineWidth(var0, 250);
			int var6 = class13.fontPlain12.lineCount(var0, 250) * 13;
			Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
			Rasterizer2D.Rasterizer2D_drawRectangle(var3 - var2, var4 - var2, var2 + var2 + var5, var6 + var2 + var2, 16777215);
			class13.fontPlain12.drawLines(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
			int var7 = var3 - var2;
			int var8 = var4 - var2;
			int var9 = var2 + var5 + var2;
			int var10 = var6 + var2 + var2;

			int var11;
			for (var11 = 0; var11 < Client.rootWidgetCount; ++var11) {
				if (Client.rootWidgetXs[var11] + Client.rootWidgetWidths[var11] > var7 && Client.rootWidgetXs[var11] < var9 + var7 && Client.rootWidgetHeights[var11] + Client.rootWidgetYs[var11] > var8 && Client.rootWidgetYs[var11] < var8 + var10) {
					Client.field851[var11] = true;
				}
			}

			if (var1) {
				DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
			} else {
				var11 = var3;
				int var12 = var4;
				int var13 = var5;
				int var14 = var6;

				for (int var15 = 0; var15 < Client.rootWidgetCount; ++var15) {
					if (Client.rootWidgetXs[var15] + Client.rootWidgetWidths[var15] > var11 && Client.rootWidgetXs[var15] < var11 + var13 && Client.rootWidgetHeights[var15] + Client.rootWidgetYs[var15] > var12 && Client.rootWidgetYs[var15] < var14 + var12) {
						Client.field852[var15] = true;
					}
				}
			}

		}
	}
}
