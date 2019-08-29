import java.awt.Image;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("f")
@Implements("GrandExchangeOfferUnitPriceComparator")
final class GrandExchangeOfferUnitPriceComparator implements Comparator {
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -1744737453
	)
	@Export("SpriteBuffer_spriteWidth")
	public static int SpriteBuffer_spriteWidth;
	@ObfuscatedName("as")
	static Image field74;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lq;Lq;I)I",
		garbageValue = "1336373316"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.grandExchangeOffer.unitPrice < var2.grandExchangeOffer.unitPrice ? -1 : (var2.grandExchangeOffer.unitPrice == var1.grandExchangeOffer.unitPrice ? 0 : 1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(II)Lig;",
		garbageValue = "-2004472785"
	)
	@Export("HealthBarDefinition_get")
	public static HealthBarDefinition HealthBarDefinition_get(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0);
			var1 = new HealthBarDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "75"
	)
	@Export("VarbitDefinition_clearCached")
	public static void VarbitDefinition_clearCached() {
		VarbitDefinition.VarbitDefinition_cached.clear();
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "1195585580"
	)
	static int method136(int var0, Script var1, boolean var2) {
		int var3;
		int var4;
		if (var0 == ScriptOpcodes.ADD) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SUB) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 - var4;
			return 1;
		} else if (var0 == ScriptOpcodes.MULTIPLY) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 * var4;
			return 1;
		} else if (var0 == ScriptOpcodes.DIV) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 / var4;
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOM) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
			return 1;
		} else if (var0 == ScriptOpcodes.RANDOMINC) {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
			return 1;
		} else if (var0 == ScriptOpcodes.INTERPOLATE) {
			Interpreter.Interpreter_intStackSize -= 5;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			int var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			int var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + (var4 - var3) * (var7 - var5) / (var6 - var5);
			return 1;
		} else if (var0 == ScriptOpcodes.ADDPERCENT) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + var4 * var3 / 100;
			return 1;
		} else if (var0 == ScriptOpcodes.SETBIT) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | 1 << var4;
			return 1;
		} else if (var0 == ScriptOpcodes.CLEARBIT) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
			return 1;
		} else if (var0 == ScriptOpcodes.TESTBIT) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.MOD) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 % var4;
			return 1;
		} else if (var0 == ScriptOpcodes.POW) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
			}

			return 1;
		} else if (var0 == ScriptOpcodes.INVPOW) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (var3 == 0) {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
				return 1;
			} else {
				switch(var4) {
				case 0:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
					break;
				case 1:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					break;
				case 2:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
					break;
				case 3:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
					break;
				case 4:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
					break;
				default:
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
				}

				return 1;
			}
		} else if (var0 == ScriptOpcodes.AND) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & var4;
			return 1;
		} else if (var0 == ScriptOpcodes.OR) {
			Interpreter.Interpreter_intStackSize -= 2;
			var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | var4;
			return 1;
		} else if (var0 == ScriptOpcodes.SCALE) {
			Interpreter.Interpreter_intStackSize -= 3;
			long var9 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			long var11 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			long var13 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(var9 * var13 / var11);
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("fg")
	@ObfuscatedSignature(
		signature = "(IIII)V",
		garbageValue = "773083265"
	)
	@Export("queueSoundEffect")
	static void queueSoundEffect(int var0, int var1, int var2) {
		if (Client.soundEffectVolume != 0 && var1 != 0 && Client.soundEffectCount < 50) {
			Client.soundEffectIds[Client.soundEffectCount] = var0;
			Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
			Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
			Client.soundEffects[Client.soundEffectCount] = null;
			Client.soundLocations[Client.soundEffectCount] = 0;
			++Client.soundEffectCount;
		}

	}

	@ObfuscatedName("fh")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-38"
	)
	static final void method133() {
		if (Client.field651 != ItemContainer.plane) {
			Client.field651 = ItemContainer.plane;
			AbstractWorldMapData.method264(ItemContainer.plane);
		}

	}

	@ObfuscatedName("hp")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "78"
	)
	@Export("readNpcUpdates")
	static final void readNpcUpdates() {
		PacketBuffer var0 = Client.packetWriter.packetBuffer;
		var0.importIndex();
		int var1 = var0.readBits(8);
		int var2;
		if (var1 < Client.npcCount) {
			for (var2 = var1; var2 < Client.npcCount; ++var2) {
				Client.field655[++Client.field899 - 1] = Client.npcIndices[var2];
			}
		}

		if (var1 > Client.npcCount) {
			throw new RuntimeException("");
		} else {
			Client.npcCount = 0;

			for (var2 = 0; var2 < var1; ++var2) {
				int var3 = Client.npcIndices[var2];
				NPC var4 = Client.npcs[var3];
				int var5 = var0.readBits(1);
				if (var5 == 0) {
					Client.npcIndices[++Client.npcCount - 1] = var3;
					var4.npcCycle = Client.cycle;
				} else {
					int var6 = var0.readBits(2);
					if (var6 == 0) {
						Client.npcIndices[++Client.npcCount - 1] = var3;
						var4.npcCycle = Client.cycle;
						Client.field669[++Client.field861 - 1] = var3;
					} else {
						int var7;
						int var8;
						if (var6 == 1) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method1961(var7, (byte)1);
							var8 = var0.readBits(1);
							if (var8 == 1) {
								Client.field669[++Client.field861 - 1] = var3;
							}
						} else if (var6 == 2) {
							Client.npcIndices[++Client.npcCount - 1] = var3;
							var4.npcCycle = Client.cycle;
							var7 = var0.readBits(3);
							var4.method1961(var7, (byte)2);
							var8 = var0.readBits(3);
							var4.method1961(var8, (byte)2);
							int var9 = var0.readBits(1);
							if (var9 == 1) {
								Client.field669[++Client.field861 - 1] = var3;
							}
						} else if (var6 == 3) {
							Client.field655[++Client.field899 - 1] = var3;
						}
					}
				}
			}

		}
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "-59560739"
	)
	static final String method127(int var0) {
		return var0 < 999999999 ? Integer.toString(var0) : "*";
	}

	@ObfuscatedName("km")
	@ObfuscatedSignature(
		signature = "(Lhp;IB)Ljava/lang/String;",
		garbageValue = "0"
	)
	static String method125(Widget var0, int var1) {
		int var3 = ParamDefinition.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
