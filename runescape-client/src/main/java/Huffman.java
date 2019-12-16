import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("Huffman")
public class Huffman {
	@ObfuscatedName("f")
	@Export("masks")
	int[] masks;
	@ObfuscatedName("i")
	@Export("bits")
	byte[] bits;
	@ObfuscatedName("y")
	@Export("keys")
	int[] keys;

	public Huffman(byte[] var1) {
		int var2 = var1.length;
		this.masks = new int[var2];
		this.bits = var1;
		int[] var3 = new int[33];
		this.keys = new int[8];
		int var4 = 0;

		for (int var5 = 0; var5 < var2; ++var5) {
			byte var6 = var1[var5];
			if (var6 != 0) {
				int var7 = 1 << 32 - var6;
				int var8 = var3[var6];
				this.masks[var5] = var8;
				int var9;
				int var10;
				int var11;
				int var12;
				if ((var8 & var7) != 0) {
					var9 = var3[var6 - 1];
				} else {
					var9 = var8 | var7;

					for (var10 = var6 - 1; var10 >= 1; --var10) {
						var11 = var3[var10];
						if (var8 != var11) {
							break;
						}

						var12 = 1 << 32 - var10;
						if ((var11 & var12) != 0) {
							var3[var10] = var3[var10 - 1];
							break;
						}

						var3[var10] = var11 | var12;
					}
				}

				var3[var6] = var9;

				for (var10 = var6 + 1; var10 <= 32; ++var10) {
					if (var8 == var3[var10]) {
						var3[var10] = var9;
					}
				}

				var10 = 0;

				for (var11 = 0; var11 < var6; ++var11) {
					var12 = Integer.MIN_VALUE >>> var11;
					if ((var8 & var12) != 0) {
						if (this.keys[var10] == 0) {
							this.keys[var10] = var4;
						}

						var10 = this.keys[var10];
					} else {
						++var10;
					}

					if (var10 >= this.keys.length) {
						int[] var13 = new int[this.keys.length * 2];

						for (int var14 = 0; var14 < this.keys.length; ++var14) {
							var13[var14] = this.keys[var14];
						}

						this.keys = var13;
					}

					var12 >>>= 1;
				}

				this.keys[var10] = ~var5;
				if (var10 >= var4) {
					var4 = var10 + 1;
				}
			}
		}

	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "([BII[BII)I",
		garbageValue = "918574893"
	)
	@Export("compress")
	int compress(byte[] var1, int var2, int var3, byte[] var4, int var5) {
		int var6 = 0;
		int var7 = var5 << 3;

		for (var3 += var2; var2 < var3; ++var2) {
			int var8 = var1[var2] & 255;
			int var9 = this.masks[var8];
			byte var10 = this.bits[var8];
			if (var10 == 0) {
				throw new RuntimeException("" + var8);
			}

			int var11 = var7 >> 3;
			int var12 = var7 & 7;
			var6 &= -var12 >> 31;
			int var13 = (var12 + var10 - 1 >> 3) + var11;
			var12 += 24;
			var4[var11] = (byte)(var6 |= var9 >>> var12);
			if (var11 < var13) {
				++var11;
				var12 -= 8;
				var4[var11] = (byte)(var6 = var9 >>> var12);
				if (var11 < var13) {
					++var11;
					var12 -= 8;
					var4[var11] = (byte)(var6 = var9 >>> var12);
					if (var11 < var13) {
						++var11;
						var12 -= 8;
						var4[var11] = (byte)(var6 = var9 >>> var12);
						if (var11 < var13) {
							++var11;
							var12 -= 8;
							var4[var11] = (byte)(var6 = var9 << -var12);
						}
					}
				}
			}

			var7 += var10;
		}

		return (var7 + 7 >> 3) - var5;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BI[BIII)I",
		garbageValue = "273462814"
	)
	@Export("decompress")
	int decompress(byte[] var1, int var2, byte[] var3, int var4, int var5) {
		if (var5 == 0) {
			return 0;
		} else {
			int var6 = 0;
			var5 += var4;
			int var7 = var2;

			while (true) {
				byte var8 = var1[var7];
				if (var8 < 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				int var9;
				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 64) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 32) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 16) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 8) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 4) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 2) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				if ((var8 & 1) != 0) {
					var6 = this.keys[var6];
				} else {
					++var6;
				}

				if ((var9 = this.keys[var6]) < 0) {
					var3[var4++] = (byte)(~var9);
					if (var4 >= var5) {
						break;
					}

					var6 = 0;
				}

				++var7;
			}

			return var7 + 1 - var2;
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "2034773594"
	)
	public static void method3917() {
		VarbitDefinition.VarbitDefinition_cached.clear();
	}

	@ObfuscatedName("ig")
	@ObfuscatedSignature(
		signature = "(IIIIB)V",
		garbageValue = "-1"
	)
	@Export("addSceneMenuOptions")
	static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
		if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
			class1.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
		}

		long var4 = -1L;
		long var6 = -1L;

		int var8;
		for (var8 = 0; var8 < class192.method3654(); ++var8) {
			long var9 = class14.method152(var8);
			if (var9 != var6) {
				var6 = var9;
				int var23 = class288.method5334(ViewportMouse.ViewportMouse_entityTags[var8]);
				int var12 = var23;
				int var13 = class117.method2760(var8);
				int var14 = CollisionMap.method3555(var8);
				int var15 = WorldMapSection2.method322(var8);
				if (var14 == 2 && class14.scene.getObjectFlags(UrlRequest.Client_plane, var23, var13, var9) >= 0) {
					ObjectDefinition var16 = Coord.getObjectDefinition(var15);
					if (var16.transforms != null) {
						var16 = var16.transform();
					}

					if (var16 == null) {
						continue;
					}

					if (Client.isItemSelected == 1) {
						class1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + NPC.colorStartTag(65535) + var16.name, 1, var15, var23, var13);
					} else if (Client.isSpellSelected) {
						if ((ReflectionCheck.selectedSpellFlags & 4) == 4) {
							class1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + NPC.colorStartTag(65535) + var16.name, 2, var15, var23, var13);
						}
					} else {
						String[] var24 = var16.actions;
						if (var24 != null) {
							for (int var25 = 4; var25 >= 0; --var25) {
								if (var24[var25] != null) {
									short var19 = 0;
									if (var25 == 0) {
										var19 = 3;
									}

									if (var25 == 1) {
										var19 = 4;
									}

									if (var25 == 2) {
										var19 = 5;
									}

									if (var25 == 3) {
										var19 = 6;
									}

									if (var25 == 4) {
										var19 = 1001;
									}

									class1.insertMenuItemNoShift(var24[var25], NPC.colorStartTag(65535) + var16.name, var19, var15, var12, var13);
								}
							}
						}

						class1.insertMenuItemNoShift("Examine", NPC.colorStartTag(65535) + var16.name, 1002, var16.id, var12, var13);
					}
				}

				int var17;
				NPC var18;
				Player var20;
				int[] var31;
				int var33;
				if (var14 == 1) {
					NPC var28 = Client.npcs[var15];
					if (var28 == null) {
						continue;
					}

					if (var28.definition.size == 1 && (var28.x & 127) == 64 && (var28.y & 127) == 64) {
						for (var17 = 0; var17 < Client.npcCount; ++var17) {
							var18 = Client.npcs[Client.npcIndices[var17]];
							if (var18 != null && var18 != var28 && var18.definition.size == 1 && var18.x == var28.x && var28.y == var18.y) {
								DefaultsGroup.addNpcToMenu(var18.definition, Client.npcIndices[var17], var12, var13);
							}
						}

						var17 = Players.Players_count;
						var31 = Players.Players_indices;

						for (var33 = 0; var33 < var17; ++var33) {
							var20 = Client.players[var31[var33]];
							if (var20 != null && var28.x == var20.x && var20.y == var28.y) {
								class30.addPlayerToMenu(var20, var31[var33], var12, var13);
							}
						}
					}

					DefaultsGroup.addNpcToMenu(var28.definition, var15, var12, var13);
				}

				if (var14 == 0) {
					Player var29 = Client.players[var15];
					if (var29 == null) {
						continue;
					}

					if ((var29.x & 127) == 64 && (var29.y & 127) == 64) {
						for (var17 = 0; var17 < Client.npcCount; ++var17) {
							var18 = Client.npcs[Client.npcIndices[var17]];
							if (var18 != null && var18.definition.size == 1 && var29.x == var18.x && var18.y == var29.y) {
								DefaultsGroup.addNpcToMenu(var18.definition, Client.npcIndices[var17], var12, var13);
							}
						}

						var17 = Players.Players_count;
						var31 = Players.Players_indices;

						for (var33 = 0; var33 < var17; ++var33) {
							var20 = Client.players[var31[var33]];
							if (var20 != null && var20 != var29 && var20.x == var29.x && var20.y == var29.y) {
								class30.addPlayerToMenu(var20, var31[var33], var12, var13);
							}
						}
					}

					if (var15 != Client.combatTargetPlayerIndex) {
						class30.addPlayerToMenu(var29, var15, var12, var13);
					} else {
						var4 = var9;
					}
				}

				if (var14 == 3) {
					NodeDeque var30 = Client.groundItems[UrlRequest.Client_plane][var12][var13];
					if (var30 != null) {
						for (TileItem var34 = (TileItem)var30.first(); var34 != null; var34 = (TileItem)var30.next()) {
							ItemDefinition var32 = PacketBufferNode.ItemDefinition_get(var34.id);
							if (Client.isItemSelected == 1) {
								class1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + NPC.colorStartTag(16748608) + var32.name, 16, var34.id, var12, var13);
							} else if (Client.isSpellSelected) {
								if ((ReflectionCheck.selectedSpellFlags & 1) == 1) {
									class1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + NPC.colorStartTag(16748608) + var32.name, 17, var34.id, var12, var13);
								}
							} else {
								String[] var26 = var32.groundActions;

								for (int var27 = 4; var27 >= 0; --var27) {
									if (var26 != null && var26[var27] != null) {
										byte var21 = 0;
										if (var27 == 0) {
											var21 = 18;
										}

										if (var27 == 1) {
											var21 = 19;
										}

										if (var27 == 2) {
											var21 = 20;
										}

										if (var27 == 3) {
											var21 = 21;
										}

										if (var27 == 4) {
											var21 = 22;
										}

										class1.insertMenuItemNoShift(var26[var27], NPC.colorStartTag(16748608) + var32.name, var21, var34.id, var12, var13);
									} else if (var27 == 2) {
										class1.insertMenuItemNoShift("Take", NPC.colorStartTag(16748608) + var32.name, 20, var34.id, var12, var13);
									}
								}

								class1.insertMenuItemNoShift("Examine", NPC.colorStartTag(16748608) + var32.name, 1004, var34.id, var12, var13);
							}
						}
					}
				}
			}
		}

		if (-1L != var4) {
			var8 = class288.method5334(var4);
			int var22 = (int)(var4 >>> 7 & 127L);
			Player var11 = Client.players[Client.combatTargetPlayerIndex];
			class30.addPlayerToMenu(var11, Client.combatTargetPlayerIndex, var8, var22);
		}

	}
}
