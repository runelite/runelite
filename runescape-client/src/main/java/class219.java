import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class219 {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)V",
		garbageValue = "-444030041"
	)
	static final void method4111(String var0) {
		PacketBufferNode var1 = Archive.method4265(ClientPacket.field2210, Client.packetWriter.isaacCipher);
		var1.packetBuffer.writeByte(Huffman.stringCp1252NullTerminatedByteSize(var0));
		var1.packetBuffer.writeStringCp1252NullTerminated(var0);
		Client.packetWriter.method2219(var1);
	}

	@ObfuscatedName("gd")
	@ObfuscatedSignature(
		signature = "(Lbq;II)V",
		garbageValue = "1386416846"
	)
	@Export("getActorScreenLocation")
	static final void getActorScreenLocation(Actor var0, int var1) {
		class32.worldToScreen(var0.x, var0.y, var1);
	}

	@ObfuscatedName("im")
	@ObfuscatedSignature(
		signature = "(Lhj;IIZI)V",
		garbageValue = "-2103568814"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2636 * var0.height / var0.field2582;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.field2582 * var0.width / var0.field2636;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}
