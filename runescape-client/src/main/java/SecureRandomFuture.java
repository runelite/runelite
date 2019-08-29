import java.awt.Component;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cm")
@Implements("SecureRandomFuture")
public class SecureRandomFuture {
	@ObfuscatedName("s")
	@Export("executor")
	ExecutorService executor;
	@ObfuscatedName("j")
	@Export("future")
	Future future;

	SecureRandomFuture() {
		this.executor = Executors.newSingleThreadExecutor();
		this.future = this.executor.submit(new SecureRandomCallable());
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1323034679"
	)
	@Export("shutdown")
	void shutdown() {
		this.executor.shutdown();
		this.executor = null;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-2137893013"
	)
	@Export("isDone")
	boolean isDone() {
		return this.future.isDone();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)Ljava/security/SecureRandom;",
		garbageValue = "1958597886"
	)
	@Export("get")
	SecureRandom get() {
		try {
			return (SecureRandom)this.future.get();
		} catch (Exception var4) {
			SecureRandom var3 = new SecureRandom();
			var3.nextInt();
			return var3;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/awt/Component;B)V",
		garbageValue = "4"
	)
	static void method2061(Component var0) {
		var0.addMouseListener(MouseHandler.MouseHandler_instance);
		var0.addMouseMotionListener(MouseHandler.MouseHandler_instance);
		var0.addFocusListener(MouseHandler.MouseHandler_instance);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(ILcr;ZS)I",
		garbageValue = "-27974"
	)
	static int method2060(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? class286.field3623 : class297.field3693;
		}

		int var11;
		if (var0 == ScriptOpcodes.CC_SETOP) {
			var11 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
				return 1;
			} else {
				--Interpreter.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == ScriptOpcodes.CC_SETDRAGGABLE) {
				Interpreter.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				var4.parent = ModelData0.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGGABLEBEHAVIOR) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADZONE) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADTIME) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOPBASE) {
				var4.dataText = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTARGETVERB) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_CLEAROPS) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.field2688 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != ScriptOpcodes.CC_SETOPKEY) {
					byte var5;
					if (var0 == ScriptOpcodes.CC_SETOPTKEY) {
						Interpreter.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
						class80.Widget_setKey(var4, var5, var9, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYRATE) {
						Interpreter.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							FontName.Widget_setKeyRate(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYRATE) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						FontName.Widget_setKeyRate(var4, var5, var6, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYIGNOREHELD) {
						--Interpreter.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							class30.Widget_setKeyIgnoreHeld(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYIGNOREHELD) {
						var5 = 10;
						class30.Widget_setKeyIgnoreHeld(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						Interpreter.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize + 1];
							}
						}
					} else {
						Interpreter.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						class80.Widget_setKey(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}

	@ObfuscatedName("hn")
	@ObfuscatedSignature(
		signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
		garbageValue = "1546769014"
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
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2270, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5432(RouteStrategy.baseY * 64 + var1);
			var8.packetBuffer.writeShortLE(class185.selectedItemSlot);
			var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeIntLE(FontName.selectedItemWidget);
			var8.packetBuffer.method5432(PacketWriter.baseX * 64 + var0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShortLE(class1.selectedItemId);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 2) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2277, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(PacketWriter.baseX * 64 + var0);
			var8.packetBuffer.method5443(var3);
			var8.packetBuffer.writeIntLE16(NetCache.field3162);
			var8.packetBuffer.writeShort(Client.field816);
			var8.packetBuffer.writeShortLE(RouteStrategy.baseY * 64 + var1);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 3) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2212, Client.packetWriter.isaacCipher);
			var8.packetBuffer.writeShort(RouteStrategy.baseY * 64 + var1);
			var8.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5443(var3);
			var8.packetBuffer.method5432(PacketWriter.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 4) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2264, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.writeShort(var3);
			var8.packetBuffer.writeShort(RouteStrategy.baseY * 64 + var1);
			var8.packetBuffer.writeShort(PacketWriter.baseX * 64 + var0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 5) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2274, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5432(PacketWriter.baseX * 64 + var0);
			var8.packetBuffer.method5443(var3);
			var8.packetBuffer.method5432(RouteStrategy.baseY * 64 + var1);
			var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			Client.packetWriter.addNode(var8);
		} else if (var2 == 6) {
			Client.mouseCrossX = var6;
			Client.mouseCrossY = var7;
			Client.mouseCrossColor = 2;
			Client.mouseCrossState = 0;
			Client.destinationX = var0;
			Client.destinationY = var1;
			var8 = MenuAction.getPacketBufferNode(ClientPacket.field2248, Client.packetWriter.isaacCipher);
			var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
			var8.packetBuffer.method5443(RouteStrategy.baseY * 64 + var1);
			var8.packetBuffer.method5443(PacketWriter.baseX * 64 + var0);
			var8.packetBuffer.writeShortLE(var3);
			Client.packetWriter.addNode(var8);
		} else {
			PacketBufferNode var9;
			NPC var13;
			if (var2 == 7) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2208, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5432(class1.selectedItemId);
					var9.packetBuffer.writeShort(class185.selectedItemSlot);
					var9.packetBuffer.method5432(var3);
					var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeInt(FontName.selectedItemWidget);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 8) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2271, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5432(var3);
					var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeIntLE(NetCache.field3162);
					var9.packetBuffer.method5443(Client.field816);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 9) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2256, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 10) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2186, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5443(var3);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 11) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2218, Client.packetWriter.isaacCipher);
					var9.packetBuffer.method5432(var3);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 12) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2196, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeShort(var3);
					var9.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var9);
				}
			} else if (var2 == 13) {
				var13 = Client.npcs[var3];
				if (var13 != null) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var9 = MenuAction.getPacketBufferNode(ClientPacket.field2216, Client.packetWriter.isaacCipher);
					var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var9.packetBuffer.method5443(var3);
					Client.packetWriter.addNode(var9);
				}
			} else {
				Player var15;
				if (var2 == 14) {
					var15 = Client.players[var3];
					if (var15 != null) {
						Client.mouseCrossX = var6;
						Client.mouseCrossY = var7;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = var0;
						Client.destinationY = var1;
						var9 = MenuAction.getPacketBufferNode(ClientPacket.field2242, Client.packetWriter.isaacCipher);
						var9.packetBuffer.method5432(class185.selectedItemSlot);
						var9.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.writeIntME(FontName.selectedItemWidget);
						var9.packetBuffer.writeShort(var3);
						var9.packetBuffer.writeShort(class1.selectedItemId);
						Client.packetWriter.addNode(var9);
					}
				} else if (var2 == 15) {
					var15 = Client.players[var3];
					if (var15 != null) {
						Client.mouseCrossX = var6;
						Client.mouseCrossY = var7;
						Client.mouseCrossColor = 2;
						Client.mouseCrossState = 0;
						Client.destinationX = var0;
						Client.destinationY = var1;
						var9 = MenuAction.getPacketBufferNode(ClientPacket.field2240, Client.packetWriter.isaacCipher);
						var9.packetBuffer.writeIntLE16(NetCache.field3162);
						var9.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
						var9.packetBuffer.method5443(Client.field816);
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
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2251, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(FontName.selectedItemWidget);
					var8.packetBuffer.method5432(class1.selectedItemId);
					var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(class185.selectedItemSlot);
					var8.packetBuffer.method5432(var3);
					var8.packetBuffer.method5432(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.writeShortLE(RouteStrategy.baseY * 64 + var1);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 17) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2217, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeIntME(NetCache.field3162);
					var8.packetBuffer.writeShort(Client.field816);
					var8.packetBuffer.method5443(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.method5443(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 18) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2190, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5432(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.writeShortLE(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 19) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2259, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5432(var3);
					var8.packetBuffer.method5443(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.writeShort(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 20) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2191, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.writeShortLE(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.writeShortLE(var3);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 21) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2214, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method5443(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.writeShortLE(var3);
					var8.packetBuffer.writeShort(PacketWriter.baseX * 64 + var0);
					var8.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 22) {
					Client.mouseCrossX = var6;
					Client.mouseCrossY = var7;
					Client.mouseCrossColor = 2;
					Client.mouseCrossState = 0;
					Client.destinationX = var0;
					Client.destinationY = var1;
					var8 = MenuAction.getPacketBufferNode(ClientPacket.field2236, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
					var8.packetBuffer.method5432(var3);
					var8.packetBuffer.method5443(RouteStrategy.baseY * 64 + var1);
					var8.packetBuffer.writeShort(PacketWriter.baseX * 64 + var0);
					Client.packetWriter.addNode(var8);
				} else if (var2 == 23) {
					if (Client.isMenuOpen) {
						Player.scene.setViewportWalking();
					} else {
						Player.scene.menuOpen(ItemContainer.plane, var0, var1, true);
					}
				} else {
					PacketBufferNode var10;
					Widget var16;
					if (var2 == 24) {
						var16 = WorldMapElement.getWidget(var1);
						boolean var12 = true;
						if (var16.contentType > 0) {
							var12 = WorldMapSection1.method563(var16);
						}

						if (var12) {
							var10 = MenuAction.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
							var10.packetBuffer.writeInt(var1);
							Client.packetWriter.addNode(var10);
						}
					} else {
						if (var2 == 25) {
							var16 = ModelData0.getWidgetChild(var1, var0);
							if (var16 != null) {
								WorldMapRegion.Widget_runOnTargetLeave();
								class223.method4036(var1, var0, WorldMapRegion.method530(ParamDefinition.getWidgetClickMask(var16)), var16.itemId);
								Client.isItemSelected = 0;
								Client.selectedSpellActionName = class173.method3529(var16);
								if (Client.selectedSpellActionName == null) {
									Client.selectedSpellActionName = "null";
								}

								if (var16.isIf3) {
									Client.selectedSpellName = var16.dataText + class16.colorStartTag(16777215);
								} else {
									Client.selectedSpellName = class16.colorStartTag(65280) + var16.spellName + class16.colorStartTag(16777215);
								}
							}

							return;
						}

						if (var2 == 26) {
							ParamDefinition.method4424();
						} else {
							int var11;
							Widget var14;
							if (var2 == 28) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = WorldMapElement.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var11 = var14.cs1Instructions[0][1];
									Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
									ObjectSound.method1837(var11);
								}
							} else if (var2 == 29) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2254, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								Client.packetWriter.addNode(var8);
								var14 = WorldMapElement.getWidget(var1);
								if (var14.cs1Instructions != null && var14.cs1Instructions[0][0] == 5) {
									var11 = var14.cs1Instructions[0][1];
									if (Varps.Varps_main[var11] != var14.cs1ComparisonValues[0]) {
										Varps.Varps_main[var11] = var14.cs1ComparisonValues[0];
										ObjectSound.method1837(var11);
									}
								}
							} else if (var2 == 30) {
								if (Client.meslayerContinueWidget == null) {
									GameShell.resumePauseWidget(var1, var0);
									Client.meslayerContinueWidget = ModelData0.getWidgetChild(var1, var0);
									FriendSystem.invalidateWidget(Client.meslayerContinueWidget);
								}
							} else if (var2 == 31) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2229, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(var1);
								var8.packetBuffer.writeIntLE16(FontName.selectedItemWidget);
								var8.packetBuffer.method5432(class185.selectedItemSlot);
								var8.packetBuffer.writeShortLE(class1.selectedItemId);
								var8.packetBuffer.writeShortLE(var0);
								var8.packetBuffer.method5432(var3);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 32) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2187, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntME(NetCache.field3162);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.writeShortLE(Client.field816);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 33) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2235, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeShortLE(var3);
								var8.packetBuffer.writeIntME(var1);
								var8.packetBuffer.writeShort(var0);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 34) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2283, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5443(var3);
								var8.packetBuffer.writeIntLE16(var1);
								var8.packetBuffer.method5432(var0);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 35) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2257, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeIntLE(var1);
								var8.packetBuffer.method5432(var0);
								var8.packetBuffer.method5432(var3);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 36) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2188, Client.packetWriter.isaacCipher);
								var8.packetBuffer.method5432(var3);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.method5432(var0);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else if (var2 == 37) {
								var8 = MenuAction.getPacketBufferNode(ClientPacket.field2243, Client.packetWriter.isaacCipher);
								var8.packetBuffer.writeInt(var1);
								var8.packetBuffer.writeShort(var0);
								var8.packetBuffer.writeShort(var3);
								Client.packetWriter.addNode(var8);
								Client.field729 = 0;
								Actor.field978 = WorldMapElement.getWidget(var1);
								Client.field730 = var0;
							} else {
								if (var2 == 38) {
									WorldMapRegion.Widget_runOnTargetLeave();
									var16 = WorldMapElement.getWidget(var1);
									Client.isItemSelected = 1;
									class185.selectedItemSlot = var0;
									FontName.selectedItemWidget = var1;
									class1.selectedItemId = var3;
									FriendSystem.invalidateWidget(var16);
									Client.selectedItemName = class16.colorStartTag(16748608) + WorldMapData_0.ItemDefinition_get(var3).name + class16.colorStartTag(16777215);
									if (Client.selectedItemName == null) {
										Client.selectedItemName = "null";
									}

									return;
								}

								if (var2 == 39) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2231, Client.packetWriter.isaacCipher);
									var8.packetBuffer.method5432(var3);
									var8.packetBuffer.writeIntLE16(var1);
									var8.packetBuffer.writeShortLE(var0);
									Client.packetWriter.addNode(var8);
									Client.field729 = 0;
									Actor.field978 = WorldMapElement.getWidget(var1);
									Client.field730 = var0;
								} else if (var2 == 40) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2211, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntLE16(var1);
									var8.packetBuffer.writeShortLE(var0);
									var8.packetBuffer.method5443(var3);
									Client.packetWriter.addNode(var8);
									Client.field729 = 0;
									Actor.field978 = WorldMapElement.getWidget(var1);
									Client.field730 = var0;
								} else if (var2 == 41) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2250, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeIntLE(var1);
									var8.packetBuffer.method5443(var0);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field729 = 0;
									Actor.field978 = WorldMapElement.getWidget(var1);
									Client.field730 = var0;
								} else if (var2 == 42) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2193, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeInt(var1);
									var8.packetBuffer.method5443(var0);
									var8.packetBuffer.writeShort(var3);
									Client.packetWriter.addNode(var8);
									Client.field729 = 0;
									Actor.field978 = WorldMapElement.getWidget(var1);
									Client.field730 = var0;
								} else if (var2 == 43) {
									var8 = MenuAction.getPacketBufferNode(ClientPacket.field2268, Client.packetWriter.isaacCipher);
									var8.packetBuffer.writeShort(var3);
									var8.packetBuffer.writeIntME(var1);
									var8.packetBuffer.writeShort(var0);
									Client.packetWriter.addNode(var8);
									Client.field729 = 0;
									Actor.field978 = WorldMapElement.getWidget(var1);
									Client.field730 = var0;
								} else if (var2 == 44) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2272, Client.packetWriter.isaacCipher);
										var9.packetBuffer.writeShort(var3);
										var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 45) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2241, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5443(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 46) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5443(var3);
										var9.packetBuffer.writeByte(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 47) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2279, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5432(var3);
										var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 48) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2262, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5443(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 49) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2249, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5443(var3);
										var9.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 50) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2260, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5435(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.writeShortLE(var3);
										Client.packetWriter.addNode(var9);
									}
								} else if (var2 == 51) {
									var15 = Client.players[var3];
									if (var15 != null) {
										Client.mouseCrossX = var6;
										Client.mouseCrossY = var7;
										Client.mouseCrossColor = 2;
										Client.mouseCrossState = 0;
										Client.destinationX = var0;
										Client.destinationY = var1;
										var9 = MenuAction.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
										var9.packetBuffer.method5545(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
										var9.packetBuffer.method5432(var3);
										Client.packetWriter.addNode(var9);
									}
								} else {
									label758: {
										if (var2 != 57) {
											if (var2 == 58) {
												var16 = ModelData0.getWidgetChild(var1, var0);
												if (var16 != null) {
													var9 = MenuAction.getPacketBufferNode(ClientPacket.field2246, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShortLE(Client.field816);
													var9.packetBuffer.writeIntLE16(var1);
													var9.packetBuffer.writeShortLE(Client.field736);
													var9.packetBuffer.method5432(var0);
													var9.packetBuffer.writeInt(NetCache.field3162);
													var9.packetBuffer.method5432(var16.itemId);
													Client.packetWriter.addNode(var9);
												}
												break label758;
											}

											if (var2 == 1001) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												Client.destinationX = var0;
												Client.destinationY = var1;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2287, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShort(var3);
												var8.packetBuffer.method5433(KeyHandler.KeyHandler_pressedKeys[82] ? 1 : 0);
												var8.packetBuffer.method5443(PacketWriter.baseX * 64 + var0);
												var8.packetBuffer.method5432(RouteStrategy.baseY * 64 + var1);
												Client.packetWriter.addNode(var8);
												break label758;
											}

											if (var2 == 1002) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2239, Client.packetWriter.isaacCipher);
												var8.packetBuffer.method5443(var3);
												Client.packetWriter.addNode(var8);
												break label758;
											}

											if (var2 == 1003) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var13 = Client.npcs[var3];
												if (var13 != null) {
													NPCDefinition var17 = var13.definition;
													if (var17.transforms != null) {
														var17 = var17.transform();
													}

													if (var17 != null) {
														var10 = MenuAction.getPacketBufferNode(ClientPacket.field2215, Client.packetWriter.isaacCipher);
														var10.packetBuffer.method5443(var17.id);
														Client.packetWriter.addNode(var10);
													}
												}
												break label758;
											}

											if (var2 == 1004) {
												Client.mouseCrossX = var6;
												Client.mouseCrossY = var7;
												Client.mouseCrossColor = 2;
												Client.mouseCrossState = 0;
												var8 = MenuAction.getPacketBufferNode(ClientPacket.field2209, Client.packetWriter.isaacCipher);
												var8.packetBuffer.writeShortLE(var3);
												Client.packetWriter.addNode(var8);
												break label758;
											}

											if (var2 == 1005) {
												var16 = WorldMapElement.getWidget(var1);
												if (var16 != null && var16.itemQuantities[var0] >= 100000) {
													DirectByteArrayCopier.addGameMessage(27, "", var16.itemQuantities[var0] + " x " + WorldMapData_0.ItemDefinition_get(var3).name);
												} else {
													var9 = MenuAction.getPacketBufferNode(ClientPacket.field2209, Client.packetWriter.isaacCipher);
													var9.packetBuffer.writeShortLE(var3);
													Client.packetWriter.addNode(var9);
												}

												Client.field729 = 0;
												Actor.field978 = WorldMapElement.getWidget(var1);
												Client.field730 = var0;
												break label758;
											}

											if (var2 != 1007) {
												if (var2 == 1010 || var2 == 1011 || var2 == 1008 || var2 == 1009 || var2 == 1012) {
													WorldMapCacheName.worldMap.menuAction(var2, var3, new Coord(var0), new Coord(var1));
												}
												break label758;
											}
										}

										var16 = ModelData0.getWidgetChild(var1, var0);
										if (var16 != null) {
											InterfaceParent.method1127(var3, var1, var0, var16.itemId, var5);
										}
									}
								}
							}
						}
					}
				}
			}
		}

		if (Client.isItemSelected != 0) {
			Client.isItemSelected = 0;
			FriendSystem.invalidateWidget(WorldMapElement.getWidget(FontName.selectedItemWidget));
		}

		if (Client.isSpellSelected) {
			WorldMapRegion.Widget_runOnTargetLeave();
		}

		if (Actor.field978 != null && Client.field729 == 0) {
			FriendSystem.invalidateWidget(Actor.field978);
		}

	}
}
