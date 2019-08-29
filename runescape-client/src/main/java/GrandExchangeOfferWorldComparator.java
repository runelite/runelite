import java.util.Comparator;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("n")
@Implements("GrandExchangeOfferWorldComparator")
final class GrandExchangeOfferWorldComparator implements Comparator {
	@ObfuscatedName("rr")
	@ObfuscatedGetter(
		intValue = 133251749
	)
	static int field34;
	@ObfuscatedName("q")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lid;"
	)
	@Export("archive15")
	static Archive archive15;

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Lq;Lq;I)I",
		garbageValue = "1902979302"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.world < var2.world ? -1 : (var2.world == var1.world ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
		garbageValue = "1594628992"
	)
	public static String method74(CharSequence[] var0, int var1, int var2) {
		if (var2 == 0) {
			return "";
		} else if (var2 == 1) {
			CharSequence var3 = var0[var1];
			return var3 == null ? "null" : var3.toString();
		} else {
			int var8 = var2 + var1;
			int var4 = 0;

			for (int var5 = var1; var5 < var8; ++var5) {
				CharSequence var6 = var0[var5];
				if (var6 == null) {
					var4 += 4;
				} else {
					var4 += var6.length();
				}
			}

			StringBuilder var9 = new StringBuilder(var4);

			for (int var10 = var1; var10 < var8; ++var10) {
				CharSequence var7 = var0[var10];
				if (var7 == null) {
					var9.append("null");
				} else {
					var9.append(var7);
				}
			}

			return var9.toString();
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcr;ZI)I",
		garbageValue = "-1665010136"
	)
	static int method79(int var0, Script var1, boolean var2) {
		Widget var3;
		if (var0 >= 2000) {
			var0 -= 1000;
			var3 = WorldMapElement.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		} else {
			var3 = var2 ? class286.field3623 : class297.field3693;
		}

		if (var0 == ScriptOpcodes.CC_CALLONRESIZE) {
			if (Interpreter.field1064 >= 10) {
				throw new RuntimeException();
			} else if (var3.onResize == null) {
				return 0;
			} else {
				ScriptEvent var4 = new ScriptEvent();
				var4.widget = var3;
				var4.args = var3.onResize;
				var4.field555 = Interpreter.field1064 + 1;
				Client.scriptEvents.addFirst(var4);
				return 1;
			}
		} else {
			return 2;
		}
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)I",
		garbageValue = "516723982"
	)
	public static int method80(String var0) {
		return var0.length() + 2;
	}
}
