import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("de")
@Implements("Decimator")
public class Decimator {
	@ObfuscatedName("et")
	@ObfuscatedGetter(
		intValue = -722271125
	)
	static int field1431;
	@ObfuscatedName("g")
	@ObfuscatedGetter(
		intValue = -313653259
	)
	@Export("inputRate")
	int inputRate;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -172648561
	)
	@Export("outputRate")
	int outputRate;
	@ObfuscatedName("u")
	@Export("table")
	int[][] table;

	public Decimator(int var1, int var2) {
		if (var2 != var1) {
			int var4 = var1;
			int var5 = var2;
			if (var2 > var1) {
				var4 = var2;
				var5 = var1;
			}

			while (var5 != 0) {
				int var6 = var4 % var5;
				var4 = var5;
				var5 = var6;
			}

			var1 /= var4;
			var2 /= var4;
			this.inputRate = var1;
			this.outputRate = var2;
			this.table = new int[var1][14];

			for (int var7 = 0; var7 < var1; ++var7) {
				int[] var8 = this.table[var7];
				double var9 = 6.0D + (double)var7 / (double)var1;
				int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
				if (var11 < 0) {
					var11 = 0;
				}

				int var12 = (int)Math.ceil(7.0D + var9);
				if (var12 > 14) {
					var12 = 14;
				}

				for (double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
					double var15 = 3.141592653589793D * ((double)var11 - var9);
					double var17 = var13;
					if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
						var17 = var13 * (Math.sin(var15) / var15);
					}

					var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
					var8[var11] = (int)Math.floor(0.5D + var17 * 65536.0D);
				}
			}

		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		signature = "([BB)[B",
		garbageValue = "63"
	)
	@Export("resample")
	byte[] resample(byte[] var1) {
		if (this.table != null) {
			int var2 = (int)((long)var1.length * (long)this.outputRate / (long)this.inputRate) + 14;
			int[] var3 = new int[var2];
			int var4 = 0;
			int var5 = 0;

			int var6;
			for (var6 = 0; var6 < var1.length; ++var6) {
				byte var7 = var1[var6];
				int[] var8 = this.table[var5];

				int var9;
				for (var9 = 0; var9 < 14; ++var9) {
					var3[var9 + var4] += var8[var9] * var7;
				}

				var5 += this.outputRate;
				var9 = var5 / this.inputRate;
				var4 += var9;
				var5 -= var9 * this.inputRate;
			}

			var1 = new byte[var2];

			for (var6 = 0; var6 < var2; ++var6) {
				int var10 = var3[var6] + 32768 >> 16;
				if (var10 < -128) {
					var1[var6] = -128;
				} else if (var10 > 127) {
					var1[var6] = 127;
				} else {
					var1[var6] = (byte)var10;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		signature = "(II)I",
		garbageValue = "-749198393"
	)
	@Export("scaleRate")
	int scaleRate(int var1) {
		if (this.table != null) {
			var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate);
		}

		return var1;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		signature = "(IB)I",
		garbageValue = "-106"
	)
	@Export("scalePosition")
	int scalePosition(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
		}

		return var1;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		signature = "(II)V",
		garbageValue = "-2091115234"
	)
	public static void method2499(int var0) {
		if (class197.field2376 != 0) {
			Canvas.field395 = var0;
		} else {
			class197.midiPcmStream.method3686(var0);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		signature = "(ILcu;ZB)I",
		garbageValue = "1"
	)
	static int method2494(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.VIEWPORT_SETFOV) {
			class160.Interpreter_intStackSize -= 2;
			Client.field873 = (short)class1.method17(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize]);
			if (Client.field873 <= 0) {
				Client.field873 = 256;
			}

			Client.field752 = (short)class1.method17(Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1]);
			if (Client.field752 <= 0) {
				Client.field752 = 256;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_SETZOOM) {
			class160.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_CLAMPFOV) {
			class160.Interpreter_intStackSize -= 4;
			Client.field877 = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize];
			if (Client.field877 <= 0) {
				Client.field877 = 1;
			}

			Client.field878 = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 1];
			if (Client.field878 <= 0) {
				Client.field878 = 32767;
			} else if (Client.field878 < Client.field877) {
				Client.field878 = Client.field877;
			}

			Client.field879 = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 2];
			if (Client.field879 <= 0) {
				Client.field879 = 1;
			}

			Client.field717 = (short)Interpreter.Interpreter_intStack[class160.Interpreter_intStackSize + 3];
			if (Client.field717 <= 0) {
				Client.field717 = 32767;
			} else if (Client.field717 < Client.field879) {
				Client.field717 = Client.field879;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETEFFECTIVESIZE) {
			if (Client.viewportWidget != null) {
				DesktopPlatformInfoProvider.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETZOOM) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == ScriptOpcodes.VIEWPORT_GETFOV) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = WorldMapLabel.method381(Client.field873);
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = WorldMapLabel.method381(Client.field752);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GraphicsDefaults.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++class160.Interpreter_intStackSize - 1] = GameShell.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("ei")
	@ObfuscatedSignature(
		signature = "(I)V",
		garbageValue = "1128100526"
	)
	@Export("load")
	static void load() {
		int var0;
		if (Client.titleLoadingStage == 0) {
			WorldMapIcon_1.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			class60.sceneMinimapSprite = new Sprite(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.titleLoadingStage = 20;
		} else if (Client.titleLoadingStage == 20) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.titleLoadingStage = 30;
		} else if (Client.titleLoadingStage == 30) {
			ScriptEvent.archive0 = FloorOverlayDefinition.newArchive(0, false, true, true);
			GrandExchangeOffer.archive1 = FloorOverlayDefinition.newArchive(1, false, true, true);
			class173.archive2 = FloorOverlayDefinition.newArchive(2, true, false, true);
			WorldMapData_0.archive3 = FloorOverlayDefinition.newArchive(3, false, true, true);
			class13.archive4 = FloorOverlayDefinition.newArchive(4, false, true, true);
			Timer.archive5 = FloorOverlayDefinition.newArchive(5, true, true, true);
			WorldMapDecoration.archive6 = FloorOverlayDefinition.newArchive(6, true, true, true);
			class49.archive7 = FloorOverlayDefinition.newArchive(7, false, true, true);
			WorldMapDecoration.archive8 = FloorOverlayDefinition.newArchive(8, false, true, true);
			WorldMapData_0.archive9 = FloorOverlayDefinition.newArchive(9, false, true, true);
			FontName.archive10 = FloorOverlayDefinition.newArchive(10, false, true, true);
			ArchiveDisk.archive11 = FloorOverlayDefinition.newArchive(11, false, true, true);
			Message.archive12 = FloorOverlayDefinition.newArchive(12, false, true, true);
			TextureProvider.archive13 = FloorOverlayDefinition.newArchive(13, true, false, true);
			WorldMapLabel.archive14 = FloorOverlayDefinition.newArchive(14, false, true, true);
			BufferedSource.archive15 = FloorOverlayDefinition.newArchive(15, false, true, true);
			class49.archive17 = FloorOverlayDefinition.newArchive(17, true, true, true);
			WorldMapArea.archive18 = FloorOverlayDefinition.newArchive(18, false, true, true);
			UrlRequest.archive19 = FloorOverlayDefinition.newArchive(19, false, true, true);
			WorldMapSection1.archive20 = FloorOverlayDefinition.newArchive(20, false, true, true);
			Login.Login_loadingText = "Connecting to update server";
			Login.Login_loadingPercent = 20;
			Client.titleLoadingStage = 40;
		} else if (Client.titleLoadingStage == 40) {
			byte var24 = 0;
			var0 = var24 + ScriptEvent.archive0.percentage() * 4 / 100;
			var0 += GrandExchangeOffer.archive1.percentage() * 4 / 100;
			var0 += class173.archive2.percentage() * 2 / 100;
			var0 += WorldMapData_0.archive3.percentage() * 2 / 100;
			var0 += class13.archive4.percentage() * 6 / 100;
			var0 += Timer.archive5.percentage() * 4 / 100;
			var0 += WorldMapDecoration.archive6.percentage() * 2 / 100;
			var0 += class49.archive7.percentage() * 56 / 100;
			var0 += WorldMapDecoration.archive8.percentage() * 2 / 100;
			var0 += WorldMapData_0.archive9.percentage() * 2 / 100;
			var0 += FontName.archive10.percentage() * 2 / 100;
			var0 += ArchiveDisk.archive11.percentage() * 2 / 100;
			var0 += Message.archive12.percentage() * 2 / 100;
			var0 += TextureProvider.archive13.percentage() * 2 / 100;
			var0 += WorldMapLabel.archive14.percentage() * 2 / 100;
			var0 += BufferedSource.archive15.percentage() * 2 / 100;
			var0 += UrlRequest.archive19.percentage() / 100;
			var0 += WorldMapArea.archive18.percentage() / 100;
			var0 += WorldMapSection1.archive20.percentage() / 100;
			var0 += class49.archive17.method4265() && class49.archive17.isFullyLoaded() ? 1 : 0;
			if (var0 != 100) {
				if (var0 != 0) {
					Login.Login_loadingText = "Checking for updates - " + var0 + "%";
				}

				Login.Login_loadingPercent = 30;
			} else {
				class14.method142(ScriptEvent.archive0, "Animations");
				class14.method142(GrandExchangeOffer.archive1, "Skeletons");
				class14.method142(class13.archive4, "Sound FX");
				class14.method142(Timer.archive5, "Maps");
				class14.method142(WorldMapDecoration.archive6, "Music Tracks");
				class14.method142(class49.archive7, "Models");
				class14.method142(WorldMapDecoration.archive8, "Sprites");
				class14.method142(ArchiveDisk.archive11, "Music Jingles");
				class14.method142(WorldMapLabel.archive14, "Music Samples");
				class14.method142(BufferedSource.archive15, "Music Patches");
				class14.method142(UrlRequest.archive19, "World Map");
				class14.method142(WorldMapArea.archive18, "World Map Geography");
				class14.method142(WorldMapSection1.archive20, "World Map Ground");
				Frames.spriteIds = new GraphicsDefaults();
				Frames.spriteIds.decode(class49.archive17);
				Login.Login_loadingText = "Loaded update list";
				Login.Login_loadingPercent = 30;
				Client.titleLoadingStage = 45;
			}
		} else if (Client.titleLoadingStage == 45) {
			Login.PcmPlayer_configure(22050, !Client.isLowDetail, 2);
			MidiPcmStream var26 = new MidiPcmStream();
			var26.method3732(9, 128);
			WorldMapIcon_1.pcmPlayer0 = PacketWriter.method2246(GameShell.taskHandler, 0, 22050);
			WorldMapIcon_1.pcmPlayer0.setStream(var26);
			class192.setAudioArchives(BufferedSource.archive15, WorldMapLabel.archive14, class13.archive4, var26);
			ClientPreferences.pcmPlayer1 = PacketWriter.method2246(GameShell.taskHandler, 1, 2048);
			class51.pcmStreamMixer = new PcmStreamMixer();
			ClientPreferences.pcmPlayer1.setStream(class51.pcmStreamMixer);
			class81.decimator = new Decimator(22050, GrandExchangeOfferWorldComparator.PcmPlayer_sampleRate);
			Login.Login_loadingText = "Prepared sound engine";
			Login.Login_loadingPercent = 35;
			Client.titleLoadingStage = 50;
			GraphicsObject.WorldMapElement_fonts = new Fonts(WorldMapDecoration.archive8, TextureProvider.archive13);
		} else if (Client.titleLoadingStage == 50) {
			var0 = FontName.method5288().length;
			Client.fontsMap = GraphicsObject.WorldMapElement_fonts.createMap(FontName.method5288());
			if (Client.fontsMap.size() < var0) {
				Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
				Login.Login_loadingPercent = 40;
			} else {
				GrandExchangeEvent.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
				class197.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
				HealthBar.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
				class32.platformInfo = Client.platformInfoProvider.get();
				Login.Login_loadingText = "Loaded fonts";
				Login.Login_loadingPercent = 40;
				Client.titleLoadingStage = 60;
			}
		} else {
			Archive var2;
			int var3;
			Archive var20;
			int var23;
			if (Client.titleLoadingStage == 60) {
				var20 = FontName.archive10;
				var2 = WorldMapDecoration.archive8;
				var3 = 0;
				if (var20.tryLoadFileByNames("title.jpg", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("logo", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("logo_deadman_mode", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("titlebox", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("titlebutton", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("runes", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("title_mute", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("options_radio_buttons,0", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("options_radio_buttons,2", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("options_radio_buttons,4", "")) {
					++var3;
				}

				if (var2.tryLoadFileByNames("options_radio_buttons,6", "")) {
					++var3;
				}

				var2.tryLoadFileByNames("sl_back", "");
				var2.tryLoadFileByNames("sl_flags", "");
				var2.tryLoadFileByNames("sl_arrows", "");
				var2.tryLoadFileByNames("sl_stars", "");
				var2.tryLoadFileByNames("sl_button", "");
				var23 = AbstractWorldMapIcon.method587();
				if (var3 < var23) {
					Login.Login_loadingText = "Loading title screen - " + var3 * 100 / var23 + "%";
					Login.Login_loadingPercent = 50;
				} else {
					Login.Login_loadingText = "Loaded title screen";
					Login.Login_loadingPercent = 50;
					WorldMapIcon_0.updateGameState(5);
					Client.titleLoadingStage = 70;
				}
			} else if (Client.titleLoadingStage == 70) {
				if (!class173.archive2.isFullyLoaded()) {
					Login.Login_loadingText = "Loading config - " + class173.archive2.loadPercent() + "%";
					Login.Login_loadingPercent = 60;
				} else {
					Player.method1228(class173.archive2);
					Archive var25 = class173.archive2;
					FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var25;
					WorldMapID.method526(class173.archive2, class49.archive7);
					var20 = class173.archive2;
					var2 = class49.archive7;
					boolean var21 = Client.isLowDetail;
					GrandExchangeOfferNameComparator.ObjectDefinition_archive = var20;
					ObjectDefinition.ObjectDefinition_modelsArchive = var2;
					ObjectDefinition.ObjectDefinition_isLowDetail = var21;
					GameObject.NpcDefinition_setArchives(class173.archive2, class49.archive7);
					class188.method3617(class173.archive2);
					GrandExchangeEvents.method69(class173.archive2, class49.archive7, Client.isMembersWorld, GrandExchangeEvent.fontPlain11);
					Archive var17 = class173.archive2;
					Archive var22 = ScriptEvent.archive0;
					Archive var6 = GrandExchangeOffer.archive1;
					SequenceDefinition.SequenceDefinition_archive = var17;
					SequenceDefinition.SequenceDefinition_animationsArchive = var22;
					SequenceDefinition.SequenceDefinition_skeletonsArchive = var6;
					Archive var7 = class173.archive2;
					Archive var8 = class49.archive7;
					SpotAnimationDefinition.SpotAnimationDefinition_archive = var7;
					SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var8;
					Archive var9 = class173.archive2;
					VarbitDefinition.VarbitDefinition_archive = var9;
					Archive var10 = class173.archive2;
					class297.VarpDefinition_archive = var10;
					CollisionMap.VarpDefinition_fileCount = class297.VarpDefinition_archive.getGroupFileCount(16);
					class162.Widget_setArchives(WorldMapData_0.archive3, class49.archive7, WorldMapDecoration.archive8, TextureProvider.archive13);
					PcmPlayer.InvDefinition_setArchives(class173.archive2);
					Archive var11 = class173.archive2;
					EnumDefinition.EnumDefinition_archive = var11;
					class293.method5298(class173.archive2);
					VarcInt.method4407(class173.archive2);
					BoundaryObject.varcs = new Varcs();
					ChatChannel.method2220(class173.archive2, WorldMapDecoration.archive8, TextureProvider.archive13);
					NPCDefinition.method4749(class173.archive2, WorldMapDecoration.archive8);
					Archive var12 = class173.archive2;
					Archive var13 = WorldMapDecoration.archive8;
					WorldMapElement.WorldMapElement_archive = var13;
					if (var12.isFullyLoaded()) {
						WorldMapElement.WorldMapElement_count = var12.getGroupFileCount(35);
						WorldMapElement.WorldMapElement_cached = new WorldMapElement[WorldMapElement.WorldMapElement_count];

						for (int var14 = 0; var14 < WorldMapElement.WorldMapElement_count; ++var14) {
							byte[] var15 = var12.takeFile(35, var14);
							WorldMapElement.WorldMapElement_cached[var14] = new WorldMapElement(var14);
							if (var15 != null) {
								WorldMapElement.WorldMapElement_cached[var14].decode(new Buffer(var15));
								WorldMapElement.WorldMapElement_cached[var14].method4378();
							}
						}
					}

					Login.Login_loadingText = "Loaded config";
					Login.Login_loadingPercent = 60;
					Client.titleLoadingStage = 80;
				}
			} else if (Client.titleLoadingStage == 80) {
				var0 = 0;
				if (UrlRequest.compass == null) {
					UrlRequest.compass = FillMode.SpriteBuffer_getSprite(WorldMapDecoration.archive8, Frames.spriteIds.compass, 0);
				} else {
					++var0;
				}

				if (FontName.redHintArrowSprite == null) {
					FontName.redHintArrowSprite = FillMode.SpriteBuffer_getSprite(WorldMapDecoration.archive8, Frames.spriteIds.field3794, 0);
				} else {
					++var0;
				}

				IndexedSprite[] var1;
				boolean var4;
				byte[] var5;
				if (class287.mapSceneSprites == null) {
					var2 = WorldMapDecoration.archive8;
					var3 = Frames.spriteIds.mapScenes;
					var5 = var2.takeFile(var3, 0);
					if (var5 == null) {
						var4 = false;
					} else {
						GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var5);
						var4 = true;
					}

					if (!var4) {
						var1 = null;
					} else {
						var1 = FileSystem.method3489();
					}

					class287.mapSceneSprites = var1;
				} else {
					++var0;
				}

				if (PlatformInfo.headIconPkSprites == null) {
					PlatformInfo.headIconPkSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.headIconsPk, 0);
				} else {
					++var0;
				}

				if (RouteStrategy.headIconPrayerSprites == null) {
					RouteStrategy.headIconPrayerSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.field3797, 0);
				} else {
					++var0;
				}

				if (GrandExchangeEvents.headIconHintSprites == null) {
					GrandExchangeEvents.headIconHintSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.field3798, 0);
				} else {
					++var0;
				}

				if (WorldMapLabelSize.mapMarkerSprites == null) {
					WorldMapLabelSize.mapMarkerSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.field3800, 0);
				} else {
					++var0;
				}

				if (class270.crossSprites == null) {
					class270.crossSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.field3804, 0);
				} else {
					++var0;
				}

				if (class42.mapDotSprites == null) {
					class42.mapDotSprites = PendingSpawn.SpriteBuffer_getSpriteArray(WorldMapDecoration.archive8, Frames.spriteIds.field3801, 0);
				} else {
					++var0;
				}

				if (WorldMapIcon_1.scrollBarSprites == null) {
					var2 = WorldMapDecoration.archive8;
					var3 = Frames.spriteIds.field3802;
					var5 = var2.takeFile(var3, 0);
					if (var5 == null) {
						var4 = false;
					} else {
						GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var5);
						var4 = true;
					}

					if (!var4) {
						var1 = null;
					} else {
						var1 = FileSystem.method3489();
					}

					WorldMapIcon_1.scrollBarSprites = var1;
				} else {
					++var0;
				}

				if (SecureRandomCallable.modIconSprites == null) {
					var2 = WorldMapDecoration.archive8;
					var3 = Frames.spriteIds.field3799;
					var5 = var2.takeFile(var3, 0);
					if (var5 == null) {
						var4 = false;
					} else {
						GrandExchangeOfferWorldComparator.SpriteBuffer_decode(var5);
						var4 = true;
					}

					if (!var4) {
						var1 = null;
					} else {
						var1 = FileSystem.method3489();
					}

					SecureRandomCallable.modIconSprites = var1;
				} else {
					++var0;
				}

				if (var0 < 11) {
					Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
					Login.Login_loadingPercent = 70;
				} else {
					AbstractFont.AbstractFont_modIconSprites = SecureRandomCallable.modIconSprites;
					FontName.redHintArrowSprite.normalize();
					int var18 = (int)(Math.random() * 21.0D) - 10;
					int var19 = (int)(Math.random() * 21.0D) - 10;
					var3 = (int)(Math.random() * 21.0D) - 10;
					var23 = (int)(Math.random() * 41.0D) - 20;
					class287.mapSceneSprites[0].shiftColors(var23 + var18, var19 + var23, var3 + var23);
					Login.Login_loadingText = "Loaded sprites";
					Login.Login_loadingPercent = 70;
					Client.titleLoadingStage = 90;
				}
			} else if (Client.titleLoadingStage == 90) {
				if (!WorldMapData_0.archive9.isFullyLoaded()) {
					Login.Login_loadingText = "Loading textures - " + "0%";
					Login.Login_loadingPercent = 90;
				} else {
					class216.textureProvider = new TextureProvider(WorldMapData_0.archive9, WorldMapDecoration.archive8, 20, 0.8D, Client.isLowDetail ? 64 : 128);
					Rasterizer3D.Rasterizer3D_setTextureLoader(class216.textureProvider);
					Rasterizer3D.Rasterizer3D_setBrightness(0.8D);
					Client.titleLoadingStage = 100;
				}
			} else if (Client.titleLoadingStage == 100) {
				var0 = class216.textureProvider.getLoadedPercentage();
				if (var0 < 100) {
					Login.Login_loadingText = "Loading textures - " + var0 + "%";
					Login.Login_loadingPercent = 90;
				} else {
					Login.Login_loadingText = "Loaded textures";
					Login.Login_loadingPercent = 90;
					Client.titleLoadingStage = 110;
				}
			} else if (Client.titleLoadingStage == 110) {
				ParamDefinition.mouseRecorder = new MouseRecorder();
				GameShell.taskHandler.newThreadTask(ParamDefinition.mouseRecorder, 10);
				Login.Login_loadingText = "Loaded input handler";
				Login.Login_loadingPercent = 92;
				Client.titleLoadingStage = 120;
			} else if (Client.titleLoadingStage == 120) {
				if (!FontName.archive10.tryLoadFileByNames("huffman", "")) {
					Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
					Login.Login_loadingPercent = 94;
				} else {
					Huffman var16 = new Huffman(FontName.archive10.takeFileByNames("huffman", ""));
					class210.huffman = var16;
					Login.Login_loadingText = "Loaded wordpack";
					Login.Login_loadingPercent = 94;
					Client.titleLoadingStage = 130;
				}
			} else if (Client.titleLoadingStage == 130) {
				if (!WorldMapData_0.archive3.isFullyLoaded()) {
					Login.Login_loadingText = "Loading interfaces - " + WorldMapData_0.archive3.loadPercent() * 4 / 5 + "%";
					Login.Login_loadingPercent = 96;
				} else if (!Message.archive12.isFullyLoaded()) {
					Login.Login_loadingText = "Loading interfaces - " + (80 + Message.archive12.loadPercent() / 6) + "%";
					Login.Login_loadingPercent = 96;
				} else if (!TextureProvider.archive13.isFullyLoaded()) {
					Login.Login_loadingText = "Loading interfaces - " + (96 + TextureProvider.archive13.loadPercent() / 50) + "%";
					Login.Login_loadingPercent = 96;
				} else {
					Login.Login_loadingText = "Loaded interfaces";
					Login.Login_loadingPercent = 98;
					Client.titleLoadingStage = 140;
				}
			} else if (Client.titleLoadingStage == 140) {
				Login.Login_loadingPercent = 100;
				if (!UrlRequest.archive19.tryLoadGroupByName(WorldMapCacheName.field294.name)) {
					Login.Login_loadingText = "Loading world map - " + UrlRequest.archive19.groupLoadPercentByName(WorldMapCacheName.field294.name) / 10 + "%";
				} else {
					if (GrandExchangeOfferUnitPriceComparator.worldMap == null) {
						GrandExchangeOfferUnitPriceComparator.worldMap = new WorldMap();
						GrandExchangeOfferUnitPriceComparator.worldMap.init(UrlRequest.archive19, WorldMapArea.archive18, WorldMapSection1.archive20, HealthBar.fontBold12, Client.fontsMap, class287.mapSceneSprites);
					}

					Login.Login_loadingText = "Loaded world map";
					Client.titleLoadingStage = 150;
				}
			} else if (Client.titleLoadingStage == 150) {
				WorldMapIcon_0.updateGameState(10);
			}
		}
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZI)V",
		garbageValue = "-281939606"
	)
	@Export("insertMenuItem")
	static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
		if (!Client.isMenuOpen) {
			if (Client.menuOptionsCount < 500) {
				Client.menuActions[Client.menuOptionsCount] = var0;
				Client.menuTargets[Client.menuOptionsCount] = var1;
				Client.menuOpcodes[Client.menuOptionsCount] = var2;
				Client.menuIdentifiers[Client.menuOptionsCount] = var3;
				Client.menuArguments1[Client.menuOptionsCount] = var4;
				Client.menuArguments2[Client.menuOptionsCount] = var5;
				Client.menuShiftClick[Client.menuOptionsCount] = var6;
				++Client.menuOptionsCount;
			}

		}
	}
}
