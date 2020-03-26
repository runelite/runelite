import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	static Bounds field2495;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgi;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljh;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Ldz;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		signature = "(Lgi;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(Lhz;[IIIIB)V",
		garbageValue = "56"
	)
	void method3992(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2428[var1.field2452] & 4) != 0 && var1.field2459 < 0) {
			int var6 = this.superStream.field2433[var1.field2452] / PcmPlayer.field1421;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2462) / var6;
				if (var7 > var4) {
					var1.field2462 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2462 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.field1421 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2431[var1.field2452] == 0) {
					var1.stream = RawPcmStream.method2685(var1.rawSound, var10.method2670(), var10.method2662(), var10.method2663());
				} else {
					var1.stream = RawPcmStream.method2685(var1.rawSound, var10.method2670(), 0, var10.method2663());
					this.superStream.method3852(var1, var1.patch.field2485[var1.field2464] < 0);
					var1.stream.method2666(var8, var10.method2662());
				}

				if (var1.patch.field2485[var1.field2464] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method2706(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method2672()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lhz;II)V",
		garbageValue = "2036025263"
	)
	void method3989(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2428[var1.field2452] & 4) != 0 && var1.field2459 < 0) {
			int var3 = this.superStream.field2433[var1.field2452] / PcmPlayer.field1421;
			int var4 = (var3 + 1048575 - var1.field2462) / var3;
			var1.field2462 = var3 * var2 + var1.field2462 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2431[var1.field2452] == 0) {
					var1.stream = RawPcmStream.method2685(var1.rawSound, var1.stream.method2670(), var1.stream.method2662(), var1.stream.method2663());
				} else {
					var1.stream = RawPcmStream.method2685(var1.rawSound, var1.stream.method2670(), 0, var1.stream.method2663());
					this.superStream.method3852(var1, var1.patch.field2485[var1.field2464] < 0);
				}

				if (var1.patch.field2485[var1.field2464] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2462 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
		if (var1 == null) {
			return null;
		} else {
			return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "()Lds;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		MusicPatchNode var1;
		do {
			var1 = (MusicPatchNode)this.queue.previous();
			if (var1 == null) {
				return null;
			}
		} while(var1.stream == null);

		return var1.stream;
	}

	@ObfuscatedName("z")
	protected int vmethod3984() {
		return 0;
	}

	@ObfuscatedName("t")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3826(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2453) {
						this.method3992(var6, var1, var4, var5, var4 + var5);
						var6.field2453 -= var5;
						break;
					}

					this.method3992(var6, var1, var4, var6.field2453, var4 + var5);
					var4 += var6.field2453;
					var5 -= var6.field2453;
				} while(!this.superStream.method3884(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("s")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method3826(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2453) {
						this.method3989(var3, var2);
						var3.field2453 -= var2;
						break;
					}

					this.method3989(var3, var3.field2453);
					var2 -= var3.field2453;
				} while(!this.superStream.method3884(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("fv")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1600061666"
	)
	static void method4004() {
		Client.mouseLastLastPressedTimeMillis = -1L;
		MidiPcmStream.mouseRecorder.index = 0;
		GameShell.hasFocus = true;
		Client.hadFocus = true;
		Client.field904 = -1L;
		class25.method277();
		Client.packetWriter.clearBuffer();
		Client.packetWriter.packetBuffer.offset = 0;
		Client.packetWriter.serverPacket = null;
		Client.packetWriter.field1334 = null;
		Client.packetWriter.field1329 = null;
		Client.packetWriter.field1339 = null;
		Client.packetWriter.serverPacketLength = 0;
		Client.packetWriter.field1338 = 0;
		Client.rebootTimer = 0;
		Client.logoutTimer = 0;
		Client.hintArrowType = 0;
		AbstractByteArrayCopier.method4023();
		ServerPacket.method3684(0);
		Interpreter.method2112();
		Client.isItemSelected = 0;
		Client.isSpellSelected = false;
		Client.soundEffectCount = 0;
		Client.camAngleY = 0;
		Client.oculusOrbState = 0;
		WorldMapRectangle.field222 = null;
		Client.minimapState = 0;
		Client.field695 = -1;
		Client.destinationX = 0;
		Client.destinationY = 0;
		Client.playerAttackOption = AttackOption.AttackOption_hidden;
		Client.npcAttackOption = AttackOption.AttackOption_hidden;
		Client.npcCount = 0;
		Player.method1383();

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
		Projectile.friendSystem.clear();

		for (var0 = 0; var0 < VarpDefinition.VarpDefinition_fileCount; ++var0) {
			VarpDefinition var3 = class228.VarpDefinition_get(var0);
			if (var3 != null) {
				Varps.Varps_temp[var0] = 0;
				Varps.Varps_main[var0] = 0;
			}
		}

		UserComparator4.varcs.clearTransient();
		Client.followerIndex = -1;
		if (Client.rootInterface != -1) {
			EnumDefinition.method4614(Client.rootInterface);
		}

		for (InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.first(); var4 != null; var4 = (InterfaceParent)Client.interfaceParents.next()) {
			class41.closeInterface(var4, true);
		}

		Client.rootInterface = -1;
		Client.interfaceParents = new NodeHashTable(8);
		Client.meslayerContinueWidget = null;
		AbstractByteArrayCopier.method4023();
		Client.playerAppearance.update((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

		for (var0 = 0; var0 < 8; ++var0) {
			Client.playerMenuActions[var0] = null;
			Client.playerOptionsPriorities[var0] = false;
		}

		ItemContainer.itemContainers = new NodeHashTable(32);
		Client.isLoading = true;

		for (var0 = 0; var0 < 100; ++var0) {
			Client.field679[var0] = true;
		}

		PacketBufferNode var5 = FaceNormal.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
		var5.packetBuffer.writeByte(class74.getWindowedMode());
		var5.packetBuffer.writeShort(WorldMapLabel.canvasWidth);
		var5.packetBuffer.writeShort(Varps.canvasHeight);
		Client.packetWriter.addNode(var5);
		InterfaceParent.clanChat = null;

		for (var0 = 0; var0 < 8; ++var0) {
			Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
		}

		GrandExchangeEvent.grandExchangeEvents = null;
	}
}
