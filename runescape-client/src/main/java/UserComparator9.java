import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("eh")
@Implements("UserComparator9")
public class UserComparator9 extends AbstractUserComparator {
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator9(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "1918476759"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)[Lkl;",
		garbageValue = "-445895559"
	)
	static class310[] method3383() {
		return new class310[]{class310.field3817, class310.field3816, class310.field3818};
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lml;"
	)
	public static RunException method3390(Throwable var0, String var1) {
		RunException var2;
		if (var0 instanceof RunException) {
			var2 = (RunException)var0;
			var2.string = var2.string + ' ' + var1;
		} else {
			var2 = new RunException(var0, var1);
		}

		return var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(ILcx;ZS)I",
		garbageValue = "-7813"
	)
	static int method3389(int var0, Script var1, boolean var2) {
		boolean var3 = true;
		Widget var4;
		if (var0 >= 2000) {
			var0 -= 1000;
			var4 = class80.getWidget(Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize]);
			var3 = false;
		} else {
			var4 = var2 ? Interpreter.field1111 : Calendar.field2507;
		}

		int var11;
		if (var0 == ScriptOpcodes.CC_SETOP) {
			var11 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] - 1;
			if (var11 >= 0 && var11 <= 9) {
				var4.setAction(var11, Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize]);
				return 1;
			} else {
				--Skills.Interpreter_stringStackSize;
				return 1;
			}
		} else {
			int var6;
			if (var0 == ScriptOpcodes.CC_SETDRAGGABLE) {
				HealthBarUpdate.Interpreter_intStackSize -= 2;
				var11 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize];
				var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
				var4.parent = Client.getWidgetChild(var11, var6);
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGGABLEBEHAVIOR) {
				var4.isScrollBar = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADZONE) {
				var4.dragZoneSize = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETDRAGDEADTIME) {
				var4.dragThreshold = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETOPBASE) {
				var4.dataText = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_SETTARGETVERB) {
				var4.spellActionName = Interpreter.Interpreter_stringStack[--Skills.Interpreter_stringStackSize];
				return 1;
			} else if (var0 == ScriptOpcodes.CC_CLEAROPS) {
				var4.actions = null;
				return 1;
			} else if (var0 == 1308) {
				var4.field2691 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] == 1;
				return 1;
			} else {
				int var7;
				byte[] var9;
				if (var0 != ScriptOpcodes.CC_SETOPKEY) {
					byte var5;
					if (var0 == ScriptOpcodes.CC_SETOPTKEY) {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						var5 = 10;
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize]};
						byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]};
						FloorOverlayDefinition.method4756(var4, var5, var9, var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYRATE) {
						HealthBarUpdate.Interpreter_intStackSize -= 3;
						var11 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] - 1;
						var6 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1];
						var7 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 2];
						if (var11 >= 0 && var11 <= 9) {
							class14.method153(var4, var11, var6, var7);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYRATE) {
						var5 = 10;
						var6 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize];
						class14.method153(var4, var5, var6, var7);
						return 1;
					} else if (var0 == ScriptOpcodes.CC_SETOPKEYIGNOREHELD) {
						--HealthBarUpdate.Interpreter_intStackSize;
						var11 = Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize] - 1;
						if (var11 >= 0 && var11 <= 9) {
							WorldMapCacheName.method600(var4, var11);
							return 1;
						} else {
							throw new RuntimeException();
						}
					} else if (var0 == ScriptOpcodes.CC_SETOPTKEYIGNOREHELD) {
						var5 = 10;
						WorldMapCacheName.method600(var4, var5);
						return 1;
					} else {
						return 2;
					}
				} else {
					byte[] var8 = null;
					var9 = null;
					if (var3) {
						HealthBarUpdate.Interpreter_intStackSize -= 10;

						for (var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + HealthBarUpdate.Interpreter_intStackSize] >= 0; var7 += 2) {
						}

						if (var7 > 0) {
							var8 = new byte[var7 / 2];
							var9 = new byte[var7 / 2];

							for (var7 -= 2; var7 >= 0; var7 -= 2) {
								var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + HealthBarUpdate.Interpreter_intStackSize];
								var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + HealthBarUpdate.Interpreter_intStackSize + 1];
							}
						}
					} else {
						HealthBarUpdate.Interpreter_intStackSize -= 2;
						var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize]};
						var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[HealthBarUpdate.Interpreter_intStackSize + 1]};
					}

					var7 = Interpreter.Interpreter_intStack[--HealthBarUpdate.Interpreter_intStackSize] - 1;
					if (var7 >= 0 && var7 <= 9) {
						FloorOverlayDefinition.method4756(var4, var7, var8, var9);
						return 1;
					} else {
						throw new RuntimeException();
					}
				}
			}
		}
	}
}
