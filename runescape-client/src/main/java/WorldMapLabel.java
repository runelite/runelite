import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("gl")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;
	@ObfuscatedName("s")
	@Export("text")
	String text;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -100160843
	)
	@Export("width")
	int width;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1360429455
	)
	@Export("height")
	int height;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILe;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}
}
