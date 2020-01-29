import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("PlayerType")
public enum PlayerType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_normal")
	PlayerType_normal(0, -1, true, false, true),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_playerModerator")
	PlayerType_playerModerator(1, 0, true, true, true),
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_jagexModerator")
	PlayerType_jagexModerator(2, 1, true, true, false),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_ironman")
	PlayerType_ironman(3, 2, false, false, true),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_ultimateIronman")
	PlayerType_ultimateIronman(4, 3, false, false, true),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lhu;"
	)
	@Export("PlayerType_hardcoreIronman")
	PlayerType_hardcoreIronman(5, 10, false, false, true);

	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 82247459
	)
	@Export("id")
	final int id;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 583511619
	)
	@Export("modIcon")
	public final int modIcon;
	@ObfuscatedName("j")
	@Export("isPrivileged")
	public final boolean isPrivileged;
	@ObfuscatedName("m")
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
		signature = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BI)Laf;",
		garbageValue = "1601863224"
	)
	static WorldMapSprite method4204(byte[] var0) {
		return var0 == null ? new WorldMapSprite() : new WorldMapSprite(class14.convertJpgToSprite(var0).pixels);
	}
}
