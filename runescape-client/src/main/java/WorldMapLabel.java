import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
@Implements("WorldMapLabel")
public class WorldMapLabel {
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lal;"
	)
	@Export("worldMapEvent")
	static WorldMapEvent worldMapEvent;
	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "[Lls;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;
	@ObfuscatedName("f")
	@Export("text")
	String text;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1263751547
	)
	@Export("width")
	int width;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1391610407
	)
	@Export("height")
	int height;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lj;"
	)
	@Export("size")
	WorldMapLabelSize size;

	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;IILj;)V"
	)
	WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
		this.text = var1;
		this.width = var2;
		this.height = var3;
		this.size = var4;
	}

	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1562650127"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (NetSocket.pcmPlayer1 != null) {
			NetSocket.pcmPlayer1.run();
		}

		if (UserComparator6.pcmPlayer0 != null) {
			UserComparator6.pcmPlayer0.run();
		}

	}
}
