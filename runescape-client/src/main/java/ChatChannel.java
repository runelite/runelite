import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		signature = "Lhi;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "[Lbt;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -1655773149
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbt;",
		garbageValue = "-2124852367"
	)
	@Export("addMessage")
	Message addMessage(int var1, String var2, String var3, String var4) {
		Message var5 = this.messages[99];

		for (int var6 = this.count; var6 > 0; --var6) {
			if (var6 != 100) {
				this.messages[var6] = this.messages[var6 - 1];
			}
		}

		if (var5 == null) {
			var5 = new Message(var1, var2, var4, var3);
		} else {
			var5.remove();
			var5.removeDual();
			var5.set(var1, var2, var4, var3);
		}

		this.messages[0] = var5;
		if (this.count < 100) {
			++this.count;
		}

		return var5;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(II)Lbt;",
		garbageValue = "1546938937"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "126"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(CI)Z",
		garbageValue = "1710830217"
	)
	@Export("isCharAlphabetic")
	public static boolean isCharAlphabetic(char var0) {
		return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
	}

	@ObfuscatedName("fz")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1507769653"
	)
	@Export("playPcmPlayers")
	static final void playPcmPlayers() {
		if (MenuAction.pcmPlayer1 != null) {
			MenuAction.pcmPlayer1.run();
		}

		if (class80.pcmPlayer0 != null) {
			class80.pcmPlayer0.run();
		}

	}
}
