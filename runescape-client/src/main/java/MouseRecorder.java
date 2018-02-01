import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("mouseWheel")
   static class158 mouseWheel;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   static IndexedSprite field761;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lio;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("dq")
   @ObfuscatedGetter(
      intValue = 1282924127
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("p")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("i")
   @Export("lock")
   Object lock;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1356559085
   )
   @Export("index")
   int index;
   @ObfuscatedName("s")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("j")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; class1.method3(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "561692073"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class48.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class29.minimapSprite = new SpritePixels(512, 512);
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
               GameCanvas.indexInterfaces = class43.openCacheIndex(0, false, true, true);
               GroundObject.indexSoundEffects = class43.openCacheIndex(1, false, true, true);
               class293.configsIndex = class43.openCacheIndex(2, true, false, true);
               AttackOption.indexCache3 = class43.openCacheIndex(3, false, true, true);
               class23.indexCache4 = class43.openCacheIndex(4, false, true, true);
               FontName.indexMaps = class43.openCacheIndex(5, true, true, true);
               class148.indexTrack1 = class43.openCacheIndex(6, true, true, true);
               indexModels = class43.openCacheIndex(7, false, true, true);
               Tile.indexSprites = class43.openCacheIndex(8, false, true, true);
               BoundingBox3D.indexTextures = class43.openCacheIndex(9, false, true, true);
               Client.indexCache10 = class43.openCacheIndex(10, false, true, true);
               class70.indexTrack2 = class43.openCacheIndex(11, false, true, true);
               class28.indexScripts = class43.openCacheIndex(12, false, true, true);
               class304.indexCache13 = class43.openCacheIndex(13, true, false, true);
               class45.vorbisIndex = class43.openCacheIndex(14, false, true, true);
               class265.indexCache15 = class43.openCacheIndex(15, false, true, true);
               class283.indexWorldMap = class43.openCacheIndex(16, false, true, true);
               class89.loadingText = "Connecting to update server";
               class89.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var25 = 0;
               var0 = var25 + GameCanvas.indexInterfaces.percentage() * 4 / 100;
               var0 += GroundObject.indexSoundEffects.percentage() * 4 / 100;
               var0 += class293.configsIndex.percentage() * 2 / 100;
               var0 += AttackOption.indexCache3.percentage() * 2 / 100;
               var0 += class23.indexCache4.percentage() * 6 / 100;
               var0 += FontName.indexMaps.percentage() * 4 / 100;
               var0 += class148.indexTrack1.percentage() * 2 / 100;
               var0 += indexModels.percentage() * 58 / 100;
               var0 += Tile.indexSprites.percentage() * 2 / 100;
               var0 += BoundingBox3D.indexTextures.percentage() * 2 / 100;
               var0 += Client.indexCache10.percentage() * 2 / 100;
               var0 += class70.indexTrack2.percentage() * 2 / 100;
               var0 += class28.indexScripts.percentage() * 2 / 100;
               var0 += class304.indexCache13.percentage() * 2 / 100;
               var0 += class45.vorbisIndex.percentage() * 2 / 100;
               var0 += class265.indexCache15.percentage() * 2 / 100;
               var0 += class283.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class89.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class89.loadingBarPercentage = 30;
               } else {
                  class27.method228(GameCanvas.indexInterfaces, "Animations");
                  class27.method228(GroundObject.indexSoundEffects, "Skeletons");
                  class27.method228(class23.indexCache4, "Sound FX");
                  class27.method228(FontName.indexMaps, "Maps");
                  class27.method228(class148.indexTrack1, "Music Tracks");
                  class27.method228(indexModels, "Models");
                  class27.method228(Tile.indexSprites, "Sprites");
                  class27.method228(class70.indexTrack2, "Music Jingles");
                  class27.method228(class45.vorbisIndex, "Music Samples");
                  class27.method228(class265.indexCache15, "Music Patches");
                  class27.method228(class283.indexWorldMap, "World Map");
                  class89.loadingText = "Loaded update list";
                  class89.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else if(Client.loadingStage == 45) {
               WidgetNode.method1074(22050, !Client.lowMemory, 2);
               class215 var28 = new class215();
               var28.method3964(9, 128);
               CombatInfoListHolder.soundSystem0 = Client.method1465(GameEngine.taskManager, 0, 22050);
               CombatInfoListHolder.soundSystem0.method2219(var28);
               CacheFile.method2476(class265.indexCache15, class45.vorbisIndex, class23.indexCache4, var28);
               DecorativeObject.soundSystem1 = Client.method1465(GameEngine.taskManager, 1, 2048);
               CombatInfoListHolder.field1251 = new class99();
               DecorativeObject.soundSystem1.method2219(CombatInfoListHolder.field1251);
               PacketNode.field2406 = new Resampler(22050, class20.sampleRate);
               class89.loadingText = "Prepared sound engine";
               class89.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               class233.fonts = new Fonts(Tile.indexSprites, class304.indexCache13);
            } else if(Client.loadingStage == 50) {
               var0 = FontName.method5195().length;
               Client.fontsMap = class233.fonts.createMap(FontName.method5195());
               if(Client.fontsMap.size() < var0) {
                  class89.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                  class89.loadingBarPercentage = 40;
               } else {
                  GrandExchangeOffer.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  BoundingBox2D.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  ContextMenuRow.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  class27.platformInfo = new MachineInfo(true);
                  class89.loadingText = "Loaded fonts";
                  class89.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = class70.method1124(Client.indexCache10, Tile.indexSprites);
               var1 = class175.method3328();
               if(var0 < var1) {
                  class89.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class89.loadingBarPercentage = 50;
               } else {
                  class89.loadingText = "Loaded title screen";
                  class89.loadingBarPercentage = 50;
                  class5.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else {
               IndexData var22;
               if(Client.loadingStage == 70) {
                  if(!class293.configsIndex.method4371()) {
                     class89.loadingText = "Loading config - " + class293.configsIndex.loadPercent() + "%";
                     class89.loadingBarPercentage = 60;
                  } else {
                     IndexData var27 = class293.configsIndex;
                     Overlay.overlay_ref = var27;
                     IndexData var29 = class293.configsIndex;
                     FloorUnderlayDefinition.underlay_ref = var29;
                     class160.method3146(class293.configsIndex, indexModels);
                     var22 = class293.configsIndex;
                     IndexData var23 = indexModels;
                     boolean var24 = Client.lowMemory;
                     SoundTask.objects_ref = var22;
                     ObjectComposition.field3496 = var23;
                     ObjectComposition.ocLowDetail = var24;
                     RunException.method3090(class293.configsIndex, indexModels);
                     GameObject.method3020(class293.configsIndex);
                     IndexData var5 = class293.configsIndex;
                     IndexData var6 = indexModels;
                     boolean var7 = Client.isMembers;
                     Font var8 = GrandExchangeOffer.fontPlain11;
                     class23.item_ref = var5;
                     ItemComposition.ItemDefinition_modelIndexCache = var6;
                     class255.isMembersWorld = var7;
                     SoundTask.field1549 = class23.item_ref.fileCount(10);
                     KitDefinition.field3418 = var8;
                     IndexData var9 = class293.configsIndex;
                     IndexData var10 = GameCanvas.indexInterfaces;
                     IndexData var11 = GroundObject.indexSoundEffects;
                     Sequence.seq_ref = var9;
                     Sequence.skel_ref = var10;
                     Sequence.skin_ref = var11;
                     class40.method549(class293.configsIndex, indexModels);
                     IndexData var12 = class293.configsIndex;
                     Varbit.varbit_ref = var12;
                     BuildType.method4353(class293.configsIndex);
                     IndexData var13 = AttackOption.indexCache3;
                     IndexData var14 = indexModels;
                     IndexData var15 = Tile.indexSprites;
                     IndexData var16 = class304.indexCache13;
                     Widget.widgetIndex = var13;
                     Widget.field2731 = var14;
                     class18.field301 = var15;
                     ISAACCipher.field2525 = var16;
                     FileRequest.widgets = new Widget[Widget.widgetIndex.size()][];
                     Widget.validInterfaces = new boolean[Widget.widgetIndex.size()];
                     class236.method4335(class293.configsIndex);
                     IndexData var17 = class293.configsIndex;
                     Enum.EnumDefinition_indexCache = var17;
                     Resampler.method2281(class293.configsIndex);
                     ItemLayer.method2560(class293.configsIndex);
                     class185.method3615(class293.configsIndex);
                     class61.chatMessages = new Varcs();
                     class148.method3040(class293.configsIndex, Tile.indexSprites, class304.indexCache13);
                     IndexData var18 = class293.configsIndex;
                     IndexData var19 = Tile.indexSprites;
                     CombatInfo2.field3423 = var18;
                     CombatInfo2.field3420 = var19;
                     class160.method3142(class293.configsIndex, Tile.indexSprites);
                     class89.loadingText = "Loaded config";
                     class89.loadingBarPercentage = 60;
                     Client.loadingStage = 80;
                  }
               } else if(Client.loadingStage == 80) {
                  var0 = 0;
                  SpritePixels var21;
                  if(ClassInfo.compass == null) {
                     var22 = Tile.indexSprites;
                     var3 = var22.getFile("compass");
                     var4 = var22.getChild(var3, "");
                     var21 = BaseVarType.method17(var22, var3, var4);
                     ClassInfo.compass = var21;
                  } else {
                     ++var0;
                  }

                  if(class92.mapedge == null) {
                     var22 = Tile.indexSprites;
                     var3 = var22.getFile("mapedge");
                     var4 = var22.getChild(var3, "");
                     var21 = BaseVarType.method17(var22, var3, var4);
                     class92.mapedge = var21;
                  } else {
                     ++var0;
                  }

                  if(class179.mapscene == null) {
                     class179.mapscene = class228.getIndexedSprites(Tile.indexSprites, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(GrandExchangeOffer.headIconsPk == null) {
                     GrandExchangeOffer.headIconsPk = BoundingBox2D.getSprites(Tile.indexSprites, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(Player.headIconsPrayer == null) {
                     Player.headIconsPrayer = BoundingBox2D.getSprites(Tile.indexSprites, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(GrandExchangeEvent.headIconsHint == null) {
                     GrandExchangeEvent.headIconsHint = BoundingBox2D.getSprites(Tile.indexSprites, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(DState.mapMarkers == null) {
                     DState.mapMarkers = BoundingBox2D.getSprites(Tile.indexSprites, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(class39.crossSprites == null) {
                     class39.crossSprites = BoundingBox2D.getSprites(Tile.indexSprites, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(Widget.mapDots == null) {
                     Widget.mapDots = BoundingBox2D.getSprites(Tile.indexSprites, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class79.scrollbarSprites == null) {
                     class79.scrollbarSprites = class228.getIndexedSprites(Tile.indexSprites, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(PacketNode.modIconSprites == null) {
                     PacketNode.modIconSprites = class228.getIndexedSprites(Tile.indexSprites, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 11) {
                     class89.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class89.loadingBarPercentage = 70;
                  } else {
                     FontTypeFace.modIcons = PacketNode.modIconSprites;
                     class92.mapedge.method5543();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;
                     class179.mapscene[0].method5503(var4 + var1, var2 + var4, var3 + var4);
                     class89.loadingText = "Loaded sprites";
                     class89.loadingBarPercentage = 70;
                     Client.loadingStage = 90;
                  }
               } else if(Client.loadingStage == 90) {
                  if(!BoundingBox3D.indexTextures.method4371()) {
                     class89.loadingText = "Loading textures - " + "0%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     WorldComparator.field259 = new TextureProvider(BoundingBox3D.indexTextures, Tile.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                     Graphics3D.method2746(WorldComparator.field259);
                     Graphics3D.setBrightness(0.8D);
                     Client.loadingStage = 100;
                  }
               } else if(Client.loadingStage == 100) {
                  var0 = WorldComparator.field259.method2531();
                  if(var0 < 100) {
                     class89.loadingText = "Loading textures - " + var0 + "%";
                     class89.loadingBarPercentage = 90;
                  } else {
                     class89.loadingText = "Loaded textures";
                     class89.loadingBarPercentage = 90;
                     Client.loadingStage = 110;
                  }
               } else if(Client.loadingStage == 110) {
                  class3.mouseRecorder = new MouseRecorder();
                  GameEngine.taskManager.createRunnable(class3.mouseRecorder, 10);
                  class89.loadingText = "Loaded input handler";
                  class89.loadingBarPercentage = 92;
                  Client.loadingStage = 120;
               } else if(Client.loadingStage == 120) {
                  if(!Client.indexCache10.tryLoadRecordByNames("huffman", "")) {
                     class89.loadingText = "Loading wordpack - " + 0 + "%";
                     class89.loadingBarPercentage = 94;
                  } else {
                     Huffman var26 = new Huffman(Client.indexCache10.takeRecordByNames("huffman", ""));
                     class288.huffman = var26;
                     class89.loadingText = "Loaded wordpack";
                     class89.loadingBarPercentage = 94;
                     Client.loadingStage = 130;
                  }
               } else if(Client.loadingStage == 130) {
                  if(!AttackOption.indexCache3.method4371()) {
                     class89.loadingText = "Loading interfaces - " + AttackOption.indexCache3.loadPercent() * 4 / 5 + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class28.indexScripts.method4371()) {
                     class89.loadingText = "Loading interfaces - " + (80 + class28.indexScripts.loadPercent() / 6) + "%";
                     class89.loadingBarPercentage = 96;
                  } else if(!class304.indexCache13.method4371()) {
                     class89.loadingText = "Loading interfaces - " + (96 + class304.indexCache13.loadPercent() / 50) + "%";
                     class89.loadingBarPercentage = 96;
                  } else {
                     class89.loadingText = "Loaded interfaces";
                     class89.loadingBarPercentage = 98;
                     Client.loadingStage = 140;
                  }
               } else if(Client.loadingStage == 140) {
                  class89.loadingBarPercentage = 100;
                  if(!class283.indexWorldMap.tryLoadArchiveByName(class40.field508.field509)) {
                     class89.loadingText = "Loading world map - " + class283.indexWorldMap.archiveLoadPercentByName(class40.field508.field509) / 10 + "%";
                  } else {
                     if(ScriptState.renderOverview == null) {
                        ScriptState.renderOverview = new RenderOverview();
                        ScriptState.renderOverview.method5825(class283.indexWorldMap, ContextMenuRow.fontBold12, Client.fontsMap, class179.mapscene);
                     }

                     var0 = ScriptState.renderOverview.method5662();
                     if(var0 < 100) {
                        class89.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                     } else {
                        class89.loadingText = "Loaded world map";
                        Client.loadingStage = 150;
                     }
                  }
               } else if(Client.loadingStage == 150) {
                  class5.setGameState(10);
               }
            }
         } else {
            int[] var20 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var20[var1] = var3 * var4 >> 16;
            }

            Region.method2846(var20, 500, 800, 512, 334);
            class89.loadingText = "Prepared visibility map";
            class89.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
