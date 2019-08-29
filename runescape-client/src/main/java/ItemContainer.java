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

@ObfuscatedName("bv")
@Implements("ItemContainer")
public class ItemContainer extends Node {
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		signature = "Llm;"
	)
	@Export("itemContainers")
	static NodeHashTable itemContainers;
	@ObfuscatedName("jo")
	@ObfuscatedGetter(
		intValue = -311647147
	)
	@Export("plane")
	static int plane;
	@ObfuscatedName("j")
	@Export("ids")
	int[] ids;
	@ObfuscatedName("i")
	@Export("quantities")
	int[] quantities;

	static {
		itemContainers = new NodeHashTable(32);
	}

	ItemContainer() {
		this.ids = new int[]{-1};
		this.quantities = new int[]{0};
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "124"
	)
	static void method1120() {
		if (Login.Login_username == null || Login.Login_username.length() <= 0) {
			if (GrandExchangeOffer.clientPreferences.rememberedUsername != null) {
				Login.Login_username = GrandExchangeOffer.clientPreferences.rememberedUsername;
				Client.Login_isUsernameRemembered = true;
			} else {
				Client.Login_isUsernameRemembered = false;
			}

		}
	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "70"
	)
	static void method1118() {
		Login.Login_username = Login.Login_username.trim();
		if (Login.Login_username.length() == 0) {
			GrandExchangeOfferOwnWorldComparator.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
		} else {
			long var1 = ObjectSound.method1836();
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

				var6.encryptRsa(class80.field1108, class80.field1110);
				var7.writeByte(10);

				for (var9 = 0; var9 < 3; ++var9) {
					var7.writeInt(var5.nextInt());
				}

				var7.writeLong(var5.nextLong());
				var7.writeLongMedium(var5.nextLong());
				FloorDecoration.method2787(var7);
				var7.writeLong(var5.nextLong());
				var7.encryptRsa(class80.field1108, class80.field1110);
				var9 = Buddy.stringCp1252NullTerminatedByteSize(var4);
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
				String var12 = ViewportMouse.method2902(var11.array);

				byte var3;
				try {
					URL var13 = new URL(RouteStrategy.method3534("services", false) + "m=accountappeal/login.ws");
					URLConnection var14 = var13.openConnection();
					var14.setDoInput(true);
					var14.setDoOutput(true);
					var14.setConnectTimeout(5000);
					OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
					var15.write("data2=" + WorldMapAreaData.method658(var12) + "&dest=" + WorldMapAreaData.method658("passwordchoice.ws"));
					var15.flush();
					InputStream var16 = var14.getInputStream();
					var11 = new Buffer(new byte[1000]);

					while (true) {
						int var17 = var16.read(var11.array, var11.offset, 1000 - var11.offset);
						if (var17 == -1) {
							var15.close();
							var16.close();
							String var18 = new String(var11.array);
							if (var18.startsWith("OFFLINE")) {
								var3 = 4;
							} else if (var18.startsWith("WRONG")) {
								var3 = 7;
							} else if (var18.startsWith("RELOAD")) {
								var3 = 3;
							} else if (var18.startsWith("Not permitted for social network accounts.")) {
								var3 = 6;
							} else {
								var11.xteaDecryptAll(var8);

								while (var11.offset > 0 && var11.array[var11.offset - 1] == 0) {
									--var11.offset;
								}

								var18 = new String(var11.array, 0, var11.offset);
								if (class3.isValidURL(var18)) {
									GameObject.openURL(var18, true, false);
									var3 = 2;
								} else {
									var3 = 5;
								}
							}
							break;
						}

						var11.offset += var17;
						if (var11.offset >= 1000) {
							var3 = 5;
							break;
						}
					}
				} catch (Throwable var19) {
					var19.printStackTrace();
					var3 = 5;
				}

				var0 = var3;
			}

			switch(var0) {
			case 2:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString(Strings.field3007, Strings.field3008, Strings.field3009);
				Login.loginIndex = 6;
				break;
			case 3:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 4:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
				break;
			case 5:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
				break;
			case 6:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("", "Error connecting to server.", "");
				break;
			case 7:
				GrandExchangeOfferOwnWorldComparator.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
			}

		}
	}

	@ObfuscatedName("eb")
	@ObfuscatedSignature(
		signature = "(B)V",
		garbageValue = "22"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			Player.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			ParamDefinition.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			Client.archive0 = UserComparator10.newArchive(0, false, true, true);
			class269.archive1 = UserComparator10.newArchive(1, false, true, true);
			HealthBarUpdate.archive2 = UserComparator10.newArchive(2, true, false, true);
			UserComparator8.archive3 = UserComparator10.newArchive(3, false, true, true);
			WorldMapSprite.archive4 = UserComparator10.newArchive(4, false, true, true);
			WorldMapDecoration.archive5 = UserComparator10.newArchive(5, true, true, true);
			GrandExchangeEvent.archive6 = UserComparator10.newArchive(6, true, true, true);
			class51.archive7 = UserComparator10.newArchive(7, false, true, true);
			class2.archive8 = UserComparator10.newArchive(8, false, true, true);
			WorldMapDecoration.archive9 = UserComparator10.newArchive(9, false, true, true);
			GameObject.archive10 = UserComparator10.newArchive(10, false, true, true);
			WorldMapRectangle.archive11 = UserComparator10.newArchive(11, false, true, true);
			GameShell.archive12 = UserComparator10.newArchive(12, false, true, true);
			WorldMapID.archive13 = UserComparator10.newArchive(13, true, false, true);
			WorldMapSection1.archive14 = UserComparator10.newArchive(14, false, true, true);
			GrandExchangeOfferWorldComparator.archive15 = UserComparator10.newArchive(15, false, true, true);
			WorldMapIcon_1.archive17 = UserComparator10.newArchive(17, true, true, true);
			class40.archive18 = UserComparator10.newArchive(18, false, true, true);
			SoundCache.archive19 = UserComparator10.newArchive(19, false, true, true);
			Script.archive20 = UserComparator10.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var31 = 0;
			var0 = var31 + Client.archive0.percentage() * 4 / 100;
			var0 += class269.archive1.percentage() * 4 / 100;
			var0 += HealthBarUpdate.archive2.percentage() * 2 / 100;
			var0 += UserComparator8.archive3.percentage() * 2 / 100;
			var0 += WorldMapSprite.archive4.percentage() * 6 / 100;
			var0 += WorldMapDecoration.archive5.percentage() * 4 / 100;
			var0 += GrandExchangeEvent.archive6.percentage() * 2 / 100;
			var0 += class51.archive7.percentage() * 56 / 100;
			var0 += class2.archive8.percentage() * 2 / 100;
			var0 += WorldMapDecoration.archive9.percentage() * 2 / 100;
			var0 += GameObject.archive10.percentage() * 2 / 100;
			var0 += WorldMapRectangle.archive11.percentage() * 2 / 100;
			var0 += GameShell.archive12.percentage() * 2 / 100;
			var0 += WorldMapID.archive13.percentage() * 2 / 100;
			var0 += WorldMapSection1.archive14.percentage() * 2 / 100;
			var0 += GrandExchangeOfferWorldComparator.archive15.percentage() * 2 / 100;
			var0 += SoundCache.archive19.percentage() / 100;
			var0 += class40.archive18.percentage() / 100;
			var0 += Script.archive20.percentage() / 100;
			var0 += WorldMapIcon_1.archive17.method4177() && WorldMapIcon_1.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				InterfaceParent.method1125(Client.archive0, "Animations");
				InterfaceParent.method1125(class269.archive1, "Skeletons");
				InterfaceParent.method1125(WorldMapSprite.archive4, "Sound FX");
				InterfaceParent.method1125(WorldMapDecoration.archive5, "Maps");
				InterfaceParent.method1125(GrandExchangeEvent.archive6, "Music Tracks");
				InterfaceParent.method1125(class51.archive7, "Models");
				InterfaceParent.method1125(class2.archive8, "Sprites");
				InterfaceParent.method1125(WorldMapRectangle.archive11, "Music Jingles");
				InterfaceParent.method1125(WorldMapSection1.archive14, "Music Samples");
				InterfaceParent.method1125(GrandExchangeOfferWorldComparator.archive15, "Music Patches");
				InterfaceParent.method1125(SoundCache.archive19, "World Map");
				InterfaceParent.method1125(class40.archive18, "World Map Geography");
				InterfaceParent.method1125(Script.archive20, "World Map Ground");
				class197.spriteIds = new GraphicsDefaults();
				class197.spriteIds.decode(WorldMapIcon_1.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			PlayerType.PcmPlayer_configure(22050, !Client.isLowDetail, 2);
			MidiPcmStream var34 = new MidiPcmStream();
			var34.method3655(9, 128);
			MouseRecorder.pcmPlayer0 = ArchiveDisk.method5757(GameShell.taskHandler, 0, 22050);
			MouseRecorder.pcmPlayer0.setStream(var34);
			PlayerType.setAudioArchives(GrandExchangeOfferWorldComparator.archive15, WorldMapSection1.archive14, WorldMapSprite.archive4, var34);
			SoundCache.pcmPlayer1 = ArchiveDisk.method5757(GameShell.taskHandler, 1, 2048);
			IgnoreList.pcmStreamMixer = new PcmStreamMixer();
			SoundCache.pcmPlayer1.setStream(IgnoreList.pcmStreamMixer);
			class247.decimator = new Decimator(22050, PcmPlayer.PcmPlayer_sampleRate);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			UserComparator7.WorldMapElement_fonts = new Fonts(class2.archive8, WorldMapID.archive13);
		} else {
			int var1;
			if (Client.titleLoadingStage == 50) {
				FontName[] var33 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_verdana15, FontName.FontName_verdana11, FontName.FontName_plain12};
				var1 = var33.length;
				Fonts var28 = UserComparator7.WorldMapElement_fonts;
				FontName[] var29 = new FontName[]{FontName.FontName_verdana13, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_verdana15, FontName.FontName_verdana11, FontName.FontName_plain12};
				Client.fontsMap = var28.createMap(var29);
				if (Client.fontsMap.size() < var1) {
					Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
					Login.Login_loadingPercent = 40;
				} else {
					class30.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
					ClientPacket.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
					class43.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
					World.platformInfo = Client.platformInfoProvider.get();
					Login.Login_loadingText = "Loaded fonts";
					Login.Login_loadingPercent = 40;
					Client.titleLoadingStage = 60;
				}
			} else if (Client.titleLoadingStage == 60) {
				var0 = Language.method3607(GameObject.archive10, class2.archive8);
				var1 = HealthBarUpdate.method1683();
				if (var0 < var1) {
					Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
					Login.Login_loadingPercent = 50;
				} else {
					Login.Login_loadingText = "Loaded title screen";
					Login.Login_loadingPercent = 50;
					FloorDecoration.updateGameState(5);
					Client.titleLoadingStage = 70;
				}
			} else {
				Archive var2;
				if (Client.titleLoadingStage == 70) {
					if (!HealthBarUpdate.archive2.isFullyLoaded()) {
						Login.Login_loadingText = "Loading config - " + HealthBarUpdate.archive2.loadPercent() + "%";
						Login.Login_loadingPercent = 60;
					} else {
						Archive var32 = HealthBarUpdate.archive2;
						FloorOverlayDefinition.FloorOverlayDefinition_archive = var32;
						CollisionMap.FloorUnderlayDefinition_setArchives(HealthBarUpdate.archive2);
						Archive var35 = HealthBarUpdate.archive2;
						var2 = class51.archive7;
						class297.KitDefinition_archive = var35;
						KitDefinition.KitDefinition_modelsArchive = var2;
						KitDefinition.KitDefinition_fileCount = class297.KitDefinition_archive.getGroupFileCount(3);
						Archive var3 = HealthBarUpdate.archive2;
						Archive var4 = class51.archive7;
						boolean var5 = Client.isLowDetail;
						ObjectDefinition.ObjectDefinition_archive = var3;
						ObjectDefinition.ObjectDefinition_modelsArchive = var4;
						ObjectDefinition.ObjectDefinition_isLowDetail = var5;
						WorldMapArea.NpcDefinition_setArchives(HealthBarUpdate.archive2, class51.archive7);
						Archive var6 = HealthBarUpdate.archive2;
						StructDefinition.StructDefinition_archive = var6;
						class188.method3589(HealthBarUpdate.archive2, class51.archive7, Client.isMembersWorld, class30.fontPlain11);
						Fonts.method5234(HealthBarUpdate.archive2, Client.archive0, class269.archive1);
						Archive var30 = HealthBarUpdate.archive2;
						Archive var8 = class51.archive7;
						SpotAnimationDefinition.SpotAnimationDefinition_archive = var30;
						SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var8;
						class192.method3614(HealthBarUpdate.archive2);
						Tiles.VarpDefinition_setArchives(HealthBarUpdate.archive2);
						UserComparator10.Widget_setArchives(UserComparator8.archive3, class51.archive7, class2.archive8, WorldMapID.archive13);
						KeyHandler.InvDefinition_setArchives(HealthBarUpdate.archive2);
						Archive var9 = HealthBarUpdate.archive2;
						EnumDefinition.EnumDefinition_archive = var9;
						Archive var10 = HealthBarUpdate.archive2;
						VarcInt.VarcInt_archive = var10;
						Archive var11 = HealthBarUpdate.archive2;
						class339.ParamDefinition_archive = var11;
						KeyHandler.varcs = new Varcs();
						Archive var12 = HealthBarUpdate.archive2;
						Archive var13 = class2.archive8;
						Archive var14 = WorldMapID.archive13;
						HitSplatDefinition.HitSplatDefinition_archive = var12;
						GrandExchangeOfferTotalQuantityComparator.HitSplatDefinition_spritesArchive = var13;
						class43.HitSplatDefinition_fontsArchive = var14;
						Archive var15 = HealthBarUpdate.archive2;
						Archive var16 = class2.archive8;
						HealthBarDefinition.HealthBarDefinition_archive = var15;
						HealthBarDefinition.HealthBarDefinition_spritesArchive = var16;
						Archive var17 = HealthBarUpdate.archive2;
						Archive var18 = class2.archive8;
						WorldMapElement.WorldMapElement_archive = var18;
						if (var17.isFullyLoaded()) {
							WorldMapElement.WorldMapElement_count = var17.getGroupFileCount(35);
							WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

							for (int var19 = 0; var19 < WorldMapElement.WorldMapElement_count; ++var19) {
								byte[] var20 = var17.takeFile(35, var19);
								WorldMapElement.WorldMapElement_cached[var19] = new WorldMapElement(var19);
								if (var20 != null) {
									WorldMapElement.WorldMapElement_cached[var19].decode(new Buffer(var20));
									WorldMapElement.WorldMapElement_cached[var19].method4290();
								}
							}
						}

						Login.Login_loadingText = "Loaded config";
						Login.Login_loadingPercent = 60;
						Client.titleLoadingStage = 80;
					}
				} else if (Client.titleLoadingStage == 80) {
					var0 = 0;
					if (class32.compass == null) {
						class32.compass = TilePaint.SpriteBuffer_getSprite(class2.archive8, class197.spriteIds.compass, 0);
					} else {
						++var0;
					}

					if (UserComparator3.redHintArrowSprite == null) {
						UserComparator3.redHintArrowSprite = TilePaint.SpriteBuffer_getSprite(class2.archive8, class197.spriteIds.field3806, 0);
					} else {
						++var0;
					}

					IndexedSprite var7;
					IndexedSprite[] var22;
					int var23;
					IndexedSprite[] var24;
					int var25;
					if (GrandExchangeOfferOwnWorldComparator.mapSceneSprites == null) {
						var2 = class2.archive8;
						var23 = class197.spriteIds.mapScenes;
						if (!World.SpriteBuffer_bufferFile(var2, var23, 0)) {
							var22 = null;
						} else {
							var24 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var25 = 0; var25 < class325.SpriteBuffer_spriteCount; ++var25) {
								var7 = var24[var25] = new IndexedSprite();
								var7.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = class325.SpriteBuffer_xOffsets[var25];
								var7.yOffset = class325.SpriteBuffer_yOffsets[var25];
								var7.subWidth = class325.SpriteBuffer_spriteWidths[var25];
								var7.subHeight = class225.SpriteBuffer_spriteHeights[var25];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = WorldMapSection1.SpriteBuffer_pixels[var25];
							}

							UserComparator7.SpriteBuffer_clear();
							var22 = var24;
						}

						GrandExchangeOfferOwnWorldComparator.mapSceneSprites = var22;
					} else {
						++var0;
					}

					if (UserComparator6.headIconPkSprites == null) {
						UserComparator6.headIconPkSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.headIconsPk, 0);
					} else {
						++var0;
					}

					if (IntHashTable.headIconPrayerSprites == null) {
						IntHashTable.headIconPrayerSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.field3805, 0);
					} else {
						++var0;
					}

					if (WorldMapData_1.headIconHintSprites == null) {
						WorldMapData_1.headIconHintSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.field3802, 0);
					} else {
						++var0;
					}

					if (WorldMapSection1.mapMarkerSprites == null) {
						WorldMapSection1.mapMarkerSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.field3798, 0);
					} else {
						++var0;
					}

					if (DefaultsGroup.crossSprites == null) {
						DefaultsGroup.crossSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.field3804, 0);
					} else {
						++var0;
					}

					if (WorldMapLabel.mapDotSprites == null) {
						WorldMapLabel.mapDotSprites = WorldMapID.SpriteBuffer_getSpriteArray(class2.archive8, class197.spriteIds.field3797, 0);
					} else {
						++var0;
					}

					if (ClientPreferences.scrollBarSprites == null) {
						var2 = class2.archive8;
						var23 = class197.spriteIds.field3801;
						if (!World.SpriteBuffer_bufferFile(var2, var23, 0)) {
							var22 = null;
						} else {
							var24 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var25 = 0; var25 < class325.SpriteBuffer_spriteCount; ++var25) {
								var7 = var24[var25] = new IndexedSprite();
								var7.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = class325.SpriteBuffer_xOffsets[var25];
								var7.yOffset = class325.SpriteBuffer_yOffsets[var25];
								var7.subWidth = class325.SpriteBuffer_spriteWidths[var25];
								var7.subHeight = class225.SpriteBuffer_spriteHeights[var25];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = WorldMapSection1.SpriteBuffer_pixels[var25];
							}

							UserComparator7.SpriteBuffer_clear();
							var22 = var24;
						}

						ClientPreferences.scrollBarSprites = var22;
					} else {
						++var0;
					}

					if (Messages.modIconSprites == null) {
						var2 = class2.archive8;
						var23 = class197.spriteIds.field3807;
						if (!World.SpriteBuffer_bufferFile(var2, var23, 0)) {
							var22 = null;
						} else {
							var24 = new IndexedSprite[class325.SpriteBuffer_spriteCount];

							for (var25 = 0; var25 < class325.SpriteBuffer_spriteCount; ++var25) {
								var7 = var24[var25] = new IndexedSprite();
								var7.width = GrandExchangeOfferUnitPriceComparator.SpriteBuffer_spriteWidth;
								var7.height = class325.SpriteBuffer_spriteHeight;
								var7.xOffset = class325.SpriteBuffer_xOffsets[var25];
								var7.yOffset = class325.SpriteBuffer_yOffsets[var25];
								var7.subWidth = class325.SpriteBuffer_spriteWidths[var25];
								var7.subHeight = class225.SpriteBuffer_spriteHeights[var25];
								var7.palette = class325.SpriteBuffer_spritePalette;
								var7.pixels = WorldMapSection1.SpriteBuffer_pixels[var25];
							}

							UserComparator7.SpriteBuffer_clear();
							var22 = var24;
						}

						Messages.modIconSprites = var22;
					} else {
						++var0;
					}

					if (var0 < 11) {
						Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
						Login.Login_loadingPercent = 70;
					} else {
						AbstractFont.AbstractFont_modIconSprites = Messages.modIconSprites;
						UserComparator3.redHintArrowSprite.normalize();
						var1 = (int)(Math.random() * 21.0D) - 10;
						int var26 = (int)(Math.random() * 21.0D) - 10;
						var23 = (int)(Math.random() * 21.0D) - 10;
						int var27 = (int)(Math.random() * 41.0D) - 20;
						GrandExchangeOfferOwnWorldComparator.mapSceneSprites[0].shiftColors(var1 + var27, var26 + var27, var23 + var27);
						Login.Login_loadingText = "Loaded sprites";
						Login.Login_loadingPercent = 70;
						Client.titleLoadingStage = 90;
					}
				} else if (Client.titleLoadingStage == 90) {
					if (!WorldMapDecoration.archive9.isFullyLoaded()) {
						Login.Login_loadingText = "Loading textures - " + "0%";
						Login.Login_loadingPercent = 90;
					} else {
						MenuAction.textureProvider = new TextureProvider(WorldMapDecoration.archive9, class2.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
						Rasterizer3D.Rasterizer3D_setTextureLoader(MenuAction.textureProvider);
						Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
						Client.titleLoadingStage = 100;
					}
				} else if (Client.titleLoadingStage == 100) {
					var0 = MenuAction.textureProvider.getLoadedPercentage();
					if (var0 < 100) {
						Login.Login_loadingText = "Loading textures - " + var0 + "%";
						Login.Login_loadingPercent = 90;
					} else {
						Login.Login_loadingText = "Loaded textures";
						Login.Login_loadingPercent = 90;
						Client.titleLoadingStage = 110;
					}
				} else if (Client.titleLoadingStage == 110) {
					Language.mouseRecorder = new MouseRecorder();
					GameShell.taskHandler.newThreadTask(Language.mouseRecorder, 10);
					Login.Login_loadingText = "Loaded input handler";
					Login.Login_loadingPercent = 92;
					Client.titleLoadingStage = 120;
				} else if (Client.titleLoadingStage == 120) {
					if (!GameObject.archive10.tryLoadFileByNames("huffman", "")) {
						Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
						Login.Login_loadingPercent = 94;
					} else {
						Huffman var21 = new Huffman(GameObject.archive10.takeFileByNames("huffman", ""));
						class210.huffman = var21;
						Login.Login_loadingText = "Loaded wordpack";
						Login.Login_loadingPercent = 94;
						Client.titleLoadingStage = 130;
					}
				} else if (Client.titleLoadingStage == 130) {
					if (!UserComparator8.archive3.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + UserComparator8.archive3.loadPercent() * 4 / 5 + "%";
						Login.Login_loadingPercent = 96;
					} else if (!GameShell.archive12.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (80 + GameShell.archive12.loadPercent() / 6) + "%";
						Login.Login_loadingPercent = 96;
					} else if (!WorldMapID.archive13.isFullyLoaded()) {
						Login.Login_loadingText = "Loading interfaces - " + (96 + WorldMapID.archive13.loadPercent() / 50) + "%";
						Login.Login_loadingPercent = 96;
					} else {
						Login.Login_loadingText = "Loaded interfaces";
						Login.Login_loadingPercent = 98;
						Client.titleLoadingStage = 140;
					}
				} else if (Client.titleLoadingStage == 140) {
					Login.Login_loadingPercent = 100;
					if (!SoundCache.archive19.tryLoadGroupByName(WorldMapCacheName.field295.name)) {
						Login.Login_loadingText = "Loading world map - " + SoundCache.archive19.groupLoadPercentByName(WorldMapCacheName.field295.name) / 10 + "%";
					} else {
						if (WorldMapCacheName.worldMap == null) {
							WorldMapCacheName.worldMap = new WorldMap();
							WorldMapCacheName.worldMap.init(SoundCache.archive19, class40.archive18, Script.archive20, class43.fontBold12, Client.fontsMap, GrandExchangeOfferOwnWorldComparator.mapSceneSprites);
						}

						Login.Login_loadingText = "Loaded world map";
						Client.titleLoadingStage = 150;
					}
				} else if (Client.titleLoadingStage == 150) {
					FloorDecoration.updateGameState(10);
				}
			}
		}
	}

	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		signature = "(IIIII)V",
		garbageValue = "-14379933"
	)
	static final void method1119(int var0, int var1, int var2, int var3) {
		Client.overheadTextCount = 0;
		boolean var4 = false;
		int var5 = -1;
		int var6 = -1;
		int var7 = Players.Players_count;
		int[] var8 = Players.Players_indices;

		int var9;
		for (var9 = 0; var9 < var7 + Client.npcCount; ++var9) {
			Object var10;
			if (var9 < var7) {
				var10 = Client.players[var8[var9]];
				if (var8[var9] == Client.combatTargetPlayerIndex) {
					var4 = true;
					var5 = var9;
					continue;
				}

				if (var10 == WorldMapIcon_1.localPlayer) {
					var6 = var9;
					continue;
				}
			} else {
				var10 = Client.npcs[Client.npcIndices[var9 - var7]];
			}

			ObjectSound.drawActor2d((Actor)var10, var9, var0, var1, var2, var3);
		}

		if (Client.renderSelf && var6 != -1) {
			ObjectSound.drawActor2d(WorldMapIcon_1.localPlayer, var6, var0, var1, var2, var3);
		}

		if (var4) {
			ObjectSound.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var5, var0, var1, var2, var3);
		}

		for (var9 = 0; var9 < Client.overheadTextCount; ++var9) {
			int var19 = Client.overheadTextXs[var9];
			int var11 = Client.overheadTextYs[var9];
			int var12 = Client.overheadTextXOffsets[var9];
			int var13 = Client.overheadTextAscents[var9];
			boolean var14 = true;

			while (var14) {
				var14 = false;

				for (int var15 = 0; var15 < var9; ++var15) {
					if (var11 + 2 > Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] && var11 - var13 < Client.overheadTextYs[var15] + 2 && var19 - var12 < Client.overheadTextXs[var15] + Client.overheadTextXOffsets[var15] && var12 + var19 > Client.overheadTextXs[var15] - Client.overheadTextXOffsets[var15] && Client.overheadTextYs[var15] - Client.overheadTextAscents[var15] < var11) {
						var11 = Client.overheadTextYs[var15] - Client.overheadTextAscents[var15];
						var14 = true;
					}
				}
			}

			Client.viewportTempX = Client.overheadTextXs[var9];
			Client.viewportTempY = Client.overheadTextYs[var9] = var11;
			String var20 = Client.overheadText[var9];
			if (Client.chatEffects == 0) {
				int var16 = 16776960;
				if (Client.overheadTextColors[var9] < 6) {
					var16 = Client.field643[Client.overheadTextColors[var9]];
				}

				if (Client.overheadTextColors[var9] == 6) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
				}

				if (Client.overheadTextColors[var9] == 7) {
					var16 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
				}

				if (Client.overheadTextColors[var9] == 8) {
					var16 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
				}

				int var17;
				if (Client.overheadTextColors[var9] == 9) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 1280 + 16711680;
					} else if (var17 < 100) {
						var16 = 16776960 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 5 + 65280;
					}
				}

				if (Client.overheadTextColors[var9] == 10) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = var17 * 5 + 16711680;
					} else if (var17 < 100) {
						var16 = 16711935 - (var17 - 50) * 327680;
					} else if (var17 < 150) {
						var16 = (var17 - 100) * 327680 + 255 - (var17 - 100) * 5;
					}
				}

				if (Client.overheadTextColors[var9] == 11) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					if (var17 < 50) {
						var16 = 16777215 - var17 * 327685;
					} else if (var17 < 100) {
						var16 = (var17 - 50) * 327685 + 65280;
					} else if (var17 < 150) {
						var16 = 16777215 - (var17 - 100) * 327680;
					}
				}

				if (Client.overheadTextEffects[var9] == 0) {
					class43.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0);
				}

				if (Client.overheadTextEffects[var9] == 1) {
					class43.fontBold12.drawCenteredWave(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 2) {
					class43.fontBold12.drawCenteredWave2(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount);
				}

				if (Client.overheadTextEffects[var9] == 3) {
					class43.fontBold12.drawCenteredShake(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, var16, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var9]);
				}

				if (Client.overheadTextEffects[var9] == 4) {
					var17 = (150 - Client.overheadTextCyclesRemaining[var9]) * (class43.fontBold12.stringWidth(var20) + 100) / 150;
					Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
					class43.fontBold12.draw(var20, var0 + Client.viewportTempX + 50 - var17, Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}

				if (Client.overheadTextEffects[var9] == 5) {
					var17 = 150 - Client.overheadTextCyclesRemaining[var9];
					int var18 = 0;
					if (var17 < 25) {
						var18 = var17 - 25;
					} else if (var17 > 125) {
						var18 = var17 - 125;
					}

					Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class43.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
					class43.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, var18 + Client.viewportTempY + var1, var16, 0);
					Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
				}
			} else {
				class43.fontBold12.drawCentered(var20, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
			}
		}

	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		signature = "([Lhp;IIIZB)V",
		garbageValue = "47"
	)
	@Export("resizeInterface")
	static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
		for (int var5 = 0; var5 < var0.length; ++var5) {
			Widget var6 = var0[var5];
			if (var6 != null && var6.parentId == var1) {
				NetSocket.alignWidgetSize(var6, var2, var3, var4);
				Message.alignWidgetPosition(var6, var2, var3);
				if (var6.scrollX > var6.scrollWidth - var6.width) {
					var6.scrollX = var6.scrollWidth - var6.width;
				}

				if (var6.scrollX < 0) {
					var6.scrollX = 0;
				}

				if (var6.scrollY > var6.scrollHeight - var6.height) {
					var6.scrollY = var6.scrollHeight - var6.height;
				}

				if (var6.scrollY < 0) {
					var6.scrollY = 0;
				}

				if (var6.type == 0) {
					WorldMapAreaData.revalidateWidgetScroll(var0, var6, var4);
				}
			}
		}

	}

	@ObfuscatedName("lf")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "-829944775"
	)
	static void method1111() {
		if (Client.oculusOrbState == 1) {
			Client.field706 = true;
		}

	}
}
