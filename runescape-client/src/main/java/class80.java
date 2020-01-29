import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class80 {
	@ObfuscatedName("i")
	static final BigInteger field1123;
	@ObfuscatedName("g")
	static final BigInteger field1120;

	static {
		field1123 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
		field1120 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lks;I)I",
		garbageValue = "-1637825226"
	)
	static int method2094(PacketBuffer var0) {
		int var1 = var0.readBits(2);
		int var2;
		if (var1 == 0) {
			var2 = 0;
		} else if (var1 == 1) {
			var2 = var0.readBits(5);
		} else if (var1 == 2) {
			var2 = var0.readBits(8);
		} else {
			var2 = var0.readBits(11);
		}

		return var2;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1745616388"
	)
	static final void method2097() {
		class60.method1188("You can't add yourself to your own ignore list");
	}

	@ObfuscatedName("ka")
	@ObfuscatedSignature(
		signature = "(Lhn;II)Ljava/lang/String;",
		garbageValue = "237205846"
	)
	static String method2098(Widget var0, int var1) {
		int var3 = WorldMapIcon_0.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
