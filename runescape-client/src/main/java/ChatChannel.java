import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("fc")
	@ObfuscatedGetter(
		longValue = -181918079142719425L
	)
	static long field1319;
	@ObfuscatedName("go")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("compass")
	static Sprite compass;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "[Lby;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 1013484149
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lby;",
		garbageValue = "922420852"
	)
	@Export("addMessage")
	Message addMessage(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.remove();
			var5.removeDual();
			var5.set(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IB)Lby;",
		garbageValue = "49"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-2095560133"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-570972962"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "266221696"
	)
	static final void method2351() {
		GrandExchangeEvent.method165("You can't add yourself to your own ignore list");
	}

	@ObfuscatedName("fo")
	@ObfuscatedSignature(
		signature = "(IZZZB)Lih;",
		garbageValue = "109"
	)
	@Export("newArchive")
	static Archive newArchive(int var0, boolean var1, boolean var2, boolean var3) {
		ArchiveDisk var4 = null;
		if (JagexCache.JagexCache_dat2File != null) {
			var4 = new ArchiveDisk(var0, JagexCache.JagexCache_dat2File, PacketBufferNode.JagexCache_idxFiles[var0], 1000000);
		}

		return new Archive(var4, WorldMapRegion.masterDisk, var0, var1, var2, var3);
	}

	@ObfuscatedName("fn")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "48"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (AbstractWorldMapData.pcmPlayer1 != null) {
			AbstractWorldMapData.pcmPlayer1.run();
		}

		if (WorldMapManager.pcmPlayer0 != null) {
			WorldMapManager.pcmPlayer0.run();
		}

	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2027834560"
	)
	static void method2354() {
		for (int var0 = 0; var0 < Client.menuOptionsCount; ++var0) {
			if (WorldMapLabelSize.method282(Client.menuOpcodes[var0])) {
				if (var0 < Client.menuOptionsCount - 1) {
					for (int var1 = var0; var1 < Client.menuOptionsCount - 1; ++var1) {
						Client.menuActions[var1] = Client.menuActions[var1 + 1];
						Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
						Client.menuOpcodes[var1] = Client.menuOpcodes[var1 + 1];
						Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
						Client.menuArguments1[var1] = Client.menuArguments1[var1 + 1];
						Client.menuArguments2[var1] = Client.menuArguments2[var1 + 1];
						Client.menuShiftClick[var1] = Client.menuShiftClick[var1 + 1];
					}
				}

				--var0;
				--Client.menuOptionsCount;
			}
		}

		MusicPatchNode.method3922(class49.menuWidth / 2 + WorldMapDecoration.menuX, PacketBufferNode.menuY);
	}
}
