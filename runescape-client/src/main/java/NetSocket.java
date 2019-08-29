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
	@ObfuscatedName("s")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("j")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("i")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("k")
	@Export("isClosed")
	boolean isClosed;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lfu;"
	)
	@Export("taskHandler")
	TaskHandler taskHandler;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lft;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("t")
	@Export("outBuffer")
	byte[] outBuffer;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -2034750073
	)
	@Export("outLength")
	int outLength;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 944271121
	)
	@Export("outOffset")
	int outOffset;
	@ObfuscatedName("d")
	@Export("exceptionWriting")
	boolean exceptionWriting;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1855971629
	)
	@Export("bufferLength")
	final int bufferLength;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 234092539
	)
	@Export("maxPacketLength")
	final int maxPacketLength;

	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;Lfu;I)V"
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

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1798752769"
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
					UserList.sleepMillis(1L);
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

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "547465689"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.isClosed ? 0 : this.inputStream.read();
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "83"
	)
	@Export("available")
	public int available() throws IOException {
		return this.isClosed ? 0 : this.inputStream.available();
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "156087109"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		if (this.isClosed) {
			return false;
		} else {
			return this.inputStream.available() >= var1;
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "([BIIB)I",
		garbageValue = "100"
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-1945962644"
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
						if ((this.outLength + this.maxPacketLength) % this.bufferLength == this.outOffset) {
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "638463675"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.write0(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}

	protected void abt() {
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
						if (this.outLength == this.outOffset) {
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
			class3.RunException_sendStackTrace((String)null, var12);
		}

	}

	protected void abi() {
		this.close();
	}

	@ObfuscatedName("ii")
	@ObfuscatedSignature(
		signature = "(Lhp;IIZB)V",
		garbageValue = "-62"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.field2538 * var0.height / var0.field2612;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.width * var0.field2612 / var0.field2538;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}

	@ObfuscatedName("ln")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "549032388"
	)
	static String method3489(String var0) {
		PlayerType[] var1 = class191.PlayerType_values();

		for (int var2 = 0; var2 < var1.length; ++var2) {
			PlayerType var3 = var1[var2];
			if (var3.modIcon * 714577229 != -1 && var0.startsWith(AbstractWorldMapData.method278(var3.modIcon * 714577229))) {
				var0 = var0.substring(6 + Integer.toString(var3.modIcon * 714577229).length());
				break;
			}
		}

		return var0;
	}
}
