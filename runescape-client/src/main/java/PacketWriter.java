import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("PacketWriter")
public class PacketWriter {
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lky;"
	)
	@Export("socket")
	AbstractSocket socket;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lju;"
	)
	@Export("packetBufferNodes")
	IterableNodeDeque packetBufferNodes;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -1004294931
	)
	@Export("bufferSize")
	int bufferSize;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lkf;"
	)
	@Export("buffer")
	Buffer buffer;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("isaacCipher")
	public IsaacCipher isaacCipher;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("packetBuffer")
	PacketBuffer packetBuffer;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	@Export("serverPacket")
	ServerPacket serverPacket;
	@ObfuscatedName("i")
	@ObfuscatedGetter(
		intValue = 1529475721
	)
	@Export("serverPacketLength")
	int serverPacketLength;
	@ObfuscatedName("c")
	boolean field1322;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1922577877
	)
	int field1318;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1793928125
	)
	int field1319;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	ServerPacket field1309;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	ServerPacket field1321;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lgc;"
	)
	ServerPacket field1317;

	PacketWriter() {
		this.packetBufferNodes = new IterableNodeDeque();
		this.bufferSize = 0;
		this.buffer = new Buffer(5000);
		this.packetBuffer = new PacketBuffer(40000);
		this.serverPacket = null;
		this.serverPacketLength = 0;
		this.field1322 = true;
		this.field1318 = 0;
		this.field1319 = 0;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "19166064"
	)
	final void method2218() {
		this.packetBufferNodes.clear();
		this.bufferSize = 0;
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "294803591"
	)
	final void method2234() throws IOException {
		if (this.socket != null && this.bufferSize > 0) {
			this.buffer.offset = 0;

			while (true) {
				PacketBufferNode var1 = (PacketBufferNode)this.packetBufferNodes.last();
				if (var1 == null || var1.index > this.buffer.array.length - this.buffer.offset) {
					this.socket.write(this.buffer.array, 0, this.buffer.offset);
					this.field1319 = 0;
					break;
				}

				this.buffer.writeBytes(var1.packetBuffer.array, 0, var1.index);
				this.bufferSize -= var1.index;
				var1.remove();
				var1.packetBuffer.method5477();
				var1.method3620();
			}
		}

	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(Lgb;I)V",
		garbageValue = "2067459847"
	)
	public final void method2219(PacketBufferNode var1) {
		this.packetBufferNodes.addFirst(var1);
		var1.index = var1.packetBuffer.offset;
		var1.packetBuffer.offset = 0;
		this.bufferSize += var1.index;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(Lky;I)V",
		garbageValue = "242555588"
	)
	@Export("setSocket")
	void setSocket(AbstractSocket var1) {
		this.socket = var1;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "-14154"
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
		signature = "(B)V",
		garbageValue = "94"
	)
	@Export("removeSocket")
	void removeSocket() {
		this.socket = null;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(S)Lky;",
		garbageValue = "-14430"
	)
	@Export("getSocket")
	AbstractSocket getSocket() {
		return this.socket;
	}

	@ObfuscatedName("gs")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-107"
	)
	static final void method2245() {
		for (Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
			if (var0.plane == class42.plane && Client.cycle <= var0.cycleEnd) {
				if (Client.cycle >= var0.cycleStart) {
					if (var0.targetIndex > 0) {
						NPC var1 = Client.npcs[var0.targetIndex - 1];
						if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
							var0.setDestination(var1.x, var1.y, ScriptEvent.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					if (var0.targetIndex < 0) {
						int var2 = -var0.targetIndex - 1;
						Player var3;
						if (var2 == Client.localPlayerIndex) {
							var3 = Client.localPlayer;
						} else {
							var3 = Client.players[var2];
						}

						if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
							var0.setDestination(var3.x, var3.y, ScriptEvent.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
						}
					}

					var0.advance(Client.field718);
					GrandExchangeOfferWorldComparator.scene.drawEntity(class42.plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
				}
			} else {
				var0.remove();
			}
		}

	}

	@ObfuscatedName("it")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1368328511"
	)
	static boolean method2244(int var0) {
		for (int var1 = 0; var1 < Client.field754; ++var1) {
			if (Client.field921[var1] == var0) {
				return true;
			}
		}

		return false;
	}
}
