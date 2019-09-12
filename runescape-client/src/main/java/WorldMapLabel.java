import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lio;"
	)
	@Export("archive14")
	static Archive archive14;
	@ObfuscatedName("c")
	@Export("text")
	String text;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1500544575
	)
	@Export("width")
	int width;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 654109137
	)
	@Export("height")
	int height;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lq;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILq;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "55939772"
	)
	static int method381(int var0) {
		return (int)((Math.log((double)var0) / Interpreter.field1070 - 7.0D) * 256.0D);
	}

	@ObfuscatedName("ju")
	@ObfuscatedSignature(
		signature = "(Lhy;I)Lhy;",
		garbageValue = "-658225047"
	)
	static Widget method382(Widget var0) {
		Widget var1 = FontName.method5290(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}
