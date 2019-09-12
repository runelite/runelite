import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fk")
@Implements("Clock")
public abstract class Clock {
	Clock() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-250719361"
	)
	@Export("mark")
	public abstract void mark();

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(III)I",
		garbageValue = "1652957447"
	)
	@Export("wait")
	public abstract int wait(int var1, int var2);

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		signature = "(ILcu;ZI)I",
		garbageValue = "1861663871"
	)
	static int method3490(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERTYPE) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].type();
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERITEM) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].id;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERPRICE) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].unitPrice;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].totalQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDCOUNT) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentQuantity;
			return 1;
		} else if (var0 == ScriptOpcodes.STOCKMARKET_GETOFFERCOMPLETEDGOLD) {
			var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.grandExchangeOffers[var3].currentPrice;
			return 1;
		} else {
			int var12;
			if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFEREMPTY) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var12 == 0 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERSTABLE) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var12 == 2 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERFINISHED) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var12 == 5 ? 1 : 0;
				return 1;
			} else if (var0 == ScriptOpcodes.STOCKMARKET_ISOFFERADDING) {
				var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
				var12 = Client.grandExchangeOffers[var3].status();
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var12 == 1 ? 1 : 0;
				return 1;
			} else {
				boolean var13;
				if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_NAME) {
					var13 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					if (PacketWriter.grandExchangeEvents != null) {
						PacketWriter.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_nameComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_PRICE) {
					var13 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					if (PacketWriter.grandExchangeEvents != null) {
						PacketWriter.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_priceComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTFILTERBY_WORLD) {
					class160.Interpreter_intStackSize -= 2;
					var13 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize] == 1;
					boolean var4 = Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1] == 1;
					if (PacketWriter.grandExchangeEvents != null) {
						Client.GrandExchangeEvents_worldComparator.filterWorlds = var4;
						PacketWriter.grandExchangeEvents.sort(Client.GrandExchangeEvents_worldComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_AGE) {
					var13 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					if (PacketWriter.grandExchangeEvents != null) {
						PacketWriter.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_ageComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_SORTBY_COUNT) {
					var13 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize] == 1;
					if (PacketWriter.grandExchangeEvents != null) {
						PacketWriter.grandExchangeEvents.sort(GrandExchangeEvents.GrandExchangeEvents_quantityComparator, var13);
					}

					return 1;
				} else if (var0 == ScriptOpcodes.TRADINGPOST_GETTOTALOFFERS) {
					Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = PacketWriter.grandExchangeEvents == null ? 0 : PacketWriter.grandExchangeEvents.events.size();
					return 1;
				} else {
					GrandExchangeEvent var11;
					if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERWORLD) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var11.world;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERNAME) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var11.getOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPREVIOUSNAME) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var11.getPreviousOfferName();
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERAGE) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						long var5 = SoundCache.method2480() - GrandExchangeOfferWorldComparator.field25 - var11.age;
						int var7 = (int)(var5 / 3600000L);
						int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
						int var9 = (int)((var5 - (long)(var7 * 3600000) - (long)(var8 * 60000)) / 1000L);
						String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
						Interpreter.Interpreter_stringStack[++TextureProvider.Interpreter_stringStackSize - 1] = var10;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERCOUNT) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.totalQuantity;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERPRICE) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.unitPrice;
						return 1;
					} else if (var0 == ScriptOpcodes.TRADINGPOST_GETOFFERITEM) {
						var3 = Interpreter.Interpreter_intStack[--class160.Interpreter_intStackSize];
						var11 = (GrandExchangeEvent)PacketWriter.grandExchangeEvents.events.get(var3);
						Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = var11.grandExchangeOffer.id;
						return 1;
					} else {
						return 2;
					}
				}
			}
		}
	}
}
