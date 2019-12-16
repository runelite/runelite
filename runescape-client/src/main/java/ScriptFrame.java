import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("bk")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lls;"
	)
	@Export("rightTitleSprite")
	static Sprite rightTitleSprite;
	@ObfuscatedName("fc")
	@ObfuscatedSignature(
		signature = "Lko;"
	)
	@Export("fontPlain12")
	static Font fontPlain12;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lcu;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -894059765
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("y")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("w")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "68267919"
	)
	public static int method1109(int var0) {
		var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
		var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
		var0 = var0 + (var0 >>> 4) & 252645135;
		var0 += var0 >>> 8;
		var0 += var0 >>> 16;
		return var0 & 255;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(CI)C",
		garbageValue = "-1576497419"
	)
	static char method1110(char var0) {
		return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1395741259"
	)
	static int method1111(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERTYPE) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERITEM) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERPRICE) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFEREMPTY) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERSTABLE) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERFINISHED) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERADDING) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_NAME) {
					var13 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					if (Script.grandExchangeEvents != null) {
						Script.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_PRICE) {
					var13 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					if (Script.grandExchangeEvents != null) {
						Script.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					class188.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1] == 1;
					if (Script.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						Script.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_AGE) {
					var13 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					if (Script.grandExchangeEvents != null) {
						Script.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_COUNT) {
					var13 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize] == 1;
					if (Script.grandExchangeEvents != null) {
						Script.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_GETTOTALOFFERS) {
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = Script.grandExchangeEvents == null ? 0 : Script.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERWORLD) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERNAME) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var11.getOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERAGE) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						long var5 = WorldMapID.currentTimeMillis() - TileItemPile.field1522 - var11.age;
						int var7 = (int)(var5 / 3600000L);
						int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
						int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERCOUNT) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPRICE) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERITEM) {
						var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)Script.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "-2033386176"
	)
	static int method1112(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.OC_NAME) {
			var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = PacketBufferNode.ItemDefinition_get(var3).name;
			return 1;
		} else {
			int var4;
			ItemDefinition var5;
			if (var0 == ScriptOpcodes.OC_OP) {
				class188.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				var5 = PacketBufferNode.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_IOP) {
				class188.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[class188.Interpreter_intStackSize + 1];
				var5 = PacketBufferNode.ItemDefinition_get(var3);
				if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
				} else {
					Interpreter.Interpreter_stringStack[++class65.Interpreter_stringStackSize - 1] = "";
				}

				return 1;
			} else if (var0 == ScriptOpcodes.OC_COST) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = PacketBufferNode.ItemDefinition_get(var3).price;
				return 1;
			} else if (var0 == ScriptOpcodes.OC_STACKABLE) {
				var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = PacketBufferNode.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
				return 1;
			} else {
				ItemDefinition var6;
				if (var0 == ScriptOpcodes.OC_CERT) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					var6 = PacketBufferNode.ItemDefinition_get(var3);
					if (var6.noteTemplate == -1 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNCERT) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					var6 = PacketBufferNode.ItemDefinition_get(var3);
					if (var6.noteTemplate >= 0 && var6.note >= 0) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.note;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_MEMBERS) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = PacketBufferNode.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
					return 1;
				} else if (var0 == ScriptOpcodes.OC_PLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					var6 = PacketBufferNode.ItemDefinition_get(var3);
					if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_UNPLACEHOLDER) {
					var3 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					var6 = PacketBufferNode.ItemDefinition_get(var3);
					if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var6.placeholder;
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = var3;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.OC_FIND) {
					String var7 = Interpreter.Interpreter_stringStack[--class65.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--class188.Interpreter_intStackSize];
					WorldMapSectionType.findItemDefinitions(var7, var4 == 1);
					Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = KeyHandler.foundItemIdCount;
					return 1;
				} else if (var0 != ScriptOpcodes.OC_FINDNEXT) {
					if (var0 == ScriptOpcodes.OC_FINDRESET) {
						class189.foundItemIndex = 0;
						return 1;
					} else {
						return 2;
					}
				} else {
					if (class269.foundItemIds != null && class189.foundItemIndex < KeyHandler.foundItemIdCount) {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = class269.foundItemIds[++class189.foundItemIndex - 1] & '\uffff';
					} else {
						Interpreter.Interpreter_intStack[++class188.Interpreter_intStackSize - 1] = -1;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "1546700501"
	)
	@Export("playSoundJingle")
	static void playSoundJingle(int var0, int var1) {
		if (Client.musicVolume != 0 && var0 != -1) {
			class173.playMusicTrack(class48.archive11, var0, 0, Client.musicVolume, false);
			Client.field767 = true;
		}

	}

	@ObfuscatedName("ki")
	@ObfuscatedSignature(
		signature = "(IIII)Lbz;",
		garbageValue = "-1435666355"
	)
	static final InterfaceParent method1107(int var0, int var1, int var2) {
		InterfaceParent var3 = new InterfaceParent();
		var3.group = var1;
		var3.type = var2;
		Client.interfaceParents.put(var3, (long)var0);
		GameShell.Widget_resetModelFrames(var1);
		Widget var4 = Tile.getWidget(var0);
		LoginPacket.invalidateWidget(var4);
		if (Client.meslayerContinueWidget != null) {
			LoginPacket.invalidateWidget(Client.meslayerContinueWidget);
			Client.meslayerContinueWidget = null;
		}

		Strings.method4096();
		Messages.revalidateWidgetScroll(UserComparator7.Widget_interfaceComponents[var0 >> 16], var4, false);
		Players.runWidgetOnLoadListener(var1);
		if (Client.rootInterface != -1) {
			ItemContainer.runIntfCloseListeners(Client.rootInterface, 1);
		}

		return var3;
	}
}
