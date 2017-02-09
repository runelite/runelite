import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class189 extends CacheableNode {
   @ObfuscatedName("j")
   @Export("overlayPaths")
   static byte[][][] overlayPaths;
   @ObfuscatedName("y")
   static NodeCache field2767 = new NodeCache(64);
   @ObfuscatedName("o")
   public boolean field2768 = false;
   @ObfuscatedName("k")
   public static class182 field2769;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1551072709"
   )
   void method3442(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3443(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-691667414"
   )
   void method3443(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2768 = true;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-1422882107"
   )
   public static void method3452(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1795 = 0;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "1139808738"
   )
   static final void method3453(Actor var0) {
      if(var0.field643 != 0) {
         if(var0.interacting != -1) {
            Object var4 = null;
            if(var0.interacting < '耀') {
               var4 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var4 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var4 != null) {
               int var5 = var0.x - ((Actor)var4).x;
               int var3 = var0.y - ((Actor)var4).y;
               if(var5 != 0 || var3 != 0) {
                  var0.field641 = (int)(Math.atan2((double)var5, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field617) {
               var0.interacting = -1;
               var0.field617 = false;
            }
         }

         if(var0.field635 != -1 && (var0.field644 == 0 || var0.field638 > 0)) {
            var0.field641 = var0.field635;
            var0.field635 = -1;
         }

         int var1 = var0.field641 - var0.angle & 2047;
         if(var1 == 0 && var0.field617) {
            var0.interacting = -1;
            var0.field617 = false;
         }

         if(var1 != 0) {
            ++var0.field591;
            boolean var6;
            if(var1 > 1024) {
               var0.angle -= var0.field643;
               var6 = true;
               if(var1 < var0.field643 || var1 > 2048 - var0.field643) {
                  var0.angle = var0.field641;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field591 > 25 || var6)) {
                  if(var0.field596 != -1) {
                     var0.poseAnimation = var0.field596;
                  } else {
                     var0.poseAnimation = var0.field598;
                  }
               }
            } else {
               var0.angle += var0.field643;
               var6 = true;
               if(var1 < var0.field643 || var1 > 2048 - var0.field643) {
                  var0.angle = var0.field641;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field591 > 25 || var6)) {
                  if(var0.field642 != -1) {
                     var0.poseAnimation = var0.field642;
                  } else {
                     var0.poseAnimation = var0.field598;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field591 = 0;
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1964442894"
   )
   static void method3454() {
      int var0;
      if(Client.field294 == 0) {
         class65.region = new Region(4, 104, 104, class11.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class7.field56 = new SpritePixels(512, 512);
         class41.field839 = "Starting game engine...";
         class41.field849 = 5;
         Client.field294 = 20;
      } else {
         int var1;
         int var3;
         int var4;
         int var22;
         if(Client.field294 == 20) {
            int[] var32 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var22 = 15 + 128 + var1 * 32;
               var3 = 600 + 3 * var22;
               var4 = class84.field1428[var22];
               var32[var1] = var3 * var4 >> 16;
            }

            Region.method1742(var32, 500, 800, 512, 334);
            class41.field839 = "Prepared visibility map";
            class41.field849 = 10;
            Client.field294 = 30;
         } else if(Client.field294 == 30) {
            class152.field2191 = XItemContainer.method185(0, false, true, true);
            class0.field2 = XItemContainer.method185(1, false, true, true);
            Client.field353 = XItemContainer.method185(2, true, false, true);
            class166.field2297 = XItemContainer.method185(3, false, true, true);
            Friend.field152 = XItemContainer.method185(4, false, true, true);
            class37.field786 = XItemContainer.method185(5, true, true, true);
            ChatMessages.field923 = XItemContainer.method185(6, true, true, false);
            class171.field2330 = XItemContainer.method185(7, false, true, true);
            Friend.field147 = XItemContainer.method185(8, false, true, true);
            class171.field2324 = XItemContainer.method185(9, false, true, true);
            class174.field2628 = XItemContainer.method185(10, false, true, true);
            class11.field109 = XItemContainer.method185(11, false, true, true);
            class112.field1763 = XItemContainer.method185(12, false, true, true);
            class25.field574 = XItemContainer.method185(13, true, false, true);
            class119.field1849 = XItemContainer.method185(14, false, true, false);
            class103.field1686 = XItemContainer.method185(15, false, true, true);
            class41.field839 = "Connecting to update server";
            class41.field849 = 20;
            Client.field294 = 40;
         } else if(Client.field294 == 40) {
            byte var29 = 0;
            var0 = var29 + class152.field2191.method3364() * 4 / 100;
            var0 += class0.field2.method3364() * 4 / 100;
            var0 += Client.field353.method3364() * 2 / 100;
            var0 += class166.field2297.method3364() * 2 / 100;
            var0 += Friend.field152.method3364() * 6 / 100;
            var0 += class37.field786.method3364() * 4 / 100;
            var0 += ChatMessages.field923.method3364() * 2 / 100;
            var0 += class171.field2330.method3364() * 60 / 100;
            var0 += Friend.field147.method3364() * 2 / 100;
            var0 += class171.field2324.method3364() * 2 / 100;
            var0 += class174.field2628.method3364() * 2 / 100;
            var0 += class11.field109.method3364() * 2 / 100;
            var0 += class112.field1763.method3364() * 2 / 100;
            var0 += class25.field574.method3364() * 2 / 100;
            var0 += class119.field1849.method3364() * 2 / 100;
            var0 += class103.field1686.method3364() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field839 = "Checking for updates - " + var0 + "%";
               }

               class41.field849 = 30;
            } else {
               class41.field839 = "Loaded update list";
               class41.field849 = 30;
               Client.field294 = 45;
            }
         } else if(Client.field294 == 45) {
            boolean var28 = !Client.field278;
            class57.field1045 = 22050;
            class57.field1057 = var28;
            ObjectComposition.field2920 = 2;
            class139 var34 = new class139();
            var34.method2552(9, 128);
            class139.field1944 = class2.method30(class63.field1093, class32.canvas, 0, 22050);
            class139.field1944.method1056(var34);
            class139.method2607(class103.field1686, class119.field1849, Friend.field152, var34);
            CombatInfoListHolder.field760 = class2.method30(class63.field1093, class32.canvas, 1, 2048);
            class164.field2290 = new class51();
            CombatInfoListHolder.field760.method1056(class164.field2290);
            class22.field237 = new class65(22050, class57.field1045);
            class41.field839 = "Prepared sound engine";
            class41.field849 = 35;
            Client.field294 = 50;
         } else if(Client.field294 == 50) {
            var0 = 0;
            if(null == class41.field855) {
               class41.field855 = class94.method1905(Friend.field147, class25.field574, "p11_full", "");
            } else {
               ++var0;
            }

            if(class49.field961 == null) {
               class49.field961 = class94.method1905(Friend.field147, class25.field574, "p12_full", "");
            } else {
               ++var0;
            }

            if(null == class16.field176) {
               class16.field176 = class94.method1905(Friend.field147, class25.field574, "b12_full", "");
            } else {
               ++var0;
            }

            if(var0 < 3) {
               class41.field839 = "Loading fonts - " + var0 * 100 / 3 + "%";
               class41.field849 = 40;
            } else {
               Sequence.field3052 = new class230(true);
               class41.field839 = "Loaded fonts";
               class41.field849 = 40;
               Client.field294 = 60;
            }
         } else {
            class184 var2;
            class184 var33;
            if(Client.field294 == 60) {
               var33 = class174.field2628;
               var2 = Friend.field147;
               var3 = 0;
               if(var33.method3291("title.jpg", "")) {
                  ++var3;
               }

               if(var2.method3291("logo", "")) {
                  ++var3;
               }

               if(var2.method3291("logo_deadman_mode", "")) {
                  ++var3;
               }

               if(var2.method3291("titlebox", "")) {
                  ++var3;
               }

               if(var2.method3291("titlebutton", "")) {
                  ++var3;
               }

               if(var2.method3291("runes", "")) {
                  ++var3;
               }

               if(var2.method3291("title_mute", "")) {
                  ++var3;
               }

               if(var2.method3292("options_radio_buttons,0")) {
                  ++var3;
               }

               if(var2.method3292("options_radio_buttons,2")) {
                  ++var3;
               }

               var2.method3291("sl_back", "");
               var2.method3291("sl_flags", "");
               var2.method3291("sl_arrows", "");
               var2.method3291("sl_stars", "");
               var2.method3291("sl_button", "");
               byte var26 = 9;
               if(var3 < var26) {
                  class41.field839 = "Loading title screen - " + var3 * 100 / var26 + "%";
                  class41.field849 = 50;
               } else {
                  class41.field839 = "Loaded title screen";
                  class41.field849 = 50;
                  class11.setGameState(5);
                  Client.field294 = 70;
               }
            } else if(Client.field294 == 70) {
               if(!Client.field353.method3277()) {
                  class41.field839 = "Loading config - " + Client.field353.method3372() + "%";
                  class41.field849 = 60;
               } else {
                  class94.method1904(Client.field353);
                  class184 var31 = Client.field353;
                  FloorUnderlayDefinition.field2792 = var31;
                  var33 = Client.field353;
                  var2 = class171.field2330;
                  KitDefinition.field2803 = var33;
                  KitDefinition.field2800 = var2;
                  KitDefinition.field2810 = KitDefinition.field2803.method3283(3);
                  class114.method2192(Client.field353, class171.field2330, Client.field278);
                  class108.method2038(Client.field353, class171.field2330);
                  class184 var24 = Client.field353;
                  class184 var25 = class171.field2330;
                  boolean var27 = Client.isMembers;
                  Font var6 = class41.field855;
                  class206.field3079 = var24;
                  ItemComposition.field2930 = var25;
                  ItemComposition.isMembersWorld = var27;
                  class47.field924 = class206.field3079.method3283(10);
                  class205.field3070 = var6;
                  class184 var7 = Client.field353;
                  class184 var8 = class152.field2191;
                  class184 var9 = class0.field2;
                  Sequence.field3045 = var7;
                  Sequence.field3048 = var8;
                  Sequence.field3034 = var9;
                  class184 var10 = Client.field353;
                  class184 var11 = class171.field2330;
                  Spotanim.field2773 = var10;
                  Spotanim.field2777 = var11;
                  class114.method2187(Client.field353);
                  class184 var12 = Client.field353;
                  class187.field2759 = var12;
                  class187.field2755 = class187.field2759.method3283(16);
                  class184 var13 = class166.field2297;
                  class184 var14 = class171.field2330;
                  class184 var15 = Friend.field147;
                  class184 var16 = class25.field574;
                  class156.field2213 = var13;
                  class105.field1724 = var14;
                  class210.field3109 = var15;
                  class44.field896 = var16;
                  Widget.widgets = new Widget[class156.field2213.method3270()][];
                  Widget.validInterfaces = new boolean[class156.field2213.method3270()];
                  class184 var17 = Client.field353;
                  class186.field2750 = var17;
                  class9.method123(Client.field353);
                  FloorUnderlayDefinition.method3489(Client.field353);
                  class184 var18 = Client.field353;
                  field2769 = var18;
                  class45.chatMessages = new ChatMessages();
                  class167.method3207(Client.field353, Friend.field147, class25.field574);
                  class184 var19 = Client.field353;
                  class184 var20 = Friend.field147;
                  CombatInfo2.field2826 = var19;
                  CombatInfo2.field2815 = var20;
                  class41.field839 = "Loaded config";
                  class41.field849 = 60;
                  Client.field294 = 80;
               }
            } else if(Client.field294 != 80) {
               if(Client.field294 == 90) {
                  if(!class171.field2324.method3277()) {
                     class41.field839 = "Loading textures - " + class171.field2324.method3372() + "%";
                     class41.field849 = 90;
                  } else {
                     TextureProvider var30 = new TextureProvider(class171.field2324, Friend.field147, 20, 0.8D, Client.field278?64:128);
                     class84.method1647(var30);
                     class84.method1648(0.8D);
                     class41.field839 = "Loaded textures";
                     class41.field849 = 90;
                     Client.field294 = 110;
                  }
               } else if(Client.field294 == 110) {
                  WallObject.field1557 = new class20();
                  class63.field1093.method1945(WallObject.field1557, 10);
                  class41.field839 = "Loaded input handler";
                  class41.field849 = 94;
                  Client.field294 = 120;
               } else if(Client.field294 == 120) {
                  if(!class174.field2628.method3291("huffman", "")) {
                     class41.field839 = "Loading wordpack - " + 0 + "%";
                     class41.field849 = 96;
                  } else {
                     class152 var21 = new class152(class174.field2628.method3341("huffman", ""));
                     class184.method3393(var21);
                     class41.field839 = "Loaded wordpack";
                     class41.field849 = 96;
                     Client.field294 = 130;
                  }
               } else if(Client.field294 == 130) {
                  if(!class166.field2297.method3277()) {
                     class41.field839 = "Loading interfaces - " + class166.field2297.method3372() * 4 / 5 + "%";
                     class41.field849 = 100;
                  } else if(!class112.field1763.method3277()) {
                     class41.field839 = "Loading interfaces - " + (80 + class112.field1763.method3372() / 6) + "%";
                     class41.field849 = 100;
                  } else if(!class25.field574.method3277()) {
                     class41.field839 = "Loading interfaces - " + (96 + class25.field574.method3372() / 20) + "%";
                     class41.field849 = 100;
                  } else {
                     class41.field839 = "Loaded interfaces";
                     class41.field849 = 100;
                     Client.field294 = 140;
                  }
               } else if(Client.field294 == 140) {
                  class11.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var23;
               if(WidgetNode.field180 == null) {
                  var2 = Friend.field147;
                  var3 = var2.method3284("compass");
                  var4 = var2.method3285(var3, "");
                  var23 = class60.method1158(var2, var3, var4);
                  WidgetNode.field180 = var23;
               } else {
                  ++var0;
               }

               if(class186.field2752 == null) {
                  var2 = Friend.field147;
                  var3 = var2.method3284("mapedge");
                  var4 = var2.method3285(var3, "");
                  var23 = class60.method1158(var2, var3, var4);
                  class186.field2752 = var23;
               } else {
                  ++var0;
               }

               if(null == MessageNode.field234) {
                  MessageNode.field234 = FrameMap.method1705(Friend.field147, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class99.field1648) {
                  class99.field1648 = class26.method622(Friend.field147, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class101.field1666 == null) {
                  class101.field1666 = class26.method622(Friend.field147, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class94.field1591 == null) {
                  class94.field1591 = class26.method622(Friend.field147, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(null == class49.field963) {
                  class49.field963 = class26.method622(Friend.field147, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == class5.field52) {
                  class5.field52 = class26.method622(Friend.field147, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(class33.field742 == null) {
                  class33.field742 = class26.method622(Friend.field147, "cross", "");
               } else {
                  ++var0;
               }

               if(null == class22.field239) {
                  class22.field239 = class26.method622(Friend.field147, "mapdots", "");
               } else {
                  ++var0;
               }

               if(class225.field3219 == null) {
                  class225.field3219 = FrameMap.method1705(Friend.field147, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == class104.field1699) {
                  class104.field1699 = FrameMap.method1705(Friend.field147, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field839 = "Loading sprites - " + var0 * 100 / 12 + "%";
                  class41.field849 = 70;
               } else {
                  FontTypeFace.modIcons = class104.field1699;
                  class186.field2752.method4184();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var22 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var5 = 0; var5 < class99.field1648.length; ++var5) {
                     class99.field1648[var5].method4105(var4 + var1, var4 + var22, var4 + var3);
                  }

                  MessageNode.field234[0].method4063(var1 + var4, var4 + var22, var3 + var4);
                  class41.field839 = "Loaded sprites";
                  class41.field849 = 70;
                  Client.field294 = 90;
               }
            }
         }
      }
   }
}
