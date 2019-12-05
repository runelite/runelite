import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("ScriptFrame")
public class ScriptFrame {
	@ObfuscatedName("du")
	@ObfuscatedSignature(
		signature = "Lij;"
	)
	@Export("archive11")
	static Archive archive11;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lci;"
	)
	@Export("script")
	Script script;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1054193233
	)
	@Export("pc")
	int pc;
	@ObfuscatedName("b")
	@Export("intLocals")
	int[] intLocals;
	@ObfuscatedName("g")
	@Export("stringLocals")
	String[] stringLocals;

	ScriptFrame() {
		this.pc = -1;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;B)Ljava/io/File;",
		garbageValue = "16"
	)
	@Export("getFile")
	public static File getFile(String var0) {
		if (!FileSystem.FileSystem_hasPermissions) {
			throw new RuntimeException("");
		} else {
			File var1 = (File)FileSystem.FileSystem_cacheFiles.get(var0);
			if (var1 != null) {
				return var1;
			} else {
				File var2 = new File(FileSystem.FileSystem_cacheDir, var0);
				RandomAccessFile var3 = null;

				try {
					File var4 = new File(var2.getParent());
					if (!var4.exists()) {
						throw new RuntimeException("");
					} else {
						var3 = new RandomAccessFile(var2, "rw");
						int var5 = var3.read();
						var3.seek(0L);
						var3.write(var5);
						var3.seek(0L);
						var3.close();
						FileSystem.FileSystem_cacheFiles.put(var0, var2);
						return var2;
					}
				} catch (Exception var8) {
					try {
						if (var3 != null) {
							var3.close();
							var3 = null;
						}
					} catch (Exception var7) {
					}

					throw new RuntimeException();
				}
			}
		}
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)J",
		garbageValue = "0"
	)
	static long method1162() {
		try {
			URL var0 = new URL(PacketBuffer.method5582("services", false) + "m=accountappeal/login.ws");
			URLConnection var1 = var0.openConnection();
			var1.setRequestProperty("connection", "close");
			var1.setDoInput(true);
			var1.setDoOutput(true);
			var1.setConnectTimeout(5000);
			OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
			var2.write("data1=req");
			var2.flush();
			InputStream var3 = var1.getInputStream();
			Buffer var4 = new Buffer(new byte[1000]);

			do {
				int var5 = var3.read(var4.array, var4.offset, 1000 - var4.offset);
				if (var5 == -1) {
					var4.offset = 0;
					long var7 = var4.readLong();
					return var7;
				}

				var4.offset += var5;
			} while(var4.offset < 1000);

			return 0L;
		} catch (Exception var9) {
			return 0L;
		}
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1620036213"
	)
	static void method1163() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			PacketWriter.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1 = method1162();
			byte var0;
			if (var1 == 0L) {
				var0 = 5;
			} else {
				String var4 = Login.Login_username;
				Random var5 = new Random();
				Buffer var6 = new Buffer(128);
				Buffer var7 = new Buffer(128);
				int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
				var6.writeByte(10);

				int var9;
				for (var9 = 0; var9 < 4; ++var9) {
					var6.writeInt(var5.nextInt());
				}

				var6.writeInt(var8[0]);
				var6.writeInt(var8[1]);
				var6.writeLong(var1);
				var6.writeLong(0L);

				for (var9 = 0; var9 < 4; ++var9) {
					var6.writeInt(var5.nextInt());
				}

				var6.encryptRsa(class80.field1129, class80.field1130);
				var7.writeByte(10);

				for (var9 = 0; var9 < 3; ++var9) {
					var7.writeInt(var5.nextInt());
				}

				var7.writeLong(var5.nextLong());
				var7.writeLongMedium(var5.nextLong());
				GrandExchangeOfferTotalQuantityComparator.method104(var7);
				var7.writeLong(var5.nextLong());
				var7.encryptRsa(class80.field1129, class80.field1130);
				var9 = class173.stringCp1252NullTerminatedByteSize(var4);
				if (var9 % 8 != 0) {
					var9 += 8 - var9 % 8;
				}

				Buffer var10 = new Buffer(var9);
				var10.writeStringCp1252NullTerminated(var4);
				var10.offset = var9;
				var10.xteaEncryptAll(var8);
				Buffer var11 = new Buffer(var7.offset + var6.offset + var10.offset + 5);
				var11.writeByte(2);
				var11.writeByte(var6.offset);
				var11.writeBytes(var6.array, 0, var6.offset);
				var11.writeByte(var7.offset);
				var11.writeBytes(var7.array, 0, var7.offset);
				var11.writeShort(var10.offset);
				var11.writeBytes(var10.array, 0, var10.offset);
				String var12 = StudioGame.method4220(var11.array);

				byte var3;
				try {
					URL var13 = new URL(PacketBuffer.method5582("services", false) + "m=accountappeal/login.ws");
					URLConnection var14 = var13.openConnection();
					var14.setDoInput(true);
					var14.setDoOutput(true);
					var14.setConnectTimeout(5000);
					OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
					int var18 = var12.length();
					StringBuilder var19 = new StringBuilder(var18);

					int var20;
					for (var20 = 0; var20 < var18; ++var20) {
						char var21 = var12.charAt(var20);
						if ((var21 < 'a' || var21 > 'z') && (var21 < 'A' || var21 > 'Z') && (var21 < '0' || var21 > '9') && var21 != '.' && var21 != '-' && var21 != '*' && var21 != '_') {
							if (var21 == ' ') {
								var19.append('+');
							} else {
								byte var22 = Skills.charToByteCp1252(var21);
								var19.append('%');
								int var23 = var22 >> 4 & 15;
								if (var23 >= 10) {
									var19.append((char)(var23 + 55));
								} else {
									var19.append((char)(var23 + 48));
								}

								var23 = var22 & 15;
								if (var23 >= 10) {
									var19.append((char)(var23 + 55));
								} else {
									var19.append((char)(var23 + 48));
								}
							}
						} else {
							var19.append(var21);
						}
					}

					String var17 = var19.toString();
					String var26 = "data2=" + var17 + "&dest=";
					var20 = "passwordchoice.ws".length();
					StringBuilder var27 = new StringBuilder(var20);

					for (int var32 = 0; var32 < var20; ++var32) {
						char var33 = "passwordchoice.ws".charAt(var32);
						if ((var33 < 'a' || var33 > 'z') && (var33 < 'A' || var33 > 'Z') && (var33 < '0' || var33 > '9') && var33 != '.' && var33 != '-' && var33 != '*' && var33 != '_') {
							if (var33 == ' ') {
								var27.append('+');
							} else {
								byte var24 = Skills.charToByteCp1252(var33);
								var27.append('%');
								int var25 = var24 >> 4 & 15;
								if (var25 >= 10) {
									var27.append((char)(var25 + 55));
								} else {
									var27.append((char)(var25 + 48));
								}

								var25 = var24 & 15;
								if (var25 >= 10) {
									var27.append((char)(var25 + 55));
								} else {
									var27.append((char)(var25 + 48));
								}
							}
						} else {
							var27.append(var33);
						}
					}

					String var30 = var27.toString();
					var15.write(var26 + var30);
					var15.flush();
					InputStream var28 = var14.getInputStream();
					var11 = new Buffer(new byte[1000]);

					while (true) {
						int var31 = var28.read(var11.array, var11.offset, 1000 - var11.offset);
						if (var31 == -1) {
							var15.close();
							var28.close();
							String var34 = new String(var11.array);
							if (var34.startsWith("OFFLINE")) {
								var3 = 4;
							} else if (var34.startsWith("WRONG")) {
								var3 = 7;
							} else if (var34.startsWith("RELOAD")) {
								var3 = 3;
							} else if (var34.startsWith("Not permitted for social network accounts.")) {
								var3 = 6;
							} else {
								var11.xteaDecryptAll(var8);

								while (var11.offset > 0 && var11.array[var11.offset - 1] == 0) {
									--var11.offset;
								}

								var34 = new String(var11.array, 0, var11.offset);
								if (WorldMapLabel.isValidURL(var34)) {
									WorldMapAreaData.openURL(var34, true, false);
									var3 = 2;
								} else {
									var3 = 5;
								}
							}
							break;
						}

						var11.offset += var31;
						if (var11.offset >= 1000) {
							var3 = 5;
							break;
						}
					}
				} catch (Throwable var29) {
					var29.printStackTrace();
					var3 = 5;
				}

				var0 = var3;
			}

			switch(var0) {
			case 2:
				PacketWriter.setLoginResponseString(Strings.field2912, Strings.field3039, Strings.field2786);
				Login.loginIndex = 6;
				break;
			case 3:
				PacketWriter.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				PacketWriter.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				PacketWriter.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				PacketWriter.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				PacketWriter.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}
}
