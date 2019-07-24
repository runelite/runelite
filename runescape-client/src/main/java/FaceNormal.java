import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("v")
	static int[][][] field1887;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 2130535467
	)
	int field1889;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 522108407
	)
	int field1890;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1566565487
	)
	int field1888;

	FaceNormal() {
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Ljj;",
		garbageValue = "1137342160"
	)
	@Export("ClientParameter_values")
	public static ClientParameter[] ClientParameter_values() {
		return new ClientParameter[]{ClientParameter.field3593, ClientParameter.field3589, ClientParameter.field3594, ClientParameter.field3591, ClientParameter.field3600, ClientParameter.field3599, ClientParameter.field3592, ClientParameter.field3595, ClientParameter.field3585, ClientParameter.field3587, ClientParameter.field3582, ClientParameter.field3586, ClientParameter.field3581, ClientParameter.field3598, ClientParameter.field3590, ClientParameter.field3588, ClientParameter.field3584, ClientParameter.field3596, ClientParameter.field3583};
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;B)V",
		garbageValue = "-92"
	)
	@Export("setNpcDefinitionArchives")
	public static void setNpcDefinitionArchives(AbstractArchive var0, AbstractArchive var1) {
		NPCDefinition.NpcDefinition_archive = var0;
		NPCDefinition.NpcDefinition_modelArchive = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ZI)V",
		garbageValue = "-545171198"
	)
	static void method3266(boolean var0) {
		Login.Login_response1 = "";
		Login.Login_response2 = "Enter your username/email & password.";
		Login.Login_response3 = "";
		Login.loginIndex = 2;
		if (var0) {
			Login.Login_password = "";
		}

		class49.method815();
		if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
			Login.currentLoginField = 1;
		} else {
			Login.currentLoginField = 0;
		}

	}

	@ObfuscatedName("eh")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1702335616"
	)
	static void method3264() {
		Client.mouseLastLastPressedTimeMillis = 1L;
		class40.mouseRecorder.index = 0;
		class267.field3557 = true;
		Client.field667 = true;
		Client.field879 = -1L;
		class192.method3678();
		Client.packetWriter.method2218();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1309 = null;
		Client.packetWriter.field1321 = null;
		Client.packetWriter.field1317 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1318 = 0;
		Client.rebootTimer = 0;
		Client.field700 = 0;
		Client.hintArrowType = 0;
		Strings.method4121();
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
		PendingSpawn.field944 = null;
		Client.minimapState = 0;
		Client.field747 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		Players.Players_count = 0;

		int var0;
		for (var0 = 0; var0 < 2048; ++var0) {
			Players.field1254[var0] = null;
			Players.field1250[var0] = 1;
		}

		for (var0 = 0; var0 < 2048; ++var0) {
			Client.players[var0] = null;
		}

		for (var0 = 0; var0 < 32768; ++var0) {
			Client.npcs[var0] = null;
		}

		Client.combatTargetPlayerIndex = -1;
		Client.projectiles.clear();
		Client.graphicsObjects.clear();

		int var2;
		for (var0 = 0; var0 < 4; ++var0) {
			for (int var1 = 0; var1 < 104; ++var1) {
				for (var2 = 0; var2 < 104; ++var2) {
					Client.groundItems[var0][var1][var2] = null;
				}
			}
		}

		Client.pendingSpawns = new NodeDeque();
		ArchiveLoader.friendSystem.clear();

		for (var0 = 0; var0 < VarpDefinition.VarpDefinition_fileCount; ++var0) {
			VarpDefinition var3 = GrandExchangeOfferWorldComparator.method61(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		Clock.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			var0 = Client.rootInterface;
			if (var0 != -1 && ViewportMouse.loadedInterfaces[var0]) {
				Widget.Widget_archive.clearFilesGroup(var0);
				if (Widget.Widget_interfaceComponents[var0] != null) {
					boolean var5 = true;

					for (var2 = 0; var2 < Widget.Widget_interfaceComponents[var0].length; ++var2) {
						if (Widget.Widget_interfaceComponents[var0][var2] != null) {
							if (Widget.Widget_interfaceComponents[var0][var2].type != 2) {
								Widget.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var5 = false;
							}
						}
					}

					if (var5) {
						Widget.Widget_interfaceComponents[var0] = null;
					}

					ViewportMouse.loadedInterfaces[var0] = false;
				}
			}
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			class197.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.field850 = null;
		Strings.method4121();
		Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		ItemContainer.itemContainers = new NodeHashTable(32);
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field843[var0] = true;
		}

		HealthBarUpdate.method1677();
		DevicePcmPlayerProvider.clanChat = null;

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		PendingSpawn.grandExchangeEvents = null;
	}
}
