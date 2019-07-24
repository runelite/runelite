import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_normal")
	PlayerType_normal(0, -1, true, false, true),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_playerModerator")
	PlayerType_playerModerator(1, 0, true, true, true),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_jagexModerator")
	PlayerType_jagexModerator(2, 1, true, true, false),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_ironman")
	PlayerType_ironman(3, 2, false, false, true),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_ultimateIronman")
	PlayerType_ultimateIronman(4, 3, false, false, true),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhn;"
	)
	@Export("PlayerType_hardcoreIronman")
	PlayerType_hardcoreIronman(5, 10, false, false, true);

	@ObfuscatedName("n")
	@Export("userHomeDirectory")
	static String userHomeDirectory;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 942937123
	)
	@Export("id")
	final int id;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -477607547
	)
	@Export("modIcon")
	public final int modIcon;
	@ObfuscatedName("c")
	@Export("isPrivileged")
	public final boolean isPrivileged;
	@ObfuscatedName("f")
	@Export("isUser")
	public final boolean isUser;

	PlayerType(int var3, int var4, boolean var5, boolean var6, boolean var7) {
		this.id = var3;
		this.modIcon = var4;
		this.isPrivileged = var6;
		this.isUser = var7;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "320353268"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IIIS)Lly;",
		garbageValue = "-4698"
	)
	@Export("getWorldMapRegionCachedSprite")
	static Sprite getWorldMapRegionCachedSprite(int var0, int var1, int var2) {
		return (Sprite)WorldMapRegion.WorldMapRegion_cachedSprites.get(Widget.getWorldMapSpriteHash(var0, var1, var2));
	}
}
