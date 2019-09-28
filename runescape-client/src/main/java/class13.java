import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class13 {
	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		signature = "[Llf;"
	)
	@Export("mapDotSprites")
	static Sprite[] mapDotSprites;

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(CLgt;I)C",
		garbageValue = "-1706308889"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else if (var0 == 376) {
			return 'Y';
		} else {
			return var0;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-114703177"
	)
	@Export("Messages_getNextChatID")
	static int Messages_getNextChatID(int var0) {
		Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
		if (var1 == null) {
			return -1;
		} else {
			return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(Lho;II)V",
		garbageValue = "891811325"
	)
	@Export("Widget_setKeyIgnoreHeld")
	static final void Widget_setKeyIgnoreHeld(Widget var0, int var1) {
		if (var0.field2552 == null) {
			throw new RuntimeException();
		} else {
			if (var0.field2684 == null) {
				var0.field2684 = new int[var0.field2552.length];
			}

			var0.field2684[var1] = Integer.MAX_VALUE;
		}
	}
}
