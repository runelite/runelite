import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
	@ObfuscatedName("c")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("x")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("t")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("g")
	@Export("isClosed")
	boolean isClosed;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lfq;"
	)
	@Export("taskHandler")
	TaskHandler taskHandler;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfc;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("j")
	@Export("outBuffer")
	byte[] outBuffer;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = 507236183
	)
	@Export("outLength")
	int outLength;
	@ObfuscatedName("d")
	@ObfuscatedGetter(
		intValue = 33510263
	)
	@Export("outOffset")
	int outOffset;
	@ObfuscatedName("z")
	@Export("exceptionWriting")
	boolean exceptionWriting;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = -687559731
	)
	@Export("bufferLength")
	final int bufferLength;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1564055385
	)
	@Export("maxPacketLength")
	final int maxPacketLength;

	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;Lfq;I)V"
	)
	public NetSocket(Socket var1, TaskHandler var2, int var3) throws IOException {
		this.isClosed = false;
		this.outLength = 0;
		this.outOffset = 0;
		this.exceptionWriting = false;
		this.taskHandler = var2;
		this.socket = var1;
		this.bufferLength = var3;
		this.maxPacketLength = var3 - 100;
		this.socket.setSoTimeout(30000);
		this.socket.setTcpNoDelay(true);
		this.socket.setReceiveBufferSize(65536);
		this.socket.setSendBufferSize(65536);
		this.inputStream = this.socket.getInputStream();
		this.outputStream = this.socket.getOutputStream();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-75"
	)
	@Export("close")
	public void close() {
		if (!this.isClosed) {
			synchronized(this) {
				this.isClosed = true;
				this.notifyAll();
			}

			if (this.task != null) {
				while (this.task.status == 0) {
					FriendsList.sleepMillis(1L);
				}

				if (this.task.status == 1) {
					try {
						((Thread)this.task.result).join();
					} catch (InterruptedException var3) {
					}
				}
			}

			this.task = null;
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1827163357"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.isClosed ? 0 : this.inputStream.read();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1354053248"
	)
	@Export("available")
	public int available() throws IOException {
		return this.isClosed ? 0 : this.inputStream.available();
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-377412375"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		if (this.isClosed) {
			return false;
		} else {
			return this.inputStream.available() >= var1;
		}
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "2063129771"
	)
	@Export("read")
	public int read(byte[] var1, int var2, int var3) throws IOException {
		if (this.isClosed) {
			return 0;
		} else {
			int var4;
			int var5;
			for (var4 = var3; var3 > 0; var3 -= var5) {
				var5 = this.inputStream.read(var1, var2, var3);
				if (var5 <= 0) {
					throw new EOFException();
				}

				var2 += var5;
			}

			return var4;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "-25"
	)
	@Export("write0")
	void write0(byte[] var1, int var2, int var3) throws IOException {
		if (!this.isClosed) {
			if (this.exceptionWriting) {
				this.exceptionWriting = false;
				throw new IOException();
			} else {
				if (this.outBuffer == null) {
					this.outBuffer = new byte[this.bufferLength];
				}

				synchronized(this) {
					for (int var5 = 0; var5 < var3; ++var5) {
						this.outBuffer[this.outOffset] = var1[var5 + var2];
						this.outOffset = (this.outOffset + 1) % this.bufferLength;
						if ((this.maxPacketLength + this.outLength) % this.bufferLength == this.outOffset) {
							throw new IOException();
						}
					}

					if (this.task == null) {
						this.task = this.taskHandler.newThreadTask(this, 3);
					}

					this.notifyAll();
				}
			}
		}
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "9"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.write0(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}

	protected void aaj() {
		this.close();
	}

	public void run() {
		try {
			while (true) {
				label84: {
					int var1;
					int var2;
					synchronized(this) {
						if (this.outOffset == this.outLength) {
							if (this.isClosed) {
								break label84;
							}

							try {
								this.wait();
							} catch (InterruptedException var10) {
							}
						}

						var2 = this.outLength;
						if (this.outOffset >= this.outLength) {
							var1 = this.outOffset - this.outLength;
						} else {
							var1 = this.bufferLength - this.outLength;
						}
					}

					if (var1 <= 0) {
						continue;
					}

					try {
						this.outputStream.write(this.outBuffer, var2, var1);
					} catch (IOException var9) {
						this.exceptionWriting = true;
					}

					this.outLength = (var1 + this.outLength) % this.bufferLength;

					try {
						if (this.outOffset == this.outLength) {
							this.outputStream.flush();
						}
					} catch (IOException var8) {
						this.exceptionWriting = true;
					}
					continue;
				}

				try {
					if (this.inputStream != null) {
						this.inputStream.close();
					}

					if (this.outputStream != null) {
						this.outputStream.close();
					}

					if (this.socket != null) {
						this.socket.close();
					}
				} catch (IOException var7) {
				}

				this.outBuffer = null;
				break;
			}
		} catch (Exception var12) {
			class188.RunException_sendStackTrace((String)null, var12);
		}

	}

	@ObfuscatedName("gh")
	@ObfuscatedSignature(
		signature = "(Lby;I)Z",
		garbageValue = "1278760398"
	)
	static boolean method3531(Player var0) {
		if (Client.drawPlayerNames == 0) {
			return false;
		} else if (Varps.localPlayer != var0) {
			boolean var1 = (Client.drawPlayerNames & 4) != 0;
			return var1 || class160.method3419() && var0.isFriend() || Projectile.method2087() && var0.isClanMember();
		} else {
			return UrlRequester.method3273();
		}
	}
}
