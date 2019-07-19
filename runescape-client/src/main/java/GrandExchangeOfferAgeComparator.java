import java.awt.FontMetrics;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("x")
@Implements("GrandExchangeOfferAgeComparator")
final class GrandExchangeOfferAgeComparator implements Comparator {
	@ObfuscatedName("ad")
	static FontMetrics field80;
	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		signature = "[Llx;"
	)
	@Export("scrollBarSprites")
	static IndexedSprite[] scrollBarSprites;

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Li;Li;I)I",
		garbageValue = "-502692128"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.age < var2.age ? -1 : (var2.age == var1.age ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-1058025130"
	)
	@Export("itemContainerSetItem")
	static void itemContainerSetItem(int var0, int var1, int var2, int var3) {
		ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var4 == null) {
			var4 = new ItemContainer();
			ItemContainer.itemContainers.put(var4, (long)var0);
		}

		if (var4.ids.length <= var1) {
			int[] var5 = new int[var1 + 1];
			int[] var6 = new int[var1 + 1];

			int var7;
			for (var7 = 0; var7 < var4.ids.length; ++var7) {
				var5[var7] = var4.ids[var7];
				var6[var7] = var4.quantities[var7];
			}

			for (var7 = var4.ids.length; var7 < var1; ++var7) {
				var5[var7] = -1;
				var6[var7] = 0;
			}

			var4.ids = var5;
			var4.quantities = var6;
		}

		var4.ids[var1] = var2;
		var4.quantities[var1] = var3;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1192487451"
	)
	@Export("clearItemContainer")
	static void clearItemContainer(int var0) {
		ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
		if (var1 != null) {
			for (int var2 = 0; var2 < var1.ids.length; ++var2) {
				var1.ids[var2] = -1;
				var1.quantities[var2] = 0;
			}

		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)I",
		garbageValue = "65"
	)
	@Export("hashString")
	public static int hashString(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + ItemDefinition.charToByteCp1252(var0.charAt(var3));
		}

		return var2;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(ILcx;ZI)I",
		garbageValue = "1661608853"
	)
	static int method147(int var0, Script var1, boolean var2) {
		Widget var3 = var2 ? Interpreter.field1111 : Calendar.field2507;
		if (var0 == ScriptOpcodes.CC_GETX) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETY) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETWIDTH) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETHIDE) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.CC_GETLAYER) {
			Interpreter.Interpreter_intStack[++HealthBarUpdate.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "20"
	)
	static void method145() {
		NetCache.method4312(class42.menuWidth / 2 + class247.menuX, class30.menuY);
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2136228205"
	)
	static final void method146(int var0) {
		if (class162.loadInterface(var0)) {
			Widget[] var1 = Widget.Widget_interfaceComponents[var0];

			for (int var2 = 0; var2 < var1.length; ++var2) {
				Widget var3 = var1[var2];
				if (var3 != null) {
					var3.modelFrame = 0;
					var3.modelFrameCycle = 0;
				}
			}

		}
	}

	@ObfuscatedName("jd")
	@ObfuscatedSignature(
		signature = "(Lhj;B)Z",
		garbageValue = "34"
	)
	static final boolean method149(Widget var0) {
		int var1 = var0.contentType;
		if (var1 == 205) {
			Client.field700 = 250;
			return true;
		} else {
			int var2;
			int var3;
			if (var1 >= 300 && var1 <= 313) {
				var2 = (var1 - 300) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method3992(var2, var3 == 1);
			}

			if (var1 >= 314 && var1 <= 323) {
				var2 = (var1 - 314) / 2;
				var3 = var1 & 1;
				Client.playerAppearance.method3993(var2, var3 == 1);
			}

			if (var1 == 324) {
				Client.playerAppearance.method4006(false);
			}

			if (var1 == 325) {
				Client.playerAppearance.method4006(true);
			}

			if (var1 == 326) {
				PacketBufferNode var4 = Archive.method4265(ClientPacket.field2215, Client.packetWriter.isaacCipher);
				Client.playerAppearance.method3995(var4.packetBuffer);
				Client.packetWriter.method2219(var4);
				return true;
			} else {
				return false;
			}
		}
	}
}
