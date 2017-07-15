import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("a")
   @Export("INTEGER")
   INTEGER(2, 0, Integer.class, new class2()),
   @ObfuscatedName("j")
   @Export("LONG")
   LONG(1, 1, Long.class, new class3()),
   @ObfuscatedName("n")
   @Export("STRING")
   STRING(0, 2, String.class, new class5());

   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2086324149
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -572128683
   )
   final int field25;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 489626625
   )
   final int field26;
   @ObfuscatedName("cv")
   @Export("socket")
   static Task socket;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 2017732177
   )
   static int field29;

   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field25 = var3;
      this.field26 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field26;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-664780403"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class29.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class221.field2833 = new SpritePixels(512, 512);
         class92.loadingText = "Starting game engine...";
         class92.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var33 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var33[var1] = var3 * var4 >> 16;
            }

            Region.method2739(var33, 500, 800, 512, 334);
            class92.loadingText = "Prepared visibility map";
            class92.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class31.indexInterfaces = Huffman.openCacheIndex(0, false, true, true);
            Client.indexSoundEffects = Huffman.openCacheIndex(1, false, true, true);
            Tile.configsIndex = Huffman.openCacheIndex(2, true, false, true);
            BuildType.field3190 = Huffman.openCacheIndex(3, false, true, true);
            WorldMapType2.field502 = Huffman.openCacheIndex(4, false, true, true);
            class12.indexMaps = Huffman.openCacheIndex(5, true, true, true);
            class182.indexTrack1 = Huffman.openCacheIndex(6, true, true, false);
            Renderable.indexModels = Huffman.openCacheIndex(7, false, true, true);
            class17.indexSprites = Huffman.openCacheIndex(8, false, true, true);
            Client.indexTextures = Huffman.openCacheIndex(9, false, true, true);
            class54.field660 = Huffman.openCacheIndex(10, false, true, true);
            class10.indexTrack2 = Huffman.openCacheIndex(11, false, true, true);
            class265.indexScripts = Huffman.openCacheIndex(12, false, true, true);
            Player.field881 = Huffman.openCacheIndex(13, true, false, true);
            class71.vorbisIndex = Huffman.openCacheIndex(14, false, true, false);
            class56.field675 = Huffman.openCacheIndex(15, false, true, true);
            class3.indexWorldMap = Huffman.openCacheIndex(16, false, true, false);
            class92.loadingText = "Connecting to update server";
            class92.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var30 = 0;
            var0 = var30 + class31.indexInterfaces.percentage() * 4 / 100;
            var0 += Client.indexSoundEffects.percentage() * 4 / 100;
            var0 += Tile.configsIndex.percentage() * 2 / 100;
            var0 += BuildType.field3190.percentage() * 2 / 100;
            var0 += WorldMapType2.field502.percentage() * 6 / 100;
            var0 += class12.indexMaps.percentage() * 4 / 100;
            var0 += class182.indexTrack1.percentage() * 2 / 100;
            var0 += Renderable.indexModels.percentage() * 58 / 100;
            var0 += class17.indexSprites.percentage() * 2 / 100;
            var0 += Client.indexTextures.percentage() * 2 / 100;
            var0 += class54.field660.percentage() * 2 / 100;
            var0 += class10.indexTrack2.percentage() * 2 / 100;
            var0 += class265.indexScripts.percentage() * 2 / 100;
            var0 += Player.field881.percentage() * 2 / 100;
            var0 += class71.vorbisIndex.percentage() * 2 / 100;
            var0 += class56.field675.percentage() * 2 / 100;
            var0 += class3.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class92.loadingText = "Checking for updates - " + var0 + "%";
               }

               class92.loadingBarPercentage = 30;
            } else {
               class92.loadingText = "Loaded update list";
               class92.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else {
            IndexData var25;
            IndexData var27;
            if(Client.loadingStage == 45) {
               boolean var29 = !Client.lowMemory;
               ChatLineBuffer.sampleRate = 22050;
               AbstractSoundSystem.highMemory = var29;
               class11.priority = 2;
               class204 var35 = new class204();
               var35.method3741(9, 128);
               class290.soundSystem0 = TextureProvider.method2381(GameEngine.taskManager, 0, 22050);
               class290.soundSystem0.method1984(var35);
               var25 = class56.field675;
               IndexData var26 = class71.vorbisIndex;
               var27 = WorldMapType2.field502;
               class203.field2498 = var25;
               class270.field3683 = var26;
               class203.field2499 = var27;
               class203.field2500 = var35;
               KeyFocusListener.soundSystem1 = TextureProvider.method2381(GameEngine.taskManager, 1, 2048);
               class203.field2511 = new class102();
               KeyFocusListener.soundSystem1.method1984(class203.field2511);
               Overlay.field3593 = new class116(22050, ChatLineBuffer.sampleRate);
               class92.loadingText = "Prepared sound engine";
               class92.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               CombatInfoListHolder.field1362 = new class262(class17.indexSprites, Player.field881);
            } else if(Client.loadingStage == 50) {
               var0 = class261.method4649().length;
               Client.field960 = CombatInfoListHolder.field1362.method4656(class261.method4649());
               if(Client.field960.size() < var0) {
                  class92.loadingText = "Loading fonts - " + Client.field960.size() * 100 / var0 + "%";
                  class92.loadingBarPercentage = 40;
               } else {
                  class223.field2847 = (Font)Client.field960.get(class261.field3628);
                  class5.font_p12full = (Font)Client.field960.get(class261.field3622);
                  class21.field338 = (Font)Client.field960.get(class261.field3621);
                  class202.field2496 = new MachineInfo(true);
                  class92.loadingText = "Loaded fonts";
                  class92.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = class14.method86(class54.field660, class17.indexSprites);
               var1 = WidgetNode.method1091();
               if(var0 < var1) {
                  class92.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class92.loadingBarPercentage = 50;
               } else {
                  class92.loadingText = "Loaded title screen";
                  class92.loadingBarPercentage = 50;
                  WorldMapType2.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!Tile.configsIndex.method4086()) {
                  class92.loadingText = "Loading config - " + Tile.configsIndex.method4182() + "%";
                  class92.loadingBarPercentage = 60;
               } else {
                  FloorUnderlayDefinition.method4314(Tile.configsIndex);
                  IndexData var32 = Tile.configsIndex;
                  FloorUnderlayDefinition.underlay_ref = var32;
                  CombatInfo1.method1509(Tile.configsIndex, Renderable.indexModels);
                  IndexData var34 = Tile.configsIndex;
                  var25 = Renderable.indexModels;
                  boolean var28 = Client.lowMemory;
                  ObjectComposition.objects_ref = var34;
                  ObjectComposition.field3435 = var25;
                  ObjectComposition.field3441 = var28;
                  var27 = Tile.configsIndex;
                  IndexData var5 = Renderable.indexModels;
                  NPCComposition.field3560 = var27;
                  class203.field2512 = var5;
                  IndexData var6 = Tile.configsIndex;
                  class217.field2790 = var6;
                  class33.method349(Tile.configsIndex, Renderable.indexModels, Client.isMembers, class223.field2847);
                  Client.method1165(Tile.configsIndex, class31.indexInterfaces, Client.indexSoundEffects);
                  class229.method4070(Tile.configsIndex, Renderable.indexModels);
                  IndexData var7 = Tile.configsIndex;
                  Varbit.varbit_ref = var7;
                  class177.method3372(Tile.configsIndex);
                  IndexData var8 = BuildType.field3190;
                  IndexData var9 = Renderable.indexModels;
                  IndexData var10 = class17.indexSprites;
                  IndexData var11 = Player.field881;
                  class11.widgetIndex = var8;
                  class47.field592 = var9;
                  class214.field2637 = var10;
                  class271.field3685 = var11;
                  Widget.widgets = new Widget[class11.widgetIndex.size()][];
                  Widget.validInterfaces = new boolean[class11.widgetIndex.size()];
                  PendingSpawn.method1477(Tile.configsIndex);
                  IndexData var12 = Tile.configsIndex;
                  VarPlayerType.field3286 = var12;
                  IndexData var13 = Tile.configsIndex;
                  class243.field3310 = var13;
                  IndexData var14 = Tile.configsIndex;
                  class244.field3320 = var14;
                  IndexData var15 = Tile.configsIndex;
                  class251.field3386 = var15;
                  class46.chatMessages = new Varcs();
                  IndexData var16 = Tile.configsIndex;
                  IndexData var17 = class17.indexSprites;
                  IndexData var18 = Player.field881;
                  class254.field3409 = var16;
                  class254.field3408 = var17;
                  class254.field3410 = var18;
                  Occluder.method2887(Tile.configsIndex, class17.indexSprites);
                  IndexData var19 = Tile.configsIndex;
                  IndexData var20 = class17.indexSprites;
                  Area.field3294 = var20;
                  if(var19.method4086()) {
                     Area.field3291 = var19.fileCount(35);
                     class54.field662 = new Area[Area.field3291];

                     for(int var21 = 0; var21 < Area.field3291; ++var21) {
                        byte[] var22 = var19.getConfigData(35, var21);
                        if(var22 != null) {
                           class54.field662[var21] = new Area(var21);
                           class54.field662[var21].method4247(new Buffer(var22));
                           class54.field662[var21].method4252();
                        }
                     }
                  }

                  class92.loadingText = "Loaded config";
                  class92.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               SpritePixels var24;
               if(class87.compass == null) {
                  var25 = class17.indexSprites;
                  var3 = var25.getFile("compass");
                  var4 = var25.getChild(var3, "");
                  var24 = class27.method217(var25, var3, var4);
                  class87.compass = var24;
               } else {
                  ++var0;
               }

               if(class203.mapedge == null) {
                  var25 = class17.indexSprites;
                  var3 = var25.getFile("mapedge");
                  var4 = var25.getChild(var3, "");
                  var24 = class27.method217(var25, var3, var4);
                  class203.mapedge = var24;
               } else {
                  ++var0;
               }

               if(GZipDecompressor.field2330 == null) {
                  GZipDecompressor.field2330 = class266.method4774(class17.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class43.mapfunctions == null) {
                  class43.mapfunctions = WorldMapType1.method274(class17.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(XItemContainer.hitmarks == null) {
                  XItemContainer.hitmarks = WorldMapType1.method274(class17.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class23.pkIcons == null) {
                  class23.pkIcons = WorldMapType1.method274(class17.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class64.field799 == null) {
                  class64.field799 = WorldMapType1.method274(class17.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(CombatInfoListHolder.field1359 == null) {
                  CombatInfoListHolder.field1359 = WorldMapType1.method274(class17.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(class163.mapDots == null) {
                  class163.mapDots = WorldMapType1.method274(class17.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class226.field3142 == null) {
                  class226.field3142 = class266.method4774(class17.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class208.field2592 == null) {
                  class208.field2592 = class266.method4774(class17.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class92.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class92.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class208.field2592;
                  class203.mapedge.method4975();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  GZipDecompressor.field2330[0].method4949(var1 + var4, var2 + var4, var4 + var3);
                  class92.loadingText = "Loaded sprites";
                  class92.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!Client.indexTextures.method4086()) {
                  class92.loadingText = "Loading textures - " + Client.indexTextures.method4182() + "%";
                  class92.loadingBarPercentage = 90;
               } else {
                  TextureProvider var31 = new TextureProvider(Client.indexTextures, class17.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.setTextureLoader(var31);
                  Graphics3D.setBrightness(0.8D);
                  class92.loadingText = "Loaded textures";
                  class92.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               KeyFocusListener.field641 = new class71();
               GameEngine.taskManager.createRunnable(KeyFocusListener.field641, 10);
               class92.loadingText = "Loaded input handler";
               class92.loadingBarPercentage = 94;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!class54.field660.method4101("huffman", "")) {
                  class92.loadingText = "Loading wordpack - " + 0 + "%";
                  class92.loadingBarPercentage = 96;
               } else {
                  Huffman var23 = new Huffman(class54.field660.method4116("huffman", ""));
                  Player.method1137(var23);
                  class92.loadingText = "Loaded wordpack";
                  class92.loadingBarPercentage = 96;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!BuildType.field3190.method4086()) {
                  class92.loadingText = "Loading interfaces - " + BuildType.field3190.method4182() * 4 / 5 + "%";
                  class92.loadingBarPercentage = 100;
               } else if(!class265.indexScripts.method4086()) {
                  class92.loadingText = "Loading interfaces - " + (80 + class265.indexScripts.method4182() / 6) + "%";
                  class92.loadingBarPercentage = 100;
               } else if(!Player.field881.method4086()) {
                  class92.loadingText = "Loading interfaces - " + (96 + Player.field881.method4182() / 50) + "%";
                  class92.loadingBarPercentage = 100;
               } else {
                  class92.loadingText = "Loaded interfaces";
                  class92.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               if(!class3.indexWorldMap.method4102(class40.field535.field532)) {
                  class92.loadingText = "Loading world map - " + class3.indexWorldMap.method4112(class40.field535.field532) / 10 + "%";
               } else {
                  if(class11.renderOverview == null) {
                     class11.renderOverview = new RenderOverview();
                     class11.renderOverview.method5160(class3.indexWorldMap, class21.field338, Client.field960, GZipDecompressor.field2330);
                  }

                  var0 = class11.renderOverview.method5108();
                  if(var0 < 100) {
                     class92.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class92.loadingText = "Loaded world map";
                     class92.loadingBarPercentage = 100;
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               WorldMapType2.setGameState(10);
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1087656730"
   )
   static int method12(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-32"
   )
   static final void method10(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(44);
         Client.secretPacketBuffer1.putByte(DecorativeObject.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }
}
