import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
public class class96 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -413649587
   )
   static int field1510;
   @ObfuscatedName("d")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   static final IterableHashTable field1508;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static final class201 field1509;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   public static CacheFile[] field1514;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 83875549
   )
   static int field1517;

   static {
      chatLineMap = new HashMap();
      field1508 = new IterableHashTable(1024);
      field1509 = new class201();
      field1510 = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1997223360"
   )
   static boolean method1913(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   @Export("load")
   static void load() {
      int var0;
      if(Client.loadingStage == 0) {
         class8.region = new Region(4, 104, 104, class61.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         BaseVarType.field33 = new SpritePixels(512, 512);
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
               class64.indexInterfaces = class203.openCacheIndex(0, false, true, true);
               Varcs.indexSoundEffects = class203.openCacheIndex(1, false, true, true);
               FaceNormal.configsIndex = class203.openCacheIndex(2, true, false, true);
               ClanMember.field918 = class203.openCacheIndex(3, false, true, true);
               BaseVarType.field34 = class203.openCacheIndex(4, false, true, true);
               class226.indexMaps = class203.openCacheIndex(5, true, true, true);
               class268.indexTrack1 = class203.openCacheIndex(6, true, true, false);
               GraphicsObject.indexModels = class203.openCacheIndex(7, false, true, true);
               class37.indexSprites = class203.openCacheIndex(8, false, true, true);
               class8.indexTextures = class203.openCacheIndex(9, false, true, true);
               Client.field1193 = class203.openCacheIndex(10, false, true, true);
               Renderable.indexTrack2 = class203.openCacheIndex(11, false, true, true);
               class51.indexScripts = class203.openCacheIndex(12, false, true, true);
               class31.field458 = class203.openCacheIndex(13, true, false, true);
               KeyFocusListener.vorbisIndex = class203.openCacheIndex(14, false, true, false);
               class54.field686 = class203.openCacheIndex(15, false, true, true);
               class41.indexWorldMap = class203.openCacheIndex(16, false, true, false);
               class90.loadingText = "Connecting to update server";
               class90.loadingBarPercentage = 20;
               Client.loadingStage = 40;
            } else if(Client.loadingStage == 40) {
               byte var30 = 0;
               var0 = var30 + class64.indexInterfaces.percentage() * 4 / 100;
               var0 += Varcs.indexSoundEffects.percentage() * 4 / 100;
               var0 += FaceNormal.configsIndex.percentage() * 2 / 100;
               var0 += ClanMember.field918.percentage() * 2 / 100;
               var0 += BaseVarType.field34.percentage() * 6 / 100;
               var0 += class226.indexMaps.percentage() * 4 / 100;
               var0 += class268.indexTrack1.percentage() * 2 / 100;
               var0 += GraphicsObject.indexModels.percentage() * 58 / 100;
               var0 += class37.indexSprites.percentage() * 2 / 100;
               var0 += class8.indexTextures.percentage() * 2 / 100;
               var0 += Client.field1193.percentage() * 2 / 100;
               var0 += Renderable.indexTrack2.percentage() * 2 / 100;
               var0 += class51.indexScripts.percentage() * 2 / 100;
               var0 += class31.field458.percentage() * 2 / 100;
               var0 += KeyFocusListener.vorbisIndex.percentage() * 2 / 100;
               var0 += class54.field686.percentage() * 2 / 100;
               var0 += class41.indexWorldMap.percentage() * 2 / 100;
               if(var0 != 100) {
                  if(var0 != 0) {
                     class90.loadingText = "Checking for updates - " + var0 + "%";
                  }

                  class90.loadingBarPercentage = 30;
               } else {
                  class90.loadingText = "Loaded update list";
                  class90.loadingBarPercentage = 30;
                  Client.loadingStage = 45;
               }
            } else {
               IndexData var25;
               IndexData var26;
               IndexData var27;
               if(Client.loadingStage == 45) {
                  boolean var29 = !Client.lowMemory;
                  class31.sampleRate = 22050;
                  class33.highMemory = var29;
                  class17.priority = 2;
                  class204 var34 = new class204();
                  var34.method3805(9, 128);
                  class1.soundSystem0 = class162.method3142(GameEngine.taskManager, 0, 22050);
                  class1.soundSystem0.method2107(var34);
                  var25 = class54.field686;
                  var26 = KeyFocusListener.vorbisIndex;
                  var27 = BaseVarType.field34;
                  class203.field2518 = var25;
                  class203.field2519 = var26;
                  class203.field2517 = var27;
                  class203.field2523 = var34;
                  class40.soundSystem1 = class162.method3142(GameEngine.taskManager, 1, 2048);
                  CombatInfoListHolder.field1364 = new class100();
                  class40.soundSystem1.method2107(CombatInfoListHolder.field1364);
                  Renderable.field2113 = new class114(22050, class31.sampleRate);
                  class90.loadingText = "Prepared sound engine";
                  class90.loadingBarPercentage = 35;
                  Client.loadingStage = 50;
                  ItemContainer.field799 = new class262(class37.indexSprites, class31.field458);
               } else if(Client.loadingStage == 50) {
                  var0 = class261.method4816().length;
                  Client.field932 = ItemContainer.field799.method4822(class261.method4816());
                  if(Client.field932.size() < var0) {
                     class90.loadingText = "Loading fonts - " + Client.field932.size() * 100 / var0 + "%";
                     class90.loadingBarPercentage = 40;
                  } else {
                     class9.field257 = (Font)Client.field932.get(class261.field3628);
                     class20.font_p12full = (Font)Client.field932.get(class261.field3624);
                     Friend.field827 = (Font)Client.field932.get(class261.field3625);
                     WorldMapType3.field378 = new MachineInfo(true);
                     class90.loadingText = "Loaded fonts";
                     class90.loadingBarPercentage = 40;
                     Client.loadingStage = 60;
                  }
               } else {
                  IndexData var24;
                  if(Client.loadingStage == 60) {
                     var24 = Client.field1193;
                     var25 = class37.indexSprites;
                     var3 = 0;
                     if(var24.method4238("title.jpg", "")) {
                        ++var3;
                     }

                     if(var25.method4238("logo", "")) {
                        ++var3;
                     }

                     if(var25.method4238("logo_deadman_mode", "")) {
                        ++var3;
                     }

                     if(var25.method4238("titlebox", "")) {
                        ++var3;
                     }

                     if(var25.method4238("titlebutton", "")) {
                        ++var3;
                     }

                     if(var25.method4238("runes", "")) {
                        ++var3;
                     }

                     if(var25.method4238("title_mute", "")) {
                        ++var3;
                     }

                     if(var25.method4238("options_radio_buttons,0", "")) {
                        ++var3;
                     }

                     if(var25.method4238("options_radio_buttons,2", "")) {
                        ++var3;
                     }

                     if(var25.method4238("options_radio_buttons,4", "")) {
                        ++var3;
                     }

                     if(var25.method4238("options_radio_buttons,6", "")) {
                        ++var3;
                     }

                     var25.method4238("sl_back", "");
                     var25.method4238("sl_flags", "");
                     var25.method4238("sl_arrows", "");
                     var25.method4238("sl_stars", "");
                     var25.method4238("sl_button", "");
                     byte var28 = 11;
                     if(var3 < var28) {
                        class90.loadingText = "Loading title screen - " + var3 * 100 / var28 + "%";
                        class90.loadingBarPercentage = 50;
                     } else {
                        class90.loadingText = "Loaded title screen";
                        class90.loadingBarPercentage = 50;
                        FrameMap.setGameState(5);
                        Client.loadingStage = 70;
                     }
                  } else if(Client.loadingStage == 70) {
                     if(!FaceNormal.configsIndex.method4292()) {
                        class90.loadingText = "Loading config - " + FaceNormal.configsIndex.method4322() + "%";
                        class90.loadingBarPercentage = 60;
                     } else {
                        Huffman.method3169(FaceNormal.configsIndex);
                        IndexData var33 = FaceNormal.configsIndex;
                        FloorUnderlayDefinition.underlay_ref = var33;
                        var24 = FaceNormal.configsIndex;
                        var25 = GraphicsObject.indexModels;
                        KitDefinition.identKit_ref = var24;
                        KitDefinition.field3349 = var25;
                        KitDefinition.field3350 = KitDefinition.identKit_ref.fileCount(3);
                        class2.method9(FaceNormal.configsIndex, GraphicsObject.indexModels, Client.lowMemory);
                        Projectile.method1826(FaceNormal.configsIndex, GraphicsObject.indexModels);
                        class208.method4010(FaceNormal.configsIndex);
                        var26 = FaceNormal.configsIndex;
                        var27 = GraphicsObject.indexModels;
                        boolean var5 = Client.isMembers;
                        Font var6 = class9.field257;
                        class15.item_ref = var26;
                        class89.field1406 = var27;
                        class46.isMembersWorld = var5;
                        class226.field3144 = class15.item_ref.fileCount(10);
                        ItemComposition.field3488 = var6;
                        IndexData var7 = FaceNormal.configsIndex;
                        IndexData var8 = class64.indexInterfaces;
                        IndexData var9 = Varcs.indexSoundEffects;
                        Sequence.seq_ref = var7;
                        Sequence.skel_ref = var8;
                        Sequence.skin_ref = var9;
                        GameEngine.method1029(FaceNormal.configsIndex, GraphicsObject.indexModels);
                        IndexData var10 = FaceNormal.configsIndex;
                        Varbit.varbit_ref = var10;
                        class94.method1859(FaceNormal.configsIndex);
                        IndexData var11 = ClanMember.field918;
                        IndexData var12 = GraphicsObject.indexModels;
                        IndexData var13 = class37.indexSprites;
                        IndexData var14 = class31.field458;
                        FrameMap.widgetIndex = var11;
                        Widget.field2782 = var12;
                        Widget.field2681 = var13;
                        Widget.field2651 = var14;
                        class177.widgets = new Widget[FrameMap.widgetIndex.size()][];
                        Widget.validInterfaces = new boolean[FrameMap.widgetIndex.size()];
                        ChatLineBuffer.method1936(FaceNormal.configsIndex);
                        IndexData var15 = FaceNormal.configsIndex;
                        Enum.field3405 = var15;
                        IndexData var16 = FaceNormal.configsIndex;
                        class243.field3311 = var16;
                        IndexData var17 = FaceNormal.configsIndex;
                        class244.field3319 = var17;
                        class66.method1138(FaceNormal.configsIndex);
                        GZipDecompressor.chatMessages = new Varcs();
                        IndexData var18 = FaceNormal.configsIndex;
                        IndexData var19 = class37.indexSprites;
                        IndexData var20 = class31.field458;
                        class254.field3420 = var18;
                        class254.field3411 = var19;
                        class254.field3412 = var20;
                        IndexData var21 = FaceNormal.configsIndex;
                        IndexData var22 = class37.indexSprites;
                        CombatInfo2.field3366 = var21;
                        CombatInfo2.field3361 = var22;
                        class164.method3160(FaceNormal.configsIndex, class37.indexSprites);
                        class90.loadingText = "Loaded config";
                        class90.loadingBarPercentage = 60;
                        Client.loadingStage = 80;
                     }
                  } else if(Client.loadingStage == 80) {
                     var0 = 0;
                     if(class15.compass == null) {
                        class15.compass = class64.method1132(class37.indexSprites, "compass", "");
                     } else {
                        ++var0;
                     }

                     if(class15.mapedge == null) {
                        class15.mapedge = class64.method1132(class37.indexSprites, "mapedge", "");
                     } else {
                        ++var0;
                     }

                     if(class288.field3819 == null) {
                        class288.field3819 = Ignore.method1147(class37.indexSprites, "mapscene", "");
                     } else {
                        ++var0;
                     }

                     if(FaceNormal.mapfunctions == null) {
                        FaceNormal.mapfunctions = class45.method666(class37.indexSprites, "headicons_pk", "");
                     } else {
                        ++var0;
                     }

                     if(class35.hitmarks == null) {
                        class35.hitmarks = class45.method666(class37.indexSprites, "headicons_prayer", "");
                     } else {
                        ++var0;
                     }

                     if(class28.pkIcons == null) {
                        class28.pkIcons = class45.method666(class37.indexSprites, "headicons_hint", "");
                     } else {
                        ++var0;
                     }

                     if(class54.field687 == null) {
                        class54.field687 = class45.method666(class37.indexSprites, "mapmarker", "");
                     } else {
                        ++var0;
                     }

                     if(class20.field335 == null) {
                        class20.field335 = class45.method666(class37.indexSprites, "cross", "");
                     } else {
                        ++var0;
                     }

                     if(MouseInput.mapDots == null) {
                        MouseInput.mapDots = class45.method666(class37.indexSprites, "mapdots", "");
                     } else {
                        ++var0;
                     }

                     if(class29.field432 == null) {
                        class29.field432 = Ignore.method1147(class37.indexSprites, "scrollbar", "");
                     } else {
                        ++var0;
                     }

                     if(class2.field16 == null) {
                        class2.field16 = Ignore.method1147(class37.indexSprites, "mod_icons", "");
                     } else {
                        ++var0;
                     }

                     if(var0 < 11) {
                        class90.loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
                        class90.loadingBarPercentage = 70;
                     } else {
                        FontTypeFace.modIcons = class2.field16;
                        class15.mapedge.method5174();
                        var1 = (int)(Math.random() * 21.0D) - 10;
                        var2 = (int)(Math.random() * 21.0D) - 10;
                        var3 = (int)(Math.random() * 21.0D) - 10;
                        var4 = (int)(Math.random() * 41.0D) - 20;
                        class288.field3819[0].method5158(var4 + var1, var4 + var2, var3 + var4);
                        class90.loadingText = "Loaded sprites";
                        class90.loadingBarPercentage = 70;
                        Client.loadingStage = 90;
                     }
                  } else if(Client.loadingStage == 90) {
                     if(!class8.indexTextures.method4292()) {
                        class90.loadingText = "Loading textures - " + class8.indexTextures.method4322() + "%";
                        class90.loadingBarPercentage = 90;
                     } else {
                        TextureProvider var32 = new TextureProvider(class8.indexTextures, class37.indexSprites, 20, 0.8D, Client.lowMemory?64:128);
                        Graphics3D.setTextureLoader(var32);
                        Graphics3D.setBrightness(0.8D);
                        class90.loadingText = "Loaded textures";
                        class90.loadingBarPercentage = 90;
                        Client.loadingStage = 110;
                     }
                  } else if(Client.loadingStage == 110) {
                     class110.field1653 = new class70();
                     GameEngine.taskManager.createRunnable(class110.field1653, 10);
                     class90.loadingText = "Loaded input handler";
                     class90.loadingBarPercentage = 92;
                     Client.loadingStage = 120;
                  } else if(Client.loadingStage == 120) {
                     if(!Client.field1193.method4238("huffman", "")) {
                        class90.loadingText = "Loading wordpack - " + 0 + "%";
                        class90.loadingBarPercentage = 94;
                     } else {
                        Huffman var31 = new Huffman(Client.field1193.method4305("huffman", ""));
                        class244.method4432(var31);
                        class90.loadingText = "Loaded wordpack";
                        class90.loadingBarPercentage = 94;
                        Client.loadingStage = 130;
                     }
                  } else if(Client.loadingStage == 130) {
                     if(!ClanMember.field918.method4292()) {
                        class90.loadingText = "Loading interfaces - " + ClanMember.field918.method4322() * 4 / 5 + "%";
                        class90.loadingBarPercentage = 96;
                     } else if(!class51.indexScripts.method4292()) {
                        class90.loadingText = "Loading interfaces - " + (80 + class51.indexScripts.method4322() / 6) + "%";
                        class90.loadingBarPercentage = 96;
                     } else if(!class31.field458.method4292()) {
                        class90.loadingText = "Loading interfaces - " + (96 + class31.field458.method4322() / 50) + "%";
                        class90.loadingBarPercentage = 96;
                     } else {
                        class90.loadingText = "Loaded interfaces";
                        class90.loadingBarPercentage = 98;
                        Client.loadingStage = 140;
                     }
                  } else if(Client.loadingStage == 140) {
                     class90.loadingBarPercentage = 100;
                     if(!class41.indexWorldMap.method4288(class40.field561.field559)) {
                        class90.loadingText = "Loading world map - " + class41.indexWorldMap.method4241(class40.field561.field559) / 10 + "%";
                     } else {
                        if(GameObject.renderOverview == null) {
                           GameObject.renderOverview = new RenderOverview();
                           GameObject.renderOverview.method5317(class41.indexWorldMap, Friend.field827, Client.field932, class288.field3819);
                        }

                        var0 = GameObject.renderOverview.method5318();
                        if(var0 < 100) {
                           class90.loadingText = "Loading world map - " + (var0 * 9 / 10 + 10) + "%";
                        } else {
                           class90.loadingText = "Loaded world map";
                           Client.loadingStage = 150;
                        }
                     }
                  } else if(Client.loadingStage == 150) {
                     FrameMap.setGameState(10);
                  }
               }
            }
         } else {
            int[] var23 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 15 + 128 + var1 * 32;
               var3 = 600 + var2 * 3;
               var4 = Graphics3D.SINE[var2];
               var23[var1] = var4 * var3 >> 16;
            }

            Region.method2792(var23, 500, 800, 512, 334);
            class90.loadingText = "Prepared visibility map";
            class90.loadingBarPercentage = 10;
            Client.loadingStage = 30;
         }
      }
   }
}
