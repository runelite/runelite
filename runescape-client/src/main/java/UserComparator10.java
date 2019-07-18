import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("UserComparator10")
public class UserComparator10 extends AbstractUserComparator {
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		signature = "Lgl;"
	)
	@Export("musicTrack")
	public static MusicTrack musicTrack;
	@ObfuscatedName("q")
	@Export("reversed")
	final boolean reversed;

	public UserComparator10(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(Ljz;Ljz;I)I",
		garbageValue = "1029227971"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (Client.worldId == var1.world && var2.world == Client.worldId) {
			return this.reversed ? var1.int2 - var2.int2 : var2.int2 - var1.int2;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		signature = "(S)V",
		garbageValue = "8742"
	)
	static void method3406() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			class268.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1;
			try {
				URL var3 = new URL(class190.method3666("services", false) + "m=accountappeal/login.ws");
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
						long var22 = var7.readLong();
						var1 = var22;
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
			if (0L == var1) {
				var0 = 5;
			} else {
				String var35 = Login.Login_username;
				Random var36 = new Random();
				Buffer var26 = new Buffer(128);
				Buffer var9 = new Buffer(128);
				int[] var10 = new int[]{var36.nextInt(), var36.nextInt(), (int)(var1 >> 32), (int)var1};
				var26.writeByte(10);

				int var11;
				for (var11 = 0; var11 < 4; ++var11) {
					var26.writeInt(var36.nextInt());
				}

				var26.writeInt(var10[0]);
				var26.writeInt(var10[1]);
				var26.writeLong(var1);
				var26.writeLong(0L);

				for (var11 = 0; var11 < 4; ++var11) {
					var26.writeInt(var36.nextInt());
				}

				var26.encryptRsa(class80.field1140, class80.field1141);
				var9.writeByte(10);

				for (var11 = 0; var11 < 3; ++var11) {
					var9.writeInt(var36.nextInt());
				}

				var9.writeLong(var36.nextLong());
				var9.writeLongMedium(var36.nextLong());
				if (Client.field693 != null) {
					var9.writeBytes(Client.field693, 0, Client.field693.length);
				} else {
					byte[] var12 = new byte[24];

					try {
						class167.randomDat.seek(0L);
						class167.randomDat.readFully(var12);

						int var13;
						for (var13 = 0; var13 < 24 && var12[var13] == 0; ++var13) {
						}

						if (var13 >= 24) {
							throw new IOException();
						}
					} catch (Exception var33) {
						for (int var14 = 0; var14 < 24; ++var14) {
							var12[var14] = -1;
						}
					}

					var9.writeBytes(var12, 0, var12.length);
				}

				var9.writeLong(var36.nextLong());
				var9.encryptRsa(class80.field1140, class80.field1141);
				var11 = Huffman.stringCp1252NullTerminatedByteSize(var35);
				if (var11 % 8 != 0) {
					var11 += 8 - var11 % 8;
				}

				Buffer var37 = new Buffer(var11);
				var37.writeStringCp1252NullTerminated(var35);
				var37.offset = var11;
				var37.xteaEncryptAll(var10);
				Buffer var27 = new Buffer(var9.offset + var26.offset + var37.offset + 5);
				var27.writeByte(2);
				var27.writeByte(var26.offset);
				var27.writeBytes(var26.array, 0, var26.offset);
				var27.writeByte(var9.offset);
				var27.writeBytes(var9.array, 0, var9.offset);
				var27.writeShort(var37.offset);
				var27.writeBytes(var37.array, 0, var37.offset);
				byte[] var15 = var27.array;
				String var29 = Widget.method4092(var15, 0, var15.length);
				String var16 = var29;

				byte var30;
				try {
					URL var17 = new URL(class190.method3666("services", false) + "m=accountappeal/login.ws");
					URLConnection var18 = var17.openConnection();
					var18.setDoInput(true);
					var18.setDoOutput(true);
					var18.setConnectTimeout(5000);
					OutputStreamWriter var19 = new OutputStreamWriter(var18.getOutputStream());
					var19.write("data2=" + GrandExchangeOfferWorldComparator.method63(var16) + "&dest=" + GrandExchangeOfferWorldComparator.method63("passwordchoice.ws"));
					var19.flush();
					InputStream var20 = var18.getInputStream();
					var27 = new Buffer(new byte[1000]);

					while (true) {
						int var21 = var20.read(var27.array, var27.offset, 1000 - var27.offset);
						if (var21 == -1) {
							var19.close();
							var20.close();
							String var31 = new String(var27.array);
							if (var31.startsWith("OFFLINE")) {
								var30 = 4;
							} else if (var31.startsWith("WRONG")) {
								var30 = 7;
							} else if (var31.startsWith("RELOAD")) {
								var30 = 3;
							} else if (var31.startsWith("Not permitted for social network accounts.")) {
								var30 = 6;
							} else {
								var27.xteaDecryptAll(var10);

								while (var27.offset > 0 && var27.array[var27.offset - 1] == 0) {
									--var27.offset;
								}

								var31 = new String(var27.array, 0, var27.offset);
								if (HealthBarUpdate.method1676(var31)) {
									GrandExchangeOfferWorldComparator.openURL(var31, true, false);
									var30 = 2;
								} else {
									var30 = 5;
								}
							}
							break;
						}

						var27.offset += var21;
						if (var27.offset >= 1000) {
							var30 = 5;
							break;
						}
					}
				} catch (Throwable var32) {
					var32.printStackTrace();
					var30 = 5;
				}

				var0 = var30;
			}

			switch(var0) {
			case 2:
				class268.setLoginResponseString(Strings.field2942, Strings.field3027, Strings.field2768);
				Login.loginIndex = 6;
				break;
			case 3:
				class268.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				class268.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				class268.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				class268.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				class268.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-1807078732"
	)
	static void method3405() {
		Iterator var0 = Messages.Messages_hashTable.iterator();

		while (var0.hasNext()) {
			Message var1 = (Message)var0.next();
			var1.clearIsFromIgnored();
		}

	}

	@ObfuscatedName("kj")
	@ObfuscatedSignature(
		signature = "(Lhj;IS)Ljava/lang/String;",
		garbageValue = "255"
	)
	static String method3407(Widget var0, int var1) {
		int var3 = class268.getWidgetClickMask(var0);
		boolean var2 = (var3 >> var1 + 1 & 1) != 0;
		if (!var2 && var0.onOp == null) {
			return null;
		} else {
			return var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0 ? var0.actions[var1] : null;
		}
	}
}
