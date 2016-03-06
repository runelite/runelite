package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ec")
public final class class149 {
   @ObfuscatedName("i")
   public static boolean method3102(int var0) {
      if(class172.field2750[var0]) {
         return true;
      } else if(!class51.field1162.method3280(var0)) {
         return false;
      } else {
         int var1 = class51.field1162.method3224(var0);
         if(0 == var1) {
            class172.field2750[var0] = true;
            return true;
         } else {
            if(null == class172.field2757[var0]) {
               class172.field2757[var0] = new class172[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class172.field2757[var0][var2] == null) {
                  byte[] var3 = class51.field1162.method3214(var0, var2);
                  if(var3 != null) {
                     class172.field2757[var0][var2] = new class172();
                     class172.field2757[var0][var2].field2759 = (var2 + (var0 << 16)) * -1;
                     if(-1 == var3[0]) {
                        class172.field2757[var0][var2].method3390(new class118(var3));
                     } else {
                        class172.field2757[var0][var2].method3351(new class118(var3));
                     }
                  }
               }
            }

            class172.field2750[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("g")
   static void method3103() {
      int var0;
      if(0 == client.field403) {
         class107.field1906 = new class85(4, 104, 104, class5.field93);

         for(var0 = 0; var0 < 4; ++var0) {
            client.field346[var0] = new class107(104, 104);
         }

         class42.field1002 = new class78(512, 512);
         class31.field723 = "Starting game engine...";
         class31.field724 = 5;
         client.field403 = 20;
      } else {
         int var3;
         int var4;
         int var18;
         int var21;
         if(client.field403 == 20) {
            int[] var31 = new int[9];

            for(var18 = 0; var18 < 9; ++var18) {
               var21 = 128 + 32 * var18 + 15;
               var3 = 600 + var21 * 3;
               var4 = class90.field1587[var21];
               var31[var18] = var4 * var3 >> 16;
            }

            class85.method1910(var31, 500, 800, 512, 334);
            class31.field723 = "Prepared visibility map";
            class31.field724 = 10;
            client.field403 = 30;
         } else if(30 == client.field403) {
            class10.field168 = class51.method1074(0, false, true, true);
            class46.field1062 = class51.method1074(1, false, true, true);
            class115.field1978 = class51.method1074(2, true, false, true);
            class76.field1396 = class51.method1074(3, false, true, true);
            class31.field740 = class51.method1074(4, false, true, true);
            class24.field623 = class51.method1074(5, true, true, true);
            class137.field2139 = class51.method1074(6, true, true, false);
            class32.field757 = class51.method1074(7, false, true, true);
            class157.field2595 = class51.method1074(8, false, true, true);
            class108.field1915 = class51.method1074(9, false, true, true);
            class95.field1640 = class51.method1074(10, false, true, true);
            class97.field1669 = class51.method1074(11, false, true, true);
            class160.field2649 = class51.method1074(12, false, true, true);
            class182.field2958 = class51.method1074(13, true, false, true);
            class161.field2652 = class51.method1074(14, false, true, false);
            class0.field13 = class51.method1074(15, false, true, true);
            class31.field723 = "Connecting to update server";
            class31.field724 = 20;
            client.field403 = 40;
         } else if(40 == client.field403) {
            byte var30 = 0;
            var0 = var30 + class10.field168.method3287() * 4 / 100;
            var0 += class46.field1062.method3287() * 4 / 100;
            var0 += class115.field1978.method3287() * 2 / 100;
            var0 += class76.field1396.method3287() * 2 / 100;
            var0 += class31.field740.method3287() * 6 / 100;
            var0 += class24.field623.method3287() * 4 / 100;
            var0 += class137.field2139.method3287() * 2 / 100;
            var0 += class32.field757.method3287() * 60 / 100;
            var0 += class157.field2595.method3287() * 2 / 100;
            var0 += class108.field1915.method3287() * 2 / 100;
            var0 += class95.field1640.method3287() * 2 / 100;
            var0 += class97.field1669.method3287() * 2 / 100;
            var0 += class160.field2649.method3287() * 2 / 100;
            var0 += class182.field2958.method3287() * 2 / 100;
            var0 += class161.field2652.method3287() * 2 / 100;
            var0 += class0.field13.method3287() * 2 / 100;
            if(var0 != 100) {
               if(0 != var0) {
                  class31.field723 = "Checking for updates - " + var0 + "%";
               }

               class31.field724 = 30;
            } else {
               class31.field723 = "Loaded update list";
               class31.field724 = 30;
               client.field403 = 45;
            }
         } else if(client.field403 == 45) {
            boolean var29 = !client.field457;
            class102.field1780 = 22050;
            class56.field1191 = var29;
            class56.field1196 = 2;
            class183 var22 = new class183();
            var22.method3655(9, 128);
            class47.field1070 = class141.method2925(class26.field648, 0, 22050);
            class47.field1070.method1188(var22);
            class110.method2384(class0.field13, class161.field2652, class31.field740, var22);
            class77.field1403 = class141.method2925(class26.field648, 1, 2048);
            class17.field252 = new class55();
            class77.field1403.method1188(class17.field252);
            class24.field628 = new class74(22050, class102.field1780);
            class31.field723 = "Prepared sound engine";
            class31.field724 = 35;
            client.field403 = 50;
         } else {
            class167 var2;
            int var5;
            class167 var23;
            if(50 == client.field403) {
               var0 = 0;
               class223 var20;
               if(null == class0.field4) {
                  var2 = class157.field2595;
                  var23 = class182.field2958;
                  var4 = var2.method3248("p11_full");
                  var5 = var2.method3238(var4, "");
                  var20 = class75.method1631(var2, var23, var4, var5);
                  class0.field4 = var20;
               } else {
                  ++var0;
               }

               if(class29.field692 == null) {
                  var2 = class157.field2595;
                  var23 = class182.field2958;
                  var4 = var2.method3248("p12_full");
                  var5 = var2.method3238(var4, "");
                  var20 = class75.method1631(var2, var23, var4, var5);
                  class29.field692 = var20;
               } else {
                  ++var0;
               }

               if(null == class1.field28) {
                  var2 = class157.field2595;
                  var23 = class182.field2958;
                  var4 = var2.method3248("b12_full");
                  var5 = var2.method3238(var4, "");
                  var20 = class75.method1631(var2, var23, var4, var5);
                  class1.field28 = var20;
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class31.field723 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class31.field724 = 40;
               } else {
                  class98.field1693 = new class159(true);
                  class31.field723 = "Loaded fonts";
                  class31.field724 = 40;
                  client.field403 = 60;
               }
            } else {
               class167 var19;
               if(client.field403 == 60) {
                  var19 = class95.field1640;
                  var2 = class157.field2595;
                  var3 = 0;
                  if(var19.method3274("title.jpg", "")) {
                     ++var3;
                  }

                  if(var2.method3274("logo", "")) {
                     ++var3;
                  }

                  if(var2.method3274("logo_deadman_mode", "")) {
                     ++var3;
                  }

                  if(var2.method3274("titlebox", "")) {
                     ++var3;
                  }

                  if(var2.method3274("titlebutton", "")) {
                     ++var3;
                  }

                  if(var2.method3274("runes", "")) {
                     ++var3;
                  }

                  if(var2.method3274("title_mute", "")) {
                     ++var3;
                  }

                  if(var2.method3233("options_radio_buttons,0")) {
                     ++var3;
                  }

                  if(var2.method3233("options_radio_buttons,2")) {
                     ++var3;
                  }

                  var2.method3274("sl_back", "");
                  var2.method3274("sl_flags", "");
                  var2.method3274("sl_arrows", "");
                  var2.method3274("sl_stars", "");
                  var2.method3274("sl_button", "");
                  var4 = class148.method3100();
                  if(var3 < var4) {
                     class31.field723 = "Loading title screen - " + 100 * var3 / var4 + "%";
                     class31.field724 = 50;
                  } else {
                     class31.field723 = "Loaded title screen";
                     class31.field724 = 50;
                     client.method556(5);
                     client.field403 = 70;
                  }
               } else if(70 == client.field403) {
                  if(!class115.field1978.method3278()) {
                     class31.field723 = "Loading config - " + class115.field1978.method3295() + "%";
                     class31.field724 = 60;
                  } else {
                     class167 var28 = class115.field1978;
                     class46.field1058 = var28;
                     var19 = class115.field1978;
                     class41.field970 = var19;
                     var2 = class115.field1978;
                     var23 = class32.field757;
                     class44.field1030 = var2;
                     class44.field1024 = var23;
                     class44.field1032 = class44.field1030.method3224(3);
                     class167 var24 = class115.field1978;
                     class167 var25 = class32.field757;
                     boolean var6 = client.field457;
                     class40.field948 = var24;
                     class40.field940 = var25;
                     class40.field941 = var6;
                     class14.method163(class115.field1978, class32.field757);
                     class167 var7 = class115.field1978;
                     class167 var8 = class32.field757;
                     boolean var9 = client.field291;
                     class223 var10 = class0.field4;
                     class51.field1129 = var7;
                     class51.field1112 = var8;
                     class168.field2714 = var9;
                     class51.field1115 = class51.field1129.method3224(10);
                     class20.field580 = var10;
                     class167 var11 = class115.field1978;
                     class167 var12 = class10.field168;
                     class167 var13 = class46.field1062;
                     class42.field989 = var11;
                     class42.field1001 = var12;
                     class126.field2046 = var13;
                     class167 var14 = class115.field1978;
                     class167 var15 = class32.field757;
                     class43.field1016 = var14;
                     class43.field1007 = var15;
                     class167 var16 = class115.field1978;
                     class47.field1073 = var16;
                     class148.method3101(class115.field1978);
                     class77.method1665(class76.field1396, class32.field757, class157.field2595, class182.field2958);
                     class51.method1047(class115.field1978);
                     class31.method699(class115.field1978);
                     class76.method1648(class115.field1978);
                     class167 var17 = class115.field1978;
                     class49.field1088 = var17;
                     class3.field63 = new class19();
                     class31.field723 = "Loaded config";
                     class31.field724 = 60;
                     client.field403 = 80;
                  }
               } else if(80 != client.field403) {
                  if(client.field403 == 90) {
                     if(!class108.field1915.method3278()) {
                        class31.field723 = "Loading textures - " + class108.field1915.method3295() + "%";
                        class31.field724 = 90;
                     } else {
                        class94 var27 = new class94(class108.field1915, class157.field2595, 20, 0.8D, client.field457?64:128);
                        class90.method2097(var27);
                        class90.method2064(0.8D);
                        class31.field723 = "Loaded textures";
                        class31.field724 = 90;
                        client.field403 = 110;
                     }
                  } else if(110 == client.field403) {
                     class177.field2912 = new class13();
                     class26.field648.method2833(class177.field2912, 10);
                     class31.field723 = "Loaded input handler";
                     class31.field724 = 94;
                     client.field403 = 120;
                  } else if(120 == client.field403) {
                     if(!class95.field1640.method3274("huffman", "")) {
                        class31.field723 = "Loading wordpack - " + 0 + "%";
                        class31.field724 = 96;
                     } else {
                        class112 var26 = new class112(class95.field1640.method3261("huffman", ""));
                        class182.method3539(var26);
                        class31.field723 = "Loaded wordpack";
                        class31.field724 = 96;
                        client.field403 = 130;
                     }
                  } else if(client.field403 == 130) {
                     if(!class76.field1396.method3278()) {
                        class31.field723 = "Loading interfaces - " + class76.field1396.method3295() * 4 / 5 + "%";
                        class31.field724 = 100;
                     } else if(!class160.field2649.method3278()) {
                        class31.field723 = "Loading interfaces - " + (80 + class160.field2649.method3295() / 6) + "%";
                        class31.field724 = 100;
                     } else if(!class182.field2958.method3278()) {
                        class31.field723 = "Loading interfaces - " + (96 + class182.field2958.method3295() / 20) + "%";
                        class31.field724 = 100;
                     } else {
                        class31.field723 = "Loaded interfaces";
                        class31.field724 = 100;
                        client.field403 = 140;
                     }
                  } else if(client.field403 == 140) {
                     client.method556(10);
                  }
               } else {
                  var0 = 0;
                  class78 var1;
                  if(class0.field10 == null) {
                     var2 = class157.field2595;
                     var3 = var2.method3248("compass");
                     var4 = var2.method3238(var3, "");
                     var1 = class31.method689(var2, var3, var4);
                     class0.field10 = var1;
                  } else {
                     ++var0;
                  }

                  if(client.field494 == null) {
                     var2 = class157.field2595;
                     var3 = var2.method3248("mapedge");
                     var4 = var2.method3238(var3, "");
                     var1 = class31.method689(var2, var3, var4);
                     client.field494 = var1;
                  } else {
                     ++var0;
                  }

                  if(null == class23.field613) {
                     class23.field613 = class160.method3138(class157.field2595, "mapscene", "");
                  } else {
                     ++var0;
                  }

                  if(class40.field966 == null) {
                     class40.field966 = class129.method2761(class157.field2595, "mapfunction", "");
                  } else {
                     ++var0;
                  }

                  if(null == class18.field265) {
                     class18.field265 = class129.method2761(class157.field2595, "hitmarks", "");
                  } else {
                     ++var0;
                  }

                  if(null == class30.field695) {
                     class30.field695 = class129.method2761(class157.field2595, "headicons_pk", "");
                  } else {
                     ++var0;
                  }

                  if(null == class4.field74) {
                     class4.field74 = class129.method2761(class157.field2595, "headicons_prayer", "");
                  } else {
                     ++var0;
                  }

                  if(null == class74.field1378) {
                     class74.field1378 = class129.method2761(class157.field2595, "headicons_hint", "");
                  } else {
                     ++var0;
                  }

                  if(null == client.field364) {
                     client.field364 = class129.method2761(class157.field2595, "mapmarker", "");
                  } else {
                     ++var0;
                  }

                  if(null == client.field405) {
                     client.field405 = class129.method2761(class157.field2595, "cross", "");
                  } else {
                     ++var0;
                  }

                  if(null == class42.field1005) {
                     class42.field1005 = class129.method2761(class157.field2595, "mapdots", "");
                  } else {
                     ++var0;
                  }

                  if(null == class5.field104) {
                     class5.field104 = class160.method3138(class157.field2595, "scrollbar", "");
                  } else {
                     ++var0;
                  }

                  if(null == class217.field3159) {
                     class217.field3159 = class160.method3138(class157.field2595, "mod_icons", "");
                  } else {
                     ++var0;
                  }

                  if(var0 < 13) {
                     class31.field723 = "Loading sprites - " + var0 * 100 / 13 + "%";
                     class31.field724 = 70;
                  } else {
                     class222.field3178 = class217.field3159;
                     client.field494.method1727();
                     var18 = (int)(Math.random() * 21.0D) - 10;
                     var21 = (int)(Math.random() * 21.0D) - 10;
                     var3 = (int)(Math.random() * 21.0D) - 10;
                     var4 = (int)(Math.random() * 41.0D) - 20;

                     for(var5 = 0; var5 < class40.field966.length; ++var5) {
                        class40.field966[var5].method1755(var4 + var18, var21 + var4, var4 + var3);
                     }

                     class23.field613[0].method1830(var4 + var18, var21 + var4, var3 + var4);
                     class31.field723 = "Loaded sprites";
                     class31.field724 = 70;
                     client.field403 = 90;
                  }
               }
            }
         }
      }
   }
}
