import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("or")
	@ObfuscatedSignature(
		signature = "Lfi;"
	)
	@Export("mouseWheel")
	static MouseWheel mouseWheel;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lkr;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Ljj;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -1477926037
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lkp;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Llw;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lks;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -184650797
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("j")
	boolean field1301;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1725214527
	)
	int field1299;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1544276091
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	ServerPacket field1309;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	ServerPacket field1305;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgb;"
	)
	ServerPacket field1307;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1301 = true;
		this.field1299 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-10"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1781270612"
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

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Lgs;I)V",
		garbageValue = "1684104708"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lkr;I)V",
		garbageValue = "1771129210"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "711577469"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-91"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(B)Lkr;",
		garbageValue = "106"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(IS)Liy;",
		garbageValue = "-7105"
	)
	public static HealthBarDefinition method2329(int var0) {
		HealthBarDefinition var1 = (HealthBarDefinition)HealthBarDefinition.HealthBarDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HealthBarDefinition.HealthBarDefinition_archive.takeFile(33, var0);
			var1 = new HealthBarDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HealthBarDefinition.HealthBarDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)Ljava/lang/String;",
		garbageValue = "16"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}
}
