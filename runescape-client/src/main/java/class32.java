import java.awt.Font;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class32 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1377572003
   )
   int field725;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1493284931
   )
   int field726;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1848860303
   )
   int field727;
   @ObfuscatedName("z")
   String field728;
   @ObfuscatedName("qh")
   static Font field731;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 137681039
   )
   int field734;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-649327026"
   )
   public static void method693(class170 var0) {
      Sequence.field1027 = var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "1518824822"
   )
   public static int method694(CharSequence var0, int var1) {
      return class145.method3020(var0, var1, true);
   }

   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "(LPlayer;IIII)V",
      garbageValue = "-321963345"
   )
   @Export("generateMenuActionsForPlayer")
   static final void generateMenuActionsForPlayer(Player var0, int var1, int var2, int var3) {
      if(WidgetNode.localPlayer != var0) {
         if(Client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.field38 == 0) {
               String var5 = var0.actions[0] + var0.name + var0.actions[1];
               var7 = var0.combatLevel;
               int var8 = WidgetNode.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class153.method3186(16711680);
               } else if(var9 < -6) {
                  var6 = class153.method3186(16723968);
               } else if(var9 < -3) {
                  var6 = class153.method3186(16740352);
               } else if(var9 < 0) {
                  var6 = class153.method3186(16756736);
               } else if(var9 > 9) {
                  var6 = class153.method3186('\uff00');
               } else if(var9 > 6) {
                  var6 = class153.method3186(4259584);
               } else if(var9 > 3) {
                  var6 = class153.method3186(8453888);
               } else if(var9 > 0) {
                  var6 = class153.method3186(12648192);
               } else {
                  var6 = class153.method3186(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
            } else {
               var4 = var0.actions[0] + var0.name + var0.actions[1] + " " + " (" + "skill-" + var0.field38 + ")" + var0.actions[2];
            }

            int var10;
            if(Client.field524 == 1) {
               Ignore.addMenuEntry("Use", Client.field529 + " " + "->" + " " + class153.method3186(16777215) + var4, 14, var1, var2, var3);
            } else if(Client.field435) {
               if((class50.field1116 & 8) == 8) {
                  Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + class153.method3186(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(null != Client.field409[var10]) {
                     short var11 = 0;
                     if(Client.field409[var10].equalsIgnoreCase("Attack")) {
                        if(Client.field306 == class21.field581) {
                           continue;
                        }

                        if(Client.field306 == class21.field578 || class21.field587 == Client.field306 && var0.combatLevel > WidgetNode.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(WidgetNode.localPlayer.team != 0 && var0.team != 0) {
                           if(WidgetNode.localPlayer.team == var0.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(Client.field514[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = Client.field546[var10] + var11;
                     Ignore.addMenuEntry(Client.field409[var10], class153.method3186(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < Client.menuOptionCount; ++var10) {
               if(Client.menuTypes[var10] == 23) {
                  Client.menuTargets[var10] = class153.method3186(16777215) + var4;
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "27"
   )
   static void method696() {
      int var0;
      if(Client.field308 == 0) {
         class16.region = new Region(4, 104, 104, class5.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         TextureProvider.field1712 = new SpritePixels(512, 512);
         class33.field751 = "Starting game engine...";
         class33.field750 = 5;
         Client.field308 = 20;
      } else {
         int var1;
         int var3;
         int var4;
         int var12;
         if(Client.field308 == 20) {
            int[] var26 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var12 = var1 * 32 + 128 + 15;
               var3 = var12 * 3 + 600;
               var4 = class94.field1670[var12];
               var26[var1] = var3 * var4 >> 16;
            }

            Region.method2102(var26, 500, 800, 512, 334);
            class33.field751 = "Prepared visibility map";
            class33.field750 = 10;
            Client.field308 = 30;
         } else if(Client.field308 == 30) {
            class144.field2240 = class51.method1087(0, false, true, true);
            class50.field1121 = class51.method1087(1, false, true, true);
            class166.field2718 = class51.method1087(2, true, false, true);
            class35.field796 = class51.method1087(3, false, true, true);
            class47.field1065 = class51.method1087(4, false, true, true);
            class1.field18 = class51.method1087(5, true, true, true);
            class8.field140 = class51.method1087(6, true, true, false);
            class9.field147 = class51.method1087(7, false, true, true);
            ItemComposition.field1230 = class51.method1087(8, false, true, true);
            class128.field2118 = class51.method1087(9, false, true, true);
            Client.field311 = class51.method1087(10, false, true, true);
            class85.field1506 = class51.method1087(11, false, true, true);
            class190.field3083 = class51.method1087(12, false, true, true);
            class53.field1156 = class51.method1087(13, true, false, true);
            Client.field312 = class51.method1087(14, false, true, false);
            class113.field1993 = class51.method1087(15, false, true, true);
            class33.field751 = "Connecting to update server";
            class33.field750 = 20;
            Client.field308 = 40;
         } else if(Client.field308 == 40) {
            byte var22 = 0;
            var0 = var22 + class144.field2240.method3383() * 4 / 100;
            var0 += class50.field1121.method3383() * 4 / 100;
            var0 += class166.field2718.method3383() * 2 / 100;
            var0 += class35.field796.method3383() * 2 / 100;
            var0 += class47.field1065.method3383() * 6 / 100;
            var0 += class1.field18.method3383() * 4 / 100;
            var0 += class8.field140.method3383() * 2 / 100;
            var0 += class9.field147.method3383() * 60 / 100;
            var0 += ItemComposition.field1230.method3383() * 2 / 100;
            var0 += class128.field2118.method3383() * 2 / 100;
            var0 += Client.field311.method3383() * 2 / 100;
            var0 += class85.field1506.method3383() * 2 / 100;
            var0 += class190.field3083.method3383() * 2 / 100;
            var0 += class53.field1156.method3383() * 2 / 100;
            var0 += Client.field312.method3383() * 2 / 100;
            var0 += class113.field1993.method3383() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class33.field751 = "Checking for updates - " + var0 + "%";
               }

               class33.field750 = 30;
            } else {
               class33.field751 = "Loaded update list";
               class33.field750 = 30;
               Client.field308 = 45;
            }
         } else if(Client.field308 == 45) {
            class16.method184(22050, !Client.field285, 2);
            class187 var25 = new class187();
            var25.method3638(9, 128);
            Projectile.field101 = Sequence.method931(class126.field2103, class79.canvas, 0, 22050);
            Projectile.field101.method1243(var25);
            class155.method3193(class113.field1993, Client.field312, class47.field1065, var25);
            class13.field192 = Sequence.method931(class126.field2103, class79.canvas, 1, 2048);
            GameObject.field1759 = new class58();
            class13.field192.method1243(GameObject.field1759);
            class53.field1160 = new class77(22050, class59.field1265);
            class33.field751 = "Prepared sound engine";
            class33.field750 = 35;
            Client.field308 = 50;
         } else {
            class171 var2;
            int var5;
            class171 var14;
            if(Client.field308 == 50) {
               var0 = 0;
               class227 var18;
               class227 var19;
               byte[] var20;
               class227 var21;
               if(null == Client.field335) {
                  var2 = ItemComposition.field1230;
                  var14 = class53.field1156;
                  var4 = var2.method3324("p11_full");
                  var5 = var2.method3313(var4, "");
                  if(!class126.method2817(var2, var4, var5)) {
                     var18 = null;
                  } else {
                     var20 = var14.method3309(var4, var5);
                     if(var20 == null) {
                        var19 = null;
                     } else {
                        var21 = new class227(var20, class79.field1462, class79.field1458, class59.field1268, class79.field1461, class132.field2126, class8.field139);
                        class35.method747();
                        var19 = var21;
                     }

                     var18 = var19;
                  }

                  Client.field335 = var18;
               } else {
                  ++var0;
               }

               if(null == class0.field14) {
                  var2 = ItemComposition.field1230;
                  var14 = class53.field1156;
                  var4 = var2.method3324("p12_full");
                  var5 = var2.method3313(var4, "");
                  if(!class126.method2817(var2, var4, var5)) {
                     var18 = null;
                  } else {
                     var20 = var14.method3309(var4, var5);
                     if(null == var20) {
                        var19 = null;
                     } else {
                        var21 = new class227(var20, class79.field1462, class79.field1458, class59.field1268, class79.field1461, class132.field2126, class8.field139);
                        class35.method747();
                        var19 = var21;
                     }

                     var18 = var19;
                  }

                  class0.field14 = var18;
               } else {
                  ++var0;
               }

               if(Frames.field1850 == null) {
                  var2 = ItemComposition.field1230;
                  var14 = class53.field1156;
                  var4 = var2.method3324("b12_full");
                  var5 = var2.method3313(var4, "");
                  if(!class126.method2817(var2, var4, var5)) {
                     var18 = null;
                  } else {
                     var20 = var14.method3309(var4, var5);
                     if(var20 == null) {
                        var19 = null;
                     } else {
                        var21 = new class227(var20, class79.field1462, class79.field1458, class59.field1268, class79.field1461, class132.field2126, class8.field139);
                        class35.method747();
                        var19 = var21;
                     }

                     var18 = var19;
                  }

                  Frames.field1850 = var18;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class33.field751 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class33.field750 = 40;
               } else {
                  class155.field2338 = new class163(true);
                  class33.field751 = "Loaded fonts";
                  class33.field750 = 40;
                  Client.field308 = 60;
               }
            } else {
               class171 var13;
               if(Client.field308 == 60) {
                  var13 = Client.field311;
                  var2 = ItemComposition.field1230;
                  var3 = 0;
                  if(var13.method3327("title.jpg", "")) {
                     ++var3;
                  }

                  if(var2.method3327("logo", "")) {
                     ++var3;
                  }

                  if(var2.method3327("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var2.method3327("titlebox", "")) {
                     ++var3;
                  }

                  if(var2.method3327("titlebutton", "")) {
                     ++var3;
                  }

                  if(var2.method3327("runes", "")) {
                     ++var3;
                  }

                  if(var2.method3327("title_mute", "")) {
                     ++var3;
                  }

                  if(var2.method3365("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var2.method3365("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var2.method3327("sl_back", "");
                  var2.method3327("sl_flags", "");
                  var2.method3327("sl_arrows", "");
                  var2.method3327("sl_stars", "");
                  var2.method3327("sl_button", "");
                  byte var17 = 9;
                  if(var3 < var17) {
                     class33.field751 = "Loading title screen - " + var3 * 100 / var17 + "%";
                     class33.field750 = 50;
                  } else {
                     class33.field751 = "Loaded title screen";
                     class33.field750 = 50;
                     XItemContainer.setGameState(5);
                     Client.field308 = 70;
                  }
               } else if(Client.field308 == 70) {
                  if(!class166.field2718.method3353()) {
                     class33.field751 = "Loading config - " + class166.field2718.method3390() + "%";
                     class33.field750 = 60;
                  } else {
                     class8.method123(class166.field2718);
                     class171 var24 = class166.field2718;
                     class43.field1008 = var24;
                     var13 = class166.field2718;
                     var2 = class9.field147;
                     KitDefinition.field1059 = var13;
                     KitDefinition.field1049 = var2;
                     KitDefinition.field1050 = KitDefinition.field1059.method3319(3);
                     class26.method617(class166.field2718, class9.field147, Client.field285);
                     var14 = class166.field2718;
                     class171 var15 = class9.field147;
                     NPCComposition.field922 = var14;
                     class145.field2245 = var15;
                     class1.method4(class166.field2718, class9.field147, Client.isMembers, Client.field335);
                     class171 var16 = class166.field2718;
                     class171 var6 = class144.field2240;
                     class171 var7 = class50.field1121;
                     class212.field3174 = var16;
                     Sequence.field1023 = var6;
                     Sequence.field1025 = var7;
                     class117.method2465(class166.field2718, class9.field147);
                     method693(class166.field2718);
                     class171 var8 = class166.field2718;
                     class56.field1233 = var8;
                     class56.field1234 = class56.field1233.method3319(16);
                     class79.method1712(class35.field796, class9.field147, ItemComposition.field1230, class53.field1156);
                     class171 var9 = class166.field2718;
                     class54.field1175 = var9;
                     class171 var10 = class166.field2718;
                     class52.field1146 = var10;
                     class50.method1033(class166.field2718);
                     class79.method1709(class166.field2718);
                     Friend.chatMessages = new ChatMessages();
                     class31.method692(class166.field2718, ItemComposition.field1230, class53.field1156);
                     class13.method169(class166.field2718, ItemComposition.field1230);
                     class33.field751 = "Loaded config";
                     class33.field750 = 60;
                     Client.field308 = 80;
                  }
               } else if(Client.field308 != 80) {
                  if(Client.field308 == 90) {
                     if(!class128.field2118.method3353()) {
                        class33.field751 = "Loading textures - " + class128.field2118.method3390() + "%";
                        class33.field750 = 90;
                     } else {
                        TextureProvider var23 = new TextureProvider(class128.field2118, ItemComposition.field1230, 20, 0.8D, Client.field285?64:128);
                        class94.method2122(var23);
                        class94.method2162(0.8D);
                        class33.field751 = "Loaded textures";
                        class33.field750 = 90;
                        Client.field308 = 110;
                     }
                  } else if(Client.field308 == 110) {
                     class165.field2714 = new class13();
                     class126.field2103.method2934(class165.field2714, 10);
                     class33.field751 = "Loaded input handler";
                     class33.field750 = 94;
                     Client.field308 = 120;
                  } else if(Client.field308 == 120) {
                     if(!Client.field311.method3327("huffman", "")) {
                        class33.field751 = "Loading wordpack - " + 0 + "%";
                        class33.field750 = 96;
                     } else {
                        class116 var11 = new class116(Client.field311.method3326("huffman", ""));
                        class225.field3229 = var11;
                        class33.field751 = "Loaded wordpack";
                        class33.field750 = 96;
                        Client.field308 = 130;
                     }
                  } else if(Client.field308 == 130) {
                     if(!class35.field796.method3353()) {
                        class33.field751 = "Loading interfaces - " + class35.field796.method3390() * 4 / 5 + "%";
                        class33.field750 = 100;
                     } else if(!class190.field3083.method3353()) {
                        class33.field751 = "Loading interfaces - " + (80 + class190.field3083.method3390() / 6) + "%";
                        class33.field750 = 100;
                     } else if(!class53.field1156.method3353()) {
                        class33.field751 = "Loading interfaces - " + (96 + class53.field1156.method3390() / 20) + "%";
                        class33.field750 = 100;
                     } else {
                        class33.field751 = "Loaded interfaces";
                        class33.field750 = 100;
                        Client.field308 = 140;
                     }
                  } else if(Client.field308 == 140) {
                     XItemContainer.setGameState(10);
                  }
               } else {
                  var0 = 0;
                  if(Frames.field1853 == null) {
                     Frames.field1853 = NPCComposition.method808(ItemComposition.field1230, "compass", "");
                  } else {
                     ++var0;
                  }

                  if(null == NPC.field811) {
                     NPC.field811 = NPCComposition.method808(ItemComposition.field1230, "mapedge", "");
                  } else {
                     ++var0;
                  }

                  if(class18.field257 == null) {
                     class18.field257 = class119.method2474(ItemComposition.field1230, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class14.field209 == null) {
                     class14.field209 = XClanMember.method605(ItemComposition.field1230, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == class107.field1866) {
                     class107.field1866 = XClanMember.method605(ItemComposition.field1230, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(class13.field195 == null) {
                     class13.field195 = XClanMember.method605(ItemComposition.field1230, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(class139.field2167 == null) {
                     class139.field2167 = XClanMember.method605(ItemComposition.field1230, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(class164.field2709 == null) {
                     class164.field2709 = XClanMember.method605(ItemComposition.field1230, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == Client.field276) {
                     Client.field276 = XClanMember.method605(ItemComposition.field1230, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == Client.field449) {
                     Client.field449 = XClanMember.method605(ItemComposition.field1230, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(class113.field2023 == null) {
                     class113.field2023 = class119.method2474(ItemComposition.field1230, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(class13.field194 == null) {
                     class13.field194 = class119.method2474(ItemComposition.field1230, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 12) {
                     class33.field751 = "Loading sprites - " + var0 * 100 / 12 + "%";
                     class33.field750 = 70;
                  } else {
                     class226.modIcons = class13.field194;
                     NPC.field811.method1804();
                     var1 = (int)(Math.random() * 21.0D) - 10;
                     var12 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class14.field209.length; ++var5) {
                        class14.field209[var5].method1737(var4 + var1, var12 + var4, var3 + var4);
                     }

                     class18.field257[0].method1902(var4 + var1, var4 + var12, var3 + var4);
                     class33.field751 = "Loaded sprites";
                     class33.field750 = 70;
                     Client.field308 = 90;
                  }
               }
            }
         }
      }
   }
}
