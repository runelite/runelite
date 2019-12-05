import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "[Lba;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = -2111791625
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lba;",
		garbageValue = "1583297440"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(IB)Lba;",
		garbageValue = "-6"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "0"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("ll")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1059026202"
	)
	static void method2274() {
		if (InvDefinition.field3210 != null) {
			Client.field863 = Client.cycle;
			InvDefinition.field3210.method4403();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					InvDefinition.field3210.method4406(class51.baseX * 64 + (Client.players[var0].x >> 7), VarcInt.baseY * 64 + (Client.players[var0].y >> 7));
				}
			}
		}

	}
}
