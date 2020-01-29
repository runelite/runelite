import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("VertexNormal")
public class VertexNormal {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		longValue = 1130865268298434617L
	)
	static long field1752;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lli;"
	)
	static IndexedSprite field1753;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	@Export("NetCache_responseArchiveBuffer")
	public static Buffer NetCache_responseArchiveBuffer;
	@ObfuscatedName("gu")
	@ObfuscatedSignature(
		signature = "[Lli;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 707257177
	)
	@Export("x")
	int x;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1141720523
	)
	@Export("y")
	int y;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1695799799
	)
	@Export("z")
	int z;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1198697941
	)
	@Export("magnitude")
	int magnitude;

	VertexNormal() {
	}

	@ObfuscatedSignature(
		signature = "(Ldp;)V"
	)
	VertexNormal(VertexNormal var1) {
		this.x = var1.x;
		this.y = var1.y;
		this.z = var1.z;
		this.magnitude = var1.magnitude;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(II)J",
		garbageValue = "2082657015"
	)
	public static long method3063(int var0) {
		return ViewportMouse.ViewportMouse_entityTags[var0];
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1221286239"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field859 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (Friend.getWindowedMode() == 1) {
			Username.client.setMaxCanvasSize(765, 503);
		} else {
			Username.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			class238.method4415();
		}

	}
}
