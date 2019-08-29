import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1897745195
	)
	int field2437;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lgg;"
	)
	@Export("patch")
	MusicPatch patch;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lco;"
	)
	@Export("rawSound")
	RawSound rawSound;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lgf;"
	)
	MusicPatchNode2 field2422;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 1864243687
	)
	int field2423;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1872653771
	)
	int field2424;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1424781673
	)
	int field2425;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 923985799
	)
	int field2429;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1213046501
	)
	int field2426;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -322919449
	)
	int field2428;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1828519475
	)
	int field2440;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1131883179
	)
	int field2430;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -392347845
	)
	int field2431;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -610654257
	)
	int field2432;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -1442847957
	)
	int field2433;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1807257146
	)
	int field2434;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -1173270761
	)
	int field2435;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -549746549
	)
	int field2436;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Ldx;"
	)
	@Export("stream")
	RawPcmStream stream;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = 1101531435
	)
	int field2438;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 994945393
	)
	int field2439;

	MusicPatchNode() {
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "87"
	)
	void method3767() {
		this.patch = null;
		this.rawSound = null;
		this.field2422 = null;
		this.stream = null;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Lbw;I)V",
		garbageValue = "-313141068"
	)
	static void method3772(GameShell var0) {
		while (FontName.isKeyDown()) {
			if (ReflectionCheck.field1307 == 13) {
				class13.method163();
				return;
			}

			if (ReflectionCheck.field1307 == 96) {
				if (Login.worldSelectPage > 0 && AbstractWorldMapIcon.worldSelectLeftSprite != null) {
					--Login.worldSelectPage;
				}
			} else if (ReflectionCheck.field1307 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && ClanChat.worldSelectRightSprite != null) {
				++Login.worldSelectPage;
			}
		}

		if (MouseHandler.MouseHandler_lastButton == 1 || !FriendSystem.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
			int var1 = Login.xPadding + 280;
			if (MouseHandler.MouseHandler_lastPressedX >= var1 && MouseHandler.MouseHandler_lastPressedX <= var1 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(0, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var1 + 15 && MouseHandler.MouseHandler_lastPressedX <= var1 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(0, 1);
				return;
			}

			int var2 = Login.xPadding + 390;
			if (MouseHandler.MouseHandler_lastPressedX >= var2 && MouseHandler.MouseHandler_lastPressedX <= var2 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(1, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var2 + 15 && MouseHandler.MouseHandler_lastPressedX <= var2 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(1, 1);
				return;
			}

			int var3 = Login.xPadding + 500;
			if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(2, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(2, 1);
				return;
			}

			int var4 = Login.xPadding + 610;
			if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(3, 0);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
				class65.changeWorldSelectSorting(3, 1);
				return;
			}

			if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
				class13.method163();
				return;
			}

			if (Login.hoveredWorldIndex != -1) {
				World var5 = ChatChannel.World_worlds[Login.hoveredWorldIndex];
				class65.changeWorld(var5);
				class13.method163();
				return;
			}

			if (Login.worldSelectPage > 0 && AbstractWorldMapIcon.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= AbstractWorldMapIcon.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class30.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class30.canvasHeight / 2 + 50) {
				--Login.worldSelectPage;
			}

			if (Login.worldSelectPage < Login.worldSelectPagesCount && ClanChat.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= KitDefinition.canvasWidth - ClanChat.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= KitDefinition.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class30.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class30.canvasHeight / 2 + 50) {
				++Login.worldSelectPage;
			}
		}

	}

	@ObfuscatedName("gp")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1852337060"
	)
	static final void method3771(int var0, int var1, int var2, int var3) {
		Client.field737 = 0;
		int var4 = PacketWriter.baseX * 64 + (WorldMapIcon_1.localPlayer.x >> 7);
		int var5 = RouteStrategy.baseY * 64 + (WorldMapIcon_1.localPlayer.y >> 7);
		if (var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
			Client.field737 = 1;
		}

		if (var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
			Client.field737 = 1;
		}

		if (Client.field737 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
			Client.field737 = 0;
		}

	}
}
