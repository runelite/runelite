import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
	@ObfuscatedName("z")
	@Export("ArchiveDisk_buffer")
	static byte[] ArchiveDisk_buffer;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("datFile")
	BufferedFile datFile;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lmm;"
	)
	@Export("idxFile")
	BufferedFile idxFile;
	@ObfuscatedName("u")
	@ObfuscatedGetter(
		intValue = 558641831
	)
	@Export("archive")
	int archive;
	@ObfuscatedName("r")
	@ObfuscatedGetter(
		intValue = -1322039527
	)
	@Export("maxEntrySize")
	int maxEntrySize;

	static {
		ArchiveDisk_buffer = new byte[520];
	}

	@ObfuscatedSignature(
		signature = "(ILmm;Lmm;I)V"
	)
	public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
		this.datFile = null;
		this.idxFile = null;
		this.maxEntrySize = 65000;
		this.archive = var1;
		this.datFile = var2;
		this.idxFile = var3;
		this.maxEntrySize = var4;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(IB)[B",
		garbageValue = "1"
	)
	@Export("read")
	public byte[] read(int var1) {
		synchronized(this.datFile) {
			try {
				Object var10000;
				if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
					var10000 = null;
					return (byte[])var10000;
				} else {
					this.idxFile.seek((long)(var1 * 6));
					this.idxFile.read(ArchiveDisk_buffer, 0, 6);
					int var3 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
					int var4 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
					if (var3 < 0 || var3 > this.maxEntrySize) {
						var10000 = null;
						return (byte[])var10000;
					} else if (var4 <= 0 || (long)var4 > this.datFile.length() / 520L) {
						var10000 = null;
						return (byte[])var10000;
					} else {
						byte[] var5 = new byte[var3];
						int var6 = 0;
						int var7 = 0;

						while (var6 < var3) {
							if (var4 == 0) {
								var10000 = null;
								return (byte[])var10000;
							}

							this.datFile.seek((long)var4 * 520L);
							int var8 = var3 - var6;
							int var9;
							int var10;
							int var11;
							int var12;
							byte var13;
							if (var1 > 65535) {
								if (var8 > 510) {
									var8 = 510;
								}

								var13 = 10;
								this.datFile.read(ArchiveDisk_buffer, 0, var8 + var13);
								var9 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
								var10 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
								var11 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
								var12 = ArchiveDisk_buffer[9] & 255;
							} else {
								if (var8 > 512) {
									var8 = 512;
								}

								var13 = 8;
								this.datFile.read(ArchiveDisk_buffer, 0, var8 + var13);
								var9 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
								var10 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
								var11 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
								var12 = ArchiveDisk_buffer[7] & 255;
							}

							if (var9 == var1 && var10 == var7 && var12 == this.archive) {
								if (var11 >= 0 && (long)var11 <= this.datFile.length() / 520L) {
									int var14 = var13 + var8;

									for (int var15 = var13; var15 < var14; ++var15) {
										var5[var6++] = ArchiveDisk_buffer[var15];
									}

									var4 = var11;
									++var7;
									continue;
								}

								var10000 = null;
								return (byte[])var10000;
							}

							var10000 = null;
							return (byte[])var10000;
						}

						byte[] var20 = var5;
						return var20;
					}
				}
			} catch (IOException var18) {
				return null;
			}
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "(I[BII)Z",
		garbageValue = "-1069570750"
	)
	@Export("write")
	public boolean write(int var1, byte[] var2, int var3) {
		synchronized(this.datFile) {
			if (var3 >= 0 && var3 <= this.maxEntrySize) {
				boolean var5 = this.write0(var1, var2, var3, true);
				if (!var5) {
					var5 = this.write0(var1, var2, var3, false);
				}

				return var5;
			} else {
				throw new IllegalArgumentException("" + this.archive + ',' + var1 + ',' + var3);
			}
		}
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "(I[BIZI)Z",
		garbageValue = "1005578949"
	)
	@Export("write0")
	boolean write0(int var1, byte[] var2, int var3, boolean var4) {
		synchronized(this.datFile) {
			try {
				int var6;
				boolean var10000;
				if (var4) {
					if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
						var10000 = false;
						return var10000;
					}

					this.idxFile.seek((long)(var1 * 6));
					this.idxFile.read(ArchiveDisk_buffer, 0, 6);
					var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
					if (var6 <= 0 || (long)var6 > this.datFile.length() / 520L) {
						var10000 = false;
						return var10000;
					}
				} else {
					var6 = (int)((this.datFile.length() + 519L) / 520L);
					if (var6 == 0) {
						var6 = 1;
					}
				}

				ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
				ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
				ArchiveDisk_buffer[2] = (byte)var3;
				ArchiveDisk_buffer[3] = (byte)(var6 >> 16);
				ArchiveDisk_buffer[4] = (byte)(var6 >> 8);
				ArchiveDisk_buffer[5] = (byte)var6;
				this.idxFile.seek((long)(var1 * 6));
				this.idxFile.write(ArchiveDisk_buffer, 0, 6);
				int var7 = 0;
				int var8 = 0;

				while (true) {
					if (var7 < var3) {
						label171: {
							int var9 = 0;
							int var10;
							if (var4) {
								this.datFile.seek(520L * (long)var6);
								int var11;
								int var12;
								if (var1 > 65535) {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 10);
									} catch (EOFException var17) {
										break label171;
									}

									var10 = ((ArchiveDisk_buffer[1] & 255) << 16) + ((ArchiveDisk_buffer[0] & 255) << 24) + (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var11 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[4] & 255) << 8);
									var9 = (ArchiveDisk_buffer[8] & 255) + ((ArchiveDisk_buffer[7] & 255) << 8) + ((ArchiveDisk_buffer[6] & 255) << 16);
									var12 = ArchiveDisk_buffer[9] & 255;
								} else {
									try {
										this.datFile.read(ArchiveDisk_buffer, 0, 8);
									} catch (EOFException var16) {
										break label171;
									}

									var10 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
									var11 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
									var9 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
									var12 = ArchiveDisk_buffer[7] & 255;
								}

								if (var10 != var1 || var8 != var11 || var12 != this.archive) {
									var10000 = false;
									return var10000;
								}

								if (var9 < 0 || (long)var9 > this.datFile.length() / 520L) {
									var10000 = false;
									return var10000;
								}
							}

							if (var9 == 0) {
								var4 = false;
								var9 = (int)((this.datFile.length() + 519L) / 520L);
								if (var9 == 0) {
									++var9;
								}

								if (var9 == var6) {
									++var9;
								}
							}

							if (var1 > 65535) {
								if (var3 - var7 <= 510) {
									var9 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 24);
								ArchiveDisk_buffer[1] = (byte)(var1 >> 16);
								ArchiveDisk_buffer[2] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[3] = (byte)var1;
								ArchiveDisk_buffer[4] = (byte)(var8 >> 8);
								ArchiveDisk_buffer[5] = (byte)var8;
								ArchiveDisk_buffer[6] = (byte)(var9 >> 16);
								ArchiveDisk_buffer[7] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[8] = (byte)var9;
								ArchiveDisk_buffer[9] = (byte)this.archive;
								this.datFile.seek(520L * (long)var6);
								this.datFile.write(ArchiveDisk_buffer, 0, 10);
								var10 = var3 - var7;
								if (var10 > 510) {
									var10 = 510;
								}

								this.datFile.write(var2, var7, var10);
								var7 += var10;
							} else {
								if (var3 - var7 <= 512) {
									var9 = 0;
								}

								ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
								ArchiveDisk_buffer[1] = (byte)var1;
								ArchiveDisk_buffer[2] = (byte)(var8 >> 8);
								ArchiveDisk_buffer[3] = (byte)var8;
								ArchiveDisk_buffer[4] = (byte)(var9 >> 16);
								ArchiveDisk_buffer[5] = (byte)(var9 >> 8);
								ArchiveDisk_buffer[6] = (byte)var9;
								ArchiveDisk_buffer[7] = (byte)this.archive;
								this.datFile.seek((long)var6 * 520L);
								this.datFile.write(ArchiveDisk_buffer, 0, 8);
								var10 = var3 - var7;
								if (var10 > 512) {
									var10 = 512;
								}

								this.datFile.write(var2, var7, var10);
								var7 += var10;
							}

							var6 = var9;
							++var8;
							continue;
						}
					}

					var10000 = true;
					return var10000;
				}
			} catch (IOException var18) {
				return false;
			}
		}
	}

	public String toString() {
		return "" + this.archive;
	}

	public String aak() {
		return "" + this.archive;
	}

	public String aah() {
		return "" + this.archive;
	}

	public String aae() {
		return "" + this.archive;
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lkl;Ljava/lang/String;I)I",
		garbageValue = "1895940511"
	)
	public static int method5779(Buffer var0, String var1) {
		int var2 = var0.offset;
		byte[] var3 = UserComparator3.method3390(var1);
		var0.writeSmartByteShort(var3.length);
		var0.offset += class210.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
		return var0.offset - var2;
	}

	@ObfuscatedName("el")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "1355807172"
	)
	@Export("getLoginError")
	static void getLoginError(int var0) {
		if (var0 == -3) {
			PlayerType.setLoginResponseString("Connection timed out.", "Please try using a different world.", "");
		} else if (var0 == -2) {
			PlayerType.setLoginResponseString("", "Error connecting to server.", "");
		} else if (var0 == -1) {
			PlayerType.setLoginResponseString("No response from server.", "Please try using a different world.", "");
		} else if (var0 == 3) {
			Login.loginIndex = 3;
			Login.field1171 = 1;
		} else if (var0 == 4) {
			Login.loginIndex = 12;
			Login.field1174 = 0;
		} else if (var0 == 5) {
			Login.field1171 = 2;
			PlayerType.setLoginResponseString("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
		} else if (var0 == 68 || !Client.onMobile && var0 == 6) {
			PlayerType.setLoginResponseString("RuneScape has been updated!", "Please reload this page.", "");
		} else if (var0 == 7) {
			PlayerType.setLoginResponseString("This world is full.", "Please use a different world.", "");
		} else if (var0 == 8) {
			PlayerType.setLoginResponseString("Unable to connect.", "Login server offline.", "");
		} else if (var0 == 9) {
			PlayerType.setLoginResponseString("Login limit exceeded.", "Too many connections from your address.", "");
		} else if (var0 == 10) {
			PlayerType.setLoginResponseString("Unable to connect.", "Bad session id.", "");
		} else if (var0 == 11) {
			PlayerType.setLoginResponseString("We suspect someone knows your password.", "Press 'change your password' on front page.", "");
		} else if (var0 == 12) {
			PlayerType.setLoginResponseString("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
		} else if (var0 == 13) {
			PlayerType.setLoginResponseString("Could not complete login.", "Please try using a different world.", "");
		} else if (var0 == 14) {
			PlayerType.setLoginResponseString("The server is being updated.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 16) {
			PlayerType.setLoginResponseString("Too many login attempts.", "Please wait a few minutes before trying again.", "");
		} else if (var0 == 17) {
			PlayerType.setLoginResponseString("You are standing in a members-only area.", "To play on this world move to a free area first", "");
		} else if (var0 == 18) {
			Login.loginIndex = 12;
			Login.field1174 = 1;
		} else if (var0 == 19) {
			PlayerType.setLoginResponseString("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
		} else if (var0 == 20) {
			PlayerType.setLoginResponseString("Invalid loginserver requested.", "Please try using a different world.", "");
		} else if (var0 == 22) {
			PlayerType.setLoginResponseString("Malformed login packet.", "Please try again.", "");
		} else if (var0 == 23) {
			PlayerType.setLoginResponseString("No reply from loginserver.", "Please wait 1 minute and try again.", "");
		} else if (var0 == 24) {
			PlayerType.setLoginResponseString("Error loading your profile.", "Please contact customer support.", "");
		} else if (var0 == 25) {
			PlayerType.setLoginResponseString("Unexpected loginserver response.", "Please try using a different world.", "");
		} else if (var0 == 26) {
			PlayerType.setLoginResponseString("This computers address has been blocked", "as it was used to break our rules.", "");
		} else if (var0 == 27) {
			PlayerType.setLoginResponseString("", "Service unavailable.", "");
		} else if (var0 == 31) {
			PlayerType.setLoginResponseString("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
		} else if (var0 == 32) {
			PlayerType.setLoginResponseString("Your attempt to log into your account was", "unsuccessful.  Don't worry, you can sort", "this out by visiting the billing system.");
		} else if (var0 == 37) {
			PlayerType.setLoginResponseString("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
		} else if (var0 == 38) {
			PlayerType.setLoginResponseString("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
		} else if (var0 == 55) {
			Login.loginIndex = 8;
		} else {
			if (var0 == 56) {
				PlayerType.setLoginResponseString("Enter the 6-digit code generated by your", "authenticator app.", "");
				MouseRecorder.updateGameState(11);
				return;
			}

			if (var0 == 57) {
				PlayerType.setLoginResponseString("The code you entered was incorrect.", "Please try again.", "");
				MouseRecorder.updateGameState(11);
				return;
			}

			if (var0 == 61) {
				Login.loginIndex = 7;
			} else {
				PlayerType.setLoginResponseString("Unexpected server response", "Please try using a different world.", "");
			}
		}

		MouseRecorder.updateGameState(10);
	}

	@ObfuscatedName("kb")
	@ObfuscatedSignature(
		signature = "(Lkl;IB)V",
		garbageValue = "16"
	)
	static void method5781(Buffer var0, int var1) {
		LoginScreenAnimation.method1828(var0.array, var1);
		SoundSystem.method2464(var0, var1);
	}
}
