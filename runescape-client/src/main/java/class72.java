import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class72 extends class164 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILfb;I)Z",
      garbageValue = "135949829"
   )
   public boolean vmethod3188(int var1, int var2, int var3, CollisionData var4) {
      return var2 == super.field2210 && var3 == super.field2211;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "3"
   )
   static char method1147(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1964172753"
   )
   static void method1144() {
      if(class91.field1366 && class91.username != null && class91.username.length() > 0) {
         class91.field1339 = 1;
      } else {
         class91.field1339 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-713559428"
   )
   public static void method1150() {
      Area.areaSpriteCache.reset();
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class14.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class1.field12 = new SpritePixels(512, 512);
         class91.loadingText = "Starting game engine...";
         class91.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage == 20) {
            int[] var29 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 15 + 128;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var29[var1] = var4 * var3 >> 16;
            }

            Region.method2831(var29, 500, 800, 512, 334);
            class91.loadingText = "Prepared visibility map";
            class91.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         } else if(Client.loadingStage == 30) {
            class163.indexInterfaces = class37.openCacheIndex(0, false, true, true);
            class10.indexSoundEffects = class37.openCacheIndex(1, false, true, true);
            Player.configsIndex = class37.openCacheIndex(2, true, false, true);
            class45.field561 = class37.openCacheIndex(3, false, true, true);
            class47.field576 = class37.openCacheIndex(4, false, true, true);
            PlayerComposition.indexMaps = class37.openCacheIndex(5, true, true, true);
            RSCanvas.indexTrack1 = class37.openCacheIndex(6, true, true, false);
            MouseInput.indexModels = class37.openCacheIndex(7, false, true, true);
            ContextMenuRow.indexSprites = class37.openCacheIndex(8, false, true, true);
            class64.indexTextures = class37.openCacheIndex(9, false, true, true);
            WorldMapType2.field500 = class37.openCacheIndex(10, false, true, true);
            class35.indexTrack2 = class37.openCacheIndex(11, false, true, true);
            class1.indexScripts = class37.openCacheIndex(12, false, true, true);
            class44.field550 = class37.openCacheIndex(13, true, false, true);
            class18.vorbisIndex = class37.openCacheIndex(14, false, true, false);
            Player.field861 = class37.openCacheIndex(15, false, true, true);
            class46.indexWorldMap = class37.openCacheIndex(16, false, true, false);
            class91.loadingText = "Connecting to update server";
            class91.loadingBarPercentage = 20;
            Client.loadingStage = 40;
         } else if(Client.loadingStage == 40) {
            byte var25 = 0;
            var0 = var25 + class163.indexInterfaces.percentage() * 4 / 100;
            var0 += class10.indexSoundEffects.percentage() * 4 / 100;
            var0 += Player.configsIndex.percentage() * 2 / 100;
            var0 += class45.field561.percentage() * 2 / 100;
            var0 += class47.field576.percentage() * 6 / 100;
            var0 += PlayerComposition.indexMaps.percentage() * 4 / 100;
            var0 += RSCanvas.indexTrack1.percentage() * 2 / 100;
            var0 += MouseInput.indexModels.percentage() * 58 / 100;
            var0 += ContextMenuRow.indexSprites.percentage() * 2 / 100;
            var0 += class64.indexTextures.percentage() * 2 / 100;
            var0 += WorldMapType2.field500.percentage() * 2 / 100;
            var0 += class35.indexTrack2.percentage() * 2 / 100;
            var0 += class1.indexScripts.percentage() * 2 / 100;
            var0 += class44.field550.percentage() * 2 / 100;
            var0 += class18.vorbisIndex.percentage() * 2 / 100;
            var0 += Player.field861.percentage() * 2 / 100;
            var0 += class46.indexWorldMap.percentage() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class91.loadingText = "Checking for updates - " + var0 + "%";
               }

               class91.loadingBarPercentage = 30;
            } else {
               class91.loadingText = "Loaded update list";
               class91.loadingBarPercentage = 30;
               Client.loadingStage = 45;
            }
         } else if(Client.loadingStage == 45) {
            Friend.method1111(22050, !Client.lowMemory, 2);
            class211 var28 = new class211();
            var28.method3865(9, 128);
            class3.soundSystem0 = Script.method1906(class277.taskManager, 0, 22050);
            class3.soundSystem0.method2094(var28);
            class61.method1051(Player.field861, class18.vorbisIndex, class47.field576, var28);
            FileOnDisk.soundSystem1 = Script.method1906(class277.taskManager, 1, 2048);
            class70.field821 = new class101();
            FileOnDisk.soundSystem1.method2094(class70.field821);
            SoundTask.field1583 = new class115(22050, AbstractSoundSystem.sampleRate);
            class91.loadingText = "Prepared sound engine";
            class91.loadingBarPercentage = 35;
            Client.loadingStage = 50;
            MouseInput.field716 = new class269(ContextMenuRow.indexSprites, class44.field550);
         } else if(Client.loadingStage == 50) {
            var0 = class268.method4912().length;
            Client.field920 = MouseInput.field716.method4914(class268.method4912());
            if(Client.field920.size() < var0) {
               class91.loadingText = "Loading fonts - " + Client.field920.size() * 100 / var0 + "%";
               class91.loadingBarPercentage = 40;
            } else {
               class13.field262 = (Font)Client.field920.get(class268.field3687);
               KeyFocusListener.font_p12full = (Font)Client.field920.get(class268.field3690);
               World.field1226 = (Font)Client.field920.get(class268.field3683);
               class256.field3447 = new MachineInfo(true);
               class91.loadingText = "Loaded fonts";
               class91.loadingBarPercentage = 40;
               Client.loadingStage = 60;
            }
         } else if(Client.loadingStage == 60) {
            var0 = class29.method242(WorldMapType2.field500, ContextMenuRow.indexSprites);
            var1 = class60.method1049();
            if(var0 < var1) {
               class91.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
               class91.loadingBarPercentage = 50;
            } else {
               class91.loadingText = "Loaded title screen";
               class91.loadingBarPercentage = 50;
               class12.setGameState(5);
               Client.loadingStage = 70;
            }
         } else if(Client.loadingStage == 70) {
            if(!Player.configsIndex.method4269()) {
               class91.loadingText = "Loading config - " + Player.configsIndex.method4379() + "%";
               class91.loadingBarPercentage = 60;
            } else {
               class163.method3185(Player.configsIndex);
               IndexData var27 = Player.configsIndex;
               class54.underlay_ref = var27;
               class250.method4477(Player.configsIndex, MouseInput.indexModels);
               IndexData var21 = Player.configsIndex;
               IndexData var22 = MouseInput.indexModels;
               boolean var24 = Client.lowMemory;
               SoundTask.objects_ref = var21;
               class54.field638 = var22;
               ObjectComposition.field3523 = var24;
               class22.method179(Player.configsIndex, MouseInput.indexModels);
               class12.method79(Player.configsIndex);
               IndexData var23 = Player.configsIndex;
               IndexData var5 = MouseInput.indexModels;
               boolean var6 = Client.isMembers;
               Font var7 = class13.field262;
               ItemComposition.item_ref = var23;
               Widget.field2858 = var5;
               MessageNode.isMembersWorld = var6;
               ItemComposition.field3559 = ItemComposition.item_ref.fileCount(10);
               class91.field1376 = var7;
               WallObject.method2995(Player.configsIndex, class163.indexInterfaces, class10.indexSoundEffects);
               IndexData var8 = Player.configsIndex;
               IndexData var9 = MouseInput.indexModels;
               Spotanim.field3404 = var8;
               Spotanim.field3394 = var9;
               class234.method4233(Player.configsIndex);
               class56.method830(Player.configsIndex);
               IndexData var10 = class45.field561;
               IndexData var11 = MouseInput.indexModels;
               IndexData var12 = ContextMenuRow.indexSprites;
               IndexData var13 = class44.field550;
               ItemContainer.widgetIndex = var10;
               class25.field348 = var11;
               class171.field2428 = var12;
               Widget.field2717 = var13;
               class11.widgets = new Widget[ItemContainer.widgetIndex.size()][];
               class56.validInterfaces = new boolean[ItemContainer.widgetIndex.size()];
               ItemComposition.method4815(Player.configsIndex);
               IndexData var14 = Player.configsIndex;
               Enum.field3475 = var14;
               IndexData var15 = Player.configsIndex;
               class250.field3387 = var15;
               class169.method3197(Player.configsIndex);
               Coordinates.method4123(Player.configsIndex);
               class28.chatMessages = new Varcs();
               class184.method3551(Player.configsIndex, ContextMenuRow.indexSprites, class44.field550);
               class168.method3196(Player.configsIndex, ContextMenuRow.indexSprites);
               IndexData var16 = Player.configsIndex;
               IndexData var17 = ContextMenuRow.indexSprites;
               Area.field3381 = var17;
               if(var16.method4269()) {
                  class171.field2431 = var16.fileCount(35);
                  Area.mapAreaType = new Area[class171.field2431];

                  for(int var18 = 0; var18 < class171.field2431; ++var18) {
                     byte[] var19 = var16.getConfigData(35, var18);
                     if(var19 != null) {
                        Area.mapAreaType[var18] = new Area(var18);
                        Area.mapAreaType[var18].method4443(new Buffer(var19));
                        Area.mapAreaType[var18].method4445();
                     }
                  }
               }

               class91.loadingText = "Loaded config";
               class91.loadingBarPercentage = 60;
               Client.loadingStage = 80;
            }
         } else if(Client.loadingStage == 80) {
            var0 = 0;
            if(class27.compass == null) {
               class27.compass = class12.method82(ContextMenuRow.indexSprites, "compass", "");
            } else {
               ++var0;
            }

            if(class3.mapedge == null) {
               class3.mapedge = class12.method82(ContextMenuRow.indexSprites, "mapedge", "");
            } else {
               ++var0;
            }

            if(class228.mapscene == null) {
               class228.mapscene = class210.method3855(ContextMenuRow.indexSprites, "mapscene", "");
            } else {
               ++var0;
            }

            if(class43.headIconsPk == null) {
               class43.headIconsPk = class46.method709(ContextMenuRow.indexSprites, "headicons_pk", "");
            } else {
               ++var0;
            }

            if(ScriptEvent.headIconsPrayer == null) {
               ScriptEvent.headIconsPrayer = class46.method709(ContextMenuRow.indexSprites, "headicons_prayer", "");
            } else {
               ++var0;
            }

            if(class33.headIconsHint == null) {
               class33.headIconsHint = class46.method709(ContextMenuRow.indexSprites, "headicons_hint", "");
            } else {
               ++var0;
            }

            if(GameEngine.mapMarkers == null) {
               GameEngine.mapMarkers = class46.method709(ContextMenuRow.indexSprites, "mapmarker", "");
            } else {
               ++var0;
            }

            if(AbstractByteBuffer.field2514 == null) {
               AbstractByteBuffer.field2514 = class46.method709(ContextMenuRow.indexSprites, "cross", "");
            } else {
               ++var0;
            }

            if(class17.mapDots == null) {
               class17.mapDots = class46.method709(ContextMenuRow.indexSprites, "mapdots", "");
            } else {
               ++var0;
            }

            if(class90.field1333 == null) {
               class90.field1333 = class210.method3855(ContextMenuRow.indexSprites, "scrollbar", "");
            } else {
               ++var0;
            }

            if(class168.field2407 == null) {
               class168.field2407 = class210.method3855(ContextMenuRow.indexSprites, "mod_icons", "");
            } else {
               ++var0;
            }

            if(var0 < 11) {
               class91.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
               class91.loadingBarPercentage = 70;
            } else {
               FontTypeFace.modIcons = class168.field2407;
               class3.mapedge.method5260();
               var1 = (int)(Math.random() * 21.0D) - 10;
               var2 = (int)(Math.random() * 21.0D) - 10;
               var3 = (int)(Math.random() * 21.0D) - 10;
               var4 = (int)(Math.random() * 41.0D) - 20;
               class228.mapscene[0].method5240(var4 + var1, var2 + var4, var4 + var3);
               class91.loadingText = "Loaded sprites";
               class91.loadingBarPercentage = 70;
               Client.loadingStage = 90;
            }
         } else if(Client.loadingStage == 90) {
            if(!class64.indexTextures.method4269()) {
               class91.loadingText = "Loading textures - " + class64.indexTextures.method4379() + "%";
               class91.loadingBarPercentage = 90;
            } else {
               TextureProvider var26 = new TextureProvider(class64.indexTextures, ContextMenuRow.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
               Graphics3D.setTextureLoader(var26);
               Graphics3D.setBrightness(0.8D);
               class91.loadingText = "Loaded textures";
               class91.loadingBarPercentage = 90;
               Client.loadingStage = 110;
            }
         } else if(Client.loadingStage == 110) {
            class269.field3696 = new class70();
            class277.taskManager.createRunnable(class269.field3696, 10);
            class91.loadingText = "Loaded input handler";
            class91.loadingBarPercentage = 92;
            Client.loadingStage = 120;
         } else if(Client.loadingStage == 120) {
            if(!WorldMapType2.field500.method4285("huffman", "")) {
               class91.loadingText = "Loading wordpack - " + 0 + "%";
               class91.loadingBarPercentage = 94;
            } else {
               Huffman var20 = new Huffman(WorldMapType2.field500.method4284("huffman", ""));
               class23.method180(var20);
               class91.loadingText = "Loaded wordpack";
               class91.loadingBarPercentage = 94;
               Client.loadingStage = 130;
            }
         } else if(Client.loadingStage == 130) {
            if(!class45.field561.method4269()) {
               class91.loadingText = "Loading interfaces - " + class45.field561.method4379() * 4 / 5 + "%";
               class91.loadingBarPercentage = 96;
            } else if(!class1.indexScripts.method4269()) {
               class91.loadingText = "Loading interfaces - " + (80 + class1.indexScripts.method4379() / 6) + "%";
               class91.loadingBarPercentage = 96;
            } else if(!class44.field550.method4269()) {
               class91.loadingText = "Loading interfaces - " + (96 + class44.field550.method4379() / 50) + "%";
               class91.loadingBarPercentage = 96;
            } else {
               class91.loadingText = "Loaded interfaces";
               class91.loadingBarPercentage = 98;
               Client.loadingStage = 140;
            }
         } else if(Client.loadingStage == 140) {
            class91.loadingBarPercentage = 100;
            if(!class46.indexWorldMap.method4286(class40.field514.field517)) {
               class91.loadingText = "Loading world map - " + class46.indexWorldMap.method4296(class40.field514.field517) / 10 + "%";
            } else {
               if(MouseInput.renderOverview == null) {
                  MouseInput.renderOverview = new RenderOverview();
                  MouseInput.renderOverview.method5500(class46.indexWorldMap, World.field1226, Client.field920, class228.mapscene);
               }

               var0 = MouseInput.renderOverview.method5394();
               if(var0 < 100) {
                  class91.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
               } else {
                  class91.loadingText = "Loaded world map";
                  Client.loadingStage = 150;
               }
            }
         } else if(Client.loadingStage == 150) {
            class12.setGameState(10);
         }
      }
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(Lfo;I)V",
      garbageValue = "1609621530"
   )
   static final void method1149(class169 var0) {
      PacketBuffer var1 = Client.field916.field1465;
      int var2;
      int var3;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var38;
      if(class169.field2408 == var0) {
         var2 = var1.readUnsignedShortOb1();
         var3 = var1.method3380();
         var38 = (var3 >> 4 & 7) + class23.field339;
         var5 = (var3 & 7) + class211.field2628;
         var6 = var1.readUnsignedByte();
         var7 = var6 >> 2;
         var8 = var6 & 3;
         var9 = Client.field929[var7];
         if(var38 >= 0 && var5 >= 0 && var38 < 104 && var5 < 104) {
            class284.method5111(class233.plane, var38, var5, var9, var2, var7, var8, 0, -1);
         }

      } else {
         int var11;
         int var12;
         int var13;
         byte var14;
         if(class169.field2410 == var0) {
            var2 = var1.method3334();
            var3 = var1.method3333();
            byte var4 = var1.readByte();
            var5 = var1.readUnsignedShortOb1();
            var6 = var1.method3457();
            var7 = var6 >> 2;
            var8 = var6 & 3;
            var9 = Client.field929[var7];
            byte var10 = var1.method3327();
            var11 = var1.method3380();
            var12 = (var11 >> 4 & 7) + class23.field339;
            var13 = (var11 & 7) + class211.field2628;
            var14 = var1.method3328();
            int var15 = var1.readUnsignedShortOb1();
            byte var16 = var1.method3329();
            Player var17;
            if(var3 == Client.localInteractingIndex) {
               var17 = class181.localPlayer;
            } else {
               var17 = Client.cachedPlayers[var3];
            }

            if(var17 != null) {
               ObjectComposition var18 = class3.getObjectDefinition(var15);
               int var19;
               int var20;
               if(var8 != 1 && var8 != 3) {
                  var19 = var18.sizeX;
                  var20 = var18.sizeY;
               } else {
                  var19 = var18.sizeY;
                  var20 = var18.sizeX;
               }

               int var21 = var12 + (var19 >> 1);
               int var22 = var12 + (var19 + 1 >> 1);
               int var23 = var13 + (var20 >> 1);
               int var24 = var13 + (var20 + 1 >> 1);
               int[][] var25 = class61.tileHeights[class233.plane];
               int var26 = var25[var22][var24] + var25[var22][var23] + var25[var21][var23] + var25[var21][var24] >> 2;
               int var27 = (var12 << 7) + (var19 << 6);
               int var28 = (var13 << 7) + (var20 << 6);
               Model var29 = var18.method4699(var7, var8, var25, var27, var26, var28);
               if(var29 != null) {
                  class284.method5111(class233.plane, var12, var13, var9, -1, 0, 0, var2 + 1, var5 + 1);
                  var17.field848 = var2 + Client.gameCycle;
                  var17.field844 = var5 + Client.gameCycle;
                  var17.model = var29;
                  var17.field845 = var12 * 128 + var19 * 64;
                  var17.field847 = var13 * 128 + var20 * 64;
                  var17.field846 = var26;
                  byte var30;
                  if(var16 > var4) {
                     var30 = var16;
                     var16 = var4;
                     var4 = var30;
                  }

                  if(var10 > var14) {
                     var30 = var10;
                     var10 = var14;
                     var14 = var30;
                  }

                  var17.field849 = var12 + var16;
                  var17.field851 = var12 + var4;
                  var17.field850 = var13 + var10;
                  var17.field852 = var13 + var14;
               }
            }
         }

         int var39;
         if(class169.field2417 == var0) {
            byte var37 = var1.method3328();
            var3 = var1.readShort();
            var38 = var1.method3334();
            var5 = var1.method3334();
            var6 = var1.readUnsignedShort();
            var7 = var1.method3380();
            var8 = (var7 >> 4 & 7) + class23.field339;
            var9 = (var7 & 7) + class211.field2628;
            var39 = var1.method3422() * 4;
            var11 = var1.method3422();
            var12 = var1.method3457() * 4;
            var13 = var1.method3422();
            var14 = var1.method3328();
            int var40 = var14 + var8;
            var2 = var37 + var9;
            if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104 && var40 >= 0 && var2 >= 0 && var40 < 104 && var2 < 104 && var38 != 65535) {
               var8 = var8 * 128 + 64;
               var9 = var9 * 128 + 64;
               var40 = var40 * 128 + 64;
               var2 = var2 * 128 + 64;
               Projectile var31 = new Projectile(var38, class233.plane, var8, var9, class41.getTileHeight(var8, var9, class233.plane) - var12, var5 + Client.gameCycle, var6 + Client.gameCycle, var13, var11, var3, var39);
               var31.method1816(var40, var2, class41.getTileHeight(var40, var2, class233.plane) - var39, var5 + Client.gameCycle);
               Client.projectiles.addFront(var31);
            }

         } else if(class169.field2411 == var0) {
            var2 = var1.method3334();
            var3 = var1.method3380();
            var38 = (var3 >> 4 & 7) + class23.field339;
            var5 = (var3 & 7) + class211.field2628;
            var6 = var1.method3334();
            var7 = var1.method3334();
            if(var38 >= 0 && var5 >= 0 && var38 < 104 && var5 < 104) {
               Deque var41 = Client.groundItemDeque[class233.plane][var38][var5];
               if(var41 != null) {
                  for(Item var33 = (Item)var41.getFront(); var33 != null; var33 = (Item)var41.getNext()) {
                     if((var2 & 32767) == var33.id && var7 == var33.quantity) {
                        var33.quantity = var6;
                        break;
                     }
                  }

                  class139.groundItemSpawned(var38, var5);
               }
            }

         } else if(class169.field2412 == var0) {
            var2 = var1.method3334();
            var3 = var1.method3380();
            var38 = var1.readUnsignedByte();
            var5 = (var38 >> 4 & 7) + class23.field339;
            var6 = (var38 & 7) + class211.field2628;
            var7 = var1.method3334();
            if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               var5 = var5 * 128 + 64;
               var6 = var6 * 128 + 64;
               GraphicsObject var32 = new GraphicsObject(var2, class233.plane, var5, var6, class41.getTileHeight(var5, var6, class233.plane) - var3, var7, Client.gameCycle);
               Client.graphicsObjectDeque.addFront(var32);
            }

         } else {
            if(class169.field2416 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = var1.method3333();
               var38 = var1.readUnsignedByte();
               var5 = var38 >> 4 & 15;
               var6 = var38 & 7;
               var7 = var1.method3457();
               var8 = (var7 >> 4 & 7) + class23.field339;
               var9 = (var7 & 7) + class211.field2628;
               if(var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
                  var39 = var5 + 1;
                  if(class181.localPlayer.pathX[0] >= var8 - var39 && class181.localPlayer.pathX[0] <= var8 + var39 && class181.localPlayer.pathY[0] >= var9 - var39 && class181.localPlayer.pathY[0] <= var9 + var39 && Client.field1093 != 0 && var6 > 0 && Client.field985 < 50) {
                     Client.field970[Client.field985] = var3;
                     Client.field1096[Client.field985] = var6;
                     Client.field930[Client.field985] = var2;
                     Client.audioEffects[Client.field985] = null;
                     Client.field1098[Client.field985] = var5 + (var9 << 8) + (var8 << 16);
                     ++Client.field985;
                  }
               }
            }

            if(class169.field2409 == var0) {
               var2 = var1.readUnsignedShortOb1();
               var3 = var1.readUnsignedByte();
               var38 = var3 >> 2;
               var5 = var3 & 3;
               var6 = Client.field929[var38];
               var7 = var1.readUnsignedByte();
               var8 = (var7 >> 4 & 7) + class23.field339;
               var9 = (var7 & 7) + class211.field2628;
               if(var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
                  if(var6 == 0) {
                     WallObject var34 = class14.region.method2819(class233.plane, var8, var9);
                     if(var34 != null) {
                        var11 = var34.hash >> 14 & 32767;
                        if(var38 == 2) {
                           var34.renderable1 = new DynamicObject(var11, 2, var5 + 4, class233.plane, var8, var9, var2, false, var34.renderable1);
                           var34.renderable2 = new DynamicObject(var11, 2, var5 + 1 & 3, class233.plane, var8, var9, var2, false, var34.renderable2);
                        } else {
                           var34.renderable1 = new DynamicObject(var11, var38, var5, class233.plane, var8, var9, var2, false, var34.renderable1);
                        }
                     }
                  }

                  if(var6 == 1) {
                     DecorativeObject var42 = class14.region.method2820(class233.plane, var8, var9);
                     if(var42 != null) {
                        var11 = var42.hash >> 14 & 32767;
                        if(var38 != 4 && var38 != 5) {
                           if(var38 == 6) {
                              var42.renderable1 = new DynamicObject(var11, 4, var5 + 4, class233.plane, var8, var9, var2, false, var42.renderable1);
                           } else if(var38 == 7) {
                              var42.renderable1 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, class233.plane, var8, var9, var2, false, var42.renderable1);
                           } else if(var38 == 8) {
                              var42.renderable1 = new DynamicObject(var11, 4, var5 + 4, class233.plane, var8, var9, var2, false, var42.renderable1);
                              var42.renderable2 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, class233.plane, var8, var9, var2, false, var42.renderable2);
                           }
                        } else {
                           var42.renderable1 = new DynamicObject(var11, 4, var5, class233.plane, var8, var9, var2, false, var42.renderable1);
                        }
                     }
                  }

                  if(var6 == 2) {
                     GameObject var43 = class14.region.method2851(class233.plane, var8, var9);
                     if(var38 == 11) {
                        var38 = 10;
                     }

                     if(var43 != null) {
                        var43.renderable = new DynamicObject(var43.hash >> 14 & 32767, var38, var5, class233.plane, var8, var9, var2, false, var43.renderable);
                     }
                  }

                  if(var6 == 3) {
                     GroundObject var44 = class14.region.method2824(class233.plane, var8, var9);
                     if(var44 != null) {
                        var44.renderable = new DynamicObject(var44.hash >> 14 & 32767, 22, var5, class233.plane, var8, var9, var2, false, var44.renderable);
                     }
                  }
               }

            } else {
               Item var36;
               if(class169.field2414 != var0) {
                  if(class169.field2413 == var0) {
                     var2 = var1.method3334();
                     var3 = var1.method3380();
                     var38 = (var3 >> 4 & 7) + class23.field339;
                     var5 = (var3 & 7) + class211.field2628;
                     var6 = var1.method3333();
                     if(var38 >= 0 && var5 >= 0 && var38 < 104 && var5 < 104) {
                        var36 = new Item();
                        var36.id = var2;
                        var36.quantity = var6;
                        if(Client.groundItemDeque[class233.plane][var38][var5] == null) {
                           Client.groundItemDeque[class233.plane][var38][var5] = new Deque();
                        }

                        Client.groundItemDeque[class233.plane][var38][var5].addFront(var36);
                        class139.groundItemSpawned(var38, var5);
                     }

                  } else if(class169.field2415 == var0) {
                     var2 = var1.readUnsignedByte();
                     var3 = var2 >> 2;
                     var38 = var2 & 3;
                     var5 = Client.field929[var3];
                     var6 = var1.readUnsignedByte();
                     var7 = (var6 >> 4 & 7) + class23.field339;
                     var8 = (var6 & 7) + class211.field2628;
                     if(var7 >= 0 && var8 >= 0 && var7 < 104 && var8 < 104) {
                        class284.method5111(class233.plane, var7, var8, var5, -1, var3, var38, 0, -1);
                     }

                  }
               } else {
                  var2 = var1.method3380();
                  var3 = (var2 >> 4 & 7) + class23.field339;
                  var38 = (var2 & 7) + class211.field2628;
                  var5 = var1.readUnsignedShortOb1();
                  if(var3 >= 0 && var38 >= 0 && var3 < 104 && var38 < 104) {
                     Deque var35 = Client.groundItemDeque[class233.plane][var3][var38];
                     if(var35 != null) {
                        for(var36 = (Item)var35.getFront(); var36 != null; var36 = (Item)var35.getNext()) {
                           if((var5 & 32767) == var36.id) {
                              var36.unlink();
                              break;
                           }
                        }

                        if(var35.getFront() == null) {
                           Client.groundItemDeque[class233.plane][var3][var38] = null;
                        }

                        class139.groundItemSpawned(var3, var38);
                     }
                  }

               }
            }
         }
      }
   }
}
