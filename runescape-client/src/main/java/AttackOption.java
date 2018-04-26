import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("AttackOption")
public enum AttackOption implements Enumerated {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("AttackOption_dependsOnCombatLevels")
   AttackOption_dependsOnCombatLevels(0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("AttackOption_alwaysRightClick")
   AttackOption_alwaysRightClick(1),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("AttackOption_leftClickWhereAvailable")
   AttackOption_leftClickWhereAvailable(2),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   @Export("AttackOption_hidden")
   AttackOption_hidden(3);

   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1831620267
   )
   public static int field1334;
   @ObfuscatedName("gu")
   @ObfuscatedGetter(
      intValue = -194028423
   )
   static int field1333;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 999457757
   )
   @Export("id")
   final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "19795"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         GameSocket.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class44.minimapSprite = new SpritePixels(512, 512);
         class90.loadingText = "Starting game engine...";
         class90.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               MouseInput.indexInterfaces = class25.openCacheIndex(0, false, true, true);
               CombatInfoListHolder.indexSoundEffects = class25.openCacheIndex(1, false, true, true);
               Client.configsIndex = class25.openCacheIndex(2, true, false, true);
               class7.indexCache3 = class25.openCacheIndex(3, false, true, true);
               class27.indexCache4 = class25.openCacheIndex(4, false, true, true);
               SoundTaskDataProvider.indexMaps = class25.openCacheIndex(5, true, true, true);
               class7.indexTrack1 = class25.openCacheIndex(6, true, true, true);
               class28.indexModels = class25.openCacheIndex(7, false, true, true);
               UnitPriceComparator.indexSprites = class25.openCacheIndex(8, false, true, true);
               WorldMapRectangle.indexTextures = class25.openCacheIndex(9, false, true, true);
               Occluder.indexCache10 = class25.openCacheIndex(10, false, true, true);
               class190.indexTrack2 = class25.openCacheIndex(11, false, true, true);
               MapIcon.indexScripts = class25.openCacheIndex(12, false, true, true);
               class36.indexCache13 = class25.openCacheIndex(13, true, false, true);
               class228.vorbisIndex = class25.openCacheIndex(14, false, true, true);
               KeyFocusListener.indexCache15 = class25.openCacheIndex(15, false, true, true);
               MapLabel.indexWorldMap = class25.openCacheIndex(16, true, true, true);
               class90.loadingText = "Connecting to update server";
               class90.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var16 = 0;
               var0 = var16 + MouseInput.indexInterfaces.percentage() * 4 / 100;
               var0 += CombatInfoListHolder.indexSoundEffects.percentage() * 4 / 100;
               var0 += Client.configsIndex.percentage() * 2 / 100;
               var0 += class7.indexCache3.percentage() * 2 / 100;
               var0 += class27.indexCache4.percentage() * 6 / 100;
               var0 += SoundTaskDataProvider.indexMaps.percentage() * 4 / 100;
               var0 += class7.indexTrack1.percentage() * 2 / 100;
               var0 += class28.indexModels.percentage() * 58 / 100;
               var0 += UnitPriceComparator.indexSprites.percentage() * 2 / 100;
               var0 += WorldMapRectangle.indexTextures.percentage() * 2 / 100;
               var0 += Occluder.indexCache10.percentage() * 2 / 100;
               var0 += class190.indexTrack2.percentage() * 2 / 100;
               var0 += MapIcon.indexScripts.percentage() * 2 / 100;
               var0 += class36.indexCache13.percentage() * 2 / 100;
               var0 += class228.vorbisIndex.percentage() * 2 / 100;
               var0 += KeyFocusListener.indexCache15.percentage() * 2 / 100;
               var0 += MapLabel.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class90.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class90.loadingBarPercentage = 30;
               } else {
                  WorldComparator.method62(MouseInput.indexInterfaces, "Animations");
                  WorldComparator.method62(CombatInfoListHolder.indexSoundEffects, "Skeletons");
                  WorldComparator.method62(class27.indexCache4, "Sound FX");
                  WorldComparator.method62(SoundTaskDataProvider.indexMaps, "Maps");
                  WorldComparator.method62(class7.indexTrack1, "Music Tracks");
                  WorldComparator.method62(class28.indexModels, "Models");
                  WorldComparator.method62(UnitPriceComparator.indexSprites, "Sprites");
                  WorldComparator.method62(class190.indexTrack2, "Music Jingles");
                  WorldComparator.method62(class228.vorbisIndex, "Music Samples");
                  WorldComparator.method62(KeyFocusListener.indexCache15, "Music Patches");
                  WorldComparator.method62(MapLabel.indexWorldMap, "World Map");
                  class90.loadingText = "Loaded update list";
                  class90.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else if(Client.loadingStage == 45) {
               class62.method1120(22050, !Client.lowMemory, 2);
               class230 var20 = new class230();
               var20.method4243(9, 128);
               Resampler.soundSystem0 = class246.method4606(GameEngine.taskManager, 0, 22050);
               Resampler.soundSystem0.method2297(var20);
               ItemLayer.method2689(KeyFocusListener.indexCache15, class228.vorbisIndex, class27.indexCache4, var20);
               MapIconReference.soundSystem1 = class246.method4606(GameEngine.taskManager, 1, 2048);
               BoundingBox2D.field238 = new class100();
               MapIconReference.soundSystem1.method2297(BoundingBox2D.field238);
               class18.field320 = new Resampler(22050, AbstractSoundSystem.sampleRate);
               class90.loadingText = "Prepared sound engine";
               class90.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               GameCanvas.fonts = new Fonts(UnitPriceComparator.indexSprites, class36.indexCache13);
            } else if(Client.loadingStage == 50) {
               FontName[] var19 = new FontName[]{FontName.FontName_plain11, FontName.field3885, FontName.field3886, FontName.field3882, FontName.FontName_bold12, FontName.FontName_plain12};
               var1 = var19.length;
               Fonts var21 = GameCanvas.fonts;
               FontName[] var22 = new FontName[]{FontName.FontName_plain11, FontName.field3885, FontName.field3886, FontName.field3882, FontName.FontName_bold12, FontName.FontName_plain12};
               Client.fontsMap = var21.createMap(var22);
               if(Client.fontsMap.size() < var1) {
                  class90.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var1 + "%";
                  class90.loadingBarPercentage = 40;
               } else {
                  UnitPriceComparator.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  class249.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  class22.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  class153.platformInfo = new MachineInfo(true);
                  class90.loadingText = "Loaded fonts";
                  class90.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else {
               IndexData var10;
               IndexData var23;
               if(Client.loadingStage == 60) {
                  var23 = Occluder.indexCache10;
                  var10 = UnitPriceComparator.indexSprites;
                  var3 = 0;
                  if(var23.tryLoadRecordByNames("title.jpg", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("logo", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("titlebox", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("titlebutton", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("runes", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("title_mute", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                     ++var3;
                  }

                  if(var10.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                     ++var3;
                  }

                  var10.tryLoadRecordByNames("sl_back", "");
                  var10.tryLoadRecordByNames("sl_flags", "");
                  var10.tryLoadRecordByNames("sl_arrows", "");
                  var10.tryLoadRecordByNames("sl_stars", "");
                  var10.tryLoadRecordByNames("sl_button", "");
                  byte var15 = 11;
                  if(var3 < var15) {
                     class90.loadingText = "Loading title screen - " + var3 * 100 / var15 + "%";
                     class90.loadingBarPercentage = 50;
                  } else {
                     class90.loadingText = "Loaded title screen";
                     class90.loadingBarPercentage = 50;
                     class55.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!Client.configsIndex.method4666()) {
                     class90.loadingText = "Loading config - " + Client.configsIndex.loadPercent() + "%";
                     class90.loadingBarPercentage = 60;
                  } else {
                     Player.method1255(Client.configsIndex);
                     PendingSpawn.method1700(Client.configsIndex);
                     IndexData var18 = Client.configsIndex;
                     var23 = class28.indexModels;
                     KitDefinition.identKit_ref = var18;
                     KitDefinition.field3509 = var23;
                     KitDefinition.field3514 = KitDefinition.identKit_ref.fileCount(3);
                     var10 = Client.configsIndex;
                     IndexData var11 = class28.indexModels;
                     boolean var14 = Client.lowMemory;
                     ObjectComposition.objects_ref = var10;
                     ObjectComposition.field3592 = var11;
                     ObjectComposition.objectCompositionLowDetail = var14;
                     IndexData var13 = Client.configsIndex;
                     IndexData var6 = class28.indexModels;
                     class191.NpcDefinition_indexCache = var13;
                     NPCComposition.NpcDefinition_modelIndexCache = var6;
                     BaseVarType.method10(Client.configsIndex);
                     NPC.method1950(Client.configsIndex, class28.indexModels, Client.isMembers, UnitPriceComparator.fontPlain11);
                     class253.method4620(Client.configsIndex, MouseInput.indexInterfaces, CombatInfoListHolder.indexSoundEffects);
                     class45.method679(Client.configsIndex, class28.indexModels);
                     MessageNode.method1197(Client.configsIndex);
                     GraphicsObject.method1922(Client.configsIndex);
                     NetWriter.method2161(class7.indexCache3, class28.indexModels, UnitPriceComparator.indexSprites, class36.indexCache13);
                     IndexData var7 = Client.configsIndex;
                     InvType.field3441 = var7;
                     CollisionData.method3492(Client.configsIndex);
                     InvType.method4838(Client.configsIndex);
                     IndexData var8 = Client.configsIndex;
                     VarCString.field3481 = var8;
                     ScriptEvent.method1159(Client.configsIndex);
                     class160.varcs = new Varcs();
                     MouseInput.method1090(Client.configsIndex, UnitPriceComparator.indexSprites, class36.indexCache13);
                     CombatInfoListHolder.method1937(Client.configsIndex, UnitPriceComparator.indexSprites);
                     TextureProvider.method2657(Client.configsIndex, UnitPriceComparator.indexSprites);
                     class90.loadingText = "Loaded config";
                     class90.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var12;
                  if(WorldMapManager.compass == null) {
                     var10 = UnitPriceComparator.indexSprites;
                     var3 = var10.getFile("compass");
                     var4 = var10.getChild(var3, "");
                     var12 = AbstractByteBuffer.method3836(var10, var3, var4);
                     WorldMapManager.compass = var12;
                  } else {
                     ++var0;
                  }

                  if(class230.mapedge == null) {
                     var10 = UnitPriceComparator.indexSprites;
                     var3 = var10.getFile("mapedge");
                     var4 = var10.getChild(var3, "");
                     var12 = AbstractByteBuffer.method3836(var10, var3, var4);
                     class230.mapedge = var12;
                  } else {
                     ++var0;
                  }

                  if(class2.mapscene == null) {
                     class2.mapscene = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class132.headIconsPk == null) {
                     class132.headIconsPk = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(MouseRecorder.headIconsPrayer == null) {
                     MouseRecorder.headIconsPrayer = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(DecorativeObject.headIconsHint == null) {
                     DecorativeObject.headIconsHint = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class66.mapMarkers == null) {
                     class66.mapMarkers = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(ScriptState.crossSprites == null) {
                     ScriptState.crossSprites = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class3.mapDots == null) {
                     class3.mapDots = WorldMapType1.getSprites(UnitPriceComparator.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class7.scrollbarSprites == null) {
                     class7.scrollbarSprites = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class22.modIconSprites == null) {
                     class22.modIconSprites = class243.getIndexedSprites(UnitPriceComparator.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class90.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = class22.modIconSprites;
                     class230.mapedge.method5917();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class2.mapscene[0].method5888(var1 + var4, var4 + var2, var3 + var4);
                     class90.loadingText = "Loaded sprites";
                     class90.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!WorldMapRectangle.indexTextures.method4666()) {
                     class90.loadingText = "Loading textures - " + "0%";
                     class90.loadingBarPercentage = 90;
                  } else {
                     BaseVarType.field23 = new TextureProvider(WorldMapRectangle.indexTextures, UnitPriceComparator.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2933(BaseVarType.field23);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = BaseVarType.field23.method2658();
                  if(var0 < 100) {
                     class90.loadingText = "Loading textures - " + var0 + "%";
                     class90.loadingBarPercentage = 90;
                  } else {
                     class90.loadingText = "Loaded textures";
                     class90.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  MapLabel.mouseRecorder = new MouseRecorder();
                  GameEngine.taskManager.createRunnable(MapLabel.mouseRecorder, 10);
                  class90.loadingText = "Loaded input handler";
                  class90.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!Occluder.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class90.loadingText = "Loading wordpack - " + 0 + "%";
                     class90.loadingBarPercentage = 94;
                  } else {
                     Huffman var17 = new Huffman(Occluder.indexCache10.takeRecordByNames("huffman", ""));
                     MouseRecorder.method1165(var17);
                     class90.loadingText = "Loaded wordpack";
                     class90.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!class7.indexCache3.method4666()) {
                     class90.loadingText = "Loading interfaces - " + class7.indexCache3.loadPercent() * 4 / 5 + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!MapIcon.indexScripts.method4666()) {
                     class90.loadingText = "Loading interfaces - " + (80 + MapIcon.indexScripts.loadPercent() / 6) + "%";
                     class90.loadingBarPercentage = 96;
                  } else if(!class36.indexCache13.method4666()) {
                     class90.loadingText = "Loading interfaces - " + (96 + class36.indexCache13.loadPercent() / 50) + "%";
                     class90.loadingBarPercentage = 96;
                  } else {
                     class90.loadingText = "Loaded interfaces";
                     class90.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class90.loadingBarPercentage = 100;
                  if(!MapLabel.indexWorldMap.tryLoadArchiveByName(MapCacheArchiveNames.DETAILS.name)) {
                     class90.loadingText = "Loading world map - " + MapLabel.indexWorldMap.archiveLoadPercentByName(MapCacheArchiveNames.DETAILS.name) / 10 + "%";
                  } else {
                     if(class196.renderOverview == null) {
                        class196.renderOverview = new RenderOverview();
                        class196.renderOverview.method6065(MapLabel.indexWorldMap, class22.fontBold12, Client.fontsMap, class2.mapscene);
                     }

                     var0 = class196.renderOverview.method6116();
                     if(var0 < 100) {
                        class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class90.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class55.setGameState(10);
               }
            }
         } else {
            int[] var9 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var9[var1] = var4 * var3 >> 16;
            }

            Region.buildVisibilityMaps(var9, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
