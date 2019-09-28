import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Comparator;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("o")
@Implements("GrandExchangeOfferAgeComparator")
final class GrandExchangeOfferAgeComparator implements Comparator {
	@ObfuscatedName("pq")
	@Export("ClanChat_inClanChat")
	static boolean ClanChat_inClanChat;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		signature = "Lho;"
	)
	static Widget field76;
	@ObfuscatedName("di")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive4")
	static Archive archive4;
	@ObfuscatedName("do")
	@ObfuscatedSignature(
		signature = "Lie;"
	)
	@Export("archive8")
	static Archive archive8;

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		signature = "(Lm;Lm;B)I",
		garbageValue = "24"
	)
	@Export("compare_bridged")
	int compare_bridged(GrandExchangeEvent var1, GrandExchangeEvent var2) {
		return var1.age < var2.age ? -1 : (var1.age == var2.age ? 0 : 1);
	}

	public boolean equals(Object var1) {
		return super.equals(var1);
	}

	public int compare(Object var1, Object var2) {
		return this.compare_bridged((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-72081221"
	)
	static void method167() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			PlayerType.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1;
			try {
				URL var3 = new URL(FaceNormal.method3229("services", false) + "m=accountappeal/login.ws");
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
						long var31 = var7.readLong();
						var1 = var31;
						break;
					}

					var7.offset += var8;
					if (var7.offset >= 1000) {
						var1 = 0L;
						break;
					}
				}
			} catch (Exception var46) {
				var1 = 0L;
			}

			byte var0;
			if (0L == var1) {
				var0 = 5;
			} else {
				String var47 = Login.Login_username;
				Random var48 = new Random();
				Buffer var35 = new Buffer(128);
				Buffer var9 = new Buffer(128);
				int[] var10 = new int[]{var48.nextInt(), var48.nextInt(), (int)(var1 >> 32), (int)var1};
				var35.writeByte(10);

				int var11;
				for (var11 = 0; var11 < 4; ++var11) {
					var35.writeInt(var48.nextInt());
				}

				var35.writeInt(var10[0]);
				var35.writeInt(var10[1]);
				var35.writeLong(var1);
				var35.writeLong(0L);

				for (var11 = 0; var11 < 4; ++var11) {
					var35.writeInt(var48.nextInt());
				}

				var35.encryptRsa(class80.field1119, class80.field1120);
				var9.writeByte(10);

				for (var11 = 0; var11 < 3; ++var11) {
					var9.writeInt(var48.nextInt());
				}

				var9.writeLong(var48.nextLong());
				var9.writeLongMedium(var48.nextLong());
				if (Client.randomDatData != null) {
					var9.writeBytes(Client.randomDatData, 0, Client.randomDatData.length);
				} else {
					byte[] var12 = new byte[24];

					try {
						JagexCache.JagexCache_randomDat.seek(0L);
						JagexCache.JagexCache_randomDat.readFully(var12);

						int var13;
						for (var13 = 0; var13 < 24 && var12[var13] == 0; ++var13) {
						}

						if (var13 >= 24) {
							throw new IOException();
						}
					} catch (Exception var45) {
						for (int var14 = 0; var14 < 24; ++var14) {
							var12[var14] = -1;
						}
					}

					var9.writeBytes(var12, 0, var12.length);
				}

				var9.writeLong(var48.nextLong());
				var9.encryptRsa(class80.field1119, class80.field1120);
				var11 = class268.stringCp1252NullTerminatedByteSize(var47);
				if (var11 % 8 != 0) {
					var11 += 8 - var11 % 8;
				}

				Buffer var49 = new Buffer(var11);
				var49.writeStringCp1252NullTerminated(var47);
				var49.offset = var11;
				var49.xteaEncryptAll(var10);
				Buffer var36 = new Buffer(var49.offset + var35.offset + var9.offset + 5);
				var36.writeByte(2);
				var36.writeByte(var35.offset);
				var36.writeBytes(var35.array, 0, var35.offset);
				var36.writeByte(var9.offset);
				var36.writeBytes(var9.array, 0, var9.offset);
				var36.writeShort(var49.offset);
				var36.writeBytes(var49.array, 0, var49.offset);
				byte[] var15 = var36.array;
				String var38 = class3.method52(var15, 0, var15.length);
				String var16 = var38;

				byte var43;
				try {
					URL var17 = new URL(FaceNormal.method3229("services", false) + "m=accountappeal/login.ws");
					URLConnection var18 = var17.openConnection();
					var18.setDoInput(true);
					var18.setDoOutput(true);
					var18.setConnectTimeout(5000);
					OutputStreamWriter var19 = new OutputStreamWriter(var18.getOutputStream());
					int var22 = var16.length();
					StringBuilder var23 = new StringBuilder(var22);

					int var27;
					for (int var24 = 0; var24 < var22; ++var24) {
						char var25 = var16.charAt(var24);
						if ((var25 < 'a' || var25 > 'z') && (var25 < 'A' || var25 > 'Z') && (var25 < '0' || var25 > '9') && var25 != '.' && var25 != '-' && var25 != '*' && var25 != '_') {
							if (var25 == ' ') {
								var23.append('+');
							} else {
								byte var26 = Entity.charToByteCp1252(var25);
								var23.append('%');
								var27 = var26 >> 4 & 15;
								if (var27 >= 10) {
									var23.append((char)(var27 + 55));
								} else {
									var23.append((char)(var27 + 48));
								}

								var27 = var26 & 15;
								if (var27 >= 10) {
									var23.append((char)(var27 + 55));
								} else {
									var23.append((char)(var27 + 48));
								}
							}
						} else {
							var23.append(var25);
						}
					}

					String var21 = var23.toString();
					String var50 = "data2=" + var21 + "&dest=";
					int var51 = "passwordchoice.ws".length();
					StringBuilder var40 = new StringBuilder(var51);

					for (var27 = 0; var27 < var51; ++var27) {
						char var28 = "passwordchoice.ws".charAt(var27);
						if ((var28 < 'a' || var28 > 'z') && (var28 < 'A' || var28 > 'Z') && (var28 < '0' || var28 > '9') && var28 != '.' && var28 != '-' && var28 != '*' && var28 != '_') {
							if (var28 == ' ') {
								var40.append('+');
							} else {
								byte var29 = Entity.charToByteCp1252(var28);
								var40.append('%');
								int var30 = var29 >> 4 & 15;
								if (var30 >= 10) {
									var40.append((char)(var30 + 55));
								} else {
									var40.append((char)(var30 + 48));
								}

								var30 = var29 & 15;
								if (var30 >= 10) {
									var40.append((char)(var30 + 55));
								} else {
									var40.append((char)(var30 + 48));
								}
							}
						} else {
							var40.append(var28);
						}
					}

					String var41 = var40.toString();
					var19.write(var50 + var41);
					var19.flush();
					InputStream var42 = var18.getInputStream();
					var36 = new Buffer(new byte[1000]);

					while (true) {
						int var52 = var42.read(var36.array, var36.offset, 1000 - var36.offset);
						if (var52 == -1) {
							var19.close();
							var42.close();
							String var53 = new String(var36.array);
							if (var53.startsWith("OFFLINE")) {
								var43 = 4;
							} else if (var53.startsWith("WRONG")) {
								var43 = 7;
							} else if (var53.startsWith("RELOAD")) {
								var43 = 3;
							} else if (var53.startsWith("Not permitted for social network accounts.")) {
								var43 = 6;
							} else {
								var36.xteaDecryptAll(var10);

								while (var36.offset > 0 && var36.array[var36.offset - 1] == 0) {
									--var36.offset;
								}

								var53 = new String(var36.array, 0, var36.offset);
								if (LoginScreenAnimation.isValidURL(var53)) {
									ArchiveDiskActionHandler.openURL(var53, true, false);
									var43 = 2;
								} else {
									var43 = 5;
								}
							}
							break;
						}

						var36.offset += var52;
						if (var36.offset >= 1000) {
							var43 = 5;
							break;
						}
					}
				} catch (Throwable var44) {
					var44.printStackTrace();
					var43 = 5;
				}

				var0 = var43;
			}

			switch(var0) {
			case 2:
				PlayerType.setLoginResponseString(Strings.field3008, Strings.field3009, Strings.field3010);
				Login.loginIndex = 6;
				break;
			case 3:
				PlayerType.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				PlayerType.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				PlayerType.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				PlayerType.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				PlayerType.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		signature = "(IIIIIILex;Lfa;I)V",
		garbageValue = "2071227561"
	)
	static final void method165(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectDefinition var8 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = class267.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			int var23;
			int var24;
			if (var8.hasSound()) {
				ObjectSound var22 = new ObjectSound();
				var22.plane = var0;
				var22.x = var1 * 128;
				var22.y = var2 * 16384;
				var23 = var8.sizeX;
				var24 = var8.sizeY;
				if (var4 == 1 || var4 == 3) {
					var23 = var8.sizeY;
					var24 = var8.sizeX;
				}

				var22.field1059 = (var23 + var1) * 16384;
				var22.field1060 = (var24 + var2) * 16384;
				var22.soundEffectId = var8.ambientSoundId;
				var22.field1061 = var8.int4 * 128;
				var22.field1064 = var8.int5;
				var22.field1070 = var8.int6;
				var22.soundEffectIds = var8.soundEffectIds;
				if (var8.transforms != null) {
					var22.obj = var8;
					var22.set();
				}

				ObjectSound.objectSounds.addFirst(var22);
				if (var22.soundEffectIds != null) {
					var22.field1067 = var22.field1064 + (int)(Math.random() * (double)(var22.field1070 - var22.field1064));
				}
			}

			Object var34;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Entity)var34, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else if (var5 != 10 && var5 != 11) {
				int[] var10000;
				if (var5 >= 12) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.method3056(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
					if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
						var10000 = Tiles.field488[var0][var1];
						var10000[var2] |= 2340;
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				} else if (var5 == 0) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(0, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field489[var4], 0, var19, var21);
					if (var4 == 0) {
						if (var8.clipped) {
							Tiles.field486[var0][var1][var2] = 50;
							Tiles.field486[var0][var1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = Tiles.field488[var0][var1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 1) {
						if (var8.clipped) {
							Tiles.field486[var0][var1][var2 + 1] = 50;
							Tiles.field486[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = Tiles.field488[var0][var1];
							var10000[var2 + 1] |= 1170;
						}
					} else if (var4 == 2) {
						if (var8.clipped) {
							Tiles.field486[var0][var1 + 1][var2] = 50;
							Tiles.field486[var0][var1 + 1][var2 + 1] = 50;
						}

						if (var8.modelClipped) {
							var10000 = Tiles.field488[var0][var1 + 1];
							var10000[var2] |= 585;
						}
					} else if (var4 == 3) {
						if (var8.clipped) {
							Tiles.field486[var0][var1][var2] = 50;
							Tiles.field486[var0][var1 + 1][var2] = 50;
						}

						if (var8.modelClipped) {
							var10000 = Tiles.field488[var0][var1];
							var10000[var2] |= 1170;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3508(var1, var2, var5, var4, var8.boolean1);
					}

					if (var8.int2 != 16) {
						var6.method3127(var0, var1, var2, var8.int2);
					}

				} else if (var5 == 1) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var34 = var8.getEntity(1, var4, var15, var17, var16, var18);
					} else {
						var34 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
					}

					var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field493[var4], 0, var19, var21);
					if (var8.clipped) {
						if (var4 == 0) {
							Tiles.field486[var0][var1][var2 + 1] = 50;
						} else if (var4 == 1) {
							Tiles.field486[var0][var1 + 1][var2 + 1] = 50;
						} else if (var4 == 2) {
							Tiles.field486[var0][var1 + 1][var2] = 50;
						} else if (var4 == 3) {
							Tiles.field486[var0][var1][var2] = 50;
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.method3508(var1, var2, var5, var4, var8.boolean1);
					}

				} else {
					int var28;
					if (var5 == 2) {
						var28 = var4 + 1 & 3;
						Object var29;
						Object var30;
						if (var8.animationId == -1 && var8.transforms == null) {
							var29 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
							var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
						} else {
							var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var29, (Entity)var30, Tiles.field489[var4], Tiles.field489[var28], var19, var21);
						if (var8.modelClipped) {
							if (var4 == 0) {
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 585;
								var10000 = Tiles.field488[var0][var1];
								var10000[1 + var2] |= 1170;
							} else if (var4 == 1) {
								var10000 = Tiles.field488[var0][var1];
								var10000[var2 + 1] |= 1170;
								var10000 = Tiles.field488[var0][var1 + 1];
								var10000[var2] |= 585;
							} else if (var4 == 2) {
								var10000 = Tiles.field488[var0][var1 + 1];
								var10000[var2] |= 585;
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 1170;
							} else if (var4 == 3) {
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 1170;
								var10000 = Tiles.field488[var0][var1];
								var10000[var2] |= 585;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3508(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3127(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 3) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(3, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field493[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								Tiles.field486[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								Tiles.field486[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								Tiles.field486[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								Tiles.field486[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method3508(var1, var2, var5, var4, var8.boolean1);
						}

					} else if (var5 == 9) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.method3056(var0, var1, var2, var16, 1, 1, (Entity)var34, 0, var19, var21);
						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method3127(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 4) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var34 = var8.getEntity(4, var4, var15, var17, var16, var18);
						} else {
							var34 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
						}

						var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, Tiles.field489[var4], 0, 0, 0, var19, var21);
					} else {
						long var31;
						Object var33;
						if (var5 == 5) {
							var28 = 16;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var31)).int2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, Tiles.field489[var4], 0, var28 * Tiles.field491[var4], var28 * Tiles.field492[var4], var19, var21);
						} else if (var5 == 6) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var31)).int2 / 2;
							}

							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)null, 256, var4, var28 * Tiles.field484[var4], var28 * Tiles.field494[var4], var19, var21);
						} else if (var5 == 7) {
							var23 = var4 + 2 & 3;
							if (var8.animationId == -1 && var8.transforms == null) {
								var34 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
							} else {
								var34 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var34, (Entity)null, 256, var23, 0, 0, var19, var21);
						} else if (var5 == 8) {
							var28 = 8;
							var31 = var6.getBoundaryObjectTag(var0, var1, var2);
							if (0L != var31) {
								var28 = GrandExchangeOfferOwnWorldComparator.getObjectDefinition(class81.Entity_unpackID(var31)).int2 / 2;
							}

							int var27 = var4 + 2 & 3;
							Object var26;
							if (var8.animationId == -1 && var8.transforms == null) {
								var33 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
							} else {
								var33 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
								var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, true, (Entity)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Entity)var33, (Entity)var26, 256, var4, var28 * Tiles.field484[var4], var28 * Tiles.field494[var4], var19, var21);
						}
					}
				}
			} else {
				if (var8.animationId == -1 && var8.transforms == null) {
					var34 = var8.getEntity(10, var4, var15, var17, var16, var18);
				} else {
					var34 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Entity)null);
				}

				if (var34 != null && var6.method3056(var0, var1, var2, var16, var9, var10, (Entity)var34, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
					var23 = 15;
					if (var34 instanceof Model) {
						var23 = ((Model)var34).method2859() / 4;
						if (var23 > 30) {
							var23 = 30;
						}
					}

					for (var24 = 0; var24 <= var9; ++var24) {
						for (int var25 = 0; var25 <= var10; ++var25) {
							if (var23 > Tiles.field486[var0][var24 + var1][var25 + var2]) {
								Tiles.field486[var0][var24 + var1][var25 + var2] = (byte)var23;
							}
						}
					}
				}

				if (var8.interactType != 0 && var7 != null) {
					var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
				}

			}
		}
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(IIII)I",
		garbageValue = "1521796882"
	)
	@Export("hslToRgb")
	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
		return var3;
	}
}
