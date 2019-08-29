import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
@Implements("UserComparator7")
public class UserComparator7 extends AbstractUserComparator {
	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("hk")
	@ObfuscatedGetter(
		intValue = -246677649
	)
	@Export("cameraZ")
	static int cameraZ;
	@ObfuscatedName("s")
	@Export("reversed")
	final boolean reversed;

	public UserComparator7(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljt;Ljt;I)I",
		garbageValue = "-601545219"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var1.world != 0 && var2.world != 0) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "2"
	)
	@Export("SpriteBuffer_clear")
	public static void SpriteBuffer_clear() {
		class325.SpriteBuffer_xOffsets = null;
		class325.SpriteBuffer_yOffsets = null;
		class325.SpriteBuffer_spriteWidths = null;
		class225.SpriteBuffer_spriteHeights = null;
		class325.SpriteBuffer_spritePalette = null;
		WorldMapSection1.SpriteBuffer_pixels = null;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
	)
	@Export("openWorldSelect")
	static void openWorldSelect() {
		if (class173.loadWorlds()) {
			Login.worldSelectOpen = true;
			Login.worldSelectPage = 0;
			Login.worldSelectPagesCount = 0;
		}

	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1359476152"
	)
	@Export("getWindowedMode")
	static int getWindowedMode() {
		return Client.isResizable ? 2 : 1;
	}
}
