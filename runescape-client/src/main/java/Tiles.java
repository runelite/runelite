import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("Tiles")
public final class Tiles {
	@ObfuscatedName("u")
	@Export("Tiles_heights")
	static int[][][] Tiles_heights;
	@ObfuscatedName("f")
	@Export("Tiles_renderFlags")
	static byte[][][] Tiles_renderFlags;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -777969823
	)
	@Export("Tiles_minPlane")
	static int Tiles_minPlane;
	@ObfuscatedName("g")
	static byte[][][] field498;
	@ObfuscatedName("z")
	static byte[][][] field499;
	@ObfuscatedName("p")
	static byte[][][] field500;
	@ObfuscatedName("h")
	static byte[][][] field501;
	@ObfuscatedName("i")
	@Export("Tiles_hue")
	static int[] Tiles_hue;
	@ObfuscatedName("k")
	@Export("Tiles_saturation")
	static int[] Tiles_saturation;
	@ObfuscatedName("x")
	@Export("Tiles_lightness")
	static int[] Tiles_lightness;
	@ObfuscatedName("d")
	static final int[] field505;
	@ObfuscatedName("s")
	static final int[] field506;
	@ObfuscatedName("t")
	static final int[] field507;
	@ObfuscatedName("m")
	static final int[] field508;
	@ObfuscatedName("v")
	static final int[] field509;
	@ObfuscatedName("q")
	static final int[] field513;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 1093475595
	)
	static int field511;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = 1317954869
	)
	static int field503;
	@ObfuscatedName("li")
	@ObfuscatedSignature(
		signature = "Lcg;"
	)
	@Export("tempMenuAction")
	static MenuAction tempMenuAction;

	static {
		Tiles_heights = new int[4][105][105];
		Tiles_renderFlags = new byte[4][104][104];
		Tiles_minPlane = 99;
		field505 = new int[]{1, 2, 4, 8};
		field506 = new int[]{16, 32, 64, 128};
		field507 = new int[]{1, 0, -1, 0};
		field508 = new int[]{0, -1, 0, 1};
		field509 = new int[]{1, -1, -1, 1};
		field513 = new int[]{-1, -1, 1, 1};
		field511 = (int)(Math.random() * 17.0D) - 8;
		field503 = (int)(Math.random() * 33.0D) - 16;
	}

	@ObfuscatedName("fs")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1584331485"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (class60.pcmPlayer1 != null) {
			class60.pcmPlayer1.run();
		}

		if (MenuAction.pcmPlayer0 != null) {
			MenuAction.pcmPlayer0.run();
		}

	}

	@ObfuscatedName("gc")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1685874862"
	)
	static void method1161() {
		if (Client.renderSelf) {
			Varcs.addPlayerToScene(class215.localPlayer, false);
		}

	}

	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2106789037"
	)
	static void method1160() {
		int var0 = Players.Players_count;
		int[] var1 = Players.Players_indices;

		for (int var2 = 0; var2 < var0; ++var2) {
			if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
				Varcs.addPlayerToScene(Client.players[var1[var2]], true);
			}
		}

	}
}
