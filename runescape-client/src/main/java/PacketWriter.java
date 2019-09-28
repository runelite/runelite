import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("gt")
	@ObfuscatedSignature(
		signature = "Lex;"
	)
	@Export("scene")
	static Scene scene;
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Ljs;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1980831337
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Llg;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1968732153
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("y")
	boolean field1290;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = -1246763735
	)
	int field1297;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 1159394087
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1300;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1291;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1301;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1290 = true;
		this.field1297 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1613977862"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1302279031"
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

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(Lgn;I)V",
		garbageValue = "-1138020286"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "750746684"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1336003274"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-54"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Lky;",
		garbageValue = "1051298543"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}
}
