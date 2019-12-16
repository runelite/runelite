import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Script")
public class Script extends DualNode {
	@ObfuscatedName("st")
	@ObfuscatedSignature(
		signature = "Le;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Leb;"
	)
	@Export("Script_cached")
	static EvictingDualNodeHashTable Script_cached;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1585175051
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("i")
	@Export("opcodes")
	int[] opcodes;
	@ObfuscatedName("y")
	@Export("intOperands")
	int[] intOperands;
	@ObfuscatedName("w")
	@Export("stringOperands")
	String[] stringOperands;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 465356471
	)
	@Export("localIntCount")
	int localIntCount;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -1243420491
	)
	@Export("localStringCount")
	int localStringCount;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -308424659
	)
	@Export("intArgumentCount")
	int intArgumentCount;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -2632789
	)
	@Export("stringArgumentCount")
	int stringArgumentCount;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "[Llc;"
	)
	@Export("switches")
	IterableNodeHashTable[] switches;

	static {
		Script_cached = new EvictingDualNodeHashTable(128);
	}

	Script() {
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(IB)[Llc;",
		garbageValue = "-1"
	)
	@Export("newIterableNodeHashTable")
	IterableNodeHashTable[] newIterableNodeHashTable(int var1) {
		return new IterableNodeHashTable[var1];
	}

	@ObfuscatedName("fj")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1158039075"
	)
	static final void method2244() {
		if (Projectile.ClanChat_inClanChat) {
			if (Calendar.clanChat != null) {
				Calendar.clanChat.sort();
			}

			for (int var0 = 0; var0 < Players.Players_count; ++var0) {
				Player var1 = Client.players[Players.Players_indices[var0]];
				var1.clearIsInClanChat();
			}

			Projectile.ClanChat_inClanChat = false;
		}

	}
}
