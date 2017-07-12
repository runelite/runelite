import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public final class class60 {
   @ObfuscatedName("z")
   static Widget field766;
   @ObfuscatedName("ge")
   @ObfuscatedGetter(
      intValue = 1742632731
   )
   @Export("cameraZ")
   static int cameraZ;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "40"
   )
   public static int method1047() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class2.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         MouseInput.field758 = new SpritePixels(512, 512);
         class92.loadingText = "Starting game engine...";
         class92.loadingBarPercentage = 5;
         Client.loadingStage = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.loadingStage != 20) {
            if(Client.loadingStage == 30) {
               class44.indexInterfaces = RSCanvas.openCacheIndex(0, false, true, true);
               class261.indexSoundEffects = RSCanvas.openCacheIndex(1, false, true, true);
               class91.configsIndex = RSCanvas.openCacheIndex(2, true, false, true);
               class10.field259 = RSCanvas.openCacheIndex(3, false, true, true);
               class98.field1545 = RSCanvas.openCacheIndex(4, false, true, true);
               Frames.indexMaps = RSCanvas.openCacheIndex(5, true, true, true);
               class44.indexTrack1 = RSCanvas.openCacheIndex(6, true, true, false);
               class1.indexModels = RSCanvas.openCacheIndex(7, false, true, true);
               class18.indexSprites = RSCanvas.openCacheIndex(8, false, true, true);
               class87.indexTextures = RSCanvas.openCacheIndex(9, false, true, true);
               DecorativeObject.field2194 = RSCanvas.openCacheIndex(10, false, true, true);
               XGrandExchangeOffer.indexTrack2 = RSCanvas.openCacheIndex(11, false, true, true);
               class169.indexScripts = RSCanvas.openCacheIndex(12, false, true, true);
               RSCanvas.field693 = RSCanvas.openCacheIndex(13, true, false, true);
               class12.vorbisIndex = RSCanvas.openCacheIndex(14, false, true, false);
               class28.field424 = RSCanvas.openCacheIndex(15, false, true, true);
               class61.indexWorldMap = RSCanvas.openCacheIndex(16, false, true, false);
               class92.loadingText = "Connecting to update server";
               class92.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var5 = 0;
               var0 = var5 + class44.indexInterfaces.percentage() * 4 / 100;
               var0 += class261.indexSoundEffects.percentage() * 4 / 100;
               var0 += class91.configsIndex.percentage() * 2 / 100;
               var0 += class10.field259.percentage() * 2 / 100;
               var0 += class98.field1545.percentage() * 6 / 100;
               var0 += Frames.indexMaps.percentage() * 4 / 100;
               var0 += class44.indexTrack1.percentage() * 2 / 100;
               var0 += class1.indexModels.percentage() * 58 / 100;
               var0 += class18.indexSprites.percentage() * 2 / 100;
               var0 += class87.indexTextures.percentage() * 2 / 100;
               var0 += DecorativeObject.field2194.percentage() * 2 / 100;
               var0 += XGrandExchangeOffer.indexTrack2.percentage() * 2 / 100;
               var0 += class169.indexScripts.percentage() * 2 / 100;
               var0 += RSCanvas.field693.percentage() * 2 / 100;
               var0 += class12.vorbisIndex.percentage() * 2 / 100;
               var0 += class28.field424.percentage() * 2 / 100;
               var0 += class61.indexWorldMap.percentage() * 2 / 100;
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
            } else if(Client.loadingStage == 45) {
               boolean var23 = !Client.lowMemory;
               FileSystem.sampleRate = 22050;
               AbstractSoundSystem.highMemory = var23;
               AbstractSoundSystem.priority = 2;
               class204 var6 = new class204();
               var6.method3675(9, 128);
               FrameMap.soundSystem0 = class25.method166(GameEngine.taskManager, 0, 22050);
               FrameMap.soundSystem0.method2021(var6);
               class33.method348(class28.field424, class12.vorbisIndex, class98.field1545, var6);
               MouseInput.soundSystem1 = class25.method166(GameEngine.taskManager, 1, 2048);
               class19.field328 = new class102();
               MouseInput.soundSystem1.method2021(class19.field328);
               class225.field2896 = new class116(22050, FileSystem.sampleRate);
               class92.loadingText = "Prepared sound engine";
               class92.loadingBarPercentage = 35;
               Client.loadingStage = 50;
               XGrandExchangeOffer.field313 = new class262(class18.indexSprites, RSCanvas.field693);
            } else if(Client.loadingStage == 50) {
               class261[] var24 = new class261[]{class261.field3629, class261.field3628, class261.field3624, class261.field3634, class261.field3635, class261.field3633};
               var1 = var24.length;
               class262 var26 = XGrandExchangeOffer.field313;
               class261[] var7 = new class261[]{class261.field3629, class261.field3628, class261.field3624, class261.field3634, class261.field3635, class261.field3633};
               Client.field1134 = var26.method4737(var7);
               if(Client.field1134.size() < var1) {
                  class92.loadingText = "Loading fonts - " + Client.field1134.size() * 100 / var1 + "%";
                  class92.loadingBarPercentage = 40;
               } else {
                  class45.field618 = (Font)Client.field1134.get(class261.field3634);
                  class37.font_p12full = (Font)Client.field1134.get(class261.field3633);
                  World.field1322 = (Font)Client.field1134.get(class261.field3624);
                  Ignore.field866 = new MachineInfo(true);
                  class92.loadingText = "Loaded fonts";
                  class92.loadingBarPercentage = 40;
                  Client.loadingStage = 60;
               }
            } else if(Client.loadingStage == 60) {
               var0 = DecorativeObject.method2889(DecorativeObject.field2194, class18.indexSprites);
               var1 = class96.method1801();
               if(var0 < var1) {
                  class92.loadingText = "Loading title screen - " + var0 * 100 / var1 + "%";
                  class92.loadingBarPercentage = 50;
               } else {
                  class92.loadingText = "Loaded title screen";
                  class92.loadingBarPercentage = 50;
                  TextureProvider.setGameState(5);
                  Client.loadingStage = 70;
               }
            } else if(Client.loadingStage == 70) {
               if(!class91.configsIndex.method4111()) {
                  class92.loadingText = "Loading config - " + class91.configsIndex.method4234() + "%";
                  class92.loadingBarPercentage = 60;
               } else {
                  class89.method1721(class91.configsIndex);
                  class5.method21(class91.configsIndex);
                  IndexData var25 = class91.configsIndex;
                  IndexData var28 = class1.indexModels;
                  KitDefinition.identKit_ref = var25;
                  KitDefinition.field3357 = var28;
                  KitDefinition.field3359 = KitDefinition.identKit_ref.fileCount(3);
                  Area.method4312(class91.configsIndex, class1.indexModels, Client.lowMemory);
                  IndexData var31 = class91.configsIndex;
                  IndexData var8 = class1.indexModels;
                  NPCComposition.field3567 = var31;
                  NPCComposition.field3584 = var8;
                  IndexData var9 = class91.configsIndex;
                  class252.field3406 = var9;
                  class170.method3116(class91.configsIndex, class1.indexModels, Client.isMembers, class45.field618);
                  Huffman.method3060(class91.configsIndex, class44.indexInterfaces, class261.indexSoundEffects);
                  IndexData var10 = class91.configsIndex;
                  IndexData var11 = class1.indexModels;
                  Spotanim.field3347 = var10;
                  Spotanim.field3338 = var11;
                  IndexData var12 = class91.configsIndex;
                  Varbit.varbit_ref = var12;
                  IndexData var13 = class91.configsIndex;
                  VarPlayerType.varplayer_ref = var13;
                  VarPlayerType.field3289 = VarPlayerType.varplayer_ref.fileCount(16);
                  IndexData var14 = class10.field259;
                  IndexData var15 = class1.indexModels;
                  IndexData var16 = class18.indexSprites;
                  IndexData var17 = RSCanvas.field693;
                  Widget.widgetIndex = var14;
                  Widget.field2750 = var15;
                  CollisionData.field2309 = var16;
                  GroundObject.field1876 = var17;
                  class46.widgets = new Widget[Widget.widgetIndex.size()][];
                  class152.validInterfaces = new boolean[Widget.widgetIndex.size()];
                  IndexData var18 = class91.configsIndex;
                  InvType.field3285 = var18;
                  class175.method3347(class91.configsIndex);
                  AbstractSoundSystem.method2064(class91.configsIndex);
                  class175.method3346(class91.configsIndex);
                  IndexData var19 = class91.configsIndex;
                  class251.field3399 = var19;
                  class71.chatMessages = new Varcs();
                  IndexData var20 = class91.configsIndex;
                  IndexData var21 = class18.indexSprites;
                  IndexData var22 = RSCanvas.field693;
                  class254.field3441 = var20;
                  class254.field3419 = var21;
                  class215.field2639 = var22;
                  Player.method1178(class91.configsIndex, class18.indexSprites);
                  class31.method269(class91.configsIndex, class18.indexSprites);
                  class92.loadingText = "Loaded config";
                  class92.loadingBarPercentage = 60;
                  Client.loadingStage = 80;
               }
            } else if(Client.loadingStage == 80) {
               var0 = 0;
               if(class19.compass == null) {
                  class19.compass = class12.method59(class18.indexSprites, "compass", "");
               } else {
                  ++var0;
               }

               if(class31.mapedge == null) {
                  class31.mapedge = class12.method59(class18.indexSprites, "mapedge", "");
               } else {
                  ++var0;
               }

               if(class8.field246 == null) {
                  class8.field246 = class64.method1117(class18.indexSprites, "mapscene", "");
               } else {
                  ++var0;
               }

               if(class182.mapfunctions == null) {
                  class182.mapfunctions = class2.method8(class18.indexSprites, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(Friend.hitmarks == null) {
                  Friend.hitmarks = class2.method8(class18.indexSprites, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class43.pkIcons == null) {
                  class43.pkIcons = class2.method8(class18.indexSprites, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(class31.field458 == null) {
                  class31.field458 = class2.method8(class18.indexSprites, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(IndexData.field3258 == null) {
                  IndexData.field3258 = class2.method8(class18.indexSprites, "cross", "");
               } else {
                  ++var0;
               }

               if(WorldMapType3.mapDots == null) {
                  WorldMapType3.mapDots = class2.method8(class18.indexSprites, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class262.field3639 == null) {
                  class262.field3639 = class64.method1117(class18.indexSprites, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(class22.field346 == null) {
                  class22.field346 = class64.method1117(class18.indexSprites, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 11) {
                  class92.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class92.loadingBarPercentage = 70;
               } else {
                  FontTypeFace.modIcons = class22.field346;
                  class31.mapedge.method5043();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class8.field246[0].method5024(var4 + var1, var2 + var4, var3 + var4);
                  class92.loadingText = "Loaded sprites";
                  class92.loadingBarPercentage = 70;
                  Client.loadingStage = 90;
               }
            } else if(Client.loadingStage == 90) {
               if(!class87.indexTextures.method4111()) {
                  class92.loadingText = "Loading textures - " + class87.indexTextures.method4234() + "%";
                  class92.loadingBarPercentage = 90;
               } else {
                  TextureProvider var27 = new TextureProvider(class87.indexTextures, class18.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                  Graphics3D.setTextureLoader(var27);
                  Graphics3D.setBrightness(0.8D);
                  class92.loadingText = "Loaded textures";
                  class92.loadingBarPercentage = 90;
                  Client.loadingStage = 110;
               }
            } else if(Client.loadingStage == 110) {
               WorldMapType3.field393 = new class71();
               GameEngine.taskManager.createRunnable(WorldMapType3.field393, 10);
               class92.loadingText = "Loaded input handler";
               class92.loadingBarPercentage = 94;
               Client.loadingStage = 120;
            } else if(Client.loadingStage == 120) {
               if(!DecorativeObject.field2194.method4134("huffman", "")) {
                  class92.loadingText = "Loading wordpack - 0%";
                  class92.loadingBarPercentage = 96;
               } else {
                  Huffman var29 = new Huffman(DecorativeObject.field2194.method4145("huffman", ""));
                  class265.field3665 = var29;
                  class92.loadingText = "Loaded wordpack";
                  class92.loadingBarPercentage = 96;
                  Client.loadingStage = 130;
               }
            } else if(Client.loadingStage == 130) {
               if(!class10.field259.method4111()) {
                  class92.loadingText = "Loading interfaces - " + class10.field259.method4234() * 4 / 5 + "%";
                  class92.loadingBarPercentage = 100;
               } else if(!class169.indexScripts.method4111()) {
                  class92.loadingText = "Loading interfaces - " + (80 + class169.indexScripts.method4234() / 6) + "%";
                  class92.loadingBarPercentage = 100;
               } else if(!RSCanvas.field693.method4111()) {
                  class92.loadingText = "Loading interfaces - " + (96 + RSCanvas.field693.method4234() / 50) + "%";
                  class92.loadingBarPercentage = 100;
               } else {
                  class92.loadingText = "Loaded interfaces";
                  class92.loadingBarPercentage = 98;
                  Client.loadingStage = 140;
               }
            } else if(Client.loadingStage == 140) {
               if(!class61.indexWorldMap.method4135(class40.field564.field566)) {
                  class92.loadingText = "Loading world map - " + class61.indexWorldMap.method4118(class40.field564.field566) / 10 + "%";
               } else {
                  if(class43.renderOverview == null) {
                     class43.renderOverview = new RenderOverview();
                     class43.renderOverview.method5298(class61.indexWorldMap, World.field1322, Client.field1134, class8.field246);
                  }

                  var0 = class43.renderOverview.method5180();
                  if(var0 < 100) {
                     class92.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                  } else {
                     class92.loadingText = "Loaded world map";
                     class92.loadingBarPercentage = 100;
                     Client.loadingStage = 150;
                  }
               }
            } else if(Client.loadingStage == 150) {
               TextureProvider.setGameState(10);
            }
         } else {
            int[] var30 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = var2 * 3 + 600;
               var4 = Graphics3D.SINE[var2];
               var30[var1] = var3 * var4 >> 16;
            }

            Region.method2701(var30, 500, 800, 512, 334);
            class92.loadingText = "Prepared visibility map";
            class92.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }

   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "833525561"
   )
   static void method1051(int var0, String var1) {
      int var2 = class96.field1521;
      int[] var3 = class96.field1531;
      boolean var4 = false;

      for(int var5 = 0; var5 < var2; ++var5) {
         Player var6 = Client.cachedPlayers[var3[var5]];
         if(var6 != null && var6 != XItemContainer.localPlayer && var6.name != null && var6.name.equalsIgnoreCase(var1)) {
            if(var0 == 1) {
               Client.secretPacketBuffer1.putOpcode(68);
               Client.secretPacketBuffer1.putShortOb2(var3[var5]);
               Client.secretPacketBuffer1.putShortLE(0);
            } else if(var0 == 4) {
               Client.secretPacketBuffer1.putOpcode(191);
               Client.secretPacketBuffer1.putShort(var3[var5]);
               Client.secretPacketBuffer1.putShortLE(0);
            } else if(var0 == 6) {
               Client.secretPacketBuffer1.putOpcode(186);
               Client.secretPacketBuffer1.putShortLE(0);
               Client.secretPacketBuffer1.putShort(var3[var5]);
            } else if(var0 == 7) {
               Client.secretPacketBuffer1.putOpcode(204);
               Client.secretPacketBuffer1.putShortLE(0);
               Client.secretPacketBuffer1.putLEShortA(var3[var5]);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         class152.sendGameMessage(4, "", "Unable to find " + var1);
      }

   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;S)V",
      garbageValue = "-20773"
   )
   static void method1052(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class202.method3650(var1, var2);
      if(var5 != null) {
         if(var5.field2754 != null) {
            ScriptEvent var6 = new ScriptEvent();
            var6.widget = var5;
            var6.field852 = var0;
            var6.field856 = var4;
            var6.field857 = var5.field2754;
            class14.method76(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = class7.method39(var5);
         }

         if(var10) {
            int var7 = WorldMapType3.getWidgetConfig(var5);
            int var8 = var0 - 1;
            boolean var9 = (var7 >> var8 + 1 & 1) != 0;
            if(var9) {
               if(var0 == 1) {
                  Client.secretPacketBuffer1.putOpcode(78);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 2) {
                  Client.secretPacketBuffer1.putOpcode(218);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 3) {
                  Client.secretPacketBuffer1.putOpcode(216);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 4) {
                  Client.secretPacketBuffer1.putOpcode(169);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 5) {
                  Client.secretPacketBuffer1.putOpcode(104);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 6) {
                  Client.secretPacketBuffer1.putOpcode(228);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 7) {
                  Client.secretPacketBuffer1.putOpcode(244);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 8) {
                  Client.secretPacketBuffer1.putOpcode(190);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 9) {
                  Client.secretPacketBuffer1.putOpcode(35);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 10) {
                  Client.secretPacketBuffer1.putOpcode(91);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "592806910"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + TextureProvider.method2403(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1619448000"
   )
   static void method1055() {
      Client.menuOptionCount = 0;
      Client.field1074 = -1;
      Client.isMenuOpen = false;
   }
}
