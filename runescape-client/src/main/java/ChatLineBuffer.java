import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("o")
   public static Track1 field1565;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 159711907
   )
   @Export("length")
   int length;
   @ObfuscatedName("cv")
   static IndexData field1567;
   @ObfuscatedName("c")
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("fq")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)LMessageNode;",
      garbageValue = "212861014"
   )
   MessageNode method1858(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.method3600();
         var5.method1102(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LMessageNode;",
      garbageValue = "-67"
   )
   MessageNode method1860(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-941968589"
   )
   int method1861() {
      return this.length;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "192119925"
   )
   static int method1862(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-108"
   )
   static final int method1866(int var0, int var1) {
      int var2 = class56.method802(var0 + '넵', var1 + 91923, 4) - 128 + (class56.method802(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (class56.method802(var0, var1, 1) - 128 >> 2);
      var2 = (int)(0.3D * (double)var2) + 35;
      if(var2 < 10) {
         var2 = 10;
      } else if(var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   static void method1867() {
      int var22;
      if(Client.field1184 == 0) {
         class1.region = new Region(4, 104, 104, class61.tileHeights);

         for(var22 = 0; var22 < 4; ++var22) {
            Client.collisionMaps[var22] = new CollisionData(104, 104);
         }

         class41.field564 = new SpritePixels(512, 512);
         class92.field1455 = "Starting game engine...";
         class92.field1448 = 5;
         Client.field1184 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field1184 == 20) {
            int[] var30 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = var1 * 32 + 128 + 15;
               var3 = var2 * 3 + 600;
               var4 = class136.SINE[var2];
               var30[var1] = var4 * var3 >> 16;
            }

            Region.method2806(var30, 500, 800, 512, 334);
            class92.field1455 = "Prepared visibility map";
            class92.field1448 = 10;
            Client.field1184 = 30;
         } else if(Client.field1184 == 30) {
            class46.indexInterfaces = class71.method1097(0, false, true, true);
            class31.indexSoundEffects = class71.method1097(1, false, true, true);
            Overlay.field3594 = class71.method1097(2, true, false, true);
            class25.field365 = class71.method1097(3, false, true, true);
            field1567 = class71.method1097(4, false, true, true);
            XClanMember.indexMaps = class71.method1097(5, true, true, true);
            class22.indexTrack1 = class71.method1097(6, true, true, false);
            class36.indexModels = class71.method1097(7, false, true, true);
            class261.indexSprites = class71.method1097(8, false, true, true);
            WorldMapType3.indexTextures = class71.method1097(9, false, true, true);
            WidgetNode.field841 = class71.method1097(10, false, true, true);
            class4.indexTrack2 = class71.method1097(11, false, true, true);
            class23.indexScripts = class71.method1097(12, false, true, true);
            class20.field324 = class71.method1097(13, true, false, true);
            Client.field1207 = class71.method1097(14, false, true, false);
            Coordinates.field2613 = class71.method1097(15, false, true, true);
            class50.indexWorldMap = class71.method1097(16, false, true, false);
            class92.field1455 = "Connecting to update server";
            class92.field1448 = 20;
            Client.field1184 = 40;
         } else if(Client.field1184 == 40) {
            byte var33 = 0;
            var22 = var33 + class46.indexInterfaces.method4218() * 4 / 100;
            var22 += class31.indexSoundEffects.method4218() * 4 / 100;
            var22 += Overlay.field3594.method4218() * 2 / 100;
            var22 += class25.field365.method4218() * 2 / 100;
            var22 += field1567.method4218() * 6 / 100;
            var22 += XClanMember.indexMaps.method4218() * 4 / 100;
            var22 += class22.indexTrack1.method4218() * 2 / 100;
            var22 += class36.indexModels.method4218() * 58 / 100;
            var22 += class261.indexSprites.method4218() * 2 / 100;
            var22 += WorldMapType3.indexTextures.method4218() * 2 / 100;
            var22 += WidgetNode.field841.method4218() * 2 / 100;
            var22 += class4.indexTrack2.method4218() * 2 / 100;
            var22 += class23.indexScripts.method4218() * 2 / 100;
            var22 += class20.field324.method4218() * 2 / 100;
            var22 += Client.field1207.method4218() * 2 / 100;
            var22 += Coordinates.field2613.method4218() * 2 / 100;
            var22 += class50.indexWorldMap.method4218() * 2 / 100;
            if(var22 != 100) {
               if(var22 != 0) {
                  class92.field1455 = "Checking for updates - " + var22 + "%";
               }

               class92.field1448 = 30;
            } else {
               class92.field1455 = "Loaded update list";
               class92.field1448 = 30;
               Client.field1184 = 45;
            }
         } else {
            IndexData var23;
            IndexData var24;
            IndexData var25;
            if(Client.field1184 == 45) {
               class5.method10(22050, !Client.field1046, 2);
               class204 var29 = new class204();
               var29.method3676(9, 128);
               class11.field267 = class241.method4293(GameEngine.field721, 0, 22050);
               class11.field267.method2035(var29);
               var25 = Coordinates.field2613;
               var24 = Client.field1207;
               var23 = field1567;
               class203.field2512 = var25;
               class203.field2510 = var24;
               class19.field315 = var23;
               class203.field2511 = var29;
               FaceNormal.field2155 = class241.method4293(GameEngine.field721, 1, 2048);
               class158.field2288 = new class102();
               FaceNormal.field2155.method2035(class158.field2288);
               class137.field2055 = new class116(22050, class109.field1640);
               class92.field1455 = "Prepared sound engine";
               class92.field1448 = 35;
               Client.field1184 = 50;
               WorldMapType3.field378 = new class262(class261.indexSprites, class20.field324);
            } else if(Client.field1184 == 50) {
               var22 = class261.method4711().length;
               Client.field934 = WorldMapType3.field378.method4714(class261.method4711());
               if(Client.field934.size() < var22) {
                  class92.field1455 = "Loading fonts - " + Client.field934.size() * 100 / var22 + "%";
                  class92.field1448 = 40;
               } else {
                  class166.field2344 = (Font)Client.field934.get(class261.field3623);
                  class33.field473 = (Font)Client.field934.get(class261.field3617);
                  XClanMember.field922 = (Font)Client.field934.get(class261.field3619);
                  class155.field2275 = new class291(true);
                  class92.field1455 = "Loaded fonts";
                  class92.field1448 = 40;
                  Client.field1184 = 60;
               }
            } else if(Client.field1184 == 60) {
               var25 = WidgetNode.field841;
               var24 = class261.indexSprites;
               var3 = 0;
               if(var25.method4128("title.jpg", "")) {
                  ++var3;
               }

               if(var24.method4128("logo", "")) {
                  ++var3;
               }

               if(var24.method4128("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var24.method4128("titlebox", "")) {
                  ++var3;
               }

               if(var24.method4128("titlebutton", "")) {
                  ++var3;
               }

               if(var24.method4128("runes", "")) {
                  ++var3;
               }

               if(var24.method4128("title_mute", "")) {
                  ++var3;
               }

               if(var24.method4128("options_radio_buttons,0", "")) {
                  ++var3;
               }

               if(var24.method4128("options_radio_buttons,2", "")) {
                  ++var3;
               }

               var24.method4128("sl_back", "");
               var24.method4128("sl_flags", "");
               var24.method4128("sl_arrows", "");
               var24.method4128("sl_stars", "");
               var24.method4128("sl_button", "");
               byte var32 = 9;
               if(var3 < var32) {
                  class92.field1455 = "Loading title screen - " + var3 * 100 / var32 + "%";
                  class92.field1448 = 50;
               } else {
                  class92.field1455 = "Loaded title screen";
                  class92.field1448 = 50;
                  class249.setGameState(5);
                  Client.field1184 = 70;
               }
            } else if(Client.field1184 == 70) {
               if(!Overlay.field3594.method4113()) {
                  class92.field1455 = "Loading config - " + Overlay.field3594.method4226() + "%";
                  class92.field1448 = 60;
               } else {
                  IndexData var28 = Overlay.field3594;
                  Overlay.field3587 = var28;
                  var25 = Overlay.field3594;
                  FloorUnderlayDefinition.field3345 = var25;
                  class240.method4280(Overlay.field3594, class36.indexModels);
                  var24 = Overlay.field3594;
                  var23 = class36.indexModels;
                  boolean var31 = Client.field1046;
                  ObjectComposition.field3467 = var24;
                  class249.field3377 = var23;
                  ObjectComposition.field3452 = var31;
                  IndexData var5 = Overlay.field3594;
                  IndexData var6 = class36.indexModels;
                  NPCComposition.field3575 = var5;
                  NPCComposition.field3546 = var6;
                  class205.method3788(Overlay.field3594);
                  IndexData var7 = Overlay.field3594;
                  IndexData var8 = class36.indexModels;
                  boolean var9 = Client.isMembers;
                  Font var10 = class166.field2344;
                  Frames.field2161 = var7;
                  MessageNode.field876 = var8;
                  class134.isMembersWorld = var9;
                  ItemComposition.field3486 = Frames.field2161.method4187(10);
                  WidgetNode.field844 = var10;
                  class210.method3905(Overlay.field3594, class46.indexInterfaces, class31.indexSoundEffects);
                  IndexData var11 = Overlay.field3594;
                  IndexData var12 = class36.indexModels;
                  Spotanim.field3329 = var11;
                  class12.field270 = var12;
                  Coordinates.method3934(Overlay.field3594);
                  class95.method1761(Overlay.field3594);
                  Frames.method2875(class25.field365, class36.indexModels, class261.indexSprites, class20.field324);
                  class9.method40(Overlay.field3594);
                  IndexData var13 = Overlay.field3594;
                  class253.field3402 = var13;
                  Renderable.method2864(Overlay.field3594);
                  IndexData var14 = Overlay.field3594;
                  class244.field3319 = var14;
                  IndexData var15 = Overlay.field3594;
                  class251.field3383 = var15;
                  Player.chatMessages = new ChatMessages();
                  class95.method1756(Overlay.field3594, class261.indexSprites, class20.field324);
                  IndexData var16 = Overlay.field3594;
                  IndexData var17 = class261.indexSprites;
                  CombatInfo2.field3374 = var16;
                  CombatInfo2.field3365 = var17;
                  IndexData var18 = Overlay.field3594;
                  IndexData var19 = class261.indexSprites;
                  Area.field3301 = var19;
                  if(var18.method4113()) {
                     Area.field3290 = var18.method4187(35);
                     class223.field2839 = new Area[Area.field3290];

                     for(int var20 = 0; var20 < Area.field3290; ++var20) {
                        byte[] var21 = var18.getConfigData(35, var20);
                        if(var21 != null) {
                           class223.field2839[var20] = new Area(var20);
                           class223.field2839[var20].method4296(new Buffer(var21));
                           class223.field2839[var20].method4314();
                        }
                     }
                  }

                  class92.field1455 = "Loaded config";
                  class92.field1448 = 60;
                  Client.field1184 = 80;
               }
            } else if(Client.field1184 == 80) {
               var22 = 0;
               if(class109.field1660 == null) {
                  class109.field1660 = class243.method4328(class261.indexSprites, "compass", "");
               } else {
                  ++var22;
               }

               if(class219.field2788 == null) {
                  class219.field2788 = class243.method4328(class261.indexSprites, "mapedge", "");
               } else {
                  ++var22;
               }

               if(class112.field1685 == null) {
                  class112.field1685 = class164.method3071(class261.indexSprites, "mapscene", "");
               } else {
                  ++var22;
               }

               if(class71.field873 == null) {
                  class71.field873 = class162.method3053(class261.indexSprites, "headicons_pk", "");
               } else {
                  ++var22;
               }

               if(ScriptState.field781 == null) {
                  ScriptState.field781 = class162.method3053(class261.indexSprites, "headicons_prayer", "");
               } else {
                  ++var22;
               }

               if(class51.field670 == null) {
                  class51.field670 = class162.method3053(class261.indexSprites, "headicons_hint", "");
               } else {
                  ++var22;
               }

               if(ScriptState.field782 == null) {
                  ScriptState.field782 = class162.method3053(class261.indexSprites, "mapmarker", "");
               } else {
                  ++var22;
               }

               if(class13.field278 == null) {
                  class13.field278 = class162.method3053(class261.indexSprites, "cross", "");
               } else {
                  ++var22;
               }

               if(Client.field1212 == null) {
                  Client.field1212 = class162.method3053(class261.indexSprites, "mapdots", "");
               } else {
                  ++var22;
               }

               if(GroundObject.field1883 == null) {
                  GroundObject.field1883 = class164.method3071(class261.indexSprites, "scrollbar", "");
               } else {
                  ++var22;
               }

               if(class6.field106 == null) {
                  class6.field106 = class164.method3071(class261.indexSprites, "mod_icons", "");
               } else {
                  ++var22;
               }

               if(var22 < 11) {
                  class92.field1455 = "Loading sprites - " + var22 * 100 / 12 + "%";
                  class92.field1448 = 70;
               } else {
                  FontTypeFace.modIcons = class6.field106;
                  class219.field2788.method5039();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;
                  class112.field1685[0].method5032(var4 + var1, var4 + var2, var4 + var3);
                  class92.field1455 = "Loaded sprites";
                  class92.field1448 = 70;
                  Client.field1184 = 90;
               }
            } else if(Client.field1184 == 90) {
               if(!WorldMapType3.indexTextures.method4113()) {
                  class92.field1455 = "Loading textures - " + WorldMapType3.indexTextures.method4226() + "%";
                  class92.field1448 = 90;
               } else {
                  TextureProvider var27 = new TextureProvider(WorldMapType3.indexTextures, class261.indexSprites, 20, 0.8D, Client.field1046?64:128);
                  class136.method2594(var27);
                  class136.method2645(0.8D);
                  class92.field1455 = "Loaded textures";
                  class92.field1448 = 90;
                  Client.field1184 = 110;
               }
            } else if(Client.field1184 == 110) {
               class64.field807 = new class71();
               GameEngine.field721.method2936(class64.field807, 10);
               class92.field1455 = "Loaded input handler";
               class92.field1448 = 94;
               Client.field1184 = 120;
            } else if(Client.field1184 == 120) {
               if(!WidgetNode.field841.method4128("huffman", "")) {
                  class92.field1455 = "Loading wordpack - " + 0 + "%";
                  class92.field1448 = 96;
               } else {
                  class165 var0 = new class165(WidgetNode.field841.method4170("huffman", ""));
                  class265.field3654 = var0;
                  class92.field1455 = "Loaded wordpack";
                  class92.field1448 = 96;
                  Client.field1184 = 130;
               }
            } else if(Client.field1184 == 130) {
               if(!class25.field365.method4113()) {
                  class92.field1455 = "Loading interfaces - " + class25.field365.method4226() * 4 / 5 + "%";
                  class92.field1448 = 100;
               } else if(!class23.indexScripts.method4113()) {
                  class92.field1455 = "Loading interfaces - " + (class23.indexScripts.method4226() / 6 + 80) + "%";
                  class92.field1448 = 100;
               } else if(!class20.field324.method4113()) {
                  class92.field1455 = "Loading interfaces - " + (class20.field324.method4226() / 50 + 96) + "%";
                  class92.field1448 = 100;
               } else {
                  class92.field1455 = "Loaded interfaces";
                  class92.field1448 = 98;
                  Client.field1184 = 140;
               }
            } else if(Client.field1184 == 140) {
               if(!class50.indexWorldMap.method4129(class40.field540.field542)) {
                  class92.field1455 = "Loading world map - " + class50.indexWorldMap.method4133(class40.field540.field542) / 10 + "%";
               } else {
                  if(class1.field14 == null) {
                     class1.field14 = new RenderOverview();
                     class1.field14.method5189(class50.indexWorldMap, XClanMember.field922, Client.field934, class112.field1685);
                  }

                  var22 = class1.field14.method5173();
                  if(var22 < 100) {
                     class92.field1455 = "Loading world map - " + (var22 * 9 / 10 + 10) + "%";
                  } else {
                     class92.field1455 = "Loaded world map";
                     class92.field1448 = 100;
                     Client.field1184 = 150;
                  }
               }
            } else if(Client.field1184 == 150) {
               class249.setGameState(10);
            }
         }
      }
   }

   @ObfuscatedName("c")
   static final void method1868(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }
}
