import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("ChatChannel")
public class ChatChannel {
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lcz;"
	)
	@Export("pcmPlayerProvider")
	static class97 pcmPlayerProvider;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "[Lbs;"
	)
	@Export("messages")
	Message[] messages;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 510013085
	)
	@Export("count")
	int count;

	ChatChannel() {
		this.messages = new Message[100];
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbs;",
		garbageValue = "481031645"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(II)Lbs;",
		garbageValue = "-2132499563"
	)
	@Export("getMessage")
	Message getMessage(int var1) {
		return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "134905957"
	)
	@Export("size")
	int size() {
		return this.count;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(II)Ljava/lang/String;",
		garbageValue = "1959752215"
	)
	static String method2269(int var0) {
		return "<img=" + var0 + ">";
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(III)V",
		garbageValue = "-2136093779"
	)
	public static void method2259(int var0, int var1) {
		VarbitDefinition var2 = UserComparator9.method3319(var0);
		int var3 = var2.baseVar;
		int var4 = var2.startBit;
		int var5 = var2.endBit;
		int var6 = Varps.Varps_masks[var5 - var4];
		if (var1 < 0 || var1 > var6) {
			var1 = 0;
		}

		var6 <<= var4;
		Varps.Varps_main[var3] = Varps.Varps_main[var3] & ~var6 | var1 << var4 & var6;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(B)Lbe;",
		garbageValue = "90"
	)
	@Export("worldListStart")
	static World worldListStart() {
		World.World_listCount = 0;
		return Friend.getNextWorldListWorld();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BI)Lko;",
		garbageValue = "65535"
	)
	static Font method2270(byte[] var0) {
		if (var0 == null) {
			return null;
		} else {
			Font var1 = new Font(var0, class325.SpriteBuffer_xOffsets, class325.SpriteBuffer_yOffsets, UserComparator1.SpriteBuffer_spriteWidths, class325.SpriteBuffer_spriteHeights, class268.SpriteBuffer_spritePalette, class290.SpriteBuffer_pixels);
			Message.method1223();
			return var1;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		signature = "(Ldl;B)V",
		garbageValue = "21"
	)
	@Export("PcmStream_disable")
	static final void PcmStream_disable(PcmStream var0) {
		var0.active = false;
		if (var0.sound != null) {
			var0.sound.position = 0;
		}

		for (PcmStream var1 = var0.firstSubStream(); var1 != null; var1 = var0.nextSubStream()) {
			PcmStream_disable(var1);
		}

	}
}
