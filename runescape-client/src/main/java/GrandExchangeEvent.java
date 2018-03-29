import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -465224591
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -7840100100155969995L
   )
   public final long field278;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lb;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("j")
   @Export("string1")
   String string1;
   @ObfuscatedName("k")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgp;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field278 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method114(2);
      this.grandExchangeOffer.method115(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1319147053"
   )
   public String method92() {
      return this.string1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "553728684"
   )
   public String method88() {
      return this.string2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "64"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      ItemContainer var4 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new ItemContainer();
         ItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "9"
   )
   static final void method87(String var0) {
      class47.method743("Please remove " + var0 + " from your friend list first");
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-723189622"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class308.region = new Region(4, 104, 104, class62.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         ServerPacket.minimapSprite = new SpritePixels(512, 512);
         class90.loadingText = "Starting game engine...";
         class90.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var34 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var34[var1] = var4 * var3 >> 16;
            }

            Region.buildVisibilityMaps(var34, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class169.indexInterfaces = KeyFocusListener.openCacheIndex(0, false, true, true);
            class19.indexSoundEffects = KeyFocusListener.openCacheIndex(1, false, true, true);
            WorldMapType2.configsIndex = KeyFocusListener.openCacheIndex(2, true, false, true);
            class55.indexCache3 = KeyFocusListener.openCacheIndex(3, false, true, true);
            class44.indexCache4 = KeyFocusListener.openCacheIndex(4, false, true, true);
            class1.indexMaps = KeyFocusListener.openCacheIndex(5, true, true, true);
            class1.indexTrack1 = KeyFocusListener.openCacheIndex(6, true, true, true);
            class44.indexModels = KeyFocusListener.openCacheIndex(7, false, true, true);
            class44.indexSprites = KeyFocusListener.openCacheIndex(8, false, true, true);
            PendingSpawn.indexTextures = KeyFocusListener.openCacheIndex(9, false, true, true);
            Client.indexCache10 = KeyFocusListener.openCacheIndex(10, false, true, true);
            class157.indexTrack2 = KeyFocusListener.openCacheIndex(11, false, true, true);
            MapLabel.indexScripts = KeyFocusListener.openCacheIndex(12, false, true, true);
            class18.indexCache13 = KeyFocusListener.openCacheIndex(13, true, false, true);
            ScriptEvent.vorbisIndex = KeyFocusListener.openCacheIndex(14, false, true, true);
            Renderable.indexCache15 = KeyFocusListener.openCacheIndex(15, false, true, true);
            class151.indexWorldMap = KeyFocusListener.openCacheIndex(16, true, true, true);
            class90.loadingText = "Connecting to update server";
            class90.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var32 = 0;
            var0 = var32 + class169.indexInterfaces.percentage() * 4 / 100;
            var0 += class19.indexSoundEffects.percentage() * 4 / 100;
            var0 += WorldMapType2.configsIndex.percentage() * 2 / 100;
            var0 += class55.indexCache3.percentage() * 2 / 100;
            var0 += class44.indexCache4.percentage() * 6 / 100;
            var0 += class1.indexMaps.percentage() * 4 / 100;
            var0 += class1.indexTrack1.percentage() * 2 / 100;
            var0 += class44.indexModels.percentage() * 58 / 100;
            var0 += class44.indexSprites.percentage() * 2 / 100;
            var0 += PendingSpawn.indexTextures.percentage() * 2 / 100;
            var0 += Client.indexCache10.percentage() * 2 / 100;
            var0 += class157.indexTrack2.percentage() * 2 / 100;
            var0 += MapLabel.indexScripts.percentage() * 2 / 100;
            var0 += class18.indexCache13.percentage() * 2 / 100;
            var0 += ScriptEvent.vorbisIndex.percentage() * 2 / 100;
            var0 += Renderable.indexCache15.percentage() * 2 / 100;
            var0 += class151.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class90.loadingText = "Checking for updates - " + var0 + "%";
               }

               class90.loadingBarPercentage = 30;
            } else {
               class27.method232(class169.indexInterfaces, "Animations");
               class27.method232(class19.indexSoundEffects, "Skeletons");
               class27.method232(class44.indexCache4, "Sound FX");
               class27.method232(class1.indexMaps, "Maps");
               class27.method232(class1.indexTrack1, "Music Tracks");
               class27.method232(class44.indexModels, "Models");
               class27.method232(class44.indexSprites, "Sprites");
               class27.method232(class157.indexTrack2, "Music Jingles");
               class27.method232(ScriptEvent.vorbisIndex, "Music Samples");
               class27.method232(Renderable.indexCache15, "Music Patches");
               class27.method232(class151.indexWorldMap, "World Map");
               class90.loadingText = "Loaded update list";
               class90.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var27;
            IndexData var28;
            IndexData var29;
            if(Client.loadingStage == 45) {
               boolean var31 = !Client.lowMemory;
               class317.sampleRate = 22050;
               UnitPriceComparator.audioHighMemory = var31;
               Coordinates.field2777 = 2;
               class230 var36 = new class230();
               var36.method4152(9, 128);
               OwnWorldComparator.soundSystem0 = DynamicObject.method2022(GameEngine.taskManager, 0, 22050);
               OwnWorldComparator.soundSystem0.method2189(var36);
               var27 = Renderable.indexCache15;
               var28 = ScriptEvent.vorbisIndex;
               var29 = class44.indexCache4;
               class229.field2684 = var27;
               class229.field2678 = var28;
               class154.field2136 = var29;
               class229.field2679 = var36;
               Tile.soundSystem1 = DynamicObject.method2022(GameEngine.taskManager, 1, 2048);
               GameCanvas.field632 = new class100();
               Tile.soundSystem1.method2189(GameCanvas.field632);
               Buffer.field2571 = new Resampler(22050, class317.sampleRate);
               class90.loadingText = "Prepared sound engine";
               class90.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               class7.fonts = new Fonts(class44.indexSprites, class18.indexCache13);
            } else if(Client.loadingStage == 50) {
               var0 = FontName.method5498().length;
               Client.fontsMap = class7.fonts.createMap(FontName.method5498());
               if(Client.fontsMap.size() < var0) {
                  class90.loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var0 + "%";
                  class90.loadingBarPercentage = 40;
               } else {
                  class2.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
                  Huffman.font_p12full = (Font)Client.fontsMap.get(FontName.FontName_plain12);
                  class228.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
                  JagexLoginType.platformInfo = new MachineInfo(true);
                  class90.loadingText = "Loaded fonts";
                  class90.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = MapLabel.method388(Client.indexCache10, class44.indexSprites);
               byte var30 = 11;
               if(var0 < var30) {
                  class90.loadingText = "Loading title screen - " + var0 * 100 / var30 + "%";
                  class90.loadingBarPercentage = 50;
               } else {
                  class90.loadingText = "Loaded title screen";
                  class90.loadingBarPercentage = 50;
                  MapIconReference.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!WorldMapType2.configsIndex.method4640()) {
                  class90.loadingText = "Loading config - " + WorldMapType2.configsIndex.loadPercent() + "%";
                  class90.loadingBarPercentage = 60;
               } else {
                  class241.method4443(WorldMapType2.configsIndex);
                  IndexData var33 = WorldMapType2.configsIndex;
                  class55.underlay_ref = var33;
                  IndexData var35 = WorldMapType2.configsIndex;
                  var27 = class44.indexModels;
                  KitDefinition.identKit_ref = var35;
                  KitDefinition.field3505 = var27;
                  KitDefinition.field3512 = KitDefinition.identKit_ref.fileCount(3);
                  var28 = WorldMapType2.configsIndex;
                  var29 = class44.indexModels;
                  boolean var5 = Client.lowMemory;
                  class252.objects_ref = var28;
                  ObjectComposition.field3587 = var29;
                  ObjectComposition.objectCompositionLowDetail = var5;
                  IndexData var6 = WorldMapType2.configsIndex;
                  IndexData var7 = class44.indexModels;
                  NPCComposition.NpcDefinition_indexCache = var6;
                  NPCComposition.NpcDefinition_modelIndexCache = var7;
                  class167.method3254(WorldMapType2.configsIndex);
                  IndexData var8 = WorldMapType2.configsIndex;
                  IndexData var9 = class44.indexModels;
                  boolean var10 = Client.isMembers;
                  Font var11 = class2.fontPlain11;
                  class156.item_ref = var8;
                  ItemComposition.ItemDefinition_modelIndexCache = var9;
                  class154.isMembersWorld = var10;
                  class20.field319 = class156.item_ref.fileCount(10);
                  class236.field2767 = var11;
                  IndexData var12 = WorldMapType2.configsIndex;
                  IndexData var13 = class169.indexInterfaces;
                  IndexData var14 = class19.indexSoundEffects;
                  UnitPriceComparator.seq_ref = var12;
                  Sequence.skel_ref = var13;
                  Sequence.skin_ref = var14;
                  WidgetNode.method1098(WorldMapType2.configsIndex, class44.indexModels);
                  SoundTask.method2259(WorldMapType2.configsIndex);
                  IndexData var15 = WorldMapType2.configsIndex;
                  VarPlayerType.varplayer_ref = var15;
                  VarPlayerType.field3445 = VarPlayerType.varplayer_ref.fileCount(16);
                  BoundingBox.method60(class55.indexCache3, class44.indexModels, class44.indexSprites, class18.indexCache13);
                  class197.method3753(WorldMapType2.configsIndex);
                  UnitPriceComparator.method128(WorldMapType2.configsIndex);
                  IndexData var16 = WorldMapType2.configsIndex;
                  VarCInt.field3473 = var16;
                  class154.method3158(WorldMapType2.configsIndex);
                  IndexData var17 = WorldMapType2.configsIndex;
                  class278.field3542 = var17;
                  class158.varcs = new Varcs();
                  IndexData var18 = WorldMapType2.configsIndex;
                  IndexData var19 = class44.indexSprites;
                  IndexData var20 = class18.indexCache13;
                  class281.field3576 = var18;
                  class281.field3564 = var19;
                  class281.field3565 = var20;
                  FileRequest.method4545(WorldMapType2.configsIndex, class44.indexSprites);
                  IndexData var21 = WorldMapType2.configsIndex;
                  IndexData var22 = class44.indexSprites;
                  Area.field3456 = var22;
                  if(var21.method4640()) {
                     Area.field3450 = var21.fileCount(35);
                     Area.mapAreaType = new Area[Area.field3450];

                     for(int var23 = 0; var23 < Area.field3450; ++var23) {
                        byte[] var24 = var21.getConfigData(35, var23);
                        if(var24 != null) {
                           Area.mapAreaType[var23] = new Area(var23);
                           Area.mapAreaType[var23].method4751(new Buffer(var24));
                           Area.mapAreaType[var23].method4756();
                        }
                     }
                  }

                  class90.loadingText = "Loaded config";
                  class90.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               SpritePixels var26;
               if(MouseRecorder.compass == null) {
                  var27 = class44.indexSprites;
                  var3 = var27.getFile("compass");
                  var4 = var27.getChild(var3, "");
                  var26 = BufferProvider.method5831(var27, var3, var4);
                  MouseRecorder.compass = var26;
               } else {
                  ++var0;
               }

               if(MapLabel.mapedge == null) {
                  var27 = class44.indexSprites;
                  var3 = var27.getFile("mapedge");
                  var4 = var27.getChild(var3, "");
                  var26 = BufferProvider.method5831(var27, var3, var4);
                  MapLabel.mapedge = var26;
               } else {
                  ++var0;
               }

               if(class61.mapscene == null) {
                  class61.mapscene = class199.getIndexedSprites(class44.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class20.headIconsPk == null) {
                  class20.headIconsPk = class316.getSprites(class44.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class86.headIconsPrayer == null) {
                  class86.headIconsPrayer = class316.getSprites(class44.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class47.headIconsHint == null) {
                  class47.headIconsHint = class316.getSprites(class44.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class64.mapMarkers == null) {
                  class64.mapMarkers = class316.getSprites(class44.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(WorldComparator.crossSprites == null) {
                  WorldComparator.crossSprites = class316.getSprites(class44.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(SceneTilePaint.mapDots == null) {
                  SceneTilePaint.mapDots = class316.getSprites(class44.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(PendingSpawn.scrollbarSprites == null) {
                  PendingSpawn.scrollbarSprites = class199.getIndexedSprites(class44.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class44.modIconSprites == null) {
                  class44.modIconSprites = class199.getIndexedSprites(class44.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class90.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class44.modIconSprites;
                  MapLabel.mapedge.method5862();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class61.mapscene[0].method5857(var1 + var4, var4 + var2, var3 + var4);
                  class90.loadingText = "Loaded sprites";
                  class90.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!PendingSpawn.indexTextures.method4640()) {
                  class90.loadingText = "Loading textures - " + "0%";
                  class90.loadingBarPercentage = 90;
               } else {
                  class66.field760 = new TextureProvider(PendingSpawn.indexTextures, class44.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.method2796(class66.field760);
                  Graphics3D.setBrightness(0.8D);
                  Client.loadingStage = 100;
               }
            } else if(Client.loadingStage == 100) {
               var0 = class66.field760.method2555();
               if(var0 < 100) {
                  class90.loadingText = "Loading textures - " + var0 + "%";
                  class90.loadingBarPercentage = 90;
               } else {
                  class90.loadingText = "Loaded textures";
                  class90.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               class38.mouseRecorder = new MouseRecorder();
               GameEngine.taskManager.createRunnable(class38.mouseRecorder, 10);
               class90.loadingText = "Loaded input handler";
               class90.loadingBarPercentage = 92;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!Client.indexCache10.tryLoadRecordByNames("huffman", "")) {
                  class90.loadingText = "Loading wordpack - " + 0 + "%";
                  class90.loadingBarPercentage = 94;
               } else {
                  Huffman var25 = new Huffman(Client.indexCache10.takeRecordByNames("huffman", ""));
                  class313.huffman = var25;
                  class90.loadingText = "Loaded wordpack";
                  class90.loadingBarPercentage = 94;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!class55.indexCache3.method4640()) {
                  class90.loadingText = "Loading interfaces - " + class55.indexCache3.loadPercent() * 4 / 5 + "%";
                  class90.loadingBarPercentage = 96;
               } else if(!MapLabel.indexScripts.method4640()) {
                  class90.loadingText = "Loading interfaces - " + (80 + MapLabel.indexScripts.loadPercent() / 6) + "%";
                  class90.loadingBarPercentage = 96;
               } else if(!class18.indexCache13.method4640()) {
                  class90.loadingText = "Loading interfaces - " + (96 + class18.indexCache13.loadPercent() / 50) + "%";
                  class90.loadingBarPercentage = 96;
               } else {
                  class90.loadingText = "Loaded interfaces";
                  class90.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               class90.loadingBarPercentage = 100;
               if(!class151.indexWorldMap.tryLoadArchiveByName(MapCacheArchiveNames.DETAILS.name)) {
                  class90.loadingText = "Loading world map - " + class151.indexWorldMap.archiveLoadPercentByName(MapCacheArchiveNames.DETAILS.name) / 10 + "%";
               } else {
                  if(ScriptState.renderOverview == null) {
                     ScriptState.renderOverview = new RenderOverview();
                     ScriptState.renderOverview.method6049(class151.indexWorldMap, class228.fontBold12, Client.fontsMap, class61.mapscene);
                  }

                  var0 = ScriptState.renderOverview.method6010();
                  if(var0 < 100) {
                     class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class90.loadingText = "Loaded world map";
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               MapIconReference.setGameState(10);
            }
         }
      }
   }
}
