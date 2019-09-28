import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("AttackOption_leftClickWhereAvailable")
	AttackOption_leftClickWhereAvailable(2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lcn;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3);

	@ObfuscatedName("dw")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive9")
	static Archive archive9;
	@ObfuscatedName("gr")
	@ObfuscatedSignature(
		signature = "Llf;"
	)
	@Export("compass")
	static Sprite compass;
	@ObfuscatedName("lc")
	@ObfuscatedGetter(
		intValue = 629841565
	)
	@Export("selectedSpellWidget")
	static int selectedSpellWidget;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1814915457
	)
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(S)I",
		garbageValue = "221"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "639446581"
	)
	static SecureRandom method2081() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-379415067"
	)
	@Export("updatePlayer")
	static final void updatePlayer(PacketBuffer var0) {
		var0.importIndex();
		int var1 = Client.localPlayerIndex;
		Player var2 = class223.localPlayer = Client.players[var1] = new Player();
		var2.index = var1;
		int var3 = var0.readBits(30);
		byte var4 = (byte)(var3 >> 28);
		int var5 = var3 >> 14 & 16383;
		int var6 = var3 & 16383;
		var2.pathX[0] = var5 - class223.baseX * 64;
		var2.x = (var2.pathX[0] << 7) + (var2.transformedSize() << 6);
		var2.pathY[0] = var6 - class286.baseY * 64;
		var2.y = (var2.pathY[0] << 7) + (var2.transformedSize() << 6);
		WorldMapRectangle.plane = var2.plane = var4;
		if (Players.field1236[var1] != null) {
			var2.read(Players.field1236[var1]);
		}

		Players.Players_count = 0;
		Players.Players_indices[++Players.Players_count - 1] = var1;
		Players.field1244[var1] = 0;
		Players.Players_emptyIdxCount = 0;

		for (int var7 = 1; var7 < 2048; ++var7) {
			if (var1 != var7) {
				int var8 = var0.readBits(18);
				int var9 = var8 >> 16;
				int var10 = var8 >> 8 & 597;
				int var11 = var8 & 597;
				Players.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
				Players.Players_orientations[var7] = 0;
				Players.Players_targetIndices[var7] = -1;
				Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var7;
				Players.field1244[var7] = 0;
			}
		}

		var0.exportIndex();
	}

	@ObfuscatedName("ed")
	@ObfuscatedSignature(
		signature = "(IZZZI)Lie;",
		garbageValue = "1568056482"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, class189.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, WorldMapData_0.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("hj")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
		garbageValue = "844579626"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuShiftClick[Client.menuOptionsCount] = var6;
				++Client.menuOptionsCount;
			}

		}
	}
}
