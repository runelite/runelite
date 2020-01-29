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
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("fe")
@Implements("NetSocket")
public final class NetSocket extends AbstractSocket implements Runnable {
	@ObfuscatedName("sd")
	@ObfuscatedSignature(
		signature = "Llv;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		signature = "Lia;"
	)
	@Export("archive5")
	static Archive archive5;
	@ObfuscatedName("ep")
	@Export("worldHost")
	static String worldHost;
	@ObfuscatedName("fi")
	@ObfuscatedSignature(
		signature = "Lkz;"
	)
	@Export("WorldMapElement_fonts")
	static Fonts WorldMapElement_fonts;
	@ObfuscatedName("mj")
	@ObfuscatedGetter(
		intValue = -1177586883
	)
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("c")
	@Export("inputStream")
	InputStream inputStream;
	@ObfuscatedName("t")
	@Export("outputStream")
	OutputStream outputStream;
	@ObfuscatedName("o")
	@Export("socket")
	Socket socket;
	@ObfuscatedName("e")
	@Export("isClosed")
	boolean isClosed;
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lff;"
	)
	@Export("taskHandler")
	TaskHandler taskHandler;
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lfw;"
	)
	@Export("task")
	Task task;
	@ObfuscatedName("d")
	@Export("outBuffer")
	byte[] outBuffer;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -602302945
	)
	@Export("outLength")
	int outLength;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -578221925
	)
	@Export("outOffset")
	int outOffset;
	@ObfuscatedName("m")
	@Export("exceptionWriting")
	boolean exceptionWriting;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1215285735
	)
	@Export("bufferLength")
	final int bufferLength;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 639451829
	)
	@Export("maxPacketLength")
	final int maxPacketLength;

	@ObfuscatedSignature(
		signature = "(Ljava/net/Socket;Lff;I)V"
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
		signature = "(I)V",
		garbageValue = "-259367480"
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
					FriendLoginUpdate.method5325(1L);
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

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(B)I",
		garbageValue = "-108"
	)
	@Export("readUnsignedByte")
	public int readUnsignedByte() throws IOException {
		return this.isClosed ? 0 : this.inputStream.read();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "2004103994"
	)
	@Export("available")
	public int available() throws IOException {
		return this.isClosed ? 0 : this.inputStream.available();
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(II)Z",
		garbageValue = "-624446357"
	)
	@Export("isAvailable")
	public boolean isAvailable(int var1) throws IOException {
		if (this.isClosed) {
			return false;
		} else {
			return this.inputStream.available() >= var1;
		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "([BIII)I",
		garbageValue = "1847434030"
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

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "1797414909"
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

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "([BIII)V",
		garbageValue = "977025272"
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
			class225.RunException_sendStackTrace((String)null, var12);
		}

	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(ILky;Lia;I)V",
		garbageValue = "595015097"
	)
	static void method3613(int var0, ArchiveDisk var1, Archive var2) {
		byte[] var3 = null;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			for (ArchiveDiskAction var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.last(); var5 != null; var5 = (ArchiveDiskAction)ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.previous()) {
				if (var5.key == (long)var0 && var1 == var5.archiveDisk && var5.type == 0) {
					var3 = var5.data;
					break;
				}
			}
		}

		if (var3 != null) {
			var2.load(var1, var0, var3, true);
		} else {
			byte[] var4 = var1.read(var0);
			var2.load(var1, var0, var4, true);
		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1753470455"
	)
	static void method3595() {
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_lock) {
			if (ArchiveDiskActionHandler.field3150 == 0) {
				class218.ArchiveDiskActionHandler_thread = new Thread(new ArchiveDiskActionHandler());
				class218.ArchiveDiskActionHandler_thread.setDaemon(true);
				class218.ArchiveDiskActionHandler_thread.start();
				class218.ArchiveDiskActionHandler_thread.setPriority(5);
			}

			ArchiveDiskActionHandler.field3150 = 600;
		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(Lko;Lko;Lko;B)V",
		garbageValue = "-120"
	)
	@Export("drawTitle")
	static void drawTitle(Font var0, Font var1, Font var2) {
		Login.xPadding = (Username.canvasWidth - 765) / 2;
		Login.loginBoxX = Login.xPadding + 202;
		class96.loginBoxCenter = Login.loginBoxX + 180;
		int var6;
		int var9;
		byte var23;
		int var24;
		int var26;
		int var33;
		int var41;
		if (Login.worldSelectOpen) {
			Archive var32;
			if (UserComparator6.worldSelectBackSprites == null) {
				var32 = UserComparator8.archive8;
				var33 = var32.getGroupId("sl_back");
				var6 = var32.getFileId(var33, "");
				Sprite[] var7;
				if (!class228.method4199(var32, var33, var6)) {
					var7 = null;
				} else {
					var7 = HorizontalAlignment.method4783();
				}

				UserComparator6.worldSelectBackSprites = var7;
			}

			if (ReflectionCheck.worldSelectFlagSprites == null) {
				ReflectionCheck.worldSelectFlagSprites = FaceNormal.method3336(UserComparator8.archive8, "sl_flags", "");
			}

			int var38;
			if (ItemContainer.worldSelectArrows == null) {
				var32 = UserComparator8.archive8;
				var33 = var32.getGroupId("sl_arrows");
				var6 = var32.getFileId(var33, "");
				IndexedSprite[] var35;
				if (!class228.method4199(var32, var33, var6)) {
					var35 = null;
				} else {
					IndexedSprite[] var29 = new IndexedSprite[class326.SpriteBuffer_spriteCount];

					for (var38 = 0; var38 < class326.SpriteBuffer_spriteCount; ++var38) {
						IndexedSprite var30 = var29[var38] = new IndexedSprite();
						var30.width = GZipDecompressor.SpriteBuffer_spriteWidth;
						var30.height = class326.SpriteBuffer_spriteHeight;
						var30.xOffset = Huffman.SpriteBuffer_xOffsets[var38];
						var30.yOffset = NPC.SpriteBuffer_yOffsets[var38];
						var30.subWidth = class326.SpriteBuffer_spriteWidths[var38];
						var30.subHeight = class326.SpriteBuffer_spriteHeights[var38];
						var30.palette = class326.SpriteBuffer_spritePalette;
						var30.pixels = class326.SpriteBuffer_pixels[var38];
					}

					DynamicObject.method2292();
					var35 = var29;
				}

				ItemContainer.worldSelectArrows = var35;
			}

			if (DynamicObject.worldSelectStars == null) {
				DynamicObject.worldSelectStars = FaceNormal.method3336(UserComparator8.archive8, "sl_stars", "");
			}

			if (GrandExchangeEvent.worldSelectLeftSprite == null) {
				GrandExchangeEvent.worldSelectLeftSprite = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "leftarrow", "");
			}

			if (class32.worldSelectRightSprite == null) {
				class32.worldSelectRightSprite = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "rightarrow", "");
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding, 23, 765, 480, 0);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding, 0, 125, 23, 12425273, 9135624);
			Rasterizer2D.Rasterizer2D_fillRectangleGradient(Login.xPadding + 125, 0, 640, 23, 5197647, 2697513);
			var0.drawCentered("Select a world", Login.xPadding + 62, 15, 0, -1);
			if (DynamicObject.worldSelectStars != null) {
				DynamicObject.worldSelectStars[1].drawAt(Login.xPadding + 140, 1);
				var1.draw("Members only world", Login.xPadding + 152, 10, 16777215, -1);
				DynamicObject.worldSelectStars[0].drawAt(Login.xPadding + 140, 12);
				var1.draw("Free world", Login.xPadding + 152, 21, 16777215, -1);
			}

			if (ItemContainer.worldSelectArrows != null) {
				var41 = Login.xPadding + 280;
				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var41, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var41, 4);
				}

				if (World.World_sortOption1[0] == 0 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var41 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var41 + 15, 4);
				}

				var0.draw("World", var41 + 32, 17, 16777215, -1);
				var24 = Login.xPadding + 390;
				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var24, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var24, 4);
				}

				if (World.World_sortOption1[0] == 1 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var24 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var24 + 15, 4);
				}

				var0.draw("Players", var24 + 32, 17, 16777215, -1);
				var33 = Login.xPadding + 500;
				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var33, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var33, 4);
				}

				if (World.World_sortOption1[0] == 2 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var33 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var33 + 15, 4);
				}

				var0.draw("Location", var33 + 32, 17, 16777215, -1);
				var6 = Login.xPadding + 610;
				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 0) {
					ItemContainer.worldSelectArrows[2].drawAt(var6, 4);
				} else {
					ItemContainer.worldSelectArrows[0].drawAt(var6, 4);
				}

				if (World.World_sortOption1[0] == 3 && World.World_sortOption2[0] == 1) {
					ItemContainer.worldSelectArrows[3].drawAt(var6 + 15, 4);
				} else {
					ItemContainer.worldSelectArrows[1].drawAt(var6 + 15, 4);
				}

				var0.draw("Type", var6 + 32, 17, 16777215, -1);
			}

			Rasterizer2D.Rasterizer2D_fillRectangle(Login.xPadding + 708, 4, 50, 16, 0);
			var1.drawCentered("Cancel", Login.xPadding + 708 + 25, 16, 16777215, -1);
			Login.hoveredWorldIndex = -1;
			if (UserComparator6.worldSelectBackSprites != null) {
				var23 = 88;
				byte var45 = 19;
				var33 = 765 / (var23 + 1) - 1;
				var6 = 480 / (var45 + 1);

				int var37;
				do {
					var26 = var6;
					var37 = var33;
					if (var6 * (var33 - 1) >= World.World_count) {
						--var33;
					}

					if (var33 * (var6 - 1) >= World.World_count) {
						--var6;
					}

					if (var33 * (var6 - 1) >= World.World_count) {
						--var6;
					}
				} while(var6 != var26 || var37 != var33);

				var26 = (765 - var23 * var33) / (var33 + 1);
				if (var26 > 5) {
					var26 = 5;
				}

				var37 = (480 - var45 * var6) / (var6 + 1);
				if (var37 > 5) {
					var37 = 5;
				}

				var9 = (765 - var33 * var23 - var26 * (var33 - 1)) / 2;
				var38 = (480 - var45 * var6 - var37 * (var6 - 1)) / 2;
				int var11 = (var6 + World.World_count - 1) / var6;
				Login.worldSelectPagesCount = var11 - var33;
				if (GrandExchangeEvent.worldSelectLeftSprite != null && Login.worldSelectPage > 0) {
					GrandExchangeEvent.worldSelectLeftSprite.drawAt(8, WorldMapData_1.canvasHeight / 2 - GrandExchangeEvent.worldSelectLeftSprite.subHeight / 2);
				}

				if (class32.worldSelectRightSprite != null && Login.worldSelectPage < Login.worldSelectPagesCount) {
					class32.worldSelectRightSprite.drawAt(Username.canvasWidth - class32.worldSelectRightSprite.subWidth - 8, WorldMapData_1.canvasHeight / 2 - class32.worldSelectRightSprite.subHeight / 2);
				}

				int var12 = var38 + 23;
				int var13 = var9 + Login.xPadding;
				int var14 = 0;
				boolean var15 = false;
				int var16 = Login.worldSelectPage;

				int var17;
				for (var17 = var6 * var16; var17 < World.World_count && var16 - Login.worldSelectPage < var33; ++var17) {
					World var31 = class96.World_worlds[var17];
					boolean var19 = true;
					String var20 = Integer.toString(var31.population);
					if (var31.population == -1) {
						var20 = "OFF";
						var19 = false;
					} else if (var31.population > 1980) {
						var20 = "FULL";
						var19 = false;
					}

					int var22 = 0;
					byte var21;
					if (var31.isBeta()) {
						if (var31.isMembersOnly()) {
							var21 = 7;
						} else {
							var21 = 6;
						}
					} else if (var31.isDeadman()) {
						var22 = 16711680;
						if (var31.isMembersOnly()) {
							var21 = 5;
						} else {
							var21 = 4;
						}
					} else if (var31.method1767()) {
						if (var31.isMembersOnly()) {
							var21 = 9;
						} else {
							var21 = 8;
						}
					} else if (var31.isPvp()) {
						if (var31.isMembersOnly()) {
							var21 = 3;
						} else {
							var21 = 2;
						}
					} else if (var31.isMembersOnly()) {
						var21 = 1;
					} else {
						var21 = 0;
					}

					if (MouseHandler.MouseHandler_x >= var13 && MouseHandler.MouseHandler_y >= var12 && MouseHandler.MouseHandler_x < var13 + var23 && MouseHandler.MouseHandler_y < var12 + var45 && var19) {
						Login.hoveredWorldIndex = var17;
						UserComparator6.worldSelectBackSprites[var21].drawTransOverlayAt(var13, var12, 128, 16777215);
						var15 = true;
					} else {
						UserComparator6.worldSelectBackSprites[var21].drawAt(var13, var12);
					}

					if (ReflectionCheck.worldSelectFlagSprites != null) {
						ReflectionCheck.worldSelectFlagSprites[(var31.isMembersOnly() ? 8 : 0) + var31.location].drawAt(var13 + 29, var12);
					}

					var0.drawCentered(Integer.toString(var31.id), var13 + 15, var45 / 2 + var12 + 5, var22, -1);
					var1.drawCentered(var20, var13 + 60, var45 / 2 + var12 + 5, 268435455, -1);
					var12 = var12 + var37 + var45;
					++var14;
					if (var14 >= var6) {
						var12 = var38 + 23;
						var13 = var13 + var23 + var26;
						var14 = 0;
						++var16;
					}
				}

				if (var15) {
					var17 = var1.stringWidth(class96.World_worlds[Login.hoveredWorldIndex].activity) + 6;
					int var18 = var1.ascent + 8;
					int var39 = MouseHandler.MouseHandler_y + 25;
					if (var39 + var18 > 480) {
						var39 = MouseHandler.MouseHandler_y - 25 - var18;
					}

					Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var17 / 2, var39, var17, var18, 16777120);
					Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var17 / 2, var39, var17, var18, 0);
					var1.drawCentered(class96.World_worlds[Login.hoveredWorldIndex].activity, MouseHandler.MouseHandler_x, var39 + var1.ascent + 4, 0, -1);
				}
			}

			DevicePcmPlayerProvider.rasterProvider.drawFull(0, 0);
		} else {
			Login.leftTitleSprite.drawAt(Login.xPadding, 0);
			class32.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
			FloorDecoration.logoSprite.drawAt(Login.xPadding + 382 - FloorDecoration.logoSprite.subWidth / 2, 18);
			if (Client.gameState == 0 || Client.gameState == 5) {
				var23 = 20;
				var0.drawCentered("RuneScape is loading - please wait...", Login.loginBoxX + 180, 245 - var23, 16777215, -1);
				var24 = 253 - var23;
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 152, var24, 304, 34, 9179409);
				Rasterizer2D.Rasterizer2D_drawRectangle(Login.loginBoxX + 180 - 151, var24 + 1, 302, 32, 0);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.loginBoxX + 180 - 150, var24 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
				Rasterizer2D.Rasterizer2D_fillRectangle(Login.Login_loadingPercent * 3 + (Login.loginBoxX + 180 - 150), var24 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
				var0.drawCentered(Login.Login_loadingText, Login.loginBoxX + 180, 276 - var23, 16777215, -1);
			}

			String var25;
			String var27;
			short var40;
			short var42;
			if (Client.gameState == 20) {
				ScriptFrame.titleboxSprite.drawAt(Login.loginBoxX + 180 - ScriptFrame.titleboxSprite.subWidth / 2, 271 - ScriptFrame.titleboxSprite.subHeight / 2);
				var40 = 201;
				var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16776960, 0);
				var41 = var40 + 15;
				var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16776960, 0);
				var41 += 15;
				var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16776960, 0);
				var41 += 15;
				var41 += 7;
				if (Login.loginIndex != 4) {
					var0.draw("Login: ", Login.loginBoxX + 180 - 110, var41, 16777215, 0);
					var42 = 200;

					for (var25 = AttackOption.method2115(); var0.stringWidth(var25) > var42; var25 = var25.substring(0, var25.length() - 1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var25), Login.loginBoxX + 180 - 70, var41, 16777215, 0);
					var41 += 15;

					for (var27 = WorldMapSection2.method321(Login.Login_password); var0.stringWidth(var27) > var42; var27 = var27.substring(1)) {
					}

					var0.draw("Password: " + var27, Login.loginBoxX + 180 - 108, var41, 16777215, 0);
					var41 += 15;
				}
			}

			if (Client.gameState == 10 || Client.gameState == 11) {
				ScriptFrame.titleboxSprite.drawAt(Login.loginBoxX, 171);
				short var5;
				if (Login.loginIndex == 0) {
					var40 = 251;
					var0.drawCentered("Welcome to RuneScape", Login.loginBoxX + 180, var40, 16776960, 0);
					var41 = var40 + 30;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 291;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("New User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
					var24 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawLines("Existing User", var24 - 73, var5 - 20, 144, 40, 16777215, 0, 1, 1, 0);
				} else if (Login.loginIndex == 1) {
					var0.drawCentered(Login.Login_response0, Login.loginBoxX + 180, 201, 16776960, 0);
					var40 = 236;
					var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16777215, 0);
					var41 = var40 + 15;
					var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16777215, 0);
					var41 += 15;
					var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16777215, 0);
					var41 += 15;
					var24 = Login.loginBoxX + 180 - 80;
					var5 = 321;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Continue", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180 + 80;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var0.drawCentered("Cancel", var24, var5 + 5, 16777215, 0);
				} else if (Login.loginIndex == 2) {
					var40 = 201;
					var0.drawCentered(Login.Login_response1, class96.loginBoxCenter, var40, 16776960, 0);
					var41 = var40 + 15;
					var0.drawCentered(Login.Login_response2, class96.loginBoxCenter, var41, 16776960, 0);
					var41 += 15;
					var0.drawCentered(Login.Login_response3, class96.loginBoxCenter, var41, 16776960, 0);
					var41 += 15;
					var41 += 7;
					var0.draw("Login: ", class96.loginBoxCenter - 110, var41, 16777215, 0);
					var42 = 200;

					for (var25 = AttackOption.method2115(); var0.stringWidth(var25) > var42; var25 = var25.substring(1)) {
					}

					var0.draw(AbstractFont.escapeBrackets(var25) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), class96.loginBoxCenter - 70, var41, 16777215, 0);
					var41 += 15;

					for (var27 = WorldMapSection2.method321(Login.Login_password); var0.stringWidth(var27) > var42; var27 = var27.substring(1)) {
					}

					var0.draw("Password: " + var27 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), class96.loginBoxCenter - 108, var41, 16777215, 0);
					var41 += 15;
					var40 = 277;
					var26 = class96.loginBoxCenter + -117;
					IndexedSprite var28 = SecureRandomFuture.method2171(Client.Login_isUsernameRemembered, Login.field1183);
					var28.drawAt(var26, var40);
					var26 = var26 + var28.subWidth + 5;
					var1.draw("Remember username", var26, var40 + 13, 16776960, 0);
					var26 = class96.loginBoxCenter + 24;
					var28 = SecureRandomFuture.method2171(WorldMapSection2.clientPreferences.hideUsername, Login.field1184);
					var28.drawAt(var26, var40);
					var26 = var26 + var28.subWidth + 5;
					var1.draw("Hide username", var26, var40 + 13, 16776960, 0);
					var41 = var40 + 15;
					var9 = class96.loginBoxCenter - 80;
					short var10 = 321;
					Login.titlebuttonSprite.drawAt(var9 - 73, var10 - 20);
					var0.drawCentered("Login", var9, var10 + 5, 16777215, 0);
					var9 = class96.loginBoxCenter + 80;
					Login.titlebuttonSprite.drawAt(var9 - 73, var10 - 20);
					var0.drawCentered("Cancel", var9, var10 + 5, 16777215, 0);
					var40 = 357;
					switch(Login.field1193) {
					case 2:
						class14.field101 = "Having trouble logging in?";
						break;
					default:
						class14.field101 = "Can't login? Click here.";
					}

					Login.field1175 = new Bounds(class96.loginBoxCenter, var40, var1.stringWidth(class14.field101), 11);
					WorldMapCacheName.field315 = new Bounds(class96.loginBoxCenter, var40, var1.stringWidth("Still having trouble logging in?"), 11);
					var1.drawCentered(class14.field101, class96.loginBoxCenter, var40, 16777215, 0);
				} else if (Login.loginIndex == 3) {
					var40 = 201;
					var0.drawCentered("Invalid credentials.", Login.loginBoxX + 180, var40, 16776960, 0);
					var41 = var40 + 20;
					var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.loginBoxX + 180, var41, 16776960, 0);
					var41 += 15;
					var1.drawCentered("email address to login. Otherwise please login with your username.", Login.loginBoxX + 180, var41, 16776960, 0);
					var41 += 15;
					var24 = Login.loginBoxX + 180;
					var5 = 276;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Try again", var24, var5 + 5, 16777215, 0);
					var24 = Login.loginBoxX + 180;
					var5 = 326;
					Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
					var2.drawCentered("Forgotten password?", var24, var5 + 5, 16777215, 0);
				} else {
					short var8;
					if (Login.loginIndex == 4) {
						var0.drawCentered("Authenticator", Login.loginBoxX + 180, 201, 16776960, 0);
						var40 = 236;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16777215, 0);
						var41 = var40 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16777215, 0);
						var41 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16777215, 0);
						var41 += 15;
						var0.draw("PIN: " + WorldMapSection2.method321(LoginScreenAnimation.otp) + (Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 108, var41, 16777215, 0);
						var41 -= 8;
						var0.draw("Trust this computer", Login.loginBoxX + 180 - 9, var41, 16776960, 0);
						var41 += 15;
						var0.draw("for 30 days: ", Login.loginBoxX + 180 - 9, var41, 16776960, 0);
						var24 = Login.loginBoxX + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
						var33 = var41 - var0.ascent;
						IndexedSprite var44;
						if (Login.field1185) {
							var44 = DirectByteArrayCopier.options_buttons_2Sprite;
						} else {
							var44 = WorldMapSprite.options_buttons_0Sprite;
						}

						var44.drawAt(var24, var33);
						var41 += 15;
						var26 = Login.loginBoxX + 180 - 80;
						var8 = 321;
						Login.titlebuttonSprite.drawAt(var26 - 73, var8 - 20);
						var0.drawCentered("Continue", var26, var8 + 5, 16777215, 0);
						var26 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var26 - 73, var8 - 20);
						var0.drawCentered("Cancel", var26, var8 + 5, 16777215, 0);
						var1.drawCentered("<u=ff>Can't Log In?</u>", Login.loginBoxX + 180, var8 + 36, 255, 0);
					} else if (Login.loginIndex == 5) {
						var0.drawCentered("Forgotten your password?", Login.loginBoxX + 180, 201, 16776960, 0);
						var40 = 221;
						var2.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16776960, 0);
						var41 = var40 + 15;
						var2.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var2.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var41 += 14;
						var0.draw("Username/email: ", Login.loginBoxX + 180 - 145, var41, 16777215, 0);
						var42 = 174;

						for (var25 = AttackOption.method2115(); var0.stringWidth(var25) > var42; var25 = var25.substring(1)) {
						}

						var0.draw(AbstractFont.escapeBrackets(var25) + (Client.cycle % 40 < 20 ? PacketWriter.colorStartTag(16776960) + "|" : ""), Login.loginBoxX + 180 - 34, var41, 16777215, 0);
						var41 += 15;
						var6 = Login.loginBoxX + 180 - 80;
						short var43 = 321;
						Login.titlebuttonSprite.drawAt(var6 - 73, var43 - 20);
						var0.drawCentered("Recover", var6, var43 + 5, 16777215, 0);
						var6 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var6 - 73, var43 - 20);
						var0.drawCentered("Back", var6, var43 + 5, 16777215, 0);
						var43 = 356;
						var1.drawCentered("Still having trouble logging in?", class96.loginBoxCenter, var43, 268435455, 0);
					} else if (Login.loginIndex == 6) {
						var40 = 201;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16776960, 0);
						var41 = var40 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 7) {
						var40 = 216;
						var0.drawCentered("Your date of birth isn't set.", Login.loginBoxX + 180, var40, 16776960, 0);
						var41 = var40 + 15;
						var2.drawCentered("Please verify your account status by", Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var2.drawCentered("setting your date of birth.", Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Set Date of Birth", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 8) {
						var40 = 216;
						var0.drawCentered("Sorry, but your account is not eligible to play.", Login.loginBoxX + 180, var40, 16776960, 0);
						var41 = var40 + 15;
						var2.drawCentered("For more information, please take a look at", Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var2.drawCentered("our privacy policy.", Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var24 = Login.loginBoxX + 180 - 80;
						var5 = 321;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Privacy Policy", var24, var5 + 5, 16777215, 0);
						var24 = Login.loginBoxX + 180 + 80;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Back", var24, var5 + 5, 16777215, 0);
					} else if (Login.loginIndex == 12) {
						var40 = 201;
						String var4 = "";
						var25 = "";
						var27 = "";
						switch(Login.field1165) {
						case 0:
							var4 = "Your account has been disabled.";
							var25 = Strings.field3045;
							var27 = "";
							break;
						case 1:
							var4 = "Account locked as we suspect it has been stolen.";
							var25 = Strings.field2808;
							var27 = "";
							break;
						default:
							ViewportMouse.Login_promptCredentials(false);
						}

						var0.drawCentered(var4, Login.loginBoxX + 180, var40, 16776960, 0);
						var41 = var40 + 15;
						var2.drawCentered(var25, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var2.drawCentered(var27, Login.loginBoxX + 180, var41, 16776960, 0);
						var41 += 15;
						var26 = Login.loginBoxX + 180;
						var8 = 276;
						Login.titlebuttonSprite.drawAt(var26 - 73, var8 - 20);
						var0.drawCentered("Support Page", var26, var8 + 5, 16777215, 0);
						var26 = Login.loginBoxX + 180;
						var8 = 326;
						Login.titlebuttonSprite.drawAt(var26 - 73, var8 - 20);
						var0.drawCentered("Back", var26, var8 + 5, 16777215, 0);
					} else if (Login.loginIndex == 24) {
						var40 = 221;
						var0.drawCentered(Login.Login_response1, Login.loginBoxX + 180, var40, 16777215, 0);
						var41 = var40 + 15;
						var0.drawCentered(Login.Login_response2, Login.loginBoxX + 180, var41, 16777215, 0);
						var41 += 15;
						var0.drawCentered(Login.Login_response3, Login.loginBoxX + 180, var41, 16777215, 0);
						var41 += 15;
						var24 = Login.loginBoxX + 180;
						var5 = 301;
						Login.titlebuttonSprite.drawAt(var24 - 73, var5 - 20);
						var0.drawCentered("Ok", var24, var5 + 5, 16777215, 0);
					}
				}
			}

			if (Client.gameState >= 10) {
				int[] var3 = new int[4];
				Rasterizer2D.Rasterizer2D_getClipArray(var3);
				Rasterizer2D.Rasterizer2D_setClip(Login.xPadding, 0, Login.xPadding + 765, WorldMapData_1.canvasHeight);
				WorldMapLabelSize.loginScreenRunesAnimation.draw(Login.xPadding - 22, Client.cycle);
				WorldMapLabelSize.loginScreenRunesAnimation.draw(Login.xPadding + 22 + 765 - 128, Client.cycle);
				Rasterizer2D.Rasterizer2D_setClipArray(var3);
			}

			Login.title_muteSprite[WorldMapSection2.clientPreferences.titleMusicDisabled ? 1 : 0].drawAt(Login.xPadding + 765 - 40, 463);
			if (Client.gameState > 5 && Language.Language_EN == FriendLoginUpdate.clientLanguage) {
				if (WorldMapDecorationType.field2739 != null) {
					var41 = Login.xPadding + 5;
					var42 = 463;
					byte var36 = 100;
					byte var34 = 35;
					WorldMapDecorationType.field2739.drawAt(var41, var42);
					var0.drawCentered("World" + " " + Client.worldId, var36 / 2 + var41, var34 / 2 + var42 - 2, 16777215, 0);
					if (World.World_request != null) {
						var1.drawCentered("Loading...", var36 / 2 + var41, var34 / 2 + var42 + 12, 16777215, 0);
					} else {
						var1.drawCentered("Click to switch", var36 / 2 + var41, var34 / 2 + var42 + 12, 16777215, 0);
					}
				} else {
					WorldMapDecorationType.field2739 = class16.SpriteBuffer_getIndexedSpriteByName(UserComparator8.archive8, "sl_button", "");
				}
			}

		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(ILce;ZI)I",
		garbageValue = "1157828358"
	)
	static int method3608(int var0, Script var1, boolean var2) {
		Widget var3 = Varps.getWidget(Interpreter.Interpreter_intStack[--class320.Interpreter_intStackSize]);
		if (var0 == ScriptOpcodes.IF_GETX) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.x;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETY) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.y;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETWIDTH) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.width;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHEIGHT) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.height;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETHIDE) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
			return 1;
		} else if (var0 == ScriptOpcodes.IF_GETLAYER) {
			Interpreter.Interpreter_intStack[++class320.Interpreter_intStackSize - 1] = var3.parentId;
			return 1;
		} else {
			return 2;
		}
	}
}
