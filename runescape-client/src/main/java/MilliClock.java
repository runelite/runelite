import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("kh")
	@ObfuscatedGetter(
		intValue = 145701519
	)
	@Export("menuX")
	static int menuX;
	@ObfuscatedName("s")
	long[] field2002;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -986799109
	)
	int field1999;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1675223211
	)
	int field2000;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		longValue = 5516400529090944549L
	)
	long field2003;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = -1296421545
	)
	int field2001;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1277322541
	)
	int field1998;

	MilliClock() {
		this.field2002 = new long[10];
		this.field1999 = 256;
		this.field2000 = 1;
		this.field2001 = 0;
		this.field2003 = SequenceDefinition.method4686();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2002[var1] = this.field2003;
		}

	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-779324795"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field2002[var1] = 0L;
		}

	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "930751718"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1999;
		int var4 = this.field2000;
		this.field1999 = 300;
		this.field2000 = 1;
		this.field2003 = SequenceDefinition.method4686();
		if (this.field2002[this.field1998] == 0L) {
			this.field1999 = var3;
			this.field2000 = var4;
		} else if (this.field2003 > this.field2002[this.field1998]) {
			this.field1999 = (int)((long)(var1 * 2560) / (this.field2003 - this.field2002[this.field1998]));
		}

		if (this.field1999 < 25) {
			this.field1999 = 25;
		}

		if (this.field1999 > 256) {
			this.field1999 = 256;
			this.field2000 = (int)((long)var1 - (this.field2003 - this.field2002[this.field1998]) / 10L);
		}

		if (this.field2000 > var1) {
			this.field2000 = var1;
		}

		this.field2002[this.field1998] = this.field2003;
		this.field1998 = (this.field1998 + 1) % 10;
		int var5;
		if (this.field2000 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field2002[var5]) {
					this.field2002[var5] += (long)this.field2000;
				}
			}
		}

		if (this.field2000 < var2) {
			this.field2000 = var2;
		}

		UserList.sleepMillis((long)this.field2000);

		for (var5 = 0; this.field2001 < 256; this.field2001 += this.field1999) {
			++var5;
		}

		this.field2001 &= 255;
		return var5;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1790253551"
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

	@ObfuscatedName("fm")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1981832610"
	)
	static final void method3405() {
		int var0;
		int var1;
		int var2;
		int var3;
		int var4;
		int var5;
		if (Client.oculusOrbState == 0) {
			var0 = WorldMapIcon_1.localPlayer.x;
			var1 = WorldMapIcon_1.localPlayer.y;
			if (DynamicObject.oculusOrbFocalPointX - var0 < -500 || DynamicObject.oculusOrbFocalPointX - var0 > 500 || FriendSystem.oculusOrbFocalPointY - var1 < -500 || FriendSystem.oculusOrbFocalPointY - var1 > 500) {
				DynamicObject.oculusOrbFocalPointX = var0;
				FriendSystem.oculusOrbFocalPointY = var1;
			}

			if (var0 != DynamicObject.oculusOrbFocalPointX) {
				DynamicObject.oculusOrbFocalPointX += (var0 - DynamicObject.oculusOrbFocalPointX) / 16;
			}

			if (var1 != FriendSystem.oculusOrbFocalPointY) {
				FriendSystem.oculusOrbFocalPointY += (var1 - FriendSystem.oculusOrbFocalPointY) / 16;
			}

			var2 = DynamicObject.oculusOrbFocalPointX >> 7;
			var3 = FriendSystem.oculusOrbFocalPointY >> 7;
			var4 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(DynamicObject.oculusOrbFocalPointX, FriendSystem.oculusOrbFocalPointY, ItemContainer.plane);
			var5 = 0;
			int var6;
			if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
				for (var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
					for (int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
						int var8 = ItemContainer.plane;
						if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
							++var8;
						}

						int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
						if (var9 > var5) {
							var5 = var9;
						}
					}
				}
			}

			var6 = var5 * 192;
			if (var6 > 98048) {
				var6 = 98048;
			}

			if (var6 < 32768) {
				var6 = 32768;
			}

			if (var6 > Client.field635) {
				Client.field635 += (var6 - Client.field635) / 24;
			} else if (var6 < Client.field635) {
				Client.field635 += (var6 - Client.field635) / 80;
			}

			ScriptEvent.field559 = GrandExchangeOfferTotalQuantityComparator.getTileHeight(WorldMapIcon_1.localPlayer.x, WorldMapIcon_1.localPlayer.y, ItemContainer.plane) - Client.camFollowHeight;
		} else if (Client.oculusOrbState == 1) {
			GrandExchangeOffer.method122();
			short var10 = -1;
			if (KeyHandler.KeyHandler_pressedKeys[33]) {
				var10 = 0;
			} else if (KeyHandler.KeyHandler_pressedKeys[49]) {
				var10 = 1024;
			}

			if (KeyHandler.KeyHandler_pressedKeys[48]) {
				if (var10 == 0) {
					var10 = 1792;
				} else if (var10 == 1024) {
					var10 = 1280;
				} else {
					var10 = 1536;
				}
			} else if (KeyHandler.KeyHandler_pressedKeys[50]) {
				if (var10 == 0) {
					var10 = 256;
				} else if (var10 == 1024) {
					var10 = 768;
				} else {
					var10 = 512;
				}
			}

			byte var11 = 0;
			if (KeyHandler.KeyHandler_pressedKeys[35]) {
				var11 = -1;
			} else if (KeyHandler.KeyHandler_pressedKeys[51]) {
				var11 = 1;
			}

			var2 = 0;
			if (var10 >= 0 || var11 != 0) {
				var2 = KeyHandler.KeyHandler_pressedKeys[81] ? Client.oculusOrbSlowedSpeed : Client.oculusOrbNormalSpeed;
				var2 *= 16;
				Client.field701 = var10;
				Client.field680 = var11;
			}

			if (Client.field700 < var2) {
				Client.field700 += var2 / 8;
				if (Client.field700 > var2) {
					Client.field700 = var2;
				}
			} else if (Client.field700 > var2) {
				Client.field700 = Client.field700 * 9 / 10;
			}

			if (Client.field700 > 0) {
				var3 = Client.field700 / 16;
				if (Client.field701 >= 0) {
					var0 = Client.field701 - class40.cameraYaw & 2047;
					var4 = Rasterizer3D.Rasterizer3D_sine[var0];
					var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
					DynamicObject.oculusOrbFocalPointX += var4 * var3 / 65536;
					FriendSystem.oculusOrbFocalPointY += var5 * var3 / 65536;
				}

				if (Client.field680 != 0) {
					ScriptEvent.field559 += var3 * Client.field680;
					if (ScriptEvent.field559 > 0) {
						ScriptEvent.field559 = 0;
					}
				}
			} else {
				Client.field701 = -1;
				Client.field680 = -1;
			}

			if (KeyHandler.KeyHandler_pressedKeys[13]) {
				WorldMapSection0.method221();
			}
		}

		if (MouseHandler.MouseHandler_currentButton == 4 && FriendSystem.mouseCam) {
			var0 = MouseHandler.MouseHandler_y - Client.mouseCamClickedY;
			Client.camAngleDX = var0 * 2;
			Client.mouseCamClickedY = var0 != -1 && var0 != 1 ? (MouseHandler.MouseHandler_y + Client.mouseCamClickedY) / 2 : MouseHandler.MouseHandler_y;
			var1 = Client.mouseCamClickedX - MouseHandler.MouseHandler_x;
			Client.camAngleDY = var1 * 2;
			Client.mouseCamClickedX = var1 != -1 && var1 != 1 ? (MouseHandler.MouseHandler_x + Client.mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x;
		} else {
			if (KeyHandler.KeyHandler_pressedKeys[96]) {
				Client.camAngleDY += (-24 - Client.camAngleDY) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[97]) {
				Client.camAngleDY += (24 - Client.camAngleDY) / 2;
			} else {
				Client.camAngleDY /= 2;
			}

			if (KeyHandler.KeyHandler_pressedKeys[98]) {
				Client.camAngleDX += (12 - Client.camAngleDX) / 2;
			} else if (KeyHandler.KeyHandler_pressedKeys[99]) {
				Client.camAngleDX += (-12 - Client.camAngleDX) / 2;
			} else {
				Client.camAngleDX /= 2;
			}

			Client.mouseCamClickedY = MouseHandler.MouseHandler_y;
			Client.mouseCamClickedX = MouseHandler.MouseHandler_x;
		}

		Client.camAngleY = Client.camAngleDY / 2 + Client.camAngleY & 2047;
		Client.camAngleX += Client.camAngleDX / 2;
		if (Client.camAngleX < 128) {
			Client.camAngleX = 128;
		}

		if (Client.camAngleX > 383) {
			Client.camAngleX = 383;
		}

	}
}
