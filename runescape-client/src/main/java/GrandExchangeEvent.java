import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1358084805
	)
	@Export("world")
	public final int world;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = 5655370423736122045L
	)
	@Export("age")
	public final long age;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Li;"
	)
	@Export("grandExchangeOffer")
	public final GrandExchangeOffer grandExchangeOffer;
	@ObfuscatedName("u")
	@Export("offerName")
	String offerName;
	@ObfuscatedName("r")
	@Export("previousOfferName")
	String previousOfferName;

	@ObfuscatedSignature(
		signature = "(Lkl;BI)V"
	)
	GrandExchangeEvent(Buffer var1, byte var2, int var3) {
		this.offerName = var1.readStringCp1252NullTerminated();
		this.previousOfferName = var1.readStringCp1252NullTerminated();
		this.world = var1.readUnsignedShort();
		this.age = var1.readLong();
		int var4 = var1.readInt();
		int var5 = var1.readInt();
		this.grandExchangeOffer = new GrandExchangeOffer();
		this.grandExchangeOffer.method110(2);
		this.grandExchangeOffer.method117(var2);
		this.grandExchangeOffer.unitPrice = var4;
		this.grandExchangeOffer.totalQuantity = var5;
		this.grandExchangeOffer.currentQuantity = 0;
		this.grandExchangeOffer.currentPrice = 0;
		this.grandExchangeOffer.id = var3;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "963027705"
	)
	@Export("getOfferName")
	public String getOfferName() {
		return this.offerName;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)Ljava/lang/String;",
		garbageValue = "1720570985"
	)
	@Export("getPreviousOfferName")
	public String getPreviousOfferName() {
		return this.previousOfferName;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "33"
	)
	public static void method83() {
		HitSplatDefinition.HitSplatDefinition_cached.clear();
		HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
		HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
	}

	@ObfuscatedName("gj")
	@ObfuscatedSignature(
		signature = "(Lbt;B)V",
		garbageValue = "76"
	)
	static final void method88(PendingSpawn var0) {
		long var1 = 0L;
		int var3 = -1;
		int var4 = 0;
		int var5 = 0;
		if (var0.type == 0) {
			var1 = PacketWriter.scene.getBoundaryObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 1) {
			var1 = PacketWriter.scene.getWallDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 2) {
			var1 = PacketWriter.scene.getGameObjectTag(var0.plane, var0.x, var0.y);
		}

		if (var0.type == 3) {
			var1 = PacketWriter.scene.getFloorDecorationTag(var0.plane, var0.x, var0.y);
		}

		if (0L != var1) {
			int var6 = PacketWriter.scene.getObjectFlags(var0.plane, var0.x, var0.y, var1);
			var3 = class81.Entity_unpackID(var1);
			var4 = var6 & 31;
			var5 = var6 >> 6 & 3;
		}

		var0.objectId = var3;
		var0.field921 = var4;
		var0.field922 = var5;
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		signature = "(Lbi;IIII)V",
		garbageValue = "1547441010"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (class223.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				int var7;
				if (var0.skillLevel == 0) {
					String var5 = var0.actions[0] + var0.username + var0.actions[1];
					var7 = var0.combatLevel;
					int var8 = class223.localPlayer.combatLevel;
					int var9 = var8 - var7;
					String var6;
					if (var9 < -9) {
						var6 = World.colorStartTag(16711680);
					} else if (var9 < -6) {
						var6 = World.colorStartTag(16723968);
					} else if (var9 < -3) {
						var6 = World.colorStartTag(16740352);
					} else if (var9 < 0) {
						var6 = World.colorStartTag(16756736);
					} else if (var9 > 9) {
						var6 = World.colorStartTag(65280);
					} else if (var9 > 6) {
						var6 = World.colorStartTag(4259584);
					} else if (var9 > 3) {
						var6 = World.colorStartTag(8453888);
					} else if (var9 > 0) {
						var6 = World.colorStartTag(12648192);
					} else {
						var6 = World.colorStartTag(16776960);
					}

					var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var10;
				if (Client.isItemSelected == 1) {
					WorldMapData_1.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + World.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((ItemContainer.selectedSpellFlags & 8) == 8) {
						WorldMapData_1.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + World.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var10 = 7; var10 >= 0; --var10) {
						if (Client.playerMenuActions[var10] != null) {
							short var11 = 0;
							if (Client.playerMenuActions[var10].equalsIgnoreCase("Attack")) {
								if (AttackOption.AttackOption_hidden == Client.playerAttackOption) {
									continue;
								}

								if (AttackOption.AttackOption_alwaysRightClick == Client.playerAttackOption || Client.playerAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var0.combatLevel > class223.localPlayer.combatLevel) {
									var11 = 2000;
								}

								if (class223.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == class223.localPlayer.team) {
										var11 = 2000;
									} else {
										var11 = 0;
									}
								}
							} else if (Client.playerOptionsPriorities[var10]) {
								var11 = 2000;
							}

							boolean var12 = false;
							var7 = Client.playerMenuOpcodes[var10] + var11;
							WorldMapData_1.insertMenuItemNoShift(Client.playerMenuActions[var10], World.colorStartTag(16777215) + var4, var7, var1, var2, var3);
						}
					}
				}

				for (var10 = 0; var10 < Client.menuOptionsCount; ++var10) {
					if (Client.menuOpcodes[var10] == 23) {
						Client.menuTargets[var10] = World.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}
}
