import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.IOException;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("cp")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("ry")
	@ObfuscatedSignature(
		signature = "Lbb;"
	)
	@Export("friendSystem")
	public static FriendSystem friendSystem;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lku;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 150566237
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lkc;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 969841253
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("i")
	boolean field1287;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 1257964487
	)
	int field1291;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 34585799
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1290;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1286;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1292;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1287 = true;
		this.field1291 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "47"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1645356656"
	)
	@Export("flush")
	final void flush() throws IOException {
		if (this.socket != null && this.bufferSize > 0) {
			this.buffer.offset = 0;

			while (true) {
				PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
					this.socket.write(this.buffer.array, 0, this.buffer.offset);
					this.pendingWrites = 0;
					break;
				}

				this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
				this.bufferSize -= var1.index;
				var1.remove();
				var1.packetBuffer.releaseArray();
				var1.release();
			}
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Lgk;B)V",
		garbageValue = "-19"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Lku;B)V",
		garbageValue = "4"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1408755030"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "906651954"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)Lku;",
		garbageValue = "-814852778"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "(Lhq;Lhq;I)V",
		garbageValue = "1551523322"
	)
	public static void method2419(AbstractArchive var0, AbstractArchive var1) {
		SpotAnimationDefinition.SpotAnimationDefinition_archive = var0;
		SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var1;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
		garbageValue = "762135204"
	)
	static void method2421(String var0, boolean var1, String var2, boolean var3) {
		if (var1) {
			if (!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
				try {
					Desktop.getDesktop().browse(new URI(var0));
					return;
				} catch (Exception var5) {
				}
			}

			if (class51.field416.startsWith("win") && !var3) {
				class226.method4275(var0, 0, "openjs");
				return;
			}

			if (class51.field416.startsWith("mac")) {
				class226.method4275(var0, 1, var2);
				return;
			}

			class226.method4275(var0, 2, "openjs");
		} else {
			class226.method4275(var0, 3, "openjs");
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(ILcj;ZI)I",
		garbageValue = "-1319808417"
	)
	static int method2426(int var0, Script var1, boolean var2) {
		Widget var3 = PacketBufferNode.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
