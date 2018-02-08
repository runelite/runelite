import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
public final class class293 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1046758425
   )
   public static int field3798;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;I)Lki;",
      garbageValue = "-1945518368"
   )
   public static SpritePixels method5499(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ScriptEvent.method1074(var0, var3, var4);
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         TotalQuantityComparator.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         SoundTask.minimapSprite = new SpritePixels(512, 512);
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
               class153.indexInterfaces = Player.openCacheIndex(0, false, true, true);
               BoundingBox2D.indexSoundEffects = Player.openCacheIndex(1, false, true, true);
               Frames.configsIndex = Player.openCacheIndex(2, true, false, true);
               class65.indexCache3 = Player.openCacheIndex(3, false, true, true);
               class62.indexCache4 = Player.openCacheIndex(4, false, true, true);
               Client.indexMaps = Player.openCacheIndex(5, true, true, true);
               class231.indexTrack1 = Player.openCacheIndex(6, true, true, true);
               class48.indexModels = Player.openCacheIndex(7, false, true, true);
               class37.indexSprites = Player.openCacheIndex(8, false, true, true);
               class153.indexTextures = Player.openCacheIndex(9, false, true, true);
               class65.indexCache10 = Player.openCacheIndex(10, false, true, true);
               class54.indexTrack2 = Player.openCacheIndex(11, false, true, true);
               class22.indexScripts = Player.openCacheIndex(12, false, true, true);
               class27.indexCache13 = Player.openCacheIndex(13, true, false, true);
               class27.vorbisIndex = Player.openCacheIndex(14, false, true, true);
               class186.indexCache15 = Player.openCacheIndex(15, false, true, true);
               class249.indexWorldMap = Player.openCacheIndex(16, false, true, true);
               class89.loadingText = "Connecting to update server";
               class89.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var28 = 0;
               var0 = var28 + class153.indexInterfaces.percentage() * 4 / 100;
               var0 += BoundingBox2D.indexSoundEffects.percentage() * 4 / 100;
               var0 += Frames.configsIndex.percentage() * 2 / 100;
               var0 += class65.indexCache3.percentage() * 2 / 100;
               var0 += class62.indexCache4.percentage() * 6 / 100;
               var0 += Client.indexMaps.percentage() * 4 / 100;
               var0 += class231.indexTrack1.percentage() * 2 / 100;
               var0 += class48.indexModels.percentage() * 58 / 100;
               var0 += class37.indexSprites.percentage() * 2 / 100;
               var0 += class153.indexTextures.percentage() * 2 / 100;
               var0 += class65.indexCache10.percentage() * 2 / 100;
               var0 += class54.indexTrack2.percentage() * 2 / 100;
               var0 += class22.indexScripts.percentage() * 2 / 100;
               var0 += class27.indexCache13.percentage() * 2 / 100;
               var0 += class27.vorbisIndex.percentage() * 2 / 100;
               var0 += class186.indexCache15.percentage() * 2 / 100;
               var0 += class249.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class89.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class89.loadingBarPercentage = 30;
               } else {
                  GrandExchangeOffer.method120(class153.indexInterfaces, "Animations");
                  GrandExchangeOffer.method120(BoundingBox2D.indexSoundEffects, "Skeletons");
                  GrandExchangeOffer.method120(class62.indexCache4, "Sound FX");
                  GrandExchangeOffer.method120(Client.indexMaps, "Maps");
                  GrandExchangeOffer.method120(class231.indexTrack1, "Music Tracks");
                  GrandExchangeOffer.method120(class48.indexModels, "Models");
                  GrandExchangeOffer.method120(class37.indexSprites, "Sprites");
                  GrandExchangeOffer.method120(class54.indexTrack2, "Music Jingles");
                  GrandExchangeOffer.method120(class27.vorbisIndex, "Music Samples");
                  GrandExchangeOffer.method120(class186.indexCache15, "Music Patches");
                  GrandExchangeOffer.method120(class249.indexWorldMap, "World Map");
                  class89.loadingText = "Loaded update list";
                  class89.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else {
               IndexData var24;
               IndexData var25;
               IndexData var26;
               if(Client.loadingStage == 45) {
                  class218.method4307(22050, !Client.lowMemory, 2);
                  class215 var31 = new class215();
                  var31.method4141(9, 128);
                  BoundingBox.soundSystem0 = class87.method1879(GameEngine.taskManager, 0, 22050);
                  BoundingBox.soundSystem0.method2293(var31);
                  var24 = class186.indexCache15;
                  var25 = class27.vorbisIndex;
                  var26 = class62.indexCache4;
                  class214.field2618 = var24;
                  class214.field2615 = var25;
                  class214.field2619 = var26;
                  class25.field356 = var31;
                  Enum.soundSystem1 = class87.method1879(GameEngine.taskManager, 1, 2048);
                  class33.field450 = new class101();
                  Enum.soundSystem1.method2293(class33.field450);
                  VarPlayerType.field3370 = new Resampler(22050, AbstractSoundSystem.sampleRate);
                  class89.loadingText = "Prepared sound engine";
                  class89.loadingBarPercentage = 35;
                  Client.loadingStage = 50;
                  BoundingBox.fonts = new Fonts(class37.indexSprites, class27.indexCache13);
               } else if(Client.loadingStage == 50) {
                  var0 = FontName.method5351().length;
                  Client.fontsMap = BoundingBox.fonts.createMap(FontName.method5351());
                  if(Client.fontsMap.size() < var0) {
                     class89.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                     class89.loadingBarPercentage = 40;
                  } else {
                     class2.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                     TextureProvider.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                     IndexDataBase.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                     ItemContainer.platformInfo = new MachineInfo(true);
                     class89.loadingText = "Loaded fonts";
                     class89.loadingBarPercentage = 40;
                     Client.loadingStage = 60;
                  }
               } else if(Client.loadingStage == 60) {
                  var0 = CombatInfo1.method1616(class65.indexCache10, class37.indexSprites);
                  var1 = Item.method1955();
                  if(var0 < var1) {
                     class89.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                     class89.loadingBarPercentage = 50;
                  } else {
                     class89.loadingText = "Loaded title screen";
                     class89.loadingBarPercentage = 50;
                     class87.setGameState(5);
                     Client.loadingStage = 70;
                  }
               } else if(Client.loadingStage == 70) {
                  if(!Frames.configsIndex.method4508()) {
                     class89.loadingText = "Loading config - " + Frames.configsIndex.loadPercent() + "%";
                     class89.loadingBarPercentage = 60;
                  } else {
                     IndexData var30 = Frames.configsIndex;
                     Overlay.overlay_ref = var30;
                     var24 = Frames.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var24;
                     Enum.method4880(Frames.configsIndex, class48.indexModels);
                     var25 = Frames.configsIndex;
                     var26 = class48.indexModels;
                     boolean var27 = Client.lowMemory;
                     ObjectComposition.objects_ref = var25;
                     ObjectComposition.field3518 = var26;
                     ObjectComposition.objectCompositionLowDetail = var27;
                     SoundTaskDataProvider.method739(Frames.configsIndex, class48.indexModels);
                     IndexDataBase.method4568(Frames.configsIndex);
                     IndexData var5 = Frames.configsIndex;
                     IndexData var6 = class48.indexModels;
                     boolean var7 = Client.isMembers;
                     Font var8 = class2.fontPlain11;
                     ItemComposition.item_ref = var5;
                     class150.ItemDefinition_modelIndexCache = var6;
                     class35.isMembersWorld = var7;
                     class235.field2949 = ItemComposition.item_ref.fileCount(10);
                     MouseRecorder.field793 = var8;
                     IndexData var9 = Frames.configsIndex;
                     IndexData var10 = class153.indexInterfaces;
                     IndexData var11 = BoundingBox2D.indexSoundEffects;
                     Sequence.seq_ref = var9;
                     Sequence.skel_ref = var10;
                     Sequence.skin_ref = var11;
                     BoundingBox3DDrawMode.method57(Frames.configsIndex, class48.indexModels);
                     IndexData var12 = Frames.configsIndex;
                     Varbit.varbit_ref = var12;
                     IndexData var13 = Frames.configsIndex;
                     TotalQuantityComparator.varplayer_ref = var13;
                     VarPlayerType.field3373 = TotalQuantityComparator.varplayer_ref.fileCount(16);
                     IndexData var14 = class65.indexCache3;
                     IndexData var15 = class48.indexModels;
                     IndexData var16 = class37.indexSprites;
                     IndexData var17 = class27.indexCache13;
                     class60.widgetIndex = var14;
                     Widget.field2745 = var15;
                     Widget.field2746 = var16;
                     Widget.field2747 = var17;
                     ScriptState.widgets = new Widget[class60.widgetIndex.size()][];
                     GrandExchangeOffer.validInterfaces = new boolean[class60.widgetIndex.size()];
                     class236.method4476(Frames.configsIndex);
                     IndexData var18 = Frames.configsIndex;
                     Enum.EnumDefinition_indexCache = var18;
                     DState.method3489(Frames.configsIndex);
                     IndexData var19 = Frames.configsIndex;
                     class255.field3402 = var19;
                     IndexData var20 = Frames.configsIndex;
                     class262.field3468 = var20;
                     class34.chatMessages = new Varcs();
                     BoundingBox3DDrawMode.method55(Frames.configsIndex, class37.indexSprites, class27.indexCache13);
                     IndexData var21 = Frames.configsIndex;
                     IndexData var22 = class37.indexSprites;
                     CombatInfo2.field3447 = var21;
                     CombatInfo2.field3443 = var22;
                     class54.method750(Frames.configsIndex, class37.indexSprites);
                     class89.loadingText = "Loaded config";
                     class89.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  if(GameEngine.compass == null) {
                     GameEngine.compass = method5499(class37.indexSprites, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class27.mapedge == null) {
                     class27.mapedge = method5499(class37.indexSprites, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class89.mapscene == null) {
                     class89.mapscene = class233.getIndexedSprites(class37.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(Client.headIconsPk == null) {
                     Client.headIconsPk = class36.getSprites(class37.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(ItemContainer.headIconsPrayer == null) {
                     ItemContainer.headIconsPrayer = class36.getSprites(class37.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class111.headIconsHint == null) {
                     class111.headIconsHint = class36.getSprites(class37.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(ScriptState.mapMarkers == null) {
                     ScriptState.mapMarkers = class36.getSprites(class37.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(Enum.crossSprites == null) {
                     Enum.crossSprites = class36.getSprites(class37.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(WidgetNode.mapDots == null) {
                     WidgetNode.mapDots = class36.getSprites(class37.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class34.scrollbarSprites == null) {
                     class34.scrollbarSprites = class233.getIndexedSprites(class37.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(FriendManager.modIconSprites == null) {
                     FriendManager.modIconSprites = class233.getIndexedSprites(class37.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class89.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class89.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = FriendManager.modIconSprites;
                     class27.mapedge.method5686();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class89.mapscene[0].method5652(var4 + var1, var4 + var2, var4 + var3);
                     class89.loadingText = "Loaded sprites";
                     class89.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!class153.indexTextures.method4508()) {
                     class89.loadingText = "Loading textures - " + "0%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     FileOnDisk.field1471 = new TextureProvider(class153.indexTextures, class37.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2821(FileOnDisk.field1471);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = FileOnDisk.field1471.method2595();
                  if(var0 < 100) {
                     class89.loadingText = "Loading textures - " + var0 + "%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     class89.loadingText = "Loaded textures";
                     class89.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  class41.mouseRecorder = new MouseRecorder();
                  GameEngine.taskManager.createRunnable(class41.mouseRecorder, 10);
                  class89.loadingText = "Loaded input handler";
                  class89.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!class65.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class89.loadingText = "Loading wordpack - " + 0 + "%";
                     class89.loadingBarPercentage = 94;
                  } else {
                     Huffman var29 = new Huffman(class65.indexCache10.takeRecordByNames("huffman", ""));
                     class175.method3422(var29);
                     class89.loadingText = "Loaded wordpack";
                     class89.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!class65.indexCache3.method4508()) {
                     class89.loadingText = "Loading interfaces - " + class65.indexCache3.loadPercent() * 4 / 5 + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class22.indexScripts.method4508()) {
                     class89.loadingText = "Loading interfaces - " + (80 + class22.indexScripts.loadPercent() / 6) + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class27.indexCache13.method4508()) {
                     class89.loadingText = "Loading interfaces - " + (96 + class27.indexCache13.loadPercent() / 50) + "%";
                     class89.loadingBarPercentage = 96;
                  } else {
                     class89.loadingText = "Loaded interfaces";
                     class89.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class89.loadingBarPercentage = 100;
                  if(!class249.indexWorldMap.tryLoadArchiveByName(class40.field521.field515)) {
                     class89.loadingText = "Loading world map - " + class249.indexWorldMap.archiveLoadPercentByName(class40.field521.field515) / 10 + "%";
                  } else {
                     if(class175.renderOverview == null) {
                        class175.renderOverview = new RenderOverview();
                        class175.renderOverview.method5811(class249.indexWorldMap, IndexDataBase.fontBold12, Client.fontsMap, class89.mapscene);
                     }

                     var0 = class175.renderOverview.method5812();
                     if(var0 < 100) {
                        class89.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class89.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class87.setGameState(10);
               }
            }
         } else {
            int[] var23 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var23[var1] = var4 * var3 >> 16;
            }

            Region.method3041(var23, 500, 800, 512, 334);
            class89.loadingText = "Prepared visibility map";
            class89.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
