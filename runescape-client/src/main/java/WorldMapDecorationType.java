import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ha")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements Enumerated {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2704(0, 0),
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2694(1, 0),
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2695(2, 0),
	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2697(3, 0),
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2698(9, 2),
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2699(4, 1),
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2700(5, 1),
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2701(6, 1),
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2702(7, 1),
	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2703(8, 1),
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2708(12, 2),
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2709(13, 2),
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2706(14, 2),
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2705(15, 2),
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2717(16, 2),
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2696(17, 2),
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2710(18, 2),
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2711(19, 2),
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2712(20, 2),
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2713(21, 2),
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2714(10, 2),
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2715(11, 2),
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "Lha;"
	)
	field2716(22, 3);

	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = -465928431
	)
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "(I)I",
		garbageValue = "-1410702910"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "25"
	)
	static void method4099() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			Canvas.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1;
			try {
				URL var3 = new URL(GrandExchangeEvents.method67("services", false) + "m=accountappeal/login.ws");
				URLConnection var4 = var3.openConnection();
				var4.setRequestProperty("connection", "close");
				var4.setDoInput(true);
				var4.setDoOutput(true);
				var4.setConnectTimeout(5000);
				OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
				var5.write("data1=req");
				var5.flush();
				InputStream var6 = var4.getInputStream();
				Buffer var7 = new Buffer(new byte[1000]);

				while (true) {
					int var8 = var6.read(var7.array, var7.offset, 1000 - var7.offset);
					if (var8 == -1) {
						var7.offset = 0;
						long var23 = var7.readLong();
						var1 = var23;
						break;
					}

					var7.offset += var8;
					if (var7.offset >= 1000) {
						var1 = 0L;
						break;
					}
				}
			} catch (Exception var34) {
				var1 = 0L;
			}

			byte var0;
			if (var1 == 0L) {
				var0 = 5;
			} else {
				String var35 = Login.Login_username;
				Random var36 = new Random();
				Buffer var27 = new Buffer(128);
				Buffer var9 = new Buffer(128);
				int[] var10 = new int[]{var36.nextInt(), var36.nextInt(), (int)(var1 >> 32), (int)var1};
				var27.writeByte(10);

				int var11;
				for (var11 = 0; var11 < 4; ++var11) {
					var27.writeInt(var36.nextInt());
				}

				var27.writeInt(var10[0]);
				var27.writeInt(var10[1]);
				var27.writeLong(var1);
				var27.writeLong(0L);

				for (var11 = 0; var11 < 4; ++var11) {
					var27.writeInt(var36.nextInt());
				}

				var27.encryptRsa(class80.field1105, class80.field1106);
				var9.writeByte(10);

				for (var11 = 0; var11 < 3; ++var11) {
					var9.writeInt(var36.nextInt());
				}

				var9.writeLong(var36.nextLong());
				var9.writeLongMedium(var36.nextLong());
				SequenceDefinition.method4770(var9);
				var9.writeLong(var36.nextLong());
				var9.encryptRsa(class80.field1105, class80.field1106);
				var11 = Varcs.stringCp1252NullTerminatedByteSize(var35);
				if (var11 % 8 != 0) {
					var11 += 8 - var11 % 8;
				}

				Buffer var12 = new Buffer(var11);
				var12.writeStringCp1252NullTerminated(var35);
				var12.offset = var11;
				var12.xteaEncryptAll(var10);
				Buffer var13 = new Buffer(var12.offset + var27.offset + var9.offset + 5);
				var13.writeByte(2);
				var13.writeByte(var27.offset);
				var13.writeBytes(var27.array, 0, var27.offset);
				var13.writeByte(var9.offset);
				var13.writeBytes(var9.array, 0, var9.offset);
				var13.writeShort(var12.offset);
				var13.writeBytes(var12.array, 0, var12.offset);
				byte[] var15 = var13.array;
				int var17 = var15.length;
				StringBuilder var18 = new StringBuilder();

				int var21;
				for (int var19 = 0; var19 < var17 + 0; var19 += 3) {
					int var20 = var15[var19] & 255;
					var18.append(class289.field3626[var20 >>> 2]);
					if (var19 < var17 - 1) {
						var21 = var15[var19 + 1] & 255;
						var18.append(class289.field3626[(var20 & 3) << 4 | var21 >>> 4]);
						if (var19 < var17 - 2) {
							int var22 = var15[var19 + 2] & 255;
							var18.append(class289.field3626[(var21 & 15) << 2 | var22 >>> 6]).append(class289.field3626[var22 & 63]);
						} else {
							var18.append(class289.field3626[(var21 & 15) << 2]).append("=");
						}
					} else {
						var18.append(class289.field3626[(var20 & 3) << 4]).append("==");
					}
				}

				String var16 = var18.toString();
				var16 = var16;

				byte var31;
				try {
					URL var28 = new URL(GrandExchangeEvents.method67("services", false) + "m=accountappeal/login.ws");
					URLConnection var37 = var28.openConnection();
					var37.setDoInput(true);
					var37.setDoOutput(true);
					var37.setConnectTimeout(5000);
					OutputStreamWriter var29 = new OutputStreamWriter(var37.getOutputStream());
					var29.write("data2=" + FriendsList.method5163(var16) + "&dest=" + FriendsList.method5163("passwordchoice.ws"));
					var29.flush();
					InputStream var30 = var37.getInputStream();
					var13 = new Buffer(new byte[1000]);

					while (true) {
						var21 = var30.read(var13.array, var13.offset, 1000 - var13.offset);
						if (var21 == -1) {
							var29.close();
							var30.close();
							String var32 = new String(var13.array);
							if (var32.startsWith("OFFLINE")) {
								var31 = 4;
							} else if (var32.startsWith("WRONG")) {
								var31 = 7;
							} else if (var32.startsWith("RELOAD")) {
								var31 = 3;
							} else if (var32.startsWith("Not permitted for social network accounts.")) {
								var31 = 6;
							} else {
								var13.xteaDecryptAll(var10);

								while (var13.offset > 0 && var13.array[var13.offset - 1] == 0) {
									--var13.offset;
								}

								var32 = new String(var13.array, 0, var13.offset);
								if (MouseRecorder.isValidURL(var32)) {
									WorldMapIcon_0.openURL(var32, true, false);
									var31 = 2;
								} else {
									var31 = 5;
								}
							}
							break;
						}

						var13.offset += var21;
						if (var13.offset >= 1000) {
							var31 = 5;
							break;
						}
					}
				} catch (Throwable var33) {
					var33.printStackTrace();
					var31 = 5;
				}

				var0 = var31;
			}

			switch(var0) {
			case 2:
				Canvas.setLoginResponseString(Strings.field3008, Strings.field2966, Strings.field2844);
				Login.loginIndex = 6;
				break;
			case 3:
				Canvas.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				Canvas.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				Canvas.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				Canvas.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				Canvas.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}
}
