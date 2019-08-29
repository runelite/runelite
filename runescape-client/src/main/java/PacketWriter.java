import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("fe")
	@ObfuscatedGetter(
		intValue = 1606787637
	)
	@Export("baseX")
	static int baseX;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lkg;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Ljp;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1205819381
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lle;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1032703307
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("x")
	boolean field1284;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = -1284201635
	)
	int field1293;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 421998979
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	ServerPacket field1295;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	ServerPacket field1296;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lgj;"
	)
	ServerPacket field1291;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1284 = true;
		this.field1293 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-194505357"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "10298"
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

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(Lgq;I)V",
		garbageValue = "520216141"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lkg;I)V",
		garbageValue = "-2033102393"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-104"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-200145232"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(S)Lkg;",
		garbageValue = "140"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}
}
