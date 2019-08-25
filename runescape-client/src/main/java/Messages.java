import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Messages")
public class Messages {
	@ObfuscatedName("q")
	@Export("Messages_channels")
	static final Map Messages_channels;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lla;"
	)
	@Export("Messages_hashTable")
	static final IterableNodeHashTable Messages_hashTable;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Ljk;"
	)
	@Export("Messages_queue")
	static final IterableDualNodeQueue Messages_queue;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -125602517
	)
	@Export("Messages_count")
	static int Messages_count;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lhp;"
	)
	@Export("ItemDefinition_archive")
	public static AbstractArchive ItemDefinition_archive;

	static {
		Messages_channels = new HashMap();
		Messages_hashTable = new IterableNodeHashTable(1024);
		Messages_queue = new IterableDualNodeQueue();
		Messages_count = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "102"
	)
	@Export("ViewportMouse_unpackY")
	public static int ViewportMouse_unpackY(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 7 & 127L);
		return var1;
	}

	@ObfuscatedName("hz")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "-1471324986"
	)
	@Export("menuAction")
	static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
		if (var2 >= 2000) {
			var2 -= 2000;
		}

		PacketBufferNode var8;
		if (var2 == 1) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(class1.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(WorldMapIcon_1.selectedItemSlot);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntLE(MouseRecorder.selectedItemWidget);
			var8.packetBuffer.method5475(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShortLE(class4.selectedItemId);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2295, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.method5530(var3);
			var8.packetBuffer.writeIntLE16(WorldMapEvent.field359);
			var8.packetBuffer.writeShort(Client.field848);
			var8.packetBuffer.writeShortLE(class1.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2213, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(class1.baseY * 64 + var1);
			var8.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5530(var3);
			var8.packetBuffer.method5475(MusicPatchNode2.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2282, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShort(class1.baseY * 64 + var1);
			var8.packetBuffer.writeShort(MusicPatchNode2.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2292, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.method5530(var3);
			var8.packetBuffer.method5475(class1.baseY * 64 + var1);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5530(class1.baseY * 64 + var1);
			var8.packetBuffer.method5530(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 7) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2207, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5475(class4.selectedItemId);
				var9.packetBuffer.writeShort(WorldMapIcon_1.selectedItemSlot);
				var9.packetBuffer.method5475(var3);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeInt(MouseRecorder.selectedItemWidget);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 8) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2304, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5475(var3);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeIntLE(WorldMapEvent.field359);
				var9.packetBuffer.method5530(Client.field848);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 9) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 10) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2204, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5530(var3);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 11) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5475(var3);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 12) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2303, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(var3);
				var9.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 13) {
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5530(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 14) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2284, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5475(WorldMapIcon_1.selectedItemSlot);
				var9.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeIntME(MouseRecorder.selectedItemWidget);
				var9.packetBuffer.writeShort(var3);
				var9.packetBuffer.writeShort(class4.selectedItemId);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 15) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeIntLE16(WorldMapEvent.field359);
				var9.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5530(Client.field848);
				var9.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 16) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2221, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(MouseRecorder.selectedItemWidget);
			var8.packetBuffer.method5475(class4.selectedItemId);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(WorldMapIcon_1.selectedItemSlot);
			var8.packetBuffer.method5475(var3);
			var8.packetBuffer.method5475(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(class1.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 17) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2293, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(WorldMapEvent.field359);
			var8.packetBuffer.writeShort(Client.field848);
			var8.packetBuffer.method5530(class1.baseY * 64 + var1);
			var8.packetBuffer.method5530(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 18) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(class1.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShortLE(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 19) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(var3);
			var8.packetBuffer.method5530(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeShort(class1.baseY * 64 + var1);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 20) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2269, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(class1.baseY * 64 + var1);
			var8.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShortLE(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 21) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2203, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5530(class1.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShort(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 22) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5475(var3);
			var8.packetBuffer.method5530(class1.baseY * 64 + var1);
			var8.packetBuffer.writeShort(MusicPatchNode2.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 23) {
			if (Client.isMenuOpen) {
				GrandExchangeOfferWorldComparator.scene.setViewportWalking();
			} else {
				GrandExchangeOfferWorldComparator.scene.menuOpen(class42.plane, var0, var1, true);
			}
		} else if (var2 == 24) {
			Widget var16 = class80.getWidget(var1);
			boolean var12 = true;
			if (var16.contentType > 0) {
				var12 = GrandExchangeOfferAgeComparator.method149(var16);
			}

			if (var12) {
				PacketBufferNode var10 = Archive.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				Client.packetWriter.addNode(var10);
			}
		} else if (var2 == 25) {
			Widget var16 = Client.getWidgetChild(var1, var0);
			if (var16 != null) {
				WorldMapID.Widget_runOnTargetLeave();
				TileItem.method2053(var1, var0, HealthBar.method1957(class268.getWidgetClickMask(var16)), var16.itemId);
				Client.isItemSelected = 0;
				Client.selectedSpellActionName = FontName.method5318(var16);
				if (Client.selectedSpellActionName == null) {
					Client.selectedSpellActionName = "null";
				}

				if (var16.isIf3) {
					Client.selectedSpellName = var16.dataText + ClientPreferences.colorStartTag(0xffffff);
				} else {
					Client.selectedSpellName = ClientPreferences.colorStartTag(0xff00) + var16.spellName + ClientPreferences.colorStartTag(0xffffff);
				}
			}

			return;
		} else if (var2 == 26) {
			GrandExchangeEvent.method73();
		} else if (var2 == 28) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var8);
			Widget var14 = class80.getWidget(var1);
			if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
				int var11 = var14.cs1Instructions[0][1];
				Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
				GrandExchangeOfferUnitPriceComparator.method124(var11);
			}
		} else if (var2 == 29) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(var1);
			Client.packetWriter.addNode(var8);
			Widget var14 = class80.getWidget(var1);
			if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
				int var11 = var14.cs1Instructions[0][1];
				if (Varps.Varps_main[var11] != var14.cs1ComparisonValues[0]) {
					Varps.Varps_main[var11] = var14.cs1ComparisonValues[0];
					GrandExchangeOfferUnitPriceComparator.method124(var11);
				}
			}
		} else if (var2 == 30) {
			if (Client.meslayerContinueWidget == null) {
				ScriptFrame.resumePauseWidget(var1, var0);
				Client.meslayerContinueWidget = Client.getWidgetChild(var1, var0);
				Strings.invalidateWidget(Client.meslayerContinueWidget);
			}
		} else if (var2 == 31) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2266, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(var1);
			var8.packetBuffer.writeIntLE16(MouseRecorder.selectedItemWidget);
			var8.packetBuffer.method5475(WorldMapIcon_1.selectedItemSlot);
			var8.packetBuffer.writeShortLE(class4.selectedItemId);
			var8.packetBuffer.writeShortLE(var0);
			var8.packetBuffer.method5475(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 32) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2232, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntME(WorldMapEvent.field359);
			var8.packetBuffer.writeInt(var1);
			var8.packetBuffer.writeShort(var0);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeShortLE(Client.field848);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 33) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2290, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(var3);
			var8.packetBuffer.writeIntME(var1);
			var8.packetBuffer.writeShort(var0);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 34) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5530(var3);
			var8.packetBuffer.writeIntLE16(var1);
			var8.packetBuffer.method5475(var0);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 35) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2265, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntLE(var1);
			var8.packetBuffer.method5475(var0);
			var8.packetBuffer.method5475(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 36) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2281, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(var3);
			var8.packetBuffer.writeInt(var1);
			var8.packetBuffer.method5475(var0);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 37) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2261, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(var1);
			var8.packetBuffer.writeShort(var0);
			var8.packetBuffer.writeShort(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 38) {
			WorldMapID.Widget_runOnTargetLeave();
			Widget var16 = class80.getWidget(var1);
			Client.isItemSelected = 1;
			WorldMapIcon_1.selectedItemSlot = var0;
			MouseRecorder.selectedItemWidget = var1;
			class4.selectedItemId = var3;
			Strings.invalidateWidget(var16);
			Client.selectedItemName = ClientPreferences.colorStartTag(0xff9040) + WorldMapArea.ItemDefinition_get(var3).name + ClientPreferences.colorStartTag(0xffffff);
			if (Client.selectedItemName == null) {
				Client.selectedItemName = "null";
			}

			return;
		} else if (var2 == 39) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5475(var3);
			var8.packetBuffer.writeIntLE16(var1);
			var8.packetBuffer.writeShortLE(var0);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 40) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntLE16(var1);
			var8.packetBuffer.writeShortLE(var0);
			var8.packetBuffer.method5530(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 41) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeIntLE(var1);
			var8.packetBuffer.method5530(var0);
			var8.packetBuffer.writeShort(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 42) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2267, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeInt(var1);
			var8.packetBuffer.method5530(var0);
			var8.packetBuffer.writeShort(var3);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 43) {
			var8 = Archive.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeIntME(var1);
			var8.packetBuffer.writeShort(var0);
			Client.packetWriter.addNode(var8);
			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;
		} else if (var2 == 44) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShort(var3);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 45) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2301, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5530(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 46) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2209, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5530(var3);
				var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 47) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2230, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5475(var3);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 48) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5530(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 49) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5530(var3);
				var9.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 50) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2278, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5502(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 51) {
			Player var15 = Client.players[var3];
			if (var15 != null) {
				Client.mouseCrossX = var6;
				Client.mouseCrossY = var7;
				Client.mouseCrossColor = 2;
				Client.mouseCrossState = 0;
				Client.destinationX = var0;
				Client.destinationY = var1;
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2253, Client.packetWriter.isaacCipher);
				var9.packetBuffer.method5521(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
				var9.packetBuffer.method5475(var3);
				Client.packetWriter.addNode(var9);
			}
		} else if (var2 == 57) {
			Widget var16 = Client.getWidgetChild(var1, var0);
			if (var16 != null) {
				method2163(var3, var1, var0, var16.itemId, var5);
			}
		} else if (var2 == 58) {
			Widget var16 = Client.getWidgetChild(var1, var0);
			if (var16 != null) {
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2285, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(Client.field848);
				var9.packetBuffer.writeIntLE16(var1);
				var9.packetBuffer.writeShortLE(Client.field812);
				var9.packetBuffer.method5475(var0);
				var9.packetBuffer.writeInt(WorldMapEvent.field359);
				var9.packetBuffer.method5475(var16.itemId);
				Client.packetWriter.addNode(var9);
			}

		} else if (var2 == 1001) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2226, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.method5520(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5530(MusicPatchNode2.baseX * 64 + var0);
			var8.packetBuffer.method5475(class1.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);

		} else if (var2 == 1002) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2244, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5530(var3);
			Client.packetWriter.addNode(var8);

		} else if (var2 == 1003) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			NPC var13 = Client.npcs[var3];
			if (var13 != null) {
				NPCDefinition var17 = var13.definition;
				if (var17.transforms != null) {
					var17 = var17.transform();
				}

				if (var17 != null) {
					PacketBufferNode var10 = Archive.getPacketBufferNode(ClientPacket.field2233, Client.packetWriter.isaacCipher);
					var10.packetBuffer.method5530(var17.id);
					Client.packetWriter.addNode(var10);
				}
			}

		} else if (var2 == 1004) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			var8 = Archive.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);

		} else if (var2 == 1005) {
			Widget var16 = class80.getWidget(var1);
			if (var16 != null && var16.itemQuantities[var0] >= 100000) {
				ScriptEvent.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + WorldMapArea.ItemDefinition_get(var3).name);
			} else {
				PacketBufferNode var9 = Archive.getPacketBufferNode(ClientPacket.field2227, Client.packetWriter.isaacCipher);
				var9.packetBuffer.writeShortLE(var3);
				Client.packetWriter.addNode(var9);
			}

			Client.field759 = 0;
			ItemContainer.field549 = class80.getWidget(var1);
			Client.field698 = var0;

		} else if (var2 != 1007) {
			if (var2 == 1011 || var2 == 1008 || var2 == 1010 || var2 == 1009 || var2 == 1012) {
				BoundaryObject.worldMap.menuAction(var2, var3, new Coord(var0), new Coord(var1));
			}
		}

		if (Client.isItemSelected != 0) {
			Client.isItemSelected = 0;
			Strings.invalidateWidget(class80.getWidget(MouseRecorder.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			WorldMapID.Widget_runOnTargetLeave();
		}

		if (ItemContainer.field549 != null && Client.field759 == 0) {
			Strings.invalidateWidget(ItemContainer.field549);
		}

	}

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;B)V",
		garbageValue = "48"
	)
	static void method2163(int var0, int var1, int var2, int var3, String var4) {
		Widget var5 = Client.getWidgetChild(var1, var2);
		if (var5 == null) {
			return;
		}
		if (var5.onOp != null) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var5;
			var6.opIndex = var0;
			var6.targetName = var4;
			var6.args = var5.onOp;
			LoginPacket.runScriptEvent(var6);
		}

		boolean var11 = true;
		if (var5.contentType > 0) {
			var11 = GrandExchangeOfferAgeComparator.method149(var5);
		}

		if (!var11) {
			return;
		}
		int var8 = class268.getWidgetClickMask(var5);
		int var9 = var0 - 1;
		boolean var7 = (var8 >> var9 + 1 & 1) != 0;
		if (var7) {
			PacketBufferNode var10;
			if (var0 == 1) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 2) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2255, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 3) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2206, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 4) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2222, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 5) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 6) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 7) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2288, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 8) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 9) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2287, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

			if (var0 == 10) {
				var10 = Archive.getPacketBufferNode(ClientPacket.field2289, Client.packetWriter.isaacCipher);
				var10.packetBuffer.writeInt(var1);
				var10.packetBuffer.writeShort(var2);
				var10.packetBuffer.writeShort(var3);
				Client.packetWriter.addNode(var10);
			}

		}
	}
}
