import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("sh")
	@ObfuscatedSignature(
		signature = "Lj;"
	)
	@Export("grandExchangeEvents")
	static GrandExchangeEvents grandExchangeEvents;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lks;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Ljd;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("t")
	@ObfuscatedGetter(
		intValue = -1063535483
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lld;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1384639011
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("d")
	boolean field1281;
	@ObfuscatedName("z")
	@ObfuscatedGetter(
		intValue = 1450743325
	)
	int field1283;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 135236915
	)
	@Export("pendingWrites")
	int pendingWrites;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1274;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1286;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lga;"
	)
	ServerPacket field1287;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1281 = true;
		this.field1283 = 0;
		this.pendingWrites = 0;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1888658982"
	)
	@Export("clearBuffer")
	final void clearBuffer() {
		this.packetBufferNodes.rsClear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "0"
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(Lgj;S)V",
		garbageValue = "5307"
	)
	@Export("addNode")
	public final void addNode(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(Lks;B)V",
		garbageValue = "1"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "111"
	)
	@Export("close")
	void close() {
		if (this.socket != null) {
			this.socket.close();
			this.socket = null;
		}

	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1660773387"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)Lks;",
		garbageValue = "-1816909725"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		signature = "(Lfq;IIB)Ldh;",
		garbageValue = "25"
	)
	public static final PcmPlayer method2246(TaskHandler var0, int var1, int var2) {
		if (GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate == 0) {
			throw new IllegalStateException();
		} else if (var1 >= 0 && var1 < 2) {
			if (var2 < 256) {
				var2 = 256;
			}

			try {
				PcmPlayer var3 = HealthBar.pcmPlayerProvider.player();
				var3.samples = new int[256 * (PcmPlayer.PcmPlayer_stereo ? 2 : 1)];
				var3.field1377 = var2;
				var3.init();
				var3.capacity = (var2 & -1024) + 1024;
				if (var3.capacity > 16384) {
					var3.capacity = 16384;
				}

				var3.open(var3.capacity);
				if (GrandExchangeEvents.PcmPlayer_count > 0 && FontName.soundSystem == null) {
					FontName.soundSystem = new SoundSystem();
					SoundCache.soundSystemExecutor = Executors.newScheduledThreadPool(1);
					SoundCache.soundSystemExecutor.scheduleAtFixedRate(FontName.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
				}

				if (FontName.soundSystem != null) {
					if (FontName.soundSystem.players[var1] != null) {
						throw new IllegalArgumentException();
					}

					FontName.soundSystem.players[var1] = var3;
				}

				return var3;
			} catch (Throwable var4) {
				return new PcmPlayer();
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	@ObfuscatedName("ft")
	@ObfuscatedSignature(
		signature = "(ZB)V",
		garbageValue = "62"
	)
	static final void method2238(boolean var0) {
		if (var0) {
			Client.field659 = Login.field1183 ? class160.field1972 : class160.field1974;
		} else {
			LinkedHashMap var1 = Actor.clientPreferences.parameters;
			String var3 = Login.Login_username;
			int var4 = var3.length();
			int var5 = 0;

			for (int var6 = 0; var6 < var4; ++var6) {
				var5 = (var5 << 5) - var5 + var3.charAt(var6);
			}

			Client.field659 = var1.containsKey(var5) ? class160.field1975 : class160.field1973;
		}

	}
}
