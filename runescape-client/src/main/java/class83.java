import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class83 {
	@ObfuscatedName("f")
	static final BigInteger field1144;
	@ObfuscatedName("i")
	static final BigInteger field1142;

	static {
		field1144 = new BigInteger("10001", 16);
		field1142 = new BigInteger("a829ab7e2d47507cfcd882652a97602a8c7e3cd5afbd5cfcc669d81bd92ae7972a5c5d9755da447ca19827e60e79d3f609c67492a4082b20cfd50a33b5fe88a33e336e600c1ff6c84652ccfbf0d5e72de43e0bf9feed0a9829c4c475ae559b5ba4cec4bb0ecf84b403d82521b2678c77dc90101b737cb47ce3caa6d55073078d", 16);
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "-1594783398"
	)
	@Export("addGameMessage")
	static void addGameMessage(int var0, String var1, String var2) {
		GameShell.addChatMessage(var0, var1, var2, (String)null);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Llc;IIS)I",
		garbageValue = "-31800"
	)
	static int method2071(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("he")
	@ObfuscatedSignature(
		signature = "(B)Z",
		garbageValue = "114"
	)
	static boolean method2072() {
		return (Client.drawPlayerNames & 4) != 0;
	}
}
