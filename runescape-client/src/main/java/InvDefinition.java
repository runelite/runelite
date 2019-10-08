import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("InvDefinition")
public class InvDefinition extends DualNode {
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("InvDefinition_archive")
	static AbstractArchive InvDefinition_archive;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lem;"
	)
	@Export("InvDefinition_cached")
	static EvictingDualNodeHashTable InvDefinition_cached;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1122330625
	)
	@Export("size")
	public int size;

	static {
		InvDefinition_cached = new EvictingDualNodeHashTable(64);
	}

	InvDefinition() {
		this.size = 0;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lkl;I)V",
		garbageValue = "1971272201"
	)
	@Export("decode")
	void decode(Buffer var1) {
		while (true) {
			int var2 = var1.readUnsignedByte();
			if (var2 == 0) {
				return;
			}

			this.decodeNext(var1, var2);
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lkl;II)V",
		garbageValue = "-57582576"
	)
	@Export("decodeNext")
	void decodeNext(Buffer var1, int var2) {
		if (var2 == 2) {
			this.size = var1.readUnsignedShort();
		}

	}

	@ObfuscatedName("hm")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1826014571"
	)
	@Export("menuAction")
	static final void menuAction(int param0, int param1, int opcode, int id, String option, String target, int var6, int var7) {
		if (opcode >= 2000) {
			opcode -= 2000;
		}

		if (opcode == 1) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(class223.baseX * 64 + param0);
			var8.packetBuffer.writeShort(class286.baseY * 64 + param1);
			var8.packetBuffer.writeIntME(AbstractWorldMapData.selectedItemId);
			var8.packetBuffer.method5630(class2.selectedItemWidget);
			var8.packetBuffer.writeShort(DevicePcmPlayerProvider.selectedItemSlot);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2252, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(AttackOption.selectedSpellWidget);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(class286.baseY * 64 + param1);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.writeShort(class223.baseX * 64 + param0);
			var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			var8.packetBuffer.writeShortLE(class223.baseX * 64 + param0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.writeShort(class223.baseX * 64 + param0);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.writeIntME(class223.baseX * 64 + param0);
			var8.packetBuffer.writeShortLE(class286.baseY * 64 + param1);
			var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(class223.baseX * 64 + param0);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(id);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 7) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2195, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntLE16(class2.selectedItemWidget);
				var9.packetBuffer.writeShortLE(AbstractWorldMapData.selectedItemId);
				var9.packetBuffer.writeIntME(id);
				var9.packetBuffer.writeShortLE(DevicePcmPlayerProvider.selectedItemSlot);
				var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 8) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5476(Client.selectedSpellChildIndex);
				var9.packetBuffer.method5476(id);
				var9.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 9) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 10) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2280, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeIntME(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 11) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2219, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 12) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2263, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 13) {
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 14) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(id);
				var9.packetBuffer.method5630(class2.selectedItemWidget);
				var9.packetBuffer.writeShort(AbstractWorldMapData.selectedItemId);
				var9.packetBuffer.method5476(DevicePcmPlayerProvider.selectedItemSlot);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 15) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5476(id);
				var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5489(AttackOption.selectedSpellWidget);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 16) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2197, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.writeInt(class2.selectedItemWidget);
			var8.packetBuffer.writeIntME(DevicePcmPlayerProvider.selectedItemSlot);
			var8.packetBuffer.writeShortLE(class286.baseY * 64 + param1);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(class223.baseX * 64 + param0);
			var8.packetBuffer.writeIntME(AbstractWorldMapData.selectedItemId);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 17) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			var8.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
			var8.packetBuffer.method5476(class223.baseX * 64 + param0);
			var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 18) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5476(class286.baseY * 64 + param1);
			var8.packetBuffer.writeIntME(class223.baseX * 64 + param0);
			var8.packetBuffer.writeShortLE(id);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 19) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2205, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntME(class223.baseX * 64 + param0);
			var8.packetBuffer.writeIntME(id);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 20) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(class223.baseX * 64 + param0);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			var8.packetBuffer.method5476(id);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 21) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(class223.baseX * 64 + param0);
			var8.packetBuffer.writeIntME(class286.baseY * 64 + param1);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(id);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 22) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2192, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(class223.baseX * 64 + param0);
			var8.packetBuffer.method5476(class286.baseY * 64 + param1);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 23) {
			if (Client.isMenuOpen) {
				PacketWriter.scene.setViewportWalking();
			} else {
				PacketWriter.scene.menuOpen(WorldMapRectangle.plane, param0, param1, true);
			}
		} else if (opcode == 24) {
			Widget var16 = Canvas.getWidget(param1);
			boolean var11 = true;
			if (var16.contentType > 0) {
				var11 = class43.method840(var16);
			}

			if (var11) {
				PacketBufferNode var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(param1);
				Client.packetWriter.addNode(var10);
			}
		} else if (opcode == 25) {
			Widget var16 = GrandExchangeOfferWorldComparator.getWidgetChild(param1, param0);
			if (var16 != null) {
				class208.Widget_runOnTargetLeave();
				class32.selectSpell(param1, param0, class2.method30(class2.getWidgetClickMask(var16)), var16.itemId);
				Client.isItemSelected = 0;
				Client.selectedSpellActionName = VerticalAlignment.method4321(var16);
				if (Client.selectedSpellActionName == null) {
					Client.selectedSpellActionName = "null";
				}

				if (var16.isIf3) {
					Client.selectedSpellName = var16.dataText + World.colorStartTag(16777215);
				} else {
					Client.selectedSpellName = World.colorStartTag(65280) + var16.spellName + World.colorStartTag(16777215);
				}
			}

			return;
		} else if (opcode == 26) {
			class51.method922();
		} else if (opcode == 28) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(param1);
			Client.packetWriter.addNode(var8);
			Widget var14 = Canvas.getWidget(param1);
			if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
				int var12 = var14.cs1Instructions[0][1];
				Varps.Varps_main[var12] = 1 - Varps.Varps_main[var12];
				NetSocket.method3472(var12);
			}
		} else if (opcode == 29) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(param1);
			Client.packetWriter.addNode(var8);
			Widget var14 = Canvas.getWidget(param1);
			if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
				int var12 = var14.cs1Instructions[0][1];
				if (Varps.Varps_main[var12] != var14.cs1ComparisonValues[0]) {
					Varps.Varps_main[var12] = var14.cs1ComparisonValues[0];
					NetSocket.method3472(var12);
				}
			}
		} else if (opcode == 30) {
			if (Client.meslayerContinueWidget == null) {
				Clock.resumePauseWidget(param1, param0);
				Client.meslayerContinueWidget = GrandExchangeOfferWorldComparator.getWidgetChild(param1, param0);
				WorldMapSectionType.invalidateWidget(Client.meslayerContinueWidget);
			}
		} else if (opcode == 31) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5630(param1);
			var8.packetBuffer.writeShortLE(DevicePcmPlayerProvider.selectedItemSlot);
			var8.packetBuffer.writeInt(class2.selectedItemWidget);
			var8.packetBuffer.writeShort(AbstractWorldMapData.selectedItemId);
			var8.packetBuffer.writeShort(param0);
			var8.packetBuffer.writeShort(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 32) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
			var8.packetBuffer.method5476(param0);
			var8.packetBuffer.method5476(id);
			var8.packetBuffer.method5630(param1);
			var8.packetBuffer.method5489(AttackOption.selectedSpellWidget);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 33) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(param1);
			var8.packetBuffer.method5476(param0);
			var8.packetBuffer.method5476(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 34) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(param1);
			var8.packetBuffer.method5476(param0);
			var8.packetBuffer.writeIntME(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 35) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2189, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(id);
			var8.packetBuffer.writeIntLE16(param1);
			var8.packetBuffer.writeShort(param0);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 36) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2198, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(id);
			var8.packetBuffer.method5476(param0);
			var8.packetBuffer.method5630(param1);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 37) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(param0);
			var8.packetBuffer.method5630(param1);
			var8.packetBuffer.writeIntME(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 38) {
			class208.Widget_runOnTargetLeave();
			Widget var16 = Canvas.getWidget(param1);
			Client.isItemSelected = 1;
			DevicePcmPlayerProvider.selectedItemSlot = param0;
			class2.selectedItemWidget = param1;
			AbstractWorldMapData.selectedItemId = id;
			WorldMapSectionType.invalidateWidget(var16);
			Client.selectedItemName = World.colorStartTag(16748608) + Occluder.ItemDefinition_get(id).name + World.colorStartTag(16777215);
			if (Client.selectedItemName == null) {
				Client.selectedItemName = "null";
			}

			return;
		} else if (opcode == 39) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(param0);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.method5489(param1);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 40) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5630(param1);
			var8.packetBuffer.writeIntME(param0);
			var8.packetBuffer.writeShortLE(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 41) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(param0);
			var8.packetBuffer.method5489(param1);
			var8.packetBuffer.method5476(id);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 42) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.writeShort(param0);
			var8.packetBuffer.method5630(param1);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 43) {
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.method5489(param1);
			var8.packetBuffer.writeShort(param0);
			Client.packetWriter.addNode(var8);
			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 44) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntME(id);
				var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 45) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(id);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 46) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5461(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 47) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(id);
				var9.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 48) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5468(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5476(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 49) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(id);
				var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 50) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5476(id);
				var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 51) {
			Player var15 = Client.players[id];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = param0;
				Client.destinationY = param1;
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeIntME(id);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 57) {
			Widget var16 = GrandExchangeOfferWorldComparator.getWidgetChild(param1, param0);
			if (var16 != null) {
				WorldMapSection1.widgetDefaultMenuAction(id, param1, param0, var16.itemId, target);
			}
		} else if (opcode == 58) {
			Widget var16 = GrandExchangeOfferWorldComparator.getWidgetChild(param1, param0);
			if (var16 != null) {
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5630(param1);
				var9.packetBuffer.writeShort(var16.itemId);
				var9.packetBuffer.writeIntLE16(AttackOption.selectedSpellWidget);
				var9.packetBuffer.writeShortLE(param0);
				var9.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
				var9.packetBuffer.writeIntME(Client.field793);
				Client.packetWriter.addNode(var9);
			}
		} else if (opcode == 1001) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = param0;
			Client.destinationY = param1;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2234, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(class286.baseY * 64 + param1);
			var8.packetBuffer.writeShort(class223.baseX * 64 + param0);
			var8.packetBuffer.writeShort(id);
			var8.packetBuffer.method5467(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 1002) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2220, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5476(id);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 1003) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			NPC var13 = Client.npcs[id];
			if (var13 != null) {
				NPCDefinition var17 = var13.definition;
				if (var17.transforms != null) {
					var17 = var17.transform();
				}

				if (var17 != null) {
					PacketBufferNode var10 = InterfaceParent.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
					var10.packetBuffer.writeIntME(var17.id);
					Client.packetWriter.addNode(var10);
				}
			}
		} else if (opcode == 1004) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			PacketBufferNode var8 = InterfaceParent.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(id);
			Client.packetWriter.addNode(var8);
		} else if (opcode == 1005) {
			Widget var16 = Canvas.getWidget(param1);
			if (var16 != null && var16.itemQuantities[param0] >= 100000) {
				class210.addGameMessage(27, "", var16.itemQuantities[param0] + " x " + Occluder.ItemDefinition_get(id).name);
			} else {
				PacketBufferNode var9 = InterfaceParent.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(id);
				Client.packetWriter.addNode(var9);
			}

			Client.field750 = 0;
			GrandExchangeOfferOwnWorldComparator.field628 = Canvas.getWidget(param1);
			Client.field743 = param0;
		} else if (opcode == 1007) {
			Widget var16 = GrandExchangeOfferWorldComparator.getWidgetChild(param1, param0);
			if (var16 != null) {
				WorldMapSection1.widgetDefaultMenuAction(id, param1, param0, var16.itemId, target);
			}
		} else if (opcode == 1011 || opcode == 1008 || opcode == 1009 || opcode == 1010 || opcode == 1012) {
			Tiles.worldMap.menuAction(opcode, id, new Coord(param0), new Coord(param1));
		}

		if (Client.isItemSelected != 0) {
			Client.isItemSelected = 0;
			WorldMapSectionType.invalidateWidget(Canvas.getWidget(class2.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			class208.Widget_runOnTargetLeave();
		}

		if (GrandExchangeOfferOwnWorldComparator.field628 != null && Client.field750 == 0) {
			WorldMapSectionType.invalidateWidget(GrandExchangeOfferOwnWorldComparator.field628);
		}

	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lho;I)Ljava/lang/String;",
		garbageValue = "-1374184738"
	)
	static String method4335(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					String var4 = var0.substring(0, var3);
					int var6 = class216.method4015(var1, var2 - 1);
					String var5;
					if (var6 < 999999999) {
						var5 = Integer.toString(var6);
					} else {
						var5 = "*";
					}

					var0 = var4 + var5 + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}
}
