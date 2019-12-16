import java.io.IOException;
import java.io.OutputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
@Implements("BufferedSink")
public class BufferedSink implements Runnable {
	@ObfuscatedName("f")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("i")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("y")
	@ObfuscatedGetter(
		intValue = 1559219719
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("w")
	@Export("buffer")
	byte[] buffer;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -196208499
	)
	@Export("position")
	int position;
	@ObfuscatedName("b")
	@ObfuscatedGetter(
		intValue = 1767380433
	)
	@Export("limit")
	int limit;
	@ObfuscatedName("e")
	@Export("exception")
	IOException exception;
	@ObfuscatedName("x")
	@Export("closed")
	boolean closed;

	BufferedSink(OutputStream var1, int var2) {
		this.position = 0;
		this.limit = 0;
		this.outputStream = var1;
		this.capacity = var2 + 1;
		this.buffer = new byte[this.capacity];
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "(I)Z",
		garbageValue = "649877335"
	)
	@Export("isClosed")
	boolean isClosed() {
		if (this.closed) {
			try {
				this.outputStream.close();
				if (this.exception == null) {
					this.exception = new IOException("");
				}
			} catch (IOException var2) {
				if (this.exception == null) {
					this.exception = new IOException(var2);
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "-1804311851"
	)
	@Export("write")
	void write(byte[] var1, int var2, int var3) throws IOException {
		if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
			synchronized(this) {
				if (this.exception != null) {
					throw new IOException(this.exception.toString());
				} else {
					int var5;
					if (this.position <= this.limit) {
						var5 = this.capacity - this.limit + this.position - 1;
					} else {
						var5 = this.position - this.limit - 1;
					}

					if (var5 < var3) {
						throw new IOException("");
					} else {
						if (var3 + this.limit <= this.capacity) {
							System.arraycopy(var1, var2, this.buffer, this.limit, var3);
						} else {
							int var6 = this.capacity - this.limit;
							System.arraycopy(var1, var2, this.buffer, this.limit, var6);
							System.arraycopy(var1, var6 + var2, this.buffer, 0, var3 - var6);
						}

						this.limit = (var3 + this.limit) % this.capacity;
						this.notifyAll();
					}
				}
			}
		} else {
			throw new IOException();
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1910014350"
	)
	@Export("close")
	void close() {
		synchronized(this) {
			this.closed = true;
			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
		}

	}

	public void run() {
		do {
			int var1;
			synchronized(this) {
				while (true) {
					if (this.exception != null) {
						return;
					}

					if (this.position <= this.limit) {
						var1 = this.limit - this.position;
					} else {
						var1 = this.capacity - this.position + this.limit;
					}

					if (var1 > 0) {
						break;
					}

					try {
						this.outputStream.flush();
					} catch (IOException var11) {
						this.exception = var11;
						return;
					}

					if (this.isClosed()) {
						return;
					}

					try {
						this.wait();
					} catch (InterruptedException var12) {
					}
				}
			}

			try {
				if (var1 + this.position <= this.capacity) {
					this.outputStream.write(this.buffer, this.position, var1);
				} else {
					int var7 = this.capacity - this.position;
					this.outputStream.write(this.buffer, this.position, var7);
					this.outputStream.write(this.buffer, 0, var1 - var7);
				}
			} catch (IOException var10) {
				IOException var2 = var10;
				synchronized(this) {
					this.exception = var2;
					return;
				}
			}

			synchronized(this) {
				this.position = (var1 + this.position) % this.capacity;
			}
		} while(!this.isClosed());

	}

	@ObfuscatedName("kr")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1908686960"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		Buddy.method5211();
		MouseRecorder.method1187();
		int var1 = UserComparator8.VarpDefinition_get(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
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

				NetSocket.method3525();
			}

			if (var1 == 3) {
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

				if (var3 != Client.musicVolume) {
					if (Client.musicVolume == 0 && Client.currentTrackGroupId != -1) {
						class173.playMusicTrack(GrandExchangeOfferWorldComparator.archive6, Client.currentTrackGroupId, 0, var3, false);
						Client.field767 = false;
					} else if (var3 == 0) {
						Actor.method1755();
						Client.field767 = false;
					} else {
						TextureProvider.method2796(var3);
					}

					Client.musicVolume = var3;
				}
			}

			if (var1 == 4) {
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

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
				Client.field901 = var2;
			}

			if (var1 == 10) {
				if (var2 == 0) {
					Client.areaSoundEffectVolume = 127;
				}

				if (var2 == 1) {
					Client.areaSoundEffectVolume = 96;
				}

				if (var2 == 2) {
					Client.areaSoundEffectVolume = 64;
				}

				if (var2 == 3) {
					Client.areaSoundEffectVolume = 32;
				}

				if (var2 == 4) {
					Client.areaSoundEffectVolume = 0;
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)DynamicObject.findEnumerated(ArchiveDisk.method5908(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				Client.npcAttackOption = (AttackOption)DynamicObject.findEnumerated(ArchiveDisk.method5908(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
