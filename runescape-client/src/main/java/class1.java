import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
final class class1 implements class0 {
	@ObfuscatedName("k")
	static File field2;
	@ObfuscatedName("fx")
	@ObfuscatedGetter(
		intValue = 768104753
	)
	@Export("baseY")
	static int baseY;
	@ObfuscatedName("hb")
	@ObfuscatedGetter(
		intValue = 1283296175
	)
	@Export("cameraZ")
	static int cameraZ;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Object;Lkf;I)V",
		garbageValue = "1977897097"
	)
	public void vmethod43(Object var1, Buffer var2) {
		this.method6((Integer)var1, var2);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)Ljava/lang/Object;",
		garbageValue = "-408972538"
	)
	public Object vmethod42(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Integer;Lkf;I)V",
		garbageValue = "982248566"
	)
	void method6(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "84"
	)
	static final int method14(int var0, int var1) {
		int var2 = FloorOverlayDefinition.method4757(45365 + var0, 91923 + var1, 4) - 128 + (FloorOverlayDefinition.method4757(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (FloorOverlayDefinition.method4757(var0, var1, 1) - 128 >> 2);
		var2 = (int)((double)var2 * 0.3D) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/lang/String;",
		garbageValue = "-89"
	)
	public static String method17(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				char var6;
				if (var5 != 181 && var5 != 402) {
					var6 = Character.toTitleCase(var5);
				} else {
					var6 = var5;
				}

				var5 = var6;
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		signature = "(Lgw;I)V",
		garbageValue = "-472781511"
	)
	static final void method10(class185 var0) {
		PacketBuffer var1 = Client.packetWriter.packetBuffer;
		int var2;
		int var3;
		int var4;
		int var5;
		int var6;
		int var7;
		int var8;
		if (class185.field2320 == var0) {
			var2 = var1.method5525();
			var3 = var2 >> 2;
			var4 = var2 & 3;
			var5 = Client.field713[var3];
			var6 = var1.method5525();
			var7 = (var6 >> 4 & 7) + DefaultsGroup.field3819;
			var8 = (var6 & 7) + ChatChannel.field1306;
			if (var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
				MusicPatch.method3885(class42.plane, var7, var8, var5, -1, var3, var4, 0, -1);
			}

		} else {
			GroundItem var32;
			if (class185.field2321 == var0) {
				var2 = var1.method5722();
				var3 = (var2 >> 4 & 7) + DefaultsGroup.field3819;
				var4 = (var2 & 7) + ChatChannel.field1306;
				var5 = var1.method5534();
				if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
					NodeDeque var31 = Client.groundItems[class42.plane][var3][var4];
					if (var31 != null) {
						for (var32 = (GroundItem)var31.last(); var32 != null; var32 = (GroundItem)var31.previous()) {
							if ((var5 & 32767) == var32.id) {
								var32.remove();
								break;
							}
						}

						if (var31.last() == null) {
							Client.groundItems[class42.plane][var3][var4] = null;
						}

						GrandExchangeOfferWorldComparator.updateItemPile(var3, var4);
					}
				}

			} else {
				int var9;
				int var10;
				int var12;
				byte var13;
				int var14;
				int var39;
				if (class185.field2316 == var0) {
					var2 = var1.method5525() * 4;
					var3 = var1.readUnsignedShort();
					var4 = var1.method5518();
					var5 = var1.method5525() * 4;
					var6 = var1.method5535();
					var7 = var1.readUnsignedByte();
					var8 = var1.method5525();
					var9 = var1.method5532();
					var10 = var1.method5722();
					var39 = (var10 >> 4 & 7) + DefaultsGroup.field3819;
					var12 = (var10 & 7) + ChatChannel.field1306;
					var13 = var1.method5694();
					byte var40 = var1.method5527();
					var14 = var40 + var39;
					int var41 = var13 + var12;
					if (var39 >= 0 && var12 >= 0 && var39 < 104 && var12 < 104 && var14 >= 0 && var41 >= 0 && var14 < 104 && var41 < 104 && var4 != 65535) {
						var39 = var39 * 128 + 64;
						var12 = var12 * 128 + 64;
						var14 = var14 * 128 + 64;
						var41 = var41 * 128 + 64;
						Projectile var15 = new Projectile(var4, class42.plane, var39, var12, ScriptEvent.getTileHeight(var39, var12, class42.plane) - var5, var9 + Client.cycle, var3 + Client.cycle, var7, var8, var6, var2);
						var15.setDestination(var14, var41, ScriptEvent.getTileHeight(var14, var41, class42.plane) - var2, var9 + Client.cycle);
						Client.projectiles.addFirst(var15);
					}

				} else if (class185.field2322 == var0) {
					var2 = var1.method5532();
					var3 = var1.method5534();
					var4 = var1.method5532();
					var5 = var1.method5722();
					var6 = (var5 >> 4 & 7) + DefaultsGroup.field3819;
					var7 = (var5 & 7) + ChatChannel.field1306;
					if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
						NodeDeque var42 = Client.groundItems[class42.plane][var6][var7];
						if (var42 != null) {
							for (GroundItem var34 = (GroundItem)var42.last(); var34 != null; var34 = (GroundItem)var42.previous()) {
								if ((var2 & 32767) == var34.id && var4 == var34.quantity) {
									var34.quantity = var3;
									break;
								}
							}

							GrandExchangeOfferWorldComparator.updateItemPile(var6, var7);
						}
					}

				} else if (class185.field2315 == var0) {
					var2 = var1.method5518();
					var3 = var1.method5534();
					var4 = var1.method5722();
					var5 = (var4 >> 4 & 7) + DefaultsGroup.field3819;
					var6 = (var4 & 7) + ChatChannel.field1306;
					if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
						var32 = new GroundItem();
						var32.id = var3;
						var32.quantity = var2;
						if (Client.groundItems[class42.plane][var5][var6] == null) {
							Client.groundItems[class42.plane][var5][var6] = new NodeDeque();
						}

						Client.groundItems[class42.plane][var5][var6].addFirst(var32);
						GrandExchangeOfferWorldComparator.updateItemPile(var5, var6);
					}

				} else {
					if (class185.field2319 == var0) {
						var2 = var1.readUnsignedByte();
						var3 = (var2 >> 4 & 7) + DefaultsGroup.field3819;
						var4 = (var2 & 7) + ChatChannel.field1306;
						var5 = var1.method5525();
						var6 = var1.method5722();
						var7 = var6 >> 4 & 15;
						var8 = var6 & 7;
						var9 = var1.method5534();
						if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
							var10 = var7 + 1;
							if (Client.localPlayer.pathX[0] >= var3 - var10 && Client.localPlayer.pathX[0] <= var3 + var10 && Client.localPlayer.pathY[0] >= var4 - var10 && Client.localPlayer.pathY[0] <= var4 + var10 && Client.field892 != 0 && var8 > 0 && Client.soundEffectCount < 50) {
								Client.soundEffectIds[Client.soundEffectCount] = var9;
								Client.queuedSoundEffectLoops[Client.soundEffectCount] = var8;
								Client.queuedSoundEffectDelays[Client.soundEffectCount] = var5;
								Client.soundEffects[Client.soundEffectCount] = null;
								Client.soundLocations[Client.soundEffectCount] = var7 + (var4 << 8) + (var3 << 16);
								++Client.soundEffectCount;
							}
						}
					}

					if (class185.field2318 == var0) {
						byte var37 = var1.method5527();
						var3 = var1.method5534();
						byte var38 = var1.method5527();
						var5 = var1.method5518();
						var6 = var1.readUnsignedShort();
						var7 = var1.method5722();
						var8 = var7 >> 2;
						var9 = var7 & 3;
						var10 = Client.field713[var8];
						byte var11 = var1.method5694();
						var12 = var1.method5532();
						var13 = var1.method5527();
						var14 = var1.readUnsignedByteNegate();
						int var35 = (var14 >> 4 & 7) + DefaultsGroup.field3819;
						int var16 = (var14 & 7) + ChatChannel.field1306;
						Player var17;
						if (var12 == Client.localPlayerIndex) {
							var17 = Client.localPlayer;
						} else {
							var17 = Client.players[var12];
						}

						if (var17 != null) {
							ObjectDefinition var18 = ViewportMouse.getObjectDefinition(var5);
							int var19;
							int var20;
							if (var9 != 1 && var9 != 3) {
								var19 = var18.sizeX;
								var20 = var18.sizeY;
							} else {
								var19 = var18.sizeY;
								var20 = var18.sizeX;
							}

							int var21 = var35 + (var19 >> 1);
							int var22 = var35 + (var19 + 1 >> 1);
							int var23 = var16 + (var20 >> 1);
							int var24 = var16 + (var20 + 1 >> 1);
							int[][] var25 = Tiles.Tiles_heights[class42.plane];
							int var26 = var25[var22][var23] + var25[var21][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
							int var27 = (var35 << 7) + (var19 << 6);
							int var28 = (var16 << 7) + (var20 << 6);
							Model var29 = var18.getModel(var8, var9, var25, var27, var26, var28);
							if (var29 != null) {
								MusicPatch.method3885(class42.plane, var35, var16, var10, -1, 0, 0, var6 + 1, var3 + 1);
								var17.animationCycleStart = var6 + Client.cycle;
								var17.animationCycleEnd = var3 + Client.cycle;
								var17.model0 = var29;
								var17.field633 = var35 * 128 + var19 * 64;
								var17.field620 = var16 * 128 + var20 * 64;
								var17.tileHeight2 = var26;
								byte var30;
								if (var37 > var13) {
									var30 = var37;
									var37 = var13;
									var13 = var30;
								}

								if (var11 > var38) {
									var30 = var11;
									var11 = var38;
									var38 = var30;
								}

								var17.field627 = var35 + var37;
								var17.field612 = var35 + var13;
								var17.field625 = var11 + var16;
								var17.field630 = var16 + var38;
							}
						}
					}

					if (class185.field2323 == var0) {
						var2 = var1.method5722();
						var3 = (var2 >> 4 & 7) + DefaultsGroup.field3819;
						var4 = (var2 & 7) + ChatChannel.field1306;
						var5 = var1.method5525();
						var6 = var5 >> 2;
						var7 = var5 & 3;
						var8 = Client.field713[var6];
						var9 = var1.method5518();
						if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
							MusicPatch.method3885(class42.plane, var3, var4, var8, var9, var6, var7, 0, -1);
						}

					} else if (class185.field2317 == var0) {
						var2 = var1.readUnsignedShort();
						var3 = var1.method5722();
						var4 = var1.method5518();
						var5 = var1.readUnsignedByte();
						var6 = (var5 >> 4 & 7) + DefaultsGroup.field3819;
						var7 = (var5 & 7) + ChatChannel.field1306;
						if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
							var6 = var6 * 128 + 64;
							var7 = var7 * 128 + 64;
							GraphicsObject var33 = new GraphicsObject(var2, class42.plane, var6, var7, ScriptEvent.getTileHeight(var6, var7, class42.plane) - var3, var4, Client.cycle);
							Client.graphicsObjects.addFirst(var33);
						}

					} else if (class185.field2324 == var0) {
						var2 = var1.method5525();
						var3 = var2 >> 2;
						var4 = var2 & 3;
						var5 = Client.field713[var3];
						var6 = var1.readUnsignedByteNegate();
						var7 = (var6 >> 4 & 7) + DefaultsGroup.field3819;
						var8 = (var6 & 7) + ChatChannel.field1306;
						var9 = var1.readUnsignedShort();
						if (var7 >= 0 && var8 >= 0 && var7 < 103 && var8 < 103) {
							if (var5 == 0) {
								BoundaryObject var36 = GrandExchangeOfferWorldComparator.scene.method3088(class42.plane, var7, var8);
								if (var36 != null) {
									var39 = class43.method770(var36.tag);
									if (var3 == 2) {
										var36.entity1 = new DynamicObject(var39, 2, var4 + 4, class42.plane, var7, var8, var9, false, var36.entity1);
										var36.entity2 = new DynamicObject(var39, 2, var4 + 1 & 3, class42.plane, var7, var8, var9, false, var36.entity2);
									} else {
										var36.entity1 = new DynamicObject(var39, var3, var4, class42.plane, var7, var8, var9, false, var36.entity1);
									}
								}
							}

							if (var5 == 1) {
								WallDecoration var43 = GrandExchangeOfferWorldComparator.scene.method3118(class42.plane, var7, var8);
								if (var43 != null) {
									var39 = class43.method770(var43.tag);
									if (var3 != 4 && var3 != 5) {
										if (var3 == 6) {
											var43.entity1 = new DynamicObject(var39, 4, var4 + 4, class42.plane, var7, var8, var9, false, var43.entity1);
										} else if (var3 == 7) {
											var43.entity1 = new DynamicObject(var39, 4, (var4 + 2 & 3) + 4, class42.plane, var7, var8, var9, false, var43.entity1);
										} else if (var3 == 8) {
											var43.entity1 = new DynamicObject(var39, 4, var4 + 4, class42.plane, var7, var8, var9, false, var43.entity1);
											var43.entity2 = new DynamicObject(var39, 4, (var4 + 2 & 3) + 4, class42.plane, var7, var8, var9, false, var43.entity2);
										}
									} else {
										var43.entity1 = new DynamicObject(var39, 4, var4, class42.plane, var7, var8, var9, false, var43.entity1);
									}
								}
							}

							if (var5 == 2) {
								GameObject var44 = GrandExchangeOfferWorldComparator.scene.method3195(class42.plane, var7, var8);
								if (var3 == 11) {
									var3 = 10;
								}

								if (var44 != null) {
									var44.entity = new DynamicObject(class43.method770(var44.tag), var3, var4, class42.plane, var7, var8, var9, false, var44.entity);
								}
							}

							if (var5 == 3) {
								FloorDecoration var45 = GrandExchangeOfferWorldComparator.scene.getFloorDecoration(class42.plane, var7, var8);
								if (var45 != null) {
									var45.entity = new DynamicObject(class43.method770(var45.tag), 22, var4, class42.plane, var7, var8, var9, false, var45.entity);
								}
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("hl")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "1662351965"
	)
	@Export("isWidgetMenuOpcode")
	static boolean isWidgetMenuOpcode(int var0) {
		return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
	}
}
