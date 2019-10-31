import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Players")
public class Players {
	@ObfuscatedName("n")
	static byte[] field1227;
	@ObfuscatedName("q")
	static byte[] field1228;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "[Lkc;"
	)
	static Buffer[] field1229;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -1057935815
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("c")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 1503324563
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("i")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("d")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("m")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("p")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = -1083709183
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("k")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	static Buffer field1238;

	static {
		field1227 = new byte[2048];
		field1228 = new byte[2048];
		field1229 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1238 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "1609837921"
	)
	static final void method2308(String var0) {
		StringBuilder var10000 = new StringBuilder();
		Object var10001 = null;
		var10000 = var10000.append("Please remove ").append(var0);
		var10001 = null;
		String var1 = var10000.append(" from your ignore list first").toString();
		class30.addGameMessage(30, "", var1);
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "108"
	)
	static void method2298() {
		Login.loginIndex = 24;
		GrandExchangeOffer.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
	}
}
