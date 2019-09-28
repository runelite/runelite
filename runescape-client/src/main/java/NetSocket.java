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

@ObfuscatedName("fu")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
	@ObfuscatedName("ly")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	@Export("mousedOverWidgetIf1")
	static Widget mousedOverWidgetIf1;
	@ObfuscatedName("z")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("n")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("v")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("u")
	@Export("isClosed")
	boolean isClosed;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lfm;"
	)
	@Export("taskHandler")
	TaskHandler taskHandler;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lfv;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("q")
	@Export("outBuffer")
	byte[] outBuffer;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -428981347
	)
	@Export("outLength")
	int outLength;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 386347925
	)
	@Export("outOffset")
	int outOffset;
	@ObfuscatedName("i")
	@Export("exceptionWriting")
	boolean exceptionWriting;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = -539294119
	)
	@Export("bufferLength")
	final int bufferLength;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 312930257
	)
	@Export("maxPacketLength")
	final int maxPacketLength;

	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;Lfm;I)V"
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

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "-119"
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
					try {
						Thread.sleep(1L);
					} catch (InterruptedException var4) {
					}
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

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "1784126558"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.isClosed ? 0 : this.inputStream.read();
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "3"
	)
	@Export("available")
	public int available() throws IOException {
		return this.isClosed ? 0 : this.inputStream.available();
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-336706705"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		if (this.isClosed) {
			return false;
		} else {
			return this.inputStream.available() >= var1;
		}
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "-2035668362"
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

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-2110504051"
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

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "([BIIB)V",
		garbageValue = "-68"
	)
	@Export("write")
	public void write(byte[] var1, int var2, int var3) throws IOException {
		this.write0(var1, var2, var3);
	}

	protected void finalize() {
		this.close();
	}

	public void run() {
		try {
			while (true) {
				label84: {
					int var1;
					int var2;
					synchronized(this) {
						if (this.outLength == this.outOffset) {
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
			class32.RunException_sendStackTrace((String)null, var12);
		}

	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "([Lga;II)Lga;",
		garbageValue = "-846037107"
	)
	@Export("findEnumerated")
	public static Enumerated findEnumerated(Enumerated[] var0, int var1) {
		Enumerated[] var2 = var0;

		for (int var3 = 0; var3 < var2.length; ++var3) {
			Enumerated var4 = var2[var3];
			if (var1 == var4.rsOrdinal()) {
				return var4;
			}
		}

		return null;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/CharSequence;B)Z",
		garbageValue = "-100"
	)
	@Export("isNumber")
	public static boolean isNumber(CharSequence var0) {
		return MouseRecorder.method1209(var0, 10, true);
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "-175447114"
	)
	public static String method3471(String var0) {
		int var1 = var0.length();
		char[] var2 = new char[var1];
		byte var3 = 2;

		for (int var4 = 0; var4 < var1; ++var4) {
			char var5 = var0.charAt(var4);
			if (var3 == 0) {
				var5 = Character.toLowerCase(var5);
			} else if (var3 == 2 || Character.isUpperCase(var5)) {
				var5 = UrlRequester.method3260(var5);
			}

			if (Character.isLetter(var5)) {
				var3 = 0;
			} else if (var5 != '.' && var5 != '?' && var5 != '!') {
				if (Character.isSpaceChar(var5)) {
					if (var3 != 2) {
						var3 = 1;
					}
				} else {
					var3 = 1;
				}
			} else {
				var3 = 2;
			}

			var2[var4] = var5;
		}

		return new String(var2);
	}

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-1514465632"
	)
	static final void method3472(int var0) {
		class325.method6190();

		for (ObjectSound var1 = (ObjectSound)ObjectSound.objectSounds.last(); var1 != null; var1 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var1.obj != null) {
				var1.set();
			}
		}

		int var4 = AbstractWorldMapData.method288(var0).type;
		if (var4 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var4 == 1) {
				if (var2 == 1) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.9D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.7D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.Rasterizer3D_setBrightness(0.6D);
					((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness(0.6D);
				}

				ItemDefinition.ItemDefinition_cachedSprites.clear();
			}

			if (var4 == 3) {
				short var3 = 0;
				if (var2 == 0) {
					var3 = 255;
				}

				if (var2 == 1) {
					var3 = 192;
				}

				if (var2 == 2) {
					var3 = 128;
				}

				if (var2 == 3) {
					var3 = 64;
				}

				if (var2 == 4) {
					var3 = 0;
				}

				if (var3 != Client.field761) {
					if (Client.field761 == 0 && Client.field666 != -1) {
						class83.method2068(class225.archive6, Client.field666, 0, var3, false);
						Client.field759 = false;
					} else if (var3 == 0) {
						VertexNormal.method2960();
						Client.field759 = false;
					} else if (class197.field2386 != 0) {
						TileItem.field1223 = var3;
					} else {
						class49.midiPcmStream.method3760(var3);
					}

					Client.field761 = var3;
				}
			}

			if (var4 == 4) {
				if (var2 == 0) {
					Client.soundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.soundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.soundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.soundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.soundEffectVolume = 0;
				}
			}

			if (var4 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var4 == 6) {
				Client.chatEffects = var2;
			}

			if (var4 == 9) {
				Client.field873 = var2;
			}

			if (var4 == 10) {
				if (var2 == 0) {
					Client.field868 = 127;
				}

				if (var2 == 1) {
					Client.field868 = 96;
				}

				if (var2 == 2) {
					Client.field868 = 64;
				}

				if (var2 == 3) {
					Client.field868 = 32;
				}

				if (var2 == 4) {
					Client.field868 = 0;
				}
			}

			if (var4 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var4 == 18) {
				Client.playerAttackOption = (AttackOption)findEnumerated(FloorUnderlayDefinition.method4395(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var4 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var4 == 22) {
				Client.npcAttackOption = (AttackOption)findEnumerated(FloorUnderlayDefinition.method4395(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
