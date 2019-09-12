import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("TilePaint")
public final class TilePaint {
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 569513587
	)
	@Export("swColor")
	int swColor;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1458777975
	)
	@Export("seColor")
	int seColor;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 658024941
	)
	@Export("neColor")
	int neColor;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -112567911
	)
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = 696861651
	)
	@Export("texture")
	int texture;
	@ObfuscatedName("u")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -130131907
	)
	@Export("rgb")
	int rgb;

	TilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("ee")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-55"
	)
	static void method3037() {
		Client.mouseLastLastPressedTimeMillis = 1L;
		ParamDefinition.mouseRecorder.index = 0;
		PendingSpawn.hasFocus = true;
		Client.hadFocus = true;
		Client.field750 = -1L;
		class51.method860();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1274 = null;
		Client.packetWriter.field1286 = null;
		Client.packetWriter.field1287 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1283 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		MouseHandler.MouseHandler_idleCycles = 0;
		Messages.Messages_channels.clear();
		Messages.Messages_hashTable.clear();
		Messages.Messages_queue.clear();
		Messages.Messages_count = 0;
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		MenuAction.field1133 = null;
		Client.minimapState = 0;
		Client.field848 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		Huffman.method3942();

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		for (var0 = 0; var0 < 32768; ++var0) {
			Client.npcs[var0] = null;
		}

		Client.combatTargetPlayerIndex = -1;
		Client.projectiles.clear();
		Client.graphicsObjects.clear();

		for (var0 = 0; var0 < 4; ++var0) {
			for (int var1 = 0; var1 < 104; ++var1) {
				for (int var2 = 0; var2 < 104; ++var2) {
					Client.groundItems[var0][var1][var2] = null;
				}
			}
		}

		Client.pendingSpawns = new NodeDeque();
		class218.friendSystem.clear();

		for (var0 = 0; var0 < CollisionMap.VarpDefinition_fileCount; ++var0) {
			VarpDefinition var3 = class30.method518(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		BoundaryObject.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			TileItemPile.method2728(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			StructDefinition.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		Client.menuOptionsCount = 0;
		Client.isMenuOpen = false;
		Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		class286.method5221();
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field827[var0] = true;
		}

		MouseRecorder.method1145();
		GrandExchangeOfferUnitPriceComparator.clanChat = null;

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		PacketWriter.grandExchangeEvents = null;
	}
}
