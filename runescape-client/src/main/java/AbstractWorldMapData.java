import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("el")
	@ObfuscatedGetter(
		intValue = -1739932713
	)
	static int field155;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -680308736
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1014181888
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 421939525
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1418471835
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1513175747
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -402229247
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -376642433
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1618366577
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("c")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("f")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("m")
	byte[][][] field165;
	@ObfuscatedName("u")
	byte[][][] field166;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "[[[[Lz;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("r")
	boolean field168;
	@ObfuscatedName("v")
	boolean field169;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field168 = false;
		this.field169 = false;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lkf;I)V",
		garbageValue = "-1951934103"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "-613524686"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field168 && this.field169;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhp;I)V",
		garbageValue = "1963301304"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field168 = true;
				this.field169 = true;
			}

		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1146093408"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field165 = null;
		this.field166 = null;
		this.decorations = null;
		this.field168 = false;
		this.field169 = false;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(IILkf;I)V",
		garbageValue = "-1521348339"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method258(var1, var2, var3, var4);
			} else {
				this.method253(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(IILkf;IB)V",
		garbageValue = "0"
	)
	void method258(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(IILkf;IB)V",
		garbageValue = "44"
	)
	void method253(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedByte();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field165[var9][var1][var2] = (byte)(var11 >> 2);
					this.field166[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method5511();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-121424149"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1967751745"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(IIB)I",
		garbageValue = "-108"
	)
	static int method274(int var0, int var1) {
		ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var2 == null) {
			return -1;
		} else {
			return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
		}
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-2108015148"
	)
	static final void method273(int var0, int var1, int var2, int var3) {
		ObjectSound.method1826();
	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(Lij;IIII)V",
		garbageValue = "566580282"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPCDefinition var0, int var1, int var2, int var3) {
		if (Client.menuOptionsCount < 400) {
			if (var0.transforms != null) {
				var0 = var0.transform();
			}

			if (var0 != null) {
				if (var0.isInteractable) {
					if (!var0.isFollower || Client.followerIndex == var1) {
						String var4 = var0.name;
						int var7;
						int var8;
						if (var0.combatLevel != 0) {
							var7 = var0.combatLevel;
							var8 = Client.localPlayer.combatLevel;
							int var9 = var8 - var7;
							String var6;
							if (var9 < -9) {
								var6 = ClientPreferences.colorStartTag(16711680);
							} else if (var9 < -6) {
								var6 = ClientPreferences.colorStartTag(16723968);
							} else if (var9 < -3) {
								var6 = ClientPreferences.colorStartTag(16740352);
							} else if (var9 < 0) {
								var6 = ClientPreferences.colorStartTag(16756736);
							} else if (var9 > 9) {
								var6 = ClientPreferences.colorStartTag(65280);
							} else if (var9 > 6) {
								var6 = ClientPreferences.colorStartTag(4259584);
							} else if (var9 > 3) {
								var6 = ClientPreferences.colorStartTag(8453888);
							} else if (var9 > 0) {
								var6 = ClientPreferences.colorStartTag(12648192);
							} else {
								var6 = ClientPreferences.colorStartTag(16776960);
							}

							var4 = var4 + var6 + " " + " (" + "level-" + var0.combatLevel + ")";
						}

						if (var0.isFollower && Client.followerOpsLowPriority) {
							class188.insertMenuItemNoShift("Examine", ClientPreferences.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							class188.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + ClientPreferences.colorStartTag(16776960) + var4, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((WorldMapCacheName.selectedSpellFlags & 2) == 2) {
								class188.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + ClientPreferences.colorStartTag(16776960) + var4, 8, var1, var2, var3);
							}
						} else {
							int var10 = var0.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var11 = var0.actions;
							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && !var11[var7].equalsIgnoreCase("Attack")) {
										var8 = 0;
										if (var7 == 0) {
											var8 = var10 + 9;
										}

										if (var7 == 1) {
											var8 = var10 + 10;
										}

										if (var7 == 2) {
											var8 = var10 + 11;
										}

										if (var7 == 3) {
											var8 = var10 + 12;
										}

										if (var7 == 4) {
											var8 = var10 + 13;
										}

										class188.insertMenuItemNoShift(var11[var7], ClientPreferences.colorStartTag(16776960) + var4, var8, var1, var2, var3);
									}
								}
							}

							if (var11 != null) {
								for (var7 = 4; var7 >= 0; --var7) {
									if (var11[var7] != null && var11[var7].equalsIgnoreCase("Attack")) {
										short var12 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var0.combatLevel > Client.localPlayer.combatLevel) {
												var12 = 2000;
											}

											var8 = 0;
											if (var7 == 0) {
												var8 = var12 + 9;
											}

											if (var7 == 1) {
												var8 = var12 + 10;
											}

											if (var7 == 2) {
												var8 = var12 + 11;
											}

											if (var7 == 3) {
												var8 = var12 + 12;
											}

											if (var7 == 4) {
												var8 = var12 + 13;
											}

											class188.insertMenuItemNoShift(var11[var7], ClientPreferences.colorStartTag(16776960) + var4, var8, var1, var2, var3);
										}
									}
								}
							}

							if (!var0.isFollower || !Client.followerOpsLowPriority) {
								class188.insertMenuItemNoShift("Examine", ClientPreferences.colorStartTag(16776960) + var4, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
