import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
@Implements("BufferedNetSocket")
public class BufferedNetSocket extends AbstractSocket {
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 966969419
	)
	@Export("cacheGamebuild")
	public static int cacheGamebuild;
	@ObfuscatedName("z")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lkx;"
	)
	@Export("source")
	BufferedSource source;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lkv;"
	)
	@Export("sink")
	BufferedSink sink;

	public BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
		this.socket = var1;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.socket.setReceiveBufferSize(65536);
		this.socket.setSendBufferSize(65536);
		this.source = new BufferedSource(this.socket.getInputStream(), var2);
		this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-119"
	)
	@Export("close")
	public void close() {
		this.sink.close();

		try {
			this.socket.close();
		} catch (IOException var2) {
		}

		this.source.close();
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1784126558"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.source.readUnsignedByte();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "3"
	)
	@Export("available")
	public int available() throws IOException {
		return this.source.available();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-336706705"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		return this.source.isAvailable(var1);
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-2035668362"
	)
	@Export("read")
	public int read(byte[] var1, int var2, int var3) throws IOException {
		return this.source.read(var1, var2, var3);
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "-68"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.sink.write(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "2009022285"
	)
	@Export("loadWorlds")
	static boolean loadWorlds() {
		try {
			if (class51.World_request == null) {
				class51.World_request = Client.urlRequester.request(new URL(WorldMapSectionType.field150));
			} else if (class51.World_request.isDone()) {
				byte[] var0 = class51.World_request.getResponse();
				Buffer var1 = new Buffer(var0);
				var1.readInt();
				World.World_count = var1.readUnsignedShort();
				World.World_worlds = new World[World.World_count];

				World var3;
				for (int var2 = 0; var2 < World.World_count; var3.index = var2++) {
					var3 = World.World_worlds[var2] = new World();
					var3.id = var1.readUnsignedShort();
					var3.properties = var1.readInt();
					var3.host = var1.readStringCp1252NullTerminated();
					var3.activity = var1.readStringCp1252NullTerminated();
					var3.location = var1.readUnsignedByte();
					var3.population = var1.readShort();
				}

				WorldMapData_0.sortWorlds(World.World_worlds, 0, World.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
				class51.World_request = null;
				return true;
			}
		} catch (Exception var4) {
			var4.printStackTrace();
			class51.World_request = null;
		}

		return false;
	}
}
