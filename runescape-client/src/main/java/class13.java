import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class13 {
   @ObfuscatedName("no")
   static class65 field141;
   @ObfuscatedName("bp")
   static class184 field142;
   @ObfuscatedName("co")
   static class110 field143;
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 849349291
   )
   static int field148;

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "1102288338"
   )
   static final WidgetNode method164(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field191 = var2;
      Client.componentTable.method2291(var3, (long)var0);
      class20.method194(var1);
      Widget var4 = class174.method3178(var0);
      class97.method1886(var4);
      if(null != Client.field448) {
         class97.method1886(Client.field448);
         Client.field448 = null;
      }

      Frames.method1850();
      Renderable.method1833(Widget.widgets[var0 >> 16], var4, false);
      class22.method207(var1);
      if(Client.widgetRoot != -1) {
         XGrandExchangeOffer.method45(Client.widgetRoot, 1);
      }

      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass18;I)V",
      garbageValue = "-810449481"
   )
   static void method165(class18 var0) {
      XItemContainer.method162(var0, 200000);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "598946340"
   )
   static String method166(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "14790"
   )
   static final void method167(String var0, boolean var1) {
      if(null != var0) {
         if((Client.ignoreCount < 100 || Client.field409 == 1) && Client.ignoreCount < 400) {
            String var2 = class162.method3013(var0, Friend.field155);
            if(null != var2) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < Client.ignoreCount; ++var3) {
                  Ignore var4 = Client.ignores[var3];
                  var5 = class162.method3013(var4.name, Friend.field155);
                  if(null != var5 && var5.equals(var2)) {
                     class16.method183(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(var4.previousName != null) {
                     var6 = class162.method3013(var4.previousName, Friend.field155);
                     if(null != var6 && var6.equals(var2)) {
                        class16.method183(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < Client.friendCount; ++var3) {
                  Friend var7 = Client.friends[var3];
                  var5 = class162.method3013(var7.name, Friend.field155);
                  if(null != var5 && var5.equals(var2)) {
                     class16.method183(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(null != var7.previousName) {
                     var6 = class162.method3013(var7.previousName, Friend.field155);
                     if(var6 != null && var6.equals(var2)) {
                        class16.method183(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class162.method3013(class5.localPlayer.name, Friend.field155).equals(var2)) {
                  class16.method183(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  Client.field330.method2967(161);
                  Client.field330.method2815(class112.method2050(var0));
                  Client.field330.method2717(var0);
               }
            }
         } else {
            class16.method183(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIILRegion;[LCollisionData;I)V",
      garbageValue = "1629223580"
   )
   static final void method168(byte[] var0, int var1, int var2, Region var3, CollisionData[] var4) {
      Buffer var5 = new Buffer(var0);
      int var6 = -1;

      while(true) {
         int var7 = var5.method2842();
         if(var7 == 0) {
            return;
         }

         var6 += var7;
         int var8 = 0;

         while(true) {
            int var9 = var5.method2842();
            if(var9 == 0) {
               break;
            }

            var8 += var9 - 1;
            int var10 = var8 & 63;
            int var11 = var8 >> 6 & 63;
            int var12 = var8 >> 12;
            int var13 = var5.readUnsignedByte();
            int var14 = var13 >> 2;
            int var15 = var13 & 3;
            int var16 = var1 + var11;
            int var17 = var10 + var2;
            if(var16 > 0 && var17 > 0 && var16 < 103 && var17 < 103) {
               int var18 = var12;
               if((class10.tileSettings[1][var16][var17] & 2) == 2) {
                  var18 = var12 - 1;
               }

               CollisionData var19 = null;
               if(var18 >= 0) {
                  var19 = var4[var18];
               }

               class195.method3463(var12, var16, var17, var6, var15, var14, var3, var19);
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-33468934"
   )
   static void method169() {
      int var0;
      if(Client.field382 == 0) {
         class159.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class154.field2118 = new SpritePixels(512, 512);
         class41.field843 = "Starting game engine...";
         class41.field837 = 5;
         Client.field382 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field382 == 20) {
            int[] var27 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = var2 * 3 + 600;
               var4 = class84.field1435[var2];
               var27[var1] = var4 * var3 >> 16;
            }

            Region.method1681(var27, 500, 800, 512, 334);
            class41.field843 = "Prepared visibility map";
            class41.field837 = 10;
            Client.field382 = 30;
         } else if(Client.field382 == 30) {
            class45.field915 = class31.method657(0, false, true, true);
            class18.field192 = class31.method657(1, false, true, true);
            class165.field2178 = class31.method657(2, true, false, true);
            class9.field75 = class31.method657(3, false, true, true);
            class103.field1665 = class31.method657(4, false, true, true);
            ChatLineBuffer.field970 = class31.method657(5, true, true, true);
            class119.field1864 = class31.method657(6, true, true, false);
            class217.field3168 = class31.method657(7, false, true, true);
            class206.field3086 = class31.method657(8, false, true, true);
            field142 = class31.method657(9, false, true, true);
            class25.field587 = class31.method657(10, false, true, true);
            Friend.field160 = class31.method657(11, false, true, true);
            CombatInfo2.field2844 = class31.method657(12, false, true, true);
            class45.field907 = class31.method657(13, true, false, true);
            class204.field3076 = class31.method657(14, false, true, false);
            class25.field583 = class31.method657(15, false, true, true);
            class41.field843 = "Connecting to update server";
            class41.field837 = 20;
            Client.field382 = 40;
         } else if(Client.field382 == 40) {
            byte var24 = 0;
            var0 = var24 + class45.field915.method3294() * 4 / 100;
            var0 += class18.field192.method3294() * 4 / 100;
            var0 += class165.field2178.method3294() * 2 / 100;
            var0 += class9.field75.method3294() * 2 / 100;
            var0 += class103.field1665.method3294() * 6 / 100;
            var0 += ChatLineBuffer.field970.method3294() * 4 / 100;
            var0 += class119.field1864.method3294() * 2 / 100;
            var0 += class217.field3168.method3294() * 60 / 100;
            var0 += class206.field3086.method3294() * 2 / 100;
            var0 += field142.method3294() * 2 / 100;
            var0 += class25.field587.method3294() * 2 / 100;
            var0 += Friend.field160.method3294() * 2 / 100;
            var0 += CombatInfo2.field2844.method3294() * 2 / 100;
            var0 += class45.field907.method3294() * 2 / 100;
            var0 += class204.field3076.method3294() * 2 / 100;
            var0 += class25.field583.method3294() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field843 = "Checking for updates - " + var0 + "%";
               }

               class41.field837 = 30;
            } else {
               class41.field843 = "Loaded update list";
               class41.field837 = 30;
               Client.field382 = 45;
            }
         } else if(Client.field382 == 45) {
            boolean var23 = !Client.field314;
            class57.field1042 = 22050;
            class57.field1044 = var23;
            class0.field0 = 2;
            class139 var29 = new class139();
            var29.method2495(9, 128);
            class88.field1527 = XClanMember.method236(Tile.field1346, class36.canvas, 0, 22050);
            class88.field1527.method1019(var29);
            class105.method1969(class25.field583, class204.field3076, class103.field1665, var29);
            class8.field62 = XClanMember.method236(Tile.field1346, class36.canvas, 1, 2048);
            FaceNormal.field1554 = new class51();
            class8.field62.method1019(FaceNormal.field1554);
            field141 = new class65(22050, class57.field1042);
            class41.field843 = "Prepared sound engine";
            class41.field837 = 35;
            Client.field382 = 50;
         } else {
            class184 var18;
            class184 var20;
            int var21;
            if(Client.field382 == 50) {
               var0 = 0;
               class208 var28;
               if(null == class5.field40) {
                  var18 = class206.field3086;
                  var20 = class45.field907;
                  var4 = var18.method3218("p11_full");
                  var21 = var18.method3219(var4, "");
                  var28 = class2.method18(var18, var20, var4, var21);
                  class5.field40 = var28;
               } else {
                  ++var0;
               }

               if(class33.field757 == null) {
                  var18 = class206.field3086;
                  var20 = class45.field907;
                  var4 = var18.method3218("p12_full");
                  var21 = var18.method3219(var4, "");
                  var28 = class2.method18(var18, var20, var4, var21);
                  class33.field757 = var28;
               } else {
                  ++var0;
               }

               if(null == Ignore.field218) {
                  var18 = class206.field3086;
                  var20 = class45.field907;
                  var4 = var18.method3218("b12_full");
                  var21 = var18.method3219(var4, "");
                  var28 = class2.method18(var18, var20, var4, var21);
                  Ignore.field218 = var28;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field843 = "Loading fonts - " + var0 * 100 / 3 + "%";
                  class41.field837 = 40;
               } else {
                  class118.field1854 = new class230(true);
                  class41.field843 = "Loaded fonts";
                  class41.field837 = 40;
                  Client.field382 = 60;
               }
            } else {
               class184 var19;
               if(Client.field382 == 60) {
                  var19 = class25.field587;
                  var18 = class206.field3086;
                  var3 = 0;
                  if(var19.method3221("title.jpg", "")) {
                     ++var3;
                  }

                  if(var18.method3221("logo", "")) {
                     ++var3;
                  }

                  if(var18.method3221("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var18.method3221("titlebox", "")) {
                     ++var3;
                  }

                  if(var18.method3221("titlebutton", "")) {
                     ++var3;
                  }

                  if(var18.method3221("runes", "")) {
                     ++var3;
                  }

                  if(var18.method3221("title_mute", "")) {
                     ++var3;
                  }

                  if(var18.method3222("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var18.method3222("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var18.method3221("sl_back", "");
                  var18.method3221("sl_flags", "");
                  var18.method3221("sl_arrows", "");
                  var18.method3221("sl_stars", "");
                  var18.method3221("sl_button", "");
                  var4 = class60.method1132();
                  if(var3 < var4) {
                     class41.field843 = "Loading title screen - " + 100 * var3 / var4 + "%";
                     class41.field837 = 50;
                  } else {
                     class41.field843 = "Loaded title screen";
                     class41.field837 = 50;
                     class20.setGameState(5);
                     Client.field382 = 70;
                  }
               } else if(Client.field382 == 70) {
                  if(!class165.field2178.method3207()) {
                     class41.field843 = "Loading config - " + class165.field2178.method3300() + "%";
                     class41.field837 = 60;
                  } else {
                     class184 var26 = class165.field2178;
                     class200.field3039 = var26;
                     var19 = class165.field2178;
                     class0.field3 = var19;
                     var18 = class165.field2178;
                     var20 = class217.field3168;
                     KitDefinition.field2828 = var18;
                     class8.field60 = var20;
                     KitDefinition.field2819 = KitDefinition.field2828.method3245(3);
                     class184 var22 = class165.field2178;
                     class184 var5 = class217.field3168;
                     boolean var6 = Client.field314;
                     ObjectComposition.field2926 = var22;
                     class203.field3070 = var5;
                     ObjectComposition.field2891 = var6;
                     GameObject.method1880(class165.field2178, class217.field3168);
                     class196.method3511(class165.field2178, class217.field3168, Client.isMembers, class5.field40);
                     WallObject.method1841(class165.field2178, class45.field915, class18.field192);
                     class184 var7 = class165.field2178;
                     class184 var8 = class217.field3168;
                     class190.field2800 = var7;
                     class187.field2783 = var8;
                     class160.method2996(class165.field2178);
                     class48.method876(class165.field2178);
                     class184 var9 = class9.field75;
                     class184 var10 = class217.field3168;
                     class184 var11 = class206.field3086;
                     class184 var12 = class45.field907;
                     Ignore.field216 = var9;
                     Widget.field2284 = var10;
                     Frames.field1559 = var11;
                     Item.field892 = var12;
                     Widget.widgets = new Widget[Ignore.field216.method3254()][];
                     class88.validInterfaces = new boolean[Ignore.field216.method3254()];
                     class172.method3176(class165.field2178);
                     class184 var13 = class165.field2178;
                     class195.field2855 = var13;
                     class184 var14 = class165.field2178;
                     class188.field2787 = var14;
                     class139.method2564(class165.field2178);
                     class109.chatMessages = new ChatMessages();
                     class182.method3253(class165.field2178, class206.field3086, class45.field907);
                     class184 var15 = class165.field2178;
                     class184 var16 = class206.field3086;
                     CombatInfo2.field2838 = var15;
                     CombatInfo2.field2831 = var16;
                     class41.field843 = "Loaded config";
                     class41.field837 = 60;
                     Client.field382 = 80;
                  }
               } else if(Client.field382 != 80) {
                  if(Client.field382 == 90) {
                     if(!field142.method3207()) {
                        class41.field843 = "Loading textures - " + field142.method3300() + "%";
                        class41.field837 = 90;
                     } else {
                        TextureProvider var25 = new TextureProvider(field142, class206.field3086, 20, 0.8D, Client.field314?64:128);
                        class84.method1603(var25);
                        class84.method1643(0.8D);
                        class41.field843 = "Loaded textures";
                        class41.field837 = 90;
                        Client.field382 = 110;
                     }
                  } else if(Client.field382 == 110) {
                     World.field695 = new class20();
                     Tile.field1346.method1939(World.field695, 10);
                     class41.field843 = "Loaded input handler";
                     class41.field837 = 94;
                     Client.field382 = 120;
                  } else if(Client.field382 == 120) {
                     if(!class25.field587.method3221("huffman", "")) {
                        class41.field843 = "Loading wordpack - " + 0 + "%";
                        class41.field837 = 96;
                     } else {
                        class145 var17 = new class145(class25.field587.method3220("huffman", ""));
                        class9.field78 = var17;
                        class41.field843 = "Loaded wordpack";
                        class41.field837 = 96;
                        Client.field382 = 130;
                     }
                  } else if(Client.field382 == 130) {
                     if(!class9.field75.method3207()) {
                        class41.field843 = "Loading interfaces - " + class9.field75.method3300() * 4 / 5 + "%";
                        class41.field837 = 100;
                     } else if(!CombatInfo2.field2844.method3207()) {
                        class41.field843 = "Loading interfaces - " + (80 + CombatInfo2.field2844.method3300() / 6) + "%";
                        class41.field837 = 100;
                     } else if(!class45.field907.method3207()) {
                        class41.field843 = "Loading interfaces - " + (96 + class45.field907.method3300() / 20) + "%";
                        class41.field837 = 100;
                     } else {
                        class41.field843 = "Loaded interfaces";
                        class41.field837 = 100;
                        Client.field382 = 140;
                     }
                  } else if(Client.field382 == 140) {
                     class20.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  if(class159.field2139 == null) {
                     class159.field2139 = class155.method2935(class206.field3086, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(class88.field1526 == null) {
                     class88.field1526 = class155.method2935(class206.field3086, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class38.field808 == null) {
                     class38.field808 = class116.method2197(class206.field3086, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class15.field164) {
                     class15.field164 = class99.method1900(class206.field3086, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class32.field740 == null) {
                     class32.field740 = class99.method1900(class206.field3086, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class150.field2061) {
                     class150.field2061 = class99.method1900(class206.field3086, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class143.field2019 == null) {
                     class143.field2019 = class99.method1900(class206.field3086, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(Player.field274 == null) {
                     Player.field274 = class99.method1900(class206.field3086, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class8.field63) {
                     class8.field63 = class99.method1900(class206.field3086, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(class160.field2142 == null) {
                     class160.field2142 = class99.method1900(class206.field3086, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class211.field3121 == null) {
                     class211.field3121 = class116.method2197(class206.field3086, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class143.field2021 == null) {
                     class143.field2021 = class116.method2197(class206.field3086, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class41.field843 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class41.field837 = 70;
                  } else {
                     class209.modIcons = class143.field2021;
                     class88.field1526.method4042();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var21 = 0; var21 < class15.field164.length; ++var21) {
                        class15.field164[var21].method4041(var1 + var4, var2 + var4, var4 + var3);
                     }

                     class38.field808[0].method3992(var4 + var1, var2 + var4, var4 + var3);
                     class41.field843 = "Loaded sprites";
                     class41.field837 = 70;
                     Client.field382 = 90;
                  }
               }
            }
         }
      }
   }
}
