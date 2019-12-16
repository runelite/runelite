import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Ljl;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = -1004782805
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lkq;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Llr;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lkl;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -374140173
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("a")
	boolean field1297;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -597988403
	)
	int field1298;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -1139758715
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	ServerPacket field1300;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	ServerPacket field1301;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	ServerPacket field1299;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1297 = true;
		this.field1298 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-39"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1865358367"
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

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(Lfz;I)V",
		garbageValue = "-2113796206"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "-180486775"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1795782145"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2001412741"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)Lky;",
		garbageValue = "-160473860"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}
}
