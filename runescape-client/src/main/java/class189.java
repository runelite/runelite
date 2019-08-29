import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gw")
public class class189 {
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = 1476121683
	)
	static int field2328;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Ldh;"
	)
	@Export("soundCache")
	public static SoundCache soundCache;

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lkx;I)V",
		garbageValue = "1395104322"
	)
	static final void method3594(PacketBuffer var0) {
		int var1 = 0;
		var0.importIndex();

		byte[] var10000;
		int var2;
		int var3;
		int var4;
		for (var2 = 0; var2 < Players.Players_count; ++var2) {
			var3 = Players.Players_indices[var2];
			if ((Players.field1221[var3] & 1) == 0) {
				if (var1 > 0) {
					--var1;
					var10000 = Players.field1221;
					var10000[var3] = (byte)(var10000[var3] | 2);
				} else {
					var4 = var0.readBits(1);
					if (var4 == 0) {
						var1 = UserComparator9.decode(var0);
						var10000 = Players.field1221;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						StudioGame.readPlayerUpdate(var0, var3);
					}
				}
			}
		}

		var0.exportIndex();
		if (var1 != 0) {
			throw new RuntimeException();
		} else {
			var0.importIndex();

			for (var2 = 0; var2 < Players.Players_count; ++var2) {
				var3 = Players.Players_indices[var2];
				if ((Players.field1221[var3] & 1) != 0) {
					if (var1 > 0) {
						--var1;
						var10000 = Players.field1221;
						var10000[var3] = (byte)(var10000[var3] | 2);
					} else {
						var4 = var0.readBits(1);
						if (var4 == 0) {
							var1 = UserComparator9.decode(var0);
							var10000 = Players.field1221;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							StudioGame.readPlayerUpdate(var0, var3);
						}
					}
				}
			}

			var0.exportIndex();
			if (var1 != 0) {
				throw new RuntimeException();
			} else {
				var0.importIndex();

				for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
					var3 = Players.Players_emptyIndices[var2];
					if ((Players.field1221[var3] & 1) != 0) {
						if (var1 > 0) {
							--var1;
							var10000 = Players.field1221;
							var10000[var3] = (byte)(var10000[var3] | 2);
						} else {
							var4 = var0.readBits(1);
							if (var4 == 0) {
								var1 = UserComparator9.decode(var0);
								var10000 = Players.field1221;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else if (WorldMapLabelSize.updateExternalPlayer(var0, var3)) {
								var10000 = Players.field1221;
								var10000[var3] = (byte)(var10000[var3] | 2);
							}
						}
					}
				}

				var0.exportIndex();
				if (var1 != 0) {
					throw new RuntimeException();
				} else {
					var0.importIndex();

					for (var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
						var3 = Players.Players_emptyIndices[var2];
						if ((Players.field1221[var3] & 1) == 0) {
							if (var1 > 0) {
								--var1;
								var10000 = Players.field1221;
								var10000[var3] = (byte)(var10000[var3] | 2);
							} else {
								var4 = var0.readBits(1);
								if (var4 == 0) {
									var1 = UserComparator9.decode(var0);
									var10000 = Players.field1221;
									var10000[var3] = (byte)(var10000[var3] | 2);
								} else if (WorldMapLabelSize.updateExternalPlayer(var0, var3)) {
									var10000 = Players.field1221;
									var10000[var3] = (byte)(var10000[var3] | 2);
								}
							}
						}
					}

					var0.exportIndex();
					if (var1 != 0) {
						throw new RuntimeException();
					} else {
						Players.Players_count = 0;
						Players.Players_emptyIdxCount = 0;

						for (var2 = 1; var2 < 2048; ++var2) {
							var10000 = Players.field1221;
							var10000[var2] = (byte)(var10000[var2] >> 1);
							Player var5 = Client.players[var2];
							if (var5 != null) {
								Players.Players_indices[++Players.Players_count - 1] = var2;
							} else {
								Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
							}
						}

					}
				}
			}
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "1903618093"
	)
	public static String method3596(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = UserComparator8.method3342(var5);
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

	@ObfuscatedName("hw")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "638834022"
	)
	@Export("updateItemPile")
	static final void updateItemPile(int var0, int var1) {
		NodeDeque var2 = Client.groundItems[ItemContainer.plane][var0][var1];
		if (var2 == null) {
			Player.scene.removeGroundItemPile(ItemContainer.plane, var0, var1);
		} else {
			long var3 = -99999999L;
			TileItem var5 = null;

			TileItem var6;
			for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
				ItemDefinition var7 = WorldMapData_0.ItemDefinition_get(var6.id);
				long var8 = (long)var7.price;
				if (var7.isStackable == 1) {
					var8 *= (long)(var6.quantity + 1);
				}

				if (var8 > var3) {
					var3 = var8;
					var5 = var6;
				}
			}

			if (var5 == null) {
				Player.scene.removeGroundItemPile(ItemContainer.plane, var0, var1);
			} else {
				var2.addLast(var5);
				TileItem var12 = null;
				TileItem var11 = null;

				for (var6 = (TileItem)var2.last(); var6 != null; var6 = (TileItem)var2.previous()) {
					if (var6.id != var5.id) {
						if (var12 == null) {
							var12 = var6;
						}

						if (var12.id != var6.id && var11 == null) {
							var11 = var6;
						}
					}
				}

				long var9 = WorldMapSprite.calculateTag(var0, var1, 3, false, 0);
				Player.scene.newGroundItemPile(ItemContainer.plane, var0, var1, GrandExchangeOfferTotalQuantityComparator.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, ItemContainer.plane), var5, var9, var12, var11);
			}
		}
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Lhp;B)Ljava/lang/String;",
		garbageValue = "0"
	)
	static String method3597(String var0, Widget var1) {
		if (var0.indexOf("%") != -1) {
			for (int var2 = 1; var2 <= 5; ++var2) {
				while (true) {
					int var3 = var0.indexOf("%" + var2);
					if (var3 == -1) {
						break;
					}

					var0 = var0.substring(0, var3) + GrandExchangeOfferUnitPriceComparator.method127(AbstractByteArrayCopier.method3868(var1, var2 - 1)) + var0.substring(var3 + 2);
				}
			}
		}

		return var0;
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "([Lhp;II)V",
		garbageValue = "2135074914"
	)
	@Export("runComponentCloseListeners")
	static final void runComponentCloseListeners(Widget[] var0, int var1) {
		for (int var2 = 0; var2 < var0.length; ++var2) {
			Widget var3 = var0[var2];
			if (var3 != null) {
				if (var3.type == 0) {
					if (var3.children != null) {
						runComponentCloseListeners(var3.children, var1);
					}

					InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var3.id);
					if (var4 != null) {
						UserComparator6.runIntfCloseListeners(var4.group, var1);
					}
				}

				ScriptEvent var5;
				if (var1 == 0 && var3.onDialogAbort != null) {
					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onDialogAbort;
					class81.runScriptEvent(var5);
				}

				if (var1 == 1 && var3.onSubChange != null) {
					if (var3.childIndex >= 0) {
						Widget var6 = WorldMapElement.getWidget(var3.id);
						if (var6 == null || var6.children == null || var3.childIndex >= var6.children.length || var3 != var6.children[var3.childIndex]) {
							continue;
						}
					}

					var5 = new ScriptEvent();
					var5.widget = var3;
					var5.args = var3.onSubChange;
					class81.runScriptEvent(var5);
				}
			}
		}

	}
}
