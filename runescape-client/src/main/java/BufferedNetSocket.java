import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ki")
@Implements("BufferedNetSocket")
public class BufferedNetSocket extends AbstractSocket {
	@ObfuscatedName("u")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lkt;"
	)
	@Export("source")
	BufferedSource source;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "Lkb;"
	)
	@Export("sink")
	BufferedSink sink;

	BufferedNetSocket(Socket var1, int var2, int var3) throws IOException {
		this.socket = var1;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.socket.setReceiveBufferSize(65536);
		this.socket.setSendBufferSize(65536);
		this.source = new BufferedSource(this.socket.getInputStream(), var2);
		this.sink = new BufferedSink(this.socket.getOutputStream(), var3);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-29"
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

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "27"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.source.readUnsignedByte();
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-53"
	)
	@Export("available")
	public int available() throws IOException {
		return this.source.available();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1591428004"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		return this.source.isAvailable(var1);
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "29"
	)
	@Export("read")
	public int read(byte[] var1, int var2, int var3) throws IOException {
		return this.source.read(var1, var2, var3);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-543253817"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.sink.write(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}
}
