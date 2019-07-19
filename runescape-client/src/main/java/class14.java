import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("v")
public class class14 {
	@ObfuscatedName("i")
	@Export("soundSystemExecutor")
	static ScheduledExecutorService soundSystemExecutor;

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
		garbageValue = "2056666863"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lhj;IIII)V",
		garbageValue = "-2006801653"
	)
	static final void method153(Widget var0, int var1, int var2, int var3) {
		if (var0.field2641 == null) {
			throw new RuntimeException();
		} else {
			var0.field2641[var1] = var2;
			var0.field2588[var1] = var3;
		}
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;II)V",
		garbageValue = "1053602258"
	)
	static final void method159(String var0, int var1) {
		PacketBufferNode var2 = Archive.method4265(ClientPacket.field2280, Client.packetWriter.isaacCipher);
		var2.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var0) + 1);
		var2.packetBuffer.writeStringCp1252NullTerminated(var0);
		var2.packetBuffer.writeByte(var1);
		Client.packetWriter.method2219(var2);
	}

	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)V",
		garbageValue = "-27"
	)
	static void method155(String var0) {
		class294.field3695 = var0;

		try {
			String var1 = WorldMapSprite.client.getParameter(ClientParameter.field3587.id);
			String var2 = WorldMapSprite.client.getParameter(ClientParameter.field3594.id);
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			String var5;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = DirectByteArrayCopier.currentTimeMs() + 94608000000L;
				Calendar.field2504.setTime(new Date(var6));
				int var8 = Calendar.field2504.get(7);
				int var9 = Calendar.field2504.get(5);
				int var10 = Calendar.field2504.get(2);
				int var11 = Calendar.field2504.get(1);
				int var12 = Calendar.field2504.get(11);
				int var13 = Calendar.field2504.get(12);
				int var14 = Calendar.field2504.get(13);
				var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
				var3 = var4 + var5 + "; Max-Age=" + 94608000L;
			}

			Client var16 = WorldMapSprite.client;
			var5 = "document.cookie=\"" + var3 + "\"";
			JSObject.getWindow(var16).eval(var5);
		} catch (Throwable var15) {
		}

	}
}
