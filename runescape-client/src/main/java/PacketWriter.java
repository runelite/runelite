import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = 2038642023
	)
	@Export("loginBoxCenter")
	static int loginBoxCenter;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Llt;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Ljm;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1977656589
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Llp;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkj;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = -1499666993
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("t")
	boolean field1335;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 1899399217
	)
	int field1338;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1748299909
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1334;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1329;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgv;"
	)
	ServerPacket field1339;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1335 = true;
		this.field1338 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1731012634"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-2069512411"
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

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(Lgq;I)V",
		garbageValue = "348040455"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(Llt;B)V",
		garbageValue = "-28"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "955020520"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-17"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)Llt;",
		garbageValue = "1352632931"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-816734320"
	)
	public static int method2376(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "1838015298"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("fr")
	@ObfuscatedSignature(
		signature = "(Ljc;IIIB)V",
		garbageValue = "29"
	)
	@Export("addSequenceSoundEffect")
	static void addSequenceSoundEffect(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && Client.areaSoundEffectVolume != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				int var4 = var0.soundEffects[var1];
				if (var4 != 0) {
					int var5 = var4 >> 8;
					int var6 = var4 >> 4 & 7;
					int var7 = var4 & 15;
					Client.soundEffectIds[Client.soundEffectCount] = var5;
					Client.queuedSoundEffectLoops[Client.soundEffectCount] = var6;
					Client.queuedSoundEffectDelays[Client.soundEffectCount] = 0;
					Client.soundEffects[Client.soundEffectCount] = null;
					int var8 = (var2 - 64) / 128;
					int var9 = (var3 - 64) / 128;
					Client.soundLocations[Client.soundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
					++Client.soundEffectCount;
				}
			}
		}
	}
}
