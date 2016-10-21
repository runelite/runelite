import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class20 extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2058831421
   )
   int field566;
   @ObfuscatedName("as")
   static class149 field567;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1820048827
   )
   int field568;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1731333505
   )
   int field569;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1799996891
   )
   int field570;
   @ObfuscatedName("qg")
   protected static Image field573;
   @ObfuscatedName("ag")
   @Export("authCode")
   static String authCode;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-9"
   )
   void method558(int var1, int var2, int var3, int var4) {
      this.field570 = var1;
      this.field569 = var2;
      this.field566 = var3;
      this.field568 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2101243050"
   )
   static void method559() {
      int var0;
      if(Client.field302 == 0) {
         class9.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         DecorativeObject.field1660 = new SpritePixels(512, 512);
         class33.field742 = "Starting game engine...";
         class33.field741 = 5;
         Client.field302 = 20;
      } else {
         int var3;
         int var4;
         int var20;
         int var21;
         if(Client.field302 == 20) {
            int[] var31 = new int[9];

            for(var21 = 0; var21 < 9; ++var21) {
               var20 = 15 + 32 * var21 + 128;
               var3 = 600 + var20 * 3;
               var4 = class94.field1635[var20];
               var31[var21] = var4 * var3 >> 16;
            }

            Region.method1999(var31, 500, 800, 512, 334);
            class33.field742 = "Prepared visibility map";
            class33.field741 = 10;
            Client.field302 = 30;
         } else if(Client.field302 == 30) {
            class0.field16 = Sequence.method891(0, false, true, true);
            class22.field589 = Sequence.method891(1, false, true, true);
            Client.field312 = Sequence.method891(2, true, false, true);
            class56.field1207 = Sequence.method891(3, false, true, true);
            class5.field77 = Sequence.method891(4, false, true, true);
            class62.field1267 = Sequence.method891(5, true, true, true);
            class47.field1050 = Sequence.method891(6, true, true, false);
            XItemContainer.field223 = Sequence.method891(7, false, true, true);
            Item.field690 = Sequence.method891(8, false, true, true);
            class133.field2113 = Sequence.method891(9, false, true, true);
            XItemContainer.field226 = Sequence.method891(10, false, true, true);
            class21.field585 = Sequence.method891(11, false, true, true);
            Client.field531 = Sequence.method891(12, false, true, true);
            class154.field2301 = Sequence.method891(13, true, false, true);
            class167.field2694 = Sequence.method891(14, false, true, false);
            Client.field314 = Sequence.method891(15, false, true, true);
            class33.field742 = "Connecting to update server";
            class33.field741 = 20;
            Client.field302 = 40;
         } else if(Client.field302 == 40) {
            byte var27 = 0;
            var0 = var27 + class0.field16.method3380() * 4 / 100;
            var0 += class22.field589.method3380() * 4 / 100;
            var0 += Client.field312.method3380() * 2 / 100;
            var0 += class56.field1207.method3380() * 2 / 100;
            var0 += class5.field77.method3380() * 6 / 100;
            var0 += class62.field1267.method3380() * 4 / 100;
            var0 += class47.field1050.method3380() * 2 / 100;
            var0 += XItemContainer.field223.method3380() * 60 / 100;
            var0 += Item.field690.method3380() * 2 / 100;
            var0 += class133.field2113.method3380() * 2 / 100;
            var0 += XItemContainer.field226.method3380() * 2 / 100;
            var0 += class21.field585.method3380() * 2 / 100;
            var0 += Client.field531.method3380() * 2 / 100;
            var0 += class154.field2301.method3380() * 2 / 100;
            var0 += class167.field2694.method3380() * 2 / 100;
            var0 += Client.field314.method3380() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field742 = "Checking for updates - " + var0 + "%";
               }

               class33.field741 = 30;
            } else {
               class33.field742 = "Loaded update list";
               class33.field741 = 30;
               Client.field302 = 45;
            }
         } else if(Client.field302 == 45) {
            class9.method114(22050, !Client.field286, 2);
            class187 var30 = new class187();
            var30.method3665(9, 128);
            class0.field14 = class151.method3153(class54.field1146, GameObject.canvas, 0, 22050);
            class0.field14.method1267(var30);
            class9.method116(Client.field314, class167.field2694, class5.field77, var30);
            class134.field2119 = class151.method3153(class54.field1146, GameObject.canvas, 1, 2048);
            WidgetNode.field59 = new class58();
            class134.field2119.method1267(WidgetNode.field59);
            class59.field1234 = new class77(22050, class59.field1235);
            class33.field742 = "Prepared sound engine";
            class33.field741 = 35;
            Client.field302 = 50;
         } else {
            class171 var2;
            int var5;
            class171 var22;
            if(Client.field302 == 50) {
               var0 = 0;
               class227 var26;
               if(XItemContainer.field225 == null) {
                  var2 = Item.field690;
                  var22 = class154.field2301;
                  var4 = var2.method3299("p11_full");
                  var5 = var2.method3361(var4, "");
                  var26 = class53.method1083(var2, var22, var4, var5);
                  XItemContainer.field225 = var26;
               } else {
                  ++var0;
               }

               if(class112.field1962 == null) {
                  var2 = Item.field690;
                  var22 = class154.field2301;
                  var4 = var2.method3299("p12_full");
                  var5 = var2.method3361(var4, "");
                  var26 = class53.method1083(var2, var22, var4, var5);
                  class112.field1962 = var26;
               } else {
                  ++var0;
               }

               if(class79.field1434 == null) {
                  var2 = Item.field690;
                  var22 = class154.field2301;
                  var4 = var2.method3299("b12_full");
                  var5 = var2.method3361(var4, "");
                  var26 = class53.method1083(var2, var22, var4, var5);
                  class79.field1434 = var26;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field742 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class33.field741 = 40;
               } else {
                  class0.field12 = new class163(true);
                  class33.field742 = "Loaded fonts";
                  class33.field741 = 40;
                  Client.field302 = 60;
               }
            } else {
               class171 var25;
               if(Client.field302 == 60) {
                  var25 = XItemContainer.field226;
                  var2 = Item.field690;
                  var3 = 0;
                  if(var25.method3302("title.jpg", "")) {
                     ++var3;
                  }

                  if(var2.method3302("logo", "")) {
                     ++var3;
                  }

                  if(var2.method3302("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var2.method3302("titlebox", "")) {
                     ++var3;
                  }

                  if(var2.method3302("titlebutton", "")) {
                     ++var3;
                  }

                  if(var2.method3302("runes", "")) {
                     ++var3;
                  }

                  if(var2.method3302("title_mute", "")) {
                     ++var3;
                  }

                  if(var2.method3303("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var2.method3303("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var2.method3302("sl_back", "");
                  var2.method3302("sl_flags", "");
                  var2.method3302("sl_arrows", "");
                  var2.method3302("sl_stars", "");
                  var2.method3302("sl_button", "");
                  var4 = class159.method3191();
                  if(var3 < var4) {
                     class33.field742 = "Loading title screen - " + 100 * var3 / var4 + "%";
                     class33.field741 = 50;
                  } else {
                     class33.field742 = "Loaded title screen";
                     class33.field741 = 50;
                     KitDefinition.setGameState(5);
                     Client.field302 = 70;
                  }
               } else if(Client.field302 == 70) {
                  if(!Client.field312.method3288()) {
                     class33.field742 = "Loading config - " + Client.field312.method3387() + "%";
                     class33.field741 = 60;
                  } else {
                     class171 var29 = Client.field312;
                     class48.field1057 = var29;
                     var25 = Client.field312;
                     class43.field981 = var25;
                     var2 = Client.field312;
                     var22 = XItemContainer.field223;
                     KitDefinition.field1041 = var2;
                     class181.field2947 = var22;
                     KitDefinition.field1032 = KitDefinition.field1041.method3321(3);
                     class171 var23 = Client.field312;
                     class171 var24 = XItemContainer.field223;
                     boolean var6 = Client.field286;
                     ObjectComposition.field921 = var23;
                     ObjectComposition.field922 = var24;
                     ObjectComposition.field941 = var6;
                     class171 var7 = Client.field312;
                     class171 var8 = XItemContainer.field223;
                     NPCComposition.field906 = var7;
                     class145.field2224 = var8;
                     class171 var9 = Client.field312;
                     class171 var10 = XItemContainer.field223;
                     boolean var11 = Client.isMembers;
                     class227 var12 = XItemContainer.field225;
                     ItemComposition.field1152 = var9;
                     ItemComposition.field1173 = var10;
                     ItemComposition.isMembersWorld = var11;
                     class192.field3101 = ItemComposition.field1152.method3321(10);
                     ItemComposition.field1158 = var12;
                     class0.method0(Client.field312, class0.field16, class22.field589);
                     class171 var13 = Client.field312;
                     class171 var14 = XItemContainer.field223;
                     class45.field1016 = var13;
                     class45.field1014 = var14;
                     class171 var15 = Client.field312;
                     class50.field1095 = var15;
                     class143.method2972(Client.field312);
                     class157.method3185(class56.field1207, XItemContainer.field223, Item.field690, class154.field2301);
                     class171 var16 = Client.field312;
                     class54.field1142 = var16;
                     Sequence.method920(Client.field312);
                     class171 var17 = Client.field312;
                     class47.field1047 = var17;
                     class171 var18 = Client.field312;
                     class53.field1138 = var18;
                     class126.chatMessages = new ChatMessages();
                     class50.method1025(Client.field312, Item.field690, class154.field2301);
                     class216.method4021(Client.field312, Item.field690);
                     class33.field742 = "Loaded config";
                     class33.field741 = 60;
                     Client.field302 = 80;
                  }
               } else if(Client.field302 != 80) {
                  if(Client.field302 == 90) {
                     if(!class133.field2113.method3288()) {
                        class33.field742 = "Loading textures - " + class133.field2113.method3387() + "%";
                        class33.field741 = 90;
                     } else {
                        TextureProvider var28 = new TextureProvider(class133.field2113, Item.field690, 20, 0.8D, Client.field286?64:128);
                        class94.method2136(var28);
                        class94.method2137(0.8D);
                        class33.field742 = "Loaded textures";
                        class33.field741 = 90;
                        Client.field302 = 110;
                     }
                  } else if(Client.field302 == 110) {
                     class222.field3213 = new class13();
                     class54.field1146.method2910(class222.field3213, 10);
                     class33.field742 = "Loaded input handler";
                     class33.field741 = 94;
                     Client.field302 = 120;
                  } else if(Client.field302 == 120) {
                     if(!XItemContainer.field226.method3302("huffman", "")) {
                        class33.field742 = "Loading wordpack - " + 0 + "%";
                        class33.field741 = 96;
                     } else {
                        class116 var19 = new class116(XItemContainer.field226.method3285("huffman", ""));
                        class153.method3169(var19);
                        class33.field742 = "Loaded wordpack";
                        class33.field741 = 96;
                        Client.field302 = 130;
                     }
                  } else if(Client.field302 == 130) {
                     if(!class56.field1207.method3288()) {
                        class33.field742 = "Loading interfaces - " + class56.field1207.method3387() * 4 / 5 + "%";
                        class33.field741 = 100;
                     } else if(!Client.field531.method3288()) {
                        class33.field742 = "Loading interfaces - " + (80 + Client.field531.method3387() / 6) + "%";
                        class33.field741 = 100;
                     } else if(!class154.field2301.method3288()) {
                        class33.field742 = "Loading interfaces - " + (96 + class154.field2301.method3387() / 20) + "%";
                        class33.field741 = 100;
                     } else {
                        class33.field742 = "Loaded interfaces";
                        class33.field741 = 100;
                        Client.field302 = 140;
                     }
                  } else if(Client.field302 == 140) {
                     KitDefinition.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  SpritePixels var1;
                  if(ObjectComposition.field954 == null) {
                     var2 = Item.field690;
                     var3 = var2.method3299("compass");
                     var4 = var2.method3361(var3, "");
                     var1 = class1.method14(var2, var3, var4);
                     ObjectComposition.field954 = var1;
                  } else {
                     ++var0;
                  }

                  if(ObjectComposition.field972 == null) {
                     var2 = Item.field690;
                     var3 = var2.method3299("mapedge");
                     var4 = var2.method3361(var3, "");
                     var1 = class1.method14(var2, var3, var4);
                     ObjectComposition.field972 = var1;
                  } else {
                     ++var0;
                  }

                  if(null == class24.field623) {
                     class24.field623 = class51.method1062(Item.field690, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class14.field205) {
                     class14.field205 = class158.method3189(Item.field690, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class79.field1428 == null) {
                     class79.field1428 = class158.method3189(Item.field690, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class124.field2067) {
                     class124.field2067 = class158.method3189(Item.field690, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class40.field882) {
                     class40.field882 = class158.method3189(Item.field690, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == class21.field584) {
                     class21.field584 = class158.method3189(Item.field690, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class28.field678) {
                     class28.field678 = class158.method3189(Item.field690, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class4.field74) {
                     class4.field74 = class158.method3189(Item.field690, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class8.field150 == null) {
                     class8.field150 = class51.method1062(Item.field690, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(FileOnDisk.field3266 == null) {
                     FileOnDisk.field3266 = class51.method1062(Item.field690, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class33.field742 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class33.field741 = 70;
                  } else {
                     class226.modIcons = FileOnDisk.field3266;
                     ObjectComposition.field972.method1759();
                     var21 = (int)(Math.random() * 21.0D) - 10;
                     var20 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class14.field205.length; ++var5) {
                        class14.field205[var5].method1754(var21 + var4, var20 + var4, var4 + var3);
                     }

                     class24.field623[0].method1914(var21 + var4, var20 + var4, var3 + var4);
                     class33.field742 = "Loaded sprites";
                     class33.field741 = 70;
                     Client.field302 = 90;
                  }
               }
            }
         }
      }
   }

   class20(int var1, int var2, int var3, int var4) {
      this.field570 = var1;
      this.field569 = var2;
      this.field566 = var3;
      this.field568 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "17529"
   )
   static final String method563(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "1792085377"
   )
   public static boolean method565(String var0, int var1) {
      return SecondaryBufferProvider.method1668(var0, var1, "openjs");
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "2069633112"
   )
   static String method566(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class164.field2679[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class164.field2679[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class164.field2679[(var6 & 15) << 2 | var7 >>> 6]).append(class164.field2679[var7 & 63]);
            } else {
               var3.append(class164.field2679[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class164.field2679[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "126"
   )
   static int method567(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3849((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
