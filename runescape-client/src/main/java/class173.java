import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public class class173 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-960261136"
   )
   static void method3236() {
      int var0;
      if(Client.field542 == 0) {
         class6.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         class179.field2668 = new SpritePixels(512, 512);
         class41.field826 = "Starting game engine...";
         class41.field825 = 5;
         Client.field542 = 20;
      } else {
         int var1;
         int var3;
         int var4;
         int var7;
         if(Client.field542 == 20) {
            int[] var16 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var7 = 15 + var1 * 32 + 128;
               var3 = 600 + var7 * 3;
               var4 = class84.field1438[var7];
               var16[var1] = var4 * var3 >> 16;
            }

            Region.method1705(var16, 500, 800, 512, 334);
            class41.field826 = "Prepared visibility map";
            class41.field825 = 10;
            Client.field542 = 30;
         } else if(Client.field542 == 30) {
            class5.field46 = class6.method98(0, false, true, true);
            class11.field120 = class6.method98(1, false, true, true);
            class48.field936 = class6.method98(2, true, false, true);
            Client.field349 = class6.method98(3, false, true, true);
            class10.field94 = class6.method98(4, false, true, true);
            Client.field563 = class6.method98(5, true, true, true);
            class37.field781 = class6.method98(6, true, true, false);
            Client.field314 = class6.method98(7, false, true, true);
            class0.field4 = class6.method98(8, false, true, true);
            class5.field49 = class6.method98(9, false, true, true);
            ChatLineBuffer.field956 = class6.method98(10, false, true, true);
            class162.field2136 = class6.method98(11, false, true, true);
            class137.field1898 = class6.method98(12, false, true, true);
            class119.field1843 = class6.method98(13, true, false, true);
            XItemContainer.field136 = class6.method98(14, false, true, false);
            Client.field343 = class6.method98(15, false, true, true);
            class41.field826 = "Connecting to update server";
            class41.field825 = 20;
            Client.field542 = 40;
         } else if(Client.field542 == 40) {
            byte var19 = 0;
            var0 = var19 + class5.field46.method3356() * 4 / 100;
            var0 += class11.field120.method3356() * 4 / 100;
            var0 += class48.field936.method3356() * 2 / 100;
            var0 += Client.field349.method3356() * 2 / 100;
            var0 += class10.field94.method3356() * 6 / 100;
            var0 += Client.field563.method3356() * 4 / 100;
            var0 += class37.field781.method3356() * 2 / 100;
            var0 += Client.field314.method3356() * 60 / 100;
            var0 += class0.field4.method3356() * 2 / 100;
            var0 += class5.field49.method3356() * 2 / 100;
            var0 += ChatLineBuffer.field956.method3356() * 2 / 100;
            var0 += class162.field2136.method3356() * 2 / 100;
            var0 += class137.field1898.method3356() * 2 / 100;
            var0 += class119.field1843.method3356() * 2 / 100;
            var0 += XItemContainer.field136.method3356() * 2 / 100;
            var0 += Client.field343.method3356() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field826 = "Checking for updates - " + var0 + "%";
               }

               class41.field825 = 30;
            } else {
               class41.field826 = "Loaded update list";
               class41.field825 = 30;
               Client.field542 = 45;
            }
         } else {
            class184 var2;
            class184 var9;
            class184 var17;
            if(Client.field542 == 45) {
               XClanMember.method241(22050, !Client.field286, 2);
               class139 var15 = new class139();
               var15.method2580(9, 128);
               Client.field522 = Friend.method175(class44.field881, class165.canvas, 0, 22050);
               Client.field522.method1024(var15);
               var17 = Client.field343;
               var2 = XItemContainer.field136;
               var9 = class10.field94;
               class138.field1901 = var17;
               class138.field1902 = var2;
               Ignore.field210 = var9;
               class138.field1899 = var15;
               class13.field150 = Friend.method175(class44.field881, class165.canvas, 1, 2048);
               class20.field222 = new class51();
               class13.field150.method1024(class20.field222);
               class140.field1961 = new class65(22050, class7.field65);
               class41.field826 = "Prepared sound engine";
               class41.field825 = 35;
               Client.field542 = 50;
            } else {
               int var5;
               if(Client.field542 == 50) {
                  var0 = 0;
                  class208 var18;
                  if(FileOnDisk.field1186 == null) {
                     var2 = class0.field4;
                     var9 = class119.field1843;
                     var4 = var2.method3277("p11_full");
                     var5 = var2.method3278(var4, "");
                     var18 = class63.method1110(var2, var9, var4, var5);
                     FileOnDisk.field1186 = var18;
                  } else {
                     ++var0;
                  }

                  if(null == class22.field235) {
                     var2 = class0.field4;
                     var9 = class119.field1843;
                     var4 = var2.method3277("p12_full");
                     var5 = var2.method3278(var4, "");
                     var18 = class63.method1110(var2, var9, var4, var5);
                     class22.field235 = var18;
                  } else {
                     ++var0;
                  }

                  if(class97.field1621 == null) {
                     var2 = class0.field4;
                     var9 = class119.field1843;
                     var4 = var2.method3277("b12_full");
                     var5 = var2.method3278(var4, "");
                     var18 = class63.method1110(var2, var9, var4, var5);
                     class97.field1621 = var18;
                  } else {
                     ++var0;
                  }

                  if(var0 < 3) {
                     class41.field826 = "Loading fonts - " + 100 * var0 / 3 + "%";
                     class41.field825 = 40;
                  } else {
                     DecorativeObject.field1595 = new class230(true);
                     class41.field826 = "Loaded fonts";
                     class41.field825 = 40;
                     Client.field542 = 60;
                  }
               } else if(Client.field542 == 60) {
                  var0 = FrameMap.method1664(ChatLineBuffer.field956, class0.field4);
                  byte var12 = 9;
                  if(var0 < var12) {
                     class41.field826 = "Loading title screen - " + var0 * 100 / var12 + "%";
                     class41.field825 = 50;
                  } else {
                     class41.field826 = "Loaded title screen";
                     class41.field825 = 50;
                     Friend.setGameState(5);
                     Client.field542 = 70;
                  }
               } else if(Client.field542 == 70) {
                  if(!class48.field936.method3282()) {
                     class41.field826 = "Loading config - " + class48.field936.method3355() + "%";
                     class41.field825 = 60;
                  } else {
                     class149.method2744(class48.field936);
                     class116.method2223(class48.field936);
                     class171.method3234(class48.field936, Client.field314);
                     class138.method2475(class48.field936, Client.field314, Client.field286);
                     class2.method30(class48.field936, Client.field314);
                     class146.method2712(class48.field936, Client.field314, Client.isMembers, FileOnDisk.field1186);
                     class142.method2664(class48.field936, class5.field46, class11.field120);
                     class184 var14 = class48.field936;
                     var17 = Client.field314;
                     class190.field2778 = var14;
                     class190.field2781 = var17;
                     var2 = class48.field936;
                     class194.field2836 = var2;
                     class104.method1951(class48.field936);
                     class22.method209(Client.field349, Client.field314, class0.field4, class119.field1843);
                     var9 = class48.field936;
                     class186.field2748 = var9;
                     class184 var10 = class48.field936;
                     class195.field2847 = var10;
                     MessageNode.method201(class48.field936);
                     class184 var11 = class48.field936;
                     class189.field2764 = var11;
                     Renderable.chatMessages = new ChatMessages();
                     CombatInfoListHolder.method701(class48.field936, class0.field4, class119.field1843);
                     class116.method2213(class48.field936, class0.field4);
                     class41.field826 = "Loaded config";
                     class41.field825 = 60;
                     Client.field542 = 80;
                  }
               } else if(Client.field542 != 80) {
                  if(Client.field542 == 90) {
                     if(!class5.field49.method3282()) {
                        class41.field826 = "Loading textures - " + class5.field49.method3355() + "%";
                        class41.field825 = 90;
                     } else {
                        TextureProvider var13 = new TextureProvider(class5.field49, class0.field4, 20, 0.8D, Client.field286?64:128);
                        class84.method1605(var13);
                        class84.method1606(0.8D);
                        class41.field826 = "Loaded textures";
                        class41.field825 = 90;
                        Client.field542 = 110;
                     }
                  } else if(Client.field542 == 110) {
                     class191.field2796 = new class20();
                     class44.field881.method1916(class191.field2796, 10);
                     class41.field826 = "Loaded input handler";
                     class41.field825 = 94;
                     Client.field542 = 120;
                  } else if(Client.field542 == 120) {
                     if(!ChatLineBuffer.field956.method3280("huffman", "")) {
                        class41.field826 = "Loading wordpack - " + 0 + "%";
                        class41.field825 = 96;
                     } else {
                        class145 var6 = new class145(ChatLineBuffer.field956.method3279("huffman", ""));
                        class210.field3106 = var6;
                        class41.field826 = "Loaded wordpack";
                        class41.field825 = 96;
                        Client.field542 = 130;
                     }
                  } else if(Client.field542 == 130) {
                     if(!Client.field349.method3282()) {
                        class41.field826 = "Loading interfaces - " + Client.field349.method3355() * 4 / 5 + "%";
                        class41.field825 = 100;
                     } else if(!class137.field1898.method3282()) {
                        class41.field826 = "Loading interfaces - " + (80 + class137.field1898.method3355() / 6) + "%";
                        class41.field825 = 100;
                     } else if(!class119.field1843.method3282()) {
                        class41.field826 = "Loading interfaces - " + (96 + class119.field1843.method3355() / 20) + "%";
                        class41.field825 = 100;
                     } else {
                        class41.field826 = "Loaded interfaces";
                        class41.field825 = 100;
                        Client.field542 = 140;
                     }
                  } else if(Client.field542 == 140) {
                     Friend.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  SpritePixels var8;
                  if(null == class8.field73) {
                     var2 = class0.field4;
                     var3 = var2.method3277("compass");
                     var4 = var2.method3278(var3, "");
                     var8 = TextureProvider.method1410(var2, var3, var4);
                     class8.field73 = var8;
                  } else {
                     ++var0;
                  }

                  if(null == class45.field901) {
                     var2 = class0.field4;
                     var3 = var2.method3277("mapedge");
                     var4 = var2.method3278(var3, "");
                     var8 = TextureProvider.method1410(var2, var3, var4);
                     class45.field901 = var8;
                  } else {
                     ++var0;
                  }

                  if(null == class114.field1780) {
                     class114.field1780 = Buffer.method2988(class0.field4, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(null == class210.field3104) {
                     class210.field3104 = class25.method592(class0.field4, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(class140.field1936 == null) {
                     class140.field1936 = class25.method592(class0.field4, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class7.field66) {
                     class7.field66 = class25.method592(class0.field4, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(Player.field253 == null) {
                     Player.field253 = class25.method592(class0.field4, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == class167.field2169) {
                     class167.field2169 = class25.method592(class0.field4, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class145.field2001) {
                     class145.field2001 = class25.method592(class0.field4, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class161.field2129) {
                     class161.field2129 = class25.method592(class0.field4, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(TextureProvider.field1200 == null) {
                     TextureProvider.field1200 = Buffer.method2988(class0.field4, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class97.field1626 == null) {
                     class97.field1626 = Buffer.method2988(class0.field4, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class41.field826 = "Loading sprites - " + 100 * var0 / 12 + "%";
                     class41.field825 = 70;
                  } else {
                     class209.modIcons = class97.field1626;
                     class45.field901.method4205();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var7 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class210.field3104.length; ++var5) {
                        class210.field3104[var5].method4113(var4 + var1, var7 + var4, var4 + var3);
                     }

                     class114.field1780[0].method4068(var4 + var1, var4 + var7, var4 + var3);
                     class41.field826 = "Loaded sprites";
                     class41.field825 = 70;
                     Client.field542 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "774674664"
   )
   static void method3237() {
      for(class31 var0 = (class31)class31.field703.method2391(); null != var0; var0 = (class31)class31.field703.method2393()) {
         if(var0.field706 != null) {
            class20.field222.method903(var0.field706);
            var0.field706 = null;
         }

         if(null != var0.field698) {
            class20.field222.method903(var0.field698);
            var0.field698 = null;
         }
      }

      class31.field703.method2385();
   }
}
