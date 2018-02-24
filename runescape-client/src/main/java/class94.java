import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class94 {
   @ObfuscatedName("b")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lha;"
   )
   static final IterableDualNodeQueue field1397;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -189843797
   )
   static int field1400;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1397 = new IterableDualNodeQueue();
      field1400 = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   static void method1984() {
      class92.playerIndexesCount = 0;

      for(int var0 = 0; var0 < 2048; ++var0) {
         class92.field1374[var0] = null;
         class92.field1378[var0] = 1;
      }

   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1600937158"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         GameObject.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class131.minimapSprite = new SpritePixels(512, 512);
         class89.loadingText = "Starting game engine...";
         class89.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               Client.indexInterfaces = class20.openCacheIndex(0, false, true, true);
               class155.indexSoundEffects = class20.openCacheIndex(1, false, true, true);
               class109.configsIndex = class20.openCacheIndex(2, true, false, true);
               GameCanvas.indexCache3 = class20.openCacheIndex(3, false, true, true);
               class54.indexCache4 = class20.openCacheIndex(4, false, true, true);
               Script.indexMaps = class20.openCacheIndex(5, true, true, true);
               class155.indexTrack1 = class20.openCacheIndex(6, true, true, true);
               DynamicObject.indexModels = class20.openCacheIndex(7, false, true, true);
               MessageNode.indexSprites = class20.openCacheIndex(8, false, true, true);
               class63.indexTextures = class20.openCacheIndex(9, false, true, true);
               class85.indexCache10 = class20.openCacheIndex(10, false, true, true);
               GrandExchangeOffer.indexTrack2 = class20.openCacheIndex(11, false, true, true);
               class80.indexScripts = class20.openCacheIndex(12, false, true, true);
               class2.indexCache13 = class20.openCacheIndex(13, true, false, true);
               class194.vorbisIndex = class20.openCacheIndex(14, false, true, true);
               class27.indexCache15 = class20.openCacheIndex(15, false, true, true);
               class36.indexWorldMap = class20.openCacheIndex(16, false, true, true);
               class89.loadingText = "Connecting to update server";
               class89.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var26 = 0;
               var0 = var26 + Client.indexInterfaces.percentage() * 4 / 100;
               var0 += class155.indexSoundEffects.percentage() * 4 / 100;
               var0 += class109.configsIndex.percentage() * 2 / 100;
               var0 += GameCanvas.indexCache3.percentage() * 2 / 100;
               var0 += class54.indexCache4.percentage() * 6 / 100;
               var0 += Script.indexMaps.percentage() * 4 / 100;
               var0 += class155.indexTrack1.percentage() * 2 / 100;
               var0 += DynamicObject.indexModels.percentage() * 58 / 100;
               var0 += MessageNode.indexSprites.percentage() * 2 / 100;
               var0 += class63.indexTextures.percentage() * 2 / 100;
               var0 += class85.indexCache10.percentage() * 2 / 100;
               var0 += GrandExchangeOffer.indexTrack2.percentage() * 2 / 100;
               var0 += class80.indexScripts.percentage() * 2 / 100;
               var0 += class2.indexCache13.percentage() * 2 / 100;
               var0 += class194.vorbisIndex.percentage() * 2 / 100;
               var0 += class27.indexCache15.percentage() * 2 / 100;
               var0 += class36.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class89.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class89.loadingBarPercentage = 30;
               } else {
                  Huffman.method3462(Client.indexInterfaces, "Animations");
                  Huffman.method3462(class155.indexSoundEffects, "Skeletons");
                  Huffman.method3462(class54.indexCache4, "Sound FX");
                  Huffman.method3462(Script.indexMaps, "Maps");
                  Huffman.method3462(class155.indexTrack1, "Music Tracks");
                  Huffman.method3462(DynamicObject.indexModels, "Models");
                  Huffman.method3462(MessageNode.indexSprites, "Sprites");
                  Huffman.method3462(GrandExchangeOffer.indexTrack2, "Music Jingles");
                  Huffman.method3462(class194.vorbisIndex, "Music Samples");
                  Huffman.method3462(class27.indexCache15, "Music Patches");
                  Huffman.method3462(class36.indexWorldMap, "World Map");
                  class89.loadingText = "Loaded update list";
                  class89.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else {
               IndexData var22;
               IndexData var23;
               IndexData var24;
               if(Client.loadingStage == 45) {
                  class235.method4418(22050, !Client.lowMemory, 2);
                  class224 var29 = new class224();
                  var29.method4142(9, 128);
                  WorldMapData.soundSystem0 = DynamicObject.method2015(GameEngine.taskManager, 0, 22050);
                  WorldMapData.soundSystem0.method2202(var29);
                  var22 = class27.indexCache15;
                  var23 = class194.vorbisIndex;
                  var24 = class54.indexCache4;
                  class223.field2644 = var22;
                  GameCanvas.field601 = var23;
                  Item.field1362 = var24;
                  class155.field2105 = var29;
                  class87.soundSystem1 = DynamicObject.method2015(GameEngine.taskManager, 1, 2048);
                  KeyFocusListener.field583 = new class99();
                  class87.soundSystem1.method2202(KeyFocusListener.field583);
                  class197.field2565 = new Resampler(22050, AbstractSoundSystem.sampleRate);
                  class89.loadingText = "Prepared sound engine";
                  class89.loadingBarPercentage = 35;
                  Client.loadingStage = 50;
                  class63.fonts = new Fonts(MessageNode.indexSprites, class2.indexCache13);
               } else if(Client.loadingStage == 50) {
                  var0 = FontName.method5426().length;
                  Client.fontsMap = class63.fonts.createMap(FontName.method5426());
                  if(Client.fontsMap.size() < var0) {
                     class89.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                     class89.loadingBarPercentage = 40;
                  } else {
                     class259.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                     ClanMemberManager.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                     class153.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                     class63.platformInfo = new MachineInfo(true);
                     class89.loadingText = "Loaded fonts";
                     class89.loadingBarPercentage = 40;
                     Client.loadingStage = 60;
                  }
               } else if(Client.loadingStage == 60) {
                  var22 = class85.indexCache10;
                  var23 = MessageNode.indexSprites;
                  var3 = 0;
                  if(var22.tryLoadRecordByNames("title.jpg", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("logo", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("titlebox", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("titlebutton", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("runes", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("title_mute", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("options_radio_buttons,0", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("options_radio_buttons,2", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("options_radio_buttons,4", "")) {
                     ++var3;
                  }

                  if(var23.tryLoadRecordByNames("options_radio_buttons,6", "")) {
                     ++var3;
                  }

                  var23.tryLoadRecordByNames("sl_back", "");
                  var23.tryLoadRecordByNames("sl_flags", "");
                  var23.tryLoadRecordByNames("sl_arrows", "");
                  var23.tryLoadRecordByNames("sl_stars", "");
                  var23.tryLoadRecordByNames("sl_button", "");
                  var4 = class154.method3148();
                  if(var3 < var4) {
                     class89.loadingText = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class89.loadingBarPercentage = 50;
                  } else {
                     class89.loadingText = "Loaded title screen";
                     class89.loadingBarPercentage = 50;
                     WorldMapType1.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!class109.configsIndex.method4569()) {
                     class89.loadingText = "Loading config - " + class109.configsIndex.loadPercent() + "%";
                     class89.loadingBarPercentage = 60;
                  } else {
                     IndexData var28 = class109.configsIndex;
                     Overlay.overlay_ref = var28;
                     var22 = class109.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var22;
                     var23 = class109.configsIndex;
                     var24 = DynamicObject.indexModels;
                     KitDefinition.identKit_ref = var23;
                     class166.field2167 = var24;
                     KitDefinition.field3443 = KitDefinition.identKit_ref.fileCount(3);
                     IndexData var25 = class109.configsIndex;
                     IndexData var5 = DynamicObject.indexModels;
                     boolean var6 = Client.lowMemory;
                     SoundTask.objects_ref = var25;
                     class154.field2096 = var5;
                     ObjectComposition.objectCompositionLowDetail = var6;
                     SoundTask.method2273(class109.configsIndex, DynamicObject.indexModels);
                     Frames.method3055(class109.configsIndex);
                     IndexData var7 = class109.configsIndex;
                     IndexData var8 = DynamicObject.indexModels;
                     boolean var9 = Client.isMembers;
                     Font var10 = class259.fontPlain11;
                     ItemComposition.item_ref = var7;
                     class18.ItemDefinition_modelIndexCache = var8;
                     ItemComposition.isMembersWorld = var9;
                     FriendManager.field1197 = ItemComposition.item_ref.fileCount(10);
                     GameEngine.field657 = var10;
                     IndexData var11 = class109.configsIndex;
                     IndexData var12 = Client.indexInterfaces;
                     IndexData var13 = class155.indexSoundEffects;
                     Sequence.seq_ref = var11;
                     Sequence.skel_ref = var12;
                     Sequence.skin_ref = var13;
                     Item.method1919(class109.configsIndex, DynamicObject.indexModels);
                     IndexData var14 = class109.configsIndex;
                     UnitPriceComparator.varbit_ref = var14;
                     class43.method644(class109.configsIndex);
                     class31.method301(GameCanvas.indexCache3, DynamicObject.indexModels, MessageNode.indexSprites, class2.indexCache13);
                     IndexData var15 = class109.configsIndex;
                     InvType.field3384 = var15;
                     NetWriter.method2062(class109.configsIndex);
                     class89.method1888(class109.configsIndex);
                     GrandExchangeOffer.method110(class109.configsIndex);
                     class29.method269(class109.configsIndex);
                     class60.chatMessages = new Varcs();
                     IndexData var16 = class109.configsIndex;
                     IndexData var17 = MessageNode.indexSprites;
                     IndexData var18 = class2.indexCache13;
                     class274.field3515 = var16;
                     class274.field3501 = var17;
                     class274.field3497 = var18;
                     IndexData var19 = class109.configsIndex;
                     IndexData var20 = MessageNode.indexSprites;
                     CombatInfo2.field3468 = var19;
                     CombatInfo2.field3454 = var20;
                     GameSocket.method3377(class109.configsIndex, MessageNode.indexSprites);
                     class89.loadingText = "Loaded config";
                     class89.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  if(UnitPriceComparator.compass == null) {
                     UnitPriceComparator.compass = class243.method4505(MessageNode.indexSprites, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class37.mapedge == null) {
                     class37.mapedge = class243.method4505(MessageNode.indexSprites, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class2.mapscene == null) {
                     class2.mapscene = DState.getIndexedSprites(MessageNode.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(WidgetNode.headIconsPk == null) {
                     WidgetNode.headIconsPk = ObjectComposition.getSprites(MessageNode.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class162.headIconsPrayer == null) {
                     class162.headIconsPrayer = ObjectComposition.getSprites(MessageNode.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(FaceNormal.headIconsHint == null) {
                     FaceNormal.headIconsHint = ObjectComposition.getSprites(MessageNode.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class35.mapMarkers == null) {
                     class35.mapMarkers = ObjectComposition.getSprites(MessageNode.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class25.crossSprites == null) {
                     class25.crossSprites = ObjectComposition.getSprites(MessageNode.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class263.mapDots == null) {
                     class263.mapDots = ObjectComposition.getSprites(MessageNode.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(CacheFile.scrollbarSprites == null) {
                     CacheFile.scrollbarSprites = DState.getIndexedSprites(MessageNode.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class202.modIconSprites == null) {
                     class202.modIconSprites = DState.getIndexedSprites(MessageNode.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class89.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class89.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = class202.modIconSprites;
                     class37.mapedge.method5823();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class2.mapscene[0].method5778(var1 + var4, var4 + var2, var4 + var3);
                     class89.loadingText = "Loaded sprites";
                     class89.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!class63.indexTextures.method4569()) {
                     class89.loadingText = "Loading textures - " + "0%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     class54.field607 = new TextureProvider(class63.indexTextures, MessageNode.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2809(class54.field607);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = class54.field607.method2574();
                  if(var0 < 100) {
                     class89.loadingText = "Loading textures - " + var0 + "%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     class89.loadingText = "Loaded textures";
                     class89.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  class31.mouseRecorder = new MouseRecorder();
                  GameEngine.taskManager.createRunnable(class31.mouseRecorder, 10);
                  class89.loadingText = "Loaded input handler";
                  class89.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!class85.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class89.loadingText = "Loading wordpack - " + 0 + "%";
                     class89.loadingBarPercentage = 94;
                  } else {
                     Huffman var27 = new Huffman(class85.indexCache10.takeRecordByNames("huffman", ""));
                     class27.method238(var27);
                     class89.loadingText = "Loaded wordpack";
                     class89.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!GameCanvas.indexCache3.method4569()) {
                     class89.loadingText = "Loading interfaces - " + GameCanvas.indexCache3.loadPercent() * 4 / 5 + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class80.indexScripts.method4569()) {
                     class89.loadingText = "Loading interfaces - " + (80 + class80.indexScripts.loadPercent() / 6) + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class2.indexCache13.method4569()) {
                     class89.loadingText = "Loading interfaces - " + (96 + class2.indexCache13.loadPercent() / 50) + "%";
                     class89.loadingBarPercentage = 96;
                  } else {
                     class89.loadingText = "Loaded interfaces";
                     class89.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class89.loadingBarPercentage = 100;
                  if(!class36.indexWorldMap.tryLoadArchiveByName(class40.field497.field502)) {
                     class89.loadingText = "Loading world map - " + class36.indexWorldMap.archiveLoadPercentByName(class40.field497.field502) / 10 + "%";
                  } else {
                     if(BoundingBox3D.renderOverview == null) {
                        BoundingBox3D.renderOverview = new RenderOverview();
                        BoundingBox3D.renderOverview.method5963(class36.indexWorldMap, class153.fontBold12, Client.fontsMap, class2.mapscene);
                     }

                     var0 = BoundingBox3D.renderOverview.method5964();
                     if(var0 < 100) {
                        class89.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class89.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  WorldMapType1.setGameState(10);
               }
            }
         } else {
            int[] var21 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var21[var1] = var4 * var3 >> 16;
            }

            Region.buildVisibilityMaps(var21, 500, 800, 512, 334);
            class89.loadingText = "Prepared visibility map";
            class89.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
