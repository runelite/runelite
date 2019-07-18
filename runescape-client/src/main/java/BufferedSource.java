import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
@Implements("BufferedSource")
public class BufferedSource implements Runnable {
	@ObfuscatedName("q")
	@Export("thread")
	Thread thread;
	@ObfuscatedName("w")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = 491736021
	)
	@Export("capacity")
	int capacity;
	@ObfuscatedName("p")
	@Export("buffer")
	byte[] buffer;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -570790809
	)
	@Export("position")
	int position;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -902879681
	)
	@Export("limit")
	int limit;
	@ObfuscatedName("b")
	@Export("exception")
	IOException exception;

	BufferedSource(InputStream var1, int var2) {
		this.position = 0;
		this.limit = 0;
		this.inputStream = var1;
		this.capacity = var2 + 1;
		this.buffer = new byte[this.capacity];
		this.thread = new Thread(this);
		this.thread.setDaemon(true);
		this.thread.start();
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-1294773775"
	)
	@Export("isAvailable")
	boolean isAvailable(int var1) throws IOException {
		if (var1 == 0) {
			return true;
		} else if (var1 > 0 && var1 < this.capacity) {
			synchronized(this) {
				int var3;
				if (this.position <= this.limit) {
					var3 = this.limit - this.position;
				} else {
					var3 = this.capacity - this.position + this.limit;
				}

				if (var3 < var1) {
					if (this.exception != null) {
						throw new IOException(this.exception.toString());
					} else {
						this.notifyAll();
						return false;
					}
				} else {
					return true;
				}
			}
		} else {
			throw new IOException();
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-72711599"
	)
	@Export("available")
	int available() throws IOException {
		synchronized(this) {
			int var2;
			if (this.position <= this.limit) {
				var2 = this.limit - this.position;
			} else {
				var2 = this.capacity - this.position + this.limit;
			}

			if (var2 <= 0 && this.exception != null) {
				throw new IOException(this.exception.toString());
			} else {
				this.notifyAll();
				return var2;
			}
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "797723305"
	)
	@Export("readUnsignedByte")
	int readUnsignedByte() throws IOException {
		synchronized(this) {
			if (this.limit == this.position) {
				if (this.exception != null) {
					throw new IOException(this.exception.toString());
				} else {
					return -1;
				}
			} else {
				int var2 = this.buffer[this.position] & 255;
				this.position = (this.position + 1) % this.capacity;
				this.notifyAll();
				return var2;
			}
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "([BIIS)I",
		garbageValue = "28253"
	)
	@Export("read")
	int read(byte[] var1, int var2, int var3) throws IOException {
		if (var3 >= 0 && var2 >= 0 && var3 + var2 <= var1.length) {
			synchronized(this) {
				int var5;
				if (this.position <= this.limit) {
					var5 = this.limit - this.position;
				} else {
					var5 = this.capacity - this.position + this.limit;
				}

				if (var3 > var5) {
					var3 = var5;
				}

				if (var3 == 0 && this.exception != null) {
					throw new IOException(this.exception.toString());
				} else {
					if (var3 + this.position <= this.capacity) {
						System.arraycopy(this.buffer, this.position, var1, var2, var3);
					} else {
						int var6 = this.capacity - this.position;
						System.arraycopy(this.buffer, this.position, var1, var2, var6);
						System.arraycopy(this.buffer, 0, var1, var6 + var2, var3 - var6);
					}

					this.position = (var3 + this.position) % this.capacity;
					this.notifyAll();
					return var3;
				}
			}
		} else {
			throw new IOException();
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1361407903"
	)
	@Export("close")
	void close() {
		synchronized(this) {
			if (this.exception == null) {
				this.exception = new IOException("");
			}

			this.notifyAll();
		}

		try {
			this.thread.join();
		} catch (InterruptedException var3) {
		}

	}

	public void run() {
		while (true) {
			int var1;
			synchronized(this) {
				while (true) {
					if (this.exception != null) {
						return;
					}

					if (this.position == 0) {
						var1 = this.capacity - this.limit - 1;
					} else if (this.position <= this.limit) {
						var1 = this.capacity - this.limit;
					} else {
						var1 = this.position - this.limit - 1;
					}

					if (var1 > 0) {
						break;
					}

					try {
						this.wait();
					} catch (InterruptedException var10) {
					}
				}
			}

			int var7;
			try {
				var7 = this.inputStream.read(this.buffer, this.limit, var1);
				if (var7 == -1) {
					throw new EOFException();
				}
			} catch (IOException var11) {
				IOException var3 = var11;
				synchronized(this) {
					this.exception = var3;
					return;
				}
			}

			synchronized(this) {
				this.limit = (var7 + this.limit) % this.capacity;
			}
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "(Lhp;Lhp;ZII)V",
		garbageValue = "-273498913"
	)
	static void method5892(AbstractArchive var0, AbstractArchive var1, boolean var2, int var3) {
		if (Login.field1179) {
			if (var3 == 4) {
				Login.loginIndex = 4;
			}

		} else {
			Login.loginIndex = var3;
			Rasterizer2D.Rasterizer2D_clear();
			byte[] var4 = var0.takeFileByNames("title.jpg", "");
			GrandExchangeOfferWorldComparator.leftTitleSprite = BuddyRankComparator.convertJpgToSprite(var4);
			NPC.rightTitleSprite = GrandExchangeOfferWorldComparator.leftTitleSprite.mirrorHorizontally();
			if ((Client.worldProperties & 536870912) != 0) {
				GroundItem.logoSprite = class215.loadIndexedSpriteByName(var1, "logo_deadman_mode", "");
			} else {
				GroundItem.logoSprite = class215.loadIndexedSpriteByName(var1, "logo", "");
			}

			Login.titleboxSprite = class215.loadIndexedSpriteByName(var1, "titlebox", "");
			VarpDefinition.titlebuttonSprite = class215.loadIndexedSpriteByName(var1, "titlebutton", "");
			int var6 = var1.getGroupId("runes");
			int var7 = var1.getFileId(var6, "");
			IndexedSprite[] var5 = class289.method5281(var1, var6, var7);
			Login.runesSprite = var5;
			var7 = var1.getGroupId("title_mute");
			int var8 = var1.getFileId(var7, "");
			IndexedSprite[] var9 = class289.method5281(var1, var7, var8);
			Login.title_muteSprite = var9;
			Login.options_buttons_0Sprite = class215.loadIndexedSpriteByName(var1, "options_radio_buttons,0", "");
			Message.field606 = class215.loadIndexedSpriteByName(var1, "options_radio_buttons,4", "");
			Decimator.options_buttons_2Sprite = class215.loadIndexedSpriteByName(var1, "options_radio_buttons,2", "");
			Login.field1185 = class215.loadIndexedSpriteByName(var1, "options_radio_buttons,6", "");
			class237.field3191 = Login.options_buttons_0Sprite.subWidth;
			WorldMapDecoration.field212 = Login.options_buttons_0Sprite.subHeight;
			Ignored.loginScreenRunesAnimation = new LoginScreenAnimation(Login.runesSprite);
			if (var2) {
				Login.Login_username = "";
				Login.Login_password = "";
			}

			GrandExchangeOffer.field65 = 0;
			WorldMapManager.otp = "";
			Login.field1201 = true;
			Login.worldSelectOpen = false;
			if (!WorldMapLabelSize.clientPreferences.titleMusicDisabled) {
				WorldMapRegion.method533(2, WorldMapRegion.archive6, "scape main", "", 255, false);
			} else {
				class40.method729(2);
			}

			if (NetCache.NetCache_socket != null) {
				try {
					Buffer var10 = new Buffer(4);
					var10.writeByte(3);
					var10.writeMedium(0);
					NetCache.NetCache_socket.write(var10.array, 0, 4);
				} catch (IOException var13) {
					try {
						NetCache.NetCache_socket.close();
					} catch (Exception var12) {
					}

					++NetCache.NetCache_ioExceptions;
					NetCache.NetCache_socket = null;
				}
			}

			Login.field1179 = true;
			Login.xPadding = (GrandExchangeEvent.canvasWidth - 765) / 2;
			Login.loginBoxX = Login.xPadding + 202;
			ScriptEvent.loginBoxCenter = Login.loginBoxX + 180;
			GrandExchangeOfferWorldComparator.leftTitleSprite.drawAt(Login.xPadding, 0);
			NPC.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			GroundItem.logoSprite.drawAt(Login.xPadding + 382 - GroundItem.logoSprite.subWidth / 2, 18);
		}
	}
}
