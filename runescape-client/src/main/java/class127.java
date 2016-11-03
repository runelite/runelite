import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public class class127 {
   @ObfuscatedName("bz")
   static class171 field2092;

   @ObfuscatedName("k")
   public static final void method2846(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1879762343"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class116.method2506();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field313 = 0;
            Client.field529 = 0;
            Client.field310 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class12.field178) {
            class12.field178.method3020();
            class12.field178 = null;
         }

         if(Client.gameState == 25) {
            Client.field548 = 0;
            Client.field336 = 0;
            Client.field337 = 1;
            Client.field514 = 0;
            Client.field296 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class113.method2488(VertexNormal.canvas, class158.field2343, field2092, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class113.method2488(VertexNormal.canvas, class158.field2343, field2092, false, 4);
            } else if(class33.field745) {
               class33.field730 = null;
               class232.field3280 = null;
               class14.field209 = null;
               class33.field748 = null;
               class33.field732 = null;
               class33.field733 = null;
               class5.field76 = null;
               Ignore.field128 = null;
               class50.field1109 = null;
               FrameMap.field1828 = null;
               class11.field165 = null;
               class110.field1944 = null;
               class110.field1942 = null;
               WidgetNode.field59 = null;
               class23.field594 = null;
               class33.field738 = null;
               class21.field582 = null;
               class178.field2945 = null;
               class217.field3202 = null;
               class31.field715 = null;
               class9.field153 = null;
               class33.field741 = null;
               XItemContainer.method167(2);
               class125.method2808(true);
               class33.field745 = false;
            }
         } else {
            class113.method2488(VertexNormal.canvas, class158.field2343, field2092, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-980219465"
   )
   static void method2849() {
      int var0;
      if(Client.field306 == 0) {
         Frames.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         DecorativeObject.field1677 = new SpritePixels(512, 512);
         class33.field742 = "Starting game engine...";
         class33.field744 = 5;
         Client.field306 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field306 == 20) {
            int[] var22 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = 3 * var2 + 600;
               var4 = class94.field1650[var2];
               var22[var1] = var3 * var4 >> 16;
            }

            Region.method1995(var22, 500, 800, 512, 334);
            class33.field742 = "Prepared visibility map";
            class33.field744 = 10;
            Client.field306 = 30;
         } else if(Client.field306 == 30) {
            class35.field789 = class22.method586(0, false, true, true);
            class158.field2336 = class22.method586(1, false, true, true);
            class13.field200 = class22.method586(2, true, false, true);
            Buffer.field2060 = class22.method586(3, false, true, true);
            class13.field195 = class22.method586(4, false, true, true);
            class38.field820 = class22.method586(5, true, true, true);
            Client.field423 = class22.method586(6, true, true, false);
            class1.field13 = class22.method586(7, false, true, true);
            field2092 = class22.method586(8, false, true, true);
            class59.field1254 = class22.method586(9, false, true, true);
            class158.field2343 = class22.method586(10, false, true, true);
            class9.field151 = class22.method586(11, false, true, true);
            Client.field311 = class22.method586(12, false, true, true);
            MessageNode.field802 = class22.method586(13, true, false, true);
            FrameMap.field1829 = class22.method586(14, false, true, false);
            class109.field1932 = class22.method586(15, false, true, true);
            class33.field742 = "Connecting to update server";
            class33.field744 = 20;
            Client.field306 = 40;
         } else if(Client.field306 == 40) {
            byte var19 = 0;
            var0 = var19 + class35.field789.method3365() * 4 / 100;
            var0 += class158.field2336.method3365() * 4 / 100;
            var0 += class13.field200.method3365() * 2 / 100;
            var0 += Buffer.field2060.method3365() * 2 / 100;
            var0 += class13.field195.method3365() * 6 / 100;
            var0 += class38.field820.method3365() * 4 / 100;
            var0 += Client.field423.method3365() * 2 / 100;
            var0 += class1.field13.method3365() * 60 / 100;
            var0 += field2092.method3365() * 2 / 100;
            var0 += class59.field1254.method3365() * 2 / 100;
            var0 += class158.field2343.method3365() * 2 / 100;
            var0 += class9.field151.method3365() * 2 / 100;
            var0 += Client.field311.method3365() * 2 / 100;
            var0 += MessageNode.field802.method3365() * 2 / 100;
            var0 += FrameMap.field1829.method3365() * 2 / 100;
            var0 += class109.field1932.method3365() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field742 = "Checking for updates - " + var0 + "%";
               }

               class33.field744 = 30;
            } else {
               class33.field742 = "Loaded update list";
               class33.field744 = 30;
               Client.field306 = 45;
            }
         } else {
            class171 var12;
            class171 var13;
            class171 var16;
            if(Client.field306 == 45) {
               boolean var18 = !Client.field282;
               class59.field1249 = 22050;
               class59.field1238 = var18;
               class59.field1235 = 2;
               class187 var24 = new class187();
               var24.method3647(9, 128);
               class141.field2184 = Sequence.method933(Item.field699, VertexNormal.canvas, 0, 22050);
               class141.field2184.method1216(var24);
               var12 = class109.field1932;
               var16 = FrameMap.field1829;
               var13 = class13.field195;
               class186.field3012 = var12;
               class186.field3005 = var16;
               class186.field3009 = var13;
               class186.field3008 = var24;
               class178.field2948 = Sequence.method933(Item.field699, VertexNormal.canvas, 1, 2048);
               class112.field1970 = new class58();
               class178.field2948.method1216(class112.field1970);
               class166.field2695 = new class77(22050, class59.field1249);
               class33.field742 = "Prepared sound engine";
               class33.field744 = 35;
               Client.field306 = 50;
            } else if(Client.field306 == 50) {
               var0 = 0;
               if(null == class52.field1149) {
                  class52.field1149 = class32.method689(field2092, MessageNode.field802, "p11_full", "");
               } else {
                  ++var0;
               }

               if(MessageNode.field800 == null) {
                  MessageNode.field800 = class32.method689(field2092, MessageNode.field802, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == PlayerComposition.field2977) {
                  PlayerComposition.field2977 = class32.method689(field2092, MessageNode.field802, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field742 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class33.field744 = 40;
               } else {
                  class144.field2218 = new class163(true);
                  class33.field742 = "Loaded fonts";
                  class33.field744 = 40;
                  Client.field306 = 60;
               }
            } else {
               class171 var23;
               if(Client.field306 == 60) {
                  var23 = class158.field2343;
                  var12 = field2092;
                  var3 = 0;
                  if(var23.method3351("title.jpg", "")) {
                     ++var3;
                  }

                  if(var12.method3351("logo", "")) {
                     ++var3;
                  }

                  if(var12.method3351("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var12.method3351("titlebox", "")) {
                     ++var3;
                  }

                  if(var12.method3351("titlebutton", "")) {
                     ++var3;
                  }

                  if(var12.method3351("runes", "")) {
                     ++var3;
                  }

                  if(var12.method3351("title_mute", "")) {
                     ++var3;
                  }

                  if(var12.method3299("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var12.method3299("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var12.method3351("sl_back", "");
                  var12.method3351("sl_flags", "");
                  var12.method3351("sl_arrows", "");
                  var12.method3351("sl_stars", "");
                  var12.method3351("sl_button", "");
                  var4 = XItemContainer.method166();
                  if(var3 < var4) {
                     class33.field742 = "Loading title screen - " + var3 * 100 / var4 + "%";
                     class33.field744 = 50;
                  } else {
                     class33.field742 = "Loaded title screen";
                     class33.field744 = 50;
                     setGameState(5);
                     Client.field306 = 70;
                  }
               } else if(Client.field306 == 70) {
                  if(!class13.field200.method3284()) {
                     class33.field742 = "Loading config - " + class13.field200.method3376() + "%";
                     class33.field744 = 60;
                  } else {
                     class171 var21 = class13.field200;
                     class169.field2712 = var21;
                     var23 = class13.field200;
                     class43.field999 = var23;
                     var12 = class13.field200;
                     var16 = class1.field13;
                     KitDefinition.field1054 = var12;
                     KitDefinition.field1051 = var16;
                     class28.field670 = KitDefinition.field1054.method3290(3);
                     class43.method888(class13.field200, class1.field13, Client.field282);
                     class16.method170(class13.field200, class1.field13);
                     class155.method3177(class13.field200, class1.field13, Client.isMembers, class52.field1149);
                     var13 = class13.field200;
                     class171 var17 = class35.field789;
                     class171 var6 = class158.field2336;
                     Sequence.field1007 = var13;
                     Sequence.field1028 = var17;
                     Sequence.field1020 = var6;
                     Actor.method790(class13.field200, class1.field13);
                     class171 var7 = class13.field200;
                     class50.field1104 = var7;
                     class171 var8 = class13.field200;
                     class56.field1225 = var8;
                     class56.field1222 = class56.field1225.method3290(16);
                     class146.method3042(Buffer.field2060, class1.field13, field2092, MessageNode.field802);
                     class171 var9 = class13.field200;
                     class54.field1165 = var9;
                     class171 var10 = class13.field200;
                     class52.field1142 = var10;
                     class171 var11 = class13.field200;
                     class47.field1071 = var11;
                     class18.method179(class13.field200);
                     class50.chatMessages = new ChatMessages();
                     FrameMap.method2354(class13.field200, field2092, MessageNode.field802);
                     class153.method3161(class13.field200, field2092);
                     class33.field742 = "Loaded config";
                     class33.field744 = 60;
                     Client.field306 = 80;
                  }
               } else if(Client.field306 != 80) {
                  if(Client.field306 == 90) {
                     if(!class59.field1254.method3284()) {
                        class33.field742 = "Loading textures - " + class59.field1254.method3376() + "%";
                        class33.field744 = 90;
                     } else {
                        TextureProvider var20 = new TextureProvider(class59.field1254, field2092, 20, 0.8D, Client.field282?64:128);
                        class94.method2164(var20);
                        class94.method2163(0.8D);
                        class33.field742 = "Loaded textures";
                        class33.field744 = 90;
                        Client.field306 = 110;
                     }
                  } else if(Client.field306 == 110) {
                     class161.field2639 = new class13();
                     Item.field699.method2918(class161.field2639, 10);
                     class33.field742 = "Loaded input handler";
                     class33.field744 = 94;
                     Client.field306 = 120;
                  } else if(Client.field306 == 120) {
                     if(!class158.field2343.method3351("huffman", "")) {
                        class33.field742 = "Loading wordpack - " + 0 + "%";
                        class33.field744 = 96;
                     } else {
                        class116 var14 = new class116(class158.field2343.method3297("huffman", ""));
                        class145.field2223 = var14;
                        class33.field742 = "Loaded wordpack";
                        class33.field744 = 96;
                        Client.field306 = 130;
                     }
                  } else if(Client.field306 == 130) {
                     if(!Buffer.field2060.method3284()) {
                        class33.field742 = "Loading interfaces - " + Buffer.field2060.method3376() * 4 / 5 + "%";
                        class33.field744 = 100;
                     } else if(!Client.field311.method3284()) {
                        class33.field742 = "Loading interfaces - " + (80 + Client.field311.method3376() / 6) + "%";
                        class33.field744 = 100;
                     } else if(!MessageNode.field802.method3284()) {
                        class33.field742 = "Loading interfaces - " + (96 + MessageNode.field802.method3376() / 20) + "%";
                        class33.field744 = 100;
                     } else {
                        class33.field742 = "Loaded interfaces";
                        class33.field744 = 100;
                        Client.field306 = 140;
                     }
                  } else if(Client.field306 == 140) {
                     setGameState(10);
                  }
               } else {
                  var0 = 0;
                  SpritePixels var15;
                  if(null == class157.field2325) {
                     var12 = field2092;
                     var3 = var12.method3327("compass");
                     var4 = var12.method3325(var3, "");
                     var15 = Client.method428(var12, var3, var4);
                     class157.field2325 = var15;
                  } else {
                     ++var0;
                  }

                  if(null == class28.field678) {
                     var12 = field2092;
                     var3 = var12.method3327("mapedge");
                     var4 = var12.method3325(var3, "");
                     var15 = Client.method428(var12, var3, var4);
                     class28.field678 = var15;
                  } else {
                     ++var0;
                  }

                  if(null == Ignore.field132) {
                     Ignore.field132 = class48.method984(field2092, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(MessageNode.field804 == null) {
                     MessageNode.field804 = Buffer.method2769(field2092, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == class0.field12) {
                     class0.field12 = Buffer.method2769(field2092, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class151.field2276) {
                     class151.field2276 = Buffer.method2769(field2092, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(XClanMember.field623 == null) {
                     XClanMember.field623 = Buffer.method2769(field2092, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == class31.field716) {
                     class31.field716 = Buffer.method2769(field2092, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == class140.field2179) {
                     class140.field2179 = Buffer.method2769(field2092, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class9.field152) {
                     class9.field152 = Buffer.method2769(field2092, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(DecorativeObject.field1666 == null) {
                     DecorativeObject.field1666 = class48.method984(field2092, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(Client.field358 == null) {
                     Client.field358 = class48.method984(field2092, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class33.field742 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class33.field744 = 70;
                  } else {
                     class226.modIcons = Client.field358;
                     class28.field678.method1785();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var2 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(int var5 = 0; var5 < MessageNode.field804.length; ++var5) {
                        MessageNode.field804[var5].method1740(var4 + var1, var2 + var4, var4 + var3);
                     }

                     Ignore.field132[0].method1913(var4 + var1, var2 + var4, var4 + var3);
                     class33.field742 = "Loaded sprites";
                     class33.field744 = 70;
                     Client.field306 = 90;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "532156639"
   )
   static char method2850(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }
}
